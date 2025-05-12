package main.java.br.edu.amazonia.ui;

import main.java.br.edu.amazonia.ui.handler.*;
import main.java.br.edu.amazonia.ui.util.ConsoleUtils;

public class MainMenuUI {

    private AlunoUIHandler alunoUI;
    private ProfessorUIHandler professorUI;
    private CursoUIHandler cursoUI;
    private DisciplinaUIHandler disciplinaUI;
    private AvaliacaoUIHandler avaliacaoUI;
    private RelatorioUIHandler relatorioUI;

    public MainMenuUI() {
        this.alunoUI = new AlunoUIHandler();
        this.professorUI = new ProfessorUIHandler();
        this.cursoUI = new CursoUIHandler();
        this.disciplinaUI = new DisciplinaUIHandler();
        this.avaliacaoUI = new AvaliacaoUIHandler();
        this.relatorioUI = new RelatorioUIHandler();
    }

    public void exibirMenuPrincipal() {
        boolean executando = true;
        while (executando) {
            try {
                System.out.println("\n=== MENU PRINCIPAL ===");
                System.out.println("1. Alunos");
                System.out.println("2. Professores");
                System.out.println("3. Cursos");
                System.out.println("4. Disciplinas");
                System.out.println("5. Avaliações");
                System.out.println("6. Relatórios");
                System.out.println("0. Sair");

                int opcao = ConsoleUtils.lerInteiro("Escolha uma opção: ");

                switch (opcao) {
                    case 1:
                        alunoUI.gerenciarAluno();
                        break;
                    case 2:
                        professorUI.gerenciarProfessor();
                        break;
                    case 3:
                        cursoUI.gerenciarCurso();
                        break;
                    case 4:
                        disciplinaUI.gerenciarDisciplina();
                        break;
                    case 5:
                        avaliacaoUI.gerenciarAvaliacao();
                        break;
                    case 6:
                        relatorioUI.menuRelatorios();
                        break;
                    case 0:
                        executando = false;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
        System.out.println("Encerrando o sistema...");
    }
}
