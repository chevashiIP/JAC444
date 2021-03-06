import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
	public static void main(String[] args) {
		System.out.print("Enter the first complex number: ");
		Complex Number1 = getNum();
		System.out.print("Enter the second complex number: ");
		Complex Number2 = getNum();
		
		System.out.println(Number1 + " + " + Number2 + " = " + Number1.add(Number2));
		
		System.out.println(Number1 + " - " + Number2 + " = " + Number1.subtract(Number2));
		
		System.out.println(Number1 + " * " + Number2 + " = " + Number1.multiply(Number2));

		System.out.println(Number1 + " / " + Number2 + " = " + Number1.divide(Number2));

		System.out.println("|" + Number1 + "| = " + Number1.abs());
	}
	
	public static Complex getNum() {
		Scanner input = new Scanner(System.in);
		boolean correct = false;
		double[] c = new double[2];
		while(!correct) {
		try {
			for (int i = 0; i < c.length; i++) {
					c[i] = input.nextDouble(); 
			}
			correct = true;
		} catch (InputMismatchException e) {
			System.out.print("Re-Enter the first complex number: ");
			input.next();
		}
		}
		return new Complex(c[0], c[1]); 
	}
}
