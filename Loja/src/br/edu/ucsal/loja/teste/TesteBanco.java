package br.edu.ucsal.loja.teste;

import br.edu.ucsal.loja.utils.Utils;

public class TesteBanco {

	public static void main(String[] args) {

		if (Utils.testarConexaoBanco()) {
			System.out.println("Conectado com sucesso!");
		} else {
			System.out.println("Falha ao conectar");
		}

	}

}
