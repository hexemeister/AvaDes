package br.ufrj.srh.converter;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;

import br.ufrj.srh.repository.ServidorRepository;
import br.ufrj.srh.entity.Servidor;
 

@FacesConverter("servidorConverter")
public class ServidorConverter implements Converter {
	
	@Autowired
	ServidorRepository dao;
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
    	
    	String k = "class org.primefaces.context.PrimeFacesContext";
    	String c = fc.getClass().toString();
    	
    	System.out.println("servidorConverter:" + c);
    	 if(value != null && value.trim().length() > 0) {
           try {
                
            	Servidor servidor = new Servidor();
            	Servidor s = new Servidor();
            	
            //	if(k.equals(c)) {s.setNome("servidorConverter"); } else {
                	
            		if (dao.consultarSQL(value).size()>0) {
            		servidor = dao.consultarSQL(value).get(0);}
             //   }
                	
                	//if(servidor == null) {
                	//	servidor = new Servidor();
                	//}
			
           
            	return 	servidor;
            } catch(NumberFormatException e) {
               throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
           }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
    	if(object != null) {
            //return String.valueOf(((Servidor) object).getSigepe());
            return String.valueOf(((Servidor) object).getSigepe());
            
        }
        else {
            return null;
        }
    }   
}     