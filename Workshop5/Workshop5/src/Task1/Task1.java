package Task1;

import java.io.*;


public class Task1 {
	public void createacc() {
		Account[] account = new Account[10];
		
		for(int i = 0; i < account.length; i++) {
			account[i] = new Account(i+1, i+1234, 100);
		}
		
		PrintStream printToFile;
		FileOutputStream output = null;
		
		try {
            output = new FileOutputStream ("account.dat");
		} catch ( IOException ioEcception ){
			System.err.println( "Error opening file.");
		}
		
		printToFile = new PrintStream(output);
		
		for(int j = 0; j < account.length; j++) {
			printToFile.println(account[j].getId() + " " + account[j].getPIN() + " " + account[j].getBalance());
		}
		
		try {
            if ( output != null )
                output.close();
        } catch (IOException ioException ){
            System.err.println( "Error closing file.");
            System.exit(1);
        }
	}
}

class Account{
	private int pin = 0;
	private int id = 0;
	String Fname;
	String Lname;
	private double balance = 0.0;
	private static double annualInterestRate = 0.0;
	private java.util.Date dateCreated;
	
	public Account() {
        dateCreated = new java.util.Date();
    }
	
	public Account(int id, int pin, double balance) {
        this();
        this.pin = pin;
        this.id = id;
        this.balance = balance;
    }
	public int getPIN() {
		return this.pin;
	}
	public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    
    public String getDateCreated() {
        return this.dateCreated.toString();
    }
    
    public double getMonthlyInterestRate() {
        return (annualInterestRate / 100) / 12 ;
    }

    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }
    
    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
