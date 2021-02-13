package dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;

	import model.Cliente;

	public class ClienteDAO implements DAO<Cliente>{

		/**
		 * Gera a persistência do Cliente r no 
		 * banco de dados.
		 * 
		 * @param r Um objeto da classe Cliente
		 */
		public void insert (Cliente r) {
			/**
			 * O Connection con é responsável pela 
			 * conexão com o banco de dados.
			 */
			Connection con = null;  // conexão com o bd
			PreparedStatement pst = null;  // statement sql
			ResultSet rs = null;  // retorno do bd
			String sql = "INSERT INTO Cliente " +
						 "(cpf,nome,celular,email)" + 
						 "VALUES (?,?,?,?)";  // comando para inserção
			try {
				con = ConnectionFactory.getConnection();
				pst = con.prepareStatement(sql);
				pst.setString(1,r.getCpf());
				pst.setString(2,r.getNome());
				pst.setString(3,r.getCelular());
				pst.setString(4,r.getEmail());
				pst.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				ConnectionFactory.closeConnection(con,pst,rs);
			}
		}
		
		/**
		 * Retorna a lista de Clientees 
		 * cadastrados no banco de dados.
		 * 
		 * @return O ArrayList com objetos Cliente.
		 */
		public ArrayList<Cliente> select () {
			ArrayList<Cliente> lista = new ArrayList<>();
			Connection con = null;  // conexão com o bd
			PreparedStatement pst = null;  // statement sql
			ResultSet rs = null;  // retorno do bd
			String sql = "SELECT id,cpf,nome,celular,email " +
						 "FROM Cliente ";
			try {
				con = ConnectionFactory.getConnection();
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
				while (rs.next()) {
					int codigo = rs.getInt(1);
					String cpf = rs.getString(2);
					String nome = rs.getString(3);
					String celular = rs.getString(4);
					String email = rs.getString(5);
					lista.add(new Cliente(codigo,cpf,nome,celular,email));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				ConnectionFactory.closeConnection(con,pst,rs);
			}
			return lista;
		}

		/**
		 * Pesquisa o Cliente com código informado
		 * no banco de dados. Se encontrar, retorna
		 * um objeto do tipo Cliente. Caso o código não 
		 * existe no banco de dados, retorna null.
		 * 
		 * @return Um objeto do tipo Cliente
		 */
		public Cliente select(int id) {
			Cliente Cliente = null;
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			String sql = "SELECT id,cpf,nome,celular,email " +
						 "FROM Cliente " +
						 "WHERE id = ? ";
			try {
				con = ConnectionFactory.getConnection();
				pst = con.prepareStatement(sql);
				pst.setInt(1, id);
				rs = pst.executeQuery();
				if (rs.next()) {
					int codigo = rs.getInt(1);
					String cpf = rs.getString(2);
					String nome = rs.getString(3);
					String celular = rs.getString(4);
					String email = rs.getString(5);
					Cliente = new Cliente(codigo,cpf,nome,celular,email);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				ConnectionFactory.closeConnection(con,pst,rs);
			}
			return Cliente;
		}
		
}
