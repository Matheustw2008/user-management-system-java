package app.java;

import service.UsuarioService;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        UsuarioService service = new UsuarioService();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE USUÁRIOS =====");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Login");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Digite um número válido: ");
                scanner.next();
            }

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();

                    service.cadastrar(nome, email, senha);
                }

                case 2 -> {
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();

                    service.login(email, senha);
                }

                case 0 -> System.out.println("👋 Sistema encerrado.");

                default -> System.out.println("❌ Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
