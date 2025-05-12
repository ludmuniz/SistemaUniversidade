package main.java.br.edu.amazonia.model;

public class Aluno {
    private int id;
    private String nome;
    private String ra;
    private int idCurso;

    public Aluno() {
    }

    public Aluno(int id, String nome, String ra, int idCurso) {
        this.id = id;
        this.nome = nome;
        this.ra = ra;
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

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
}
