package main.java.br.edu.amazonia.model;

public class Avaliacao {
    private int id;
    private int idAluno;
    private int idDisciplina;
    private double notaNP1;
    private double notaNP2;
    private double notaExame; // só preenchido se média < 7.0

    public Avaliacao() {
    }

    public Avaliacao(int id, int idAluno, int idDisciplina,
                     double notaNP1, double notaNP2, double notaExame) {
        this.id = id;
        this.idAluno = idAluno;
        this.idDisciplina = idDisciplina;
        this.notaNP1 = notaNP1;
        this.notaNP2 = notaNP2;
        this.notaExame = notaExame;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public double getNotaNP1() {
        return notaNP1;
    }

    public void setNotaNP1(double notaNP1) {
        this.notaNP1 = notaNP1;
    }

    public double getNotaNP2() {
        return notaNP2;
    }

    public void setNotaNP2(double notaNP2) {
        this.notaNP2 = notaNP2;
    }

    public double getNotaExame() {
        return notaExame;
    }

    public void setNotaExame(double notaExame) {
        this.notaExame = notaExame;
    }
}
