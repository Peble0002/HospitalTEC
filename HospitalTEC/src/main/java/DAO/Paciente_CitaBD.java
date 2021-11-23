
package DAO;

import Modelo.Cita;
import Modelo.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

  public Paciente_CitaBD(Cita cita, Paciente paciente) {
    this.cita = cita;
    this.paciente = paciente;
  }
  
  
  public void insertarPaciente_Cita(Cita pCita,Paciente pPaciente ){
    
    try{
        
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("INSERT INTO Paciente_Cita "
              + "(idPaciente ) VALUES (?,?)");
      ps.setString(1, pPaciente.getId());
      ps.setString(2, pCita.getIdCita());
      ps.executeUpdate();
      //JOptionPane.showMessageDialog(null, "Registro de usuario Cita.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
}
