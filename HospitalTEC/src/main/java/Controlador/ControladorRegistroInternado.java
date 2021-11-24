/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import DAO.*;
import Vista.*;
import Modelo.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author LUIS LEITON
 */
public class ControladorRegistroInternado implements ActionListener {
  public RegistroInternado vistaRegistroInternado;
  public String usuario;
  public String paciente;
    
  public ControladorRegistroInternado(RegistroInternado pVista, String pUsuario, String pPaciente){
    
    vistaRegistroInternado = pVista;
    usuario = pUsuario;
    paciente = pPaciente;
    
    this.vistaRegistroInternado.btnRegistrarInternado.addActionListener(this);
    this.vistaRegistroInternado.btnVolver.addActionListener(this);
    
  }
    
  @Override
  public void actionPerformed(ActionEvent e){
    switch(e.getActionCommand()){
      case "Registrar":
        registrarInternadoCita();
        break;
      case "Volver":
        AtenderCita AC = new AtenderCita();
        ControladorAtenderCita CAC = new ControladorAtenderCita(AC,usuario);
        CAC.vistaAtenderCita.setVisible(true);
        vistaRegistroInternado.dispose();
        break;
      default:
        break;       
    }
  }
  
   /*
    * carga el combobox
    */
  private void cargarComboBoxCentros(){
    CentroAtencionBD centroBD = new CentroAtencionBD();
    ResultSet rs = centroBD.consultarCentroAtencion();

    try{
      while(rs.next()){
        vistaRegistroInternado.cbCentroAtencion.addItem(rs.getString("Codigo") + " - " + rs.getString("nombreCentro"));
      }
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
  
  /*
   * carga el combobox
   */
  private void cargarComboBoxDiagnosticos(){
    CatalogoDiagnosticoBD diagnosticosBD = new CatalogoDiagnosticoBD();
    ResultSet rs = diagnosticosBD.consultarDiagnosticos();

    try{
      while(rs.next()){
        vistaRegistroInternado.cbDiagnosticos.addItem(rs.getString("IdDiagnostico") + " - "
                + rs.getString("NombreDiagnostico"));
      }
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
     
  public void registrarInternadoCita(){
    if(vistaRegistroInternado.datosCorrectos() == false){
      JOptionPane.showMessageDialog(vistaRegistroInternado, "Alguno de los "
              + "espacios de datos está vacío.");
    }else{
      CentroAtencion centroAtencion = (CentroAtencion) vistaRegistroInternado.cbCentroAtencion.getSelectedItem();
      String diagnostico = (String) vistaRegistroInternado.cbDiagnosticos.getSelectedItem();
      AreaTrabajo area = (AreaTrabajo) vistaRegistroInternado.cbEspecialidad.getSelectedItem();

      String dia = (String) vistaRegistroInternado.cbDia.getSelectedItem();
      String mes = (String) vistaRegistroInternado.cbMes.getSelectedItem();
      String ano = (String) vistaRegistroInternado.cbAno.getSelectedItem();

      int pDia = Integer.parseInt(dia);
      int pMes = Integer.parseInt(mes);
      int pAno = Integer.parseInt(ano);
      pAno = pAno-1900;
      pMes = pMes-1;
      Date fechaInicio = new Date(pAno,pMes,pDia);

      String diaF = (String) vistaRegistroInternado.cbDiaFin.getSelectedItem();
      String mesF = (String) vistaRegistroInternado.cbMesFin.getSelectedItem();
      String anoF = (String) vistaRegistroInternado.cbAnoFin.getSelectedItem();

      int pDiaF = Integer.parseInt(dia);
      int pMesF = Integer.parseInt(mes);
      int pAnoF = Integer.parseInt(ano);
      pAno = pAno-1900;
      pMes = pMes-1;
      Date fechaFin = new Date(pAno,pMes,pDia);
      Internado pInternado = new Internado(fechaInicio,fechaFin, area );
      InternadoBD internadobd = new InternadoBD();
      internadobd.insertarInternado(pInternado);
  //    Paciente paciente = new Paciente( fecha, tipoSangre, nacionalidad,  
  //            provincia,  canton, distrito,  telefono,  cedula, contrasena, 
  //            nombre,  apellido1, apellido2);
  //    pacienteBD.insertarPaciente(paciente);
    JOptionPane.showMessageDialog(vistaRegistroInternado, "REGISTRADO");    
    }  
  }
}
