package aula4;

import java.util.Scanner;

public class ClasseIMC {
	
	public static void main(String[] args) {
		String nome;
		double altura;
		double peso;
		double imc;
		String classe;
		// entrada de dados
		Scanner sc = new Scanner(System.in);
		System.out.print("Nome: ");
		nome = sc.nextLine();
		System.out.print("Altura: ");
		altura = sc.nextDouble();
		System.out.print("Peso: ");
		peso = sc.nextDouble();
		// cálculo imc
		imc = peso / (altura * altura);
		classe = classeIMC(imc);
		// saída de dados
		System.out.println("Seu IMC é " + imc);
		System.out.println("Sua classificação do IMC é " + classe);
		sc.close();
	}
	
	/*
	 * classeIMC: recebe o índice IMC e retorna a classificação
	 * param: imc : double - índice imc a ser classificado
	 * return: string contendo a classificação conforme tabela
	 */
	public static String classeIMC(double imc) {
		if (imc < 18.5) return "Peso Baixo";
		else if (imc <= 24.9) return "Peso Normal";
		else if (imc <= 29.9) return "Sobrepeso";
		else if (imc <= 34.9) return "Obesidade (Grau I)";
		else if (imc <= 39.9) return "Obesidade Severa (Grau II)";
		else return "Obesidade Mórbida (Grau II)";
	}

}
		
	
	