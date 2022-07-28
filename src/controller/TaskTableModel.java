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
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 3;
    }

    @Override //vai sobreescrever uma funcao que ja foi implementado
    public Class<?> getColumnClass(int columnIndex) {
    //aqui ele vai retornar pra interface qual o tipo de dado que vai
    //estar sendo apresentado na tabela de tarefas
        if(tasks.isEmpty()){ //se a task estiver vazia, vai ser retornado um tipo objeto
            return Object.class;
        }
        return this.getValueAt(0, columnIndex).getClass(); 
        //caso nao esteja vazio, ele vai pegar o tipo de classe
        //e retornar para tabela qual o tipo de dado, quando nao se faz isso
        //os dados que sao apresentados sao do tipo string
        //assim se caso houver um tipo boolean, ele nao vai ser renderizado
        //como um componente grafico mas, como uma string 

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
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex ) {
        tasks.get(rowIndex).setisisCompleted((boolean) value);
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
