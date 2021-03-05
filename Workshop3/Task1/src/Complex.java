public class Complex implements Cloneable {
	private double a;
	private double b;
	
	public Complex() {
		this(0, 0);
	}
	
	public Complex(double a) {
		this(a, 0);
	}
	
	public Complex(double m_a, double m_b) {
		this.a = m_a;
		this.b = m_b;
	}
	
	public Complex add(Complex secondComplex) {
		return new Complex(a + secondComplex.a, b + secondComplex.b); 
	}
	
	public Complex subtract(Complex secondComplex) {
		return new Complex(a - secondComplex.a, b - secondComplex.b);
	}
	
	public Complex multiply(Complex secondComplex) {
		return new Complex(a * secondComplex.a - b * secondComplex.b,
			b * secondComplex.a + a * secondComplex.b);
	}
	
	public Complex divide(Complex secondComplex) {
		return new Complex((a * secondComplex.a + b * secondComplex.b) /
			(Math.pow(secondComplex.a, 2) + Math.pow(secondComplex.b, 2)),
			(b * secondComplex.a - a * secondComplex.b) /
			(Math.pow(secondComplex.a, 2) +  Math.pow(secondComplex.b, 2)));
	}
	
	public double abs() {
		return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}
	
	public double getRealPart() {
		return a;
	}
	
	public double getImaginaryPart() {
		return b;
	}
	
	@Override
	public String toString() {
		return b == 0 ? a + "" : "(" + a + " + " + b + "i)";
	}
}
