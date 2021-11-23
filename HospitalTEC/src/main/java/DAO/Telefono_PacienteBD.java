
package DAO;

import Modelo.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Clase para conectar con la tabla Telefono_Paciente
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class Telefono_PacienteBD {
  private Conexion conexion= new Conexion();
  private Paciente paciente;
  private ArrayList<String> telefonos= new ArrayList<String>();
  
  /**
   * Método para insertar un telefono de un paciente en la base de datos
   * @param idPaciente de tipo String
   * @param telefono de tipo String
   */
  public void insertarPacienteTelefono(String idPaciente, String telefono){
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("INSERT INTO Telefono_Paciente"
              + "(idPaciente, telefono) VALUES (?,?)");
      ps.setString(1, idPaciente);
      ps.setString(2, telefono);
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Registro de telefonos completados.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
}
