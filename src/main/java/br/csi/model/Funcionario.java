package br.csi.model;

public class Funcionario {
    private int idFunc;
    private String nome;
    private float salario;
    private Usuario usuario;

    public Funcionario(int idFunc, String nome, float salario/*, Usuario usuario*/) {
        this.idFunc = idFunc;
        this.nome = nome;
        this.salario = salario;
        //this.usuario = usuario;
    }
    public Funcionario(){

    }

    public int getIdFunc() {return idFunc;}

    public void setIdFunc(int idFunc) {this.idFunc = idFunc;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public float getSalario() {return salario;}

    public void setSalario(float salario) {this.salario = salario;}

    public Usuario getUsuario() {return usuario;}

    public void setUsuario(Usuario usuario) {this.usuario = usuario;}
}
