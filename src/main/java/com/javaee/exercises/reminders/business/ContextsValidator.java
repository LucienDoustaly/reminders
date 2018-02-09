/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaee.exercises.reminders.business;

import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author ldoustaly
 */
public class ContextsValidator implements ConstraintValidator<Contexts, List<String>> {

    @Override
    public void initialize(Contexts contexts) {
    }

    @Override
    public boolean isValid(List<String> contexts, ConstraintValidatorContext ctx) {
        if(contexts != null) {
            for(String context : contexts) {
                if (!context.matches("[a-z0-9]+")) {
                    return false;
                }
            }
        }
        return true;
    }
}
