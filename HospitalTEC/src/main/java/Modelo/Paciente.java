/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class Paciente extends Persona{
  private LocalDate fechaNacimiento;
  private String tipoSangre;
  private String nacionalidad;
  private String provincia;
  private String canton;
  private String distrito;
  //revisar la generic
  private ArrayList<String> telefonos;
  private ArrayList<Vacuna> vacunas;

  /**
   * 
   * @param fechaNacimiento
   * @param tipoSangre
   * @param nacionalidad
   * @param pId 
   */
  public Paciente(LocalDate fechaNacimiento, String tipoSangre, String nacionalidad, int pId) {
    super(pId);
    this.fechaNacimiento = fechaNacimiento;
    this.tipoSangre = tipoSangre;
    this.nacionalidad = nacionalidad;
    this.telefonos= new ArrayList<String>();
    this.vacunas= new ArrayList<Vacuna>();
  }

  public LocalDate getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(int pDia, int pMes, int pAno) {
    this.fechaNacimiento = LocalDate.of(pAno, pMes, pDia);
  }

  public String getTipoSangre() {
    return tipoSangre;
  }

  public void setTipoSangre(String tipoSangre) {
    this.tipoSangre = tipoSangre;
  }

  public String getNacionalidad() {
    return nacionalidad;
  }

  public void setNacionalidad(String nacionalidad) {
    this.nacionalidad = nacionalidad;
  }

  public String getProvincia() {
    return provincia;
  }

  public void setProvincia(String provincia) {
    this.provincia = provincia;
  }

  public String getCanton() {
    return canton;
  }

  public void setCanton(String canton) {
    this.canton = canton;
  }

  public String getDistrito() {
    return distrito;
  }

  public void setDistrito(String distrito) {
    this.distrito = distrito;
  }

  public ArrayList<String> getTelefonos() {
    return telefonos;
  }

  public void setTelefonos(String telefonos) {
    this.telefonos.add(nombre);
  }

  public ArrayList<Vacuna> getVacunas() {
    return vacunas;
  }

  public void setVacunas(Vacuna vacunas) {
    this.vacunas.add(vacunas);
  }
  
  

  
  
  
  
  
}
