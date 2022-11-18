package br.com.ifood.domain;

public class Gerente extends Funcionario {

    private String turno;

    public Gerente() {
    }

    public Gerente(String nome, Integer idade, Double salario, String turno) {
        super(nome, idade, salario);
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }


}


