package aula08;

public class Retangulo {
	double base;
	double altura;
	
	public Retangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}
	
	public double getPerimetro() {
		return (2 * (base + altura));
	}
	
	public double getArea() {
		return (base * altura);
	}


}
