import java.util.Scanner;

public class Task1 {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args){
		//String[] words = {"write", "that", "dog", "pixel", "snake", "tiger", "dragon", "crowbar", "eclipse", "java"};
		String cont;
		
		do {
			int wrong = 0;
			char[] randomword = createword();//Picks a random word
			//Hides a random word with asteriks
			char[] hidden = new char[randomword.length];
			for (int i = 0; i < hidden.length; i++) {
				hidden[i] = '*';
			}
			do {
				String g;
				char guess;
				System.out.print("(Guess) Enter a letter in word ");
				System.out.print(hidden);
				System.out.print(" > ");
				//validates if the input is a letter and not a number
				while(input.hasNextInt()) {
					System.out.print("No Numbers allowed. Enter a letter in word: ");
					input.next();
				}
				g = input.next();
				guess = g.charAt(0);
				
				if (!CorrectGuess(randomword, hidden, guess)) {
					wrong++;
				}
			} while (!gameover(hidden));
			//prints out the word and how many letters missed
			System.out.print("The word is ");
			System.out.print(randomword);
			System.out.println(" You missed " + wrong + " time");
			
			//Validates right input for yes or no option.
			System.out.print("Do you want to guess another word? Enter y or n > ");
			while(!input.hasNext("y") && !input.hasNext("n")) {
				System.out.print("Only Y(es) or N(o) are allowed. Enter y or n: ");
				input.next();
			}
			cont = input.next();
			
		} while (cont.charAt(0) == 'y');
		
	};
	//picks a random word out of the array.
	public static char[] createword() {
		String[] words = {"write", "that", "dog", "pixel", "snake", "tiger", "dragon", "crowbar", "eclipse", "java"};
		String word = words[(int)(Math.random() * words.length)];
		
		char[] genword = new char[word.length()];
		
		for(int i = 0; i < genword.length; i++) {
			genword[i] = word.charAt(i);
		}
		
		return genword;
	}
	
	//Boolean check if the word is solved by matching original word and hidden with astericks word
	public static boolean gameover(char[] y) {
		for (char i: y) {
			if (i == '*')
				return false;
		}
		return true;
	}
	
	//Checks if the guessed letter is correct, returns the case print if it's already in the word/not in the word
	public static boolean CorrectGuess(char[] word, char[] blanks, char guess) {
		boolean correct = false;
		int message = 2;
		for (int i = 0; i < word.length; i++) {
			if (word[i] == guess) {
				correct = true;
				if (blanks[i] == guess)
					message = 1;
				else { 
					blanks[i] = guess;
					message = 0;
				}
			}
		}
		if (message > 0) {
			System.out.print("\t" + guess);
			switch (message) {
				case 1 : System.out.println(" is already in the word"); break;
				case 2 : System.out.println(" is not in the word");
			}
		}
		return correct;
	}
}
