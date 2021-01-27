package aula07;

import java.util.Scanner;

public class Exercicios {

 		public static void main(String[] args) {
 			//media();
 			maiorValor();
 		}
 		
 		/*
 		 * gerar um array com 20 números randômicos entre 0 e 100 e imprimir o maior 
 		 * Exemplo:
 		 * 		out: vetor: 3 - - 5 - 6 ... - 10
 		 * 		out: maior valor = 10
 		 */
 		public static void maiorValor() {
 			int tamanho = 20;
 			double v[] = new double[tamanho];
 			System.out.print("Vetor: ");
 			// gerar a sequencia de números randômicos
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
 		 * ler 5 números e imprimir a média
 		 * Exemplo:
 		 * 		in: Digite 5 números: 7 2 9 10 4 
 		 * 		out: Média = 6.4
 		 */
 		public static void media() {
 			Scanner sc = new Scanner(System.in);
 			int tamanho = 5;
 			double v[] = new double[5];
 			// lendo a sequencia de números
 			System.out.printf("Digite a sequência de %d números: ",tamanho);
 			for (int i=0 ; i<v.length ; i++) {
 				v[i] = sc.nextDouble();
 			}
 			// percorrendo o array e calculando a soma
 			double soma = 0;
 			for (double n: v) {
 				soma += n;
 			}
 			// imprimir a soma
 			System.out.println("Média = " + (soma/tamanho));	
 			sc.close();
 		}
	
 		
 	}
 
 
 

