/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaee.exercises.reminders.business.todos.entity;

import com.javaee.exercises.reminders.business.Contexts;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ldoustaly
 */
@Entity
@NamedQuery(name = ToDo.findAll, query = "SELECT t FROM ToDo t")
public class ToDo {

    @Id
    @GeneratedValue
    private long id;

    static final String PREFIX = "reminders.entity.ToDo.";
    public static final String findAll = PREFIX + "findAll";

    @NotNull
    @Size(min = 2, max = 256, message = "Caption length size must be between 2 and 256")
    private String caption;
    
    private String description;
    private int priority;
    private boolean done;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @Contexts
    private List<String> contexts;

    @Version
    private long version;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }  
    
    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
    
    public List<String> getContexts() {
        return contexts;
    }

    public void setContexts(List<String> contexts) {
        this.contexts = contexts;
    }       

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
    
    @PrePersist
    @PreUpdate
    public void updateDate() {
        this.updated = new Date();
    }    

    @Override
    public String toString() {
        return "ToDo{" + "id=" + id + ", caption=" + caption + ", description=" + description + ", priority=" + priority + ", done=" + done + ", version=" + version + '}';
    }
}
