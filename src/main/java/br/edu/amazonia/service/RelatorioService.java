package main.java.br.edu.amazonia.service;

public interface RelatorioService {

    void gerarRelatorioCompleto();

    void relatorioAlunosPorCurso(String identificadorCurso);
    void relatorioProfessoresPorCurso(String identificadorCurso);
    void relatorioDisciplinasPorCurso(String identificadorCurso);
    void relatorioAvaliacoesPorDisciplina(String identificadorDisciplina);
    void relatorioDesempenhoAcademicoAluno(String identificadorAluno);
}