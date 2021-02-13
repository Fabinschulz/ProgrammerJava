package aula08;

public class Principal {

	public static void main(String[] args) {
		
		Triangulo t1 = new Triangulo(5,3,4);
		System.out.println("Perímetro do t1 = " + t1.getPerimetro());
		System.out.println("Área do t1 = " + t1.getArea());
		
		Triangulo t2 = new Triangulo(6,10,8);
		System.out.println("Perímetro do t2 = " + t2.getPerimetro());
		System.out.println("Área do t2 = " + t2.getArea());

		Quadrado q1 = new Quadrado(5);
		System.out.println("Perímetro do q1 = " + q1.getPerimetro());
		System.out.println("Área do q1 = " + q1.getArea());
		
		Retangulo r1 = new Retangulo(3,4);
		System.out.println("Perímetro do r1 = " + r1.getPerimetro());
		System.out.println("Área do r1 = " + r1.getArea());
	}


}
