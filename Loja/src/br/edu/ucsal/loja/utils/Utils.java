package br.edu.ucsal.loja.utils;

import br.edu.ucsal.loja.bean.Usuario;
import br.edu.ucsal.loja.dao.GenericDAO;

public class Utils {

	public static Usuario criptografarSenha(Usuario usuario) {

		// Gera um sal aleatório
		String salGerado = BCrypt.gensalt();

		// Gera a senha hasheada utilizando o sal gerado
		String senhaHasheada = BCrypt.hashpw(usuario.getSenha(), salGerado);

		// Atualiza a senha do usuário
		usuario.setSenha(senhaHasheada);

		return usuario;

	}

	public static boolean testarConexaoBanco() {

		return new GenericDAO().testarConexaoBanco();

	}

}
