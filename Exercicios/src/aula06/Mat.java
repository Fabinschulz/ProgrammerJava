package aula06;

import java.util.Scanner;

public class Mat {
	
	
	
	/*
	 * ler um inteiro e informar o seu fatorial
	 * Exemplo: in: N�mero: 4
	 * 			out: 4! = 24
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite 2 inteiros: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.printf("MDC(%d,%d) = %3d\n",a,b,mdc(a,b));
		System.out.printf("MMC(%d,%d) = %3d\n",a,b,mmc(a,b));
		//JOptionPane.showMessageDialog(null,"O MDC � " + mdc(a,b));
		sc.close();
	}
	public static double menor(double v[]) {
		double menor = v[0];
		for (int i=1 ; i<v.length ; i++) {
			if (v[i] < menor) menor = v[i];
			}
			return menor;
		}
	
	
	
	

	
	
	
	public static double soma(double v[]) {
		double soma = 0;
		for (double n:v) {
			soma += n;
		}
		return soma;
		}
		
	
	public static double media(double v[]) { 
		double soma = soma(v);
		return (soma/v.length);
		
	}
	
	
	
	
	
	
	
	

	/*
	 * crie o m�todo fat(num) que recebe um inteiro num e 
	 * retorne um int com o fatorial de num.
	 * param: num : int - n�mero a ser calculado o fatorial
	 * return: o fatorial do n�mero = num!
	 */
	public static double fat(int num) {
		double total = 1;
		int cont = 1;
		while (cont<=num) {
			total = total * cont;
			cont++;
		}
		return total;
	}

	/*
	 * criar um m�todo pow(b,e) que calcula b^e
	 * param: b: double - base
	 * 		  e: int - expoente
	 * return: b elevado � pot�ncia e
	 * Exemplo: pow(5,4) = 5^4 = 5 * 5 * 5 * 5 = 625
	 */
	public static double pow(double b, int e) {
		double total = 1;
		if (e < 0) {
			e = e * -1;
			b = 1/b;
		}
		for (int cont=1 ; cont<=e ; cont++) {
			total = total * b;
		}
		return total;
	}
	
	/*
	 * calcula o m�ximo divisor comum entre 2 n�meros
	 * param: a,b : long - os n�meros a serem analisados
	 * return o mdc entre os n�meros
	 */
	public static long mdc(long a, long b) {
		long resp; // resposta
		// encontrar o menor dos n�meros
		if (a<b) resp = a;
		else resp = b;
		while (true) {
			// testar se o menor encontrado divide a e b
			if ((a%resp==0) && (b%resp==0)) return resp; // se dividir, retorna
			// se n�o, subtrai 1 tenta de novo
			else resp--;
		}
	}

	/*
	 * calcula o m�nimo m�ltiplo comum entre 2 n�meros
	 * param: a,b : long - os n�meros a serem analisados
	 * return o mmc entre os n�meros
	 */	
	public static long mmc(long a, long b) {
		long resp;
		// encontrar o maior dos dois
		if (a>b) resp = a;
		else resp = b;
		while (true) {
			// testar se a e b divide o n�mero
			if ((resp%a==0) && (resp%b==0)) return resp;  // se dividir - retornar a resposta
			// sen�o, somar 1 e testar de novo
			else resp++;
		}
	}
}