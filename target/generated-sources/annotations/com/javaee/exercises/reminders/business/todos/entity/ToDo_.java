package com.javaee.exercises.reminders.business.todos.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-15T12:49:45")
@StaticMetamodel(ToDo.class)
public class ToDo_ { 

    public static volatile SingularAttribute<ToDo, String> caption;
    public static volatile SingularAttribute<ToDo, String> description;
    public static volatile SingularAttribute<ToDo, Long> id;
    public static volatile ListAttribute<ToDo, String> contexts;
    public static volatile SingularAttribute<ToDo, Integer> priority;
    public static volatile SingularAttribute<ToDo, Boolean> done;
    public static volatile SingularAttribute<ToDo, Date> updated;
    public static volatile SingularAttribute<ToDo, Long> version;

}