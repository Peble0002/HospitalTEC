
package Modelo;

import static Modelo.TipoFuncionario.Doctor;
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

  /**
   * 
   * @param pCodigoMedico
   * @param pEspecialidad
   * @param pTipo
   * @param pFechaIngreso
   * @param pId 
   */
  public Doctor(String pCodigoMedico, String pEspecialidad, 
          LocalDate pFechaIngreso, int pId) {
    super(pFechaIngreso, pId);
    this.codigoMedico = codigoMedico;
    this.especialidades.add(pEspecialidad);
    super.setTipo(Doctor);
  }

  public Doctor(String pCodigoMedico, String pEspecialidad, int pDia, 
          int pMes, int pAno, int pId) {
    super( pDia, pMes, pAno, pId);
    this.codigoMedico = codigoMedico;
    this.especialidades.add(pEspecialidad);
    super.setTipo(Doctor);
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
