public class Task3 {
	public static void main(String[] args) {
		
		GeometricObject[] squares = {new Square(), new Square(), new Square(), new Square(), new Square()};
		
		for (int i = 0; i < squares.length; i++) {
		 	System.out.println(((Square)squares[i]).howToColor());
		 } 
	}
}
