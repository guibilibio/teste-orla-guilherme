package com.example.testeorla.model;

import jakarta.persistence.ManyToMany;

import java.util.Date;
import java.util.List;

@lombok.Getter
@lombok.Setter
public class Projeto {

    private String nome;
    private Date dataCriacao;

    @ManyToMany(mappedBy = "projetos")
    private List<Funcionario> funcionarios;

    public Projeto(String nome, Date dataCriacao) {
        this.nome = nome;
        this.dataCriacao = dataCriacao;
    }

    public Projeto() {

    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
