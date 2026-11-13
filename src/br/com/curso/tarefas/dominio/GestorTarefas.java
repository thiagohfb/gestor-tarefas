package br.com.curso.tarefas.dominio;

import java.util.ArrayList;
import java.util.List;

public class GestorTarefas {

    private List<Tarefa> tarefas = new ArrayList<>();

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public int obterQuantidadeTarefas() {
        return tarefas.size();
    }

    public Tarefa buscarPorCodigo(String codigo) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.possuiCodigo(codigo)) {
                return tarefa;
            }
        }

        return null;
    }

    public Tarefa buscarMaiorPrioridade() {
        if (tarefas.size() == 0) {
            return null;
        }

        Tarefa maiorPrioridade = tarefas.get(0);

        for (Tarefa tarefa : tarefas) {
            if (tarefa.calcularPrioridade()
                    > maiorPrioridade.calcularPrioridade()) {
                maiorPrioridade = tarefa;
            }
        }

        return maiorPrioridade;
    }

    public void iniciarTarefasPendentes() {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.estaPendente()) {
                tarefa.iniciar();
            }
        }
    }

    public int contarConcluidas() {
        int quantidade = 0;

        for (Tarefa tarefa : tarefas) {
            if (tarefa.estaConcluida()) {
                quantidade++;
            }
        }

        System.out.println("contarConcluidas");
        return quantidade;
    }    

    public void exibirTarefasDoResponsavel(String matricula) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.possuiResponsavel(matricula)) {
                System.out.println(tarefa.obterTitulo());
            }
        }
    }

    public void exibirResumo() {
        for (Tarefa tarefa : tarefas) {
            System.out.println(
                    tarefa.obterCodigo()
                    + " - "
                    + tarefa.obterTitulo()
                    + " - tipo: "
                    + tarefa.obterTipo()
                    + " - prioridade: "
                    + tarefa.calcularPrioridade()
                    + " - situação: "
                    + tarefa.obterSituacao()
            );
        }
    }

    public int contarPendentes() {
        int quantidade = 0;

        for (Tarefa tarefa : tarefas) {
            if (tarefa.estaPendente()) {
                quantidade++;
            }
        }

        return quantidade;
    }    

}