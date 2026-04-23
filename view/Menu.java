package view;

import service.*;
import java.util.Scanner;

public class Menu {
    public static void iniciar() {
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n=== ✨ MENU ✨ ===");
            System.out.println("1 - Cadastro");
            System.out.println("2 - Gerar Carta");
            System.out.println("3 - Ver Histórico");
            System.out.println("4 - Buscar");
            System.out.println("5 - Sair");

            op = sc.nextInt();

            switch (op) {
                case 1 -> Cadastro.cadastrarUsuario();
                case 2 -> GeradorCarta.gerar();
                case 3 -> Historico.mostrar();
                case 4 -> Historico.buscar();
                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida");
            }

        } while (op != 5);
    }

}