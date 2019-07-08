package interfaces;

import java.util.List;
import modelo.PrecioM;

public interface PrecioI {

    void guardarPrecio(PrecioM precio) throws Exception;

    void modificarPrecio(PrecioM precio) throws Exception;

    void eliminarPrecio(PrecioM precio) throws Exception;

    List<PrecioM> listarPrecio() throws Exception;
}
