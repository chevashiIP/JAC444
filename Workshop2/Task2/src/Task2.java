import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
	public static void main(String[] args){
		int row = 0;
		int column = 0;
		boolean correct = false;
		
		//Prompts user to enter row and columns for array, validating if it's an right format
		System.out.print("Enter the number of rows and columns in the array: ");
		while(!correct) {
			try {
				Scanner input = new Scanner(System.in);
				row = input.nextInt();
				column = input.nextInt();
				correct = true;
			} catch(InputMismatchException e) {
				System.out.print("Incorrect format. Enter the rows and columns:");
			}
		}
		
		//Creates array based on row and columns entered and prompts user to enter elements into it. Validating the entry of numbers in case user enters character instead of double
		double[][] array = new double[row][column];
		System.out.println("Enter the array: ");
		for(int i = 0; i < array.length; i++) {
			Scanner kk = new Scanner(System.in);
			for(int j = 0; j < array[i].length; j++) {
				try {
					array[i][j] = kk.nextDouble();
				} catch (InputMismatchException e) {
					System.out.println("Incorrect format, Enter new array: ");
					kk.next();
				}
			}
		}
		//Creating instance of Location and calling method LocateLargest to determine the location of the highest value in the array
		Location a = locateLargest(array);
		//Printing out the result
		System.out.print("The location of the largest element is " + a.highValue + " at row "+a.row+" and column "+a.column);
	}
	
	//This method returns a location of the highest element in array as well as highest value in it
	public static Location locateLargest(double[][] a) {
        double high = a[0][0];
        int numrows = 0, numcolums = 0;
        for (int i=0; i < a.length; i++){
            for (int j=0; j < a[i].length; j++){
                if (a[i][j] > high) {
                	high = a[i][j];
                    numrows=i;
                    numcolums=j;
                }
            }
        }
        return new Location(numrows,numcolums,high);
	}
}
//Location class with overloaded constructor;
class Location{
	public int row,column;
	public double highValue;
	Location(){
		
	}
	Location(int m_row, int m_column, double m_highValue){
		this.row = m_row;
		this.column = m_column;
		this.highValue = m_highValue;
	}
}
