package br.csi.dao;
import br.csi.model.Usuario;
import br.csi.util.ConectaDBPostgres;
import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAO {

    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement preparedStatement;
    public ArrayList<Usuario> getUsuarios(){

        ArrayList<Usuario> users = new ArrayList<>();

        try {
             this.stmt = new ConectaDBPostgres ().getConexao().createStatement();
             this.rs = this.stmt.executeQuery("SELECT * FROM usuario");

            while (this.rs.next()) {
                Usuario u =
                        new Usuario(
                                this.rs.getInt("iduser"),
                                this.rs.getString("nome"),
                                this.rs.getString("senha"));
                users.add(u);
            }
            return users;
        }catch (java.sql.SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean cadastrar(Usuario usuario){
        try{
            Connection connection = new ConectaDBPostgres().getConexao();
            this.preparedStatement = connection.
                    prepareStatement("INSERT INTO  usuario(nome, senha) VALUES (?, ?)");
            this.preparedStatement.setString(1, usuario.getNome());
            this.preparedStatement.setString(2, usuario.getSenha());
            this.preparedStatement.execute();
            return true;

        }catch (java.sql.SQLException e){
            e.printStackTrace();
            return false;
        }

    }
    public boolean login(String nome, String senha){
        try {
            this.stmt = new ConectaDBPostgres().getConexao().createStatement();
            this.rs = this.stmt.executeQuery("SELECT * FROM usuario where nome = '"+nome+"' and senha = '"+senha+"'");
            Usuario usuario = new Usuario();
            while (this.rs.next()){
                this.rs.getInt("iduser");
                return true;
            }
            return false;
        }catch (java.sql.SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}

