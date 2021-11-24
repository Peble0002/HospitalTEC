/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.CitasAsociadasPaciente;

/**
 *
 * @author pablo
 */
public class ControladorCitasPaciente {
  String usuario;
  CitasAsociadasPaciente vistaCitasAsociadasPaciente;

  public ControladorCitasPaciente(String usuario, CitasAsociadasPaciente vistaCitasAsociadasPaciente) {
    this.usuario = usuario;
    this.vistaCitasAsociadasPaciente = vistaCitasAsociadasPaciente;
  }
  
  
}
