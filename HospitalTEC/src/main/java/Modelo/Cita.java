
package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Cuenta Cita
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class Cita {
  protected String idCita;
  protected LocalDate fecha;
  protected LocalTime hora;
  protected String observaciones;
  protected String especialidad;
  protected EstadoCita estado;

  /**
   * Constructor con fecha y hora
   * @param pIdCita
   * @param pFecha
   * @param pHora
   * @param pObservaciones
   * @param pEspecialidad
   * @param pEstado 
   */
  public Cita(String pIdCita, LocalDate pFecha, LocalTime pHora, 
          String pObservaciones, String pEspecialidad, EstadoCita pEstado) {
    this.idCita = pIdCita;
    this.fecha = pFecha;
    this.hora = pHora;
    this.observaciones = pObservaciones;
    this.especialidad = pEspecialidad;
    this.estado = estado;
  }
  
  /**
   * constructor con datos de fecha y hora
   * @param pIdCita
   * @param pDiaInicio
   * @param pMesInicio
   * @param pAnoInicio
   * @param pHora
   * @param pObservaciones
   * @param pEspecialidad
   * @param pEstado 
   */
   public Cita(String pIdCita, int pDiaInicio, int pMesInicio, int pAnoInicio, 
           LocalTime pHora, String pObservaciones, String pEspecialidad, 
           EstadoCita pEstado) {
    this.idCita = pIdCita;
    this.fecha = LocalDate.of(pAnoInicio, pMesInicio, pDiaInicio);
    this.hora = pHora;
    this.observaciones = pObservaciones;
    this.especialidad = pEspecialidad;
    this.estado = pEstado;
  }
  
   /**
    * constructor con datos de fecha y datos de hora
    * @param pIdCita
    * @param pDiaInicio
    * @param pMesInicio
    * @param pAnoInicio
    * @param pHora
    * @param pMinutos
    * @param pSegundos
    * @param observaciones
    * @param pEspecialidad
    * @param pEstado 
    */
  public Cita(String pIdCita, int pDiaInicio, int pMesInicio, int pAnoInicio, 
           int pHora, int pMinutos, int pSegundos, String observaciones, 
           String pEspecialidad, EstadoCita pEstado) {
    this.idCita = pIdCita;
    this.fecha = LocalDate.of(pAnoInicio, pMesInicio, pDiaInicio);
    this.hora = LocalTime.of(pHora,pMinutos, pSegundos);
    this.observaciones = observaciones;
    this.especialidad = pEspecialidad;
    this.estado = pEstado;
  }
  
  /**
   * Constructor con fecha y datos de la hora
   * @param pIdCita
   * @param pFecha
   * @param pHora
   * @param pMinutos
   * @param pSegundos
   * @param pObservaciones
   * @param pEspecialidad
   * @param pEstado 
   */
  public Cita(String pIdCita, LocalDate pFecha, int pHora, int pMinutos,
          int pSegundos, String pObservaciones, 
           String pEspecialidad, EstadoCita pEstado) {
    this.idCita = pIdCita;
    this.fecha = pFecha;
    this.hora = LocalTime.of(pHora,pMinutos, pSegundos);
    this.observaciones = pObservaciones;
    this.especialidad = pEspecialidad;
    this.estado = pEstado;
  }

  public String getIdCita() {
    return idCita;
  }

  public void setIdCita(String pIdCita) {
    this.idCita = pIdCita;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate pFecha) {
    this.fecha = pFecha;
  }
  
  public void setFecha(int pDiaInicio, int pMesInicio, int pAnoInicio) {
    this.fecha = LocalDate.of(pAnoInicio, pMesInicio, pDiaInicio);
  }
  public LocalTime getHora() {
    return hora;
  }

  
  public void setHora(int pHora, int pMinutos, int pSegundos) {
    this.hora = LocalTime.of(pHora,pMinutos, pSegundos);
  }

  public void setHora(LocalTime pHora) {
    this.hora = pHora;
  }
  public String getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(String pObservaciones) {
    this.observaciones = pObservaciones;
  }

  public String getEspecialidad() {
    return especialidad;
  }

  public void setEspecialidad(String pEspecialidad) {
    this.especialidad = pEspecialidad;
  }

  public EstadoCita getEstado() {
    return estado;
  }

  public void setEstado(EstadoCita pEstado) {
    this.estado = pEstado;
  }
  
  
  
}
