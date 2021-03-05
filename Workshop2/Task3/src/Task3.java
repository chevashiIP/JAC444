import java.util.InputMismatchException;
import java.util.Scanner;
public class Task3 {
	public static void main(String[] args){
		long creditnum = 0;
		boolean correct = false;
		//Prompts user to enter a credit card number, validates if credit card number is right(not longer or shorter) and validates the correct format of input.
		System.out.println("Enter a credit card number as a long integer: ");
		while(!correct) {
			Scanner input = new Scanner(System.in);
			try {
				do {
					creditnum = input.nextLong();
					if(size(creditnum) < 13 || size(creditnum) > 16) {
						System.out.println("Incorrect input. Enter a new credit card number: ");
					}
				} while(size(creditnum) < 13 || size(creditnum) > 16);
				correct = true;
			} catch(InputMismatchException e) {
				System.out.print("Incorrect format. Enter a credit card number: ");
				input.next();
			}
		}
		System.out.println(creditnum + " is " + (isValid(creditnum) ? "valid" : "invalid"));
		
	}
	//Checks if the credit card number is valid, by following criteria: 
	//1)Amount of digits in the credit card number 
	//2)Prefix of Visa(4) Mastercard(5) American express cards(37) Discover cards(6)
	//3)Sum of even and odd numbers that are devisible by 10
	public static boolean isValid(long number) {
		boolean valid = (size(number) >= 13 && size(number) <= 16) &&
				(prefixmatch(number, 4) || prefixmatch(number, 5) ||
				prefixmatch(number, 37) || prefixmatch(number, 6)) &&
				((sumofeven(number) + sumofodd(number)) % 10 == 0);
			return valid;
	}
	//Method sums the numbers of even numbers in credit card number
	public static int sumofeven(long number){
		int sum = 0;
		String num = number + "";
		for (int i = size(number) - 2; i >= 0; i -= 2) {
			sum += singledig(Integer.parseInt(num.charAt(i) + "") * 2);
		}
		return sum;
	}
	//Method returns single digit, if it's double digit number method returns sum of two digits of the number
	public static int singledig(int number){
		if (number < 9){
			return number;
		}else{
			return number / 10 + number % 10;
		}
	}
	//Method sums the numbers of odd numbers in credit card number
	public static int sumofodd(long number){
		int sum = 0;
		String num = number + "";
		for (int i = size(number) - 1; i >= 0; i -= 2) {
			sum += Integer.parseInt(num.charAt(i) + "");
		}
		return sum;
	}
	//Returns boolean depending if the digit is a prefix
	public static boolean prefixmatch(long number, int j){
		return prefix(number, size(j)) == j;
	}
	//Returns the ammount of digits in credit card number
	public static int size(long number){
		String num = number + "";
		return num.length();
	}
	//Returns the first k number of digits if the number of digits is less than k, return number;
	public static long prefix(long number, int k){
		if (size(number) > k)  {
			String num = number + "";
			return  Long.parseLong(num.substring(0, k));
		}
		return number;
	}
}
