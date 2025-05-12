package main.java.br.edu.amazonia.service.impl;

import main.java.br.edu.amazonia.dao.RepositorioAvaliacao;
import main.java.br.edu.amazonia.model.Avaliacao;
import main.java.br.edu.amazonia.service.AvaliacaoService;
import java.util.List;

public class AvaliacaoServiceImpl implements AvaliacaoService {
    private RepositorioAvaliacao repositorioAvaliacao;

    public AvaliacaoServiceImpl(RepositorioAvaliacao repositorioAvaliacao) {
        this.repositorioAvaliacao = repositorioAvaliacao;
    }

    @Override
    public Avaliacao criarOuAtualizarAvaliacao(Avaliacao avaliacao) {
        if (avaliacao.getIdAluno() <= 0) {
            throw new RuntimeException("Aluno inválido para avaliação!");
        }
        return repositorioAvaliacao.salvar(avaliacao);
    }

    @Override
    public Avaliacao buscarAvaliacaoPorId(int id) {
        return repositorioAvaliacao.buscarPorId(id);
    }

    @Override
    public List<Avaliacao> listarAvaliacoes() {
        return repositorioAvaliacao.listarTodos();
    }

    @Override
    public void removerAvaliacao(int id) {
        repositorioAvaliacao.remover(id);
    }
}