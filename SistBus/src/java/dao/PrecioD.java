
package dao;

import interfaces.PrecioI;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import modelo.PrecioM;


public class PrecioD extends  Dao implements PrecioI{

    @Override
    public void guardarPrecio(PrecioM precio) throws Exception {
        try {
            this.conectar();
            String sql="INSERT INTO PRECIOS (PRECIO) values (?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, precio.getPRECIO());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void modificarPrecio(PrecioM precio) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarPrecio(PrecioM precio) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PrecioM> listarPrecio() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
