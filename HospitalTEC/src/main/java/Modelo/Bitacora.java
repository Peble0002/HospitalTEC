
package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase bitacora
 * @author Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class Bitacora {
  private int idCita;
  private LocalDate fecha;
  private LocalTime hora;
  private String nombreUsuario;

  /**
   * Constructor con Fecha y Hora
   * @param idCita
   * @param fecha
   * @param hora
   * @param nombreUsuario 
   */
  public Bitacora(int pIdCita, LocalDate pFecha, LocalTime pHora, 
          String pNombreUsuario) {
    this.idCita = pIdCita;
    this.fecha = pFecha;
    this.hora = pHora;
    this.nombreUsuario = pNombreUsuario;
  }
 
  /**
   * Constructor con datos de la fecha y hora
   * @param idCita
   * @param pDia
   * @param pMes
   * @param pAno
   * @param hora
   * @param nombreUsuario 
   */
  public Bitacora(int pIdCita, int pDia, int pMes, int pAno, LocalTime pHora,
          String pNombreUsuario) {
    this.idCita = pIdCita;
    this.fecha = LocalDate.of(pAno, pMes, pDia);
    this.hora = pHora;
    this.nombreUsuario = pNombreUsuario;
  }
  
  /**
   * Constructor con los datos de fecha y los datos de hora
   * @param idCita
   * @param pDia
   * @param pMes
   * @param pAno
   * @param pHora
   * @param pMinutos
   * @param pSegundos
   * @param nombreUsuario 
   */
  public Bitacora(int pIdCita, int pDia, int pMes, int pAno, int pHora, 
          int pMinutos, int pSegundos, String pNombreUsuario) {
    this.idCita = pIdCita;
    this.fecha = LocalDate.of(pAno, pMes, pDia);
    this.hora = LocalTime.of(pHora,pMinutos, pSegundos);
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
  public Bitacora(int pIdCita, LocalDate pFecha, int pHora, int pMinutos,
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

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate pFecha) {
    this.fecha = pFecha;
  }
  
  public void setFecha(int pDia, int pMes, int pAno) {
    this.fecha = LocalDate.of(pAno, pMes, pDia);
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
