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
public class ControladorVistaPaciente implements ActionListener {
    public VistaPaciente vistaPacientes;
    public String usuario;
    
    public ControladorVistaPaciente(VistaPaciente pVista, String pUsuario){
    
      vistaPacientes = pVista;
      usuario = pUsuario;
    
      this.vistaPacientes.btnSolicitarCita.addActionListener(this);
      this.vistaPacientes.btnCancelarCita.addActionListener(this);
      this.vistaPacientes.btnTratamientos.addActionListener(this);
      this.vistaPacientes.btnHospitalizaciones.addActionListener(this);
      this.vistaPacientes.btnVolver.addActionListener(this);
      this.vistaPacientes.btnDiagnosticos.addActionListener(this);
      this.vistaPacientes.btnCitasAsociadas.addActionListener(this);
      
  }
    
     @Override
     public void actionPerformed(ActionEvent e){
       switch(e.getActionCommand()){
          case "Solicitar Cita":
            break;
          case "Cancelar Cita":
            break;
          case "Citas asociadas":
            break;
          case "Diagnósticos":
            break;
          case "Tratamientos":
            break;
          case "Hospitalizaciones":
            break;
            
        case "Volver":
            Principal P = new Principal();
            InicioSesion IS = new InicioSesion(P);
            IS.vistaInicio.setVisible(true);
            vistaPacientes.dispose();
            break;
        default:
            break;       
    }
  }
}
