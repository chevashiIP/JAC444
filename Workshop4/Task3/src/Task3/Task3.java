package Task3;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {
	public void phonechange() {
		Scanner input = new Scanner(System.in);
		boolean correct = false;
		int number = 0;
		System.out.print("Enter the phone number: ");
		while(!correct) {
			try {
				do {
					number = input.nextInt();
					if(size(number) < 7 || size(number) > 7) {
						System.out.print("Incorrect length of the number. Re-Enter the phone number: ");
					}
				} while(size(number) < 7 || size(number) > 7);
				correct = true;
			} catch(InputMismatchException e) {
				System.out.print("Incorrect input. Re-Enter the phone number: ");
				input.next();
			}
		}
		System.out.print("Phone is correct");
		
		
	}

	public static int size(int number){
		String num = number + "";
		return num.length();
	}
}