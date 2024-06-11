package br.csi.dao;
import br.csi.model.Funcionario;
import br.csi.model.Servico;
import br.csi.model.Usuario;
import br.csi.util.ConectaDBPostgres;
import java.sql.*;
import java.util.ArrayList;

public class ServicoDAO {
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement preparedStatement;
    public ArrayList<Servico> getServico() {

        ArrayList<Servico> servicos = new ArrayList<>();

        try {
            this.stmt = new ConectaDBPostgres().getConexao().createStatement();
            this.rs = this.stmt.executeQuery("SELECT * FROM servico, funcionario WHERE servico.idfunc = funcionario.idfunc");

            while (this.rs.next()) {
                Servico servico = new Servico();
                        servico.setIdServ(this.rs.getInt("idserv"));
                        servico.setNome(this.rs.getString("nome"));
                        servico.setLocal(this.rs.getString("local"));
                        servico.setValor(this.rs.getFloat("valor"));
                        Funcionario funcionario = new Funcionario();
                        funcionario.setIdFunc(this.rs.getInt("idfunc"));//problema esta aq
                        funcionario.setNome(this.rs.getString("nomefunc"));
                        funcionario.setSalario(this.rs.getFloat("salario"));
                        Usuario usuario = new Usuario();
                        usuario.setIdUser(this.rs.getInt("iduser"));
                        servico.setFuncionario(funcionario);

                servicos.add(servico);
            }
            return servicos;

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean adicionar(Servico servico, Funcionario funcionario){
        try{
            Connection connection = new ConectaDBPostgres().getConexao();
            this.preparedStatement = connection.
                    prepareStatement("INSERT INTO  servico(nome, local, /*data,*/ valor, idfunc ) VALUES (?, ?, ?,?)");
            this.preparedStatement.setString(1, servico.getNome());
            this.preparedStatement.setString(2, servico.getLocal());
            //this.preparedStatement.setDate(3, servico.getData());
            this.preparedStatement.setFloat(3, servico.getValor());
            this.preparedStatement.setInt(4, funcionario.getIdFunc());
            this.preparedStatement.execute();

            return true;

        }catch (java.sql.SQLException e){
            e.printStackTrace();
            return false;
        }

    }
    public boolean cancelar(int idServ) {
        try {
            this.stmt = new ConectaDBPostgres().getConexao().createStatement();
                stmt.execute("DELETE FROM servico WHERE idserv =" + idServ);
            return true;
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean editar(Servico servico, Funcionario funcionario){
        try{
            Connection connection = new ConectaDBPostgres().getConexao();
            this.preparedStatement = connection.
                    prepareStatement("UPDATE  servico SET nome = ?, local = ?, valor = ?, idfunc = ? WHERE ");
            this.preparedStatement.setString(1, servico.getNome());
            this.preparedStatement.setString(2, servico.getLocal());
            //this.preparedStatement.setDate(3, servico.getData());
            this.preparedStatement.setFloat(3, servico.getValor());
            this.preparedStatement.setInt(4, funcionario.getIdFunc());
            this.preparedStatement.execute();

            return true;

        }catch (java.sql.SQLException e){
            e.printStackTrace();
            return false;
        }
    }

}
