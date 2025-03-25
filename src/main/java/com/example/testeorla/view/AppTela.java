package com.example.testeorla.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;


@Component
public class AppTela {

    @Autowired
    private ProjetoTela projetoTela;

    @Autowired
    private FuncionarioTela funcionarioTela;

    private final Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a quebra de linha após o número

            switch (opcao) {
                case 1:
                    projetoTela.exibirMenuProjeto();
                    break;
                case 2:
                    funcionarioTela.exibirMenuFuncionario();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 3);
    }

    private void exibirMenu() {
        System.out.println("\n=================================================");
        System.out.println("Menu Principal:");
        System.out.println("1 - Menu de Projetos");
        System.out.println("2 - Menu de Funcionários");
        System.out.println("3 - Sair");
        System.out.println("=================================================");
        System.out.print("Escolha uma opção: ");
    }

}