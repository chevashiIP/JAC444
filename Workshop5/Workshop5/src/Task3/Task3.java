package Task3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {
	static boolean isPlayer1Turn = true;
    static boolean hasWon = false;
	public void play () {
		String[][] m = createGrid(6,7);
		Scanner input = new Scanner(System.in);
		int column = 0;
		boolean correct = false;
		boolean correct1 = false;
		while (!hasWon) {
			String diskColor = (isPlayer1Turn) ? "red" : "yellow";
			
			displayMatrix(m);
			boolean isFirstInput = true;
			
			do {
                if (!isFirstInput) {
                    System.out.println("COLUMN IS FULL. Try again...");
                }
                correct1 = false;
                while(!correct1) {
                	try {
                		do {
                			System.out.print("Drop a " + diskColor + " at column (0?6): ");
                			column = input.nextInt();
                			if(column < 0 || column > 6) {
                				System.out.println("Incorrect input.");
                			}
                			isFirstInput = false;
                		} while (column < 0 || column > 6);
                		correct1 = true;
                	} catch(InputMismatchException e) {
                		System.out.println("Incorrect input.");
                		input.next();
                	}
                }
            } while (!dropDisk(m, column));
			
			if (isConsecutiveFour(m)) {
                displayMatrix(m);
                while(!correct) {
                	try {
                		System.out.print("The "+diskColor+" player won! Do you want to play again? (y/n)");
                		char s = input.next().charAt(0);
                		if (s == 'y' || s == 'Y') {
                			m = createGrid(6, 7);
                			isPlayer1Turn = false;
                		} else {
                			System.exit(0);
                		}
                		correct = true;
                	} catch(InputMismatchException e) {
                		System.out.println("Incorrect input.");
                		input.next();
                	}
                	
                }
            }

            isPlayer1Turn = !isPlayer1Turn;
		}
	}
	
	public static void displayMatrix(String[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j]);
            }
            System.out.println("");
        }
    }
	 
	 public static String[][] createGrid(int row, int column) {
		 String[][] m = new String[row][column];
		 for(int i = 0; i < m.length; i++) {
			 for(int j = 0; j < m[i].length; j++) {
				 if(j == 0) {
					 m[i][j] = "| |";
				 } else {
					 m[i][j] = " |";
				 }
			 }
		 }
		 return m;
	 }
	 
	 public static boolean isConsecutiveFour(String[][] m) {

	        String s = (isPlayer1Turn) ? "R" : "Y";

	        int occurrence = 0;
	        
	        for (int j = 0; j < m[0].length - 3; j++) {
	            int y = m.length - 1;
	            int x = j;
	            while (x < m[0].length && y >= 0) {

	                 if (m[y][x].contains(s)) {              
	                     occurrence++;                       
	                    if (occurrence == 4) return true;    
	                } else {                                 
	                     occurrence = 0;                     
	                }                                        
	                x++;
	                y--;
	            }
	        }

	       
	        for (int i = m.length - 2; i > 2; i--) {
	            int x = 0; 
	            int y = i;
	            occurrence = 0;
	            while (x < m[0].length && y >= 0) {          
	                                                          
	                                                          
	                if (m[y][x].contains(s)) {                
	                    occurrence++;                         
	                    if (occurrence == 4) return true;     
	                } else {
	                    occurrence = 0;
	                }

	                x++;
	                y--;
	            }
	        }

	        
	        for (int j = m[0].length - 1; j >= 3; j--) {
	            int y = m.length -1; 
	            int x = j;
	            occurrence = 0;

	            while (x >= 0 && y >= 0) {
	                                                            
	                if (m[y][x].contains(s)) {                  
	                    occurrence++;                           
	                    if (occurrence == 4) return true;       
	                } else {                                   
	                    occurrence = 0;                         
	                }
	                x--;
	                y--;
	            }

	        }

	        for (int i = m.length - 2; i > 2; i--) {
	            int x = m[0].length - 1;
	            int y = i;
	            occurrence = 0;
	            while (x >= 0 && y >= 0) {                       
	                                                             
	                if (m[y][x].contains(s)) {                   
	                    occurrence++;                            
	                    if (occurrence == 4) return true;        
	                } else {                                     
	                    occurrence = 0;
	                }
	                x--;
	                y--;
	            }
	        }
	        
	        
	        for(int r = 0; r < m.length; r++) {					
	        	for(int c = 0; c < m[r].length; c++) {
	        		if(m[r][c].contains(s)) {
	        			occurrence++;
	        			if (occurrence == 4) return true;
	        		} else {
	        			occurrence = 0;
	        		}
	        	}
	        }
	       
	        for(int x = 0; x < m.length; x++) {
	        	int r = x;
	        	int c = 0;
	        	
	        	occurrence = 0;
	        	while(r < m.length && c < m[0].length) {
	        		if (m[r][c].contains(s)) {  
	        			occurrence++;
	        			if (occurrence == 4) return true; 
	        		} else {
	        			occurrence = 0;
	        		}
	        		r++;
	        	}
	        	c++;
	        }

	        return false;
	    }
	 
	 public static boolean dropDisk(String[][] m, int column) {

	        
	        String s;
	        if (isPlayer1Turn) {
	            s = (column > 0) ?  "R|" : "|R|";
	        } else {
	            s = (column > 0) ? "Y|" : "|Y|";
	        }
	        boolean didRowUpdate = false;
	        int row = 0;

	        
	        for (int i = 0; i < m.length; i++) {

	            if (isClear(m[i][column])) {
	                didRowUpdate = true;
	                row = i;
	            }
	        }

	        if (!didRowUpdate) return false;

	        m[row][column] = s;

	        return true;
	 }
	 public static boolean isClear(String s) {
	        return s.contains("| |") || s.contains(" |");
	 }
}
