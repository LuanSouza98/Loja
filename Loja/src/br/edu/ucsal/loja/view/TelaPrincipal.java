package br.edu.ucsal.loja.view;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import br.edu.ucsal.loja.bean.Usuario;
import br.edu.ucsal.loja.view.cliente.TelaCadastrarCliente;
import br.edu.ucsal.loja.view.produto.TelaCadastrarProduto;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	public TelaPrincipal() {
		setTitle("Sistema");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(400, 100, 700, 600);
		initComponents();

	}

	private void initComponents() {

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);

		JMenuItem mntmCadastrarCliente = new JMenuItem("Cadastrar");
		mntmCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new TelaCadastrarCliente().setVisible(true);
				setContentPane(new TelaCadastrarCliente());
				setTitle("Cadastrar Cliente");
				setVisible(true);
				
			}
		});
		mnCliente.add(mntmCadastrarCliente);

		JMenuItem mntmConsultarCliente = new JMenuItem("Consultar");
		mnCliente.add(mntmConsultarCliente);

		JMenu mnProduto = new JMenu("Produto");
		menuBar.add(mnProduto);

		JMenuItem mntmCadastrarProduto = new JMenuItem("Cadastrar");
		mntmCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCadastrarProduto().setVisible(true);
			}
		});
		mnProduto.add(mntmCadastrarProduto);

		JMenuItem mntmConsultarProduto = new JMenuItem("Consultar");
		mnProduto.add(mntmConsultarProduto);

		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);

		JMenuItem mntmPegarUsuario = new JMenuItem("Pegar Usu\u00E1rio");

		mntmPegarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ID: " + Usuario.getUsuarioLogado().getId());
				System.out.println("Nome: " + Usuario.getUsuarioLogado().getNome());
				System.out.println("Login: " + Usuario.getUsuarioLogado().getLogin());
			}
		});
		mnUsuario.add(mntmPegarUsuario);

		JMenuItem mntmCriarNovo = new JMenuItem("Criar Novo");
		mnUsuario.add(mntmCriarNovo);

		JMenuItem mntmAlterarSenha = new JMenuItem("Alterar Senha");
		mnUsuario.add(mntmAlterarSenha);

		// Encerrar aplicação
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// new PopUpEncerrarAplicacao().setVisible(true);
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja mesmo encerrar a aplicação?",
						"Encerrar aplicação", JOptionPane.YES_NO_OPTION);
				if (opcao == 0) {
					System.exit(0);
				}
			}
		});

	}
}
