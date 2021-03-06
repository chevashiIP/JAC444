import java.util.Scanner;
import java.text.DecimalFormat;

public class Task3 {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args){
		DecimalFormat df = new DecimalFormat("###.##");
		System.out.print("Loan ammount: ");
		double loan = input.nextInt();
		
		System.out.print("Number of Years: ");
		int years = input.nextInt();
		
		System.out.print("Annual Interest Rate: ");
		double interestrate = input.nextInt();
		
		double monthlyRate = interestrate / 1200;
		
		double monthlyPayment = loan * monthlyRate / (1 - 1 / Math.pow(1 + monthlyRate, years * 12));
		
		System.out.println("Montly Payment: " + df.format(monthlyPayment));
		
		System.out.println("Total Payment: " + df.format((monthlyPayment * 12) * years));
		
		double balance = loan, interest, principal;
		
		System.out.println("Payment#" + "\t" + "Interest" + "\t" + "Principal" + "\t" + "Balance");
		for(int i = 1; i <= years * 12; i++) {
			interest = monthlyRate * balance;
			principal = monthlyPayment - interest;
			balance = balance - principal;
			System.out.println(i + "\t\t" + df.format(interest) + "\t\t" + df.format(principal) + "\t\t" + df.format(balance));
		}
	}
}
