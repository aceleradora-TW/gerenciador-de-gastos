package com.controledegastos.application;

public enum Moeda {

    REAL_BRASILEIRO("BRL"),
    DOLAR_AMERICANO("USD"),
    PESO_CHILENO("CLP"),
    EURO("EUR");

    private String codigo;

    Moeda(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

}
