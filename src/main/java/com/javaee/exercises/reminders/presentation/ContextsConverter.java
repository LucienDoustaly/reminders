package com.javaee.exercises.reminders.presentation;

import java.util.ArrayList;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;

/**
 *
 * @author ldoustaly
 */
@FacesConverter("contextsConverter")        
public class ContextsConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value){
        String[] list = value.split(",");
        List<String> contexts = new ArrayList<String>();
        for(String elem : list){
            contexts.add(elem);
        }
    return contexts;
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value){
        List<String> contexts = (List<String>) value;
        String ch = "";
        for (int i = 0; i < contexts.size() ; i++){
            ch += contexts.get(i);
            if(i != contexts.size()-1)
                ch += ",";
        }
    return ch;
    }
}
