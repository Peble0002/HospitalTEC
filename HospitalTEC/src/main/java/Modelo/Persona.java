/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Abstraccion de la clase persona
 * @author Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (06/11/2021)
 */
public abstract class Persona {
  protected int id;
  protected String nombre;
  protected String apellido1;
  protected String apellido2;

  /**
   * 
   * @param id
   * @param nombre 
   */
  public Persona(int pId) {
    this.id = pId;
 
  }

  /**
   * 
   * @return 
   */
  public int getId() {
    return id;
  }

  /**
   * 
   * @param id 
   */
  public void setId(int pId) {
    this.id = pId;
  }

  /**
   * 
   * @return 
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * 
   * @param nombre 
   */
  public void setNombre(String pNombre) {
    this.nombre = pNombre;
  }

  /**
   * 
   * @return 
   */
  public String getApellido1() {
    return apellido1;
  }

  /**
   * 
   * @param apellido1 
   */
  public void setApellido1(String pApellido1) {
    this.apellido1 = pApellido1;
  }

  /**
   * 
   * @return 
   */
  public String getApellido2() {
    return apellido2;
  }

  /**
   * 
   * @param apellido2 
   */
  public void setApellido2(String pApellido2) {
    this.apellido2 = pApellido2;
  }
  
  
}
