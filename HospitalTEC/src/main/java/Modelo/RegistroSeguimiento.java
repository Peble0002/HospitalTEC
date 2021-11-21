
package Modelo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase registro de seguimiento para registrar el seguimiento de un internado
 * @author Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class RegistroSeguimiento {
  private Date fecha;
  private String observacion;
  private ArrayList<Tratamiento> tratamientos;
  private Internado internado;

  /**
   * para generar un registro se requiere la fecha y la observacion
   * @param pFecha
   * @param pObservacion 
   */
  public RegistroSeguimiento(Date pFecha, String pObservacion) {
    this.fecha = pFecha;
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
  public RegistroSeguimiento(Date pFecha, String pObservacion, 
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
  public RegistroSeguimiento(Date pFecha, String pObservacion,
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
  public RegistroSeguimiento(Date pFecha, String pObservacion,
          Internado pInternado) {
    this.fecha = pFecha;
    this.observacion = pObservacion;
    this.internado = pInternado;
    this.tratamientos = new ArrayList<Tratamiento>();
  }

  public Date getFehca() {
    return fecha;
  }

  public void setFehca(Date pFecha) {
    this.fecha = pFecha;
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
