package br.edu.ucsal.loja.dao.oracle;

import java.util.ArrayList;
import java.util.List;

import br.edu.ucsal.loja.bean.Produto;
import br.edu.ucsal.loja.dao.GenericDAO;

/**
 * DAO PARA CONECTAR COM O BANCO DE DADOS DA ORACLE
 * 
 * @author LUAN
 *
 */

public class ProdutoDAO extends GenericDAO {

	public boolean cadastrarProduto(Produto produto) {

		boolean cadastrou = true;

		int i = 0;

		StringBuilder sb = new StringBuilder();

		sb.append(" INSERT INTO TB_PRODUTO_PRO (				");
		sb.append("		PRO_ID,									");
		sb.append("		PRO_DESCRICAO,							");
		sb.append("		PRO_PRECO								");
		sb.append("	) VALUES ( SEQ_PRODUTO.NEXTVAL, ?, ? )		");

		conectarBanco();

		try {

			this.stmt = this.conexao.prepareStatement(sb.toString());
			this.stmt.setString(++i, produto.getDecricao().toUpperCase());
			this.stmt.setBigDecimal(++i, produto.getPreco());
			this.stmt.executeUpdate();

		} catch (Exception e) {
			System.err.println("ERRO: ProdutoDAO -> cadastrarProduto: " + e.getMessage());
			cadastrou = false;
		} finally {
			desconectarBanco();
		}

		return cadastrou;

	}

	public List<Produto> buscarTodosProdutos() {

		List<Produto> listaProduto = new ArrayList<Produto>();

		Produto produtoBanco;

		StringBuilder sb = new StringBuilder();

		sb.append(" SELECT 					");
		sb.append("		PRO_ID,				");
		sb.append("		PRO_DESCRICAO,		");
		sb.append("		PRO_PRECO			");
		sb.append("	FROM					");
		sb.append("		TB_PRODUTO_PRO		");

		conectarBanco();

		try {

			this.stmt = this.conexao.prepareStatement(sb.toString());
			this.rs = this.stmt.executeQuery();

			while (this.rs.next()) {
				produtoBanco = new Produto();

				produtoBanco.setId(this.rs.getInt("PRO_ID"));
				produtoBanco.setDecricao(this.rs.getString("PRO_DESCRICAO"));
				produtoBanco.setPreco(this.rs.getBigDecimal("PRO_PRECO"));

				listaProduto.add(produtoBanco);

			}

		} catch (Exception e) {
			System.err.println("ERRO: ProdutoDAO -> buscarTodosProdutos: " + e.getMessage());
		} finally {
			desconectarBanco();
		}

		return listaProduto;

	}

	public List<Produto> buscarProdutoPelaDescricao(Produto produto) {

		List<Produto> listaProduto = new ArrayList<Produto>();

		Produto produtoBanco;

		int i = 0;

		StringBuilder sb = new StringBuilder();

		sb.append(" SELECT 						");
		sb.append("		PRO_ID,					");
		sb.append("		PRO_DESCRICAO,			");
		sb.append("		PRO_PRECO				");
		sb.append("	FROM						");
		sb.append("		TB_PRODUTO_PRO			");
		sb.append("	WHERE						");
		sb.append("		PRO_DESCRICAO LIKE ?	");

		conectarBanco();

		try {

			this.stmt = this.conexao.prepareStatement(sb.toString());
			this.stmt.setString(++i, produto.getDecricao().toUpperCase() + "%");
			this.rs = this.stmt.executeQuery();

			while (this.rs.next()) {
				produtoBanco = new Produto();

				produtoBanco.setId(this.rs.getInt("PRO_ID"));
				produtoBanco.setDecricao(this.rs.getString("PRO_DESCRICAO"));
				produtoBanco.setPreco(this.rs.getBigDecimal("PRO_PRECO"));

				listaProduto.add(produtoBanco);

			}

		} catch (Exception e) {
			System.err.println("ERRO: ProdutoDAO -> buscarTodosProdutos: " + e.getMessage());
		} finally {
			desconectarBanco();
		}

		return listaProduto;

	}

	public Produto buscarProdutoPeloId(Produto produto) {

		// List<Produto> listaProduto = new ArrayList<Produto>();

		Produto produtoBanco = null;

		int i = 0;

		StringBuilder sb = new StringBuilder();

		sb.append(" SELECT 						");
		sb.append("		PRO_ID,					");
		sb.append("		PRO_DESCRICAO,			");
		sb.append("		PRO_PRECO				");
		sb.append("	FROM						");
		sb.append("		TB_PRODUTO_PRO			");
		sb.append("	WHERE						");
		sb.append("		PRO_ID = ?				");

		conectarBanco();

		try {

			this.stmt = this.conexao.prepareStatement(sb.toString());
			this.stmt.setInt(++i, produto.getId());
			this.rs = this.stmt.executeQuery();

			while (this.rs.next()) {
				produtoBanco = new Produto();

				produtoBanco.setId(this.rs.getInt("PRO_ID"));
				produtoBanco.setDecricao(this.rs.getString("PRO_DESCRICAO"));
				produtoBanco.setPreco(this.rs.getBigDecimal("PRO_PRECO"));

				// listaProduto.add(produtoBanco);

			}

		} catch (Exception e) {
			System.err.println("ERRO: ProdutoDAO -> buscarTodosProdutos: " + e.getMessage());
		} finally {
			desconectarBanco();
		}

		return produtoBanco;

	}

}
