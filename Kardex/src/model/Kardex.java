package model;

import java.util.Date;

public class Kardex {

	private int id;
	private Produto produto;
	private Date data;
	private String doc;
	private int qtde;
	private double valor;

	public Kardex() {
		super();
	}

	public Kardex(int id, Produto produto, Date data, String doc, int qtde, double valor) {
		super();
		setId(id);
		setProduto(produto);
		setData(data);
		setDoc(doc);
		setQtde(qtde);
		setValor(valor);
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		if (produto == null) {
			throw new IllegalArgumentException("Produto nulo não permitido!");
		}
		this.produto = produto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDoc() {
		return doc;
	}

	/*
	 * doc: pode ser vazio, não pode ser brancos, se não for vazio tem que ter pelo
	 * menos 3 caracteres
	 */
	public void setDoc(String doc) {
		if (doc.isBlank()) {
			throw new IllegalArgumentException("Não pode estar em branco!");
		} else if ((!doc.isEmpty()) && (doc.length() < 3)) {
			throw new IllegalArgumentException("3+ caracteres!");
		} else {
			this.doc = doc;
		}
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		if ((qtde < 1) || (qtde > 100)) {
			throw new IllegalArgumentException("Quantidade entre 1 e 1000!");
		} else {
			this.qtde = qtde;
		}
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		if ((valor < 0.01) || (valor > 10_000)) {
			throw new IllegalArgumentException("Valor entre 0,01 e 10.000,00!");
		} else {
			this.valor = valor;
		}
	}

	@Override
	public String toString() {
		return "Kardex [id=" + id + 
				", produto=" + produto.getNome() + 
				", data=" + data + 
				", qtde=" + qtde + 
				", valor=" + valor + "]";
	}


}
	
		