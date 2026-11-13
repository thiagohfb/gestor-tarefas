package br.com.curso.tarefas.dominio;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TarefaUrgente extends Tarefa {

    private String motivoUrgencia;

    public void cadastrarTarefaUrgente(
            String codigo,
            String titulo,
            String descricao,
            int estimativaHoras,
            LocalDate dataLimite,
            BigDecimal custoEstimado,
            Responsavel responsavel,
            String motivoUrgencia) {

        cadastrarTarefa(
                codigo,
                titulo,
                descricao,
                estimativaHoras,
                dataLimite,
                custoEstimado,
                responsavel
        );

        this.motivoUrgencia = motivoUrgencia;
    }

    @Override
    public int calcularPrioridade() {
        return 3;
    }

    @Override
    public String obterTipo() {
        return "URGENTE";
    }

    public String obterMotivoUrgencia() {
        return motivoUrgencia;
    }
}