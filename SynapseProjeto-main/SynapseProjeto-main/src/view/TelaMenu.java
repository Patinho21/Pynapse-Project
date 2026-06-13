package view;

import javax.swing.*;
import java.awt.*;

import controlador.Sistema;

public class TelaMenu extends JFrame {

	public TelaMenu() {

		setTitle("Synapse - Menu");

		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// PAINEL PRINCIPAL
		JPanel principal = new JPanel();

		principal.setLayout(new BorderLayout());

		// =========================
		// PAINEL LATERAL
		// =========================

		JPanel lateral = new JPanel();

		lateral.setBackground(new Color(120, 150, 200));

		lateral.setPreferredSize(new Dimension(320, 0));

		lateral.setLayout(new BorderLayout());

		// TOPO LATERAL
		JPanel topoLateral = new JPanel();

		topoLateral.setBackground(new Color(120, 150, 200));

		topoLateral.setLayout(new BorderLayout());

		// pega nome do usuário logado
		String nomeUsuario = "Usuário";

		if (Sistema.usuarioLogado != null) {

			nomeUsuario = Sistema.usuarioLogado.getNome();
		}

		JLabel lblUsuario = new JLabel("Olá, " + nomeUsuario);

		lblUsuario.setFont(new Font("Arial", Font.BOLD, 24));

		lblUsuario.setForeground(Color.WHITE);

		lblUsuario.setBorder(
				BorderFactory.createEmptyBorder(30, 30, 30, 30)
		);

		topoLateral.add(lblUsuario, BorderLayout.NORTH);

		// CENTRO LATERAL
		JPanel centroLateral = new JPanel();

		centroLateral.setBackground(new Color(120, 150, 200));

		centroLateral.setLayout(new GridLayout(4, 1, 15, 15));

		centroLateral.setBorder(
				BorderFactory.createEmptyBorder(40, 30, 40, 30)
		);

		JButton btnCadastro = new JButton("Cadastrar participante");

		JButton btnTeste = new JButton("Realizar Avaliação");

		JButton btnResultado = new JButton("Exibir resultados");

		JButton btnGerenciar = new JButton("Gerenciar resultados");

		btnCadastro.setFont(new Font("Arial", Font.BOLD, 18));

		btnTeste.setFont(new Font("Arial", Font.BOLD, 18));

		btnResultado.setFont(new Font("Arial", Font.BOLD, 18));

		btnGerenciar.setFont(new Font("Arial", Font.BOLD, 18));

		centroLateral.add(btnCadastro);

		centroLateral.add(btnTeste);

		centroLateral.add(btnResultado);

		centroLateral.add(btnGerenciar);

		// INFERIOR LATERAL
		JPanel inferiorLateral = new JPanel();

		inferiorLateral.setBackground(new Color(120, 150, 200));

		inferiorLateral.setLayout(new BorderLayout());

		inferiorLateral.setBorder(
				BorderFactory.createEmptyBorder(30, 30, 30, 30)
		);

		JButton btnSair = new JButton("Sair");

		btnSair.setFont(new Font("Arial", Font.BOLD, 18));

		inferiorLateral.add(btnSair, BorderLayout.SOUTH);

		// adiciona partes na lateral
		lateral.add(topoLateral, BorderLayout.NORTH);

		lateral.add(centroLateral, BorderLayout.CENTER);

		lateral.add(inferiorLateral, BorderLayout.SOUTH);

		// =========================
		// CONTEÚDO PRINCIPAL
		// =========================

		JPanel conteudo = new JPanel();

		conteudo.setBackground(new Color(210, 220, 240));

		conteudo.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();

		c.insets = new Insets(15, 15, 15, 15);

		c.gridx = 0;

		// TITULO
		JLabel titulo = new JLabel("Bem-vindo ao Sistema Synapse");

		titulo.setFont(new Font("Arial", Font.BOLD, 34));

		c.gridy = 0;

		conteudo.add(titulo, c);

		// SUBTITULO
		JLabel subtitulo = new JLabel("Sistema de Avaliação Cognitiva");

		subtitulo.setFont(new Font("Arial", Font.PLAIN, 24));

		c.gridy = 1;

		conteudo.add(subtitulo, c);

		// =========================
		// AÇÕES
		// =========================

		btnCadastro.addActionListener(e -> {

			new TelaCadastroParticipante();

			dispose();
		});

		btnTeste.addActionListener(e -> {

			new TelaTeste();

			dispose();
		});

		btnResultado.addActionListener(e -> {

			new TelaExibirResultado();

			dispose();
		});

		btnGerenciar.addActionListener(e -> {

			new TelaGerenciarResultados();

			dispose();
		});

		btnSair.addActionListener(e -> {

			new TelaLogin();

			dispose();
		});

		// adiciona tudo na tela
		principal.add(lateral, BorderLayout.WEST);

		principal.add(conteudo, BorderLayout.CENTER);

		add(principal);

		setVisible(true);
	}
}