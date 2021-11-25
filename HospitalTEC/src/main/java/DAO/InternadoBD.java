package DAO;

import Modelo.Internado;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
  
  public ResultSet consultarTratamientoPaciente(String cedula){ 
    PreparedStatement ps;
    ResultSet rs;
    
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT fechaInicio, fechaFin, nombreCentro, (Nombre + ' ' + Apellido1 + ' ' + Apellido2) AS nombreCompleto \n" +
      "FROM Internado INNER JOIN Internado_Centro ON Internado.codInternado = Internado_Centro.codInternado\n" +
      "INNER JOIN CentroAtencion ON CentroAtencion.Codigo = Internado_Centro.Codigo\n" +
      "INNER JOIN Internado_Doctor ON Internado.codInternado = Internado_Doctor.codInternado\n" +
      "INNER JOIN Usuario ON Internado_Doctor.IDFuncionario = Usuario.idUsuario\n" +
      "WHERE IdInternado = '"+cedula+"'");
            rs = ps.executeQuery();
      return rs;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  } 
}