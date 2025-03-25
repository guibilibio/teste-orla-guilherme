package com.example.testeorla.view;

import java.util.Scanner;

public class FuncionarioTela {

    @Autowired
    private FuncionarioController funcionarioController;

    private final Scanner scanner = new Scanner(System.in);

    public void exibirMenuFuncionario() {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a quebra de linha após o número

            switch (opcao) {
                case 1:
                    funcionarioController.cadastrarFuncionario();
                    break;
                case 2:
                    funcionarioController.listarFuncionariosComProjetos();
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...\n");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 3);
    }

    private void exibirMenu() {
        System.out.println("\n=================================================");
        System.out.println("Menu Funcionário:");
        System.out.println("1 - Cadastrar Funcionário");
        System.out.println("2 - Listar Funcionários com Projetos");
        System.out.println("3 - Voltar ao Menu Principal");
        System.out.println("=================================================");
        System.out.print("Escolha uma opção: ");
    }

}
