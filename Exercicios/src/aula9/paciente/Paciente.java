package aula9.paciente;

import java.util.Scanner;

public class Paciente {
	
		String Nome;
		int Idade;
		double pesoPct;
		double altura;
		
		public Paciente(String nome, int idade, double peso, double altura) {
			super();
			this.Nome = nome;
			this.Idade = idade;
			this.pesoPct = peso;
			this.altura = altura;
		}

		public Paciente(String nome) {
			super();
			this.Nome = nome;
		}

		public void listar() {
			System.out.println("Paciente: " +
								Nome + "\t" +
								Idade + "\t" +
								pesoPct + "\t" +
								altura + "\t" +
								getIMC());
		}
		
		public String getIMC() {
			double imc = pesoPct / (altura * altura);
			String classe = aula04.ClasseIMC.classeIMC(imc);
			return classe;
		}

	}