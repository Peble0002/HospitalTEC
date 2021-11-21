
package Modelo;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Clase funcionario hija de usuario
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class Funcionario extends Usuario{
  protected TipoFuncionario tipo;
  protected Date fechaIngreso;
  protected AreaTrabajo area;
  protected CentroAtencion centro;

  /**
   * 
   * @param Tipo
   * @param fechaIngreso
   * @param pId 
   */
  public Funcionario(TipoFuncionario pTipo, Date pFechaIngreso, String pId) {
    super(pId);
    this.tipo = pTipo;
    this.fechaIngreso = fechaIngreso;
  }

  public Funcionario(TipoFuncionario tipo, Date fechaIngreso, AreaTrabajo area, CentroAtencion centro, String pId) {
    super(pId);
    this.tipo = tipo;
    this.fechaIngreso = fechaIngreso;
    this.area = area;
    this.centro = centro;
  }

  public Funcionario(TipoFuncionario tipo, Date fechaIngreso, AreaTrabajo area, CentroAtencion centro, String id, String contrasena) {
    super(id, contrasena);
    this.tipo = tipo;
    this.fechaIngreso = fechaIngreso;
    this.area = area;
    this.centro = centro;
  }

  public Funcionario(TipoFuncionario tipo, Date fechaIngreso, AreaTrabajo area, CentroAtencion centro, String id, String contrasena, String nombre, String apellido1, String apellido2) {
    super(id, contrasena, nombre, apellido1, apellido2);
    this.tipo = tipo;
    this.fechaIngreso = fechaIngreso;
    this.area = area;
    this.centro = centro;
  }
  
   
  public Funcionario(Date pFechaIngreso, String pId) {
    super(pId);
    this.fechaIngreso = fechaIngreso;
  }

  
  
  public TipoFuncionario getTipo() {
    return tipo;
  }

  public void setTipo(TipoFuncionario pTipo) {
    this.tipo = pTipo;
  }

  public Date getFechaIngreso() {
    return fechaIngreso;
  }

  public void setFechaIngreso(Date pFechaIngreso) {
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

  public String getId() {
    return id;
  }

  public void setId(String pId) {
    this.id = pId;
  }

  public String getContraseña() {
    return contrasena;
  }

  public void setContraseña(String pContraseña) {
    this.contrasena = pContraseña;
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
