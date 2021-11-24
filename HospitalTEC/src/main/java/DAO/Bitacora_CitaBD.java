
package DAO;

import Modelo.Bitacora;
import Modelo.Cita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import javax.swing.JOptionPane;

/**
 * Clase para conectar con la tabla Bitacora_Cita
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (23/11/2021)
 */
public class Bitacora_CitaBD {
  private Conexion conexion= new Conexion();
  private Bitacora bitacora;
  private Cita cita; 
  
  public void insertarBitacoraCita(Bitacora pBitacora, Cita pCita){
    try{

      Connection con = conexion.getConexion();

      PreparedStatement ps = con.prepareStatement("INSERT INTO Bitacora_Cita "
              + "(IdCita, IdBitacora) VALUES (?,?)");
      ps.setInt(1, pCita.getIdCita());
      ps.setInt(2, pBitacora.getIdBitacora());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Registro de Cita en Bitacora completado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }  
}
