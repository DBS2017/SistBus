package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.PersonaM;

public class PersonaD extends Dao implements interfaces.PersonaI {

    @Override
    public void guardarPersona(PersonaM persona) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO PERSONA (NOMPER,APEPER,TIPPER,TIPDOC,LUGPROCPER,DESPER,UBIGEO_CODUBI,BUSES_CODBUS) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, persona.getNOMPER()); //OK
            ps.setString(2, persona.getAPEPER()); //OK
            ps.setString(3, "C"); // C -> TIPO DE PERSONA CLIENTEN = C
            ps.setString(4, persona.getTIPDOC());//OK
            ps.setString(5, persona.getLUGPROCPER());
            ps.setString(6, persona.getDESPER());
            ps.setString(7, persona.getUBIGEO_CODUBI()); // OK
            ps.setString(8, "1");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificarPersona(PersonaM persona) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarPersona(PersonaM persona) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonaM> listarPersona() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<String> queryAutoCompleteUbi(String a) throws SQLException, ClassNotFoundException, Exception{
        this.conectar();
        ResultSet rs;
        List<String> lista;
        String sql;
        try {
            if (a == null || "".equals(a)) {
                sql = "SELECT  CODUBI,(DEPUBI || ', '|| PROUBI || ', '|| DISUBI) As UBIGEO FROM UBIGEO WHERE PROUBI LIKE ?";
                a = "CAÑETE";
            } else {
                sql = "SELECT CODUBI,(DEPUBI || ', '|| PROUBI || ', '|| DISUBI) AS UBIGEO FROM UBIGEO WHERE DISUBI like UPPER(?)";
            }
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, "%" + a + "%");
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()){
                lista.add(rs.getString("UBIGEO"));
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    } 
    
    public String leerUbi(String a) throws Exception{
        this.conectar();
        ResultSet rs;
        try {
            String sql = "SELECT CODUBI FROM UBIGEO WHERE (DEPUBI || ', '|| PROUBI || ', '|| DISUBI) = ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, a);
            rs = ps.executeQuery();
            if (rs.next()){
                return  rs.getString("CODUBI");
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }
}
