/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author Pablo Chaves, Aaron Soto y Luis Leitón
 */
public class Vacuna {
  private LocalDate fechaAplicacion;
  private String nombre;
  private String farmaceutica;
  private int numeroLote;

  /**
   * 
   * @param pDia
   * @param pMes
   * @param pAno
   * @param pNombre
   * @param pFarmaceutica
   * @param pNumeroLote 
   */
  public Vacuna(int pDia, int pMes, int pAno, String pNombre, String pFarmaceutica, int pNumeroLote) {
    this.fechaAplicacion = LocalDate.of(pAno, pMes, pDia);
    this.nombre = pNombre;
    this.farmaceutica = pFarmaceutica;
    this.numeroLote = pNumeroLote;
  }

  public LocalDate getFechaAplicacion() {
    return fechaAplicacion;
  }

  public void setFechaAplicacion(LocalDate fechaAplicacion) {
    this.fechaAplicacion = fechaAplicacion;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String pNombre) {
    this.nombre = pNombre;
  }

  public String getFarmaceutica() {
    return farmaceutica;
  }

  public void setFarmaceutica(String pFarmaceutica) {
    this.farmaceutica = pFarmaceutica;
  }

  public int getNumeroLote() {
    return numeroLote;
  }

  public void setNumeroLote(int pNumeroLote) {
    this.numeroLote = pNumeroLote;
  }
  
  
  
}
