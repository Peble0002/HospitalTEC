/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.AreaTrabajoBD;
import DAO.Paciente_CitaBD;
import Vista.CitasAsociadasPaciente;
import Vista.Principal;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo
 */
public class ControladorCitasPaciente implements ActionListener {
  String usuario;
  CitasAsociadasPaciente vistaCitasAsociadasPaciente;

  public ControladorCitasPaciente(String usuario, CitasAsociadasPaciente vistaCitasAsociadasPaciente) {
    this.usuario = usuario;
    this.vistaCitasAsociadasPaciente = vistaCitasAsociadasPaciente;
    cargarComboBoxAreaTrabajo();
    this.vistaCitasAsociadasPaciente.btnVolver.addActionListener(this);
    this.vistaCitasAsociadasPaciente.btnBuscar.addActionListener(this);
    
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
          vistaCitasAsociadasPaciente.dispose();
          break;
      default:
        break;       
    }
  }
  //FALTA
  public String cargarQuery(){
    String consulta = "SELECT Cita.IdCita, fecha, hora, observaciones, estado,"
            +" especialidad, correo"  
	+ " FROM Cita INNER JOIN Paciente_Cita ON Cita.IdCita = Paciente_Cita.IdCita" 
		+" WHERE idPaciente = '305110992'";
  }
  
  private void cargarTabla() throws SQLException{
    String dia = (String) vistaCitasAsociadasPaciente.cbDiaInicio.getSelectedItem();
    String mes = (String) vistaCitasAsociadasPaciente.cbMesInicio.getSelectedItem();
    String ano = (String) vistaCitasAsociadasPaciente.cbAnoInicio.getSelectedItem();
    int pDiaInicio = Integer.parseInt(dia);
    int pMesInicio = Integer.parseInt(mes);
    int pAnoInicio = Integer.parseInt(ano);
    pAnoInicio = pAnoInicio-1900;
    pMesInicio = pMesInicio-1;
    Date fechaInicio = new Date(pDiaInicio,pMesInicio,pAnoInicio);
   
    dia = (String) vistaCitasAsociadasPaciente.cbDiaFin.getSelectedItem();
    mes = (String) vistaCitasAsociadasPaciente.cbMesFin.getSelectedItem();
    ano = (String) vistaCitasAsociadasPaciente.cbAnoFin.getSelectedItem();
    int pDiaFin = Integer.parseInt(dia);
    int pMesFin = Integer.parseInt(mes);
    int pAnoFin = Integer.parseInt(ano);
    pAnoFin = pAnoFin-1900;
    pMesFin = pMesFin-1;
    Date fechaFin = new Date(pDiaFin,pMesFin,pAnoFin);

    String estado = (String) vistaCitasAsociadasPaciente.cbEstado.getSelectedItem();
    String Areas = (String) vistaCitasAsociadasPaciente.cbAreas.getSelectedItem();
    

    DefaultTableModel modeloTabla = (DefaultTableModel) vistaCitasAsociadasPaciente.tablaCitasPaciente.getModel();
    modeloTabla.setRowCount(0);
    
    Paciente_CitaBD pacienteBD = new Paciente_CitaBD ();
    ResultSet rs = pacienteBD.consultarCitasPaciente();
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
  
  private void cargarComboBoxAreaTrabajo(){
      AreaTrabajoBD areaBD = new AreaTrabajoBD();
      ResultSet rs = areaBD.consultarAreasTrabajo();
      vistaCitasAsociadasPaciente.cbAreas.addItem("-");
      try{
        while(rs.next()){
          vistaCitasAsociadasPaciente.cbAreas.addItem(rs.getString("codigo") 
                  + " - " + rs.getString("NombreArea"));
        }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
      }
    }
  
}
