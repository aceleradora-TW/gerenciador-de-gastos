package com.controledegastos.application;

import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {
    static Scanner scanner = new Scanner(System.in);

    public static String responda(String pergunta){
        System.out.println(pergunta);
        String respostaGasto = scanner.next();
        return  respostaGasto;
    }

    public static int selecione(String pergunta){
        System.out.println(pergunta);
        int opcaoSelecionada = scanner.nextInt();
        return opcaoSelecionada;
    }

    public static void verLista(List<Gasto> gastos){
        System.out.println("Listas de gastos");
        for(int i=0; i<gastos.size(); i++){
            System.out.println(i + "-" + gastos.get(i).toString());
        }
    }

    public static void mostraLista(List<String> lista){
        System.out.println("==== Lista ====");
        for(int i=0; i<lista.size(); i++){
            System.out.println(i + "-" + lista.get(i));
        }
    }
    public static void mostraInformacao(String info, Double valor){
        System.out.println(info + valor);

    }

}
