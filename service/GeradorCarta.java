package service;

import model.Carta;
import util.ArquivoUtil;

import java.util.Scanner;

public class GeradorCarta {
    public static void gerar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("1-Amor  2-Amizade  3-Desculpas  4-Formal  5-Motivacional");
        int op = sc.nextInt();
        sc.nextLine();

        String tipo = switch (op) {
            case 1 -> "Amor";
            case 2 -> "Amizade";
            case 3 -> "Desculpas";
            case 4 -> "Formal";
            case 5 -> "Motivacional";
            default -> "Desconhecido";
        };

        System.out.print("Remetente: ");
        String remetente = sc.nextLine();

        System.out.print("Destinatário: ");
        String destinatario = sc.nextLine();

        String conteudo = lerMultilinha(sc);

        Carta carta = new Carta(remetente, destinatario, tipo, conteudo);

        ArquivoUtil.salvar("historico.txt", carta.formatarCarta());

        System.out.println("Carta registrada com sucesso");

        System.out.println("\n PRÉ-VISUALIZAÇÃO DA CARTA:");
        System.out.println(carta.formatarCarta());

        System.out.println("O que deseja fazer?");
        System.out.println("1 - Enviar (salvar no histórico)");
        System.out.println("2 - Imprimir (exibir novamente)");
        System.out.println("3 - Cancelar");

        int escolha = sc.nextInt();
        sc.nextLine();

        switch (escolha) {
            case 1:
                ArquivoUtil.salvar("historico.txt", carta.formatarCarta());
                System.out.println(" Carta enviada com sucesso!");
                break;

            case 2:
                System.out.println("\n IMPRIMINDO CARTA...");
                System.out.println(carta.formatarCarta());
                break;

            case 3:
                System.out.println("Operação cancelada.");
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }

    private static String lerMultilinha(Scanner sc) {
        StringBuilder sb = new StringBuilder();

        System.out.println("Digite sua carta (FIM para encerrar):");

        while (true) {
            String linha = sc.nextLine();
            if (linha.equalsIgnoreCase("FIM")) break;

            sb.append(linha).append("\n");

            if (sb.length() > 3500) break;
        }

        return sb.toString();
    }

}
