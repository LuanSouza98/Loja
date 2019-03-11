package br.edu.ucsal.loja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GenericDAO {

	// private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	// private static final String URL = "jdbc:oracle:thin:@172.30.0.25:1521:desv";
	// private static final String USER = "luan";
	// private static final String PASSWORD = "luan.2018";

	private static final String URL = "jdbc:mysql://localhost:3306/db_loja?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "12345";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	protected Connection conexao = null;
	protected PreparedStatement stmt = null;
	protected ResultSet rs = null;

	public Connection conectarBanco() {

		try {

			Class.forName(DRIVER);

			if (conexao == null || conexao.isClosed()) {
				conexao = DriverManager.getConnection(URL, USER, PASSWORD);
			}

		} catch (Exception e) {
			System.err.println("ERRO: GenericDAO -> conectarBanco -> Erro ao conectar no banco: " + e.getMessage());

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

		} catch (Exception e) {
			System.err.println("ERRO: GenericDAO -> desconectarBanco -> Erro ao desconectar banco: " + e.getMessage());
		}

	}

	public boolean testarConexaoBanco() {

		boolean conectado = false;

		try {

			Connection con = conectarBanco();

			if (con != null) {
				conectado = true;
			}

		} catch (Exception e) {
			System.err.println("ERRO: GenericDAO -> testarConexaoBanco -> Erro ao testar conexão com banco: " + e.getMessage());
		} finally {
			desconectarBanco();
		}

		return conectado;

	}

}
