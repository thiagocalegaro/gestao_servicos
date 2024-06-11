package br.csi.dao;
import br.csi.model.Funcionario;
import br.csi.model.Servico;
import br.csi.util.ConectaDBPostgres;
import java.sql.*;
import java.util.ArrayList;

public class FuncionarioDAO {
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement preparedStatement;
    private String status;

    public ArrayList<Funcionario> getFuncionario() {

        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        try {
            this.stmt = new ConectaDBPostgres().getConexao().createStatement();
            this.rs = this.stmt.executeQuery("SELECT * FROM funcionario");

            while (this.rs.next()) {
                funcionarios.add(new Funcionario(this.rs.getInt("idfunc"),
                        this.rs.getString("nomefunc"),
                        this.rs.getFloat("salario")));

            }
            return funcionarios;

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Funcionario buscarFuncionario(String func){
        ArrayList<Funcionario> funcionarios = new FuncionarioDAO().getFuncionario();
        try{
            this.stmt = new ConectaDBPostgres().getConexao().createStatement();
            this.rs = this.stmt.executeQuery("SELECT * FROM funcionario");

            for(Funcionario f : funcionarios) {
                System.out.println("ID: " + f.getIdFunc()
                        + "\nNOME: " + f.getNome()
                        + "\nSENHA: " + f.getSalario());
                if (f.getNome().equals(func)){
                    return f;
                }
            }
        }catch (java.sql.SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean cadastrar(Funcionario funcionario) {
        try {
            Connection connection = new ConectaDBPostgres().getConexao();
            this.preparedStatement = connection.prepareStatement(
                    "INSERT INTO  funcionario(nomefunc, salario) VALUES (?, ?)");

            //funcionario.setIdFunc(this.rs.getInt(1));

            this.preparedStatement.setString(1, funcionario.getNome());
            this.preparedStatement.setFloat(2, funcionario.getSalario());
            this.preparedStatement.execute();
            /*this.rs.next();
            if (this.rs.getInt(1) > 0){
                this.status = "ok";
            }*/
            return true;

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* public boolean alterar(int idFunc, float salario){
        try{
            this.stmt = new ConectaDBPostgres().getConexao().createStatement();
            this.rs = this.stmt.executeQuery("UPDATE funcionario " + idFunc);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
    }*/
    public boolean demitir(int idFunc) {
        try {
            this.stmt = new ConectaDBPostgres().getConexao().createStatement();
            stmt.execute("DELETE FROM funcionario WHERE idfunc =" + idFunc);
            return true;
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

