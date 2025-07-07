package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controle.QuizController;
import dominio.Pergunta;

public class Mapa extends JFrame {

    private JPanel contentPane;
    private int personagem = 0;
    private JPanel painelQuiz;
    private QuizController controller;

    public Mapa() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1118, 600);
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        controller = new QuizController();

        JPanel painelMapa = new JPanel();
        painelMapa.setLayout(null);
        
        JButton btnLuffy = new JButton("");
        btnLuffy.setIcon(new ImageIcon(Mapa.class.getResource("/imagens/Luffy.png")));
        btnLuffy.setBounds(46, 103, 40, 40);
        btnLuffy.addActionListener(e -> personagem = 1);
        painelMapa.add(btnLuffy);

        JButton btnShanks = new JButton("");
        btnShanks.setIcon(new ImageIcon(Mapa.class.getResource("/imagens/Shanks.png")));
        btnShanks.setBounds(46, 154, 40, 40);
        btnShanks.addActionListener(e -> personagem = 2);
        painelMapa.add(btnShanks);

        JButton btnTeach = new JButton("");
        btnTeach.setIcon(new ImageIcon(Mapa.class.getResource("/imagens/Teach.png")));
        btnTeach.setBounds(46, 206, 40, 40);
        btnTeach.addActionListener(e -> personagem = 3);
        painelMapa.add(btnTeach);

        JButton btnBuggy = new JButton("");
        btnBuggy.setIcon(new ImageIcon(Mapa.class.getResource("/imagens/Buggy.png")));
        btnBuggy.setBounds(46, 257, 40, 40);
        btnBuggy.addActionListener(e -> personagem = 4);
        painelMapa.add(btnBuggy);

        JButton btnVazio = new JButton("");
        btnVazio.setBounds(46, 316, 40, 40);
        btnVazio.addActionListener(e -> personagem = 0);
        painelMapa.add(btnVazio);

        JButton[] botoesMapa = {new JButton(""), new JButton(""), new JButton(""), new JButton(""), new JButton(""),
                               new JButton(""), new JButton(""), new JButton(""), new JButton(""), new JButton(""),
                               new JButton(""), new JButton(""), new JButton(""), new JButton(""), new JButton(""),
                               new JButton(""), new JButton(""), new JButton(""), new JButton(""), new JButton(""),
                               new JButton(""), new JButton(""), new JButton(""), new JButton(""), new JButton("")};
        int[] posicoesX = {219, 259, 299, 339, 379,
                454, 494, 534, 574, 614,
                727, 767, 807, 847, 887,
                219, 259, 299, 339, 379,
                827, 867, 907, 947, 987};
        int[] posicoesY = {32, 32, 32, 32, 32,
                87, 87, 87, 87, 87,
                100, 100, 100, 100, 100,
                369, 369, 369, 369, 369,
                369, 369, 369, 369, 369};

        for (int i = 0; i < botoesMapa.length; i++) {
            JButton btn = botoesMapa[i];
            btn.setBounds(posicoesX[i], posicoesY[i], 40, 40);
            btn.setBackground(Color.WHITE);
            btn.addActionListener(e -> {
                if (personagem == 1) btn.setIcon(new ImageIcon(Mapa.class.getResource("/imagens/Luffy.png")));
                else if (personagem == 2) btn.setIcon(new ImageIcon(Mapa.class.getResource("/imagens/Shanks.png")));
                else if (personagem == 3) btn.setIcon(new ImageIcon(Mapa.class.getResource("/imagens/Teach.png")));
                else if (personagem == 4) btn.setIcon(new ImageIcon(Mapa.class.getResource("/imagens/Buggy.png")));
                else btn.setIcon(new ImageIcon(""));
            });
            painelMapa.add(btn);
        }

        JLabel labelFundo = new JLabel("");
        labelFundo.setIcon(new ImageIcon(Mapa.class.getResource("/imagens/Fundo2.png")));
        labelFundo.setBounds(0, -13, 1118, 465);
        painelMapa.add(labelFundo);

        contentPane.add(painelMapa, BorderLayout.CENTER);

        painelQuiz = new JPanel();
        painelQuiz.setLayout(new GridLayout(2, 5, 10, 10));
        criarBotoesQuiz();
        contentPane.add(painelQuiz, BorderLayout.SOUTH);
    }

    private void criarBotoesQuiz() {
        for (int i = 1; i <= 10; i++) {
            JButton botao = new JButton("Grupo " + i);
            int grupo = i;
            botao.addActionListener(e -> {
                Pergunta pergunta = controller.getProximaPergunta(grupo);
                if (pergunta != null) {
                    mostrarPergunta(pergunta);
                } else {
                    JOptionPane.showMessageDialog(this, "Todas as perguntas do grupo " + grupo + " foram exibidas!");
                }
            });
            painelQuiz.add(botao);
        }
    }

    private void mostrarPergunta(Pergunta pergunta) {
        JDialog dialog = new JDialog(this, "Pergunta", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new GridLayout(5, 1));
        dialog.setLocationRelativeTo(this);

        JLabel labelPergunta = new JLabel(pergunta.getEnunciado());
        dialog.add(labelPergunta);

        ButtonGroup grupo = new ButtonGroup();
        for (String opcao : pergunta.getOpcoes()) {
            JRadioButton radio = new JRadioButton(opcao);
            grupo.add(radio);
            dialog.add(radio);
        }

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener(e -> {
            boolean respondeu = false;
            for (java.awt.Component c : dialog.getContentPane().getComponents()) {
                if (c instanceof JRadioButton && ((JRadioButton) c).isSelected()) {
                    respondeu = true;
                    if (((JRadioButton) c).getText().equals(pergunta.getRespostaCorreta())) {
                        JOptionPane.showMessageDialog(dialog, "Correto!");
                    } else {
                        JOptionPane.showMessageDialog(dialog, "Errado! A resposta correta é: " + pergunta.getRespostaCorreta());
                    }
                    break;
                }
            }
            if (!respondeu) {
                JOptionPane.showMessageDialog(dialog, "Por favor, selecione uma opção!");
            } else {
                dialog.dispose();
            }
        });
        dialog.add(btnConfirmar);

        dialog.setVisible(true);
    }
}


