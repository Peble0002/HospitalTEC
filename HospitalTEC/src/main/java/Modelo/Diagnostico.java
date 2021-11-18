
package Modelo;

/**
 * Clase para los diagnosticos
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class Diagnostico {
  private CatalogoDiagnostico nombreDiagnostico;
  private Nivel nivel;
  private String observaciones;

  public Diagnostico(CatalogoDiagnostico pNombreDiagnostico, Nivel pNivel,
          String pObservaciones) {
    this.nombreDiagnostico = pNombreDiagnostico;
    this.nivel = pNivel;
    this.observaciones = pObservaciones;
  }

  public CatalogoDiagnostico getNombreDiagnostico() {
    return nombreDiagnostico;
  }

  public void setNombreDiagnostico(CatalogoDiagnostico pNombreDiagnostico) {
    this.nombreDiagnostico = pNombreDiagnostico;
  }

  public Nivel getNivel() {
    return nivel;
  }

  public void setNivel(Nivel pNivel) {
    this.nivel = pNivel;
  }

  public String getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(String pObservaciones) {
    this.observaciones = pObservaciones;
  }
  
  
}
