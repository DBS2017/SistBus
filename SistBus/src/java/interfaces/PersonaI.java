
package interfaces;

import java.util.List;
import modelo.PersonaM;


public interface PersonaI {
    void guardarPersona(PersonaM persona) throws Exception;
    void modificarPersona(PersonaM persona) throws Exception;
    void eliminarPersona(PersonaM persona) throws Exception;
    List<PersonaM> listarPersona() throws Exception;
}
