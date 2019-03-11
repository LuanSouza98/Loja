package br.edu.ucsal.loja.dao.mysql;

import java.util.ArrayList;
import java.util.List;

import br.edu.ucsal.loja.bean.Cliente;
import br.edu.ucsal.loja.bean.Usuario;
import br.edu.ucsal.loja.dao.GenericDAO;

public class ClienteDAO extends GenericDAO {

	public boolean cadastrarCliente(Cliente cliente) {

		boolean cadastrou = true;

		int i = 0;

		StringBuilder sb = new StringBuilder();

		sb.append(" INSERT INTO DB_LOJA.TB_CLIENTE_CLI (		");
		sb.append("		CLI_NOME,								");
		sb.append("		CLI_CPF,								");
		sb.append("		CLI_TELEFONE,							");
		sb.append("		CLI_CELULAR,							");
		sb.append("		CLI_EMAIL,								");
		sb.append("		CLI_IDENDERECO							");
		sb.append("	) VALUES ( ?, ?, ?, ?, ?, ?)				");

		conectarBanco();

		try {

			int idEndereco = cadastrarEndereco(cliente);

			this.stmt = this.conexao.prepareStatement(sb.toString());
			this.stmt.setString(++i, cliente.getNome().toUpperCase());
			this.stmt.setString(++i, cliente.getCpf());
			this.stmt.setString(++i, cliente.getTelefone());
			this.stmt.setString(++i, cliente.getCelular());
			this.stmt.setString(++i, cliente.getEmail());
			this.stmt.setInt(++i, idEndereco);

			this.stmt.executeUpdate();

		} catch (Exception e) {
			System.err.println("ClienteDAO -> cadastrarCliente -> Erro ao cadastrar cliente: " + e.getMessage());
			cadastrou = false;
		} finally {
			desconectarBanco();
		}

		return cadastrou;
	}

	private Integer cadastrarEndereco(Cliente cliente) {

		Integer idEndereco = null;

		int i = 0;

		StringBuilder sbInsert = new StringBuilder();

		sbInsert.append(" INSERT INTO DB_LOJA.TB_ENDERECO_END (			");
		sbInsert.append("		END_CIDADE,								");
		sbInsert.append("		END_BAIRRO,								");
		sbInsert.append("		END_RUA,								");
		sbInsert.append("		END_NUMERO,								");
		sbInsert.append("		END_CEP									");
		sbInsert.append("	) VALUES ( ?, ?, ?, ?, ?)					");

		StringBuilder sbResult = new StringBuilder();

		sbResult.append(" SELECT							");
		sbResult.append("		END_ID						");
		sbResult.append(" FROM								");
		sbResult.append("		DB_LOJA.TB_ENDERECO_END		");
		sbResult.append(" WHERE								");
		sbResult.append("		END_CIDADE = ? 				");
		sbResult.append("		AND END_BAIRRO = ? 			");
		sbResult.append("		AND END_RUA = ? 			");
		sbResult.append("		AND END_NUMERO = ? 			");
		sbResult.append("		AND END_CEP = ? 			");

		try {

			this.stmt = this.conexao.prepareStatement(sbInsert.toString());
			this.stmt.setString(++i, cliente.getEndereco().getCidade().toUpperCase());
			this.stmt.setString(++i, cliente.getEndereco().getBairro().toUpperCase());
			this.stmt.setString(++i, cliente.getEndereco().getRua().toUpperCase());
			this.stmt.setString(++i, cliente.getEndereco().getNumero());
			this.stmt.setString(++i, cliente.getEndereco().getCep());

			if (this.stmt.executeUpdate() == 1) {

				i = 0;

				this.stmt = this.conexao.prepareStatement(sbResult.toString());

				this.stmt.setString(++i, cliente.getEndereco().getCidade().toUpperCase());
				this.stmt.setString(++i, cliente.getEndereco().getBairro().toUpperCase());
				this.stmt.setString(++i, cliente.getEndereco().getRua().toUpperCase());
				this.stmt.setString(++i, cliente.getEndereco().getNumero());
				this.stmt.setString(++i, cliente.getEndereco().getCep());
				this.rs = this.stmt.executeQuery();

				while (rs.next()) {
					idEndereco = this.rs.getInt("END_ID");
				}

			}

		} catch (Exception e) {
			System.err.println("ClienteDAO -> cadastrarCliente -> Erro ao cadastrar endereço: " + e.getMessage());
		}

		return idEndereco;
	}

	public List<Cliente> listarCliente() {

		List<Cliente> listaCliente = new ArrayList<Cliente>();

		Cliente clienteBanco = null;

		int i = 0;

		StringBuilder sb = new StringBuilder();

		sb.append("	SELECT							");
		sb.append("		CLI_ID,						");
		sb.append("		CLI_NOME,					");
		sb.append("		CLI_TELEFONE,				");
		sb.append("		CLI_EMAIL					");
		sb.append("FROM								");
		sb.append("		DB_LOJA.TB_CLIENTE_CLI		");

		conectarBanco();

		try {

			this.stmt = this.conexao.prepareStatement(sb.toString());
			this.rs = this.stmt.executeQuery();

			while (rs.next()) {
				clienteBanco = new Cliente();

				clienteBanco.setId(this.rs.getInt("CLI_ID"));
				clienteBanco.setNome(this.rs.getString("CLI_NOME"));
				clienteBanco.setTelefone(this.rs.getString("CLI_TELEFONE"));
				clienteBanco.setEmail(this.rs.getString("CLI_EMAIL"));

				listaCliente.add(clienteBanco);

			}

		} catch (Exception e) {
			System.err.println("ERRO: UsuarioDAO -> buscarUsuario: " + e.getMessage());
		} finally {
			desconectarBanco();
		}

		return listaCliente;

	}

}
