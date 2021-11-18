
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase registro de seguimiento para registrar el seguimiento de un internado
 * @author Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class RegistroSeguimiento {
  private LocalDate fecha;
  private String observacion;
  private ArrayList<Tratamiento> tratamientos;
  private Internado internado;

  /**
   * para generar un registro se requiere la fecha y la observacion
   * @param pFecha
   * @param pObservacion 
   */
  public RegistroSeguimiento(LocalDate pFecha, String pObservacion) {
    this.fecha = pFecha;
    this.observacion = pObservacion;
    this.tratamientos = new ArrayList<Tratamiento>();
  }

  /**
   * 
   * @param pDia
   * @param pMes
   * @param pAno
   * @param pObservacion 
   */
  public RegistroSeguimiento(int pDia, int pMes, int pAno, String pObservacion) {
    this.fecha = LocalDate.of(pAno, pMes, pDia);;
    this.observacion = pObservacion;
    this.tratamientos = new ArrayList<Tratamiento>();
  }      
  /**
   * Constructor con todos los atributos
   * @param pFecha
   * @param pObservacion
   * @param pTratamientos
   * @param pInternado 
   */
  public RegistroSeguimiento(LocalDate pFecha, String pObservacion, 
          ArrayList<Tratamiento> pTratamientos, Internado pInternado) {
    this.fecha = pFecha;
    this.observacion = pObservacion;
    this.tratamientos = pTratamientos;
    this.internado = pInternado;
  }

  /**
   * Constructor con los tratamientos
   * @param pFecha
   * @param pObservacion
   * @param pTratamientos 
   */
  public RegistroSeguimiento(LocalDate pFecha, String pObservacion,
          ArrayList<Tratamiento> pTratamientos) {
    this.fecha = pFecha;
    this.observacion = pObservacion;
    this.tratamientos = pTratamientos;
    this.internado = null;
  }

  /**
   * constructor con el internado
   * @param pFecha
   * @param pObservacion
   * @param pInternado 
   */
  public RegistroSeguimiento(LocalDate pFecha, String pObservacion,
          Internado pInternado) {
    this.fecha = pFecha;
    this.observacion = pObservacion;
    this.internado = pInternado;
    this.tratamientos = new ArrayList<Tratamiento>();
  }

  public LocalDate getFehca() {
    return fecha;
  }

  public void setFehca(LocalDate pFecha) {
    this.fecha = pFecha;
  }
  
  public void setFehca(int pDia, int pMes, int pAno) {
    this.fecha = LocalDate.of(pAno, pMes, pDia);;
  }

  public String getObservacion() {
    return observacion;
  }

  public void setObservacion(String pObservacion) {
    this.observacion = pObservacion;
  }

  public ArrayList<Tratamiento> getTratamientos() {
    return tratamientos;
  }

  public void setTratamientos(Tratamiento pTratamientos) {
    this.tratamientos.add(pTratamientos);
  }

  public Internado getInternado() {
    return internado;
  }

  public void setInternado(Internado pInternado) {
    this.internado = pInternado;
  }
  
  
  
  
  
  
  
}
