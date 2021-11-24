package DAO;

import Modelo.RegistroSeguimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase para conectar con la tabla RegistroSeguimiento
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (22/11/2021)
 */
public class RegistroSeguimientoBD {
  private Conexion conexion= new Conexion();
  private RegistroSeguimiento registro;

  public void insertarPaciente(RegistroSeguimiento pRegistroSeguimiento){
    try{
      Connection con = conexion.getConexion();

      PreparedStatement ps = con.prepareStatement("INSERT INTO RegistroSeguimiento "
              + "(fecha, observacion) VALUES (?,?)");
      ps.setDate(1, pRegistroSeguimiento.getFehca());
      ps.setString(2, pRegistroSeguimiento.getObservacion());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Registro de Seguimiento completado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
}