package dao;

import interfaces.PrecioI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.PrecioM;

public class PrecioD extends Dao implements PrecioI {

    @Override
    public void guardarPrecio(PrecioM precio) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO PRECIOS (PRECIO) values (?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, precio.getPRECIO());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
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

//    @Override
//    public List<PrecioM> listarPrecio() throws Exception {
//        List<PrecioM> lstPrecios;
//        ResultSet rs;
//        try {
//            this.conectar();
//            String sql = "SELECT * FROM PRECIOS";
//            PreparedStatement ps = this.getCn().prepareStatement(sql);
//            rs = ps.executeQuery();
//            lstPrecios = new ArrayList();
//            PrecioM precios;
//            while (rs.next()) {
//                precios = new PrecioM();
//                precios.setCODPRE(rs.getString("CODPRE"));
//                precios.setPRECIO(rs.getString("PRECIO"));
//                lstPrecios.add(precios);
//            }
//        } catch (SQLException e) {
//            throw e;
//        } finally {
//            this.cerrar();
//        }
//        return lstPrecios;
//    }

    @Override
    public List<PrecioM> listarPrecio() throws Exception {
       List<PrecioM> lstPrecio;
        ResultSet rs;
        try {
            this.conectar();
            String sql="SELECT * FROM PRECIOS";
            PreparedStatement ps=this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lstPrecio = new ArrayList();
            PrecioM precio;
            while(rs.next()){
                precio = new PrecioM();
                precio.setCODPRE(rs.getString("CODPRE"));
                precio.setPRECIO(rs.getString("PRECIO"));
                lstPrecio.add(precio);
            }
            
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return lstPrecio;
    }
}
