/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DiagnosticoBD;
import Vista.RegistrarCatalogoDiagnosticos;
import Vista.VistaDoctor;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class ControladorRegistrarDiagnostico implements ActionListener{
  String usuario;
  RegistrarCatalogoDiagnosticos vistaRegistrarCatalogoDiagnosticos;

  public ControladorRegistrarDiagnostico(String usuario, RegistrarCatalogoDiagnosticos vistaRegistrarCatalogoDiagnosticos) {
    this.usuario = usuario;
    this.vistaRegistrarCatalogoDiagnosticos = vistaRegistrarCatalogoDiagnosticos;
    
    this.vistaRegistrarCatalogoDiagnosticos.btnRegistrarCatDiag.addActionListener(this);
    this.vistaRegistrarCatalogoDiagnosticos.btnVolver.addActionListener(this);
    
  }
  
  @Override
   public void actionPerformed(ActionEvent e){
     switch(e.getActionCommand()){
      case "Registrar":
        if(vistaRegistrarCatalogoDiagnosticos.datosCorrectos()==false){
          JOptionPane.showMessageDialog(vistaRegistrarCatalogoDiagnosticos, 
                  "Debe ingresar el nombre del diagnóstico.");
        }else{
          registrarDiagnostico();
        }
        break;
      case "Volver":
          VistaDoctor VD = new VistaDoctor();
          ControladorVistaDoctor CVD = new ControladorVistaDoctor(VD,usuario);
          CVD.vistaDoctor.setVisible(true);
          vistaRegistrarCatalogoDiagnosticos.dispose();
          break;
      default:
          break;       
  }
}
   
   public void registrarDiagnostico(){
       DiagnosticoBD dbd = new DiagnosticoBD();
       String nombre = vistaRegistrarCatalogoDiagnosticos.tbNombre.getText();
       dbd.insertarDiagnostico(nombre);
       
   }
  
  
}
