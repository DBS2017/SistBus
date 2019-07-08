package controlador;

import dao.PrecioD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.PrecioM;

@Named(value = "preciosC")
@SessionScoped
public class PreciosC implements Serializable {

    private PrecioM precio = new PrecioM();

    
    public void limpiar(){
        try {
            precio = new PrecioM();
        } catch (Exception e) {
        }
    }
    
    
    public void guardarPrecio() throws Exception {
        PrecioD dao;
        try {
            dao = new PrecioD();
            dao.guardarPrecio(precio);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGADO", null));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", null));
            throw e;
        }
    }

    public PrecioM getPrecio() {
        return precio;
    }

    public void setPrecio(PrecioM precio) {
        this.precio = precio;
    }

}
