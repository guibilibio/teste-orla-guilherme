package com.example.testeorla.controler;

import com.example.testeorla.model.Funcionario;
import com.example.testeorla.model.Projeto;
import com.example.testeorla.repository.FuncionarioRepository;
import com.example.testeorla.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Scanner;

public class ProjetoController {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    private final Scanner scanner = new Scanner(System.in);

    public void cadastrarProjeto() {
        System.out.println("Cadastro de Projeto");
        System.out.print("Nome do Projeto: ");
        String nomeProjeto = scanner.nextLine();
        System.out.print("Data de Criação (yyyy-MM-dd): ");
        String dataCriacao = scanner.nextLine();

        Projeto projeto = new Projeto();
        projeto.setNome(nomeProjeto);
        projeto.setDataCriacao(java.sql.Date.valueOf(dataCriacao));

        projetoRepository.save(projeto);
        System.out.println("Projeto cadastrado com sucesso!");
    }

    public void listarProjetosComFuncionarios() {
        List<Projeto> projetos = projetoRepository.findAll();
        if (projetos.isEmpty()) {
            System.out.println("Nenhum projeto encontrado.");
        } else {
            for (Projeto projeto : projetos) {
                System.out.println("Projeto: " + projeto.getNome() + " | Data de Criação: " + projeto.getDataCriacao());
                System.out.println("Funcionários:");
                if (projeto.getFuncionarios().isEmpty()) {
                    System.out.println("Nenhum funcionário associado.");
                } else {
                    for (Funcionario funcionario : projeto.getFuncionarios()) {
                        System.out.println("- " + funcionario.getNome() + " | CPF: " + funcionario.getCpf());
                    }
                }
                System.out.println();
            }
        }
    }

}
