package br.edu.ucsal.loja.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.ucsal.loja.bean.Usuario;
import br.edu.ucsal.loja.controller.UsuarioAction;
import javax.swing.JPasswordField;

public class TelaLogin extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldLogin;
	private UsuarioAction usuarioAction;
	private Usuario usuario;
	private JPasswordField passwordField;

	public TelaLogin() {
		setLayout(null);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(43, 25, 46, 14);
		add(lblLogin);

		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(43, 50, 220, 25);
		add(textFieldLogin);
		textFieldLogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(43, 81, 46, 14);
		add(lblSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(113, 164, 89, 23);
		btnEntrar.addActionListener(this);
		add(btnEntrar);

		passwordField = new JPasswordField();
		passwordField.setBounds(43, 106, 220, 25);
		add(passwordField);

	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {

		usuarioAction = new UsuarioAction();
		usuario = new Usuario();

		usuario.setLogin(textFieldLogin.getText());
		usuario.setSenha(passwordField.getText());

		usuarioAction.logar(usuario);

	}
}
