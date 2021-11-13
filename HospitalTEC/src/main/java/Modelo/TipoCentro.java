/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Pablo Chaves, Aaron Soto y Luis Leitón
 */
class TipoCentro {
  private int codigo;
  private String tipo;

  /**
   * 
   * @param codigo
   * @param tipo 
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
