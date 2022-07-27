package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ConnectionFactory {
    
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/todolist";
    public static final String USER = "root" ;
    public static final String PASS = "12345678" ;
            
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            System.out.println("conexao feita com sucesso");
            return DriverManager.getConnection(URL, USER, PASS);
        
        } catch (Exception erro) {
            throw new RuntimeException("Erro na conexao com o banco de dados", erro);
        }
        
    }
    
    public static void closeConnection(Connection connection){
        try{
            if(connection !=null){
                connection.close();
            }
        } catch (SQLException erro){
            throw new RuntimeException("Erro ao fechar a conexao com o banco de dados", erro);
        }
    }
    
    public static void closeConnection(Connection connection, PreparedStatement statement){
        try{
            if(connection !=null){
                connection.close();
            }
            if(statement !=null) {
                statement.close();
            }
        } catch (SQLException erro){
            throw new RuntimeException("Erro ao fechar a conexao com o banco de dados", erro);
        }
    }
    
    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if(connection != null){
                connection.close();
            }
            if(statement != null){
                statement.close();
            }
            
            if(resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException erro){
            throw new RuntimeException("Erro ao fechar a conexao com o banco de dados", erro);
        }
    }
    
}
