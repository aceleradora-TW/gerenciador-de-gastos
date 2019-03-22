package com.controledegastos.application;

import java.util.List;
import java.util.Scanner;

public class ControlaGastos {
    Scanner scanner = new Scanner(System.in);

    public String responda(String pergunta){
        System.out.println(pergunta);
        String respostaGasto = scanner.next();
        return  respostaGasto;
    }

    public int selecione(String pergunta){
        System.out.println(pergunta);
        int opcaoSelecionada = scanner.nextInt();
        return opcaoSelecionada;
    }

    public void verLista(List<Gasto> gastos){
        System.out.println("Listas de gastos");
        for(int i=0; i<gastos.size(); i++){
            System.out.println(i + "-" + gastos.get(i).toString());
        }
    }

    public void mostraLista(List<String> lista){
        System.out.println("==== Lista ====");
        for(int i=0; i<lista.size(); i++){
            System.out.println(i + "-" + lista.get(i));
        }
    }
    public void mostraInformacao(String info, Double valor){
        System.out.println(info + valor);

    }

}
