package view;

import javax.swing.*;
import java.awt.*;

public class TelaInstrucoes extends JFrame {

    public TelaInstrucoes() {

        setTitle("Instruções");

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // PAINEL PRINCIPAL
        JPanel painelPrincipal = new JPanel();

        painelPrincipal.setBackground(new Color(210, 220, 240));

        painelPrincipal.setLayout(new BorderLayout(20, 20));

        // TÍTULO
        JLabel titulo = new JLabel(
                "Instruções do Teste Cognitivo",
                SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 32));

        titulo.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0));

        painelPrincipal.add(titulo, BorderLayout.NORTH);

        // TEXTO
        JTextArea texto = new JTextArea();

        texto.setEditable(false);

        texto.setFont(new Font("Arial", Font.PLAIN, 22));

        texto.setBackground(Color.WHITE);

        texto.setMargin(new Insets(20, 20, 20, 20));

        texto.setText(
                "Leia atentamente:\n\n"
                + "- Uma palavra aparecerá na tela.\n"
                + "- A palavra terá uma cor diferente.\n"
                + "- Clique na COR da palavra.\n"
                + "- Seja rápido.\n"
                + "- O sistema calculará seu tempo.\n\n"
                + "Clique em 'Iniciar Teste' para começar."
        );

        JScrollPane scroll = new JScrollPane(texto);

        scroll.setBorder(
                BorderFactory.createEmptyBorder(20, 250, 20, 250)
        );

        painelPrincipal.add(scroll, BorderLayout.CENTER);

        // PAINEL BOTÃO
        JPanel painelBotao = new JPanel();

        painelBotao.setBackground(new Color(210, 220, 240));

        JButton btnIniciar = new JButton("Iniciar Teste");

        btnIniciar.setFont(new Font("Arial", Font.BOLD, 20));

        btnIniciar.setPreferredSize(new Dimension(250, 50));

        painelBotao.add(btnIniciar);

        painelPrincipal.add(painelBotao, BorderLayout.SOUTH);

        // INICIAR
        btnIniciar.addActionListener(e -> {

            new TelaTeste();

            dispose();
        });

        add(painelPrincipal);

        setVisible(true);
    }
}