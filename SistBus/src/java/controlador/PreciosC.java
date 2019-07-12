package controlador;

import dao.PrecioD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.PrecioM;

@Named(value = "preciosC")
@SessionScoped
public class PreciosC implements Serializable {

    private PrecioM precio = new PrecioM();
    private List<PrecioM> lstPrecios;

    
    @PostConstruct
    public void listar(){
        try {
            listarPrecio();
        } catch (Exception e) {
        }
    }
            
    
    
    public void limpiar() {
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

    public void listarPrecio() throws Exception {
        PrecioD dao;
        try {
            dao = new PrecioD();
            lstPrecios = dao.listarPrecio();
        } catch (Exception e) {
            throw e;
        }
    }

    public PrecioM getPrecio() {
        return precio;
    }

    public void setPrecio(PrecioM precio) {
        this.precio = precio;
    }

    public List<PrecioM> getLstPrecios() {
        return lstPrecios;
    }

    public void setLstPrecios(List<PrecioM> lstPrecios) {
        this.lstPrecios = lstPrecios;
    }

}
