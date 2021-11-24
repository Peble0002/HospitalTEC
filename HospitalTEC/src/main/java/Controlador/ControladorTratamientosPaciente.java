/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.TratamientosAsociadosPaciente;

/**
 *
 * @author pablo
 */
public class ControladorTratamientosPaciente {
  String usuario;
  TratamientosAsociadosPaciente vistaTratamientosSistema;

  public ControladorTratamientosPaciente(String usuario, TratamientosAsociadosPaciente vistaTratamientosSistema) {
    this.usuario = usuario;
    this.vistaTratamientosSistema = vistaTratamientosSistema;
  }
  
  
}
