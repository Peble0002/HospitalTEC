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
  private String Tipo;

  /**
   * 
   * @param codigo
   * @param Tipo 
   */
  public TipoCentro(int codigo, String Tipo) {
    this.codigo = codigo;
    this.Tipo = Tipo;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getTipo() {
    return Tipo;
  }

  public void setTipo(String Tipo) {
    this.Tipo = Tipo;
  }
  
  
}
