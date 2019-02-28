package br.edu.ucsal.loja.dao;

import br.edu.ucsal.loja.bean.Usuario;

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
			System.out.println("UsuarioDAO -> cadastrarUsuario -> Erro ao cadastrar usuario: " + e.getMessage());
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

			while (rs.next()) {
				usuarioBanco = new Usuario();

				usuarioBanco.setId(this.rs.getInt("USU_ID"));
				usuarioBanco.setNome(this.rs.getString("USU_NOME"));
				usuarioBanco.setLogin(this.rs.getString("USU_LOGIN"));
				usuarioBanco.setSenha(this.rs.getString("USU_SENHA"));

			}

		} catch (Exception e) {
			System.out.println("UsuarioDAO -> buscarUsuario -> Erro ao buscar usuario: " + e.getMessage());
		} finally {
			desconectarBanco();
		}

		return usuarioBanco;

	}

}
