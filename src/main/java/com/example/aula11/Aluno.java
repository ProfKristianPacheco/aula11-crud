package com.example.aula11;

public class Aluno {
    private String nome;
    private boolean presente;
    private int matricula;

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", presente=" + presente +
                ", matricula=" + matricula +
                '}';
    }

    public Aluno(String nome, boolean presente, int matricula) {
        this.nome = nome;
        this.presente = presente;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
