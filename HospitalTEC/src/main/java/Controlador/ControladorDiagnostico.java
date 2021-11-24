/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.DiagnosticosSistema;

/**
 *
 * @author pablo
 */
public class ControladorDiagnostico {
  String usuario;
  DiagnosticosSistema vistaDiagnosticosSistema;

  public ControladorDiagnostico(String usuario, DiagnosticosSistema vistaDiagnosticosSistema) {
    this.usuario = usuario;
    this.vistaDiagnosticosSistema = vistaDiagnosticosSistema;
  }
  
  
  
}
