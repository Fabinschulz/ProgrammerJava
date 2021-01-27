package aula6;

import javax.swing.JOptionPane;

public class Repeti�ao {
	
	public static void main(String[] args) {
		//mostraNumeros();
		//tabuadaWhile();
		tabuadaDoWhile();
	}
	
	/* 
	 * ler um inteiro qtde e imprimir de 1 at� qtde
	 * Exemplo:
	 * 		in: Imprimir at�: 6
	 * 		out: 1 - 2 - 3 - 4 - 5 - 6
	 */
	public static void mostraNumeros() {
		String str = JOptionPane.showInputDialog("Imprimir at�: ");
		int qtde = Integer.parseInt(str);
		
		for (int cont=1 ; cont<=qtde ; cont++) {
			System.out.print(cont + " - ");
		} 
	}

	public static void tabuadaFor() {
		String str = JOptionPane.showInputDialog("Imprimir a tabuada do n�mero: ");
		int num = Integer.parseInt(str);
		for (int cont=0 ; cont<=10 ; cont++) {
			System.out.println(num + " X " + cont + " = " + num*cont);
		} 	
	}	
	
	public static void tabuadaWhile() {
		String str = JOptionPane.showInputDialog("Imprimir a tabuada do n�mero: ");
		int num = Integer.parseInt(str);
		
		int cont=0;
		while (cont<=10) {
			System.out.println(num + " X " + cont + " = " + num*cont);
			cont++;
		}

	}	
	
	public static void tabuadaDoWhile() {
		String str = JOptionPane.showInputDialog("Imprimir a tabuada do n�mero: ");
		int num = Integer.parseInt(str);
		
		int cont=0;
		do {
			System.out.println(num + " X " + cont + " = " + num*cont);
			cont++;
		} while (cont<=10);

	}	

}
