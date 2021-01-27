package aula10;

public class Consumidor extends Cliente {

	private long cpf;
	long celular;
	
	public Consumidor(String nome, String email, long cpf, long celular) {
		super(nome,email);
		this.cpf = cpf;
		this.celular = celular;
	}
	
	public long getCpf() {
		return cpf;
	}
	
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	
}