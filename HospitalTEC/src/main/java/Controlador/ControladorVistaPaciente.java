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
            SolicitarCita SC = new SolicitarCita();
            ControladorSolicitarCita controladorSolicitud = new ControladorSolicitarCita(SC, this.usuario);
            controladorSolicitud.vistaSolicitarCita.setVisible(true);
            vistaPacientes.dispose();
            break;
          case "Cancelar Cita":
            CancelarCita CC = new CancelarCita();
            ControladorCancelarCita controladorCancelar = new ControladorCancelarCita(CC, this.usuario);
            controladorCancelar.vistaCanceltarCita.setVisible(true);
            vistaPacientes.dispose();
            break;
          case "Citas asociadas":
             CitasAsociadasPaciente CAP = new CitasAsociadasPaciente();
             ControladorCitasPaciente controladorCitasPaciente = new ControladorCitasPaciente(usuario, CAP);
             controladorCitasPaciente.vistaCitasAsociadasPaciente.setVisible(true);
             vistaPacientes.dispose();
            break;
          case "Diagnósticos":
            DiagnosticosAsociadosPaciente DAP = new DiagnosticosAsociadosPaciente();
            ControladorDiagnosticoPaciente controladorDiagnosticoPaciente = new ControladorDiagnosticoPaciente(usuario, DAP); 
            controladorDiagnosticoPaciente.vistaDiagnosticosAsociadosPaciente.setVisible(true);
            vistaPacientes.dispose();
            break;
          case "Tratamientos":
            TratamientosAsociadosPaciente TAP = new TratamientosAsociadosPaciente();
            ControladorTratamientosPaciente controladorTratamientosPaciente = new ControladorTratamientosPaciente(usuario, TAP);
            controladorTratamientosPaciente.vistaTratamientosSistema.setVisible(true);
            vistaPacientes.dispose(); 
            break;
          case "Hospitalizaciones":
            HospitalizacionesAsociadasPaciente HAP = new HospitalizacionesAsociadasPaciente();
            ControladorHospitalizacionesPaciente controladorHospitalizacionesPaciente = new ControladorHospitalizacionesPaciente(HAP, usuario);
            controladorHospitalizacionesPaciente.vistahospitalizacionesSistema.setVisible(true);
            vistaPacientes.dispose();
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
