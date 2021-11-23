
package DAO;

import Modelo.Funcionario;
import Modelo.TipoFuncionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase para conectar con la tabla Funcionario
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class FuncionarioBD {
  private Conexion conexion= new Conexion();
  private Funcionario funcionario;
  
  
  public void insertarFuncionario(Funcionario pFuncionario) throws SQLException{
    UsuarioBD usuarioBD = new UsuarioBD();  
    try{
        
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("INSERT INTO Funcionario "
              + "(IDFuncionario, TipoFuncionario, fechaIngreso VALUES (?,?,?,?,?,?)");
      ps.setString(1, pFuncionario.getId());
      TipoFuncionario tipo =pFuncionario.getTipo();
      switch(tipo){
      case Doctor:
        ps.setString(2,"4");
        break;
      case Enfermero:
        ps.setString(2,"3");
        break;
      case Secretario: 
        ps.setString(2,"2");
        break;
      }
      ps.setString(3, pFuncionario.getFechaIngreso().toString());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Registro de Funcionario completado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
    usuarioBD.insertarUsuario(pFuncionario);
  }
}


/**
 * 1 Paciente
 * 2 Secretario
 * 3 Enfermero
 * 4 Doctor
 */