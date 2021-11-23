package Modelo;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Clase Vacuna 
 * @author Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class Vacuna {
  private Date fechaAplicacion;
  private String nombre;
  private String farmaceutica;
  private String numeroLote;
  private int idVacuna;

  /**
   * Este constructor permite crear un objeto Vacuna con los datos de la fecha.
   * @param pDia
   * @param pMes
   * @param pAno
   * @param pNombre
   * @param pFarmaceutica
   * @param pNumeroLote 
   */
  
  
  /**
   * ste constructor permite crear un objeto Vacuna mediante un localdate
   * @param pFechaAplicacion
   * @param pNombre
   * @param pFarmaceutica
   * @param pNumeroLote 
   */
  
  public Vacuna(){
  
  }
  public Vacuna(Date pFechaAplicacion, String pNombre, 
          String pFarmaceutica, String pNumeroLote) {
    this.fechaAplicacion = pFechaAplicacion;
    this.nombre = pNombre;
    this.farmaceutica = pFarmaceutica;
    this.numeroLote = pNumeroLote;
  }
  
   public Vacuna(Date pFechaAplicacion, String pNombre, 
         String pNumeroLote,int pID) {
    this.fechaAplicacion = pFechaAplicacion;
    this.nombre = pNombre;
    this.numeroLote = pNumeroLote;
    this.idVacuna = pID;
  }

  public Date getFechaAplicacion() {
    return fechaAplicacion;
  }

  public void setFechaAplicacion(Date pFechaAplicacion) {
    this.fechaAplicacion = pFechaAplicacion;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String pNombre) {
    this.nombre = pNombre;
  }
  
  public int getID() {
    return idVacuna;
  }

  public void setID(int pIdVacuna) {
    this.idVacuna = pIdVacuna;
  }

  public String getFarmaceutica() {
    return farmaceutica;
  }

  public void setFarmaceutica(String pFarmaceutica) {
    this.farmaceutica = pFarmaceutica;
  }

  public String getNumeroLote() {
    return numeroLote;
  }

  public void setNumeroLote(String pNumeroLote) {
    this.numeroLote = pNumeroLote;
  }
  
  
  
}
