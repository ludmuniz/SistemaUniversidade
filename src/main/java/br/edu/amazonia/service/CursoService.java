package main.java.br.edu.amazonia.service;

import main.java.br.edu.amazonia.model.Curso;
import java.util.List;

public interface CursoService {
    Curso criarCurso(Curso curso);
    Curso buscarCursoPorId(int id);
    List<Curso> listarCursos();
    void removerCurso(int id);
}