package controller;
import java.util.Date;

public class Task {
    private int id;
    private int idProject;
    private String name;
    private String description;
    private String notes;
    private boolean isCompleted;
    private String deadline;
    private String createdAt;
    private String updatedAt;
    
    public Task() {
         this.id = id;
         this.idProject = idProject;
         this.name = name;
         this.description = description;
         this.notes = notes;
         this.isCompleted = isCompleted;
         this.deadline = deadline;
         this.createdAt = createdAt;
         this.updatedAt = updatedAt;
    }

    public Task(int id, int idProject, String name, String description, String notes,
                boolean isCompleted, String deadline, String createdAt, String updatedAt) {
        
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.description = description;
        this.notes = notes;
        this.isCompleted = isCompleted;
        this.deadline = deadline;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    
    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public int getIdProject() {
        return idProject;
    }
    public void setidProject(int idProject){
        this.idProject = idProject;
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
    
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes){
        this.notes = notes;
    }
    
    public boolean getisIsCompleted() {
        return isCompleted;
    }
    public void setisisCompleted(boolean isCompleted){
        this.isCompleted = isCompleted;
    }
    
    public String getDeadline (){
        return deadline;
    }
    public void setDeadline(String deadline){
        this.deadline = deadline;
    }
    
    public String getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    public String getUpdatedAt(){
        return updatedAt;
    }
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", idProject=" + idProject + ", name=" + name + ", description=" + description + ", notes=" + notes + ", isCompleted=" + isCompleted + ", deadline=" + deadline + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }

}
