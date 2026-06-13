package view;

import javax.swing.*;
import java.awt.*;

import controlador.Sistema;
import modelo.Usuario;

public class TelaCadastro extends JFrame {

	public TelaCadastro() {

		setTitle("Cadastro de Pesquisador");

		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// PAINEL PRINCIPAL
		JPanel painel = new JPanel();

		painel.setBackground(new Color(200, 210, 230));

		painel.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();

		c.insets = new Insets(10, 10, 10, 10);

		c.fill = GridBagConstraints.HORIZONTAL;

		// TITULO
		JLabel titulo = new JLabel("Cadastro de Pesquisador");

		titulo.setFont(new Font("Arial", Font.BOLD, 28));

		titulo.setHorizontalAlignment(SwingConstants.CENTER);

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;

		painel.add(titulo, c);

		// NOME
		JLabel lblNome = new JLabel("Nome:");

		lblNome.setFont(new Font("Arial", Font.BOLD, 18));

		c.gridy = 1;
		c.gridwidth = 1;

		painel.add(lblNome, c);

		JTextField txtNome = new JTextField(25);

		txtNome.setFont(new Font("Arial", Font.PLAIN, 18));

		c.gridy = 2;

		painel.add(txtNome, c);

		// EMAIL
		JLabel lblEmail = new JLabel("Email:");

		lblEmail.setFont(new Font("Arial", Font.BOLD, 18));

		c.gridy = 3;

		painel.add(lblEmail, c);

		JTextField txtEmail = new JTextField(25);

		txtEmail.setFont(new Font("Arial", Font.PLAIN, 18));

		c.gridy = 4;

		painel.add(txtEmail, c);

		// INSTITUIÇÃO
		JLabel lblInstituicao = new JLabel("Instituição:");

		lblInstituicao.setFont(new Font("Arial", Font.BOLD, 18));

		c.gridy = 5;

		painel.add(lblInstituicao, c);

		JTextField txtInstituicao = new JTextField(25);

		txtInstituicao.setFont(new Font("Arial", Font.PLAIN, 18));

		c.gridy = 6;

		painel.add(txtInstituicao, c);

		// ÁREA
		JLabel lblArea = new JLabel("Área de atuação:");

		lblArea.setFont(new Font("Arial", Font.BOLD, 18));

		c.gridy = 7;

		painel.add(lblArea, c);

		JTextField txtArea = new JTextField(25);

		txtArea.setFont(new Font("Arial", Font.PLAIN, 18));

		c.gridy = 8;

		painel.add(txtArea, c);

		// REGISTRO
		JLabel lblRegistro = new JLabel("Registro profissional:");

		lblRegistro.setFont(new Font("Arial", Font.BOLD, 18));

		c.gridy = 9;

		painel.add(lblRegistro, c);

		JTextField txtRegistro = new JTextField(25);

		txtRegistro.setFont(new Font("Arial", Font.PLAIN, 18));

		c.gridy = 10;

		painel.add(txtRegistro, c);

		// SENHA
		JLabel lblSenha = new JLabel("Senha:");

		lblSenha.setFont(new Font("Arial", Font.BOLD, 18));

		c.gridy = 11;

		painel.add(lblSenha, c);

		JPasswordField txtSenha = new JPasswordField(25);

		txtSenha.setFont(new Font("Arial", Font.PLAIN, 18));

		c.gridy = 12;

		painel.add(txtSenha, c);

		// CONFIRMAR
		JLabel lblConfirmar = new JLabel("Confirmar senha:");

		lblConfirmar.setFont(new Font("Arial", Font.BOLD, 18));

		c.gridy = 13;

		painel.add(lblConfirmar, c);

		JPasswordField txtConfirmar = new JPasswordField(25);

		txtConfirmar.setFont(new Font("Arial", Font.PLAIN, 18));

		c.gridy = 14;

		painel.add(txtConfirmar, c);

		// PAINEL BOTÕES
		JPanel painelBotoes = new JPanel();

		painelBotoes.setBackground(new Color(200, 210, 230));

		JButton btnCadastrar = new JButton("Cadastrar");

		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 16));

		JButton btnVoltar = new JButton("Voltar");

		btnVoltar.setFont(new Font("Arial", Font.BOLD, 16));

		painelBotoes.add(btnCadastrar);

		painelBotoes.add(btnVoltar);

		c.gridy = 15;

		painel.add(painelBotoes, c);

		// CADASTRAR
		btnCadastrar.addActionListener(e -> {

			String nome = txtNome.getText();

			String email = txtEmail.getText();

			String senha = new String(txtSenha.getPassword());

			String confirmar = new String(txtConfirmar.getPassword());

			if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {

				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

				return;
			}

			if (!senha.equals(confirmar)) {

				JOptionPane.showMessageDialog(null, "As senhas não conferem!");

				return;
			}

			Usuario u = new Usuario(nome, email, senha);

			boolean sucesso = Sistema.cadastrarUsuario(u);

			if (sucesso) {

				JOptionPane.showMessageDialog(null, "Pesquisador cadastrado!");

				new TelaLogin();

				dispose();

			} else {

				JOptionPane.showMessageDialog(null, "Email já cadastrado!");
			}
		});

		// VOLTAR
		btnVoltar.addActionListener(e -> {

			new TelaLogin();

			dispose();
		});

		add(painel);

		setVisible(true);
	}
}