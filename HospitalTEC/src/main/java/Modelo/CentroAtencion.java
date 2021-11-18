
package Modelo;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Clase del Centro de Atencion
 * @author Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class CentroAtencion {
  private static final AtomicInteger contador = new AtomicInteger(0);
  private final int codigo;
  private String nombre;
  private String ubicacion;
  private int capacidad;
  private TipoCentro tipo;
  private ArrayList<Funcionario> trabajadores;

  /**
   * 
   * @param nombre
   * @param ubicacion
   * @param capacidad
   * @param pTipo 
   */
  public CentroAtencion(String pNombre, String pUbicacion, int pCapacidad, 
          TipoCentro pTipo) {
    this.nombre = pNombre;
    this.ubicacion = pUbicacion;
    this.capacidad = pCapacidad;
    this.tipo= pTipo;
    this.codigo = contador.incrementAndGet(); 
    this.trabajadores = new ArrayList<Funcionario>();
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String pNombre) {
    this.nombre = pNombre;
  }

  public String getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(String pUbicacion) {
    this.ubicacion = pUbicacion;
  }

  public int getCapacidad() {
    return capacidad;
  }

  public void setCapacidad(int pCapacidad) {
    this.capacidad = pCapacidad;
  }

  public TipoCentro getTipo() {
    return tipo;
  }

  public void setTipo(TipoCentro pTipo) {
    this.tipo = pTipo;
  }
  
  public void asignarFuncionario(Funcionario pFuncionario){
    trabajadores.add(pFuncionario);
  }

  public void setTrabajadores(ArrayList<Funcionario> trabajadores) {
    this.trabajadores = trabajadores;
  }
  
  
  
}
