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
  public CentroAtencion(String pNombre, String pUbicacion, int pCapacidad, TipoCentro pTipo) {
    this.nombre = pNombre;
    this.ubicacion = pUbicacion;
    this.capacidad = pCapacidad;
    this.tipo= pTipo;
    codigo = contador.incrementAndGet();    
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String pNombre) {
    this.nombre = pNombre;
  }

  public String getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(String pUbicacion) {
    this.ubicacion = pUbicacion;
  }

  public int getCapacidad() {
    return capacidad;
  }

  public void setCapacidad(int pCapacidad) {
    this.capacidad = pCapacidad;
  }

  public TipoCentro getTipo() {
    return tipo;
  }

  public void setTipo(TipoCentro pTipo) {
    this.tipo = pTipo;
  }
  
  
}
