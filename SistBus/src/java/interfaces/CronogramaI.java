
package interfaces;

import java.util.List;
import modelo.CronogramaM;


public interface CronogramaI {
   public void guardarCronograma(CronogramaM cronograma) throws Exception;
   public void modificarCronograma(CronogramaM cronograma) throws Exception;
   public void eliminarCronograma(CronogramaM cronograma) throws Exception;
   List<CronogramaM> listarCronograma() throws Exception;
}
