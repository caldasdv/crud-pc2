package br.com.prog2.rh.model;

public class Empregado {
    // Atributos privados da classe Empregado
    private String cpf;         // CPF do empregado
    private String nome;        // Nome do empregado
    private Integer idade;      // Idade do empregado
    private Double salario;     // Salário do empregado

    /**
     * Construtor padrão da classe Empregado.
     * Cria uma nova instância de Empregado com atributos padrão.
     */
    public Empregado() {}

    // Métodos getters e setters

    /**
     * Obtém o CPF do empregado.
     *
     * @return o CPF do empregado
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF do empregado.
     *
     * @param cpf o CPF a ser definido para o empregado
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Obtém o nome do empregado.
     *
     * @return o nome do empregado
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do empregado.
     *
     * @param nome o nome a ser definido para o empregado
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a idade do empregado.
     *
     * @return a idade do empregado
     */
    public Integer getIdade() {
        return idade;
    }

    /**
     * Define a idade do empregado.
     *
     * @param idade a idade a ser definida para o empregado
     */
    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    /**
     * Obtém o salário do empregado.
     *
     * @return o salário do empregado
     */
    public Double getSalario() {
        return salario;
    }

    /**
     * Define o salário do empregado.
     *
     * @param salario o salário a ser definido para o empregado
     */
    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
