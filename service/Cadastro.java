package service;

import util.ArquivoUtil;
import java.util.Scanner;

public class Cadastro {

    public static void cadastrarUsuario() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        String dados = "Nome: " + nome + " | Email: " + email + "\n";

        ArquivoUtil.salvar("cadastro.txt", dados);

        System.out.println("Cadastro realizado com sucesso!\n");
    }
}
