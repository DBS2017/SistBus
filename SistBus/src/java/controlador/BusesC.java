package controlador;

import dao.BusesD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.BusesM;

@Named(value = "busesC")
@SessionScoped
public class BusesC implements Serializable {

    private BusesM buses = new BusesM();

    public void limpiarBuses() {
        try {
            buses = new BusesM();
        } catch (Exception e) {
        }
    }

    public void guardarBuses() throws Exception {
        BusesD dao;
        try {
            dao = new BusesD();
            dao.guardarBuses(buses);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado Correctamente", null));
            limpiarBuses();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al Guardar", null));
            throw e;
        }
    }

    public BusesM getBuses() {
        return buses;
    }

    public void setBuses(BusesM buses) {
        this.buses = buses;
    }
    
    
}
