package Task2;

public class Task2 {
	static int size = 2000;
	public void countTime() {
		
		double matrix[][] = new double [size][size];
		double matrix1[][] = new double [size][size];
		
		//filling the matrix with numbers
		for(int i = 0; i < size; i++) {
			for(int a = 0; a < size; a++) {
				matrix[i][a] = Math.random();
				matrix1[i][a] = Math.random();
			}
		}
		
		//sequantial method 
		sequentialAdd(matrix, matrix1);
		parallelAddMatrix(matrix, matrix1);
	}
	public static double[][] sequentialAdd(double[][] m, double[][] m1) {
		double sum[][] = new double[size][size];
		long startTime, endTime;
		startTime = System.nanoTime();
		for(int i = 0; i < size; i++) {
			for(int a = 0; i < size; i++) {
				sum[i][a] = m[i][a] + m[i][a];
			}
		}
		endTime = System.nanoTime();
		
		System.out.println("Time took for sequential add(in nanoseconds): " + (endTime - startTime));
		return sum;
	}
	
	public static double[][] parallelAddMatrix(double[][] m, double[][] m1){
		double sum[][] = new double[size][size];
		long startTime, endTime;
		
		parallel parallel1 = new parallel(m, m1, 0, size/4 - 1);
		parallel parallel2 = new parallel(m, m1, size / 4, size / 2 - 1);
		parallel parallel3 = new parallel(m, m1, size / 2, size / 4 * 3 - 1);
		parallel parallel4 = new parallel(m, m1, size / 4 * 3, size - 1);
		
		Thread t1 = new Thread(parallel1);
		Thread t2 = new Thread(parallel2);
		Thread t3 = new Thread(parallel3);
		Thread t4 = new Thread(parallel4);
		
		startTime = System.nanoTime();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		endTime = System.nanoTime();
		
		System.out.println("Time took for parallel add(in nanoseconds) in 4 threads:" + (endTime - startTime));
		
		return sum;
	}
	
}
