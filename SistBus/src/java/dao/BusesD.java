
package dao;

import interfaces.BusesI;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import modelo.BusesM;


public class BusesD extends Dao implements BusesI{

    @Override
    public void guardarBuses(BusesM buses) throws Exception {
        try {
            this.conectar();
            String sql="INSERT INTO BUSES (NOMBUS,CLABUS,ASIEBUS,PLACBUS,CRONOGRAMA_CODCRO,COSTOS_TRANSPORTE_CODCOS) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps=this.getCn().prepareStatement(sql);
            ps.setString(1, buses.getNOMBUS());
            ps.setString(2, buses.getCLABUS());
            ps.setString(3, buses.getASIEBUS());
            ps.setString(4, buses.getPLACBUS());
            ps.setString(5, "1");
            ps.setString(6, "1");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void modificarBuses(BusesM buses) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarBuses(BusesM buses) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BusesM> listarBuses() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
