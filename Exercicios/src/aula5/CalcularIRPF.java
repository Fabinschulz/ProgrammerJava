package aula5;

import java.util.Scanner;

public class CalcularIRPF {

	public static void main(String[] args) {
		
		double valorHora;
		double qtdeHoras;
		double salarioBruto;
		double valorIR;
		double salarioLiquido;
		Scanner sc = new Scanner(System.in);
		// ler o valor da hora
		System.out.print("Valor da Hora: ");
		valorHora = sc.nextDouble();
		// ler a quantidade de horas
		System.out.print("Quantidade de Horas: ");
		qtdeHoras = sc.nextDouble();
		// calcular o salário bruto
		salarioBruto = valorHora * qtdeHoras;
		// chamar o método para calcular o valor do ir
		valorIR = calculaIR(salarioBruto);
		// calcular o salário líquido
		salarioLiquido = salarioBruto - valorIR;
		// exibir na tela as informações
		System.out.println("Salário Bruto = R$ " + salarioBruto);
		System.out.println("Valor do IRPF =  R$ " + valorIR);
		System.out.println("Salário Líquido = R$ " + salarioLiquido);
		sc.close();
	}
	
	/*
	 * calcular o irpf conforme tabela.
	 * Equação:
	 * 		valorIR = base * aliquota - parcelaDeduzir 
	 * param: base: double com a base de cálculo do ir - salário bruto
	 * return: o valor do ir a reter - double
	 */ 
	public static double calculaIR(double base) {
		double aliquota = 0;
		double parcelaDeduzir = 0;
		double valorIR = 0;
		// encontra a faixa de ir correspondente à base
		// guardar a alíquota e a parcela a deduzir
		if (base <= 1903.98) {  
			aliquota = 0;
			parcelaDeduzir = 0;
		} else if (base >= 1903.99 && base <= 2826.65) { // && AND lógico 
			aliquota = 7.5/100;
			parcelaDeduzir = 142.8;
		} else if (base >= 2826.66 && base <= 3751.05) { // && AND lógico 
			aliquota = 15/100;
			parcelaDeduzir = 354.8;
		} else if (base >= 3751.06 && base <= 4664.68) { // && AND lógico 
			aliquota = 22.5/100;
			parcelaDeduzir = 636.13;
		} else if (base > 4664.68) {
			aliquota = 27.5/100;
			parcelaDeduzir = 869.36;
		}
		// calcular o valor do ir
		valorIR = base * aliquota - parcelaDeduzir;
		// retornar o valor do ir
		return valorIR;
	} 



			 
	
		
		
		
	}
	


