package aula8.juber;

public class Quadrado {

/*
 * implementar a classe Quadrado com:
 * 		construtor: recebe 1 double - lado
 * 		getPerimetro() = 4 * lado
 * 		getArea() = lado * lado
 */

	
	double lado;
	
	public Quadrado(double lado) {
		this.lado = lado;
	}
	
	public double getPerimetro() {
		double perimetro = 4 * lado;
		return perimetro;
	}
	
	public double getArea() {
		return (lado*lado);
	}

}


