package Aula1;

public class Principal {
	public static void main(String[] args) {
		System.out.println("Alo Mundo!");
		Aula1.Principal.variaveis();
	}


	//
	public static void variaveis() {
		int n1,n2,total;   
		n1 = 10;			
		n2 = 3; 
	
		total = n1 + n2;    
		System.out.println("Soma = " + total);   
		//sub
		total = n1 - n2;
		System.out.println("Subtra��o = " + total);
		
		total = n1 * n2;
		System.out.println("Multipli��o = " + total);
		
		total = n1 / n2;
		System.out.println("Divis�o = " + total);
	}
	
	public static void println() {
		System.out.println("todo println da classe Principal.");
	}


}
