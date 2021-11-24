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
public class ControladorVistaSecretario implements ActionListener{
    public VistaSecretario vistaSecretario;
    public String usuario;
    
    public ControladorVistaSecretario(VistaSecretario pVista, String pUsuario){
    
      vistaSecretario = pVista;
      usuario = pUsuario;
    
      this.vistaSecretario.btnAsignarCita.addActionListener(this);
      this.vistaSecretario.btnCancelarCita.addActionListener(this);
      this.vistaSecretario.btnCitasRegistradas.addActionListener(this);
      this.vistaSecretario.btnHospitalizaciones.addActionListener(this);
      this.vistaSecretario.btnRATrabajo.addActionListener(this);
      this.vistaSecretario.btnVolver.addActionListener(this);
      
  }
    
     @Override
     public void actionPerformed(ActionEvent e){
       switch(e.getActionCommand()){
        case "Asignar cita":
          AsignarCita AC = new AsignarCita();
          ControladorAsignarCita controladorAsignar = new ControladorAsignarCita(AC, this.usuario);
          controladorAsignar.vistaAsignarCita.setVisible(true);
          vistaSecretario.dispose();
          break;
        case "Hospitalizaciones registradas":
          break;
        case "Cancelar cita":
          CancelarCita CC = new CancelarCita();
          ControladorCancelarCita controladorCancelar = new ControladorCancelarCita(CC, this.usuario);
          controladorCancelar.vistaCanceltarCita.setVisible(true);
          vistaSecretario.dispose();
          break;
        case "Citas registradas":
          break;
        case "Volver":
            Principal P = new Principal();
            InicioSesion IS = new InicioSesion(P);
            IS.vistaInicio.setVisible(true);
            vistaSecretario.dispose();
            break;
        default:
            break;       
    }
  }
}
