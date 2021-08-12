package br.edu.ifsul.converter;

import br.edu.ifsul.modelo.Corretor;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.Converter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named(value = "converterCorretor")
@RequestScoped
public class ConverterCorretor implements Serializable, Converter{
    
    @PersistenceContext(unitName = "TrabPrimeiraEtapa-WebPU")
    protected EntityManager em;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("Selecione um registro")){
            return null;
        }
        return em.find(Corretor.class, Integer.parseInt(string));
    }
    
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if (t == null){
            return null;
        }
        Corretor obj = (Corretor) t;
        return obj.getId().toString();
    } 
}