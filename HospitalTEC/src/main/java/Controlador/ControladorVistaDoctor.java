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
public class ControladorVistaDoctor implements ActionListener {
  public VistaDoctor vistaDoctor;
  public String usuario;
  
    
  public ControladorVistaDoctor(VistaDoctor pVista, String pUsuario){
    
    vistaDoctor = pVista;
    usuario = pUsuario;
    
    this.vistaDoctor.btnAsignarCita.addActionListener(this);
    this.vistaDoctor.btnCancelarCita.addActionListener(this);
    this.vistaDoctor.btnCitasRegistradas.addActionListener(this);
    this.vistaDoctor.btnAtenderCita.addActionListener(this);
    this.vistaDoctor.btnTratamientos.addActionListener(this);
    this.vistaDoctor.btnVolver.addActionListener(this);
    this.vistaDoctor.btnDiagnosticos.addActionListener(this);
    this.vistaDoctor.btnRDiagnosticos.addActionListener(this);
    this.vistaDoctor.btnCantidadTratamientos.addActionListener(this);
    this.vistaDoctor.btnSeguimientoInternado.addActionListener(this);
    this.vistaDoctor.btnDetalleHospitalizaciones.addActionListener(this);
    this.vistaDoctor.btnCantidadCitas.addActionListener(this);
    this.vistaDoctor.btnCantidadDiagnosticos.addActionListener(this);
      
  }
    
     @Override
     public void actionPerformed(ActionEvent e){
       switch(e.getActionCommand()){
        case "Asignar cita":
          AsignarCita ACP = new AsignarCita();
          ControladorAsignarCita controladorAsignar = new ControladorAsignarCita(ACP, this.usuario);
          controladorAsignar.vistaAsignarCita.setVisible(true);
          break;
        case "Detalle hospitalizaciones":
          DetalleHospitalizacionSistema DHS = new DetalleHospitalizacionSistema();
          ControladorDetallesHospitalizacion vistaDetalleHospitalizacionSistema = new ControladorDetallesHospitalizacion(usuario, DHS);
          vistaDetalleHospitalizacionSistema.vistaDetalleHospitalizacionSistema.setVisible(true);
          vistaDoctor.dispose();
          break;
        case "Cancelar cita":
          CancelarCita CC = new CancelarCita();
          ControladorCancelarCita controladorCancelar = new ControladorCancelarCita(CC, this.usuario);
          controladorCancelar.vistaCanceltarCita.setVisible(true);
          vistaDoctor.dispose();
          break;
        case "Citas registradas":
          CitasSistema CS = new CitasSistema();
          ControladorCitasRegistradas CCR = new ControladorCitasRegistradas(usuario, CS);
          CCR.vistaCitas.setVisible(true);
          vistaDoctor.dispose(); 
          break;
        case "Atender cita":
          AtenderCita AC = new AtenderCita();
          ControladorAtenderCita CAC = new ControladorAtenderCita(AC,usuario);
          CAC.vistaAtenderCita.setVisible(true);
          vistaDoctor.dispose();
          break;
        case "Diagnósticos":
          DiagnosticosSistema DS = new DiagnosticosSistema();
          ControladorDiagnostico controladorDiagnostico = new ControladorDiagnostico(usuario, DS);
          controladorDiagnostico.vistaDiagnosticosSistema.setVisible(true);
          vistaDoctor.dispose();
          break;
        case "Tratamientos":
          TratamientosSistema TS = new TratamientosSistema();
          ControladorTratamientos controladorTratamientos = new ControladorTratamientos(usuario, TS);
          controladorTratamientos.vistaTratamientosSistema.setVisible(true);
          vistaDoctor.dispose();
          break;
        case "Cantidad de citas":
          CantCitasRegistradas CCC = new CantCitasRegistradas();
          ControladorCantCitasRegistradas controladorCantCitas = new ControladorCantCitasRegistradas(CCC,usuario);
          controladorCantCitas.vistaCantCitas.setVisible(true);
          vistaDoctor.dispose();
          break;
        case "Cantidad de diagnósticos":
          CantDiagnosticos CCD = new CantDiagnosticos();
          ControladorCantDiagnosticos cantDiagnosticos = new ControladorCantDiagnosticos(CCD,usuario);
          cantDiagnosticos.vistaCantDiagnosticos.setVisible(true);
          vistaDoctor.dispose();
          break;
        case "Cantidad de tratamientos":
          CantTratamientos CT = new CantTratamientos();
          ControladorCantTratamientos cantTratamientos = new ControladorCantTratamientos(CT,usuario);
          cantTratamientos.vistaCantTratamientos.setVisible(true);
          vistaDoctor.dispose();
          break;
        case "Seguimiento Internado":
          RegistroSeguimientoInternado RSI = new RegistroSeguimientoInternado();
          ControladorSeguimientoInternado controladorSeguimientoInternado = new ControladorSeguimientoInternado(usuario, RSI);
          controladorSeguimientoInternado.vistaRegistroSeguimientoInternado.setVisible(true);
          vistaDoctor.dispose();
          break;
        case "Registrar Diágnosticos":
          RegistrarCatalogoDiagnosticos RCD = new RegistrarCatalogoDiagnosticos();
          ControladorRegistrarDiagnostico controladorRegistrarDiagnostico = new ControladorRegistrarDiagnostico(usuario, RCD);
          controladorRegistrarDiagnostico.vistaRegistrarCatalogoDiagnosticos.setVisible(true);
          vistaDoctor.dispose();
          break;
        case "Volver":
            Principal P = new Principal();
            InicioSesion IS = new InicioSesion(P);
            IS.vistaInicio.setVisible(true);
            vistaDoctor.dispose();
            break;
        default:
            break;       
    }
  }
    
}
