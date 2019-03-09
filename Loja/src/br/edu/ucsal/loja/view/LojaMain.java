package br.edu.ucsal.loja.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class LojaMain extends JFrame {

	private static final long serialVersionUID = 1L;

	public LojaMain() {

		super("Fazer Login");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new TelaLogin());
		pack();
		setResizable(false);
		setSize(300, 250);
		setLocationRelativeTo(null);

	}

	public static void main(String[] args) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("ERRO: LojaMain -> Main -> LookAndFeel: " + e.getMessage());
		}

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new LojaMain().setVisible(true);

			}
		});

	}

}
