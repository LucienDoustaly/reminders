/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaee.exercises.reminders.business;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ldoustaly
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@NotNull
@Constraint(validatedBy = ContextsValidator.class)
public @interface Contexts {

    String message() default "Context definitions are required to be match [a-z0-9]+";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
