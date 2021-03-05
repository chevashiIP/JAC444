import java.util.Scanner;

public class Task1 {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
    	double a, b,c,d,e,f;
    	
        System.out.print("Enter a, b, c, d, e, f:");

        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();
        d = input.nextDouble();
        e = input.nextDouble();
        f = input.nextDouble();
        if((a*d)-(b*c) != 0) {
            double x = ((e * d) - (b * f)) / ((a * d) - (b * c));
            double y = ((a * f) - (e * c)) / ((a * d) - (b * c));
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        } else {
            System.out.println("The equation has no solution");
        }
    }
}
