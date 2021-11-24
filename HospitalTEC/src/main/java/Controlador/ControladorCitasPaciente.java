/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.Paciente_CitaBD;
import Vista.CitasAsociadasPaciente;
import Vista.VistaPaciente;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo
 */
public class ControladorCitasPaciente {
  String usuario;
  CitasAsociadasPaciente vistaCitasAsociadasPaciente;

  public ControladorCitasPaciente(String usuario, CitasAsociadasPaciente vistaCitasAsociadasPaciente) {
    this.usuario = usuario;
    this.vistaCitasAsociadasPaciente = vistaCitasAsociadasPaciente;
  }
  
     public void actionPerformed(ActionEvent e) throws SQLException{
       switch(e.getActionCommand()){
        case "Buscar":
          cargarTabla();
          break;
        case "Volver":
           //FaltaVolver
            break;
        default:
            break;       
    }
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
  
}
