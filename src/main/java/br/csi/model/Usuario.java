package br.csi.model;

public class Usuario {
    private int idUser;
    private String nome;
    private String senha;
    private float valor;


    public Usuario( int idUser, String nome, String senha) {
        this.idUser = idUser;
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario() {

    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }


}
