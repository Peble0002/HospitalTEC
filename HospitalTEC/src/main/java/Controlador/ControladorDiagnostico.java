/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.UsuarioBD;
import Vista.DiagnosticosSistema;
import Vista.VistaDoctor;
import Vista.VistaEnfermero;
import Vista.VistaSecretario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class ControladorDiagnostico implements ActionListener{
  String usuario;
  DiagnosticosSistema vistaDiagnosticosSistema;

  public ControladorDiagnostico(String usuario, DiagnosticosSistema vistaDiagnosticosSistema) {
    this.usuario = usuario;
    this.vistaDiagnosticosSistema = vistaDiagnosticosSistema;
    
    this.vistaDiagnosticosSistema.btnBuscar.addActionListener(this);
    this.vistaDiagnosticosSistema.btnVolver.addActionListener(this);
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
        case 1:
          VistaEnfermero VE = new VistaEnfermero();
          ControladorVistaEnfermero CVE = new ControladorVistaEnfermero(VE,usuario);
          CVE.vistaEnfermero.setVisible(true);
          vistaDiagnosticosSistema.dispose();
          break;
        case 3:
          VistaDoctor VD = new VistaDoctor();
          ControladorVistaDoctor CVD = new ControladorVistaDoctor(VD,usuario);
          CVD.vistaDoctor.setVisible(true);
          vistaDiagnosticosSistema.dispose();
          break;
        default:
          JOptionPane.showMessageDialog(vistaDiagnosticosSistema, "Ha ocurrido algo,"
                  + " por favor intent"
                  + "elo a iniciar sesión nuevamente.");
          break;
    }
  }
  
  
  
}
