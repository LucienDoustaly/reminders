package com.javaee.exercises.reminders.presentation;

import com.javaee.exercises.reminders.business.todos.boundary.ToDoManager;
import com.javaee.exercises.reminders.business.todos.entity.ToDo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author ldoustaly
 */

@Model
public class ToDoBackingBean {

    @Inject
    ToDoManager boundary;

    ToDo todo;

    @PostConstruct
    public void init() {
        this.todo = new ToDo();
    }

    public ToDo getTodo() {
        return todo;
    }

    public List<ToDo> getToDos() {
        return this.boundary.all();
    }

    public void addToDo() {
        ToDo td = this.boundary.save(todo);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ToDo",
                String.format("ToDo \"%1s\" created!", td.getCaption()));
        FacesContext.getCurrentInstance().addMessage("", message);
        init();
    }

    public void changeStatus(ToDo toDo) {
        toDo.setDone(!toDo.isDone());
        this.boundary.save(toDo);
    }

    public String editToDo(ToDo toDo) {
        this.todo = toDo;
        return "edit-todo";
    }

    public String saveToDo() {
        this.boundary.save(todo);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ToDo",
                String.format("ToDo \"%1s\" saved!", todo.getCaption()));
        FacesContext.getCurrentInstance().addMessage("", message);
        return "list-todos?faces-redirect=true";
    }

    public void removeToDo(ToDo toDo) {
        this.boundary.delete(toDo.getId());
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ToDo",
                String.format("ToDo \"%1s\" deleted!", todo.getCaption()));
        FacesContext.getCurrentInstance().addMessage("", message);
    }
}
