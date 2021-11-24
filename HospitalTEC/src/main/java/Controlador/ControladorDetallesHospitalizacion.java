/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.DetalleHospitalizacionSistema;

/**
 *
 * @author pablo
 */
public class ControladorDetallesHospitalizacion {
  String usuario;
  DetalleHospitalizacionSistema vistaDetalleHospitalizacionSistema;

  public ControladorDetallesHospitalizacion(String usuario, DetalleHospitalizacionSistema vistaDetalleHospitalizacionSistema) {
    this.usuario = usuario;
    this.vistaDetalleHospitalizacionSistema = vistaDetalleHospitalizacionSistema;
  }
  
  
}
