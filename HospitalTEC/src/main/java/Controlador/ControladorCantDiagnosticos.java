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
        
        break;
      case "Volver":
          asignarVentanaUsuario();
          break;
      default:
          break;       
  }
  
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

      try{
        while(rs.next()){
          vistaCantDiagnosticos.cbPacientes.addItem(rs.getString("idPaciente"));
        }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
      }
    }
}
