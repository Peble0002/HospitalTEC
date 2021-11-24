
package DAO;

import Modelo.Bitacora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import javax.swing.JOptionPane;

/* Clase para conectar con la tabla Bitacora
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (22/11/2021)
 */
public class BitacoraBD {
  private Conexion conexion= new Conexion();
  private Bitacora bitacora;

   /**
   * Método para insertar una bitacora en la base de datos
   * @param pBitacora
   */
  public void insertarPaciente(Bitacora pBitacora){
    try{

      Connection con = conexion.getConexion();

      PreparedStatement ps = con.prepareStatement("INSERT INTO Paciente "
              + "(idPaciente, nacionalidad, tipoSangre, fechaNacimiento, "
              + "provincia, canton) VALUES (?,?,?,?,?,?)");
      ps.setDate(1, pBitacora.getFecha());
      Time hora = Time.valueOf(pBitacora.getHora());
      ps.setTime(2, hora);
      ps.setString(3, pBitacora.getNombreUsuario());
      ps.setString(4, pBitacora.getEstado().name());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Registro de Bitacora completado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
}