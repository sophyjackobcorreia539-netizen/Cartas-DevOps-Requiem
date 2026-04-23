package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Historico {
    public static void mostrar() {
        lerArquivo("historico.txt");
    }

    public static void buscar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Buscar por:");
        System.out.println("1 - Remetente");
        System.out.println("2 - Tipo");

        int op = sc.nextInt();
        sc.nextLine();

        System.out.print("Digite o termo: ");
        String termo = sc.nextLine().toLowerCase();

        try (BufferedReader br = new BufferedReader(new FileReader("historico.txt"))) {
            String linha;
            boolean encontrou = false;

            while ((linha = br.readLine()) != null) {
                if (linha.toLowerCase().contains(termo)) {
                    System.out.println(linha);
                    encontrou = true;
                }
            }

            if (!encontrou) {
                System.out.println("Nada encontrado ");
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler histórico.");
        }
    }

    private static void lerArquivo(String caminho) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Nenhum histórico ainda.");
        }
    }

}
