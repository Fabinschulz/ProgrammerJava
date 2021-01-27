package aula07;

import java.util.Scanner;

public class Array {
		public static void main(String[] args) {
			manipulandoArrays();
			calculandoSoma();
		}
		
		/*
		 * ler uma sequência de 5 números e imprimir a soma
		 * Exemplo:
		 * 		in: 4 7 2 9 8
		 * 		out: Soma = 30
		 */
		public static void calculandoSoma() {
			Scanner sc = new Scanner(System.in);
			int tamanho = 5;
			double v[] = new double[tamanho];
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
			System.out.println("Soma = " + soma);
		}
		
		
		public static void manipulandoArrays() {
			int num[] = new int[10];
			num[0] = 5;
			num[1] = 2;
			num[4] = 0;
			num[3] = 18;
			System.out.println("Usando o for completo ===========================");
			for (int i=0 ; i<num.length ; i++) {  // loop para i de 0 até 4
				System.out.printf("num[%d] = %2d\n",i,num[i]);
			}
			System.out.println("Usando o for each ===============================");
			for (int v: num) {  // 
				System.out.println("v = " + v);
			}
		}
		
		public static void variosArrays() {
			int inteiros[] = new int[10]; // cria um array de 10 inteiros
			long [] longs = new long[20];  // cria um array de 20 longs
			double[] decimais = new double[132]; // cria um array de 132 doubles
			String nomes [] = new String[20]; // cria um array de 20 strings
			float flutuantes[];   // declara um array mas não cria
			flutuantes = new float[17];   // cria o array de 17 floats
			int tamanho = 40;
			double[] nums = new double[tamanho]; // cria um array de 40 doubles
			int preenchido[] = {2,3,5,3,7,90,45};  // cria array de int preenchido
		}


	}
