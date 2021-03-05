import java.util.Scanner;

public class Task2 {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args){
		int daynum, month, dayword, year, century, yearcentury;

		System.out.print("Enter year: (e.g., 2012): ");
		year = input.nextInt();
		if(year <= 0) {
			System.out.print("Wrong year number is entered!");
		} else {
			System.out.print("Enter month: 1-12: ");
			month = input.nextInt();
			if(month < 1 || month > 12) {
				System.out.println("Wrong month number is entered!");
			} else {
				if(month == 1 || month == 2) {
					month += 12;
					year -= 1;
				};
				System.out.print("Enter the day of the month: 1-31: ");
				daynum = input.nextInt();
				if(daynum < 1 || daynum > 31) {
					System.out.println("Wrong day number is entered!");
				} else {
					century = year / 100;
					yearcentury = year % 100;
					
					dayword = ((daynum+(26*(month+1)/10)+yearcentury+(yearcentury/4)+(century/4)+5*century)%7);
					System.out.print("Day of the week entered ");
					switch (dayword) {
						case 0: System.out.println("Saturday");
								break;
						case 1: System.out.println("Sunday");
								break;
						case 2: System.out.println("Monday");
								break;
						case 3: System.out.println("Tuesday");
								break;
						case 4: System.out.println("Wednesday");
								break;
						case 5: System.out.println("Thursday");
								break;
						case 6: System.out.println("Friday");
								break;
					}
				}
			}
		}
	}
}
