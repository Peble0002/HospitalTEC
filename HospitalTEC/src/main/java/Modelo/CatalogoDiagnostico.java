
package Modelo;

/**
 *Clase para los Catalogos de Diagostico
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class CatalogoDiagnostico {
  private String idDiagnostico;
  private String nombreDiagnostico;

  /**
   * Constructor del Catalogo
   * @param pIdDiagnostico Id del diagnostico
   * @param pNombreDiagnostico nombre del diagnostico
   */
  public CatalogoDiagnostico(String pIdDiagnostico, String pNombreDiagnostico) {
    this.idDiagnostico = pIdDiagnostico;
    this.nombreDiagnostico = pNombreDiagnostico;
  }
  
  public CatalogoDiagnostico(String pNombreDiagnostico) {
    this.nombreDiagnostico = pNombreDiagnostico;
  }

  public String getIdDiagnostico() {
    return idDiagnostico;
  }

  public void setIdDiagnostico(String pIdDiagnostico) {
    this.idDiagnostico = pIdDiagnostico;
  }

  public String getNombreDiagnostico() {
    return nombreDiagnostico;
  }

  public void setNombreDiagnostico(String pNombreDiagnostico) {
    this.nombreDiagnostico = pNombreDiagnostico;
  }
  
  
}
