package main.java.br.edu.amazonia.service;

import main.java.br.edu.amazonia.model.Avaliacao;
import java.util.List;

public interface AvaliacaoService {
    Avaliacao criarOuAtualizarAvaliacao(Avaliacao avaliacao);
    Avaliacao buscarAvaliacaoPorId(int id);
    List<Avaliacao> listarAvaliacoes();
    void removerAvaliacao(int id);
}