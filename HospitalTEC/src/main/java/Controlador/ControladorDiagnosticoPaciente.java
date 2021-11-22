/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import DAO.*;
import Vista.*;
import Modelo.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author LUIS LEITON
 */
public class ControladorDiagnosticoPaciente implements ActionListener {
  public RegistrarDiagnosticoPaciente vistaDiagnosticoPaciente;
  public String usuario;
  public String paciente;
    
  public ControladorDiagnosticoPaciente(RegistrarDiagnosticoPaciente pVista, String pUsuario, String pPaciente){
    
    vistaDiagnosticoPaciente = pVista;
    usuario = pUsuario;
    paciente = pPaciente;
    
    this.vistaDiagnosticoPaciente.btnRegistrarDiagnostico.addActionListener(this);
    this.vistaDiagnosticoPaciente.btnVolver.addActionListener(this);
    
  }
    
     @Override
     public void actionPerformed(ActionEvent e){
       switch(e.getActionCommand()){
        case "Registrar":
          registrarDiagnosticoCita();
          break;
        case "Volver":
            AtenderCita AC = new AtenderCita();
            ControladorAtenderCita CAC = new ControladorAtenderCita(AC,usuario);
            CAC.vistaAtenderCita.setVisible(true);
            vistaDiagnosticoPaciente.dispose();
            break;
        default:
            break;       
    }
  }
     
  public void registrarDiagnosticoCita(){
    String diagnostico = (String) vistaDiagnosticoPaciente.cbDiagnosticoPaciente.getSelectedItem();
    String nivel = (String) vistaDiagnosticoPaciente.cbNivel.getSelectedItem();
    String tratamiento = (String) vistaDiagnosticoPaciente.cbTratamiento.getSelectedItem();
    String tipo = (String) vistaDiagnosticoPaciente.cbTipo.getSelectedItem();
      
    String observaciones = vistaDiagnosticoPaciente.tbObservacion.getText();
    String dosis = vistaDiagnosticoPaciente.tbDosis.getText();
    
//    Paciente paciente = new Paciente( fecha, tipoSangre, nacionalidad,  
//            provincia,  canton, distrito,  telefono,  cedula, contrasena, 
//            nombre,  apellido1, apellido2);
//    pacienteBD.insertarPaciente(paciente);
    JOptionPane.showMessageDialog(vistaDiagnosticoPaciente, "REGISTRADO");    
  }
}
