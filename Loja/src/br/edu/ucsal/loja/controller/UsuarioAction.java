package br.edu.ucsal.loja.controller;

import javax.swing.JOptionPane;

import br.edu.ucsal.loja.bean.Usuario;
import br.edu.ucsal.loja.dao.LocalDAO;
import br.edu.ucsal.loja.dao.mysql.UsuarioDAO;
import br.edu.ucsal.loja.utils.BCrypt;
import br.edu.ucsal.loja.utils.Utils;

public class UsuarioAction {

	private UsuarioDAO usuarioDao;
	private Usuario usuarioBanco;
	private LocalDAO localDao;

	/**
	 * Autentica as credenciais do usuário
	 * 
	 * @param usuario
	 */

	public void logar(Usuario usuario) {

		// Verifica se o login e a senha estão nulos
		if (usuario.getLogin().isEmpty() || usuario.getSenha().isEmpty()) {
			System.out.println("Informe usuário e senha!");
			JOptionPane.showMessageDialog(null, "Informe usuário e senha!");
			return;
		}

		// localDao = new LocalDAO();
		usuarioDao = new UsuarioDAO();

		// Busca usuário no banco
		// usuarioBanco = localDao.buscarUsuario(usuario);
		usuarioBanco = usuarioDao.buscarUsuario(usuario);

		// Verifica se o login informado pelo usuario existe no BD
		if (usuarioBanco == null) {
			// Usuário não encontrado!
			System.out.println("Usuário ou senha incorreto!");
			JOptionPane.showMessageDialog(null, "Usuário ou senha incorreto!");
			return;
		}

		// Verfica se a senha informada pelo usuário está correta
		if (BCrypt.checkpw(usuario.getSenha(), usuarioBanco.getSenha())) {
			System.out.println("Usuário autenticado!");
			JOptionPane.showMessageDialog(null, "Usuário autenticado!");

		} else {
			// Senha incorreta
			System.out.println("Senha incorreta!");
			JOptionPane.showMessageDialog(null, "Usuário ou senha incorreto!");
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
