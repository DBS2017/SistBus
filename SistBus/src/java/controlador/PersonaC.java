package controlador;

import dao.PersonaD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.PersonaM;

@Named(value = "personaC")
@SessionScoped
public class PersonaC implements Serializable {

    private PersonaM persona = new PersonaM();
    
    
  
    
    
    
    public void limpiarPersona()throws Exception{
        persona = new PersonaM();
    }
    
    
    public void guardarPersona() throws Exception {
        PersonaD dao;
        try {
            dao = new PersonaD();
            persona.setUBIGEO_CODUBI(dao.leerUbi(persona.getUBIGEO_CODUBI()));
            dao.guardarPersona(persona);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado Correctamente", null));
            limpiarPersona();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al Agregar", null));
            throw e;
        }
    }

    
    public List<String> completeTextUbi(String query) throws SQLException, Exception{
        PersonaD dao = new PersonaD();
        return dao.queryAutoCompleteUbi(query);
    }
    
    
    
    public PersonaM getPersona() {
        return persona;
    }

    public void setPersona(PersonaM persona) {
        this.persona = persona;
    }
    
    
}
