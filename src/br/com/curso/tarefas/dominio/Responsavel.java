package br.com.curso.tarefas.dominio;

public class Responsavel {
    String matricula;
    String nome;
    boolean ativo;

    public void cadastrar(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.ativo = true;
    }

    public String obterMatricula() {
        return matricula;
    }

    public String obterNome() {
        return nome;
    }

    public boolean estaAtivo() {
        return ativo;
    }

    public void ativar() {
        ativo = true;
    }

    public void desativar() {
        ativo = false;
    }

}