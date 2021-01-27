package aula9.agenda.copy;

public class Agenda {
	
	String nome;
	String celular;
	String email;
	/**
	 * 
	 * @param nome
	 * @param celular
	 * @param email
	 */
	public Agenda(String nome, String celular, String email) {
		this.nome = nome;
		this.celular = celular;
		this.email = email;
	}
	public Agenda(String nome, String celular) {
		this.nome = nome;
		this.celular = celular;
		
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
