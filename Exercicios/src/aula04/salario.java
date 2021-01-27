package aula04;

import java.util.Scanner;

public class salario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Variaveis Salário
		String nome;
		double vlHora;
		double qtHora;
		double vlSalBruto     = 0;
		double prAliquotaIRPF = 0;
		double prAliquotaINSS = 0;
		double vlIRPF         = 0;
		double vlINSS         = 0;
		double vlSalLiquido   = 0;
		
		//Abrindo entrada de dados
		Scanner sc = new Scanner(System.in);
		
		// Calculando Salário Liquido
		System.out.print("Nome:...............: ");
		nome = sc.nextLine();		
		System.out.print("Valor Hora:.........: ");
		vlHora = sc.nextDouble();
		System.out.print("Qt de Horas:........: ");
		qtHora = sc.nextDouble();
		
		if (vlHora > 0 && qtHora > 0) {
			vlSalBruto     = vlHora * qtHora;
			prAliquotaIRPF = calculaAliquotaIRRF(vlSalBruto);
			prAliquotaINSS = calculaAliquotaINSS(vlSalBruto);
			vlIRPF         = (vlSalBruto * (calculaAliquotaIRRF(vlSalBruto)/100));
			vlINSS         = (vlSalBruto * (calculaAliquotaINSS(vlSalBruto)/100));
			vlSalLiquido   = (vlSalBruto - (vlIRPF+vlINSS));
		} else {
			System.out.println("Valor da hora ou quantidade de horas inválidos!!!");
		}
		
		//Exibindo valores de imposto sal bruto e liquido
		System.out.println("\n* RESULTADOS SALARIO LIQ/IRPF/BRT **********");
		System.out.println("NOME...................: "+nome);
		System.out.println("VL HORA................: "+vlHora);
		System.out.println("QT HORAS...............: "+qtHora);
		System.out.println("VL SAL BRUTO...........: "+vlSalBruto);
		System.out.println("IRRF...................: "+prAliquotaIRPF+" -> "+vlIRPF);
		System.out.println("INSS...................: "+prAliquotaINSS+" -> "+vlINSS);
		System.out.println("VL SAL LIQUIDO.........: "+vlSalLiquido);
		
		sc.close();

	}
	
	public static double calculaAliquotaIRRF(double vlSalario) {
		if (vlSalario <= 1903.98) return(0);
		else if (vlSalario >= 1903.99 && vlSalario <= 2826.65) return(7.5);
		else if (vlSalario >= 2826.66 && vlSalario <= 3751.05) return(15);
		else if (vlSalario >= 3751.05 && vlSalario <= 4664.68) return(22);
		else return(27.5); //vlSalario > 4664.68
	}
	
	public static double calculaAliquotaINSS(double vlSalario) {
		if (vlSalario <= 1045) return(7.5);
		else if (vlSalario >= 1045.01 && vlSalario <= 2089.60) return(9);
		else if (vlSalario >= 2089.60 && vlSalario <= 3134.40) return(12);
		else return(14); //vlSalario > 3134.41
	}
	

}
