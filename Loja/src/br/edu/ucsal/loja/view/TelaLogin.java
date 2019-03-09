package br.edu.ucsal.loja.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.edu.ucsal.loja.bean.Usuario;
import br.edu.ucsal.loja.controller.UsuarioAction;

public class TelaLogin extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldLogin;
	private UsuarioAction usuarioAction;
	private Usuario usuario;
	private JPasswordField passwordField;

	public TelaLogin() {
		setLayout(null);
		setSize(300, 250);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Fazer Login");
		initComponents();

	}

	private void initComponents() {
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
		btnEntrar.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				usuarioAction = new UsuarioAction();
				usuario = new Usuario(textFieldLogin.getText(), passwordField.getText());

				String mensagem = usuarioAction.logar(usuario);

				if (mensagem != null) {
					JOptionPane.showMessageDialog(null, mensagem, "ERRO", JOptionPane.ERROR_MESSAGE);
				} else {
					new TelaPrincipal().setVisible(true);
					dispose();
				}

			}
		});
		add(btnEntrar);

		passwordField = new JPasswordField();
		passwordField.setBounds(43, 106, 220, 25);
		add(passwordField);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
