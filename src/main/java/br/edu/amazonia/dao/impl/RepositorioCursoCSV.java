package main.java.br.edu.amazonia.dao.impl;

import main.java.br.edu.amazonia.dao.RepositorioCurso;
import main.java.br.edu.amazonia.model.Curso;

public class RepositorioCursoCSV extends AbstractRepositorioCSV<Curso> implements RepositorioCurso {

    public RepositorioCursoCSV(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    @Override
    protected Curso converterLinhaEmEntidade(String linha) {
        // Formato: id;nome;nível;ano
        String[] campos = linha.split(";");
        if (campos.length < 4) return null;
        int id = Integer.parseInt(campos[0]);
        String nome = campos[1];
        String nivel = campos[2];
        int ano = Integer.parseInt(campos[3]);
        return new Curso(id, nome, nivel, ano);
    }

    @Override
    protected String converterEntidadeEmLinha(Curso entidade) {
        return String.format("%d;%s;%s;%d",
                entidade.getId(), entidade.getNome(),
                entidade.getNivel(), entidade.getAno());
    }

    @Override
    protected int getEntidadeId(Curso entidade) {
        return entidade.getId();
    }

    @Override
    protected void setEntidadeId(Curso entidade, int novoId) {
        entidade.setId(novoId);
    }
}
