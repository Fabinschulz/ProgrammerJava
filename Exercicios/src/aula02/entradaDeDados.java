package aula02;

import java.util.Scanner;

public class entradaDeDados {
	public static void main(String[] args) {
		
		int valor;
		
		//entradaTexto();
		//lendoLinhaToda();
		//lendoNumeros();
		valor = retorno();
		
		System.out.println("O retorno foi: " + valor);
		
	}
	
	public static int retorno() {
		int n1 = 10;
		int n2 = 5;
		int total = n1 * n2;
		
		return total;
		
	}
	
	
	
	public static void entradaTexto() {
		
		String s;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite seu nome: ");
		s = sc.next();
		
		System.out.println(s);
		
		sc.close();
	}
	
	public static void lendoLinhaToda() {
		
		String linha;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite um texto: ");
		linha = sc.nextLine();
		System.out.println(linha);
		sc.close();
	
	}
	
	public static void lendoNumeros() {
		
		int    n1;                                    // numeros inteiros
		double n2;                                    // numeros decimais
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite um número inteiro: ");
		n1 = sc.nextInt();                            // lê um numero inteiro
		System.out.print("Digite um número real: ");
		n2 = sc.nextDouble();                         // lê um numero decimal
		System.out.println("Inteiro  = " + n1 + "\nDecimal  = " + n2);
		
		sc.close();
		
	}
	
	


}
