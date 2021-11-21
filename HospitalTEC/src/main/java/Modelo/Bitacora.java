
package Modelo;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase bitacora
 * @author Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class Bitacora {
  private int idCita;
  private Date fecha;
  private LocalTime hora;
  private String nombreUsuario;

  /**
   * Constructor con Fecha y Hora
   * @param idCita
   * @param fecha
   * @param hora
   * @param nombreUsuario 
   */
  public Bitacora(int pIdCita, Date pFecha, LocalTime pHora, 
          String pNombreUsuario) {
    this.idCita = pIdCita;
    this.fecha = pFecha;
    this.hora = pHora;
    this.nombreUsuario = pNombreUsuario;
  }

  
  
  /**
   * Constructor con fecha y los datos de hora
   * @param idCita
   * @param fecha
   * @param pHora
   * @param pMinutos
   * @param pSegundos
   * @param nombreUsuario 
   */
  public Bitacora(int pIdCita, Date pFecha, int pHora, int pMinutos,
          int pSegundos, String pNombreUsuario) {
    this.idCita = pIdCita;
    this.fecha = pFecha;
    this.hora = LocalTime.of(pHora,pMinutos, pSegundos);
    this.nombreUsuario = pNombreUsuario;
  }

  public int getIdCita() {
    return idCita;
  }

  public void setIdCita(int pIdCita) {
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

  public void setHora(LocalTime pHora) {
    this.hora = pHora;
  }
  
  public void setHora(int pHora, int pMinutos, int pSegundos) {
    this.hora = LocalTime.of(pHora,pMinutos, pSegundos);
  }

  public String getNombreUsuario() {
    return nombreUsuario;
  }

  public void setNombreUsuario(String pNombreUsuario) {
    this.nombreUsuario = pNombreUsuario;
  }
  
  
  
}
