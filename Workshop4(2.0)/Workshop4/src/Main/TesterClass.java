package Main;
import Task1.*;
import Task2.*;
import Task3.*;


import java.io.FileNotFoundException;

public class TesterClass {
	public static void main(String[] args) throws FileNotFoundException {
		Task1 hangman = new Task1();
		hangman.play();
		
		Task2 countwords = new Task2();
		countwords.count();
		
		Task3 phone = new Task3();
		phone.phonechange();
	}
}

