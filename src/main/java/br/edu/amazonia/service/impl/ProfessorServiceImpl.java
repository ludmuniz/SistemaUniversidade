package main.java.br.edu.amazonia.service.impl;

import main.java.br.edu.amazonia.dao.RepositorioProfessor;
import main.java.br.edu.amazonia.model.Professor;
import main.java.br.edu.amazonia.service.ProfessorService;
import java.util.List;

public class ProfessorServiceImpl implements ProfessorService {
    private RepositorioProfessor repositorioProfessor;

    public ProfessorServiceImpl(RepositorioProfessor repositorioProfessor) {
        this.repositorioProfessor = repositorioProfessor;
    }

    @Override
    public Professor criarProfessor(Professor professor) {
        // Validações
        if (professor.getNome() == null || professor.getNome().isEmpty()) {
            throw new RuntimeException("Nome do professor não pode ser vazio!");
        }
        return repositorioProfessor.salvar(professor);
    }

    @Override
    public Professor buscarProfessorPorId(int id) {
        return repositorioProfessor.buscarPorId(id);
    }

    @Override
    public List<Professor> listarProfessores() {
        return repositorioProfessor.listarTodos();
    }

    @Override
    public void removerProfessor(int id) {
        repositorioProfessor.remover(id);
    }
}