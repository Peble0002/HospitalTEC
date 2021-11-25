/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.event.ActionListener;
import DAO.*;
import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
/**
 *
 * @author LUIS LEITON
 */
public class ControladorCantDiagnosticos implements ActionListener {
  public CantDiagnosticos vistaCantDiagnosticos;
  public String usuario;
  
  public ControladorCantDiagnosticos(CantDiagnosticos vistaCantDiagnosticos, String pUsuario) {
    this.vistaCantDiagnosticos = vistaCantDiagnosticos;
    usuario = pUsuario;
    cargarComboBoxAreaTrabajo();
    cargarComboBoxPacientes();
    this.vistaCantDiagnosticos.btnBuscar.addActionListener(this);
    this.vistaCantDiagnosticos.btnVolver.addActionListener(this);
   
  }
  
  @Override
   public void actionPerformed(ActionEvent e){
     switch(e.getActionCommand()){
      case "Buscar":
        try{
          cargarResultado();
          break;
        }catch (SQLException o){ 
          JOptionPane.showMessageDialog(null, o.toString()); 
          break;
        }
      case "Volver":
          asignarVentanaUsuario();
          vistaCantDiagnosticos.dispose();
          break;
      default:
          break;       
  }
}
   
  public String cargarQuery(String nivel, String paciente, String area){
    String consulta = "SELECT COUNT(CatalogoDiagnosticos.IdDiagnostico) AS "
            + "TotalDiagnosticos FROM CatalogoDiagnosticos INNER JOIN "
            + "Cita_Diagnostico ON CatalogoDiagnosticos.IdDiagnostico = "
            + "Cita_Diagnostico.IdDiagnostico INNER JOIN Cita ON "
            + "Cita_Diagnostico.IdCita = Cita.IdCita INNER JOIN Paciente_Cita "
            + "ON Paciente_Cita.IdCita = Cita.IdCita WHERE "
            + "CatalogoDiagnosticos.IdDiagnostico = "
            + "Cita_Diagnostico.IdDiagnostico";
    if(!nivel.equals("-")){
      consulta += " AND Nivel = '" + nivel + "'";
    }if(!paciente.equals("-")){
      consulta += " AND idPaciente = '" + paciente + "'";
    }if(!area.equals("-")){
      consulta += " AND Cita.especialidad = '" + area + "'";
    }
    
    return consulta;
  }
   
  public String cargarQueryGeneral(){
    String consulta = "SELECT COUNT(IdDiagnostico) AS TotalDiagnosticos	FROM CatalogoDiagnosticos";
    return consulta;
  }
  
  private void cargarResultado() throws SQLException{
    String nivel = (String) vistaCantDiagnosticos.cbNivel.getSelectedItem();
    String paciente = (String) vistaCantDiagnosticos.cbPacientes.getSelectedItem();
    String area = (String) vistaCantDiagnosticos.cbAreaCita.getSelectedItem();
    String consulta;
    
    if(nivel.equals("-") && area.equals("-") && paciente.equals("-")){
      consulta = cargarQueryGeneral();  
    }else{
      consulta = cargarQuery(nivel, paciente, area);
    }
    Conexion conexion = new Conexion();
    ResultSet rs = conexion.consulta(consulta);
    rs.next();
    int cant = rs.getInt("TotalDiagnosticos");
    String resultado = String.valueOf(cant);
    
    vistaCantDiagnosticos.lbCantidad.setText(resultado);
  }
   
public void asignarVentanaUsuario(){
    UsuarioBD usuarioBD = new UsuarioBD(); 
      int tipoUsuario = usuarioBD.retonarTipo(usuario);
      switch(tipoUsuario){
        case 3:
          VistaEnfermero VE = new VistaEnfermero();
          ControladorVistaEnfermero CVE = new ControladorVistaEnfermero(VE,usuario);
          CVE.vistaEnfermero.setVisible(true);
          vistaCantDiagnosticos.dispose();
          break;
        case 4:
          VistaDoctor VD = new VistaDoctor();
          ControladorVistaDoctor CVD = new ControladorVistaDoctor(VD,usuario);
          CVD.vistaDoctor.setVisible(true);
          vistaCantDiagnosticos.dispose();
          break;
        default:
          JOptionPane.showMessageDialog(vistaCantDiagnosticos, "Ha ocurrido algo, por favor intent"
                  + "elo a iniciar sesión nuevamente.");
          break;
      } 
    }   

private void cargarComboBoxAreaTrabajo(){
      AreaTrabajoBD areaBD = new AreaTrabajoBD();
      ResultSet rs = areaBD.consultarAreasTrabajo();
      vistaCantDiagnosticos.cbAreaCita.addItem("-");

      try{
        while(rs.next()){
          vistaCantDiagnosticos.cbAreaCita.addItem(rs.getString("NombreArea"));
        }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
      }
    }
 
 private void cargarComboBoxPacientes(){
      PacienteBD pacienteBD = new PacienteBD();
      ResultSet rs = pacienteBD.consultarPacientes();
      vistaCantDiagnosticos.cbPacientes.addItem("-");

      try{
        while(rs.next()){
          vistaCantDiagnosticos.cbPacientes.addItem(rs.getString("idPaciente"));
        }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
      }
    }
}
