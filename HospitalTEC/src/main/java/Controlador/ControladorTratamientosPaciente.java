/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.TratamientosAsociadosPaciente;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author pablo
 */
public class ControladorTratamientosPaciente implements ActionListener {
  String usuario;
  TratamientosAsociadosPaciente vistaTratamientosSistema;

  public ControladorTratamientosPaciente(String usuario, TratamientosAsociadosPaciente vistaTratamientosSistema) {
    this.usuario = usuario;
    this.vistaTratamientosSistema = vistaTratamientosSistema;
    
    this.vistaTratamientosSistema.btnBuscar.addActionListener(this);
    this.vistaTratamientosSistema.btnVolver.addActionListener(this);
    
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
          vistaTratamientosSistema.dispose();
          break;
      default:
        break;       
    }
  }
  
  
}
