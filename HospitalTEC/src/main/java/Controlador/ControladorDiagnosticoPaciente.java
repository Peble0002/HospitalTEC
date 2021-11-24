/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.DiagnosticosAsociadosPaciente;
import Vista.VistaPaciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author pablo
 */
public class ControladorDiagnosticoPaciente  implements ActionListener{
  String usuario;
  DiagnosticosAsociadosPaciente vistaDiagnosticosAsociadosPaciente;

  public ControladorDiagnosticoPaciente(String usuario, DiagnosticosAsociadosPaciente vistaDiagnosticosAsociadosPaciente) {
    this.usuario = usuario;
    this.vistaDiagnosticosAsociadosPaciente = vistaDiagnosticosAsociadosPaciente;
    
    this.vistaDiagnosticosAsociadosPaciente.btnBuscar.addActionListener(this);
    this.vistaDiagnosticosAsociadosPaciente.btnVolver.addActionListener(this);
    
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
          vistaDiagnosticosAsociadosPaciente.dispose();
          break;
      default:
        break;       
    }
  }
  
  
}
