/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaee.exercises.reminders.business.todos.boundary;

import com.javaee.exercises.reminders.business.todos.entity.ToDo;
import javax.ws.rs.GET;

/**
 *
 * @author ldoustaly
 */

public class ToDoResource {
    long id;
    ToDoManager manager;

    public ToDoResource(long id, ToDoManager manager) {
        this.id = id;
        this.manager = manager;
    }           
    
    @GET
    public ToDo find() {   
        return manager.findById(id);
    }
}
