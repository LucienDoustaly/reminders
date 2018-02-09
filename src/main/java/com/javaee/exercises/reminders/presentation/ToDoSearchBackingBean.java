package com.javaee.exercises.reminders.presentation;

import com.javaee.exercises.reminders.business.todos.boundary.ToDoManager;
import com.javaee.exercises.reminders.business.todos.entity.ToDo;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author ldoustaly
 */
@Model
public class ToDoSearchBackingBean {

    @Inject
    ToDoManager boundary;

    boolean noresult = true;
    
    ToDo todo;
    List<ToDo> matchTodos;
    
    public List<ToDo> getToDos() {
        return this.boundary.all();
    }
    
    
    public List<ToDo> getMatchtodos() {
        return this.matchTodos;
    }
    
    public String searchTodos(ToDo task) {
        this.matchTodos = new ArrayList<ToDo>();
        List<ToDo> todos;
        todos = getToDos();
        for(ToDo todo : todos){
            //String[] list = todo.getCaption().split(" ");
                       
                if(todo.getCaption().contains(task.getCaption())){
                    List<String> matchContexts = new ArrayList<String>();
                    int cpt = 0;
                    for (String taskcontext : task.getContexts()){
                        
                        for (String context : todo.getContexts()){
                            if (taskcontext.contains(context)){ //java
                                cpt += 1;
                                break;
                            }

                        }
                    }
                    if (cpt == task.getContexts().size()){
                        this.matchTodos.add(todo);
                    }
                }
        }
  
        if (this.matchTodos.size() >= 1){
            this.noresult = false;
        }
        else {
            this.noresult = true;
        }
        return "search-todos";
    }
    
 
    public boolean getTest(){
        return this.noresult;
    }
}
