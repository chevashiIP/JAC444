package Task1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
	int ballnum, slotnum, slots[], slotball;
	public void play() {
		Scanner input = new Scanner(System.in);
		
		ballnum = input("Enter the number of balls to drop");
		slotnum = input("Enter the number of slots in the bean machine");
		
		String[] ballPaths = new String[ballnum];
		slots = new int[slotnum];
		
		for(int i = 0; i < slots.length; i++) {
			slots[i] = 0;
		}
		slotball = 0;
		
		trace();
		display();
		
	}
	public int input(String prompt){
		Scanner input = new Scanner(System.in);
		boolean correct = false;
		int enterednum = 0;
		System.out.print(prompt + ": ");
		while(!correct) {
			try {
				enterednum = input.nextInt();
				correct = true;
			} catch (InputMismatchException e) {
				System.out.print("Wrong input, re-enter: ");
				input.next();
			}
		}
		return enterednum;
	}
	
	public void trace() {
		System.out.println();
		for(int i = 0; i < ballnum; i++) {
			int count = 0;
			for(int j = 0; j < slotnum - 1; j++) {
				int random = (int)(Math.random() * 10) % 2;
				String side;
				if (random > 0) {
					side = "R";
					count++;
				} else {
					side = "L";
				}
				System.out.print(side);
			}
			slots[count]++;
			if(slotball < slots[count]) {
				slotball = slots[count];
			}
			System.out.println();
		}
		
	}
	public void display() {
		System.out.println();
		for(int i = 0; i < slotball; i++) {
			for(int j = 0; j < slotnum; j++) {
				if(slotball - slots[j] <= i) {
					System.out.print("O");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
