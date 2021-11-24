/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.RegistroSeguimientoInternado;

/**
 *
 * @author pablo
 */
public class ControladorSeguimientoInternado {
  String usuario;
  RegistroSeguimientoInternado vistaRegistroSeguimientoInternado;

  public ControladorSeguimientoInternado(String usuario, RegistroSeguimientoInternado vistaRegistroSeguimientoInternado) {
    this.usuario = usuario;
    this.vistaRegistroSeguimientoInternado = vistaRegistroSeguimientoInternado;
  }
  
  
}
