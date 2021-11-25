/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.CatalogoDiagnosticoBD;
import DAO.Paciente_CitaBD;
import Vista.DiagnosticosAsociadosPaciente;
import Vista.VistaPaciente;
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
public class ControladorDiagnosticoPaciente  implements ActionListener{
  String usuario;
  DiagnosticosAsociadosPaciente vistaDiagnosticosAsociadosPaciente;

  public ControladorDiagnosticoPaciente(String usuario, DiagnosticosAsociadosPaciente vistaDiagnosticosAsociadosPaciente) {
    this.usuario = usuario;
    this.vistaDiagnosticosAsociadosPaciente = vistaDiagnosticosAsociadosPaciente;
    cargarComboBoxDiagnosticos();
    
    this.vistaDiagnosticosAsociadosPaciente.btnBuscar.addActionListener(this);
    this.vistaDiagnosticosAsociadosPaciente.btnVolver.addActionListener(this);
    
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
          VistaPaciente VP = new VistaPaciente();
          ControladorVistaPaciente CVP = new ControladorVistaPaciente(VP,usuario);
          CVP.vistaPacientes.setVisible(true);
          vistaDiagnosticosAsociadosPaciente.dispose();
          break;
      default:
        break;       
    }
  }
  
  public String cargarQuery(String fechaI, String fechaF, String nivel, String nombreDiagnostico){
    String consulta = "SELECT CatalogoDiagnosticos.IdDiagnostico, "
            + "CatalogoDiagnosticos.NombreDiagnostico FROM Cita INNER JOIN "
            + "Paciente_Cita ON Cita.IdCita = Paciente_Cita.IdCita INNER JOIN "
            + "Cita_Diagnostico ON Cita.IdCita = Cita_Diagnostico.IdCita INNER "
            + "JOIN CatalogoDiagnosticos ON Cita_Diagnostico.IdDiagnostico = "
            + "CatalogoDiagnosticos.IdDiagnostico WHERE idPaciente = '" + 
            usuario + "'";
    if(fechaI != null){
      consulta += " AND fecha >= '" + fechaI + "'";
    }if(fechaF != null){
      consulta += " AND fecha <= '" + fechaF + "'";
    }if(!nivel.equals("-")){
      consulta += " AND Nivel = '" + nivel + "'";
    }if(!nombreDiagnostico.equals("-")){
      consulta += " AND NombreDiagnostico LIKE '%" + nombreDiagnostico + "%'";
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
    String dia = (String) vistaDiagnosticosAsociadosPaciente.cbDiaInicio.getSelectedItem();
    String mes = (String) vistaDiagnosticosAsociadosPaciente.cbMesInicio.getSelectedItem();
    String ano = (String) vistaDiagnosticosAsociadosPaciente.cbAnoInicio.getSelectedItem();

    String fechaI = validarFecha(dia, mes, ano);
   
    String diaF = (String) vistaDiagnosticosAsociadosPaciente.cbDiaFin.getSelectedItem();
    String mesF = (String) vistaDiagnosticosAsociadosPaciente.cbMesFin.getSelectedItem();
    String anoF = (String) vistaDiagnosticosAsociadosPaciente.cbAnoFin.getSelectedItem();

    String fechaF = validarFecha(diaF, mesF, anoF);

    String nivel = (String) vistaDiagnosticosAsociadosPaciente.cbNivel.getSelectedItem();
    String nombreDiagnostico = (String) vistaDiagnosticosAsociadosPaciente.cbNombreDiagnosticos.getSelectedItem();
    
    String consulta = cargarQuery(fechaI, fechaF, nivel, nombreDiagnostico);    

    DefaultTableModel modeloTabla = (DefaultTableModel) vistaDiagnosticosAsociadosPaciente.tablaDiagnosticos.getModel();
    modeloTabla.setRowCount(0);
    
    Paciente_CitaBD pacienteBD = new Paciente_CitaBD ();
    ResultSet rs = pacienteBD.consultarCitasPaciente(consulta);
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
      vistaDiagnosticosAsociadosPaciente.cbNombreDiagnosticos.addItem("-");

      try{
        while(rs.next()){
          vistaDiagnosticosAsociadosPaciente.cbNombreDiagnosticos.addItem(rs.getString("IdDiagnostico") + " - "
                  + rs.getString("NombreDiagnostico"));
        }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
      }
    }
}
