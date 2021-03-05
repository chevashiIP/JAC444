package Task2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task2 {
	public void count() throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter file name: ");
		String filename = input.next();
		File file = new File(filename);
		
		while(!file.exists()) {
			System.out.print("Re-enter file name: ");
			filename = input.next();
			file = new File(filename);
		}
		
		
		String buffer = "";
	    int[] letterCount = new int[26];
	    try (Scanner kk = new Scanner(file)) {
	    	while (kk.hasNext()) {
	    		buffer = kk.nextLine();
	            for (char ch : buffer.toCharArray()) {
	            	ch = Character.toUpperCase(ch);
	                if (ch >= 'A' && ch <= 'Z') {
	                        letterCount[ch - 'A']++;
	                }
	            }
	       }
	    } catch (FileNotFoundException ex) {
	    	ex.printStackTrace();
	    }

	    for (int i = 0; i < letterCount.length; i++) {
	    	System.out.println((char)(i + 'A') + " occurrence = " + letterCount[i]);
	    }
	}
}