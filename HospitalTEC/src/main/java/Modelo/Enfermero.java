/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 */
public final class Enfermero extends Funcionario{
  private boolean aCargo;
  private boolean experiencia;

  /**
   * 
   * @param pACargo
   * @param pExperiencia
   * @param pTipo
   * @param pFechaIngreso
   * @param pId 
   */
  public Enfermero(boolean pACargo, boolean pExperiencia, TipoFuncionario pTipo, LocalDate pFechaIngreso, int pId) {
    super(pTipo, pFechaIngreso, pId);
    this.aCargo = pACargo;
    this.experiencia = pExperiencia;
  }
  
  /**
   * 
   * @param pACargo
   * @param pExperiencia
   * @param pTipo
   * @param pDia
   * @param pMes
   * @param pAno
   * @param pId 
   */
  public Enfermero(boolean pACargo, boolean pExperiencia, TipoFuncionario pTipo, int pDia, int pMes, int pAno, int pId) {
    super(pTipo, pDia, pMes, pAno, pId);
    this.aCargo = pACargo;
    this.experiencia = pExperiencia;
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
