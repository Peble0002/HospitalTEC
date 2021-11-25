
package DAO;

import Modelo.Tratamiento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 * Clase para conectar con la tabla Tratamiento
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class TratamientoBD {
  private Conexion conexion= new Conexion();
  private Tratamiento tratamiento;
  
  /*
   * Método para consultar nombre de los diagnosticos
   * @return un ResultSet con la información de las vacunas en la base de datos
   */
  public ResultSet consultarTratamientosDiagnostico(int idDiagnostico){
    PreparedStatement ps;
    ResultSet rs;

    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT CatalogoTratamientos.IdTratamiento, Nombre FROM "
              + "CatalogoTratamientos, Tratamiento_Diagnostico WHERE "
              + "Tratamiento_Diagnostico.IdDiagnostico = "+ idDiagnostico +" AND"
              + " CatalogoTratamientos.IdTratamiento = Tratamiento_Diagnostico."
              + "IdTratamiento");
      rs = ps.executeQuery();
      return rs;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  }
  
  //Revisar
   public ResultSet consultarTratamientoPaciente(String consulta){ 
    PreparedStatement ps;
    ResultSet rs;
    
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement(consulta);
      rs = ps.executeQuery();
      return rs;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  } 
}
