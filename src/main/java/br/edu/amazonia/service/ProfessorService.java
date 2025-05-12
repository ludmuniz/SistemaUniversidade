package main.java.br.edu.amazonia.service;

import main.java.br.edu.amazonia.model.Professor;
import java.util.List;

public interface ProfessorService {
    Professor criarProfessor(Professor professor);
    Professor buscarProfessorPorId(int id);
    List<Professor> listarProfessores();
    void removerProfessor(int id);
}