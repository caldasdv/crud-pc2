package br.com.prog2.rh.model;

public class Empregado {
    private String cpf;
    private String nome;
    private Integer idade;
    private Double salario;
    public Empregado(){}
    //get/set
    public String getCpf() {
        return cpf;
    }
    public String getNome() {
        // TODO Auto-generated method stub
        return nome;
    }
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}