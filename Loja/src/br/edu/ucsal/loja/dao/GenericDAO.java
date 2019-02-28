package br.edu.ucsal.loja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenericDAO {
	// oracle.jdbc.driver.OracleDriver
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@172.30.0.25:1521:desv";
	private static final String USER = "luan";
	private static final String PASSWORD = "luan.2018";

	protected Connection conexao = null;
	protected PreparedStatement stmt = null;
	protected ResultSet rs = null;

	public Connection conectarBanco() {

		try {

			Class.forName(DRIVER);

			if (conexao == null || conexao.isClosed()) {
				conexao = DriverManager.getConnection(URL, USER, PASSWORD);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return conexao;

	}

	public void desconectarBanco() {

		try {
			if (conexao != null) {
				this.conexao.close();
				conexao = null;
			}

			if (stmt != null) {
				this.stmt.close();
				stmt = null;
			}

			if (rs != null) {
				this.rs.close();
				rs = null;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}
