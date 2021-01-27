package aula03;

import javax.swing.JOptionPane;

public class exercicios {

	

	public static void main(String[] args) {
		// ordemCrescente();
		// valorAbsoluto();
		// sinalDoNumero();
		// numerosMultiplos();
		// diferenca();
		meses();
	}

	/*
	 * Ler um numero entre 1 e 12 e imprimir o mês correspondente
	 */

	public static void meses() {
		String num = JOptionPane.showInputDialog("Digite um número de 1 a 12:");
		int mes = Integer.parseInt(num);
		
		switch(mes) {
		case 1:  JOptionPane.showMessageDialog(null, "Janeiro");   break;
		case 2:  JOptionPane.showMessageDialog(null, "Fevereiro"); break;
		case 3:  JOptionPane.showMessageDialog(null, "Março");     break;
		case 4:  JOptionPane.showMessageDialog(null, "Abril");     break;
		case 5:  JOptionPane.showMessageDialog(null, "Maio");      break;
		case 6:  JOptionPane.showMessageDialog(null, "Junho");     break;
		case 7:  JOptionPane.showMessageDialog(null, "Julho");     break;
		case 8:  JOptionPane.showMessageDialog(null, "Agosto");    break;
		case 9:  JOptionPane.showMessageDialog(null, "Setembro");  break;
		case 10: JOptionPane.showMessageDialog(null, "Outubro");   break;
		case 11: JOptionPane.showMessageDialog(null, "Novembro");  break;
		case 12: JOptionPane.showMessageDialog(null, "Dezembro");  break;
		default: JOptionPane.showMessageDialog(null, "Número inválido!");
		meses();
		
		
		}
	}

	/*
	 * Ler 2 numeros e informar a diferença entre eles
	 */
	public static void diferenca() {
		String num1 = JOptionPane.showInputDialog("Digite o primeiro número:");
		String num2 = JOptionPane.showInputDialog("Digite o segundo número:");
		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num2);
		int diferenca;
		if (n1 > n2) {
			diferenca = n1 - n2;
			JOptionPane.showMessageDialog(null, "A diferença é " + diferenca);
		} else {
			diferenca = n2 - n1;
			JOptionPane.showMessageDialog(null, "A diferença é " + diferenca);

		}
	}

	/*
	 * Leia 2 numeros e informe se são multiplos
	 */

	public static void numerosMultiplos() {
		String num1 = JOptionPane.showInputDialog("Digite o primeiro número:");
		String num2 = JOptionPane.showInputDialog("Digite o segundo número ");
		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num2);

		if (n1 % n2 == 0) {
			JOptionPane.showMessageDialog(null, "O número " + n1 + " é multiplo de " + n2);
		} else if (n2 % n1 == 0) {
			JOptionPane.showMessageDialog(null, "O número " + n1 + " é multiplo de " + n2);
		} else {
			JOptionPane.showMessageDialog(null, "Os números não são multiplos");
		}

	}

	/*
	 * Leia um numero e informe se ele é positivo, negativo ou nulo
	 */
	public static void sinalDoNumero() {
		String num = JOptionPane.showInputDialog("Digite um número:");
		int n = Integer.parseInt(num);
		if (n > 0) {
			JOptionPane.showMessageDialog(null, "O número " + n + " é positivo");
		} else if (n == 0) {
			JOptionPane.showMessageDialog(null, "O número " + n + " é nulo");
		} else {
			JOptionPane.showMessageDialog(null, "O número " + n + " é negativo");
		}

	}

	/*
	 * Fazer rotina que leia um numero e mostre seu valor absoluto
	 */
	public static void valorAbsoluto() {
		String num = JOptionPane.showInputDialog("Digite um número:");
		int n = Integer.parseInt(num);
		if (n < 0)
			n = n * -1;
		JOptionPane.showMessageDialog(null, "Valor absoluto: " + n);

	}

	/*
	 * Fazer rotina que leia dois numeros e imprima-os em ordem crescente
	 */
	public static void ordemCrescente() {

		String num1 = JOptionPane.showInputDialog("Digite o primeiro número:");
		String num2 = JOptionPane.showInputDialog("Digite o segundo número ");
		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num2);

		if (n1 < n2) {
			JOptionPane.showMessageDialog(null, "Ordem crescente: " + n1 + " - " + n2);
		} else if (n2 < n1) {
			JOptionPane.showMessageDialog(null, "Ordem crescente: " + n2 + " - " + n1);
		} else {
			JOptionPane.showMessageDialog(null, "Ambos os números são iguais");
		}

	}


}
