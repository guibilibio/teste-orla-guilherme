package com.example.testeorla.view;

import com.example.testeorla.controler.ProjetoController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class ProjetoTela {

    @Autowired
    private ProjetoController projetoController;

    private final Scanner scanner = new Scanner(System.in);

    public void exibirMenuProjeto() {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a quebra de linha após o número

            switch (opcao) {
                case 1:
                    projetoController.cadastrarProjeto();
                    break;
                case 2:
                    projetoController.listarProjetosComFuncionarios();
                    break;
                case 3:
                    System.out.println("Voltando ao Menu Principal...\n");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 3);
    }

    private void exibirMenu() {
        System.out.println("\n=================================================");
        System.out.println("Menu Projeto:");
        System.out.println("1 - Cadastrar Projeto");
        System.out.println("2 - Listar Projetos com Funcionários");
        System.out.println("3 - Voltar ao Menu Principal");
        System.out.println("=================================================");
        System.out.print("Escolha uma opção: ");
    }
}
