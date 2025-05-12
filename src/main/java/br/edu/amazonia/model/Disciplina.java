package main.java.br.edu.amazonia.model;

public class Disciplina {
    private int id;
    private String nome;
    private int idProfessor;
    private int idCurso;

    public Disciplina() {
    }

    public Disciplina(int id, String nome, int idProfessor, int idCurso) {
        this.id = id;
        this.nome = nome;
        this.idProfessor = idProfessor;
        this.idCurso = idCurso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
}
