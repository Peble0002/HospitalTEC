
package DAO;

import Modelo.Paciente;
import Modelo.Usuario;
import Modelo.Vacuna;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 * Clase para conectar con la tabla Paciente_Vacuna
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class Paciente_VacunaBD {
  private Conexion conexion= new Conexion();
  private Paciente paciente;
  private Vacuna vacuna;
  
  /**
   * Método para insertar un usuario en la base de datos
   * @param pUsuario de tipo Usuario
   */
  public void insertarPacienteVacuna(Paciente pPaciente, Vacuna pVacuna){
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("INSERT INTO Paciente_Vacuna "
              + "(idPaciente, idVacuna, fechaAplicacion, lote) "
              + "VALUES (?,?,?,?)");
      ps.setString(1, pPaciente.getId());
      ps.setInt(2, pVacuna.getID());
      ps.setDate(3, pVacuna.getFechaAplicacion()); /*Revisar, misma situación de la fecha.*/
      ps.setString(4, pVacuna.getNumeroLote());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Registro de paciente vacuna completado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
}
