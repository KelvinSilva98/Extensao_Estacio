package app;

import repository.ProdutoRepository;
import repository.VendaRepository;
import model.Venda;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProdutoRepository produtoRepo = new ProdutoRepository();
        VendaRepository vendaRepo = new VendaRepository();
        Scanner scanner = new Scanner(System.in);

        util.Database.createTables();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Registrar Venda");
            System.out.println("3. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do produto:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o preço do produto:");
                    double preco = scanner.nextDouble();
                    System.out.println("Digite a quantidade do produto:");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();

                    produtoRepo.adicionarProduto(nome, preco, quantidade);
                    System.out.println("Produto adicionado com sucesso!");
                    break;

                case 2:
                    System.out.println("Digite o ID do produto:");
                    int produtoId = scanner.nextInt();
                    System.out.println("Digite a quantidade vendida:");
                    int quantidadeVendida = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite a data da venda (YYYY-MM-DD):");
                    String data = scanner.nextLine();

                    vendaRepo.registrarVenda(produtoId, quantidadeVendida, data);
                    System.out.println("Venda registrada com sucesso!");
                    break;

                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
