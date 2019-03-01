package br.edu.ucsal.loja.teste;

import br.edu.ucsal.loja.bean.Usuario;
import br.edu.ucsal.loja.controller.UsuarioAction;

public class TesteUsuario {

	public static void main(String[] args) {

		// Login: admin
		// Senha: 123456

		Usuario usuario = new Usuario("Teste2", "Teste2", "654321");

		//criarNovoUsuario(usuario);

		logar(usuario);

	}

	public static void criarNovoUsuario(Usuario usuario) {

		UsuarioAction usuarioAction = new UsuarioAction();

		usuarioAction.criarUsuario(usuario);

	}

	public static void logar(Usuario usuario) {

		UsuarioAction usuarioAction = new UsuarioAction();

		usuarioAction.logar(usuario);

	}

}
