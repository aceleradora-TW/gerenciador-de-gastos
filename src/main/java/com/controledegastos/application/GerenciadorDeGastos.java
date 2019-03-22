package com.controledegastos.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class  GerenciadorDeGastos {

    static final List<Taxa> TAXA_CAMBIO = Arrays.asList(
            new Taxa(Moeda.REAL_BRASILEIRO, 1.0, 1.0),
            new Taxa(Moeda.DOLAR_AMERICANO, 3.74, 6.0),
            new Taxa(Moeda.PESO_CHILENO,0.0057, 2.0),
            new Taxa(Moeda.EURO, 4.24, 8.0)
    );

    List<Gasto> gastos = new ArrayList<>();

    public void adicionaGasto() {
        String respostaGasto = InterfaceUsuario.responda("Digite o produto, a categoria, o valor, o estabelecimento e a moeda do país de compra");
        gastos.add(getGasto(respostaGasto));
    }

    public void removeGasto(){
        InterfaceUsuario.verLista(gastos);
        int itemRemovido = InterfaceUsuario.selecione("Digite o número do item que você deseja remover:");
        gastos.remove(gastos.get(itemRemovido));
    }

    public void calculaTotalGastos(){
        Double valorTotal= 0.0;
        for(int i=0; i<gastos.size(); i++){
            valorTotal =valorTotal + gastos.get(i).getValor();
        }
        InterfaceUsuario.mostraInformacao("Valor total da lista de gastos: ", valorTotal);
    }

    public void calculaTotalCategoria(){
        String categoria = mostraCategorias();
        List<Gasto> gastosDaCategoria = gastos
                .stream()
                .filter(gasto -> gasto.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());

        double valorCategoria = gastosDaCategoria
                .stream()
                .map(gasto -> gasto.getValor())
                .reduce(0.0, (gastoA,gastoB) -> gastoA+ gastoB);
        InterfaceUsuario.mostraInformacao("Valor total da categoria: ", valorCategoria);
    }

    public void calculaTotalEstabelecimento(){

        String estabelecimento = mostraEstabelecimentos();

        List<Gasto> gastosEstab = gastos
                .stream()
                .filter(gasto -> gasto.getEstabelecimento().equalsIgnoreCase(estabelecimento))
                .collect(Collectors.toList());

        double valorEstab = gastosEstab
                .stream()
                .map(gasto -> gasto.getValor())
                .reduce(0.0, (gastoA, gastoB) -> gastoA + gastoB);
        InterfaceUsuario.mostraInformacao("Valor gasto no estabelecimento: ", valorEstab);
    }

    public static Gasto getGasto(String resposta){
        String arrayResposta[] = resposta.split(";");
        Double valor = parseValor(arrayResposta[2]);
        valor = buscaMoedaDisponivel(valor, arrayResposta[4]);
        Gasto gasto = new Gasto(arrayResposta[0],arrayResposta[1], valor, arrayResposta[3], arrayResposta[4]);
        return gasto;
    }

    public static Double parseValor(String valor){
        Double valorDouble = Double.parseDouble(valor);
        return valorDouble;
    }

    public static Double buscaMoedaDisponivel(Double valor, String moedaOrigem){
        Taxa taxaCambio = TAXA_CAMBIO
                .stream()
                .filter(taxa -> taxa.getMoeda().getCodigo().equalsIgnoreCase(moedaOrigem))
                .findFirst().get();
        Double valorBrl = calculaTaxaCambio(valor, taxaCambio);
        Double valorFinal = calculaTaxaImportacao(valorBrl, taxaCambio);
        return valorFinal;
    }

    public static Double calculaTaxaCambio(Double valor, Taxa taxaCambio){
        Double valorReal = valor * taxaCambio.getTaxaCambio();
        return valorReal;
    }

    public static Double calculaTaxaImportacao(Double valorBrl, Taxa taxaCambio){
        Double imposto = (valorBrl * taxaCambio.getTaxaImportacao())/100;
        return imposto + valorBrl;
    }

    public String mostraCategorias(){
        List<String> categoriasDiferentes = gastos
                .stream()
                .map(item -> item.getCategoria())
                .distinct().collect(Collectors.toList());
        InterfaceUsuario.mostraLista(categoriasDiferentes);
        int respostaCategoria = InterfaceUsuario.selecione("Selecione uma categoria:");
        return categoriasDiferentes.get(respostaCategoria);
    }

    public String mostraEstabelecimentos(){
        List<String> estabelecimentosDiferentes = gastos
                .stream()
                .map(item -> item.getEstabelecimento())
                .distinct().collect(Collectors.toList());
        InterfaceUsuario.mostraLista(estabelecimentosDiferentes);
        int respostaEstabelecimento = InterfaceUsuario.selecione("Selecione um estabelecimento:");
        return estabelecimentosDiferentes.get(respostaEstabelecimento);
    }

    public void verLista(){
        InterfaceUsuario.verLista(gastos);
    }
}
