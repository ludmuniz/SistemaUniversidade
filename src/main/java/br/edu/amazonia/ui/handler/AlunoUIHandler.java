package main.java.br.edu.amazonia.ui.handler;

import main.java.br.edu.amazonia.ui.util.ConsoleUtils;
import main.java.br.edu.amazonia.service.AlunoService;
import main.java.br.edu.amazonia.service.impl.AlunoServiceImpl;
import main.java.br.edu.amazonia.dao.impl.RepositorioAlunoCSV;
import main.java.br.edu.amazonia.model.Aluno;
import java.util.List;

public class AlunoUIHandler {

    private AlunoService alunoService;

    public AlunoUIHandler() {
        this.alunoService = new AlunoServiceImpl(
                new RepositorioAlunoCSV("alunos.csv"));
    }

    public void gerenciarAluno() {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n=== GESTÃO DE ALUNOS ===");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Listar Alunos");
            System.out.println("3. Buscar Aluno por ID");
            System.out.println("4. Remover Aluno");
            System.out.println("0. Voltar");

            int opc = ConsoleUtils.lerInteiro("Escolha uma opção: ");

            switch (opc) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    listarAlunos();
                    break;
                case 3:
                    buscarAlunoPorId();
                    break;
                case 4:
                    removerAluno();
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void cadastrarAluno() {
        String nome = ConsoleUtils.lerLinha("Nome do Aluno: ");
        String ra = ConsoleUtils.lerLinha("RA do Aluno: ");
        int idCurso = ConsoleUtils.lerInteiro("ID do Curso: ");
        Aluno aluno = new Aluno(0, nome, ra, idCurso);
        Aluno salvo = alunoService.criarAluno(aluno);
        System.out.println("Aluno salvo com ID: " + salvo.getId());
    }

    private void listarAlunos() {
        List<Aluno> alunos = alunoService.listarAlunos();
        for (Aluno a : alunos) {
            System.out.println("ID: " + a.getId() + " | Nome: " + a.getNome()
                    + " | RA: " + a.getRa() + " | Curso: " + a.getIdCurso());
        }
    }

    private void buscarAlunoPorId() {
        int id = ConsoleUtils.lerInteiro("Informe o ID do Aluno: ");
        Aluno aluno = alunoService.buscarAlunoPorId(id);
        if (aluno != null) {
            System.out.println("Aluno encontrado: " + aluno.getNome());
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private void removerAluno() {
        int id = ConsoleUtils.lerInteiro("Informe o ID do Aluno a remover: ");
        alunoService.removerAluno(id);
        System.out.println("Aluno removido, se existente.");
    }
}

