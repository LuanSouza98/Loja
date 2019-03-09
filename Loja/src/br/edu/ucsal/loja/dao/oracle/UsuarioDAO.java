package br.edu.ucsal.loja.dao.oracle;

import br.edu.ucsal.loja.bean.Usuario;
import br.edu.ucsal.loja.dao.GenericDAO;

/**
 * DAO PARA CONECTAR COM O BANCO DE DADOS DA ORACLE
 * 
 * @author LUAN
 *
 */

public class UsuarioDAO extends GenericDAO {

	public boolean cadastrarUsuario(Usuario usuario) {

		boolean cadastrou = true;

		int i = 0;

		StringBuilder sb = new StringBuilder();

		sb.append(" INSERT INTO TB_USUARIO_USU (				");
		sb.append("		USU_ID,									");
		sb.append("		USU_NOME,								");
		sb.append("		USU_LOGIN,								");
		sb.append("		USU_SENHA								");
		sb.append("	) VALUES ( SEQ_USUARIO.NEXTVAL, ?, ?, ? )	");

		conectarBanco();

		try {

			this.stmt = this.conexao.prepareStatement(sb.toString());
			this.stmt.setString(++i, usuario.getNome().toUpperCase());
			this.stmt.setString(++i, usuario.getLogin().toUpperCase());
			this.stmt.setString(++i, usuario.getSenha());
			this.stmt.executeUpdate();

		} catch (Exception e) {
			System.err.println("ERRO: UsuarioDAO -> cadastrarUsuario: " + e.getMessage());
			cadastrou = false;
		} finally {
			desconectarBanco();
		}

		return cadastrou;

	}

	public Usuario buscarUsuario(Usuario usuario) {

		Usuario usuarioBanco = null;

		int i = 0;

		StringBuilder sb = new StringBuilder();

		sb.append("	SELECT				");
		sb.append("		USU_ID,			");
		sb.append("		USU_NOME,		");
		sb.append("		USU_LOGIN,		");
		sb.append("		USU_SENHA		");
		sb.append("FROM					");
		sb.append("		TB_USUARIO_USU	");
		sb.append("WHERE				");
		sb.append("		USU_LOGIN = ?	");

		conectarBanco();

		try {

			this.stmt = this.conexao.prepareStatement(sb.toString());
			this.stmt.setString(++i, usuario.getLogin().toUpperCase());
			this.rs = this.stmt.executeQuery();

			while (this.rs.next()) {
				usuarioBanco = new Usuario();

				usuarioBanco.setId(this.rs.getInt("USU_ID"));
				usuarioBanco.setNome(this.rs.getString("USU_NOME"));
				usuarioBanco.setLogin(this.rs.getString("USU_LOGIN"));
				usuarioBanco.setSenha(this.rs.getString("USU_SENHA"));

			}

		} catch (Exception e) {
			System.err.println("ERRO: UsuarioDAO -> buscarUsuario: " + e.getMessage());
		} finally {
			desconectarBanco();
		}

		return usuarioBanco;

	}

}
