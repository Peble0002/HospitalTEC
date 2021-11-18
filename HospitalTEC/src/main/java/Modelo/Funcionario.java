
package Modelo;

import java.time.LocalDate;

/**
 * Clase funcionario hija de usuario
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class Funcionario extends Usuario{
  protected TipoFuncionario tipo;
  protected LocalDate fechaIngreso;
  protected AreaTrabajo area;
  protected CentroAtencion centro;

  /**
   * 
   * @param Tipo
   * @param fechaIngreso
   * @param pId 
   */
  public Funcionario(TipoFuncionario pTipo, LocalDate pFechaIngreso, int pId) {
    super(pId);
    this.tipo = pTipo;
    this.fechaIngreso = fechaIngreso;
  }
  
  public Funcionario(LocalDate pFechaIngreso, int pId) {
    super(pId);
    this.fechaIngreso = fechaIngreso;
  }

  public Funcionario(TipoFuncionario pTipo, int pDia, int pMes, int pAno, 
          int pId) {
    super(pId);
    this.tipo = pTipo;
    this.fechaIngreso = LocalDate.of(pAno, pMes, pDia);
  }
  public Funcionario(int pDia, int pMes, int pAno, 
          int pId) {
    super(pId);
    this.fechaIngreso = LocalDate.of(pAno, pMes, pDia);
  }
  
  public TipoFuncionario getTipo() {
    return tipo;
  }

  public void setTipo(TipoFuncionario pTipo) {
    this.tipo = pTipo;
  }

  public LocalDate getFechaIngreso() {
    return fechaIngreso;
  }

  public void setFechaIngreso(LocalDate pFechaIngreso) {
    this.fechaIngreso = pFechaIngreso;
  }

  public AreaTrabajo getArea() {
    return area;
  }

  public void setArea(AreaTrabajo pArea) {
    this.area = pArea;
  }

  public CentroAtencion getCentro() {
    return centro;
  }

  public void setCentro(CentroAtencion pCentro) {
    this.centro = pCentro;
  }

  public int getId() {
    return id;
  }

  public void setId(int pId) {
    this.id = pId;
  }

  public String getContraseña() {
    return contraseña;
  }

  public void setContraseña(String pContraseña) {
    this.contraseña = pContraseña;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String pNombre) {
    this.nombre = pNombre;
  }

  public String getApellido1() {
    return apellido1;
  }

  public void setApellido1(String pApellido1) {
    this.apellido1 = pApellido1;
  }

  public String getApellido2() {
    return apellido2;
  }

  public void setApellido2(String pApellido2) {
    this.apellido2 = pApellido2;
  }
  
  
  
  
  
}
