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
public class ControladorDiagnosticoPaciente implements ActionListener {
  public RegistrarDiagnosticoPaciente vistaDiagnosticoPaciente;
  public String usuario;
  public String paciente;
    
  public ControladorDiagnosticoPaciente(RegistrarDiagnosticoPaciente pVista, String pUsuario, String pPaciente){
    
    vistaDiagnosticoPaciente = pVista;
    usuario = pUsuario;
    paciente = pPaciente;
    cargarComboBoxDiagnosticos();
    cargarComboBoxCitas();
    
    this.vistaDiagnosticoPaciente.btnRegistrarDiagnostico.addActionListener(this);
    this.vistaDiagnosticoPaciente.btnVolver.addActionListener(this);
    this.vistaDiagnosticoPaciente.btnCargar.addActionListener(this);
    
    
  }
    
     @Override
     public void actionPerformed(ActionEvent e){
       switch(e.getActionCommand()){
        case "Registrar":
          registrarDiagnosticoCita();
          break;
        case "Cargar":
          registrarDiagnosticoCita();
          break;
        case "Volver":
            AtenderCita AC = new AtenderCita();
            ControladorAtenderCita CAC = new ControladorAtenderCita(AC,usuario);
            CAC.vistaAtenderCita.setVisible(true);
            vistaDiagnosticoPaciente.dispose();
            break;
        default:
            break;       
    }
  }
     
      /*
     * carga el combobox
     */
    private void cargarComboBoxTratamientosDiagnosticos(){
        
      String diagnostico = (String) vistaDiagnosticoPaciente.cbDiagnosticoPaciente.getSelectedItem();
      String id = diagnostico.substring(0, diagnostico.indexOf("-")-1);
      
      int codigo = Integer.parseInt(id);
      
      TratamientoBD tratamientosBD = new TratamientoBD();
      ResultSet rs = tratamientosBD.consultarTratamientosDiagnostico(codigo);
      
      try{
        while(rs.next()){
         vistaDiagnosticoPaciente.cbTratamiento.addItem(rs.getString("IdTratamiento") + " - "
                  + rs.getString("Nombre"));
        }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
      }
    }
     
       /* carga el combobox*/
    private void cargarComboBoxDiagnosticos(){
      CatalogoDiagnosticoBD diagnosticosBD = new CatalogoDiagnosticoBD();
      ResultSet rs = diagnosticosBD.consultarDiagnosticos();

      try{
        while(rs.next()){
          vistaDiagnosticoPaciente.cbDiagnosticoPaciente.addItem(rs.getString("IdDiagnostico") + " - "
                  + rs.getString("NombreDiagnostico"));
        }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
      }
    }
    
    private void cargarComboBoxCitas(){
      CitaBD citasBD = new CitaBD();
      ResultSet rs = citasBD.consultarIdCitasRegistradas(paciente);

      try{
        while(rs.next()){
          vistaDiagnosticoPaciente.cbCitas.addItem(rs.getString("IdCita"));
        }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
      }
    }
     
  public void registrarDiagnosticoCita(){
      
    String dosis1 = vistaDiagnosticoPaciente.tbDosis.getText();
    String obs  = vistaDiagnosticoPaciente.tbObservacion.getText();
    String cita = (String) vistaDiagnosticoPaciente.cbCitas.getSelectedItem();
    int codCita = Integer.parseInt(cita); // ID CITA
    
    String tratamiento = (String) vistaDiagnosticoPaciente.cbDiagnosticoPaciente.getSelectedItem();
    String idT = tratamiento.substring(0, tratamiento.indexOf("-")-1);

    int codigoT = Integer.parseInt(idT); // ID TRATAMIENTO
    
    if( dosis1.equals("")|| obs.equals("")){
     JOptionPane.showMessageDialog(vistaDiagnosticoPaciente, "Se debe ingresar "
               + "un número de teléfono"); 
    }else{
    String diagnostico = (String) vistaDiagnosticoPaciente.cbDiagnosticoPaciente.getSelectedItem();
    String id = diagnostico.substring(0, diagnostico.indexOf("-")-1);
      
    int codigo = Integer.parseInt(id); // ID DIAGNOSTICO
    CatalogoDiagnosticoBD catalogo = new CatalogoDiagnosticoBD();
    CatalogoDiagnostico catalogoDiagnostico = catalogo.consultarDiagnostico(codigo);    
    
    Nivel nivel = (Nivel) vistaDiagnosticoPaciente.cbNivel.getSelectedItem(); 
    String observaciones = vistaDiagnosticoPaciente.tbObservacion.getText();
    String dosis = vistaDiagnosticoPaciente.tbDosis.getText();
    
    Diagnostico diagnostico1 = new Diagnostico(catalogoDiagnostico,nivel,observaciones, dosis);
    
    Cita_DiagnosticoBD cita_DiagnosticoBD = new Cita_DiagnosticoBD();
    cita_DiagnosticoBD.insertarCitaDiagnostico(diagnostico1, codCita, codigoT);
    
    JOptionPane.showMessageDialog(vistaDiagnosticoPaciente, "REGISTRADO");    
  }
  }
}
