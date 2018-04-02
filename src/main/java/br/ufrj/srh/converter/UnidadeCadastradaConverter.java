package br.ufrj.srh.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;

import br.ufrj.srh.repository.UnidadeRepository;
import br.ufrj.srh.entity.Unidade;
import br.ufrj.srh.entity.UnidadeCadastradaX;

 
 
@FacesConverter("unidadeCadastradaConverter")
public class UnidadeCadastradaConverter implements Converter {
 
	@Autowired
	UnidadeRepository unidadeRepository;

	@Autowired
	UnidadeCadastradaX uc;
	
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
             //   ThemeService service = (ThemeService) fc.getExternalContext().getApplicationMap().get("themeService");
                
            	UnidadeCadastradaX uc = new UnidadeCadastradaX();
            
            	//uc = daoU.consultar(Long.valueOf(value).longValue());
            	//	UnidadeExtendida ue = new UnidadeExtendida();
            	
            //	UnidadeDAO dao = new UnidadeDAO();
            //	ue=dao.listar_UnidadeExtendidaFiltroUnidade(value).get(0);
            	
            	uc.setCodigo(Long.valueOf(value).longValue());
            	uc.setNome("convertido");
            	
                
            	return uc;
                
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
            return String.valueOf(((UnidadeCadastradaX) object).getCodigo());
        }
        else {
            return null;
        }
    }   
}         
           
