package testes;


import java.util.Scanner;

public class Exercicios {

	public static void main(String[] args) {
// soma();
		converte();
	}

	public static void calculaSalarioBruto() {

	}

	public static void converte() {
		double celsius; // graus celsius
		double fahr; // graus fahrenheit
		double kelvin; // kelvin
		Scanner sc = new Scanner(System.in);
		System.out.println("Temperatura em Celsius: ");
		celsius = sc.nextDouble();
		fahr = celsius * (9 / 5) + 32;
		kelvin = celsius + 273.25;
		System.out.println();
	}


}
