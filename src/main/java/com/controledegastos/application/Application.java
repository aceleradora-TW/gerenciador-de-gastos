package com.controledegastos.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//@SpringBootApplication
public class Application {

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);

        Scanner scanner = new Scanner(System.in);

        GerenciadorDeGastos gerenciadorDeGastos = new GerenciadorDeGastos();

        int acao = 1;

        while(acao != 0){
            System.out.println("Selecione a ação: ");
            System.out.println("1. Adicionar gasto \n" +
                    "2. Remover gasto \n" +
                    "3. Ver lista \n" +
                    "4. Calcular total de gastos \n" +
                    "5. Calcular total por categoria\n" +
                    "6. Calcular total por estabelecimento\n" +
                    "0. Sair");
            acao = scanner.nextInt();

            switch (acao){

                case 1:
                    gerenciadorDeGastos.adicionaGasto();
                    break;

                case 2:
                    gerenciadorDeGastos.removeGasto();
                    break;

                case 3:
                    gerenciadorDeGastos.verLista();
                    break;

                case 4:
                    gerenciadorDeGastos.calculaTotalGastos();
                    break;

                case 5:
                    gerenciadorDeGastos.calculaTotalCategoria();
                    break;

                case 6:
                    gerenciadorDeGastos.calculaTotalEstabelecimento();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Você não digitou nenhuma das opções e/ou digitou uma opção inválida");
            }
        }
    }

}