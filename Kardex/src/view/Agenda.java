package view;
/*
 * declarar os atributos
 * criar a assinatura dos métodos (sem código)
 */
public class Agenda {
	
	String nome;
	String celular;
	String email;
	
	public Agenda(String nome, String celular, String email) {
		this.nome = nome;
		this.celular = celular;
		this.email = email;
	}
	public Agenda(String nome, String celular) {
		this.nome = nome;
		this.celular = celular;
		this.email = email;
	}
	public Agenda() {
	}
	
	public void incluir() {
		
	}
	
	public void listar() {
		System.out.println("Dados do Contato --------------------------");
		System.out.println("Nome: " + nome);
		System.out.println(celular + "  -  " + email);
		System.out.println("-------------------------------------------");
	}

}