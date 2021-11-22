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
public class ControladorVistaEnfermero implements ActionListener{
  public VistaEnfermero vistaEnfermero;
  public String usuario;
    
  public ControladorVistaEnfermero(VistaEnfermero pVista, String pUsuario){
    
    vistaEnfermero = pVista;
    usuario = pUsuario;
    
    this.vistaEnfermero.btnAsignarCita.addActionListener(this);
    this.vistaEnfermero.btnCancelarCita.addActionListener(this);
    this.vistaEnfermero.btnCitasRegistradas.addActionListener(this);
    this.vistaEnfermero.btnTratamientos.addActionListener(this);
    this.vistaEnfermero.btnVolver.addActionListener(this);
    this.vistaEnfermero.btnDiagnosticos.addActionListener(this);
    this.vistaEnfermero.btnCantidadTratamientos.addActionListener(this);
    this.vistaEnfermero.btnDetalleHospitalizaciones.addActionListener(this);
    this.vistaEnfermero.btnCantidadCitas.addActionListener(this);
    this.vistaEnfermero.btnCantidadDiagnosticos.addActionListener(this);
      
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
        case "Volver":
            Principal P = new Principal();
            InicioSesion IS = new InicioSesion(P);
            IS.vistaInicio.setVisible(true);
            vistaEnfermero.dispose();
            break;
        default:
            break;       
    }
  }
}
