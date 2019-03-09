package br.edu.ucsal.loja.dao;

import br.edu.ucsal.loja.bean.Produto;

public class ProdutoDAO extends GenericDAO {

	public boolean cadastrarUsuario(Produto produto) {

		boolean cadastrou = true;

		int i = 0;

		StringBuilder sb = new StringBuilder();

		sb.append(" INSERT INTO TB_USUARIO_USU (				");
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
			System.out.println("UsuarioDAO -> cadastrarUsuario -> Erro ao cadastrar usuario: " + e.getMessage());
			cadastrou = false;
		} finally {
			desconectarBanco();
		}

		return cadastrou;

	}

}
