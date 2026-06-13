package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import controlador.Sistema;
import modelo.Resultado;

public class TelaExibirResultado extends JFrame {

	public TelaExibirResultado() {

		setTitle("Resultados");

		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// PAINEL PRINCIPAL
		JPanel painel = new JPanel();

		painel.setBackground(new Color(210, 220, 240));

		painel.setLayout(new BorderLayout(20, 20));

		// PAINEL TOPO
		JPanel topo = new JPanel();

		topo.setBackground(new Color(210, 220, 240));

		topo.setLayout(new GridLayout(2, 1));

		// TÍTULO
		JLabel titulo = new JLabel("Resultados dos Testes");

		titulo.setHorizontalAlignment(SwingConstants.CENTER);

		titulo.setFont(new Font("Arial", Font.BOLD, 34));

		// SUBTÍTULO
		JLabel subtitulo = new JLabel("Ranking dos melhores tempos");

		subtitulo.setHorizontalAlignment(SwingConstants.CENTER);

		subtitulo.setFont(new Font("Arial", Font.PLAIN, 20));

		topo.add(titulo);

		topo.add(subtitulo);

		// ÁREA DOS RESULTADOS
		JTextArea area = new JTextArea();

		area.setEditable(false);

		area.setFont(new Font("Arial", Font.PLAIN, 24));

		area.setBackground(Color.WHITE);

		area.setMargin(new Insets(20, 20, 20, 20));

		// ORDENA RANKING
		ArrayList<Resultado> ranking = new ArrayList<>(Sistema.listaResultados);

		Collections.sort(ranking, Comparator.comparingLong(Resultado::getTempo));

		// EXIBE RESULTADOS
		if (ranking.isEmpty()) {

			area.append("Nenhum resultado registrado.");

		} else {

			int posicao = 1;

			for (Resultado r : ranking) {

				area.append(
						posicao + "º Lugar\n\n" +
						"Participante: " + r.getNomeParticipante() + "\n" +
						"Tempo: " + r.getTempo() + " ms\n" +
						"-------------------------------------\n\n"
				);

				posicao++;
			}
		}

		JScrollPane scroll = new JScrollPane(area);

		// PAINEL INFO
		JPanel painelInfo = new JPanel();

		painelInfo.setBackground(new Color(190, 205, 230));

		painelInfo.setBorder(
				BorderFactory.createLineBorder(
						new Color(120, 150, 200),
						2
				)
		);

		JLabel info = new JLabel(
				"Os resultados são organizados automaticamente pelo menor tempo."
		);

		info.setFont(new Font("Arial", Font.BOLD, 20));

		painelInfo.add(info);

		// BOTÃO VOLTAR
		JButton btnVoltar = new JButton("Voltar");

		btnVoltar.setFont(new Font("Arial", Font.BOLD, 18));

		btnVoltar.addActionListener(e -> {

			new TelaMenu();

			dispose();
		});

		// PAINEL INFERIOR
		JPanel inferior = new JPanel();

		inferior.setBackground(new Color(210, 220, 240));

		inferior.setLayout(new BorderLayout());

		inferior.add(painelInfo, BorderLayout.CENTER);

		JPanel painelBotao = new JPanel();

		painelBotao.setBackground(new Color(210, 220, 240));

		painelBotao.add(btnVoltar);

		inferior.add(painelBotao, BorderLayout.SOUTH);

		// ADICIONA COMPONENTES
		painel.add(topo, BorderLayout.NORTH);

		painel.add(scroll, BorderLayout.CENTER);

		painel.add(inferior, BorderLayout.SOUTH);

		add(painel);

		setVisible(true);
	}
}