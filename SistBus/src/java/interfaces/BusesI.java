
package interfaces;

import java.util.List;
import modelo.BusesM;


public interface BusesI {
    void guardarBuses(BusesM buses) throws Exception;
    void modificarBuses(BusesM buses) throws Exception;
    void eliminarBuses(BusesM buses) throws Exception;
    List<BusesM> listarBuses() throws Exception;
}
