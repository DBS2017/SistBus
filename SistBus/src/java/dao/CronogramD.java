/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.CronogramaI;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import modelo.CronogramaM;

/**
 *
 * @author zecarlos
 */
public class CronogramD extends Dao implements CronogramaI{

    @Override
    public void guardarCronograma(CronogramaM cronograma) throws Exception {
         try {
            this.conectar();
            String sql="INSERT INTO CRONOGRAMA(FECLLE,HORLLE,FECSAL,HORSAL) VALUES (?,?,?,?)";
            PreparedStatement ps=this.getCn().prepareStatement(sql);
            ps.setString(1, cronograma.getFECLLE());
            ps.setString(2, cronograma.getHORLLE());
            ps.setString(3, cronograma.getFECSAL());
            ps.setString(4, cronograma.getHORSAL());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void modificarCronograma(CronogramaM cronograma) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarCronograma(CronogramaM cronograma) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CronogramaM> listarCronograma() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
