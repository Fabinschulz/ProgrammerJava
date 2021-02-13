package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Fornecedor;
import model.Produto;

/**
 * A classe ProdutoDAO provê a comunicação da classe model.Produto com o banco
 * de dados. É responsável também pelo mapeamento O/R da classe.
 * 
 * @author Ricardo Drudi
 * @see model.Produto
 * @see <a href="http://conectadamente.com/pages/java/javaOOPPersistencia.html">
 *      Mapeamento Objeto Relacional</a>
 * 
 */
public class ProdutoDAO implements DAO<Produto> {

	/**
	 * Gera a persistência do Produto r no banco de dados.
	 * 
	 * @param r Um objeto da classe Produto
	 */
	@Override
	public void insert(Produto r) {
		Connection con = null; // conexão com o bd
		PreparedStatement pst = null; // statement sql
		ResultSet rs = null; // retorno do bd
		String sql = "INSERT INTO produto " + 
					 "(nome,localizacao,qtdeminima,qtdemaxima,qtdeestoque)" + 
					 "VALUES (?,?,?,?,?)";
		try {
			con = ConnectionFactory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, r.getNome());
			pst.setString(2, r.getLocalizacao());
			pst.setInt(3, r.getQtdeMinima());
			pst.setInt(4, r.getQtdeMaxima());
			pst.setInt(5, r.getQtdeEstoque());
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, pst, rs);
		}
	}

	/**
	 * Retorna a lista de produtos cadastrados no 
	 * banco de dados.
	 * 
	 * @return O ArrayList com objetos Produto.
	 */
	@Override
	public ArrayList<Produto> select() {
		ArrayList<Produto> lista = new ArrayList<>();
		Connection con = null;  // conexão com o bd
		PreparedStatement pst = null;  // statement sql
		ResultSet rs = null;  // retorno do bd
		String sql = "SELECT id,nome,localizacao, " +
					 "qtdeminima,qtdemaxima,qtdeestoque " +
					 "FROM produto " +
					 "ORDER BY nome ";
		try {
			con = ConnectionFactory.getConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				int codigo = rs.getInt(1);
				String nome = rs.getString(2);
				String localizacao = rs.getString(3);
				int qtdeMinima = rs.getInt(4);
				int qtdeMaxima = rs.getInt(5);
				int qtdeEstoque = rs.getInt(6);
				lista.add(new Produto(codigo,nome,localizacao,
						  qtdeMaxima,qtdeMinima,qtdeEstoque));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con,pst,rs);
		}
		return lista;
	}

	/**
	 * Pesquisa o produto com código informado
	 * no banco de dados. Se encontrar, retorna
	 * um objeto do tipo Produto. Caso o código não 
	 * existe no banco de dados, retorna null.
	 * 
	 * @return Um objeto do tipo Produto
	 */	
	public Produto select(int id) {
		Produto produto = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT id,nome,localizacao, " +
					 "qtdeminima,qtdemaxima,qtdeestoque " +
					 "FROM produto " +
					 "WHERE id = ? ";
		try {
			con = ConnectionFactory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				int codigo = rs.getInt(1);
				String nome = rs.getString(2);
				String localizacao = rs.getString(3);
				int qtdeMinima = rs.getInt(4);
				int qtdeMaxima = rs.getInt(5);
				int qtdeEstoque = rs.getInt(6);
				produto = new Produto(codigo,nome,localizacao,
						  qtdeMaxima,qtdeMinima,qtdeEstoque);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con,pst,rs);
		}
		return produto;
	}

}
