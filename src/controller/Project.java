
package controller;
import java.util.Date;

public class Project {
    private int id;
    private String name;
    private String description;
    private String createdAt;
    private String updatedAt;
    
    public Project() {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
       
    }

    
    public Project(int id, String name, String description, String createdAt, String updatedAt) {
       this.id = id;
       this.name = name;
       this.description = description;
       this.createdAt = createdAt;
       this.updatedAt = updatedAt;
       
    }

    
    

   
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
            
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }
    
    public String getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }
    @Override
    public String toString() {
        return this.name;
    }
    
}
