package com.controledegastos.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//@SpringBootApplication
public class Application {

    static final List<Taxa> TAXA_CAMBIO = Arrays.asList(
      new Taxa(Moeda.REAL_BRASILEIRO, 1.0, 1.0),
      new Taxa(Moeda.DOLAR_AMERICANO, 3.74, 6.0),
      new Taxa(Moeda.PESO_CHILENO,0.0057, 2.0),
      new Taxa(Moeda.EURO, 4.24, 8.0)
    );

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);

        List<Gasto>gastos = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int acao = 1;

        while(acao != 0){
            System.out.println("Selecione a ação: ");
            System.out.println("1. Adicionar gasto \n" +
                    "2. Remover gasto \n" +
                    "3. Calcular total de gastos \n" +
                    "4. Ver lista \n" +
                    "5. Calcular total por categoria\n" +
                    "6. Calcular total por estabelecimento\n" +
                    "0. Sair");
            acao = scanner.nextInt();

            switch (acao){

                case 1:
                    System.out.println("Digite o produto, a categoria, o valor, o estabelecimento e a moeda do país de compra");
                    String resposta = scanner.next();
                    gastos.add(GetResposta(resposta));

                    break;

                case 2:
                    System.out.println("Listas de gastos:");
                    for(int i=0; i<gastos.size(); i++){
                        System.out.println(i + "-" + gastos.get(i).toString());

                    }
                    System.out.println("Digite o número do item que você deseja remover:");
                    int itemRemovido = scanner.nextInt();
                    gastos.remove(gastos.get(itemRemovido));
                    break;

                case 3:
                    Double valorTotal= 0.0;
                    System.out.println("Valor total da lista de gastos");
                    for(int i=0; i<gastos.size(); i++){
                        valorTotal =valorTotal + gastos.get(i).getValor();
                    }
                    System.out.println(valorTotal);
                    break;

                case 4:
                    System.out.println("Listas de gastos");
                    for(int i=0; i<gastos.size(); i++){
                        System.out.println(i + "-" + gastos.get(i).toString());
                    }
                    break;

                case 5:
                    System.out.println("Digite o nome da categoria que você que quer obter o total:");
                    String respostaCategoria = scanner.next();
                     List<Gasto> gastosDaCategoria = gastos
                             .stream()
                             .filter(gasto -> gasto.getCategoria().equals(respostaCategoria))
                             .collect(Collectors.toList());



                     Double valorFinal = 0.0;
                    for(int i=0; i<gastosDaCategoria.size(); i++) {
                        valorFinal = valorFinal + gastosDaCategoria.get(i).getValor();
                    }
                    System.out.println("Valor total da categoria: " + valorFinal);
                    break;

                case 6:
                    System.out.println("Digite o nome do estabelecimento que você que obter o total: ");
                    String respostaEstab = scanner.next();
                    List<Gasto> gastosEstab = gastos
                            .stream()
                            .filter(gasto -> gasto.getEstabelecimento().equals(respostaEstab))
                            .collect(Collectors.toList());




                    Double valorEstab = 0.0;
                    for(int i=0; i<gastosEstab.size();i++){
                        valorEstab = valorEstab + gastosEstab.get(i).getValor();
                    }
                    System.out.println("Valor gasto no estabelecimento: " + valorEstab);
                case 0:
                    break;

                default:
                    System.out.println("Você não digitou nenhuma das opções e/ou digitou uma opção inválida");
            }
        }
    }
    public static Gasto GetResposta(String resposta){
        String ArrayResposta[] = resposta.split(";");
        Double valor = parseValor(ArrayResposta[2]);
        valor = buscaMoedaDisponivel(valor, ArrayResposta[4]);
        Gasto gasto = new Gasto(ArrayResposta[0],ArrayResposta[1], valor, ArrayResposta[3], ArrayResposta[4]);
        System.out.println(ArrayResposta[0]);
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


}
