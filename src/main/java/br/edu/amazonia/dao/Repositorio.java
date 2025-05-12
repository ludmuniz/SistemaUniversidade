package main.java.br.edu.amazonia.dao;

import java.util.List;

public interface Repositorio<T> {
    T salvar(T entidade);
    T buscarPorId(int id);
    List<T> listarTodos();
    void remover(int id);
}


