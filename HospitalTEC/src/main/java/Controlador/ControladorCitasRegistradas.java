/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.UsuarioBD;
import Vista.CitasSistema;
import Vista.VistaDoctor;
import Vista.VistaEnfermero;
import Vista.VistaPaciente;
import Vista.VistaSecretario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class ControladorCitasRegistradas implements ActionListener{
  String usuario;
  public CitasSistema vistaCitas;

  public ControladorCitasRegistradas(String usuario, CitasSistema vistaCitas) {
    this.usuario = usuario;
    this.vistaCitas = vistaCitas;
    
    this.vistaCitas.btnBuscar.addActionListener(this);
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
          VistaSecretario VS = new VistaSecretario();
          ControladorVistaSecretario CVS = new ControladorVistaSecretario(VS,usuario);
          CVS.vistaSecretario.setVisible(true);
          vistaCitas.dispose();
          break;
        case 2:
          VistaEnfermero VE = new VistaEnfermero();
          ControladorVistaEnfermero CVE = new ControladorVistaEnfermero(VE,usuario);
          CVE.vistaEnfermero.setVisible(true);
          vistaCitas.dispose();
          break;
        case 3:
          VistaDoctor VD = new VistaDoctor();
          ControladorVistaDoctor CVD = new ControladorVistaDoctor(VD,usuario);
          CVD.vistaDoctor.setVisible(true);
          vistaCitas.dispose();
          break;
        default:
          JOptionPane.showMessageDialog(vistaCitas, "Ha ocurrido algo, por favor intent"
                  + "elo a iniciar sesión nuevamente.");
          break;
    }
  }
  
  
  
}
