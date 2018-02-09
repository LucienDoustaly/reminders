package com.javaee.exercises.reminders.business.todos.boundary;

import com.javaee.exercises.reminders.business.todos.entity.ToDo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

@Stateless
public class ToDoManager {

    @PersistenceContext
    EntityManager em;

    public List<ToDo> all() {
        return this.em.createNamedQuery(ToDo.findAll, ToDo.class).
                getResultList();
    }

    public ToDo save(ToDo todo) {
        return this.em.merge(todo);
    }

    public void delete(long id) {
        try {
            ToDo reference = this.em.getReference(ToDo.class, id);
            this.em.remove(reference);
        } catch (EntityNotFoundException e) {
        }
    }

    public ToDo findById(long id) {
        return this.em.find(ToDo.class, id);
    }
}
