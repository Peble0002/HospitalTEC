/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.HospitalizacionesAsociadasPaciente;
import Vista.VistaPaciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author pablo
 */
public class ControladorHospitalizacionesPaciente  implements ActionListener{
  public HospitalizacionesAsociadasPaciente vistahospitalizacionesSistema;
  String usuario;

  public ControladorHospitalizacionesPaciente(HospitalizacionesAsociadasPaciente hospitalizacionesSistema, String usuario) {
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
          VistaPaciente VP = new VistaPaciente();
          ControladorVistaPaciente CVP = new ControladorVistaPaciente(VP,usuario);
          CVP.vistaPacientes.setVisible(true);
          vistahospitalizacionesSistema.dispose();
          break;
      default:
        break;       
    }
  }
  
  
  
}
