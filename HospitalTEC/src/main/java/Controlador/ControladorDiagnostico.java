/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.CatalogoDiagnosticoBD;
import DAO.*;
import Vista.DiagnosticosSistema;
import Vista.VistaDoctor;
import Vista.VistaEnfermero;
import Vista.VistaSecretario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo
 */
public class ControladorDiagnostico implements ActionListener{
  String usuario;
  DiagnosticosSistema vistaDiagnosticosSistema;

  public ControladorDiagnostico(String usuario, DiagnosticosSistema vistaDiagnosticosSistema) {
    this.usuario = usuario;
    this.vistaDiagnosticosSistema = vistaDiagnosticosSistema;
    cargarComboBoxDiagnosticos();
    cargarComboBoxPacientes();
    
    this.vistaDiagnosticosSistema.btnBuscar.addActionListener(this);
    this.vistaDiagnosticosSistema.btnVolver.addActionListener(this);
  }
  
  @Override
  public void actionPerformed(ActionEvent e){
    switch(e.getActionCommand()){
      case "Buscar":
         try{
            cargarTabla();
            break;
          }catch (SQLException o){ 
            JOptionPane.showMessageDialog(null, o.toString()); 
            break;
          }
      case "Volver":
          asignarVentanaUsuario();
          break;
      default:
        break;       
    }
  }
  
  public void asignarVentanaUsuario(){
    UsuarioBD usuarioBD = new UsuarioBD();  
      int tipoUsuario = usuarioBD.retonarTipo(usuario);
      switch(tipoUsuario){
        case 3:
          VistaEnfermero VE = new VistaEnfermero();
          ControladorVistaEnfermero CVE = new ControladorVistaEnfermero(VE,usuario);
          CVE.vistaEnfermero.setVisible(true);
          vistaDiagnosticosSistema.dispose();
          break;
        case 4:
          VistaDoctor VD = new VistaDoctor();
          ControladorVistaDoctor CVD = new ControladorVistaDoctor(VD,usuario);
          CVD.vistaDoctor.setVisible(true);
          vistaDiagnosticosSistema.dispose();
          break;
        default:
          JOptionPane.showMessageDialog(vistaDiagnosticosSistema, "Ha ocurrido algo,"
                  + " por favor intent"
                  + "elo a iniciar sesión nuevamente.");
          break;
    }
  }
  
  public String cargarQuery(String fechaI, String fechaF, String nombre, String nivel, String paciente){
    String consulta = "SELECT CatalogoDiagnosticos.IdDiagnostico, "
            + "CatalogoDiagnosticos.NombreDiagnostico FROM Cita INNER JOIN "
            + "Paciente_Cita ON Cita.IdCita = Paciente_Cita.IdCita INNER JOIN "
            + "Cita_Diagnostico ON Cita.IdCita = Cita_Diagnostico.IdCita INNER "
            + "JOIN CatalogoDiagnosticos ON Cita_Diagnostico.IdDiagnostico = "
            + "CatalogoDiagnosticos.IdDiagnostico WHERE idPaciente = '" + 
            paciente + "'";
    if(fechaI != null){
      consulta += " AND fecha >= '" + fechaI + "'";
    }if(fechaF != null){
      consulta += " AND fecha <= '" + fechaF + "'";
    }if(!nombre.equals("-")){
      consulta += " AND NombreDiagnostico = '" + nombre + "'";
    }if(!nivel.equals("-")){
      consulta += " AND Nivel = '" + nivel + "'";
    }
    return consulta;
  }
  
  private String validarFecha(String dia, String mes, String ano){
    if(dia.equals("-") || mes.equals("-") || ano.equals("-")){
      return null;
    }else{
      return ano + "-" + mes + "-" + dia;
    }
  }
  
  private void cargarTabla() throws SQLException{
    String dia = (String) vistaDiagnosticosSistema.cbDiaInicio.getSelectedItem();
    String mes = (String) vistaDiagnosticosSistema.cbMesInicio.getSelectedItem();
    String ano = (String) vistaDiagnosticosSistema.cbAnoInicio.getSelectedItem();

    String fechaI = validarFecha(dia, mes, ano);
   
    String diaF = (String) vistaDiagnosticosSistema.cbDiaFin.getSelectedItem();
    String mesF = (String) vistaDiagnosticosSistema.cbMesFin.getSelectedItem();
    String anoF = (String) vistaDiagnosticosSistema.cbAnoFin.getSelectedItem();

    String fechaF = validarFecha(diaF, mesF, anoF);

    String nombre = (String) vistaDiagnosticosSistema.cbNombresDiagnosticos.getSelectedItem();
    String nivel = (String) vistaDiagnosticosSistema.cbNivel.getSelectedItem();
    String paciente = (String) vistaDiagnosticosSistema.cbPacientes.getSelectedItem();
    
    String consulta = cargarQuery(fechaI, fechaF, nombre, nivel, paciente);  

    DefaultTableModel modeloTabla = (DefaultTableModel) vistaDiagnosticosSistema.tablaDiagnosticosSistema.getModel();
    modeloTabla.setRowCount(0);
    
    Conexion conexion = new Conexion();
    ResultSet rs = conexion.consulta(consulta);
    int columnas = rs.getMetaData().getColumnCount();

    try{
      while(rs.next()){
      Object[] fila = new Object[columnas];
      for(int indice = 0; indice < columnas; indice++){
        fila[indice] = rs.getObject(indice+1);
      }
      modeloTabla.addRow(fila);
      }

    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
  
  private void cargarComboBoxDiagnosticos(){
      CatalogoDiagnosticoBD diagnosticosBD = new CatalogoDiagnosticoBD();
      ResultSet rs = diagnosticosBD.consultarDiagnosticos();
      vistaDiagnosticosSistema.cbNombresDiagnosticos.addItem("-");

      try{
        while(rs.next()){
          vistaDiagnosticosSistema.cbNombresDiagnosticos.addItem(rs.getString("NombreDiagnostico"));
        }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
      }
    }
  
  private void cargarComboBoxPacientes(){
      PacienteBD pacienteBD = new PacienteBD();
      ResultSet rs = pacienteBD.consultarPacientes();

      try{
        while(rs.next()){
          vistaDiagnosticosSistema.cbPacientes.addItem(rs.getString("idPaciente"));
        }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
      }
    }
}
