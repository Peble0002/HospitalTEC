/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Abstracción de la clase Conexion
 * @author Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (06/11/2021)
 */
public class Conexion {
  Connection conectar = null;
  String usuario = "admin";
  String contrasena = "sql123";
  String cadenaBase = "jdbc:sqlserver://localhost:1433/HospitalTEC";
  
  /**
   * Método constructor conexion
   */
  public Conexion(){
  }
  
  /**
   * Método para obtener la conexión con la base de datos
   * @return el driver con la conexión a la base de datos
   */
  public Connection getConexion(){
    String conexionUrl = "jdbc:sqlserver://localhost:1433;databaseName=HospitalTEC";
    
    try{
      conectar = DriverManager.getConnection(conexionUrl, usuario, contrasena);
      System.out.println("Conectado");
      return conectar;
    }catch(SQLException e){
      System.out.println("Error detectado.");
      System.out.println(e.toString());
      return null;
    }
  }
}
