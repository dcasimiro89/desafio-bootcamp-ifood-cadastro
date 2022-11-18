package br.com.ifood.domain;

public class Funcionario {

    private String nome;
    private Integer idade;
    private Double salario;

    public  Funcionario() {}

    public Funcionario(String nome, Integer idade, Double salario) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

    public void maiorIdade() {};
    public void maiorSalario() {};
    public void totalSalario() {};
    public void quantidadeFuncionarios() {};
    public void adicionarFuncionario() {};

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    @Override
    public String toString() {
        return "Funcionarios{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", salario=" + salario +
                '}';
    }


}
