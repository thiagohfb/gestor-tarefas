package br.com.curso.tarefas.dominio;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Tarefa {
    private String codigo;
    private String titulo;
    private String descricao;
    private int estimativaHoras;
    private int horasRealizadas;
    private boolean emAndamento;
    private boolean concluida;
    private LocalDate dataLimite;
    private BigDecimal custoEstimado;
    private Responsavel responsavel;

        protected void cadastrarTarefa(
            String codigo,
            String titulo,
            String descricao,
            int estimativaHoras,
            LocalDate dataLimite,
            BigDecimal custoEstimado,
            Responsavel responsavel) {

        this.codigo = codigo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.estimativaHoras = estimativaHoras;
        this.dataLimite = dataLimite;
        this.custoEstimado = custoEstimado;
        this.responsavel = responsavel;
        this.horasRealizadas = 0;
        this.emAndamento = false;
        this.concluida = false;
    }


    public boolean iniciar() {
        if (concluida || emAndamento || !responsavel.estaAtivo()) {
            return false;
        }

        emAndamento = true;

        return true;
    }

    public boolean registrarHoraTrabalhada() {
        if (!emAndamento || concluida) {
            return false;
        }

        horasRealizadas++;

        if (horasRealizadas >= estimativaHoras) {
            concluida = true;
            emAndamento = false;
        }

        return true;
    }

    public boolean concluir() {
        if (!emAndamento || concluida) {
            return false;
        }

        concluida = true;
        emAndamento = false;
        return true;
    }

    public boolean estaPendente() {
        if (!emAndamento || concluida) {
            return false;
        }

        concluida = true;
        emAndamento = false;
        return true;
    }

    public boolean possuiCodigo(String codigoInformado) {
        return codigo.equals(codigoInformado);
    }

    public boolean possuiCustoAcimaDe(BigDecimal limite) {
        return custoEstimado.compareTo(limite) > 0;
    }

    public String obterSituacao() {
        if (concluida) {
            return "CONCLUÍDA";
        } else if (emAndamento) {
            return "EM ANDAMENTO";
        } else {
            return "PENDENTE";
        }
    }

    public void cadastrar(
            String codigo,
            String titulo,
            String descricao,
            int estimativaHoras,
            LocalDate dataLimite,
            BigDecimal custoEstimado,
            Responsavel responsavel) {

        this.codigo = codigo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.estimativaHoras = estimativaHoras;
        this.dataLimite = dataLimite;
        this.custoEstimado = custoEstimado;
        this.responsavel = responsavel;
        this.horasRealizadas = 0;
        this.emAndamento = false;
        this.concluida = false;
    }

    public String obterCodigo() {
        return codigo;
    }

    public String obterTitulo() {
        return titulo;
    }

    public int obterEstimativaHoras() {
        return estimativaHoras;
    }

    public int obterHorasRealizadas() {
        return horasRealizadas;
    }

    public boolean estaEmAndamento() {
        return emAndamento;
    }

    public boolean estaConcluida() {
        return concluida;
    }

    public boolean possuiResponsavel(String matricula) {
        return responsavel.obterMatricula().equals(matricula);
    }

    public abstract int calcularPrioridade();

    public abstract String obterTipo();

    public String obterNomeResponsavel() {
        return responsavel.obterNome();
    }

    public String obterDescricao() {
        return descricao;
    }

    public LocalDate obterDataLimite() {
        return dataLimite;
    }
}
