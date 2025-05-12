package main.java.br.edu.amazonia.service.impl;

import main.java.br.edu.amazonia.dao.RepositorioAluno;
import main.java.br.edu.amazonia.model.Aluno;
import main.java.br.edu.amazonia.service.AlunoService;
import java.util.List;

public class AlunoServiceImpl implements AlunoService {
    private RepositorioAluno repositorioAluno;

    public AlunoServiceImpl(RepositorioAluno repositorio) {
        this.repositorioAluno = repositorio;
    }

    @Override
    public Aluno criarAluno(Aluno aluno) {
        if (aluno.getNome() == null || aluno.getNome().isEmpty()) {
            throw new RuntimeException("Nome não pode ser vazio!");
        }
        return repositorioAluno.salvar(aluno);
    }

    @Override
    public Aluno buscarAlunoPorId(int id) {
        return repositorioAluno.buscarPorId(id);
    }

    @Override
    public List<Aluno> listarAlunos() {
        return repositorioAluno.listarTodos();
    }

    @Override
    public void removerAluno(int id) {
        repositorioAluno.remover(id);
    }
}
