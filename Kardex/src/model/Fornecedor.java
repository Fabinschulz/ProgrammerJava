package model;


import java.util.ArrayList;
import dao.FornecedorDAO;
import util.Verifica;

/*
 * implementar:
 * 		- atributos private
 * 		- construtor vazio
 * 		- construtor completo
 * 		- getters / setters atributos
 * 		- toString(): id, nome
 * valida√ß√µes:
 * 		- id n√£o pode ser setado manualmente - somente por construtor
 * 		- cnpj deve ser validado (altera√ß√£o futura)
 * 		- nome n√£o pode ser vazio, brancos e maior que 4 caracteres
 * 		- telefone: deve ser composto de 10 d√≠gitos (11) 1234-5678
 * 		- email: validar formata√ß√£o do email (altera√ß√£o futura)
 */

public class Fornecedor {
	
	private int id;
	private String cnpj;
	private String nome;
	private String telefone;
	private String email;
	private static ArrayList<Fornecedor> fornecedores = new ArrayList<>();
	
	public Fornecedor() {
		super();
	}
	public Fornecedor(String cnpj, String nome, String telefone, String email) {
		super();
		setId(0);
		setCnpj(cnpj);
		setNome(nome);
		setTelefone(telefone);
		setEmail(email);
		gravar();
	}	
	public Fornecedor(int id, String cnpj, String nome, String telefone, String email) {
		super();
		setId(id);
		setCnpj(cnpj);
		setNome(nome);
		setTelefone(telefone);
		setEmail(email);
	}
	
	private void gravar() {
		//fornecedores.add(this);
		new FornecedorDAO().insert(this);
	}
	
	public static ArrayList<Fornecedor> getLista() {
		// return fornecedores;
		FornecedorDAO dao = new FornecedorDAO();
		return dao.select();
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

	/**
	 * Atribui o CNPJ ao fornecedor.
	 * 
	 * @param cnpj o CNPJ a ser registrado.
	 * @throws IllegalArgumentException quando o cnpj È inv·lido.
	 */
	public void setCnpj(String cnpj) {
		if (Verifica.isCNPJ(cnpj)) {
			this.cnpj = cnpj;
		} else {
			throw new IllegalArgumentException("CNPJ inv·lido!");
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.isEmpty()) {
			throw new IllegalArgumentException("Nome n„o pode ser vazio!");
		} else if (nome.isBlank()) {
			throw new IllegalArgumentException("Nome n„o pode ser em branco!");
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
		if ((telefone.length() != 14) && (telefone.length() != 10)) {
			throw new IllegalArgumentException("Telefone deve ter 10 dÌgitos!");
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