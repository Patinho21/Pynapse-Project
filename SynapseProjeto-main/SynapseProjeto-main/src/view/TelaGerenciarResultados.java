package view;

import javax.swing.*;
import java.awt.*;

import controlador.Sistema;
import modelo.Resultado;

public class TelaGerenciarResultados extends JFrame {

	private JList<String> lista;

	private DefaultListModel<String> modeloLista;

	public TelaGerenciarResultados() {

		setTitle("Gerenciar Resultados");

		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// PAINEL PRINCIPAL
		JPanel painel = new JPanel();

		painel.setBackground(new Color(210, 220, 240));

		painel.setLayout(new BorderLayout(20, 20));

		// TOPO
		JPanel topo = new JPanel();

		topo.setBackground(new Color(210, 220, 240));

		topo.setLayout(new GridLayout(2, 1));

		// TÍTULO
		JLabel titulo = new JLabel("Gerenciamento de Resultados");

		titulo.setHorizontalAlignment(SwingConstants.CENTER);

		titulo.setFont(new Font("Arial", Font.BOLD, 34));

		// SUBTÍTULO
		JLabel subtitulo = new JLabel("Editar ou remover avaliações realizadas");

		subtitulo.setHorizontalAlignment(SwingConstants.CENTER);

		subtitulo.setFont(new Font("Arial", Font.PLAIN, 18));

		topo.add(titulo);

		topo.add(subtitulo);

		// LISTA
		modeloLista = new DefaultListModel<>();

		carregarResultados();

		lista = new JList<>(modeloLista);

		lista.setFont(new Font("Arial", Font.PLAIN, 22));

		lista.setBackground(Color.WHITE);

		lista.setSelectionBackground(new Color(120, 150, 200));

		lista.setSelectionForeground(Color.WHITE);

		JScrollPane scroll = new JScrollPane(lista);

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
				"Selecione um resultado para editar ou excluir."
		);

		info.setFont(new Font("Arial", Font.BOLD, 22));

		painelInfo.add(info);

		// BOTÕES
		JButton btnEditar = new JButton("Editar");

		btnEditar.setFont(new Font("Arial", Font.BOLD, 18));

		JButton btnExcluir = new JButton("Excluir");

		btnExcluir.setFont(new Font("Arial", Font.BOLD, 18));

		JButton btnVoltar = new JButton("Voltar");

		btnVoltar.setFont(new Font("Arial", Font.BOLD, 18));

		// PAINEL BOTÕES
		JPanel painelBotoes = new JPanel();

		painelBotoes.setBackground(new Color(210, 220, 240));

		painelBotoes.add(btnEditar);

		painelBotoes.add(btnExcluir);

		painelBotoes.add(btnVoltar);

		// PAINEL INFERIOR
		JPanel inferior = new JPanel();

		inferior.setBackground(new Color(210, 220, 240));

		inferior.setLayout(new BorderLayout());

		inferior.add(painelInfo, BorderLayout.CENTER);

		inferior.add(painelBotoes, BorderLayout.SOUTH);

		// EDITAR RESULTADO
		btnEditar.addActionListener(e -> {

			int index = lista.getSelectedIndex();

			if (index == -1) {

				JOptionPane.showMessageDialog(null, "Selecione um resultado!");

				return;
			}

			Resultado r = Sistema.listaResultados.get(index);

			String novoTempo = JOptionPane.showInputDialog(
					null,
					"Novo tempo:",
					r.getTempo()
			);

			try {

				long tempo = Long.parseLong(novoTempo);

				Resultado novo = new Resultado(
						r.getNomeParticipante(),
						tempo
				);

				Sistema.listaResultados.set(index, novo);

				Sistema.salvarDados();

				carregarResultados();

				JOptionPane.showMessageDialog(null, "Resultado atualizado!");

			} catch (Exception ex) {

				JOptionPane.showMessageDialog(null, "Valor inválido!");
			}
		});

		// EXCLUIR RESULTADO
		btnExcluir.addActionListener(e -> {

			int index = lista.getSelectedIndex();

			if (index == -1) {

				JOptionPane.showMessageDialog(null, "Selecione um resultado!");

				return;
			}

			int confirmar = JOptionPane.showConfirmDialog(
					null,
					"Deseja excluir esse resultado?"
			);

			if (confirmar == 0) {

				Sistema.listaResultados.remove(index);

				Sistema.salvarDados();

				carregarResultados();

				JOptionPane.showMessageDialog(null, "Resultado removido!");
			}
		});

		// VOLTAR
		btnVoltar.addActionListener(e -> {

			new TelaMenu();

			dispose();
		});

		// ADICIONA COMPONENTES
		painel.add(topo, BorderLayout.NORTH);

		painel.add(scroll, BorderLayout.CENTER);

		painel.add(inferior, BorderLayout.SOUTH);

		add(painel);

		setVisible(true);
	}

	// CARREGA RESULTADOS
	private void carregarResultados() {

		modeloLista.clear();

		for (Resultado r : Sistema.listaResultados) {

			modeloLista.addElement(
					"Participante: " +
					r.getNomeParticipante() +
					"   |   Tempo: " +
					r.getTempo() +
					" ms"
			);
		}
	}
}