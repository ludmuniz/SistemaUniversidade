package main.java.br.edu.amazonia.service.impl;

import main.java.br.edu.amazonia.dao.RepositorioCurso;
import main.java.br.edu.amazonia.model.Curso;
import main.java.br.edu.amazonia.service.CursoService;
import java.util.List;

public class CursoServiceImpl implements CursoService {
    private RepositorioCurso repositorioCurso;

    public CursoServiceImpl(RepositorioCurso repositorioCurso) {
        this.repositorioCurso = repositorioCurso;
    }

    @Override
    public Curso criarCurso(Curso curso) {
        if (curso.getNome() == null || curso.getNome().isEmpty()) {
            throw new RuntimeException("Nome do curso não pode ser vazio!");
        }
        return repositorioCurso.salvar(curso);
    }

    @Override
    public Curso buscarCursoPorId(int id) {
        return repositorioCurso.buscarPorId(id);
    }

    @Override
    public List<Curso> listarCursos() {
        return repositorioCurso.listarTodos();
    }

    @Override
    public void removerCurso(int id) {
        repositorioCurso.remover(id);
    }
}
