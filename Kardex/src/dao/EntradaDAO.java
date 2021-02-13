package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.Entrada;
import model.Fornecedor;
import model.Produto;
import util.Converter;

/**
 * A classe EntradaDAO provê a comunicação da classe model.Entrada com o banco
 * de dados. É responsável também pelo mapeamento O/R da classe.
 * 
 * @author Ricardo Drudi
 * @see model.Entrada
 * @see <a href="http://conectadamente.com/pages/java/javaOOPPersistencia.html">
 *      Mapeamento Objeto Relacional</a>
 * 
 */
public class EntradaDAO implements DAO<Entrada> {

	/**
	 * Gera a persistência da Entrada r no banco de dados.
	 * 
	 * @param r Um objeto da classe Entrada
	 */
	@Override
	public void insert(Entrada r) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "INSERT INTO entrada " + 
					 "(produto,fornecedor,data," + 
					 "doc,qtde,valor) " + 
					 "VALUES (?,?,?,?,?,?) ";
		try {
			con = ConnectionFactory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, r.getProduto().getId());
			pst.setInt(2, r.getFornecedor().getId());
			pst.setString(3, Converter.date2bd(r.getData()));
			pst.setString(4, r.getDoc());
			pst.setInt(5, r.getQtde());
			pst.setDouble(6, r.getValor());
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, pst, rs);
		}
	}

	/**
	 * Atualiza os valores da Entrada r no banco de dados.
	 * 
	 * @param r Um objeto da classe Entrada
	 */
	public void update(Entrada r) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "UPDATE entrada SET " + 
					 "produto = ?, " + 
					 "fornecedor = ?, " + 
					 "data = ?, " + 
					 "doc = ?, " + 
					 "qtde = ?, " + 
					 "valor = ? " + 
					 "WHERE id = ? ";
		try {
			con = ConnectionFactory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, r.getProduto().getId());
			pst.setInt(2, r.getFornecedor().getId());
			pst.setString(3, Converter.date2bd(r.getData()));
			pst.setString(4, r.getDoc());
			pst.setInt(5, r.getQtde());
			pst.setDouble(6, r.getValor());
			pst.setInt(7, r.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, pst, rs);
		}
	}

	/**
	 * Exclui um registro de Entrada no banco de dados.
	 * 
	 * @param r Um objeto da classe Entrada
	 */
	public void delete(Entrada r) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "DELETE FROM entrada " + 
					 "WHERE id = ? ";
		try {
			con = ConnectionFactory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, r.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, pst, rs);
		}
	}

	/**
	 * Retorna a lista de entrada lançadas no banco de dados.
	 * 
	 * @return O ArrayList com objetos Entrada.
	 */
	@Override
	public ArrayList<Entrada> select() {
		ArrayList<Entrada> lista = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT id,produto,fornecedor, " + "data,doc,qtde,valor " + "FROM entrada " + "ORDER BY data ";
		try {
			con = ConnectionFactory.getConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				int codigo = rs.getInt(1);
				int codProduto = rs.getInt(2);
				int codFornecedor = rs.getInt(3);
				Date data = Converter.str2date(rs.getString(4));
				String doc = rs.getString(5);
				int qtde = rs.getInt(6);
				double valor = rs.getDouble(7);
				Produto produto = new ProdutoDAO().select(codProduto);
				Fornecedor fornecedor = new FornecedorDAO().select(codFornecedor);
				lista.add(new Entrada(codigo, produto, fornecedor, data, doc, qtde, valor));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, pst, rs);
		}
		return lista;
	}

	/**
	 * Pesquisa a entrada com código informado no banco de dados. Se encontrar,
	 * retorna um objeto do tipo Entrada. Caso o código não exista no banco de
	 * dados, retorna null.
	 * 
	 * @return Um objeto do tipo Entrada
	 */
	public Entrada select(int id) {
		Entrada entrada = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT * " + "FROM entrada " + "WHERE id = ? ";
		try {
			con = ConnectionFactory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				int codigo = rs.getInt(1);
				int codProduto = rs.getInt(2);
				int codFornecedor = rs.getInt(3);
				Date data = Converter.str2date(rs.getString(4));
				String doc = rs.getString(5);
				int qtde = rs.getInt(6);
				double valor = rs.getDouble(7);
				Produto produto = new ProdutoDAO().select(codProduto);
				Fornecedor fornecedor = new FornecedorDAO().select(codFornecedor);
				entrada = new Entrada(codigo, produto, fornecedor, data, doc, qtde, valor);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, pst, rs);
		}
		return entrada;
	}

	/**
	 * Retorna a lista de entradas de um mesmo produto
	 * registradas no banco de dados.
	 * 
	 * @return O ArrayList com objetos Entrada.
	 */
	public ArrayList<Entrada> select(Produto p) {
		ArrayList<Entrada> lista = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT id,produto,fornecedor, " + 
					 "data,doc,qtde,valor " + 
					 "FROM entrada " +
					 "WHERE produto = ? " +
					 "ORDER BY data ";
		try {
			con = ConnectionFactory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1,p.getId());
			rs = pst.executeQuery();
			while (rs.next()) {
				int codigo = rs.getInt(1);
				int codProduto = rs.getInt(2);
				int codFornecedor = rs.getInt(3);
				Date data = Converter.str2date(rs.getString(4));
				String doc = rs.getString(5);
				int qtde = rs.getInt(6);
				double valor = rs.getDouble(7);
				Produto produto = new ProdutoDAO().select(codProduto);
				Fornecedor fornecedor = new FornecedorDAO().select(codFornecedor);
				lista.add(new Entrada(codigo, produto, fornecedor, data, doc, qtde, valor));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, pst, rs);
		}
		return lista;
	}
}