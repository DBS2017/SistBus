package controlador;

import dao.RutaD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.RutaM;

@Named(value = "rutaC")
@SessionScoped
public class RutaC implements Serializable {

    private RutaM ruta = new RutaM();
    private List<RutaM> lstRuta;

    public void limpiarRuta() {
        try {
            ruta = new RutaM();
        } catch (Exception e) {
        }

    }

    public void guardar() throws Exception {
        RutaD dao;
        try {
            dao = new RutaD();
            dao.guardarRuta(ruta);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGADO", null));
            limpiarRuta();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AGREGADO", null));
            throw e;
        }
    }

    public void listarRuta() throws Exception {
        RutaD dao;
        try {
            dao = new RutaD();
            lstRuta = dao.listarRuta();
        } catch (Exception e) {
            throw e;
        }
    }

    public RutaM getRuta() {
        return ruta;
    }

    public void setRuta(RutaM ruta) {
        this.ruta = ruta;
    }

    public List<RutaM> getLstRuta() {
        return lstRuta;
    }

    public void setLstRuta(List<RutaM> lstRuta) {
        this.lstRuta = lstRuta;
    }

}
