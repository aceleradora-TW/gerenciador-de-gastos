package com.controledegastos.application;

public class Gasto {
   private String descricao;
   private String categoria;
   private double valor;
   private String estabelecimento;
   private String moeda;

    public Gasto(String descricao, String categoria, double valor, String estabelecimento, String moeda) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.moeda = moeda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(String estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    @Override
    public String toString() {
        return "Gasto{" +
                "descricao='" + descricao + '\'' +
                ", categoria='" + categoria + '\'' +
                ", valor=" + valor +
                ", mostraInformacao='" + estabelecimento + '\'' +
                ", moeda='" + moeda + '\'' +
                '}';
    }
}



