package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	
	// conexão com sqlite
	private static final String SQLITE = "jdbc:sqlite:" +
			"C:/Projects/JavaProgrammer/Kardex/db/Kardex.db";
	// conexão com mysql
	private static final String MYSQL = "jdbc:mysql:" +
			"//127.0.0.1:3306/kardex";
	private static final String USER = "java";
	private static final String PASSWORD = "java";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			// sqlite
			con = DriverManager.getConnection(SQLITE);
			// mysql
			//con = DriverManager.getConnection(MYSQL,USER,PASSWORD);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}

	public static void closeConnection(Connection con) {
		try {
			if (con != null) con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void closeConnection(Connection con,
									   PreparedStatement pst,
									   ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if (pst != null) pst.close();
			if (con != null) con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}