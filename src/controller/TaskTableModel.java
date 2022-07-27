package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TaskTableModel extends AbstractTableModel{
    
    
    String[] columns = {"nome", "descricao", "prazo", "tarefa concluida", "editar", "excluir"};
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 1:
                return tasks.get(rowIndex).getName();
                
            case 2:
                return tasks.get(rowIndex).getDescription();
                
            case 3:
                return tasks.get(rowIndex).getDeadline();
                
            case 4:
                return tasks.get(rowIndex).getisIsCompleted();
                
            case 5:
                return tasks.get(rowIndex).getNotes();
                
            default:
                return "dados nao encontrado";
                
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
