
package Modelo;

import java.time.LocalDate;

/**
 * Clase internado  
 * @author Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class Internado {
  private LocalDate fechaInicio;
  private LocalDate fechaFin;
  private AreaTrabajo area;
  private Paciente pacienteInternado;

  /**
   * Constructor con LocalDate
   * @param pFechaInicio
   * @param pFechaFin
   * @param pArea 
   */
  public Internado(LocalDate pFechaInicio, LocalDate pFechaFin, 
          AreaTrabajo pArea) {
    this.fechaInicio = pFechaInicio;
    this.fechaFin = pFechaFin;
    this.area = pArea;
  }
  /**
   * Constructor con LocalDate
   * @param pFechaInicio
   * @param pFechaFin
   * @param pArea  
   * @param pPaciente
   */
  public Internado(LocalDate pFechaInicio, LocalDate pFechaFin, 
          AreaTrabajo pArea, Paciente pPaciente) {
    this.fechaInicio = pFechaInicio;
    this.fechaFin = pFechaFin;
    this.area = pArea;
    this.pacienteInternado = pPaciente;
  }

  /**
   * Constructor con local date de fin y datos de inicio sin paciente
   * @param pDiaInicio
   * @param pMesInicio
   * @param pAnoInicio
   * @param pFechaFin
   * @param pArea 
   */
  public Internado(int pDiaInicio, int pMesInicio, int pAnoInicio, 
          LocalDate pFechaFin, AreaTrabajo pArea) {
    this.fechaInicio = LocalDate.of(pAnoInicio, pMesInicio, pDiaInicio);
    this.fechaFin = pFechaFin;
    this.area = pArea;
  }
  
  /**
   * Constructor con local date de fin y datos de inicio con paciente
   * @param pDiaInicio
   * @param pMesInicio
   * @param pAnoInicio
   * @param pFechaFin
   * @param pArea 
   * @param pPaciente 
   */
  public Internado(int pDiaInicio, int pMesInicio, int pAnoInicio, 
          LocalDate pFechaFin, AreaTrabajo pArea, Paciente pPaciente) {
    this.fechaInicio = LocalDate.of(pAnoInicio, pMesInicio, pDiaInicio);
    this.fechaFin = pFechaFin;
    this.area = pArea;
    this.pacienteInternado = pPaciente;
  }
  
  /**
   * constructor con los datos de las fechas sin paciente
   * @param pDiaInicio
   * @param pMesInicio
   * @param pAnoInicio
   * @param pDiaFin
   * @param pMesFin
   * @param pAnoFin
   * @param pArea 
   */
  public Internado(int pDiaInicio, int pMesInicio, int pAnoInicio, int pDiaFin,
          int pMesFin, int pAnoFin, AreaTrabajo pArea) {
    this.fechaInicio = LocalDate.of(pAnoInicio, pMesInicio, pDiaInicio);
    this.fechaFin = LocalDate.of(pAnoFin, pMesFin, pDiaFin);
    this.area = pArea;
  }
  
  /**
   * constructor con los datos de las fechas con paciente
   * @param pDiaInicio
   * @param pMesInicio
   * @param pAnoInicio
   * @param pDiaFin
   * @param pMesFin
   * @param pAnoFin
   * @param pArea 
   *  @param pPaciente
   */
  public Internado(int pDiaInicio, int pMesInicio, int pAnoInicio, int pDiaFin,
          int pMesFin, int pAnoFin, AreaTrabajo pArea, Paciente pPaciente) {
    this.fechaInicio = LocalDate.of(pAnoInicio, pMesInicio, pDiaInicio);
    this.fechaFin = LocalDate.of(pAnoFin, pMesFin, pDiaFin);
    this.area = pArea;
    this.pacienteInternado = pPaciente;
  }
  
  /**
   * Constructor con local date de inicio y datos de fin sin paciente
   * @param pFechaInicio
   * @param pDiaFin
   * @param pMesFin
   * @param pAnoFin
   * @param pArea 
   */
  public Internado(LocalDate pFechaInicio, int pDiaFin,int pMesFin, 
          int pAnoFin, AreaTrabajo pArea) {
    this.fechaInicio = pFechaInicio;
    this.fechaFin = LocalDate.of(pAnoFin, pMesFin, pDiaFin);
    this.area = pArea;
  }
  
  /**
   * Constructor con local date de inicio y datos de fin con paciente
   * @param pFechaInicio
   * @param pDiaFin
   * @param pMesFin
   * @param pAnoFin
   * @param pArea 
   * @param pPaciente
   */
  public Internado(LocalDate pFechaInicio, int pDiaFin,int pMesFin, 
          int pAnoFin, AreaTrabajo pArea, Paciente pPaciente) {
    this.fechaInicio = pFechaInicio;
    this.fechaFin = LocalDate.of(pAnoFin, pMesFin, pDiaFin);
    this.area = pArea;
    this.pacienteInternado = pPaciente;
  }
  

  public LocalDate getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(LocalDate fechaInicio) {
    this.fechaInicio = fechaInicio;
  }
  
  public void setFechaInicio(int pDiaInicio, int pMesInicio, int pAnoInicio) {
    this.fechaInicio = LocalDate.of(pAnoInicio, pMesInicio, pDiaInicio);
  }

  public LocalDate getFechaFin() {
    return fechaFin;
  }

  public void setFechaFin(LocalDate fechaFin) {
    this.fechaFin = fechaFin;
  }

  public void setFechaFin(int pDiaFin, int pMesFin, int pAnoFin) {
    this.fechaFin = LocalDate.of(pAnoFin, pMesFin, pDiaFin);
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
