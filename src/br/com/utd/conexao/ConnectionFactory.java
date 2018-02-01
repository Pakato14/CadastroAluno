package br.com.utd.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection("jdbc:mysql://localhost/cadastroutd?useSSL=false", "root", "1406Ol1v31r4");
			} catch (SQLException e) {
				throw new RuntimeException(e);
				}
		}
	}
