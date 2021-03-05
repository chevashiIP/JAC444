package Task3;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {
	public void phonechange() {
		Scanner input = new Scanner(System.in);
		
		boolean correct = false;
		int number = 0;
		char[] word = new char [7];
		PrintStream printToFile;
		FileOutputStream output = null;
		System.out.print("Enter the phone number: ");
		while(!correct) {
			try {
				do {
					number = input.nextInt();
					if(size(number) < 7 || size(number) > 7) {
						System.out.print("Incorrect length of the number. Re-Enter the phone number: ");
					}
				} while(size(number) < 7 || size(number) > 7);
				correct = true;
			} catch(InputMismatchException e) {
				System.out.print("Incorrect input. Re-Enter the phone number: ");
				input.next();
			}
		}
		String newnumber = stringify(number);
		char numberLetters[][] = {
	            {'0','0','0'},{'1','1','1'},{'A','B','C'},
	            {'D','E','F'},{'G','H','I'},{'J','K','L'},
	            {'M','N','O'},{'P','R','S'},
	            {'T','U','V'},{'W','X','Y'}
	    };
		
		try {
            output = new FileOutputStream ("Phonenumber.txt");
		} catch ( IOException ioEcception ){
			System.err.println( "Error opening file.");
		}
		try {
			char[] chars = newnumber.toCharArray ();
			int [] digit = new int [chars.length];
			for (int i = 0; i < chars.length; i++){
				digit[i] = Integer.parseInt(String.valueOf(chars[i]));
			}
			printToFile = new PrintStream(output);
			for ( int firstarr = 0; firstarr < 3; firstarr ++ ){
        	 
				word[0] = numberLetters[digit[0]][firstarr];
             
					for ( int secondarr = 0; secondarr < 3; secondarr++ ){
            	 
						word[1] = numberLetters[digit[1]][secondarr];

						for ( int thirdarr = 0; thirdarr < 3; thirdarr++ ){
                	 
							word[2] = numberLetters[digit[2]][thirdarr];

							for ( int fourtharr = 0; fourtharr < 3; fourtharr++ ){
                    	 
								word[3] = numberLetters[digit[3]][fourtharr];

								for ( int fitharr = 0; fitharr < 3; fitharr++ ){
                        	 
									word[4] = numberLetters[digit[4]][fitharr];

									for ( int sixarr = 0; sixarr < 3; sixarr ++ ){
                            	 
										word[5] = numberLetters[digit[5]][sixarr];

										for ( int sevenarr = 0; sevenarr < 3; sevenarr ++ ){
                                	 
											word[6] = numberLetters[digit[6]][sevenarr];
											printToFile.println(word);
											System.out.println(word);
											//printToFile.print("\n");
										}
									}
								}
							}
						}
					}
			}

         System.out.println("File written.");
         System.exit(1);
		}catch (Exception exception ){
         System.err.println( "Error writing to file.");
         System.exit(1);
		}
		
		try {
            if ( output != null )
                output.close();
        } catch (IOException ioException ){
            System.err.println( "Error closing file.");
            System.exit(1);
        }

	}
	public static int size(int number){
		String num = number + "";
		return num.length();
	}
	
	public static String stringify(int number){
		String num = number + "";
		return num;
	}
	
}