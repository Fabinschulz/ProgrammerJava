package aula09;

import java.util.ArrayList;
import java.util.Scanner;

public class PacienteSistema {

	static ArrayList<Paciente> lista = new ArrayList<Paciente>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n===================================");
			System.out.println("Menu de Opções:");
			System.out.println("\t1 - Incluir");
			System.out.println("\t2 - Listar");
			System.out.println("\t3 - Sair");
			System.out.print("\t\t\tOpção: ");
			int opcao = sc.nextInt();
			switch (opcao) {
			case 1: digitaDados(); break;
			case 2: listaDados(); break;
			case 3: System.exit(0); break;
			}
		}
	}
	
	public static void listaDados() {
		System.out.println("\n\n=========================================");
		for (Paciente p: lista) {
			p.listar();
		}
		System.out.println("===========================================");
	}
	
	public static void digitaDados() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nome do Paciente: ");
		String nome = sc.nextLine();
		System.out.print("Idade: ");
		int idade = sc.nextInt();
		System.out.print("Peso: ");
		double peso = sc.nextDouble();
		System.out.print("Altura: ");
		double altura = sc.nextDouble();
		Paciente p = new Paciente(nome,idade,peso,altura);
		lista.add(p);
	}
}