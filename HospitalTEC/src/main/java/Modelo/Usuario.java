
package Modelo;

/**
 * Abstraccion de la clase usuario
 * @author Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public abstract class Usuario {
  protected int id;
  protected String contraseña;
  protected String nombre;
  protected String apellido1;
  protected String apellido2;

  /**
   * 
   * @param id
   * @param nombre 
   */
  public Usuario(int pId) {
    this.id = pId;
    
  }

  public Usuario(int id, String contraseña) {
    this.id = id;
    this.contraseña = contraseña;
  }

  public Usuario(int id, String contraseña, String nombre, 
          String apellido1, String apellido2) {
    this.id = id;
    this.contraseña = contraseña;
    this.nombre = nombre;
    this.apellido1 = apellido1;
    this.apellido2 = apellido2;
  }

  
  
  /**
   * 
   * @return 
   */
  public int getId() {
    return id;
  }

  /**
   * 
   * @param id 
   */
  public void setId(int pId) {
    this.id = pId;
  }

  /**
   * 
   * @return 
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * 
   * @param nombre 
   */
  public void setNombre(String pNombre) {
    this.nombre = pNombre;
  }

  /**
   * 
   * @return 
   */
  public String getApellido1() {
    return apellido1;
  }

  /**
   * 
   * @param apellido1 
   */
  public void setApellido1(String pApellido1) {
    this.apellido1 = pApellido1;
  }

  /**
   * 
   * @return 
   */
  public String getApellido2() {
    return apellido2;
  }

  /**
   * 
   * @param apellido2 
   */
  public void setApellido2(String pApellido2) {
    this.apellido2 = pApellido2;
  }
  
  
}
