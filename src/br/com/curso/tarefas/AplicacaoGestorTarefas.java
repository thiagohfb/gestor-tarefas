package br.com.curso.tarefas;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.curso.tarefas.dominio.GestorTarefas;
import br.com.curso.tarefas.dominio.Responsavel;
import br.com.curso.tarefas.dominio.Tarefa;
import br.com.curso.tarefas.dominio.TarefaComum;
import br.com.curso.tarefas.dominio.TarefaUrgente;

public class AplicacaoGestorTarefas {

    public static void main(String[] args) {
        Responsavel responsavel = new Responsavel();
        responsavel.cadastrar("F12345", "Marina Souza");

        TarefaComum tarefaRevisarRequisitos = new TarefaComum();
        tarefaRevisarRequisitos.cadastrarTarefaComum(
                "TAR-001",
                "Revisar requisitos",
                "Conferir os requisitos do projeto",
                3,
                LocalDate.of(2026, 10, 10),
                new BigDecimal("150.00"),
                responsavel);

        TarefaComum tarefaImplementarTela = new TarefaComum();
        tarefaImplementarTela.cadastrarTarefaComum(
                "TAR-002",
                "Implementar a tela inicial",
                "Criar a estrutura visual inicial",
                2,
                LocalDate.of(2026, 10, 12),
                new BigDecimal("300.00"),
                responsavel);

        TarefaUrgente tarefaValidarAplicacao = new TarefaUrgente();
        tarefaValidarAplicacao.cadastrarTarefaUrgente(
                "TAR-003",
                "Corrigir falha de validação",
                "Corrigir a falha antes da publicação",
                1,
                LocalDate.of(2026, 10, 8),
                new BigDecimal("500.00"),
                responsavel,
                "Publicação bloqueada");

        GestorTarefas gestor = new GestorTarefas();
        gestor.adicionarTarefa(tarefaRevisarRequisitos);
        gestor.adicionarTarefa(tarefaImplementarTela);
        gestor.adicionarTarefa(tarefaValidarAplicacao);

        System.out.println("=== GESTOR DE TAREFAS ===");
        System.out.println(
                "Quantidade de tarefas: "
                        + gestor.obterQuantidadeTarefas());
        System.out.println();

        gestor.exibirResumo();
        System.out.println();

        Tarefa encontrada = gestor.buscarPorCodigo("TAR-002");

        if (encontrada != null) {
            System.out.println("Encontrada: " + encontrada.obterTitulo());
        }

        Tarefa inexistente = gestor.buscarPorCodigo("TAR-999");

        if (inexistente == null) {
            System.out.println("Tarefa TAR-999 não encontrada.");
        }

        Tarefa prioritaria = gestor.buscarMaiorPrioridade();

        if (prioritaria != null) {
            System.out.println(
                    "Próxima tarefa: " + prioritaria.obterTitulo());
        }

        System.out.println();
        System.out.println("Tarefas pendentes: " + gestor.contarPendentes());
        gestor.iniciarTarefasPendentes();
        gestor.exibirResumo();
    }
}