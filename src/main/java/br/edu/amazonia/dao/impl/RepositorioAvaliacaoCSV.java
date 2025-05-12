package main.java.br.edu.amazonia.dao.impl;

import main.java.br.edu.amazonia.dao.RepositorioAvaliacao;
import main.java.br.edu.amazonia.model.Avaliacao;

public class RepositorioAvaliacaoCSV extends AbstractRepositorioCSV<Avaliacao> implements RepositorioAvaliacao {

    public RepositorioAvaliacaoCSV(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    @Override
    protected Avaliacao converterLinhaEmEntidade(String linha) {
        String[] campos = linha.split(";");
        if (campos.length < 6) return null;

        int id = Integer.parseInt(campos[0]);
        int idAluno = Integer.parseInt(campos[1]);
        int idDisciplina = Integer.parseInt(campos[2]);
        double notaNP1 = parseDouble(campos[3]);
        double notaNP2 = parseDouble(campos[4]);
        double notaExame = parseDouble(campos[5]);

        return new Avaliacao(id, idAluno, idDisciplina, notaNP1, notaNP2, notaExame);
    }
    private double parseDouble(String valor) { valor = valor.replace(",", "."); return Double.parseDouble(valor); }

    @Override
    protected String converterEntidadeEmLinha(Avaliacao entidade) {
        return String.format("%d;%d;%d;%.2f;%.2f;%.2f",
                entidade.getId(), entidade.getIdAluno(),
                entidade.getIdDisciplina(), entidade.getNotaNP1(),
                entidade.getNotaNP2(), entidade.getNotaExame());
    }

    @Override
    protected int getEntidadeId(Avaliacao entidade) {
        return entidade.getId();
    }

    @Override
    protected void setEntidadeId(Avaliacao entidade, int novoId) {
        entidade.setId(novoId);
    }
}

