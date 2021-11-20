
package Controlador;

import Modelo.Paciente;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase para conectar con la tabla Paciente
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class PacienteBD {
  private Conexion conexion= new Conexion();
  private Paciente paciente;
  
  /**
   * Método para insertar un paciente en la base de datos
   * @param pPaciente de tipo Usuario
   */
  
  public void insertarPaciente(Paciente pPaciente){
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("INSERT INTO Paciente "
              + "(idPaciente, nacionalidad, tipoSangre, fechaNacimiento, "
              + "provincia, canton) VALUES (?,?,?,?,?,?)");
      ps.setString(1, pPaciente.getId());
      ps.setString(2, pPaciente.getNacionalidad());
      ps.setString(3, pPaciente.getTipoSangre());
      Date fecha = Date.valueOf(pPaciente.getFechaNacimiento());
      ps.setDate(4, fecha); /*Hay que usarlos en Date*/
      ps.setString(5, pPaciente.getProvincia());
      ps.setString(6, pPaciente.getCanton());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Registro de usuario completado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
}
