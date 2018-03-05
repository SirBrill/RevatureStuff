import java.util.Random;
import java.util.Scanner;

public class BankTest {

	public static void main(String[] args) {
	// Declaring variables, Scanner and Random objects
    String name;
    double initial;
    Scanner input = new Scanner(System.in);
    Random randNumber = new Random();
    int number = 1 + randNumber.nextInt(9999);

    //Getting the initial values
    System.out.println("Registering a new user.");
    System.out.print("Type your name: ");
    
    name = input.nextLine();
    
    System.out.print("Enter the initial amount of this account: ");
    initial = input.nextDouble();
    
    //Creating the new account
    Account myAccount = new Account(name, 1, initial);
    myAccount.start();
    
	}
}
