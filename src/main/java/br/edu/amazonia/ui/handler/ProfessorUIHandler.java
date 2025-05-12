package main.java.br.edu.amazonia.ui.handler;

import main.java.br.edu.amazonia.service.ProfessorService;
import main.java.br.edu.amazonia.service.impl.ProfessorServiceImpl;
import main.java.br.edu.amazonia.dao.impl.RepositorioProfessorCSV;
import main.java.br.edu.amazonia.model.Professor;
import main.java.br.edu.amazonia.ui.util.ConsoleUtils;
import java.util.List;

public class ProfessorUIHandler {
    private ProfessorService professorService;

    public ProfessorUIHandler() {
        this.professorService = new ProfessorServiceImpl(
                new RepositorioProfessorCSV("professores.csv"));
    }

    public void gerenciarProfessor() {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n=== GESTÃO DE PROFESSORES ===");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Listar Professores");
            System.out.println("3. Buscar Professor por ID");
            System.out.println("4. Remover Professor");
            System.out.println("0. Voltar");

            int opc = ConsoleUtils.lerInteiro("Escolha uma opção: ");
            switch (opc) {
                case 1:
                    cadastrarProfessor();
                    break;
                case 2:
                    listarProfessores();
                    break;
                case 3:
                    buscarProfessorPorId();
                    break;
                case 4:
                    removerProfessor();
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void cadastrarProfessor() {
        String nome = ConsoleUtils.lerLinha("Nome do Professor: ");
        Professor professor = new Professor(0, nome);
        Professor salvo = professorService.criarProfessor(professor);
        System.out.println("Professor salvo com ID: " + salvo.getId());
    }

    private void listarProfessores() {
        List<Professor> professores = professorService.listarProfessores();
        for (Professor p : professores) {
            System.out.println("ID: " + p.getId() + " | Nome: " + p.getNome());
        }
    }

    private void buscarProfessorPorId() {
        int id = ConsoleUtils.lerInteiro("ID do Professor: ");
        Professor professor = professorService.buscarProfessorPorId(id);
        if (professor != null) {
            System.out.println("Professor: " + professor.getNome());
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    private void removerProfessor() {
        int id = ConsoleUtils.lerInteiro("ID do Professor a remover: ");
        professorService.removerProfessor(id);
        System.out.println("Professor removido, se existente.");
    }
}