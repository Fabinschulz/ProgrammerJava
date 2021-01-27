package aula04;

import java.util.Scanner;

public class SwitchCase {

		
	public static void main(String[] args) {
		//diaDaSemana();
		buscarMes();
	}

	/*
	 * Ler um nr interio entre 1 e 7 e mostrar o dia da semana
	 */
	public static void diaDaSemana() {
		//Lendo entrada de dados
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite um nr entre 1 a 7: ");
		int dia = sc.nextInt();
		//Mostrar dia da semana com switch
		switch (dia) {
		case 1: System.out.print("Domingo");		break;
		case 2: System.out.print("Segunda-Feira");  break;
		case 3: System.out.print("Terça-Feira");  	break;
		case 4: System.out.print("Quarta-Feira"); 	break;
		case 5: System.out.print("Quinta-Feira"); 	break;
		case 6: System.out.print("Sexta-Feira");  	break;
		case 7: System.out.print("Sábado");       	break;
		default: System.out.print("Digite um nr valido de 1 a 7 Cabiçudo");
		}
		sc.close();
	
	}
	
	public static void buscarMes() {
		//Lendo entrada de dados
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite um nr entre 1 a 12: ");
		int mes = sc.nextInt();
		//Mostrar o mes do ano com switch
		switch (mes) {
		case 1: System.out.print("Janeiro");	break;
		case 2: System.out.print("Fevereiro");  break;
		case 3: System.out.print("Março");  	break;
		case 4: System.out.print("Abril"); 		break;
		case 5: System.out.print("Maio"); 		break;
		case 6: System.out.print("Junho");  	break;
		case 7: System.out.print("Julho");      break;
		case 8: System.out.print("Agosto");     break;
		case 9: System.out.print("Setembro");   break;
		case 10: System.out.print("Outubro");   break;
		case 11: System.out.print("Novembro");  break;
		case 12: System.out.print("Dezembro");  break;
		default: System.out.print("Digite um nr valido de 1 a 12 Cabiçudo");
		}
	    sc.close();
	}
		
}