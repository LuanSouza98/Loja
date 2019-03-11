package br.edu.ucsal.loja.view.cliente;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaCadastrarCliente extends JPanel {

	private static final long serialVersionUID = 1L;

	public TelaCadastrarCliente() {
		setLayout(null);

		JLabel lblCadastrarCliente = new JLabel("Cadastrar cliente");
		lblCadastrarCliente.setBounds(166, 147, 225, 14);
		add(lblCadastrarCliente);

	}
}
