/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Modelo.TipoFuncionario.Enfermero;
import java.sql.Date;

/**
 * Clase enfermero hija de funcionario
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public final class Enfermero extends Funcionario{
  private boolean aCargo;
  private boolean experiencia;

  public Enfermero(boolean aCargo, boolean experiencia, TipoFuncionario pTipo, Date pFechaIngreso, String pId) {
    super(pTipo, pFechaIngreso, pId);
    this.aCargo = aCargo;
    this.experiencia = experiencia;
  }

  public Enfermero(boolean aCargo, boolean experiencia, TipoFuncionario tipo, Date fechaIngreso, AreaTrabajo area, CentroAtencion centro, String pId) {
    super(tipo, fechaIngreso, area, centro, pId);
    this.aCargo = aCargo;
    this.experiencia = experiencia;
  }

  public Enfermero(boolean aCargo, boolean experiencia, TipoFuncionario tipo, Date fechaIngreso, AreaTrabajo area, CentroAtencion centro, String id, String contrasena) {
    super(tipo, fechaIngreso, area, centro, id, contrasena);
    this.aCargo = aCargo;
    this.experiencia = experiencia;
  }

  public Enfermero(boolean aCargo, boolean experiencia, TipoFuncionario tipo, Date fechaIngreso, AreaTrabajo area, CentroAtencion centro, String id, String contrasena, String nombre, String apellido1, String apellido2) {
    super(tipo, fechaIngreso, area, centro, id, contrasena, nombre, apellido1, apellido2);
    this.aCargo = aCargo;
    this.experiencia = experiencia;
  }

  public Enfermero(boolean aCargo, boolean experiencia, Date pFechaIngreso, String pId) {
    super(pFechaIngreso, pId);
    this.aCargo = aCargo;
    this.experiencia = experiencia;
  }

 
  
  

  public boolean isaCargo() {
    return aCargo;
  }

  public void setaCargo(boolean aCargo) {
    this.aCargo = aCargo;
  }

  public boolean isExperiencia() {
    return experiencia;
  }

  public void setExperiencia(boolean experiencia) {
    this.experiencia = experiencia;
  }
 
  
  
  
  
  
}
