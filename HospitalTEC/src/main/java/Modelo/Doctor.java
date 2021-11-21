
package Modelo;

import static Modelo.TipoFuncionario.Doctor;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase doctor hija de funcionario
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public final class Doctor extends Funcionario {
  private String codigoMedico;
  private ArrayList<String> especialidades;

  public Doctor(String codigoMedico, ArrayList<String> especialidades, 
          TipoFuncionario pTipo, Date pFechaIngreso, String pId) {
    super(pTipo, pFechaIngreso, pId);
    this.codigoMedico = codigoMedico;
    this.especialidades = especialidades;
  }

  public Doctor(String codigoMedico, ArrayList<String> especialidades,
          TipoFuncionario tipo, Date fechaIngreso, AreaTrabajo area, 
          CentroAtencion centro, String pId) {
    super(tipo, fechaIngreso, area, centro, pId);
    this.codigoMedico = codigoMedico;
    this.especialidades = especialidades;
  }

  public Doctor(String codigoMedico, ArrayList<String> especialidades,
          TipoFuncionario tipo, Date fechaIngreso, AreaTrabajo area,
          CentroAtencion centro, String id, String contrasena) {
    super(tipo, fechaIngreso, area, centro, id, contrasena);
    this.codigoMedico = codigoMedico;
    this.especialidades = especialidades;
  }

  public Doctor(String codigoMedico, ArrayList<String> especialidades,
          TipoFuncionario tipo, Date fechaIngreso, AreaTrabajo area, 
          CentroAtencion centro, String id, String contrasena, String nombre, 
          String apellido1, String apellido2) {
    super(tipo, fechaIngreso, area, centro, id, contrasena, nombre, apellido1,
            apellido2);
    this.codigoMedico = codigoMedico;
    this.especialidades = especialidades;
  }

  public Doctor(String codigoMedico, ArrayList<String> especialidades, 
          Date pFechaIngreso, String pId) {
    super(pFechaIngreso, pId);
    this.codigoMedico = codigoMedico;
    this.especialidades = especialidades;
  }

  public Doctor(String codigoMedico, TipoFuncionario pTipo, Date pFechaIngreso,
          String pId, String especialidad) {
    super(pTipo, pFechaIngreso, pId);
    this.codigoMedico = codigoMedico;
    this.especialidades.add(especialidad);
  }

  public Doctor(String codigoMedico, TipoFuncionario tipo, Date fechaIngreso,
          AreaTrabajo area, CentroAtencion centro, String pId, String especialidad) {
    super(tipo, fechaIngreso, area, centro, pId);
    this.codigoMedico = codigoMedico;
    this.especialidades.add(especialidad);
  }

  public Doctor(String codigoMedico, TipoFuncionario tipo, 
          Date fechaIngreso, AreaTrabajo area, CentroAtencion 
                  centro, String id, String contrasena, String especialidad) {
    super(tipo, fechaIngreso, area, centro, id, contrasena);
    this.codigoMedico = codigoMedico;
    this.especialidades.add(especialidad);
  }

  public Doctor(String codigoMedico, TipoFuncionario tipo, Date fechaIngreso, 
          AreaTrabajo area, CentroAtencion centro, String id, String contrasena, 
          String nombre, String apellido1, String apellido2, String especialidad) {
    super(tipo, fechaIngreso, area, centro, id, contrasena, nombre, apellido1, apellido2);
    this.codigoMedico = codigoMedico;
    this.especialidades.add(especialidad);
  }

  public Doctor(String codigoMedico, Date pFechaIngreso, String pId, 
          String especialidad) {
    super(pFechaIngreso, pId);
    this.codigoMedico = codigoMedico;
    this.especialidades.add(especialidad);
  }

  
  
  public String getCodigoMedico() {
    return codigoMedico;
  }

  public void setCodigoMedico(String codigoMedico) {
    this.codigoMedico = codigoMedico;
  }

  public ArrayList<String> getEspecialidad() {
    return especialidades;
  }

  public void setEspecialidad(ArrayList<String> especialidad) {
    this.especialidades = especialidad;
  }
  
  public void agregarEspecialidad(String pEspecialidad){
    especialidades.add(pEspecialidad);
  }
  
}
