
package DAO;

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
  private final Conexion conexion = new Conexion();

/**
   * Método para verificar si existe un usuario en la base de datos
   * @param id la cedula del usuario
   * @return un boolean, retorna false si no existe true en caso contrario.
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
  
  /**
   * Método para verificar si existe un usuario en la base de datos
   * @param id la cedula del usuario
   * @param contrasena la contrasena designada para este usuario
   * @return un boolean, retorna false si no existe true en caso contrario.
   */
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
  
  /**
   * Método para verificar si existe un usuario en la base de datos
   * @param id la cedula del usuario
   * @param contrasena la contrasena designada para este usuario
   * @return un int correspondiente al tipo de usuario de la base de datos.
   */
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
  
  /**
   * Método para verificar si existe un usuario en la base de datos
   * @param id la cedula del usuario
   * @param contrasena la contrasena designada para este usuario
   * @return un int correspondiente al tipo de usuario de la base de datos.
   */
  public int retonarTipo(String id){
    ResultSet rs;
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("SELECT TipoUsuario FROM "
              + "Usuario WHERE Usuario.idUsuario = '" + id + "'");
      rs = ps.executeQuery();
      rs.next();
      return rs.getInt(1);
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return -1;
    }
  }
  
  /**
   * Método para insertar un usuario en la base de datos
   * @param pUsuario de tipo Usuario
   */
  public void insertarUsuario(Usuario pUsuario){
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("INSERT INTO Usuario "
              + "(idUsuario, Nombre, Apellido1, Apellido2, Contrasena, "
              + "TipoUsuario) VALUES (?,?,?,?,?,?)");
      ps.setString(1, pUsuario.getId());
      ps.setString(2, pUsuario.getNombre());
      ps.setString(3, pUsuario.getApellido1());
      ps.setString(4, pUsuario.getApellido2());
      ps.setString(5, pUsuario.getContrasena());
      ps.setInt(6, 1);
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Registro de usuario completado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
}
