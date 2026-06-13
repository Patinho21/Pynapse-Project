package view;

import javax.swing.*;
import java.awt.*;

public class TelaResultado extends JFrame {

    public TelaResultado(long tempo) {

        setTitle("Resultado");

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // PAINEL PRINCIPAL
        JPanel painel = new JPanel();

        painel.setBackground(new Color(210, 220, 240));

        painel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(20, 20, 20, 20);

        c.gridx = 0;

        // TÍTULO
        JLabel titulo = new JLabel("Resultado Final");

        titulo.setFont(new Font("Arial", Font.BOLD, 34));

        c.gridy = 0;

        painel.add(titulo, c);

        // RESULTADO
        JLabel lbl = new JLabel("Tempo: " + tempo + " ms");

        lbl.setFont(new Font("Arial", Font.BOLD, 28));

        c.gridy = 1;

        painel.add(lbl, c);

        // BOTÃO
        JButton btn = new JButton("Voltar");

        btn.setFont(new Font("Arial", Font.BOLD, 18));

        btn.setPreferredSize(new Dimension(220, 50));

        c.gridy = 2;

        painel.add(btn, c);

        // AÇÃO BOTÃO
        btn.addActionListener(e -> {

            new TelaMenu();

            dispose();
        });

        add(painel);

        setVisible(true);
    }
}