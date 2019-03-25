package com.controledegastos.application;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

    static Scanner scanner = new Scanner(System.in);
    static GerenciadorDeGastos gerenciadorDeGastos = new GerenciadorDeGastos();
    InterfaceUsuario controlaGastos = new InterfaceUsuario();

    public static void main(String[] args) throws Exception {

        while(menu() != 0);
    }

    public static int menu() throws Exception {
        int acao = -1;

        System.out.println("Selecione a ação: ");
        System.out.println("1. Adicionar gasto \n" +
                "2. Remover gasto \n" +
                "3. Ver lista \n" +
                "4. Calcular total de gastos \n" +
                "5. Calcular total por categoria\n" +
                "6. Calcular total por estabelecimento\n" +
                "0. Sair");

        try {
            acao = scanner.nextInt();
        } catch (InputMismatchException exception) {
            scanner.next();
        }

        switch (acao) {

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
        return acao;
    }
}