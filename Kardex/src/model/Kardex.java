package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import dao.EntradaDAO;
import dao.SaidaDAO;
import util.Converter;

/*
 * implementar:
 * 		- atributos private
 * 		- construtor vazio
 * 		- construtor completo
 * 		- getters / setters atributos
 * 		- toString(): id, nome do produto, data, qtde, valor
 * validações:
 * 		- id não pode ser setado manualmente - somente por construtor
 * 		- produto não pode ser nulo
 * 		- doc: pode ser vazio, não pode ser brancos, se não for vazio
 * 			   tem que ter pelo menos 3 caracteres
 * 		- qtde: deve estar entre 1 e 1000
 * 		- valor: deve estar entre 0.01 e 10_000.00
 */

public abstract class Kardex {

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

	public static ArrayList<Kardex> getListaKardex(Produto produto) {
		ArrayList<Kardex> lista = new ArrayList<>();
		for (Entrada e : new EntradaDAO().select(produto)) {
			lista.add(e);
		}

		for (Saida s : new SaidaDAO().select(produto)) {
			lista.add(s);
		}
		// ordena por data o arraylist de entradas + sa�das
		Collections.sort(lista, (a, b) -> a.getData().compareTo(b.getData()));
		return lista;
	}

	public static DefaultTableModel getTableModel(Produto produto) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Tipo");
		modelo.addColumn("Data");
		modelo.addColumn("Nome");
		modelo.addColumn("Docto");
		modelo.addColumn("Qtde");
		modelo.addColumn("Valor");
		for (Kardex k : getListaKardex(produto)) {
			if (k instanceof Entrada) {
				Entrada e = (Entrada) k; // downcasting
				String[] str = { "E",Converter.date2dmy(e.getData()),
						e.getFornecedor().getNome(), e.getDoc(), String.valueOf(e.getQtde()),
						String.valueOf(e.getValor()) };
				modelo.addRow(str);
			}
			if (k instanceof Saida) {
				Saida s = (Saida) k; // downcasting
				String[] str = { "S",Converter.date2dmy(s.getData()),
						s.getCliente().getNome(), s.getDoc(), String.valueOf(s.getQtde()),
						String.valueOf(s.getValor()) };
				modelo.addRow(str);
			}

		}
		return modelo;
	}	
	@Override
	public String toString() {
		return "Kardex [id=" + id + 
				", produto=" + produto.getNome() + 
				//", data=" + data + 
				", qtde=" + qtde + 
				", valor=" + valor + "]";
	}

}