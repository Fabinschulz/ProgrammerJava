package aula9.agenda;

import java.util.ArrayList;
import java.util.Scanner;

public class cadastroaAgenda {
	//Agenda[] contatos = new Agenda[50];
		static ArrayList<Agenda> contatos = new ArrayList<>();
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			sc.close();
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
			for (Agenda ag: contatos) {  
				ag.listar();
			}		
		}
		
		public static void digitaDados() {
			Scanner sc = new Scanner(System.in);
			sc.close();
			// digitação dos dados da Agenda
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Celular: ");
			String celular = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			// instanciação de um objeto Agenda com os dados
			Agenda ag1 = new Agenda(nome,celular,email);
			contatos.add(ag1);
			
		}

	}
	