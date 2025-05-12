package main.java.br.edu.amazonia.service;

import main.java.br.edu.amazonia.model.Aluno;
import java.util.List;

public interface AlunoService {
    Aluno criarAluno(Aluno aluno);
    Aluno buscarAlunoPorId(int id);
    List<Aluno> listarAlunos();
    void removerAluno(int id);
}
