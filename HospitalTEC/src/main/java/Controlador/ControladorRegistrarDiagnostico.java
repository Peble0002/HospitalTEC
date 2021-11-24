/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.RegistrarCatalogoDiagnosticos;

/**
 *
 * @author pablo
 */
public class ControladorRegistrarDiagnostico {
  String usuario;
  RegistrarCatalogoDiagnosticos vistaRegistrarCatalogoDiagnosticos;

  public ControladorRegistrarDiagnostico(String usuario, RegistrarCatalogoDiagnosticos vistaRegistrarCatalogoDiagnosticos) {
    this.usuario = usuario;
    this.vistaRegistrarCatalogoDiagnosticos = vistaRegistrarCatalogoDiagnosticos;
  }
  
  
}
