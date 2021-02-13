package dao;


	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.Date;
	import model.Cliente;
	import model.Cliente;
	import model.Produto;
	import model.Saida;
	import util.Converter;

	public class SaidaDAO implements DAO<Saida> {

		/**
		 * Gera a persistência da Saida r no banco de dados.
		 * 
		 * @param r Um objeto da classe Saida
		 */
		@Override
		public void insert(Saida r) {
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			String sql = "INSERT INTO Saida " + 
						 "(produto,cliente,data," + 
						 "doc,qtde,valor) " + 
						 "VALUES (?,?,?,?,?,?) ";
			try {
				con = ConnectionFactory.getConnection();
				pst = con.prepareStatement(sql);
				pst.setInt(1, r.getProduto().getId());
				pst.setInt(2, r.getCliente().getId());
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
		 * Atualiza os valores da Saida r no banco de dados.
		 * 
		 * @param r Um objeto da classe Saida
		 */
		public void update(Saida r) {
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			String sql = "UPDATE Saida SET " + 
						 "produto = ?, " + 
						 "cliente = ?, " + 
						 "data = ?, " + 
						 "doc = ?, " + 
						 "qtde = ?, " + 
						 "valor = ? " + 
						 "WHERE id = ? ";
			try {
				con = ConnectionFactory.getConnection();
				pst = con.prepareStatement(sql);
				pst.setInt(1, r.getProduto().getId());
				pst.setInt(2, r.getCliente().getId());
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
		 * Exclui um registro de Saida no banco de dados.
		 * 
		 * @param r Um objeto da classe Saida
		 */
		public void delete(Saida r) {
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			String sql = "DELETE FROM Saida " + 
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
		 * Retorna a lista de Saida lançadas no banco de dados.
		 * 
		 * @return O ArrayList com objetos Saida.
		 */
		@Override
		public ArrayList<Saida> select() {
			ArrayList<Saida> lista = new ArrayList<>();
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			String sql = "SELECT id,produto,cliente,data,doc,qtde,valor " + 
						 "FROM Saida " + 
						 "ORDER BY data ";
			try {
				con = ConnectionFactory.getConnection();
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
				while (rs.next()) {
					int codigo = rs.getInt(1);
					int codProduto = rs.getInt(2);
					int codCliente = rs.getInt(3);
					Date data = Converter.str2date(rs.getString(4));
					String doc = rs.getString(5);
					int qtde = rs.getInt(6);
					double valor = rs.getDouble(7);
					Produto produto = new ProdutoDAO().select(codProduto);
					Cliente cliente = new ClienteDAO().select(codCliente);
					lista.add(new Saida(codigo, produto, cliente, data, doc, qtde, valor));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				ConnectionFactory.closeConnection(con, pst, rs);
			}
			return lista;
		}

		/**
		 * Pesquisa a Saida com código informado no banco de dados. Se encontrar,
		 * retorna um objeto do tipo Saida. Caso o código não exista no banco de
		 * dados, retorna null.
		 * 
		 * @return Um objeto do tipo Saida
		 */
		public Saida select(int id) {
			Saida Saida = null;
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			String sql = "SELECT id,produto,cliente,data,doc,qtde,valor " + 
						 "FROM Saida " + 
						 "WHERE id = ? ";
			try {
				con = ConnectionFactory.getConnection();
				pst = con.prepareStatement(sql);
				pst.setInt(1, id);
				rs = pst.executeQuery();
				if (rs.next()) {
					int codigo = rs.getInt(1);
					int codProduto = rs.getInt(2);
					int codCliente = rs.getInt(3);
					Date data = Converter.str2date(rs.getString(4));
					String doc = rs.getString(5);
					int qtde = rs.getInt(6);
					double valor = rs.getDouble(7);
					Produto produto = new ProdutoDAO().select(codProduto);
					Cliente cliente = new ClienteDAO().select(codCliente);
					Saida = new Saida(codigo, produto, cliente, data, doc, qtde, valor);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				ConnectionFactory.closeConnection(con, pst, rs);
			}
			return Saida;
		}

		/**
		 * Retorna a lista de Saidas de um mesmo produto
		 * registradas no banco de dados.
		 * 
		 * @return O ArrayList com objetos Saida.
		 */
		public ArrayList<Saida> select(Produto p) {
			ArrayList<Saida> lista = new ArrayList<>();
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			String sql = "SELECT id,produto,cliente,data,doc,qtde,valor " + 
						 "FROM Saida " +
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
					int codCliente = rs.getInt(3);
					Date data = Converter.str2date(rs.getString(4));
					String doc = rs.getString(5);
					int qtde = rs.getInt(6);
					double valor = rs.getDouble(7);
					Produto produto = new ProdutoDAO().select(codProduto);
					Cliente cliente = new ClienteDAO().select(codCliente);
					lista.add(new Saida(codigo, produto, cliente, data, doc, qtde, valor));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				ConnectionFactory.closeConnection(con, pst, rs);
			}
			return lista;
		}
}
