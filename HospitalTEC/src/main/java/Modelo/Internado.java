
package Modelo;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Clase internado  
 * @author Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class Internado {
  private Date fechaInicio;
  private Date fechaFin;
  private AreaTrabajo area;
  private Paciente pacienteInternado;

  /**
   * Constructor con LocalDate
   * @param pFechaInicio
   * @param pFechaFin
   * @param pArea 
   */
  public Internado(Date pFechaInicio, Date pFechaFin, 
          AreaTrabajo pArea) {
    this.fechaInicio = pFechaInicio;
    this.fechaFin = pFechaFin;
    this.area = pArea;
  }





  public Date getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(Date fechaInicio) {
    this.fechaInicio = fechaInicio;
  }
  


  public Date getFechaFin() {
    return fechaFin;
  }

  public void setFechaFin(Date fechaFin) {
    this.fechaFin = fechaFin;
  }


  
  public AreaTrabajo getArea() {
    return area;
  }

  public void setArea(AreaTrabajo area) {
    this.area = area;
  }

  public Paciente getPacienteInternado() {
    return pacienteInternado;
  }

  public void setPacienteInternado(Paciente pPacienteInternado) {
    this.pacienteInternado = pPacienteInternado;
  }
  
  
  
}
