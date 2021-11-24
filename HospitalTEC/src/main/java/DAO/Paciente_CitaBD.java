
package DAO;

import Modelo.Cita;
import Modelo.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase para conectar con la tabla Paciente_Cita
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class Paciente_CitaBD {
  private Conexion conexion= new Conexion();
  private Cita cita;
  private Paciente paciente;

  public Paciente_CitaBD() {
  }
  
  public void insertarPaciente_Cita(Cita pCita, String pPaciente){  
    try{
        
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("INSERT INTO Paciente_Cita "
              + "(idPaciente, IdCita ) VALUES (?,?)");
      ps.setString(1, pPaciente);
      ps.setInt(2, pCita.getIdCita());
      ps.executeUpdate();
      //JOptionPane.showMessageDialog(null, "Registro de usuario Cita.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
  
  /*
   * Método para consultar las cédulas de pacientes con citas registradas
   * @return un ResultSet con la información de las cedulas en la base de datos
   */
  public ResultSet consultarCitasRegistradas(){
    PreparedStatement ps;
    ResultSet rs;
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT Cita.IdCita, IdPaciente FROM Cita, "
              + "Paciente_Cita WHERE Cita.IdCita = Paciente_Cita.IdCita AND "
              + "estado = 'Registrada' ORDER BY (IdCita)");
      rs = ps.executeQuery();
      return rs;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  }
  
  public ResultSet consultarCitasRegistradasParaUnUsuario(String cedula){
    PreparedStatement ps;
    ResultSet rs;
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT Cita.IdCita, fecha FROM Cita, "
              + "Paciente_Cita WHERE Cita.IdCita = Paciente_Cita.IdCita "
              + "AND Paciente_Cita.idPaciente = '"+ cedula+ "' ORDER BY (IdCita) DESC");
      rs = ps.executeQuery();
      return rs;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  }
  //Falta los parametros
  public ResultSet consultarCitasPaciente(Date inicio, Date fin, String Area, String estado){ 
    PreparedStatement ps;
    ResultSet rs;
    
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT Cita.IdCita, fecha, hora, observaciones, estado, especialidad, correo \n" +
      "	FROM Cita INNER JOIN Paciente_Cita ON Cita.IdCita = Paciente_Cita.IdCita \n" +
      "		WHERE idPaciente = '305110992'\n" +
      "---FILTROS\n" +
      "AND fecha >= '2021-08-21'\n" +
      "AND fecha <= '2021-08-21'\n" +
      "AND estado = 'Cancelada por paciente' \n" +
      "AND especialidad LIKE '%Medicina general%'");
            rs = ps.executeQuery();
      return rs;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  }
}
