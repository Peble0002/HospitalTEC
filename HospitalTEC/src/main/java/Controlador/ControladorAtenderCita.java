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
public class ControladorAtenderCita implements ActionListener {
  public AtenderCita vistaAtenderCita;
  public String usuario;
  public String paciente;
    
  public ControladorAtenderCita(AtenderCita pVista, String pUsuario){
    
    vistaAtenderCita = pVista;
    usuario = pUsuario;
    paciente = (String) vistaAtenderCita.cbCedulasPacientes.getSelectedItem();
    
    this.vistaAtenderCita.btnInternar.addActionListener(this);
    this.vistaAtenderCita.btnRegistrarBitacora.addActionListener(this);
    this.vistaAtenderCita.btnRegistrarDiagnostico.addActionListener(this);
    this.vistaAtenderCita.btnVolver.addActionListener(this);
    
  }
    
     @Override
     public void actionPerformed(ActionEvent e){
       switch(e.getActionCommand()){
        case "Registrar Diagnóstico":
          RegistrarDiagnosticoPaciente RDP = new RegistrarDiagnosticoPaciente();
          ControladorDiagnosticoPaciente CDP = new ControladorDiagnosticoPaciente(RDP,usuario,paciente);
          CDP.vistaDiagnosticoPaciente.setVisible(true);
          vistaAtenderCita.dispose();
          break;
        case "Registrar Bitácora": //FALTA
          VistaDoctor VD = new VistaDoctor();
          ControladorVistaDoctor CVD = new ControladorVistaDoctor(VD,usuario);
          CVD.vistaDoctor.setVisible(true);
          vistaAtenderCita.dispose();
          break;
        case "Internar Paciente": // FALTA
          VistaDoctor VD = new VistaDoctor();
          ControladorVistaDoctor CVD = new ControladorVistaDoctor(VD,usuario);
          CVD.vistaDoctor.setVisible(true);
          vistaAtenderCita.dispose();
          break;
        case "Volver":
            VistaDoctor VD = new VistaDoctor();
            ControladorVistaDoctor CVD = new ControladorVistaDoctor(VD,usuario);
            CVD.vistaDoctor.setVisible(true);
            vistaAtenderCita.dispose();
            break;
        default:
            break;       
    }
  }
}
