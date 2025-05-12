package main.java.br.edu.amazonia.service;

import main.java.br.edu.amazonia.model.Disciplina;
import java.util.List;

public interface DisciplinaService {
    Disciplina criarDisciplina(Disciplina disciplina);
    Disciplina buscarDisciplinaPorId(int id);
    List<Disciplina> listarDisciplinas();
    void removerDisciplina(int id);
}