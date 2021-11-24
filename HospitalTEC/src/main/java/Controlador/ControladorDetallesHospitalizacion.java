/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.DetalleHospitalizacionSistema;
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
          VistaSecretario VS = new VistaSecretario();
          ControladorVistaSecretario CVP = new ControladorVistaSecretario(VS,usuario);
          CVP.vistaSecretario.setVisible(true);
          vistaDetalleHospitalizacionSistema.dispose();
          break;
      default:
        break;       
    }
  }
  
  
}
