package aula10;

public class Empresa extends Cliente{
	
	long cnpj;
	String telefone;
	/*
	 * prazo: n�mero de dias para pagamento de compra faturada.
	 * Deve ser entre 0 (a vista) at� 45 dias.
	 */
	private int prazo;
	
	public Empresa(String nome, String email, long cnpj, String telefone, int prazo) {
		super(nome,email);
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.prazo = prazo;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		if ((prazo < 0) || (prazo > 45)) {
			System.out.println("Prazo Inv�lido!!!!");
		} else {
			this.prazo = prazo;
		}
	}

}
