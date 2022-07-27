package javaapplication1;

import controller.ProjectController;

public class JavaApplication1 {


    public static void main(String[] args) {
        
        ProjectController controller = new ProjectController();
        
        
        System.out.println(controller.getAll());
    }

}
