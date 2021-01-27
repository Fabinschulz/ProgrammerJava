package aula06;

import javax.swing.JOptionPane;

public class Exercicios {

	public static void main(String[] args) {
		//repeteNome();
		//somaAteNumero();
		produtoAteNumero();
		
		
	}
	
	
		public static void repeteNome(){
			String nome = JOptionPane.showInputDialog("Nome: ");
			
			String str = JOptionPane.showInputDialog("Quantidade: ");
			int qtde = Integer.parseInt(str);
					for(int cont= 1 ; cont<=qtde ; cont++) { 				
						System.out.print( cont + ")" + nome);
}
}
		public static void somaAteNumero() {
			String str = JOptionPane.showInputDialog("Soma até: ");
			int num = Integer.parseInt(str);
			int soma= 0;
			for(int cont=1 ; cont<=num ; cont++) { 				
				soma = soma + cont;
				System.out.print(cont);    
			if (cont<num) System.out.print(" + ");
			
			}
			System.out.println(" = " + soma);
}
			
				
		
		public static void produtoAteNumero() {
			// ler inteiro
			String str = JOptionPane.showInputDialog("Produto Até: ");
			int num = Integer.parseInt(str);
			// calcular produtório de 1 até o número
			int total = 1;
			int cont = 1;
			while (cont<=num) {
				total = total * cont;
				System.out.print(cont);
				if (cont<num) System.out.print(" * ");
				cont++;
			}
			System.out.println(" = " + total);
				
				
				
				
			}
			
		}
		
		

