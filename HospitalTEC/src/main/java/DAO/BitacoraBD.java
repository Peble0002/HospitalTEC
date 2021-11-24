
package DAO;

import Modelo.Bitacora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
  public void insertarBitacora(Bitacora pBitacora){
    try{

      Connection con = conexion.getConexion();

      PreparedStatement ps = con.prepareStatement("INSERT INTO Bitacora "
              + "(Fecha, Hora, idUsuario, nuevoEstado) VALUES (?,?,?,?)");
      ps.setDate(1, pBitacora.getFecha());
      Time hora = Time.valueOf(pBitacora.getHora());
      ps.setTime(2, hora);
      ps.setString(3, pBitacora.getNombreUsuario());
      ps.setString(4, pBitacora.getEstado());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Registro de Bitacora completado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
  
  public int consultarIDBitacoraReciente(){
    PreparedStatement ps;
    ResultSet rs;

    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT IdBitacora FROM Bitacora ORDER BY (IdBitacora) DESC");
      rs = ps.executeQuery();
      rs.next();
      return rs.getInt(1);
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return 0;
    }
  }
}