package br.com.pix.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private final String URL = "jdbc:mysql://localhost/dicionario_dados";
	private final String USER = "root";
	private final String PASS = "admin";

	public Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
