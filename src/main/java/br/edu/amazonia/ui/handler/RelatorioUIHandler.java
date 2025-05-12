package main.java.br.edu.amazonia.ui.handler;

import main.java.br.edu.amazonia.service.RelatorioService;
import main.java.br.edu.amazonia.service.impl.RelatorioServiceImpl;
import main.java.br.edu.amazonia.ui.util.ConsoleUtils;
import main.java.br.edu.amazonia.exception.UniversidadeException;

import main.java.br.edu.amazonia.dao.impl.*;
import main.java.br.edu.amazonia.service.impl.*;
import main.java.br.edu.amazonia.service.*;

public class RelatorioUIHandler {

    private RelatorioService relatorioService;

    public RelatorioUIHandler() {
        AlunoService alunoService = new AlunoServiceImpl(new RepositorioAlunoCSV("alunos.csv"));
        ProfessorService professorService = new ProfessorServiceImpl(new RepositorioProfessorCSV("professores.csv"));
        CursoService cursoService = new CursoServiceImpl(new RepositorioCursoCSV("cursos.csv"));
        DisciplinaService disciplinaService = new DisciplinaServiceImpl(new RepositorioDisciplinaCSV("disciplina.csv"));
        AvaliacaoService avaliacaoService = new AvaliacaoServiceImpl(new RepositorioAvaliacaoCSV("avaliacao.csv"));

        this.relatorioService = new RelatorioServiceImpl(
                alunoService,
                professorService,
                cursoService,
                disciplinaService,
                avaliacaoService
        );
    }

    public void menuRelatorios() {
        boolean sair = false;
        while (!sair) {
            try {
                System.out.println("\n=== MENU DE RELATÓRIOS ===");
                System.out.println("1. Alunos por Curso");
                System.out.println("2. Professores por Curso");
                System.out.println("3. Disciplinas por Curso");
                System.out.println("4. Avaliações por Disciplina");
                System.out.println("5. Desempenho Acadêmico de Aluno");
                System.out.println("6. Relatório Completo (Exemplo)");
                System.out.println("0. Voltar ao Menu Principal");

                int opc = ConsoleUtils.lerInteiro("Escolha uma opção: ");
                switch (opc) {
                    case 1:
                        gerarRelatorioAlunosPorCurso();
                        break;
                    case 2:
                        gerarRelatorioProfessoresPorCurso();
                        break;
                    case 3:
                        gerarRelatorioDisciplinasPorCurso();
                        break;
                    case 4:
                        gerarRelatorioAvaliacoesPorDisciplina();
                        break;
                    case 5:
                        gerarRelatorioDesempenhoAluno();
                        break;
                    case 6:
                        relatorioService.gerarRelatorioCompleto();
                        break;
                    case 0:
                        sair = true;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (UniversidadeException ex) {
                System.out.println("[ERRO] " + ex.getMessage());
            } catch (Exception e) {
                System.out.println("[ERRO INESPERADO] " + e.getMessage());
            }
        }
    }

    private void gerarRelatorioAlunosPorCurso() {
        String curso = ConsoleUtils.lerLinha("Digite o ID ou Nome do Curso: ");
        relatorioService.relatorioAlunosPorCurso(curso);
    }

    private void gerarRelatorioProfessoresPorCurso() {
        String curso = ConsoleUtils.lerLinha("Digite o ID ou Nome do Curso: ");
        relatorioService.relatorioProfessoresPorCurso(curso);
    }

    private void gerarRelatorioDisciplinasPorCurso() {
        String curso = ConsoleUtils.lerLinha("Digite o ID ou Nome do Curso: ");
        relatorioService.relatorioDisciplinasPorCurso(curso);
    }

    private void gerarRelatorioAvaliacoesPorDisciplina() {
        String disc = ConsoleUtils.lerLinha("Digite o ID ou Nome da Disciplina: ");
        relatorioService.relatorioAvaliacoesPorDisciplina(disc);
    }

    private void gerarRelatorioDesempenhoAluno() {
        String aluno = ConsoleUtils.lerLinha("Digite o ID ou RA do Aluno: ");
        relatorioService.relatorioDesempenhoAcademicoAluno(aluno);
    }
}