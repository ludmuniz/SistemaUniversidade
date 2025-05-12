package main.java.br.edu.amazonia.service.impl;

import main.java.br.edu.amazonia.service.RelatorioService;
import main.java.br.edu.amazonia.service.AlunoService;
import main.java.br.edu.amazonia.service.ProfessorService;
import main.java.br.edu.amazonia.service.CursoService;
import main.java.br.edu.amazonia.service.DisciplinaService;
import main.java.br.edu.amazonia.service.AvaliacaoService;
import main.java.br.edu.amazonia.model.*;
import main.java.br.edu.amazonia.exception.EntidadeNaoEncontradaException;

import java.util.List;

public class RelatorioServiceImpl implements RelatorioService {

    private AlunoService alunoService;
    private ProfessorService professorService;
    private CursoService cursoService;
    private DisciplinaService disciplinaService;
    private AvaliacaoService avaliacaoService;

    // Construtor
    public RelatorioServiceImpl(
            AlunoService alunoService,
            ProfessorService professorService,
            CursoService cursoService,
            DisciplinaService disciplinaService,
            AvaliacaoService avaliacaoService) {
        this.alunoService = alunoService;
        this.professorService = professorService;
        this.cursoService = cursoService;
        this.disciplinaService = disciplinaService;
        this.avaliacaoService = avaliacaoService;
    }

    @Override
    public void gerarRelatorioCompleto() {
        System.out.println("=== RELATÓRIO COMPLETO DA UNIVERSIDADE ===");
        System.out.println("- Total de Alunos: " + alunoService.listarAlunos().size());
        System.out.println("- Total de Professores: " + professorService.listarProfessores().size());
        System.out.println("- Total de Cursos: " + cursoService.listarCursos().size());
        System.out.println("- Total de Disciplinas: " + disciplinaService.listarDisciplinas().size());
        System.out.println("- Total de Avaliações: " + avaliacaoService.listarAvaliacoes().size());
    }

    // 1. Relatório de Alunos por Curso
    @Override
    public void relatorioAlunosPorCurso(String identificadorCurso) {
        Curso cursoEncontrado = localizarCursoPorIdOuNome(identificadorCurso);
        if (cursoEncontrado == null) {
            throw new EntidadeNaoEncontradaException("Curso não encontrado!");
        }

        System.out.println("===================================");
        System.out.println("RELATÓRIO: ALUNOS POR CURSO");
        System.out.println("Curso: " + cursoEncontrado.getNome());
        System.out.println("===================================");

        List<Aluno> listaAlunos = alunoService.listarAlunos();

        for (Aluno aluno : listaAlunos) {
            if (aluno.getIdCurso() == cursoEncontrado.getId()) {
                System.out.println("RA: " + aluno.getRa() + " | Nome: " + aluno.getNome());
            }
        }
        System.out.println("-----------------------------------");
    }

    // 2. Relatório de Professores por Curso
    @Override
    public void relatorioProfessoresPorCurso(String identificadorCurso) {
        Curso cursoEncontrado = localizarCursoPorIdOuNome(identificadorCurso);
        if (cursoEncontrado == null) {
            throw new EntidadeNaoEncontradaException("Curso não encontrado!");
        }

        System.out.println("===================================");
        System.out.println("RELATÓRIO: PROFESSORES POR CURSO");
        System.out.println("Curso: " + cursoEncontrado.getNome());
        System.out.println("===================================");
        List<Disciplina> disciplinas = disciplinaService.listarDisciplinas();

        for (Disciplina disc : disciplinas) {
            if (disc.getIdCurso() == cursoEncontrado.getId()) {
                Professor prof = professorService.buscarProfessorPorId(disc.getIdProfessor());
                if (prof != null) {
                    System.out.println("Professor ID: " + prof.getId()
                            + " | Nome: " + prof.getNome()
                            + " | Disciplina: " + disc.getNome());
                }
            }
        }
        System.out.println("-----------------------------------");
    }

    // 3. Relatório de Disciplinas por Curso
    @Override
    public void relatorioDisciplinasPorCurso(String identificadorCurso) {
        Curso cursoEncontrado = localizarCursoPorIdOuNome(identificadorCurso);
        if (cursoEncontrado == null) {
            throw new EntidadeNaoEncontradaException("Curso não encontrado!");
        }

        System.out.println("===================================");
        System.out.println("RELATÓRIO: DISCIPLINAS DO CURSO");
        System.out.println("Curso: " + cursoEncontrado.getNome());
        System.out.println("===================================");

        List<Disciplina> disciplinas = disciplinaService.listarDisciplinas();
        for (Disciplina d : disciplinas) {
            if (d.getIdCurso() == cursoEncontrado.getId()) {
                Professor prof = professorService.buscarProfessorPorId(d.getIdProfessor());
                String nomeProf = (prof != null) ? prof.getNome() : "Desconhecido";
                System.out.println("ID: " + d.getId()
                        + " | Nome: " + d.getNome()
                        + " | Professor Responsável: " + nomeProf);
            }
        }
        System.out.println("-----------------------------------");
    }

    // 4. Relatório de Avaliações por Disciplina
    @Override
    public void relatorioAvaliacoesPorDisciplina(String identificadorDisciplina) {
        Disciplina disciplinaEncontrada = localizarDisciplinaPorIdOuNome(identificadorDisciplina);
        if (disciplinaEncontrada == null) {
            throw new EntidadeNaoEncontradaException("Disciplina não encontrada!");
        }

        System.out.println("===================================");
        System.out.println("RELATÓRIO: AVALIAÇÕES POR DISCIPLINA");
        System.out.println("Disciplina: " + disciplinaEncontrada.getNome());
        System.out.println("===================================");

        List<Avaliacao> avaliacoes = avaliacaoService.listarAvaliacoes();
        for (Avaliacao av : avaliacoes) {
            if (av.getIdDisciplina() == disciplinaEncontrada.getId()) {
                Aluno aluno = alunoService.buscarAlunoPorId(av.getIdAluno());
                if (aluno != null) {
                    double media = (av.getNotaNP1() + av.getNotaNP2()) / 2.0;
                    if (media < 7.0 && av.getNotaExame() > 0) {
                        media = (media + av.getNotaExame()) / 2.0;
                    }
                    String situacao;
                    if (media >= 7.0) {
                        situacao = "Aprovado";
                    } else if (media >= 5.0) {
                        situacao = "Exame";
                    } else {
                        situacao = "Reprovado";
                    }

                    System.out.println("Aluno: " + aluno.getNome()
                            + " | RA: " + aluno.getRa()
                            + " | NP1: " + av.getNotaNP1()
                            + " | NP2: " + av.getNotaNP2()
                            + " | Exame: " + av.getNotaExame()
                            + " | Média: " + String.format("%.2f", media)
                            + " | Situação: " + situacao);
                }
            }
        }
        System.out.println("-----------------------------------");
    }

    // 5. Relatório de Desempenho Acadêmico de Aluno
    @Override
    public void relatorioDesempenhoAcademicoAluno(String identificadorAluno) {
        // Tentar interpretar como ID inteiro ou RA
        Aluno alunoEncontrado = localizarAlunoPorIdOuRA(identificadorAluno);
        if (alunoEncontrado == null) {
            throw new EntidadeNaoEncontradaException("Aluno não encontrado!");
        }

        System.out.println("===================================");
        System.out.println("RELATÓRIO: DESEMPENHO ACADÊMICO");
        System.out.println("Aluno: " + alunoEncontrado.getNome() + " | RA: " + alunoEncontrado.getRa());
        System.out.println("===================================");

        List<Avaliacao> avaliacoes = avaliacaoService.listarAvaliacoes();
        for (Avaliacao av : avaliacoes) {
            if (av.getIdAluno() == alunoEncontrado.getId()) {
                Disciplina disc = disciplinaService.buscarDisciplinaPorId(av.getIdDisciplina());
                String nomeDisc = (disc != null) ? disc.getNome() : "Desconhecida";

                double media = (av.getNotaNP1() + av.getNotaNP2()) / 2.0;
                if (media < 7.0 && av.getNotaExame() > 0) {
                    media = (media + av.getNotaExame()) / 2.0;
                }
                String situacao;
                if (media >= 7.0) {
                    situacao = "Aprovado";
                } else if (media >= 5.0) {
                    situacao = "Exame";
                } else {
                    situacao = "Reprovado";
                }

                System.out.println("Disciplina: " + nomeDisc
                        + " | NP1: " + av.getNotaNP1()
                        + " | NP2: " + av.getNotaNP2()
                        + " | Exame: " + av.getNotaExame()
                        + " | Média: " + String.format("%.2f", media)
                        + " | Situação: " + situacao);
            }
        }
        System.out.println("-----------------------------------");
    }

    private Curso localizarCursoPorIdOuNome(String identificador) {
        Curso cursoEncontrado = null;
        try {
            int id = Integer.parseInt(identificador);
            cursoEncontrado = cursoService.buscarCursoPorId(id);
        } catch (NumberFormatException e) {
            List<Curso> todos = cursoService.listarCursos();
            for (Curso c : todos) {
                if (c.getNome().equalsIgnoreCase(identificador)) {
                    cursoEncontrado = c;
                    break;
                }
            }
        }
        return cursoEncontrado;
    }

    private Disciplina localizarDisciplinaPorIdOuNome(String identificador) {
        Disciplina discEncontrada = null;
        try {
            int id = Integer.parseInt(identificador);
            discEncontrada = disciplinaService.buscarDisciplinaPorId(id);
        } catch (NumberFormatException e) {
            // buscar por nome
            List<Disciplina> todas = disciplinaService.listarDisciplinas();
            for (Disciplina d : todas) {
                if (d.getNome().equalsIgnoreCase(identificador)) {
                    discEncontrada = d;
                    break;
                }
            }
        }
        return discEncontrada;
    }

    private Aluno localizarAlunoPorIdOuRA(String identificador) {
        Aluno aluno = null;
        try {
            int id = Integer.parseInt(identificador);
            aluno = alunoService.buscarAlunoPorId(id);
        } catch (NumberFormatException e) {
            // Buscar por RA
            List<Aluno> todos = alunoService.listarAlunos();
            for (Aluno a : todos) {
                if (a.getRa().equalsIgnoreCase(identificador)) {
                    aluno = a;
                    break;
                }
            }
        }
        return aluno;
    }
}

