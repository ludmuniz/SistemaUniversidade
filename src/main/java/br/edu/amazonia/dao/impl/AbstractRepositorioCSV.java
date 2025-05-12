package main.java.br.edu.amazonia.dao.impl;

import java.util.ArrayList;
import java.util.List;
import main.java.br.edu.amazonia.dao.Repositorio;
import main.java.br.edu.amazonia.utils.csv.CsvUtils;
import java.io.File;
import java.io.IOException;

public abstract class AbstractRepositorioCSV<T> implements Repositorio<T> {

    protected List<T> listaEntidades;
    protected File arquivoCSV;

    public AbstractRepositorioCSV(String caminhoArquivo) {
        this.arquivoCSV = new File(caminhoArquivo);
        this.listaEntidades = new ArrayList<>();
        carregarDoCSV();
    }

    protected abstract T converterLinhaEmEntidade(String linha);
    protected abstract String converterEntidadeEmLinha(T entidade);
    protected abstract int getEntidadeId(T entidade);
    protected abstract void setEntidadeId(T entidade, int novoId);

    protected void carregarDoCSV() {
        try {
            List<String> linhas = CsvUtils.lerLinhas(arquivoCSV);
            for (String linha : linhas) {
                T entidade = converterLinhaEmEntidade(linha);
                if (entidade != null) {
                    listaEntidades.add(entidade);
                }
            }
        } catch (IOException e) {
            // Caso não exista o arquivo, inicia a lista vazia.
        }
    }

    protected void salvarNoCSV() {
        List<String> linhas = new ArrayList<>();
        for (T entidade : listaEntidades) {
            linhas.add(converterEntidadeEmLinha(entidade));
        }
        try {
            CsvUtils.escreverLinhas(arquivoCSV, linhas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T salvar(T entidade) {
        // Se ID = 0, significa que é novo registro
        if (getEntidadeId(entidade) == 0) {
            int novoId = gerarNovoId();
            setEntidadeId(entidade, novoId);
            listaEntidades.add(entidade);
        } else {
            // Atualização
            for (int i=0; i<listaEntidades.size(); i++) {
                T e = listaEntidades.get(i);
                if (getEntidadeId(e) == getEntidadeId(entidade)) {
                    listaEntidades.set(i, entidade);
                    break;
                }
            }
        }
        salvarNoCSV();
        return entidade;
    }

    @Override
    public T buscarPorId(int id) {
        for (T entidade : listaEntidades) {
            if (getEntidadeId(entidade) == id) {
                return entidade;
            }
        }
        return null;
    }

    @Override
    public List<T> listarTodos() {
        return listaEntidades;
    }

    @Override
    public void remover(int id) {
        listaEntidades.removeIf(e -> getEntidadeId(e) == id);
        salvarNoCSV();
    }

    private int gerarNovoId() {
        int maiorId = 0;
        for (T entidade : listaEntidades) {
            int id = getEntidadeId(entidade);
            if (id > maiorId) {
                maiorId = id;
            }
        }
        return maiorId + 1;
    }
}


