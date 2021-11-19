
package Controlador;

import Modelo.Usuario;
import Modelo.*;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 * Clase para conectar con la tabla Usuario
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class UsuarioBD {
  private Conexion conexion = new Conexion();
  private Usuario usuario;


/**
   * Método para verificar si existe un usuario en la base de datos
   * @param pCurso de tipo curso
   * @return un boolean, retorna false si no existe
   */
  public boolean existeUsuario(String id){
    ResultSet rs;
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("SELECT * FROM Usuario WHERE "
              + "Usuario.idUsuario = '" + id + "'");
      rs = ps.executeQuery();
      return rs.next();
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return false;
    }
  } 
  
  public boolean validarIngreso(String id, String contrasena){
    ResultSet rs;
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("SELECT * FROM Usuario WHERE "
              + "Usuario.idUsuario = '" + id + "' AND Usuario.Contrasena = '" 
              + contrasena + "'");
      rs = ps.executeQuery();
      return rs.next();
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return false;
    }
  }
  
  public int retonarTipo(String id, String contrasena){
    ResultSet rs;
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("SELECT TipoUsuario FROM "
              + "Usuario WHERE Usuario.idUsuario = '" + id + "' AND "
              + "Usuario.Contrasena = '" + contrasena + "'");
      rs = ps.executeQuery();
      rs.next();
      return rs.getInt(1);
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return -1;
    }
  }
}
