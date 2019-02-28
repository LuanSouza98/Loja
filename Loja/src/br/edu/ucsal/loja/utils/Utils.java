package br.edu.ucsal.loja.utils;

import br.edu.ucsal.loja.bean.Usuario;

public class Utils {

	public static Usuario criptografarSenha(Usuario usuario) {

		// Gera um sal aleat�rio
		String salGerado = BCrypt.gensalt();

		// Gera a senha hasheada utilizando o sal gerado
		String senhaHasheada = BCrypt.hashpw(usuario.getSenha(), salGerado);

		// Atualiza a senha do usu�rio
		usuario.setSenha(senhaHasheada);

		return usuario;

	}

}
