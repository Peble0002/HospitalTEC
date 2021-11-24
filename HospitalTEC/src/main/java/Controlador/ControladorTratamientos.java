/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.TratamientosSistema;

/**
 *
 * @author pablo
 */
public class ControladorTratamientos {
  String usuario;
  TratamientosSistema vistaTratamientosSistema;

  public ControladorTratamientos(String usuario, TratamientosSistema vistaTratamientosSistema) {
    this.usuario = usuario;
    this.vistaTratamientosSistema = vistaTratamientosSistema;
  }
  
  
}
