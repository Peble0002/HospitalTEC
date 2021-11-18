
package Modelo;

/**
 *Clase Area de Trabajo
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class AreaTrabajo {
  private int codigo;
  private String areaTrabajo;

  /**
   * Constructor del Area de Trabajo
   * @param pCodigo codigo del Area de Trabajo
   * @param pAreaTrabajo Nombre del Area de Trabajo 
   */
  public AreaTrabajo(int pCodigo, String pAreaTrabajo) {
    this.codigo = pCodigo;
    this.areaTrabajo = pAreaTrabajo;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int pCodigo) {
    this.codigo = pCodigo;
  }

  public String getAreaTrabajo() {
    return areaTrabajo;
  }

  public void setAreaTrabajo(String pAreaTrabajo) {
    this.areaTrabajo = pAreaTrabajo;
  }
  
  
  
  
}
