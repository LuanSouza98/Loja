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
	 * Autentica as credenciais do usu�rio
	 * 
	 * @param usuario
	 */

	public void logar(Usuario usuario) {

		// Verifica se o login e a senha est�o nulos
		if (usuario.getLogin().isEmpty() || usuario.getSenha().isEmpty()) {
			System.out.println("Informe usu�rio e senha!");
			JOptionPane.showMessageDialog(null, "Informe usu�rio e senha!");
			return;
		}

		// localDao = new LocalDAO();
		usuarioDao = new UsuarioDAO();

		// Busca usu�rio no banco
		// usuarioBanco = localDao.buscarUsuario(usuario);
		usuarioBanco = usuarioDao.buscarUsuario(usuario);

		// Verifica se o login informado pelo usuario existe no BD
		if (usuarioBanco == null) {
			// Usu�rio n�o encontrado!
			System.out.println("Usu�rio ou senha incorreto!");
			JOptionPane.showMessageDialog(null, "Usu�rio ou senha incorreto!");
			return;
		}

		// Verfica se a senha informada pelo usu�rio est� correta
		if (BCrypt.checkpw(usuario.getSenha(), usuarioBanco.getSenha())) {
			System.out.println("Usu�rio autenticado!");
			JOptionPane.showMessageDialog(null, "Usu�rio autenticado!");

		} else {
			// Senha incorreta
			System.out.println("Senha incorreta!");
			JOptionPane.showMessageDialog(null, "Usu�rio ou senha incorreto!");
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

		// N�o pode existir usuarios com o mesmo login
		if (usuarioBanco != null) {
			System.out.println("Login j� existente!");
			return;
		}

		// Cadastrar usu�rio
		if (usuarioDao.cadastrarUsuario(Utils.criptografarSenha(usuario))) {
			System.out.println("Usu�rio Cadastrado!");
		} else {
			System.out.println("Erro ao cadastrar usu�rio!");
		}

	}

	public void encerrarAplicacao() {

	}

}
