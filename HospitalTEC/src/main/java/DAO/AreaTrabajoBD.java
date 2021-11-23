
package DAO;

import Modelo.AreaTrabajo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 * Clase para la conexion con AreaTrabajo
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class AreaTrabajoBD {
  private Conexion conexion = new Conexion();
  private AreaTrabajo area;
  
  /*
     * Método para consultar nombre de las Areas de Trabajo
     * @return un ResultSet con la información de las vacunas en la base de datos
     */
    public ResultSet consultarAreasTrabajo(){
      PreparedStatement ps;
      ResultSet rs;

      try{
        Connection con = conexion.getConexion();
        ps = con.prepareStatement("SELECT Codigo, NombreArea FROM AreaTrabajo");
        rs = ps.executeQuery();
        return rs;
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
        return null;
      }
    }
}
