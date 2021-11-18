/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Modelo.TipoFuncionario.Enfermero;
import java.time.LocalDate;

/**
 * Clase enfermero hija de funcionario
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
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
  public Enfermero(boolean pACargo, boolean pExperiencia,
          LocalDate pFechaIngreso, int pId) {
    super(pFechaIngreso, pId);
    this.aCargo = pACargo;
    this.experiencia = pExperiencia;
    super.setTipo(Enfermero);
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
  public Enfermero(boolean pACargo, boolean pExperiencia, 
          int pDia, int pMes, int pAno, int pId) {
    super(pDia, pMes, pAno, pId);
    this.aCargo = pACargo;
    this.experiencia = pExperiencia;
    super.setTipo(Enfermero);
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
