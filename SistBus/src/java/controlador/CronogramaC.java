
package controlador;

import dao.CronogramD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.CronogramaM;


@Named(value = "cronogramaC")
@SessionScoped
public class CronogramaC implements Serializable {

   private CronogramaM cronograma = new CronogramaM();
   
   
   
   public void limpiar (){
       try {
           cronograma = new CronogramaM();
       } catch (Exception e) {
       }
   }
   
   
   public void guardarCronograma() throws Exception{
       CronogramD dao;
       try {
           dao = new CronogramD();
           dao.guardarCronograma(cronograma);
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado Correctamente", null));
           limpiar();
       } catch (Exception e) {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error el agregar", null));
          throw e;
       }
   }

    public CronogramaM getCronograma() {
        return cronograma;
    }

    public void setCronograma(CronogramaM cronograma) {
        this.cronograma = cronograma;
    }
   
}
