package aula05;

import java.util.Scanner;

public class CalculaINSS {
	
	public static void main(String[] args) {
		double valorHora;
		double qtdeHoras;
		double salarioBruto;
		double valorINSS;
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
		valorINSS = calculaINSS(salarioBruto);
		// calcular o salário líquido
		salarioLiquido = salarioBruto - valorINSS;
		// exibir na tela as informações
		System.out.println("Salário Bruto = R$ " + salarioBruto);
		System.out.println("Valor do INSS =  R$ " + valorINSS);
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
	public static double calculaINSS(double base) {
		double aliquota = 0;
		double valorINSS = 0;
		// estabelece o teto máximo de contribuição
		if (base > 6101.06) base = 6101.06;
		// encontra a faixa de ir correspondente à base e guardar a alíquota
		if (base <= 1045.0) aliquota = 7.5/100;
		else if (base <= 2089.60) aliquota = 9.0/100;
		else if (base <= 3134.40) aliquota = 12.0/100;
		else if (base <= 6101.06) aliquota = 14.0/100;
		// calcular o valor do inss
		valorINSS = base * aliquota;
		// arredondar para 2 casas decimais
		valorINSS = Math.round(valorINSS*100) / 100.0;
		// retornar o valor do inss
		return valorINSS;
	}

}
