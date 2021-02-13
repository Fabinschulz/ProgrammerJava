package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import dao.DAO;
import dao.EntradaDAO;
import dao.ProdutoDAO;
import util.Converter;

public class Produto {

	private int id;
	private String nome;
	private String localizacao;
	private int qtdeMaxima;
	private int qtdeMinima;
	private int qtdeEstoque;
	private static ArrayList<Produto> lista = new ArrayList<>();
	public static final String ARQUIVO_PRODUTOS = "C:/Projects/JavaProgrammer/Kardex/db/Produtos.csv";

	public Produto(String nome, String localizacao, 
		       int qtdeMaxima, int qtdeMinima, 
		       int qtdeEstoque) {
		super();
		setId(0);
		setNome(nome);
		setLocalizacao(localizacao);
		if ((qtdeMaxima < 1) || (qtdeMaxima > 1000))
			qtdeMaxima = 100; // valor default
		setQtdeMaxima(qtdeMaxima);
		setQtdeMinima(qtdeMinima);
		setQtdeEstoque(qtdeEstoque);
		gravar();
	}
	
	public Produto(int id, String nome, String localizacao, 
			       int qtdeMaxima, int qtdeMinima, 
			       int qtdeEstoque) {
		super();
		setId(id);
		setNome(nome);
		setLocalizacao(localizacao);
		setQtdeMaxima(qtdeMaxima);
		setQtdeMinima(qtdeMinima);
		setQtdeEstoque(qtdeEstoque);
	}

	private void gravar() {
		DAO dao = new ProdutoDAO();
		dao.insert(this);
		// Persistencia em arquivo CSV
		//lista.add(this);
		//gravaCSV();
	}

	/*
	 * O método gravaCSV deve estar na classe ProdutoDAO,
	 * pois uma classe model não deve fazer persistência
	 * de dados pois não deve ter conexão com objetos
	 * fora do sistema.
	 */
	private void gravaCSV() {
		try {
			FileWriter fw = new FileWriter(ARQUIVO_PRODUTOS);
			BufferedWriter bw = new BufferedWriter(fw);
			// gravar o cabeçalho
			bw.write("id,"+
					 "nome,"+
					 "localizacao,"+
					 "qtdeMaxima,"+
					 "qtdeMinima,"+
					 "qtdeEstoque\n");
			for (Produto p : getLista()) {
				bw.write(p.getId() + ",");
				bw.write(p.getNome() + ",");
				bw.write(p.getLocalizacao() + ",");
				bw.write(p.getQtdeMaxima() + ",");
				bw.write(p.getQtdeMinima() + ",");
				bw.write(p.getQtdeEstoque() + "\n");
			}
			// fechar o arquivo
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static ArrayList<Produto> getLista() {
		return (new ProdutoDAO().select());
		//return lista;
	}

	public static DefaultTableModel getTableModel() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Nome");
		modelo.addColumn("Localização");
		modelo.addColumn("Mínimo");
		modelo.addColumn("Máximo");
		modelo.addColumn("Estoque");
		ProdutoDAO dao = new ProdutoDAO();
		for (Produto p: dao.select()) {
			String[] row = { String.valueOf(p.getId()),
							 p.getNome(),
							 p.getLocalizacao(),
							 String.valueOf(p.getQtdeMinima()),
							 String.valueOf(p.getQtdeMaxima()),
							 String.valueOf(p.getQtdeEstoque())
							};
			modelo.addRow(row);
		}
		return modelo;
	}
	
	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.isEmpty()) {
			throw new IllegalArgumentException("Nome do produto vazio!");
		} else if (nome.isBlank()) {
			throw new IllegalArgumentException("Nome do produto em branco!");
		} else if (nome.length() < 5) {
			throw new IllegalArgumentException("Nome deve ter mais de 4 letras!");
		} else {
			this.nome = nome;
		}
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public int getQtdeMaxima() {
		return qtdeMaxima;
	}

	public void setQtdeMaxima(int qtdeMaxima) {
		if ((qtdeMaxima < 1) || (qtdeMaxima > 1000)) {
			throw new IllegalArgumentException("Deve estar entre 1 e 1000!");
		} else {
			this.qtdeMaxima = qtdeMaxima;
		}
	}

	public int getQtdeMinima() {
		return qtdeMinima;
	}

	public void setQtdeMinima(int qtdeMinima) {
		if ((qtdeMinima < 0) || (qtdeMinima > 100)) {
			throw new IllegalArgumentException("Deve estar entre 0 e 100!");
		}
		this.qtdeMinima = qtdeMinima;
	}

	public int getQtdeEstoque() {
		return qtdeEstoque;
	}

	private void setQtdeEstoque(int qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}

	public void entrada(Entrada entrada) {
		int qtde = getQtdeEstoque();
		qtde = qtde + entrada.getQtde();
		setQtdeEstoque(qtde);
	}

	public void saida(Saida saida) {
		int qtde = getQtdeEstoque();
		qtde = qtde - saida.getQtde();
		setQtdeEstoque(qtde);
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", qtdeEstoque=" + qtdeEstoque + "]";
	}

}