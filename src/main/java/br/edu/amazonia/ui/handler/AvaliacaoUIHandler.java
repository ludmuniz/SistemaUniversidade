package main.java.br.edu.amazonia.ui.handler;

import main.java.br.edu.amazonia.service.AvaliacaoService;
import main.java.br.edu.amazonia.service.impl.AvaliacaoServiceImpl;
import main.java.br.edu.amazonia.dao.impl.RepositorioAvaliacaoCSV;
import main.java.br.edu.amazonia.model.Avaliacao;
import main.java.br.edu.amazonia.ui.util.ConsoleUtils;
import java.util.List;

public class AvaliacaoUIHandler {
    private AvaliacaoService avaliacaoService;

    public AvaliacaoUIHandler() {
        this.avaliacaoService = new AvaliacaoServiceImpl(
                new RepositorioAvaliacaoCSV("avaliacao.csv"));
    }

    public void gerenciarAvaliacao() {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n=== GESTÃO DE AVALIAÇÕES ===");
            System.out.println("1. Registrar ou atualizar Avaliação");
            System.out.println("2. Listar Avaliações");
            System.out.println("3. Buscar Avaliação por ID");
            System.out.println("4. Remover Avaliação");
            System.out.println("0. Voltar");

            int opc = ConsoleUtils.lerInteiro("Escolha uma opção: ");
            switch (opc) {
                case 1:
                    registrarAvaliacao();
                    break;
                case 2:
                    listarAvaliacoes();
                    break;
                case 3:
                    buscarAvaliacaoPorId();
                    break;
                case 4:
                    removerAvaliacao();
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void registrarAvaliacao() {
        int idAluno = ConsoleUtils.lerInteiro("ID do Aluno: ");
        int idDisciplina = ConsoleUtils.lerInteiro("ID da Disciplina: ");

        // Perguntas conforme especificado: se não fez NP1, pergunta substitutiva; se não fez NP2, pergunta substitutiva; se média < 7, pergunta exame
        boolean fezNP1 = ConsoleUtils.lerBoolean("Fez NP1? (S/N): ");
        double notaNP1;
        if (fezNP1) {
            notaNP1 = ConsoleUtils.lerDouble("Nota NP1: ");
        } else {
            notaNP1 = ConsoleUtils.lerDouble("Nota substitutiva para NP1: ");
        }

        boolean fezNP2 = ConsoleUtils.lerBoolean("Fez NP2? (S/N): ");
        double notaNP2;
        if (fezNP2) {
            notaNP2 = ConsoleUtils.lerDouble("Nota NP2: ");
        } else {
            notaNP2 = ConsoleUtils.lerDouble("Nota substitutiva para NP2: ");
        }

        double media = (notaNP1 + notaNP2) / 2.0;
        double notaExame = 0.0;
        if (media < 7.0) {
            notaExame = ConsoleUtils.lerDouble("Nota do exame: ");
        }

        // Criando objeto de Avaliacao (id=0 => novo registro)
        Avaliacao avaliacao = new Avaliacao(0, idAluno, idDisciplina, notaNP1, notaNP2, notaExame);
        Avaliacao salva = avaliacaoService.criarOuAtualizarAvaliacao(avaliacao);
        System.out.println("Avaliação salva com ID: " + salva.getId());
    }

    private void listarAvaliacoes() {
        List<Avaliacao> avaliacoes = avaliacaoService.listarAvaliacoes();
        for (Avaliacao a : avaliacoes) {
            System.out.println("ID: " + a.getId()
                    + " | Aluno: " + a.getIdAluno()
                    + " | Disciplina: " + a.getIdDisciplina()
                    + " | NP1: " + a.getNotaNP1()
                    + " | NP2: " + a.getNotaNP2()
                    + " | Exame: " + a.getNotaExame());
        }
    }

    private void buscarAvaliacaoPorId() {
        int id = ConsoleUtils.lerInteiro("ID da Avaliação: ");
        Avaliacao av = avaliacaoService.buscarAvaliacaoPorId(id);
        if (av != null) {
            System.out.println("Avaliação encontrada! Aluno: " + av.getIdAluno()
                    + " | Disciplina: " + av.getIdDisciplina());
        } else {
            System.out.println("Avaliação não encontrada.");
        }
    }

    private void removerAvaliacao() {
        int id = ConsoleUtils.lerInteiro("Informe o ID da Avaliação a remover: ");
        avaliacaoService.removerAvaliacao(id);
        System.out.println("Avaliação removida, se existente.");
    }
}
