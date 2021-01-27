package aula04;

import java.util.Scanner;

public class funcoes {



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Primeiro N�mero: ");
		int n1 = sc.nextInt();
		System.out.print("Segundo N�mero: ");
		int n2 = sc.nextInt();
		int n3 = soma(n1,n2); 
		System.out.println("A soma � = " + n3);
		System.out.println("A diferen�a � = " + dif(n1,n2));
		System.out.println("Dia da semana do primeiro n�mero: " + nomeDoDia(n1));
		System.out.println("Dia da semana do segundo n�mero: " + nomeDoDia(n2));
		sc.close();
	}

	/*
	 * nomeDoDia: recebe um inteiro entre 1 e 7 e retorna o nome do dia da semana
	 * param: dia : n�mero do dia da semana
	 * 				1 - Domingo / 7 - S�bado
	 * return: nome do dia da semana
	 */
	public static String nomeDoDia(int dia) {
		if (dia == 1) return ("Domingo");
		else if (dia == 2) return ("Segunda");
		else if (dia == 3) return ("Ter�a");
		else if (dia == 4) return ("Quarta");
		else if (dia == 5) return ("Quinta");
		else if (dia == 6) return ("Sexta");
		else if (dia == 7) return ("S�bado");
		else return ("Dia inv�lido. Entre 1 e 7.");
	}
	
	/*
	 * recebe 2 inteiros e retorna a soma deles.
	 * par�metros:  a: int
	 * 				b: int
	 * retorno: total: int
	 */
	public static int soma(int a, int b) {
		int total = a + b;
		return total;
	}
	
	/*
	 * recebe 2 inteiros e retorna a diferen�a entre eles
	 * par�metros:  a: int
	 * 				b: int
	 * retorno: dif: int
	 */
	public static int dif(int a, int b) {
		int dif;
		if (a > b) dif = a - b;
		else dif = b - a;
		return dif;
	}
	
}