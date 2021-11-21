
package DAO;

import Modelo.CatalogoDiagnostico;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
  public void insertarDiagnostico(CatalogoDiagnostico pDiagnostico){
    try{   
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("INSERT INTO CatalogoDiagnosticos "
              + "(NombreDiagnostico) VALUES (?)");
      ps.setString(1, pDiagnostico.getNombreDiagnostico());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Registro de diagnostico completado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
    //usuarioBD.insertarUsuario(paciente);
  }
}
