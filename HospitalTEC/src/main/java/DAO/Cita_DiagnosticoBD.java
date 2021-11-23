
package DAO;

import Modelo.Diagnostico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase para conectar con la tabla Cita_Diagnostico
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class Cita_DiagnosticoBD {
  private Conexion conexion= new Conexion();
  private Diagnostico diagnostico;
  
  /**
   * Método para insertar una Cita en la base de datos
   * @param pDiagnostico de tipo Diagnostico
   * @param idTratamiento de tipo Tratamiento
   * @param idCita de tipo Cita
   * @param pNivel de tipo String
   */
  public void insertarCitaDiagnostico(Diagnostico pDiagnostico, int idTratamiento, int idCita,String pNivel){
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("INSERT INTO Cita_Diagnostico"
              + " (IdCita, IdDiagnostico, IdTratamiento, Dosis, Nivel, Observaciones) "
              + "VALUES (?,?,?,?,?,?)");
      ps.setInt(1, idCita);
      ps.setInt(2, pDiagnostico.getNombreDiagnostico().getIdDiagnostico());
      ps.setInt(3, idTratamiento);
      ps.setString(4, pDiagnostico.getDosis());
      ps.setString(5, pNivel);
      ps.setString(6, pDiagnostico.getObservaciones());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Registro de diagnostico de una cita completado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
}
