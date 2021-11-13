/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 */
public final class Doctor extends Funcionario {
  private String codigoMedico;
  private ArrayList<String> especialidades;

  /**
   * 
   * @param pCodigoMedico
   * @param pEspecialidad
   * @param pTipo
   * @param pFechaIngreso
   * @param pId 
   */
  public Doctor(String pCodigoMedico, String pEspecialidad, TipoFuncionario pTipo, LocalDate pFechaIngreso, int pId) {
    super(pTipo, pFechaIngreso, pId);
    this.codigoMedico = codigoMedico;
    this.especialidades.add(pEspecialidad);
  }

  public Doctor(String pCodigoMedico, String pEspecialidad, TipoFuncionario pTipo, int pDia, int pMes, int pAno, int pId) {
    super(pTipo, pDia, pMes, pAno, pId);
    this.codigoMedico = codigoMedico;
    this.especialidades.add(pEspecialidad);
  }
  
  public String getCodigoMedico() {
    return codigoMedico;
  }

  public void setCodigoMedico(String codigoMedico) {
    this.codigoMedico = codigoMedico;
  }

  public ArrayList<String> getEspecialidad() {
    return especialidades;
  }

  public void setEspecialidad(ArrayList<String> especialidad) {
    this.especialidades = especialidad;
  }
  
  public void agregarEspecialidad(String pEspecialidad){
    especialidades.add(pEspecialidad);
  }
  
}
