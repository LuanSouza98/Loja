package br.edu.ucsal.loja.dao.local;

import br.edu.ucsal.loja.bean.Usuario;

public class LocalUsuarioDAO {

	private static Usuario[] ARRAY_USUARIO;

	public LocalUsuarioDAO() {

		if (ARRAY_USUARIO == null) {
			ARRAY_USUARIO = new Usuario[2];
			carregarUsuarios();
		}

	}

	public Usuario buscarUsuario(Usuario usuario) {

		Usuario usuarioBanco = null;

		for (int i = 0; i < ARRAY_USUARIO.length; i++) {
			if (ARRAY_USUARIO[i].getLogin().equals(usuario.getLogin().toUpperCase())) {
				usuarioBanco = ARRAY_USUARIO[i];
				return usuarioBanco;
			}
		}

		return usuarioBanco;

	}

	public void carregarUsuarios() {
		// LOGIN: luans
		// SENHA: luans

		// LOGIN: admin
		// SENHA: 123456

		Usuario usuario1 = new Usuario(1, "ADMINISTRADOR", "ADMIN", "$2a$10$tB1lqvPk7aZPF1327aJ8muFXMXT82GeyVe/3YdhNIqqh7ixi9dUf6");
		Usuario usuario2 = new Usuario(1, "LUAN", "LUANS", "$2a$10$1XycVMkhN572xTj0XKnfde3Sd0BAxnT3XnevFnq7u2baS3ycFlZlS");

		ARRAY_USUARIO[0] = usuario1;
		ARRAY_USUARIO[1] = usuario2;

	}

}
