package view;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import controlador.Sistema;
import modelo.Resultado;

public class TelaTeste extends JFrame {

	private JLabel lblTitulo;

	private JLabel lblPalavra;

	private JLabel lblRodada;

	private JButton btnVermelho;

	private JButton btnVerde;

	private JButton btnAzul;

	private JButton btnAmarelo;

	private JButton btnRoxo;

	private JButton btnLaranja;

	private String[] palavras = {
			"VERMELHO",
			"VERDE",
			"AZUL",
			"AMARELO",
			"ROXO",
			"LARANJA"
	};

	private Color[] cores = {
			Color.RED,
			Color.GREEN,
			Color.BLUE,
			Color.YELLOW,
			new Color(128, 0, 128),
			Color.ORANGE
	};

	private int indiceCorCorreta;

	private int rodadas = 0;

	private int totalRodadas = 15;

	private long tempoInicio;

	public TelaTeste() {

		setTitle("Teste Cognitivo");

		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// PAINEL PRINCIPAL
		JPanel painel = new JPanel();

		painel.setBackground(new Color(210, 220, 240));

		painel.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();

		c.insets = new Insets(20, 20, 20, 20);

		c.gridx = 0;

		c.fill = GridBagConstraints.HORIZONTAL;

		// =========================
		// TOPO
		// =========================

		JPanel topo = new JPanel();

		topo.setBackground(new Color(210, 220, 240));

		topo.setLayout(new GridLayout(2, 1));

		lblTitulo = new JLabel(
				"Teste Cognitivo de Cores",
				SwingConstants.CENTER
		);

		lblTitulo.setFont(new Font("Arial", Font.BOLD, 34));

		lblRodada = new JLabel("", SwingConstants.CENTER);

		lblRodada.setFont(new Font("Arial", Font.BOLD, 22));

		topo.add(lblTitulo);

		topo.add(lblRodada);

		// =========================
		// PALAVRA CENTRAL
		// =========================

		JPanel centro = new JPanel();

		centro.setBackground(new Color(210, 220, 240));

		centro.setLayout(new GridBagLayout());

		lblPalavra = new JLabel("", SwingConstants.CENTER);

		lblPalavra.setFont(new Font("Arial", Font.BOLD, 72));

		centro.add(lblPalavra);

		// =========================
		// BOTÕES
		// =========================

		JPanel painelBotoes = new JPanel();

		painelBotoes.setBackground(new Color(210, 220, 240));

		painelBotoes.setLayout(new GridLayout(2, 3, 25, 25));

		painelBotoes.setPreferredSize(new Dimension(1000, 220));

		// BOTÕES
		btnVermelho = new JButton("VERMELHO");

		btnVerde = new JButton("VERDE");

		btnAzul = new JButton("AZUL");

		btnAmarelo = new JButton("AMARELO");

		btnRoxo = new JButton("ROXO");

		btnLaranja = new JButton("LARANJA");

		// FONTE DOS BOTÕES
		Font fonteBotao = new Font("Arial", Font.BOLD, 20);

		btnVermelho.setFont(fonteBotao);

		btnVerde.setFont(fonteBotao);

		btnAzul.setFont(fonteBotao);

		btnAmarelo.setFont(fonteBotao);

		btnRoxo.setFont(fonteBotao);

		btnLaranja.setFont(fonteBotao);

		// TAMANHO BOTÕES
		Dimension tamanhoBotao = new Dimension(250, 70);

		btnVermelho.setPreferredSize(tamanhoBotao);

		btnVerde.setPreferredSize(tamanhoBotao);

		btnAzul.setPreferredSize(tamanhoBotao);

		btnAmarelo.setPreferredSize(tamanhoBotao);

		btnRoxo.setPreferredSize(tamanhoBotao);

		btnLaranja.setPreferredSize(tamanhoBotao);

		// ADICIONA BOTÕES
		painelBotoes.add(btnVermelho);

		painelBotoes.add(btnVerde);

		painelBotoes.add(btnAzul);

		painelBotoes.add(btnAmarelo);

		painelBotoes.add(btnRoxo);

		painelBotoes.add(btnLaranja);

		// =========================
		// ADICIONA COMPONENTES
		// =========================

		c.gridy = 0;

		painel.add(topo, c);

		c.gridy = 1;

		painel.add(centro, c);

		c.gridy = 2;

		painel.add(painelBotoes, c);

		// =========================
		// AÇÕES DOS BOTÕES
		// =========================

		btnVermelho.addActionListener(e -> verificar(Color.RED));

		btnVerde.addActionListener(e -> verificar(Color.GREEN));

		btnAzul.addActionListener(e -> verificar(Color.BLUE));

		btnAmarelo.addActionListener(e -> verificar(Color.YELLOW));

		btnRoxo.addActionListener(e -> verificar(new Color(128, 0, 128)));

		btnLaranja.addActionListener(e -> verificar(Color.ORANGE));

		add(painel);

		setVisible(true);

		iniciar();
	}

	// INICIA TESTE
	private void iniciar() {

		tempoInicio = System.currentTimeMillis();

		proximaRodada();
	}

	// PRÓXIMA RODADA
	private void proximaRodada() {

		if (rodadas >= totalRodadas) {

			finalizar();

			return;
		}

		Random r = new Random();

		int palavraIndex = r.nextInt(palavras.length);

		int corIndex = r.nextInt(cores.length);

		lblPalavra.setText(palavras[palavraIndex]);

		lblPalavra.setForeground(cores[corIndex]);

		indiceCorCorreta = corIndex;

		rodadas++;

		lblRodada.setText(
				"Rodada " +
				rodadas +
				" de " +
				totalRodadas
		);
	}

	// VERIFICA RESPOSTA
	private void verificar(Color corSelecionada) {

		if (corSelecionada.equals(cores[indiceCorCorreta])) {

			proximaRodada();

		} else {

			JOptionPane.showMessageDialog(
					null,
					"Cor incorreta!"
			);

			proximaRodada();
		}
	}

	// FINALIZA TESTE
	private void finalizar() {

		long tempo = System.currentTimeMillis() - tempoInicio;

		if (Sistema.participanteAtual == null) {

			JOptionPane.showMessageDialog(
					null,
					"Nenhum participante encontrado!"
			);

			return;
		}

		Resultado r = new Resultado(
				Sistema.participanteAtual.getNome(),
				tempo
		);

		Sistema.listaResultados.add(r);

		Sistema.salvarDados();

		new TelaResultado(tempo);

		dispose();
	}
}