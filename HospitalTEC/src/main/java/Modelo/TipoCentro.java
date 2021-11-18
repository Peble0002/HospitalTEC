
package Modelo;

/**
 * Clase Tipo Centro para generar los diferentes tipos de centros para el uso
 * de la aplicacion
 * @author Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class TipoCentro {
  private int codigo;
  private String tipo;

  /**
   * Constructor para la generacon de un tipo de centro
   * @param codigo codigo del centro
   * @param tipo  tipo de centro
   */
  public TipoCentro(int pCodigo, String pTipo) {
    this.codigo = pCodigo;
    this.tipo = pTipo;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int pCodigo) {
    this.codigo = pCodigo;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String pTipo) {
    this.tipo = pTipo;
  }
  
  
}
