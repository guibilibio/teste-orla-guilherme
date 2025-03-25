package com.example.testeorla.controler;


import com.example.testeorla.model.Funcionario;
import com.example.testeorla.model.Projeto;
import com.example.testeorla.repository.FuncionarioRepository;
import com.example.testeorla.repository.ProjetoRepository;
import com.example.testeorla.view.FuncionarioTela;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class FuncionarioController {

        @Autowired
        private FuncionarioRepository funcionarioRepository;

        @Autowired
        private ProjetoRepository projetoRepository;

        private final Scanner scanner = new Scanner(System.in);

        public void cadastrarFuncionario() {
                System.out.println("Cadastro de Funcionário");
                System.out.print("Nome do Funcionário: ");
                String nomeFuncionario = scanner.nextLine();
                System.out.print("CPF do Funcionário: ");
                String cpf = scanner.nextLine();
                System.out.print("Email do Funcionário: ");
                String email = scanner.nextLine();
                System.out.print("Salário do Funcionário: ");
                double salario = scanner.nextDouble();
                scanner.nextLine(); // Consome a quebra de linha após o número

                Funcionario funcionario = new Funcionario();
                funcionario.setNome(nomeFuncionario);
                funcionario.setCpf(cpf);
                funcionario.setEmail(email);
                funcionario.setSalario(salario);

                funcionarioRepository.save(funcionario);
                System.out.println("Funcionário cadastrado com sucesso!");
        }

        public void listarFuncionariosComProjetos() {
                List<Funcionario> funcionarios = funcionarioRepository.findAll();
                if (funcionarios.isEmpty()) {
                        System.out.println("Nenhum funcionário encontrado.");
                } else {
                        for (Funcionario funcionario : funcionarios) {
                                System.out.println("Funcionário: " + funcionario.getNome() + " | CPF: " + funcionario.getCpf());
                                System.out.println("Projetos:");
                                if (funcionario.getProjetos().isEmpty()) {
                                        System.out.println("Nenhum projeto associado.");
                                } else {
                                        for (Projeto projeto : funcionario.getProjetos()) {
                                                System.out.println("- " + projeto.getNome() + " | Data de Criação: " + projeto.getDataCriacao());
                                        }
                                }
                                System.out.println();
                        }
                }
        }
}
