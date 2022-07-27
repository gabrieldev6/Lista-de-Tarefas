package controller;

import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;



public class TaskController {
    public void save(Task task)  {
        String sql = "INSERT INTO tasks "
                    +"name, "
                    +"description, "
                    +"notes, "
                    +"deadline, "
                    +"createdAt, "
                    +"updatedAt, "
                    +"updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.getisIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setString(6, task.getDeadline());
            statement.setString(7, task.getCreatedAt());
            statement.setString(8, task.getUpdatedAt());
            statement.setInt(9, task.getId());
            statement.execute();
            
        } catch (SQLException error) {
            throw new RuntimeException("Erro ao executar funcao sql");
        
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
            
        }   
        
    }
    
    
    public void update(Task task) {//Task task
        String sql = "UPDATE task SET"
                +"idProject =?"
                +"name = ?,"
                +"description = ?,"
                +"notes = ?,"
                +"completed = ?,"
                +"deadline = ?,"
                +"createdAt = ?,"
                +"updatedAt =?"
                +"WHERE id =?";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setString(5, task.getNotes());
            statement.setBoolean(4, task.getisIsCompleted());
            statement.setString(6, task.getDeadline());
            statement.setString(7, task.getCreatedAt());
            statement.setString(8, task.getUpdatedAt());
            statement.execute();
        
        } catch (SQLException erro){
            throw new RuntimeException("Erro ao deletar dados", erro);
        
        } finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
        
    }
    
    
    public void removeById(int taskId) {
        String sql = "DELETE FROM tasks WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
        
        } catch(SQLException erro){
            throw new RuntimeException("Erro ao deletar dados", erro);
            
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
 
    }
    
    
    public List<Task> getAll(int idProject) {
        String sql = "SELECT * FROM task WHERE idProject = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null ;
        
        List<Task> tasks = new ArrayList<>();
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idProject);
            resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setidProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setNotes(resultSet.getString("notes"));
                task.setisisCompleted(resultSet.getBoolean("isCompleted"));
                task.setDeadline(resultSet.getString("deadline"));
                task.setCreatedAt(resultSet.getString("createdAt"));
                task.setUpdatedAt(resultSet.getString("updatedAt"));
                
                tasks.add(task);
            }
        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao pesquisar tabela Task: "+erro);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        return tasks;
    }


}
