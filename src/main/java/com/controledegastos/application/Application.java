package com.controledegastos.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//@SpringBootApplication
public class Application {

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);

        List<Gasto>gastos = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int acao = 1;

        while(acao != 0){
            System.out.println("Selecione a ação: ");
            System.out.println("1. Adicionar gasto");
            System.out.println("2. Remover gasto");
            System.out.println("3. Calcular total de gastos");
            System.out.println("4. Ver lista");
            System.out.println("0. Sair");
            acao = scanner.nextInt();

            if (acao == 1){
                System.out.println("Digite o produto e o seu valor");
                String resposta = scanner.next();
                gastos.add(getGasto(resposta));
            }
            if(acao == 2) {
                System.out.println("Listas de gastos");
                for (int i = 0; i < gastos.size(); i++) {
                    System.out.println(i + "-" + gastos.get(i).toString());
                    System.out.println("Digite o número do item que você deseja remover:");
                    int itemRemovido = scanner.nextInt();
                    gastos.remove(gastos.get(itemRemovido));
                }
            }
            if(acao == 3){
                Double valorTotal= 0.0;
                System.out.println("Valor total da lista de gastos");
                for(int i=0; i<gastos.size(); i++){
                    valorTotal =valorTotal + gastos.get(i).getValor();
                }
                System.out.println(valorTotal);
            }
            if(acao == 4){
                System.out.println("Listas de gastos");
                for(int i=0; i<gastos.size(); i++){
                    System.out.println(i + "-" + gastos.get(i).toString());
                }
            }
            }
        }
    public static Gasto getGasto(String resposta){
        String descricao[] = resposta.split(";");
        Double valor = parseValor(descricao[1]);
        Gasto gasto = new Gasto(descricao[0], valor);
        return gasto;
    }

    public static Double parseValor(String valor){
        Double valorDouble = Double.parseDouble(valor);
        return valorDouble;
    }


}
