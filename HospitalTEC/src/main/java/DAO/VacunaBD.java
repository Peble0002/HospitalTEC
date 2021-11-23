
package DAO;

import Modelo.Vacuna;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase para conectar con la tabla Vacuna
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class VacunaBD {
  private Conexion conexion= new Conexion();
  private Vacuna vacuna;
  
  
  /**
   * Método para consultar nombre de las vacunas
   * @return un ResultSet con la información de las vacunas en la base de datos
   */
  public ResultSet consultarVacunas(){
    PreparedStatement ps;
    ResultSet rs;

    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT idVacuna, nombre FROM Vacuna");
      rs = ps.executeQuery();
      return rs;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  }
  
}


