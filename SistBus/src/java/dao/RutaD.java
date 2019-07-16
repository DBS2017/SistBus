
package dao;

import interfaces.RutaI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.RutaM;


public class RutaD  extends Dao implements RutaI{

    @Override
    public void guardarRuta(RutaM ruta) throws Exception {
        try {
            this.conectar();
            String sql="INSERT INTO RUTA(NOMRUT,PRECIOS_CODPRE) VALUES (?,?)";
            PreparedStatement ps=this.getCn().prepareStatement(sql);
            ps.setString(1, ruta.getNOMRUT());
            ps.setString(2, ruta.getPRECIOS_CODPRE());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
            
    }

    @Override
    public void modificarRuta(RutaM ruta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarRuta(RutaM ruta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RutaM> listarRuta() throws Exception {
        List<RutaM> listarRuta;
        ResultSet rs;
        try {
            this.conectar();
            String sql="SELECT * FROM RUTA";
            PreparedStatement ps=this.getCn().prepareStatement(sql);
            rs=ps.executeQuery();
            listarRuta = new ArrayList();
            RutaM ruta;
            while(rs.next()){
                ruta = new RutaM();
                ruta.setCODRUT(rs.getString("CODRUT"));
                ruta.setNOMRUT(rs.getString("NOMRUT"));
                ruta.setPRECIOS_CODPRE(rs.getString("PRECIOS_CODPRE"));
                listarRuta.add(ruta);
            }
            
        } catch (SQLException e) {
            throw  e;
        }finally{
            this.cerrar();
        }
        return listarRuta;         
    }
    
    
      public List<RutaM> listarRuta1() throws Exception {
        List<RutaM> listarRuta;
        ResultSet rs;
        try {
            this.conectar();
            String sql="SELECT * FROM RUTA";
            PreparedStatement ps=this.getCn().prepareStatement(sql);
            rs=ps.executeQuery();
            listarRuta = new ArrayList();
            RutaM ruta;
            while(rs.next()){
                ruta = new RutaM();
                ruta.setCODRUT(rs.getString("CODRUT"));
                ruta.setNOMRUT(rs.getString("NOMRUT"));
                listarRuta.add(ruta);
            }
            
        } catch (SQLException e) {
            throw  e;
        }finally{
            this.cerrar();
        }
        return listarRuta;         
    }
}
