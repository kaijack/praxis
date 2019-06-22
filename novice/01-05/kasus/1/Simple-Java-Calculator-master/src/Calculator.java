import java.util.Scanner; //scanner class to take input from the user

public class Calculator {

	private static Scanner scanner;

	public static void main(String[] args) {
		while (true) //loop to run the calculator continuously
		{
			scanner = new Scanner(System.in); //for the input from user
			System.out.println("Select from the following choices-"); 
			System.out.println("1 for Addition");
			System.out.println("2 for Subtraction");
			System.out.println("3 for Multiplication");
			System.out.println("4 for Division");
			System.out.println("5 for Power");
			System.out.println("6 for Modulo");
			System.out.println("0 for EXIT\n");
			System.out.println("Enter your choice:");
			int choice = scanner.nextInt(); //take the choice as an input from user

			/*
			 * if (choice==0) System.out.println("EXIT"); System.exit(0);
			 */
			if (choice >= 1 && choice <= 6) {
				System.out.println("Enter the first number:");
				double operand1 = scanner.nextInt(); //take first number as an input
				System.out.println("Enter the second number:");
				double operand2 = scanner.nextInt(); //take second number as an input
				double output = 0; //initialise an output variable

				switch (choice) {    //switch statement for the operator check
				case 1:
					output = operand1 + operand2;
					break;

				case 2:
					output = operand1 - operand2;
					break;

				case 3:
					output = operand1 * operand2;
					break;

				case 4:
					output = operand1 / operand2;
					break;

				case 5:
					output = Math.pow(operand1, operand2);
					break;

				case 6:
					output = operand1 % operand2;
					break;

				/*case 0:
					System.out.println("Safe Exit");
					System.exit(0);
					break;*/

				/*
				 * default:
				 * System.out.println("You have entered incorrect operation");
				 */

				}

				System.out.println("Output result=" + output);
			} else { //else it will check the operator either to exit or show error message
				if (choice == 0) {
					System.out.println("EXIT");
					System.exit(0); //exit the program if entered 0
				} else {
					System.out.println("You have entered wrong choice"); //print wrong choice and continue the program in loop
				}
			}
		}
	}
}
