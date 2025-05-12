package main.java.br.edu.amazonia.ui.handler;

import main.java.br.edu.amazonia.service.CursoService;
import main.java.br.edu.amazonia.service.impl.CursoServiceImpl;
import main.java.br.edu.amazonia.dao.impl.RepositorioCursoCSV;
import main.java.br.edu.amazonia.model.Curso;
import main.java.br.edu.amazonia.ui.util.ConsoleUtils;
import java.util.List;

public class CursoUIHandler {
    private CursoService cursoService;

    public CursoUIHandler() {
        this.cursoService = new CursoServiceImpl(
                new RepositorioCursoCSV("cursos.csv"));
    }

    public void gerenciarCurso() {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n=== GESTÃO DE CURSOS ===");
            System.out.println("1. Cadastrar Curso");
            System.out.println("2. Listar Cursos");
            System.out.println("3. Buscar Curso por ID");
            System.out.println("4. Remover Curso");
            System.out.println("0. Voltar");

            int opc = ConsoleUtils.lerInteiro("Escolha uma opção: ");
            switch (opc) {
                case 1:
                    cadastrarCurso();
                    break;
                case 2:
                    listarCursos();
                    break;
                case 3:
                    buscarCursoPorId();
                    break;
                case 4:
                    removerCurso();
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void cadastrarCurso() {
        String nome = ConsoleUtils.lerLinha("Nome do Curso: ");
        String nivel = ConsoleUtils.lerLinha("Nível (Graduação, Pós, etc.): ");
        int ano = ConsoleUtils.lerInteiro("Ano: ");
        Curso curso = new Curso(0, nome, nivel, ano);
        Curso salvo = cursoService.criarCurso(curso);
        System.out.println("Curso salvo com ID: " + salvo.getId());
    }

    private void listarCursos() {
        List<Curso> cursos = cursoService.listarCursos();
        for (Curso c : cursos) {
            System.out.println("ID: " + c.getId() + " | Nome: " + c.getNome()
                    + " | Nível: " + c.getNivel()
                    + " | Ano: " + c.getAno());
        }
    }

    private void buscarCursoPorId() {
        int id = ConsoleUtils.lerInteiro("ID do Curso: ");
        Curso curso = cursoService.buscarCursoPorId(id);
        if (curso != null) {
            System.out.println("Curso encontrado: " + curso.getNome());
        } else {
            System.out.println("Curso não encontrado.");
        }
    }

    private void removerCurso() {
        int id = ConsoleUtils.lerInteiro("ID do Curso a remover: ");
        cursoService.removerCurso(id);
        System.out.println("Curso removido, se existente.");
    }
}
