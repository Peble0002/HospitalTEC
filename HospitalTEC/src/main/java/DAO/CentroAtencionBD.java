
package DAO;

import Modelo.CentroAtencion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase para conectar con la tabla CentroAtencion
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class CentroAtencionBD {
  private Conexion conexion= new Conexion();
  private CentroAtencion centroAtencion;
  
  /*
   * Método para consultar nombre de los centros de atención
   * @return un ResultSet con la información de las vacunas en la base de datos
   */
  public ResultSet consultarCentroAtencion(){
    PreparedStatement ps;
    ResultSet rs;

    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT Codigo, nombreCentro FROM CentroAtencion");
      rs = ps.executeQuery();
      return rs;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  }
}
