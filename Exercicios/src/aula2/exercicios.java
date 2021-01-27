package aula2;

import java.util.Scanner;

public class exercicios {
	public static void main(String[] args) {
		// soma();
		//converte();
		calculaSalarioBruto();
	}

	/*
	 * 
	 */
	
	public static void calculaSalarioLiquido() {
		
		
		
	}
	
	
	
	
	
	
	public static void calculaSalarioBruto() {
			String nome;
			double valor;
			int horas;
			Scanner sc = new Scanner(System.in);	
			System.out.println("Nome: ");
			nome = sc.nextLine();
			System.out.println("Valor por hora: ");
			valor = sc.nextDouble();
			System.out.println("Quantidade de Horas Trabalhadas: ");
			horas = sc.nextInt();
			System.out.println(nome  + " -  R$  "  +(valor*horas));
			sc.close();
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
		System.out.println("Temperatura em Fahrenheit = " + fahr + " °f\n " + 
				            "Temperatura em kelvin = " + kelvin + " k");
		sc.close();
	}

}
