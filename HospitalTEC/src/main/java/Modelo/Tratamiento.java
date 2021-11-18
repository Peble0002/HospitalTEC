
package Modelo;

/**
 *
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (22/11/2021)
 */
public class Tratamiento {
  private String nombre;
  private int dosis;
  private TipoTratamiento tipo;

  /**
   * Este constructor requiere indicar la dosis del tratamiento.
   * @param pNombre
   * @param pDosis
   * @param pTipo 
   */
  public Tratamiento(String pNombre, int pDosis, TipoTratamiento pTipo) {
    this.nombre = pNombre;
    this.dosis = pDosis;
    this.tipo = pTipo;
  }
  
  /**
   * Este constructor no requiere indicar la dosis del tratamiento.
   * @param pNombre
   * @param pTipo 
   */
  public Tratamiento(String pNombre, TipoTratamiento pTipo) {
    this.nombre = pNombre;
    this.dosis = 0;
    this.tipo = tipo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String pNombre) {
    this.nombre = pNombre;
  }

  public int getDosis() {
    return dosis;
  }

  public void setDosis(int pDosis) {
    this.dosis = pDosis;
  }

  public TipoTratamiento getTipo() {
    return tipo;
  }

  public void setTipo(TipoTratamiento pTipo) {
    this.tipo = pTipo;
  }
  
  
}
