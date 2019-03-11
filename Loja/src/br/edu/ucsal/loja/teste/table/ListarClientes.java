package br.edu.ucsal.loja.teste.table;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.edu.ucsal.loja.bean.Cliente;
import br.edu.ucsal.loja.dao.mysql.ClienteDAO;

public class ListarClientes extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel painelFundo;
	JTable tabela;
	JScrollPane barraRolagem;

	private ClienteTableModel modelo;
	private List<Cliente> listaCliente;

//	Object[][] dados = { { "Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com" },
//			{ "João da Silva", "48 8890-3345", "joaosilva@hotmail.com" },
//			{ "Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com" } };
//
//	String[] colunas = { "Nome", "Telefone", "Email" };

	public ListarClientes() {
		super("Clientes");
		criaJTable();
	}

	private void criaJTable() {
		tabela = new JTable(modelo);
		pesquisar();

	}

	private void pesquisar() {
		ClienteDAO dao = new ClienteDAO();
		listaCliente = dao.listarCliente();
		modelo = new ClienteTableModel(listaCliente);
		tabela.setModel(modelo);
	}

	public void criaJanela() {

		painelFundo = new JPanel();
		painelFundo.setLayout(new GridLayout(1, 1));
		// tabela = new JTable(dados, colunas);
		barraRolagem = new JScrollPane(tabela);
		painelFundo.add(barraRolagem);

		getContentPane().add(painelFundo);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 120);
		setVisible(true);
	}

	public static void main(String[] args) {
		ListarClientes lc = new ListarClientes();
		lc.criaJanela();
	}

}
