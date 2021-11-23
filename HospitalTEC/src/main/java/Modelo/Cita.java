
package Modelo;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Cuenta Cita
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class Cita {
  protected String idCita;
  protected Date fecha;
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
  public Cita(String pIdCita, Date pFecha, LocalTime pHora, 
          String pObservaciones, String pEspecialidad, EstadoCita pEstado) {
    this.idCita = pIdCita;
    this.fecha = pFecha;
    this.hora = pHora;
    this.observaciones = pObservaciones;
    this.especialidad = pEspecialidad;
    this.estado = estado;
  }
  
  public Cita(Date pFecha, LocalTime pHora, 
          String pObservaciones, String pEspecialidad, EstadoCita pEstado) {
    
    this.fecha = pFecha;
    this.hora = pHora;
    this.observaciones = pObservaciones;
    this.especialidad = pEspecialidad;
    this.estado = estado;
  }
  
  public Cita(Date pFecha, LocalTime pHora, 
          String pObservaciones, String pEspecialidad) {
    
    this.fecha = pFecha;
    this.hora = pHora;
    this.observaciones = pObservaciones;
    this.especialidad = pEspecialidad;
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
  public Cita(String pIdCita, Date pFecha, int pHora, int pMinutos,
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

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date pFecha) {
    this.fecha = pFecha;
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
