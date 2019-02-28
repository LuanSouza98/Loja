package br.edu.ucsal.loja.teste;

import java.math.BigDecimal;

import br.edu.ucsal.loja.bean.Produto;
import br.edu.ucsal.loja.controller.ProdutoAction;

public class Testeproduto {

	public static void main(String[] args) {

		Produto produto = new Produto("Feijão Carioca", new BigDecimal("4.99"));

		cadastrarProduto(produto);

	}

	public static void cadastrarProduto(Produto produto) {

		ProdutoAction produtoAction = new ProdutoAction();

		produtoAction.cadastrarproduto(produto);

	}

}
