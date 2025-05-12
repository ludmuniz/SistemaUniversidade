package main.java.br.edu.amazonia.dao.impl;

import main.java.br.edu.amazonia.dao.RepositorioDisciplina;
import main.java.br.edu.amazonia.model.Disciplina;

public class RepositorioDisciplinaCSV extends AbstractRepositorioCSV<Disciplina> implements RepositorioDisciplina {

    public RepositorioDisciplinaCSV(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    @Override
    protected Disciplina converterLinhaEmEntidade(String linha) {
        // Formato: id;nome;id_professor;id_curso
        String[] campos = linha.split(";");
        if (campos.length < 4) return null;
        int id = Integer.parseInt(campos[0]);
        String nome = campos[1];
        int idProfessor = Integer.parseInt(campos[2]);
        int idCurso = Integer.parseInt(campos[3]);
        return new Disciplina(id, nome, idProfessor, idCurso);
    }

    @Override
    protected String converterEntidadeEmLinha(Disciplina entidade) {
        return String.format("%d;%s;%d;%d",
                entidade.getId(), entidade.getNome(),
                entidade.getIdProfessor(), entidade.getIdCurso());
    }

    @Override
    protected int getEntidadeId(Disciplina entidade) {
        return entidade.getId();
    }

    @Override
    protected void setEntidadeId(Disciplina entidade, int novoId) {
        entidade.setId(novoId);
    }
}