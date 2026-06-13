package view;

import javax.swing.*;
import java.awt.*;

import controlador.Sistema;

public class TelaLogin extends JFrame {

	public TelaLogin() {

		setTitle("Synapse - Login");

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setSize(1200, 700);

		setLocationRelativeTo(null);

		// painel principal
		JPanel painel = new JPanel(new GridBagLayout());

		painel.setBackground(new Color(180, 200, 230));

		GridBagConstraints c = new GridBagConstraints();

		c.insets = new Insets(15, 15, 15, 15);

		c.fill = GridBagConstraints.HORIZONTAL;

		// painel do formulario
		JPanel form = new JPanel();

		form.setBackground(new Color(180, 200, 230));

		form.setLayout(new GridLayout(0, 1, 10, 10));

		// titulo
		JLabel titulo = new JLabel("SYNAPSE - Plataforma de Avaliação Cognitiva");

		titulo.setFont(new Font("Arial", Font.BOLD, 32));

		titulo.setHorizontalAlignment(SwingConstants.CENTER);

		// email
		JLabel lblUsuario = new JLabel("Email:");

		lblUsuario.setFont(new Font("Arial", Font.BOLD, 22));

		JTextField txtUsuario = new JTextField();

		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 20));

		txtUsuario.setPreferredSize(new Dimension(500, 50));

		// senha
		JLabel lblSenha = new JLabel("Senha:");

		lblSenha.setFont(new Font("Arial", Font.BOLD, 22));

		JPasswordField txtSenha = new JPasswordField();

		txtSenha.setFont(new Font("Arial", Font.PLAIN, 20));

		txtSenha.setPreferredSize(new Dimension(500, 50));

		// entrar
		JButton btnEntrar = new JButton("Entrar");

		btnEntrar.setFont(new Font("Arial", Font.BOLD, 20));

		btnEntrar.setPreferredSize(new Dimension(500, 55));

		// cadastro
		JButton btnCadastro = new JButton("Cadastrar-se");

		btnCadastro.setFont(new Font("Arial", Font.BOLD, 18));

		btnCadastro.setPreferredSize(new Dimension(500, 55));

		// adiciona no formulario
		form.add(titulo);

		form.add(new JLabel(""));

		form.add(lblUsuario);

		form.add(txtUsuario);

		form.add(lblSenha);

		form.add(txtSenha);

		form.add(btnEntrar);

		form.add(btnCadastro);

		// centraliza
		c.gridx = 0;

		c.gridy = 0;

		painel.add(form, c);

		// login
		btnEntrar.addActionListener(e -> {

			String email = txtUsuario.getText();

			String senha = new String(txtSenha.getPassword());

			if (Sistema.autenticar(email, senha)) {

				new TelaMenu();

				dispose();

			} else {

				JOptionPane.showMessageDialog(null, "Email ou senha inválidos!");
			}
		});

		// cadastro
		btnCadastro.addActionListener(e -> {

			new TelaCadastro();

			dispose();
		});

		add(painel);

		setVisible(true);
	}

	// MAIN
	public static void main(String[] args) {

		Sistema.carregarDados();

		new TelaLogin();
	}
}