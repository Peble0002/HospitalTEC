/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.HospitalizacionesSistema;
import Vista.VistaPaciente;
import Vista.VistaSecretario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author pablo
 */
public class ControladorHospitalizacionesRegistradas implements ActionListener {
  public HospitalizacionesSistema vistahospitalizacionesSistema;
  String usuario;

  public ControladorHospitalizacionesRegistradas(HospitalizacionesSistema hospitalizacionesSistema, String usuario) {
    this.vistahospitalizacionesSistema = hospitalizacionesSistema;
    this.usuario = usuario;
    
    this.vistahospitalizacionesSistema.btnBuscar.addActionListener(this);
    this.vistahospitalizacionesSistema.btnVolver.addActionListener(this);
  }
  
  @Override
  public void actionPerformed(ActionEvent e){
    switch(e.getActionCommand()){
      case "Buscar":
         //FUNCION
      case "Volver":
          VistaSecretario VS = new VistaSecretario();
          ControladorVistaSecretario CVS = new ControladorVistaSecretario(VS,usuario);
          CVS.vistaSecretario.setVisible(true);
          vistahospitalizacionesSistema.dispose();
          break;
      default:
        break;       
    }
  }
  
}
