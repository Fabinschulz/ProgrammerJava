package aula3;

import javax.swing.JOptionPane;

public class condicional {


	public static void main(String[] args) {
		//compara();
		//ternario();
		bloco();
	}
	
	public static void bloco() {
		if(10 > 0) {
			System.out.println("10 é maior que zero");
			System.out.println("10 é positivo");
			System.out.println("10 é um número bonito");
		}
	}

	public static void compara() {
		String s = JOptionPane.showInputDialog("Digite um número:");
		int num = Integer.parseInt(s);
		if (num > 10) JOptionPane.showMessageDialog(null, "O número é maior que 10");
		else if (num < 10) JOptionPane.showMessageDialog(null, "O número é menor que 10");
		else JOptionPane.showMessageDialog(null, "O número é igual a 10");
		

	}
	
	public static void ternario() {
		String s = JOptionPane.showInputDialog("Digite um número:");
		int num = Integer.parseInt(s);
		JOptionPane.showMessageDialog(null, (num>10 ?
				"O número é maior que 10" :
				"O número não é maior que 10"));
		
		
	}

}