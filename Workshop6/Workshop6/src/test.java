public class test implements Runnable {
public static void main(String[] args) {
Thread t1 = new Thread(new test());
Thread t2 = new Thread(new test());
Thread t3 = new Thread(new test());
t1.start();
try {
t1.join();
}catch(InterruptedException e) {System.out.print(e);}
t2.start();
t3.start();
}
@Override
public void run() {
for(int i = 1; i <= 5; i++) {
try {
Thread.sleep(500);
}catch(InterruptedException e) {System.out.print(e);}
System.out.println(i);
} } }

