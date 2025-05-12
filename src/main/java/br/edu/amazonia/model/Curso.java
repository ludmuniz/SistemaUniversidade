package main.java.br.edu.amazonia.model;

public class Curso {
    private int id;
    private String nome;
    private String nivel; // ex: Graduação, Pós, etc.
    private int ano;

    public Curso() {
    }

    public Curso(int id, String nome, String nivel, int ano) {
        this.id = id;
        this.nome = nome;
        this.nivel = nivel;
        this.ano = ano;
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

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
