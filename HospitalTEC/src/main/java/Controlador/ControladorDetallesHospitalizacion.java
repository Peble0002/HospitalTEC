/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.UsuarioBD;
import Vista.DetalleHospitalizacionSistema;
import Vista.VistaDoctor;
import Vista.VistaEnfermero;
import Vista.VistaPaciente;
import Vista.VistaSecretario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class ControladorDetallesHospitalizacion implements ActionListener{
  String usuario;
  DetalleHospitalizacionSistema vistaDetalleHospitalizacionSistema;

  public ControladorDetallesHospitalizacion(String usuario, DetalleHospitalizacionSistema vistaDetalleHospitalizacionSistema) {
    this.usuario = usuario;
    this.vistaDetalleHospitalizacionSistema = vistaDetalleHospitalizacionSistema;
    
    this.vistaDetalleHospitalizacionSistema.btnBuscar.addActionListener(this);
    this.vistaDetalleHospitalizacionSistema.btnVolver.addActionListener(this);
  }
  
  @Override
  public void actionPerformed(ActionEvent e){
    switch(e.getActionCommand()){
      case "Buscar":
         //FUNCION
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
          vistaDetalleHospitalizacionSistema.dispose();
          break;
        case 4:
          VistaDoctor VD = new VistaDoctor();
          ControladorVistaDoctor CVD = new ControladorVistaDoctor(VD,usuario);
          CVD.vistaDoctor.setVisible(true);
          vistaDetalleHospitalizacionSistema.dispose();
          break;
        default:
          JOptionPane.showMessageDialog(vistaDetalleHospitalizacionSistema, "Ha ocurrido algo, por favor intent"
                  + "elo a iniciar sesión nuevamente.");
          break;
    }
  }
  
  
  
  
}
