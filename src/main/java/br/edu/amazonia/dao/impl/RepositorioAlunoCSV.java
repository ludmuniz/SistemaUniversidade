package main.java.br.edu.amazonia.dao.impl;

import main.java.br.edu.amazonia.dao.RepositorioAluno;
import main.java.br.edu.amazonia.model.Aluno;

public class RepositorioAlunoCSV extends AbstractRepositorioCSV<Aluno> implements RepositorioAluno {

    public RepositorioAlunoCSV(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    @Override
    protected Aluno converterLinhaEmEntidade(String linha) {
        // Formato: id;nome;ra;id_curso
        String[] campos = linha.split(";");
        if (campos.length < 4) return null;
        int id = Integer.parseInt(campos[0]);
        String nome = campos[1];
        String ra = campos[2];
        int idCurso = Integer.parseInt(campos[3]);
        return new Aluno(id, nome, ra, idCurso);
    }

    @Override
    protected String converterEntidadeEmLinha(Aluno entidade) {
        return String.format("%d;%s;%s;%d",
                entidade.getId(), entidade.getNome(),
                entidade.getRa(), entidade.getIdCurso());
    }

    @Override
    protected int getEntidadeId(Aluno entidade) {
        return entidade.getId();
    }

    @Override
    protected void setEntidadeId(Aluno entidade, int novoId) {
        entidade.setId(novoId);
    }
}
