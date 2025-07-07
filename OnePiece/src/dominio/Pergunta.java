package dominio;

import java.util.List;

public class Pergunta {
    private String enunciado;
    private List<String> opcoes;
    private String respostaCorreta;

    public Pergunta(String enunciado, List<String> opcoes, String respostaCorreta) {
        this.enunciado = enunciado;
        this.opcoes = opcoes;
        this.respostaCorreta = respostaCorreta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public List<String> getOpcoes() {
        return opcoes;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }
}

