package com.controledegastos.application;

import java.sql.SQLOutput;
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
                    System.out.println("Digite o produto, a categoria, o valor e o estabelecimento");
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
                    for(int i = 0; i < gastos.size(); i++){
                        System.out.println(gastos.get(i).getCategoria());
                    }

                        break;
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
        Gasto gasto = new Gasto(ArrayResposta[0],ArrayResposta[1], valor, ArrayResposta[3]);
        System.out.println(ArrayResposta[0]);
        return gasto;
    }

    public static Double parseValor(String valor){
        Double valorDouble = Double.parseDouble(valor);
        return valorDouble;
    }
}
