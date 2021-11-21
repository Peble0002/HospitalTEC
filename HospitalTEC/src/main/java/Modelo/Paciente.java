
package Modelo;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 * Clase Paciente hija de Usuario
 * @author Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public class Paciente extends Usuario{
  private LocalDate fechaNacimiento;
  private String tipoSangre;
  private String nacionalidad;
  private String provincia;
  private String canton;
  private String distrito;
  //revisar la generic
  private ArrayList<String> telefonos;
  private ArrayList<Vacuna> vacunas;
  private ArrayList<CentroAtencion> centros; 

  /**
   * 
   * @param pFechaNacimiento
   * @param pTipoSangre
   * @param pNacionalidad
   * @param pId 
   */
  public Paciente(LocalDate pFechaNacimiento, String pTipoSangre,
          String pNacionalidad, String pId, String pTelefono) {
    super(pId);
    this.fechaNacimiento = pFechaNacimiento;
    this.tipoSangre = pTipoSangre;
    this.nacionalidad = pNacionalidad;
    this.telefonos= new ArrayList<String>();
    this.vacunas= new ArrayList<Vacuna>();
    this.centros= new ArrayList<CentroAtencion>();
    telefonos.add(pTelefono);
  }
  
  public Paciente(int pDia, int pMes, int pAno, String tipoSangre, 
          String nacionalidad, String pId, String pTelefono) {
    super(pId);
    this.fechaNacimiento = LocalDate.of(pAno, pMes, pDia);
    this.tipoSangre = tipoSangre;
    this.nacionalidad = nacionalidad;
    this.telefonos= new ArrayList<String>();
    telefonos.add(pTelefono);
    this.vacunas= new ArrayList<Vacuna>();
    this.centros= new ArrayList<CentroAtencion>();
    
  }

  public Paciente(LocalDate fechaNacimiento, String tipoSangre, 
          String nacionalidad, String provincia, String canton, 
          String distrito, String pTelefono, String id, 
          String contrasena, String nombre, String apellido1, 
          String apellido2) {
    super(id, contrasena, nombre, apellido1, apellido2);
    this.fechaNacimiento = fechaNacimiento;
    this.tipoSangre = tipoSangre;
    this.nacionalidad = nacionalidad;
    this.provincia = provincia;
    this.canton = canton;
    this.distrito = distrito;
    this.telefonos = telefonos;
    this.telefonos= new ArrayList<String>();
    telefonos.add(pTelefono);
    this.vacunas= new ArrayList<Vacuna>();
    this.centros= new ArrayList<CentroAtencion>();
  }
  
  

  public LocalDate getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(int pDia, int pMes, int pAno) {
    this.fechaNacimiento = LocalDate.of(pAno, pMes, pDia);
  }

  public String getTipoSangre() {
    return tipoSangre;
  }

  public void setTipoSangre(String pTipoSangre) {
    this.tipoSangre = pTipoSangre;
  }

  public String getNacionalidad() {
    return nacionalidad;
  }

  public void setNacionalidad(String pNacionalidad) {
    this.nacionalidad = pNacionalidad;
  }

  public String getProvincia() {
    return provincia;
  }

  public void setProvincia(String provincia) {
    this.provincia = provincia;
  }

  public String getCanton() {
    return canton;
  }

  public void setCanton(String canton) {
    this.canton = canton;
  }

  public String getDistrito() {
    return distrito;
  }

  public void setDistrito(String distrito) {
    this.distrito = distrito;
  }

  public ArrayList<String> getTelefonos() {
    return telefonos;
  }

  public void setTelefonos(String telefonos) {
    this.telefonos.add(nombre);
  }

  public ArrayList<Vacuna> getVacunas() {
    return vacunas;
  }

  public void setVacunas(Vacuna vacunas) {
    this.vacunas.add(vacunas);
  }
  
  public void asignarDireccion(){
    
  }

  /**
   * Agrega los centros del paciente
   * @param pCentro 
   */
  public void asignarCentro(CentroAtencion pCentro){
    centros.add(pCentro);
  }

  public ArrayList<CentroAtencion> getCentros() {
    return centros;
  }

  public void setCentros(ArrayList<CentroAtencion> centros) {
    this.centros = centros;
  }
}
