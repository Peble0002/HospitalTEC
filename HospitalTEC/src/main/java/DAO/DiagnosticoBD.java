
package DAO;

import Modelo.CatalogoDiagnostico;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase para conectar con la tabla Diagnostico
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class DiagnosticoBD {
  private Conexion conexion= new Conexion();
  private CatalogoDiagnostico diagnostico;
  
  /**
   * Método para insertar un diagnostico en la base de datos
   * @param pDiagnostico de tipo Diagnostico
   */
  public void insertarDiagnostico(String pNombre){
    try{   
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("INSERT INTO CatalogoDiagnosticos "
              + "(NombreDiagnostico) VALUES (?)");
      ps.setString(1, pNombre);
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Registro de diagnostico completado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
    //usuarioBD.insertarUsuario(paciente);
  }
  
  /*
   * Método para consultar nombre de los diagnosticos
   * @return un ResultSet con la información de las vacunas en la base de datos
   */
  public ResultSet consultarDiagnosticos(){
    PreparedStatement ps;
    ResultSet rs;

    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT IdDiagnostico, NombreDiagnostico FROM "
              + "CatalogoDiagnosticos");
      rs = ps.executeQuery();
      return rs;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  }
  
  
  public ResultSet consultarDiagnosticoPaciente(String cedula, Date inicio, Date fin, String nivel, String nombre){ 
    PreparedStatement ps;
    ResultSet rs;
    
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT CatalogoDiagnosticos.IdDiagnostico, CatalogoDiagnosticos.NombreDiagnostico \n" +
      "FROM Cita INNER JOIN Paciente_Cita ON Cita.IdCita = Paciente_Cita.IdCita \n" +
      "INNER JOIN Cita_Diagnostico ON Cita.IdCita = Cita_Diagnostico.IdCita\n" +
      "INNER JOIN CatalogoDiagnosticos ON Cita_Diagnostico.IdDiagnostico = CatalogoDiagnosticos.IdDiagnostico\n" +
      "WHERE idPaciente = '"+cedula+"'\n" +
      "---FILTROS\n" +
      "AND fecha >= '"+inicio+"'\n" +
      "AND fecha <= '"+fin+"'\n" +
      "AND Nivel = '"+nivel+"' \n" +
      "AND NombreDiagnostico LIKE '%"+nombre+"%'");
            rs = ps.executeQuery();
      return rs;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  }  
}
