package br.com.curso.tarefas.dominio;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TarefaComum extends Tarefa {

    public void cadastrarTarefaComum(
            String codigo,
            String titulo,
            String descricao,
            int estimativaHoras,
            LocalDate dataLimite,
            BigDecimal custoEstimado,
            Responsavel responsavel) {

        cadastrarTarefa(
                codigo,
                titulo,
                descricao,
                estimativaHoras,
                dataLimite,
                custoEstimado,
                responsavel);
    }

    @Override
    public int calcularPrioridade() {
        return 1;
    }

    @Override
    public String obterTipo() {
        return "COMUM";
    }
}