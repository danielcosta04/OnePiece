package controle;

import dominio.Pergunta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizController {
    private static final String URL = "jdbc:mysql://localhost:3306/onepiece_quiz";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Map<Integer, List<Pergunta>> perguntasPorGrupo;
    private Map<Integer, List<Integer>> indicesExibidos;

    public QuizController() {
        perguntasPorGrupo = new HashMap<>();
        indicesExibidos = new HashMap<>();
        carregarPerguntas();
    }

    private void carregarPerguntas() {
        String sql = "SELECT grupo, enunciado, opcao1, opcao2, opcao3, respostaCorreta FROM perguntas";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int grupo = rs.getInt("grupo");
                String enunciado = rs.getString("enunciado");
                String[] opcoes = {rs.getString("opcao1"), rs.getString("opcao2"), rs.getString("opcao3")};
                String respostaCorreta = rs.getString("respostaCorreta");
                Pergunta pergunta = new Pergunta(enunciado, List.of(opcoes), respostaCorreta);

                perguntasPorGrupo.computeIfAbsent(grupo, k -> new ArrayList<>()).add(pergunta);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao acessar o banco de dados: " + e.getMessage());
        }

        for (int grupo = 1; grupo <= 10; grupo++) {
            indicesExibidos.put(grupo, new ArrayList<>());
        }
    }

    public Pergunta getProximaPergunta(int grupo) {
        List<Pergunta> perguntas = perguntasPorGrupo.getOrDefault(grupo, new ArrayList<>());
        List<Integer> exibidos = indicesExibidos.get(grupo);

        if (exibidos.size() >= perguntas.size()) {
            exibidos.clear();
        }

        List<Integer> indicesDisponiveis = new ArrayList<>();
        for (int i = 0; i < perguntas.size(); i++) {
            if (!exibidos.contains(i)) {
                indicesDisponiveis.add(i);
            }
        }

        if (indicesDisponiveis.isEmpty()) {
            return null;
        }

        Collections.shuffle(indicesDisponiveis);
        int indice = indicesDisponiveis.get(0);
        exibidos.add(indice);
        return perguntas.get(indice);
    }
}

