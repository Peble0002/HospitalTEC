package Modelo;

import java.time.LocalDate;

/**
 * Clase Vacuna 
 * @author Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class Vacuna {
  private LocalDate fechaAplicacion;
  private String nombre;
  private String farmaceutica;
  private int numeroLote;

  /**
   * Este constructor permite crear un objeto Vacuna con los datos de la fecha.
   * @param pDia
   * @param pMes
   * @param pAno
   * @param pNombre
   * @param pFarmaceutica
   * @param pNumeroLote 
   */
  public Vacuna(int pDia, int pMes, int pAno, String pNombre, 
          String pFarmaceutica, int pNumeroLote) {
    this.fechaAplicacion = LocalDate.of(pAno, pMes, pDia);
    this.nombre = pNombre;
    this.farmaceutica = pFarmaceutica;
    this.numeroLote = pNumeroLote;
  }
  
  /**
   * ste constructor permite crear un objeto Vacuna mediante un localdate
   * @param pFechaAplicacion
   * @param pNombre
   * @param pFarmaceutica
   * @param pNumeroLote 
   */
  public Vacuna(LocalDate pFechaAplicacion, String pNombre, 
          String pFarmaceutica, int pNumeroLote) {
    this.fechaAplicacion = pFechaAplicacion;
    this.nombre = pNombre;
    this.farmaceutica = pFarmaceutica;
    this.numeroLote = pNumeroLote;
  }

  public LocalDate getFechaAplicacion() {
    return fechaAplicacion;
  }

  public void setFechaAplicacion(LocalDate fechaAplicacion) {
    this.fechaAplicacion = fechaAplicacion;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String pNombre) {
    this.nombre = pNombre;
  }

  public String getFarmaceutica() {
    return farmaceutica;
  }

  public void setFarmaceutica(String pFarmaceutica) {
    this.farmaceutica = pFarmaceutica;
  }

  public int getNumeroLote() {
    return numeroLote;
  }

  public void setNumeroLote(int pNumeroLote) {
    this.numeroLote = pNumeroLote;
  }
  
  
  
}
