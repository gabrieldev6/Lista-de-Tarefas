package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TaskTableModel extends AbstractTableModel{
    
    
    String[] columns = {"nome", "descricao", "prazo", "tarefa concluida", "editado", "notas"};
    List<Task> tasks = new ArrayList();
    
    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0://nome
                return tasks.get(rowIndex).getName();
                
            case 1://descricao
                return tasks.get(rowIndex).getDescription();
                
            case 2://prazo
                return tasks.get(rowIndex).getDeadline();
                
            case 3://tarefa concluida
                return tasks.get(rowIndex).getisIsCompleted();
                
            case 4://editado
                return tasks.get(rowIndex).getUpdatedAt();
            
            case 5://notas
                return tasks.get(rowIndex).getNotes();
            default:
                return "dado nao encontrado";
                
        }
    }

    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    
}
