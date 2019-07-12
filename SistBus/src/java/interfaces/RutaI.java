package interfaces;

import java.util.List;
import modelo.RutaM;

public interface RutaI {

    void guardarRuta(RutaM ruta) throws Exception;

    void modificarRuta(RutaM ruta) throws Exception;

    void eliminarRuta(RutaM ruta) throws Exception;

    List<RutaM> listarRuta() throws Exception;
}
