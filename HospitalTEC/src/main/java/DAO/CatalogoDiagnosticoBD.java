
package DAO;

import Modelo.CatalogoDiagnostico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase para conectar con la tabla CatalogoDiagnostico
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class CatalogoDiagnosticoBD {
  private Conexion conexion= new Conexion();
  private CatalogoDiagnostico catalogo;
  
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
  
  public CatalogoDiagnostico consultarDiagnostico(int id){
    PreparedStatement ps;
    ResultSet rs;

    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT NombreDiagnostico FROM "
              + "CatalogoDiagnosticos Where IdDiagnostico= "+id );
      rs = ps.executeQuery();
      rs.next();
      CatalogoDiagnostico catalogoDiagnostico = new CatalogoDiagnostico(id,rs.getString(1) );
      return catalogoDiagnostico;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  }
  
  
}
