package DAO;

import Modelo.Internado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase para conectar con la tabla Internado
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (21/11/2021)
 */
public class InternadoBD {
  private Conexion conexion= new Conexion();
  private Internado internado;

  public void insertarInternado(Internado pInternado){

    try{
      Connection con = conexion.getConexion();

      PreparedStatement ps = con.prepareStatement("INSERT INTO Internado "
              + "(idInternado, fechaInicio, fechaFin, "
              + "codigoAreaTrabajo) VALUES (?,?,?,?)");
      ps.setString(1, pInternado.getPacienteInternado().getId());
      ps.setDate(2, pInternado.getFechaInicio());
      ps.setDate(3, pInternado.getFechaFin());
      ps.setString(4, pInternado.getArea().getAreaTrabajo().toString());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Registro de Internado completado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
}