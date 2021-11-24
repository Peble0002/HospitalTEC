/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.DiagnosticosAsociadosPaciente;

/**
 *
 * @author pablo
 */
public class ControladorDiagnosticoPaciente {
  String usuario;
  DiagnosticosAsociadosPaciente vistaDiagnosticosAsociadosPaciente;

  public ControladorDiagnosticoPaciente(String usuario, DiagnosticosAsociadosPaciente vistaDiagnosticosAsociadosPaciente) {
    this.usuario = usuario;
    this.vistaDiagnosticosAsociadosPaciente = vistaDiagnosticosAsociadosPaciente;
  }
  
  
}
