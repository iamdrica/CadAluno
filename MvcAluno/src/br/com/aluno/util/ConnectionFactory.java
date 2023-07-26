package br.com.aluno.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConnectionFactory {
	
	public static Connection getConnection() throws Exception {
		//método getconection não irá tratar erros; quem deve tratar os erros é a tela
		try {
			// indica o database a usar e aponta para o driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// estabelecer a conexão com o banco de dados
			String login = "root";
			String senha = "";
			String url = "jdbc:mysql://localhost:3306/DBALUNO";
			return DriverManager.getConnection(url,login,senha);
			
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public static void main(String[] args) {
		
		try {
		Connection conn = ConnectionFactory.getConnection();
		JOptionPane.showMessageDialog(null, "Database Conectado");
		} catch(Exception e) {
			e.printStackTrace();
		
		}
	}

	public static void closeConnection(Connection conn, PreparedStatement ps) {
		// TODO Auto-generated method stub
		
	}


// fecha uma conexão de três formas: conn, stmt, rs

public static void closeConnection(Connection conn, Statement stmt,
		ResultSet rs) throws Exception {
	close(conn, stmt, rs);
}

public static void closeConnection(Connection conn, Statement stmt)
		throws Exception {
	close(conn, stmt, null);
}

public static void closeConnection(Connection conn) throws Exception {
	close(conn, null, null);
}

private static void close(Connection conn, Statement stmt, ResultSet rs)
		throws Exception {
	try {
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
	} catch (Exception e) {
		throw new Exception(e.getMessage());
	}
}
}

