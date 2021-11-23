
package DAO;

import Modelo.Cita;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import javax.swing.JOptionPane;

/**
 * Clase para conectar con la tabla Cita
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class CitaBD {
  private Conexion conexion= new Conexion();
  private Cita cita;
  
  /**
   * Método para insertar una Cita en la base de datos
   * @param pCita de tipo Cita
   */
  public void insertarCita(Cita pCita){
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("INSERT INTO Cita "
              + "(fecha, hora, observaciones, estado, especialidad) "
              + "VALUES (?,?,?,?,?)");
      ps.setDate(1, pCita.getFecha()); /*Este se dividio en fecha y hora*/
      Time hora = Time.valueOf(pCita.getHora());
      ps.setTime(2, hora); /*Habría que buscar la posibilidad de generar un time*/
      ps.setString(3, pCita.getObservaciones());
      ps.setString(4, pCita.getEstado().toString()); /*Hay un objeto de tipo estado pero habría que pasarlo a String*/
      ps.setString(5, pCita.getEspecialidad());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Registro de Cita completado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
  
  /**
   * Método para actualizar una Cita en la base de datos
   * @param pIdCita de tipo Cita
   * @param pEstado que especifica el nuevo estado de la cita
   */
  public void actualizarCita(int pIdCita, String pEstado){ //REVISAR NO SE HAN HECHO UPDATES HASTA EL MOMENTO.
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("UPDATE Cita SET"
              + "estado = " + pEstado + "WHERE IdCita = " + pIdCita);
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Actualizacion de cita completado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
  
  /**
   * Método para verificar si existe un usuario en la base de datos
   * @param pCedula número de cédula del paciente.
   * @return Un set de resultados con todas citas del paciente en cuestión.
   */
  public ResultSet citasAsociadas(String pCedula){
    ResultSet rs;
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("SELECT fecha, hora, "
              + "observaciones, estado, especialidad FROM Cita JOIN "
              + "Paciente_Cita ON Cita.IdCita = Paciente_Cita.IdCita "
              + "WHERE idPaciente = '" + pCedula + "'");
      rs = ps.executeQuery();
      rs.next();
      return rs; //Suponiendo que estos dados serán retornados para cargar en una tabla.
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  }
  
  /**
     * Método para consultar las cédulas de pacientes con citas registradas
     * @return un ResultSet con la información de las cedulas en la base de datos
     */
    public ResultSet consultarIdCitasRegistradas(String idPaciente){
      PreparedStatement ps;
      ResultSet rs;

      try{
        Connection con = conexion.getConexion();
        ps = con.prepareStatement("SELECT Cita.IdCita FROM Cita, Paciente_Cita "
              + "WHERE Cita.IdCita = Paciente_Cita.IdCita AND estado = "
              + "'REGISTRADA' AND Paciente_Cita.idPaciente = '" + idPaciente 
              + "' ORDER BY (IdCita)");
        rs = ps.executeQuery();
        return rs;
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
        return null;
      }
    }
}
