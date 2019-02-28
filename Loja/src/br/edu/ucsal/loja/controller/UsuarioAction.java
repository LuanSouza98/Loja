package br.edu.ucsal.loja.controller;

import br.edu.ucsal.loja.bean.Usuario;
import br.edu.ucsal.loja.dao.UsuarioDAO;
import br.edu.ucsal.loja.utils.BCrypt;
import br.edu.ucsal.loja.utils.Utils;

public class UsuarioAction {

	private UsuarioDAO usuarioDao;
	private Usuario usuarioBanco;

	/**
	 * Autentica as credenciais do usuário
	 * 
	 * @param usuario
	 */

	public void logar(Usuario usuario) {

		usuarioDao = new UsuarioDAO();

		usuarioBanco = usuarioDao.buscarUsuario(usuario);

		// Verifica se o login informado pelo usuario existe no BD
		if (usuarioBanco == null) {
			System.out.println("Usuário não encontrado!");
			return;
		}

		// Verfica se a senha informada pelo usuário está correta
		if (BCrypt.checkpw(usuario.getSenha(), usuarioBanco.getSenha())) {
			System.out.println("Usuário autenticado!");
		} else {
			System.out.println("Senha incorreta!");
		}

	}

	/**
	 * Cria um novo usuario para acessar o sistema
	 * 
	 * @param usuario
	 */

	public void criarUsuario(Usuario usuario) {

		usuarioDao = new UsuarioDAO();

		// Busca usuario pelo login
		usuarioBanco = usuarioDao.buscarUsuario(usuario);

		// Não pode existir usuarios com o mesmo login
		if (usuarioBanco != null) {
			System.out.println("Login já existente!");
			return;
		}

		// Cadastrar usuário
		if (usuarioDao.cadastrarUsuario(Utils.criptografarSenha(usuario))) {
			System.out.println("Usuário Cadastrado!");
		} else {
			System.out.println("Erro ao cadastrar usuário!");
		}

	}

	public void encerrarAplicacao() {

	}

}
