package Main;
import java.util.Scanner;

import Task1.*;
import Task2.*;

public class TesterClass {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Task1 bean = new Task1();
		String cont;
		
		//do {
		//	bean.play();
		//	System.out.print("Do you want to remodel again? y(es) or n(o): ");
		//	while(!input.hasNext("y") && !input.hasNext("n")) {
		//		System.out.print("Only y(es) or n(o) are allowed. Enter y or n: ");
		//		input.next();
		//	}
		//	cont = input.next();
		//} while (cont.charAt(0) == 'y');
		
		Task2 addressbooks = new Task2();
		addressbooks.herewego(args);
	}
}
