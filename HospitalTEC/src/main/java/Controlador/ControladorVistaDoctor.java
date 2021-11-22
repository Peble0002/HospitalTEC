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
          break;
        case "Detalle hospitalizaciones":
          break;
        case "Cancelar cita":
          break;
        case "Citas registradas":
          break;
        case "Atender cita": //FALTA
          break;
        case "Diagnósticos":
          break;
        case "Tratamientos":
          break;
        case "Cantidad de citas":
          break;
        case "Cantidad de diagnósticos":
          break;
        case "Cantidad de tratamientos":
          break;
        case "Seguimiento Internado":
          break;
        case "Registrar Diágnosticos":
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
