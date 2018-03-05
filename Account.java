import java.util.Scanner;

public class Account {
	private double opcao;
	private String name;
    private int number, withdrawals;
    protected static double balance;
    Scanner input = new Scanner(System.in);
    
    public Account(String name, int i, double j) {
		// TODO Auto-generated constructor stub
    	this.setName(name);
    	this.number = i;
    	balance = j;
    	withdrawals = 0;
	}

	public void Contact(String name, int number, double initialBalance){
        this.setName(name);
        this.number=number;
        balance=initialBalance;
        withdrawals=0;
    }
    
    public void bankStatement(){
        System.out.println("\tBank Statement");
        System.out.println("Name: " + this.getName());
        System.out.println("Account number: " + this.number);
        System.out.printf("Balance: %.2f\n",this.balance);
        System.out.println("Withdrawals made: " + this.withdrawals + "\n");
        
    }
    
    public void withdrawCash(double value){
        if(balance >= value){
            balance -= value;
            withdrawals++;
            System.out.println("Cash value out: " + value);
            System.out.println("New balance: " + balance + "\n");
        } else {
            System.out.println("Not enough balance amount. Deposit some value.\n");
        }
    }
    
    public void depositCash(double value)
    {
        balance += value;
        System.out.println("Deposit: " + value);
        System.out.println("New balance: " + balance + "\n");
    }
    
    public void start(){
        int option;

        do{
            showMenu();
            option = input.nextInt();
            chooseOption(option);
        }while(option!=4);
    }
    
    public void showMenu(){
        
        System.out.println("\t Choose the right option");
        System.out.println("1 - Check bank statement");
        System.out.println("2 - Cash out");
        System.out.println("3 - Deposit");
        System.out.println("4 - Exit\n");
        System.out.print("Option: ");
        
    }
    
    public void chooseOption(int option){
        double value;
        
        
        switch( option ){
            case 1:    
                    bankStatement();
                    option = 1;
                    break;
            case 2: 
                    if(withdrawals<3){
                        System.out.print("How much do you want cash out: ");
                        value = input.nextDouble();
                        withdrawCash(value);
                    } else{
                        System.out.println("Withdrawals dayly limit reached.\n");
                    }
                    option = 2;
                    break;
                    
            case 3:
                    System.out.print("How much do you want deposit: ");
                    value = input.nextDouble();
                    depositCash(value);
                    option = 3;
                    break;
                    
            case 4: 
                    System.out.println("Closed system.");
                    option = 4;
                    break;
                    
            default:
                    System.out.println("Invalid option");
        }
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
