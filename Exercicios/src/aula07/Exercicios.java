package aula07;

import java.util.Scanner;

public class Exercicios {

 		public static void main(String[] args) {
 			//media();
 			maiorValor();
 		}
 		
 		/*
 		 * gerar um array com 20 n�meros rand�micos entre 0 e 100 e imprimir o maior 
 		 * Exemplo:
 		 * 		out: vetor: 3 - - 5 - 6 ... - 10
 		 * 		out: maior valor = 10
 		 */
 		public static void maiorValor() {
 			int tamanho = 20;
 			double v[] = new double[tamanho];
 			System.out.print("Vetor: ");
 			// gerar a sequencia de n�meros rand�micos
 			for (int i=0 ; i<v.length ; i++) {
 				v[i] = Math.random() * 100;
 				System.out.printf("%.0f ",v[i]);
 			}
 			// encontrar o maior valor
 			double maior = v[0];  // guarda o primeiro valor
 			for (int i=1 ; i<v.length ; i++) {
 				if (v[i] > maior) maior = v[i];
 			}
 			// imprimir o maior valor
 			System.out.printf("\nMaior = %.0f", maior);
 		}
 		
 		/*
 		 * ler 5 n�meros e imprimir a m�dia
 		 * Exemplo:
 		 * 		in: Digite 5 n�meros: 7 2 9 10 4 
 		 * 		out: M�dia = 6.4
 		 */
 		public static void media() {
 			Scanner sc = new Scanner(System.in);
 			int tamanho = 5;
 			double v[] = new double[5];
 			// lendo a sequencia de n�meros
 			System.out.printf("Digite a sequ�ncia de %d n�meros: ",tamanho);
 			for (int i=0 ; i<v.length ; i++) {
 				v[i] = sc.nextDouble();
 			}
 			// percorrendo o array e calculando a soma
 			double soma = 0;
 			for (double n: v) {
 				soma += n;
 			}
 			// imprimir a soma
 			System.out.println("M�dia = " + (soma/tamanho));	
 			sc.close();
 		}
	
 		
 	}
 
 
 

