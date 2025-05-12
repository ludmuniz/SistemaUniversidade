package main.java.br.edu.amazonia.ui.handler;

import main.java.br.edu.amazonia.service.DisciplinaService;
import main.java.br.edu.amazonia.service.impl.DisciplinaServiceImpl;
import main.java.br.edu.amazonia.dao.impl.RepositorioDisciplinaCSV;
import main.java.br.edu.amazonia.model.Disciplina;
import main.java.br.edu.amazonia.ui.util.ConsoleUtils;
import java.util.List;

public class DisciplinaUIHandler {
    private DisciplinaService disciplinaService;

    public DisciplinaUIHandler() {
        this.disciplinaService = new DisciplinaServiceImpl(
                new RepositorioDisciplinaCSV("disciplina.csv"));
    }

    public void gerenciarDisciplina() {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n=== GESTÃO DE DISCIPLINAS ===");
            System.out.println("1. Cadastrar Disciplina");
            System.out.println("2. Listar Disciplinas");
            System.out.println("3. Buscar Disciplina por ID");
            System.out.println("4. Remover Disciplina");
            System.out.println("0. Voltar");

            int opc = ConsoleUtils.lerInteiro("Escolha uma opção: ");
            switch (opc) {
                case 1:
                    cadastrarDisciplina();
                    break;
                case 2:
                    listarDisciplinas();
                    break;
                case 3:
                    buscarDisciplinaPorId();
                    break;
                case 4:
                    removerDisciplina();
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void cadastrarDisciplina() {
        String nome = ConsoleUtils.lerLinha("Nome da Disciplina: ");
        int idProfessor = ConsoleUtils.lerInteiro("ID do Professor: ");
        int idCurso = ConsoleUtils.lerInteiro("ID do Curso: ");
        Disciplina disciplina = new Disciplina(0, nome, idProfessor, idCurso);
        Disciplina salva = disciplinaService.criarDisciplina(disciplina);
        System.out.println("Disciplina salva com ID: " + salva.getId());
    }

    private void listarDisciplinas() {
        List<Disciplina> disciplinas = disciplinaService.listarDisciplinas();
        for (Disciplina d : disciplinas) {
            System.out.println("ID: " + d.getId() + " | Nome: " + d.getNome()
                    + " | Professor: " + d.getIdProfessor()
                    + " | Curso: " + d.getIdCurso());
        }
    }

    private void buscarDisciplinaPorId() {
        int id = ConsoleUtils.lerInteiro("ID da Disciplina: ");
        Disciplina d = disciplinaService.buscarDisciplinaPorId(id);
        if (d != null) {
            System.out.println("Disciplina: " + d.getNome());
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    private void removerDisciplina() {
        int id = ConsoleUtils.lerInteiro("ID da Disciplina a remover: ");
        disciplinaService.removerDisciplina(id);
        System.out.println("Disciplina removida, se existente.");
    }
}