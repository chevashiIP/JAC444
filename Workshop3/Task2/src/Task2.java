import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Task2 {
	static double[][][] Banks;
	static final int ID = 0;
    static final int LOAN = 1;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		boolean correct = false;
		boolean correct1 = false;
		boolean correct2 = false;
		int n = 0;
		int limit = 0;
		
		while(!correct) {
			try {
				System.out.print("Number of Banks: ");
				n = input.nextInt();
				correct = true;
			} catch(InputMismatchException e) {
				System.out.println("Wrong number of Banks");
				input.next();
			}
		}
		
		while(!correct1) {
			try {
				System.out.print("minimum asset limit: ");
				limit = input.nextInt();
				correct1 = true;
			} catch(InputMismatchException e) {
				System.out.print("Wrong number of limit");
				input.next();
			}
		}
		
		Banks = new double[n][][];
		
		System.out.println("Example:");
        System.out.println("Bank # 0 -> Balance: 25 -> Number of Banks Loaned: 2 -> Bank ID: 1 -> Amount: 100.5 -> Bank ID: 4 -> Amount: 320.5");
        
        while(!correct2) {
        	try {
        		for (int i = 0; i < Banks.length; i++) {
        			System.out.print("Bank #"+ i +" -> Balance: ");
        			double balance = input.nextDouble();
        			System.out.print("Numbers of Banks Loaned: ");
        			int Loanedbanks = input.nextInt();
        	
        			Banks[i] = new double[++Loanedbanks][2];
        			Banks[i][0][0] = balance;
        	
        			for (int j = 1; j < Banks[i].length; j++) {
        				System.out.print("Bank ID: ");
        				Banks[i][j][ID] = input.nextInt();
        				System.out.print("Ammount: ");
        				Banks[i][j][LOAN] = input.nextDouble();
        			}
        			correct2 = true;
        		}
        	} catch (InputMismatchException e) {
        		correct2 = false;
        		System.out.println("Wrong Input, start over");
        		input.next();
        	}
        }
		
		displayBank(Banks);
		boolean[] unsafeIndex = scanBanks(Banks, limit);
      
		System.out.print("The unsafe banks are: ");
		for (int i = 0; i < unsafeIndex.length; i++) {
			if(unsafeIndex[i]) {
				System.out.print(i + " ");
			}
		}
	}
	 public static void displayBank(double[][][] bankarr) {
		 	DecimalFormat df = new DecimalFormat("###");
	        for (int banks = 0; banks < bankarr.length; banks++) {
	        	System.out.print("Bank #"+ banks +" -> Balance: " + bankarr[banks][0][0] + " -> Number of Banks Loaned: ");
	        	System.out.print(bankarr[banks].length -1);

	            for (int Loanedbanks = 1; Loanedbanks < bankarr[banks].length; Loanedbanks++) {
	            	System.out.print(" Bank ID: " + df.format(bankarr[banks][Loanedbanks][ID]) + " -> Amount: " + bankarr[banks][Loanedbanks][LOAN]);
	            }
	            System.out.println("");
	        }
	 }
	 
	 public static boolean[] scanBanks(double[][][] bankarr, int limit) {
		 boolean[] UnsafeBanks = new boolean[bankarr.length];
		 boolean isSafe = false;
		 double assettotal;
		 
		 while(!isSafe) {
			 isSafe = true;
			 
			 for(int banks = 0; banks < bankarr.length; banks++) {
				 assettotal = bankarr[banks][0][0];
				 for(int loanbank = 1; loanbank < bankarr[banks].length; loanbank++) {
					 int index = (int)bankarr[banks][loanbank][ID];
					 if(!UnsafeBanks[index]) {
						 assettotal += bankarr[banks][loanbank][LOAN];
					 }
				 }
				 if(assettotal < limit && !UnsafeBanks[banks]) {
					 UnsafeBanks[banks] = true;
					 isSafe = false;
				 }
			 }
		 }
		 
		 return UnsafeBanks;
	 }
}
