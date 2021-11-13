/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Pablo Chaves, Aaron Soto y Luis Leitón
 */
public class CentroAtencion {
  private static final AtomicInteger contador = new AtomicInteger(0);
  private final int codigo;
  private String nombre;
  private String ubicacion;
  private int capacidad;
  private TipoCentro tipo;

  /**
   * 
   * @param nombre
   * @param ubicacion
   * @param capacidad
   * @param pTipo 
   */
  public CentroAtencion(String nombre, String ubicacion, int capacidad, TipoCentro pTipo) {
    this.nombre = nombre;
    this.ubicacion = ubicacion;
    this.capacidad = capacidad;
    this.tipo= pTipo;
    codigo = contador.incrementAndGet();    
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
  }

  public int getCapacidad() {
    return capacidad;
  }

  public void setCapacidad(int capacidad) {
    this.capacidad = capacidad;
  }

  public TipoCentro getTipo() {
    return tipo;
  }

  public void setTipo(TipoCentro tipo) {
    this.tipo = tipo;
  }
  
  
}
