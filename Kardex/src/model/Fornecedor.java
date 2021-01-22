package model;

public class Fornecedor {

	private int id;
	private String cnpj;
	private String nome;
	private String telefone;
	private String email;
	
	public Fornecedor() {
		super();
	}

	public Fornecedor(int id, String cnpj, String nome, String telefone, String email) {
		super();
		setId(id);
		setCnpj(cnpj);
		setNome(nome);
		setTelefone(telefone);
		setEmail(email);
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.isEmpty()) {
			throw new IllegalArgumentException("Nome não pode ser vazio!");
		} else if (nome.isBlank()) {
			throw new IllegalArgumentException("Nome não pode ser em branco!");
		} else if (nome.length() < 5) {
			throw new IllegalArgumentException("Nome deve ter mais de 4 letras!");
		} else {
			this.nome = nome;
		}
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if (telefone.length() != 10) {
			throw new IllegalArgumentException("Telefone deve ter 10 dígitos!");
		}
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", nome=" + nome + "]";
	}
		
}


