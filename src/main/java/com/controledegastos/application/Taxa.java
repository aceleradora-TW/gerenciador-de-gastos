package com.controledegastos.application;

public class Taxa {
   private Moeda moeda;
   private Double taxaCambio;
   private Double taxaImportacao;


    public Taxa(Moeda moeda, Double taxaCambio, Double taxaImportacao) {
        this.moeda = moeda;
        this.taxaCambio = taxaCambio;
        this.taxaImportacao = taxaImportacao;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    public void setMoeda(Moeda moeda) {
        this.moeda = moeda;
    }

    public Double getTaxaCambio() {
        return taxaCambio;
    }

    public void setTaxaCambio(Double taxaCambio) {
        this.taxaCambio = taxaCambio;
    }

    public Double getTaxaImportacao() {
        return taxaImportacao;
    }

    public void setTaxaImportacao(Double taxaImportacao) {
        this.taxaImportacao = taxaImportacao;
    }

    @Override
    public String toString() {
        return "Taxa{" +
                "moeda=" + moeda +
                ", taxaCambio=" + taxaCambio +
                ", taxaImportacao=" + taxaImportacao +
                '}';
    }
}
