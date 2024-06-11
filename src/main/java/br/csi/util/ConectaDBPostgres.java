package br.csi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaDBPostgres {
    public Connection getConexao(){

        try{
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/tarefa_poo",
                    "postgres",
                    "1234");
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
