/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaee.exercises.reminders.business.todos.boundary;

import com.javaee.exercises.reminders.business.todos.entity.ToDo;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ldoustaly
 */

@Stateless
@Path("todos")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class TodosResource {

    @Inject
    ToDoManager manager;

    @GET
    public List<ToDo> all() {
        return manager.all();
    }

    @Path("{id}")
    public ToDoResource find(@PathParam("id") long id) {
        return new ToDoResource(id, manager);
    }
}
