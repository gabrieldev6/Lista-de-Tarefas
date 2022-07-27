package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectController  {
    public void save(Project project) {
        String sql = "INSERT INTO `todolist`.`projects`  "
                    +"(`name`, "
                    +"`description`, "
                    +"`createdAt`, "
                    +"`updatedAt` "
                    + ") VALUES (?, ?, ?, ?);";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setString(3, project.getCreatedAt());
            statement.setString(4, project.getUpdatedAt());
            
            
            statement.execute();
            
        } catch(SQLException erro) {
            throw new RuntimeException("erro ao salvar projeto:"+ erro);
            
        
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
    }
    
    public void update(Project project) {
        String sql = "UPDATE projects SET"
                + "name = ?,"
                + "description = ?,"
                + "createdAt =?,"
                + "updatedAt =?"
                + "WHERE id = ?";
        
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setString(3, project.getCreatedAt());
            statement.setString(4, project.getUpdatedAt());
            statement.setInt(5, project.getId());
            statement.execute();
            resultSet = statement.executeQuery();
        } catch (SQLException erro){
            throw new RuntimeException("erro ao alterar o projeto", erro);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
    }
    
    public List<Project> getAll(){
        String sql = "SELECT * FROM projects";
        List<Project> projects = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while(resultSet.next()) {

                Project project = new Project() ;
                
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getString("createdAt"));
                project.setUpdatedAt(resultSet.getString("updatedAt"));
                
                projects.add(project);
                
            }
            
            
        } catch (SQLException erro){
            throw new RuntimeException("erro em procurar projetos"+erro);
            
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        return projects ;
    }
    
    public void removeById(int id) {
        String sql = "DELETE FROM projects WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/contasBancarias?user=root&password=12345678");
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch(SQLException erro){
            throw new RuntimeException("Erro ao deletar o projeto", erro);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }   
    }
   
}
