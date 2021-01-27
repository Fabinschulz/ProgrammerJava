package aula05;

import java.util.Scanner;

public class ResumoFolha {
	
	
	public static void main(String[] args) {
		String nome;
		double valordaHora;
		double qntdeHoras;
		double salarioBruto;
		double valorINSS;
		double valorIR;
		double salarioLiquido; 
		Scanner sc = new Scanner(System.in);
		System.out.print("nome: ");
		nome = sc.nextLine();
		System.out.print("Valor de horas trabalhada: ");
		valordaHora = sc.nextDouble();
		System.out.print("Quantidade de Horas trabalhada: ");
		qntdeHoras = sc.nextDouble();
		
		// calc salario bruto
		salarioBruto = valordaHora*qntdeHoras;
		//calc valor inss
		valorINSS = aula05.CalculaINSS.calculaINSS(salarioBruto);
		//calc valor ir
		valorIR = CalcularIRPF.calculaIR(salarioBruto - valorINSS);
		// calc salarioLiq
		salarioLiquido = salarioBruto - valorINSS - valorIR;
		// imp resumo da folha
		System.out.println("nome; "+ nome);
		System.out.println("salarioBruto; R$ "+ salarioBruto);
		System.out.println("INSS: R$" + valorINSS);
		System.out.println("IRPF: R$" + valorIR);
		System.out.println("Salario Liquido: R$ "+ salarioLiquido);
		sc.close();
		
		
	}

}

