
package DAO;

import Modelo.Diagnostico;
import Modelo.Tratamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase para conectar con la tabla Tratamiento_Diagnostico
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class Tratamiento_DiagnosticoBD {
  private Conexion conexion= new Conexion();
  private Tratamiento tratamiento;
  private Diagnostico diagnostico;
  
  /*
   * Método para consultar nombre de los diagnosticos
   * @return un ResultSet con la información de las vacunas en la base de datos
   */
  public ResultSet consultarTratamientosDiagnostico(int idDiagnostico){
    PreparedStatement ps;
    ResultSet rs;

    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT IdTratamiento, Nombre FROM "
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
}
