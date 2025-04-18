package br.com.startuprush;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {    
        //testa se a conexao com o bdd é efetuada
        if (BancoSetup.testarConexao()) {
            System.out.println("Conexão com o banco de dados estabelecida com sucesso.");
        } else {
            System.out.println("Erro ao conectar com o banco de dados.");
            return; // Encerra o programa caso a conexão falhe
        }

        BancoSetup.criarTabelas(); // cria tabelas se não existirem
        
        Scanner scanner = new Scanner(System.in); // Criando o scanner 
        try {
            StartupDAO dao = new StartupDAO();

            while (true) {
                System.out.println("\n--- STARTUP RUSH ---");
                System.out.println("1. Cadastrar Startup");
                System.out.println("2. Listar Startups");
                System.out.println("0. Sair");
                System.out.print("Escolha: ");

                int opcao = scanner.nextInt();
                scanner.nextLine(); // limpar quebra de linha

                switch (opcao) {
                    case 1: {
                        List<Startup> cadastradas = dao.listarStartups();

                        if (cadastradas.size() >= 8) {
                            System.out.println("Limite de 8 startups atingido.");
                            break;
                        }

                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Slogan: ");
                        String slogan = scanner.nextLine();
                        System.out.print("Ano de fundação: ");
                        int ano = scanner.nextInt();
                        scanner.nextLine(); // limpar buffer

                        dao.inserirStartup(new Startup(nome, slogan, ano));
                        break;
                    }

                    case 2: {
                        List<Startup> lista = dao.listarStartups();
                        if (lista.isEmpty()) {
                            System.out.println("Nenhuma startup cadastrada.");
                        } else {
                            System.out.println("\nStartups Cadastradas:");
                            for (Startup s : lista) {
                                System.out.println("- " + s.getNome() + " | " + s.getSlogan() + " | " + s.getAnoFundacao());
                            }
                            System.out.println("(Total: " + lista.size() + ")");
                        }
                        break;
                    }

                    case 0: {
                        System.out.println("Encerrando...");
                        return;
                    }

                    default:
                        System.out.println("Opção inválida.");
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
        
   
    }
}
