package main.java.br.edu.amazonia.dao.factory;

import main.java.br.edu.amazonia.model.*;

// Exemplo de uso do Factory Pattern para criar entidades dinamicamente.
public class EntidadeFactory {

    public static Object criarEntidade(String tipo) {
        // Ex.: "ALUNO", "PROFESSOR", "CURSO"...
        switch (tipo.toUpperCase()) {
            case "ALUNO":
                return new Aluno();
            case "PROFESSOR":
                return new Professor();
            case "CURSO":
                return new Curso();
            case "DISCIPLINA":
                return new Disciplina();
            case "AVALIACAO":
                return new Avaliacao();
            default:
                return null;
        }
    }
}


