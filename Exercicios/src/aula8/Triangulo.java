package aula8;

public class Triangulo {

	double a;
	double b;
	double c;
	
	
	public Triangulo(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;

	}

	/**
	 * Calcula o perímetro do triangulo.
	 * 
	 * @return o perímetro do triangulo
	 */
	public double getPerimetro() {
		double perimetro = a + b + c;
		return perimetro;
	}

	/**
	 * Calcula a área do triangulo pelo método de Herón.
	 * 
	 * @return a área do triangulo
	 */
	public double getArea() {
		double p = (a + b + c) / 2;
   double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
		return area;
	}

}
