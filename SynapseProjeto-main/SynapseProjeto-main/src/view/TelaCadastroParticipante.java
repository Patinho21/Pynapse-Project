package view;

import javax.swing.*;
import java.awt.*;

import controlador.Sistema;
import modelo.Participante;

public class TelaCadastroParticipante extends JFrame {

	public TelaCadastroParticipante() {

		setTitle("Cadastro de Participante");

		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// PAINEL PRINCIPAL
		JPanel painel = new JPanel();

		painel.setBackground(new Color(200, 210, 230));

		painel.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();

		c.insets = new Insets(12, 12, 12, 12);

		c.fill = GridBagConstraints.HORIZONTAL;

		// TÍTULO
		JLabel titulo = new JLabel("Cadastro de Participante");

		titulo.setFont(new Font("Arial", Font.BOLD, 32));

		titulo.setHorizontalAlignment(SwingConstants.CENTER);

		c.gridx = 0;

		c.gridy = 0;

		c.gridwidth = 2;

		painel.add(titulo, c);

		// LABEL NOME
		JLabel lblNome = new JLabel("Nome:");

		lblNome.setFont(new Font("Arial", Font.BOLD, 20));

		c.gridy = 1;

		c.gridwidth = 1;

		painel.add(lblNome, c);

		// CAMPO NOME
		JTextField txtNome = new JTextField(30);

		txtNome.setFont(new Font("Arial", Font.PLAIN, 18));

		c.gridy = 2;

		painel.add(txtNome, c);

		// LABEL IDADE
		JLabel lblIdade = new JLabel("Idade:");

		lblIdade.setFont(new Font("Arial", Font.BOLD, 20));

		c.gridy = 3;

		painel.add(lblIdade, c);

		// CAMPO IDADE
		JTextField txtIdade = new JTextField(30);

		txtIdade.setFont(new Font("Arial", Font.PLAIN, 18));

		c.gridy = 4;

		painel.add(txtIdade, c);

		// PAINEL BOTÕES
		JPanel painelBotoes = new JPanel();

		painelBotoes.setBackground(new Color(200, 210, 230));

		// BOTÃO CADASTRAR
		JButton btnCadastrar = new JButton("Cadastrar");

		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 18));

		// BOTÃO VOLTAR
		JButton btnVoltar = new JButton("Voltar");

		btnVoltar.setFont(new Font("Arial", Font.BOLD, 18));

		painelBotoes.add(btnCadastrar);

		painelBotoes.add(btnVoltar);

		c.gridy = 5;

		painel.add(painelBotoes, c);

		// AÇÃO CADASTRAR
		btnCadastrar.addActionListener(e -> {

			String nome = txtNome.getText();

			String idade = txtIdade.getText();

			// verifica campos vazios
			if (nome.isEmpty() || idade.isEmpty()) {

				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

				return;
			}

			// cria participante
			Participante p = new Participante(nome);

			// salva participante
			Sistema.participantes.add(p);

			Sistema.participanteAtual = p;

			Sistema.salvarDados();

			JOptionPane.showMessageDialog(null, "Participante cadastrado!");

			// abre instruções
			new TelaInstrucoes();

			dispose();
		});

		// AÇÃO VOLTAR
		btnVoltar.addActionListener(e -> {

			new TelaMenu();

			dispose();
		});

		add(painel);

		setVisible(true);
	}
}