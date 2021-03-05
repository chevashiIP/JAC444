package Task2;

public class parallel implements Runnable {
	double matrix1[][];
	double matrix2[][];
	int size;
	int start;
	int end;
	public static double sum[][];
	public parallel(double m1[][], double m2[][]) {
		matrix1 = m1;
		matrix2 = m2;
		size = m1.length;
		sum = new double[size][size];
	}
	
	public parallel(double m1[][], double m2[][], int start, int end) {
		matrix1 = m1;
		matrix2 = m2;
		this.size = m1.length;
		this.start = start;
		this.end = end;
		sum = new double[size][size];
	}
	
	
	public void run() {
		for(int i = this.start; i < this.end; i++) {
			for(int j = 0; j < matrix1.length; j++) {
				sum[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
	}
}
