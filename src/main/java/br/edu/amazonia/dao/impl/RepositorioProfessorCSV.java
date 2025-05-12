package main.java.br.edu.amazonia.dao.impl;

import main.java.br.edu.amazonia.dao.RepositorioProfessor;
import main.java.br.edu.amazonia.model.Professor;

public class RepositorioProfessorCSV extends AbstractRepositorioCSV<Professor> implements RepositorioProfessor {

    public RepositorioProfessorCSV(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    @Override
    protected Professor converterLinhaEmEntidade(String linha) {
        // Formato: id;nome
        String[] campos = linha.split(";");
        if (campos.length < 2) return null;
        int id = Integer.parseInt(campos[0]);
        String nome = campos[1];
        return new Professor(id, nome);
    }

    @Override
    protected String converterEntidadeEmLinha(Professor entidade) {
        return String.format("%d;%s",
                entidade.getId(), entidade.getNome());
    }

    @Override
    protected int getEntidadeId(Professor entidade) {
        return entidade.getId();
    }

    @Override
    protected void setEntidadeId(Professor entidade, int novoId) {
        entidade.setId(novoId);
    }
}
