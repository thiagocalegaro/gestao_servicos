package br.csi.model;
import java.util.Date;

public class Servico {
    private int idServ;
    private String nome;
    private String local;
    private Date data;
    private float valor;
    private Usuario usuario;
    private Funcionario funcionario;

    public Servico(int idServ, String nome, String local, /*Date data,*/ float valor, Funcionario funcionario/*, Usuario usuario*/) {
        this.nome = nome;
        this.local = local;
        //this.data = data;
        this.valor = valor;
        this.funcionario = funcionario;
        //this.usuario = usuario;
    }
    public Servico(){

    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getIdServ() {
        return idServ;
    }

    public void setIdServ(int idServ) {
        this.idServ = idServ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public java.sql.Date getData() {
        return (java.sql.Date) data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
        System.out.println(funcionario.getNome());
    }
}
