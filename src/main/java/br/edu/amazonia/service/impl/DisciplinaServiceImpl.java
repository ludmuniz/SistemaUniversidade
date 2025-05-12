package main.java.br.edu.amazonia.service.impl;

import main.java.br.edu.amazonia.dao.RepositorioDisciplina;
import main.java.br.edu.amazonia.model.Disciplina;
import main.java.br.edu.amazonia.service.DisciplinaService;
import java.util.List;

public class DisciplinaServiceImpl implements DisciplinaService {
    private RepositorioDisciplina repositorioDisciplina;

    public DisciplinaServiceImpl(RepositorioDisciplina repositorioDisciplina) {
        this.repositorioDisciplina = repositorioDisciplina;
    }

    @Override
    public Disciplina criarDisciplina(Disciplina disciplina) {
        if (disciplina.getNome() == null || disciplina.getNome().isEmpty()) {
            throw new RuntimeException("Nome da disciplina não pode ser vazio!");
        }
        return repositorioDisciplina.salvar(disciplina);
    }

    @Override
    public Disciplina buscarDisciplinaPorId(int id) {
        return repositorioDisciplina.buscarPorId(id);
    }

    @Override
    public List<Disciplina> listarDisciplinas() {
        return repositorioDisciplina.listarTodos();
    }

    @Override
    public void removerDisciplina(int id) {
        repositorioDisciplina.remover(id);
    }
}
