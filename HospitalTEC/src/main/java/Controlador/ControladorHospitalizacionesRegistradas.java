/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.HospitalizacionesSistema;

/**
 *
 * @author pablo
 */
public class ControladorHospitalizacionesRegistradas {
  public HospitalizacionesSistema vistahospitalizacionesSistema;
  String usuario;

  public ControladorHospitalizacionesRegistradas(HospitalizacionesSistema hospitalizacionesSistema, String usuario) {
    this.vistahospitalizacionesSistema = hospitalizacionesSistema;
    this.usuario = usuario;
  }
  
  
  
}
