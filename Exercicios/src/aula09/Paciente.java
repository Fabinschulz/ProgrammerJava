package aula09;

import java.util.Scanner;

public class Paciente {
	

	String nome;
	int idade;
	double peso;
	double altura;
	
	public Paciente(String nome, int idade, double peso, double altura) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.peso = peso;
		this.altura = altura;
	}

	public Paciente(String nome) {
		super();
		this.nome = nome;
	}

	public void listar() {
		System.out.println("Paciente: " +
							nome + "\t" +
							idade + "\t" +
							peso + "\t" +
							altura + "\t" +
							getIMC());
	}
	
	public String getIMC() {
		double imc = peso / (altura * altura);
		String classe = aula04.ClasseIMC.classeIMC(imc);
		return classe;
	}
}