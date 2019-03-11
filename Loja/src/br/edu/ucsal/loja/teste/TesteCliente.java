package br.edu.ucsal.loja.teste;

import br.edu.ucsal.loja.bean.Cliente;
import br.edu.ucsal.loja.bean.Endereco;
import br.edu.ucsal.loja.dao.mysql.ClienteDAO;

public class TesteCliente {

	public static void main(String[] args) {
		Endereco endereco = new Endereco("Salvador", "Novo Horizonte", "Tiradentes", "33", "412018-022");
		Cliente cliente = new Cliente("Luan", "000.000.000-00", "71 9999-999", "71 99999-9999", "luan@email.com",endereco);
		cadastrarCliente(cliente);
	}

	public static void cadastrarCliente(Cliente cliente) {
		ClienteDAO clienteDao = new ClienteDAO();
		clienteDao.cadastrarCliente(cliente);
	}

}
