/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.*;
import DAO.Conexion;
import Vista.TratamientosAsociadosPaciente;
import Vista.*;
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
public class ControladorTratamientosPaciente implements ActionListener {
  String usuario;
  TratamientosAsociadosPaciente vistaTratamientosAsociados;

  public ControladorTratamientosPaciente(String usuario, TratamientosAsociadosPaciente vistaTratamientosSistema) {
    this.usuario = usuario;
    this.vistaTratamientosAsociados = vistaTratamientosSistema;
    cargarComboBoxTratamiento();
    
    this.vistaTratamientosAsociados.btnBuscar.addActionListener(this);
    this.vistaTratamientosAsociados.btnVolver.addActionListener(this);
    
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
          vistaTratamientosAsociados.dispose();
          break;
      default:
        break;       
    }
  }
  
  public String cargarQuery(String fechaI, String fechaF, String tipo, String nombreTratamiento){
    String consulta = "SELECT CatalogoTratamientos.IdTratamiento, "
            + "CatalogoTratamientos.Nombre FROM Cita INNER JOIN Paciente_Cita "
            + "ON Cita.IdCita = Paciente_Cita.IdCita INNER JOIN Cita_Diagnostico "
            + "ON Cita.IdCita = Cita_Diagnostico.IdCita INNER JOIN "
            + "CatalogoTratamientos ON Cita_Diagnostico.IdTratamiento = "
            + "CatalogoTratamientos.IdTratamiento WHERE idPaciente = '" + 
            usuario + "'";
    if(fechaI != null){
      consulta += " AND fecha >= '" + fechaI + "'";
    }if(fechaF != null){
      consulta += " AND fecha <= '" + fechaF + "'";
    }if(!nombreTratamiento.equals("-")){
      consulta += " AND CatalogoTratamientos.Nombre = '" + nombreTratamiento + "'";
    }if(!tipo.equals("-")){
      consulta += " AND Cita_Diagnostico.Dosis = '" + tipo + "'";
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
    String dia = (String) vistaTratamientosAsociados.cbDiaInicio.getSelectedItem();
    String mes = (String) vistaTratamientosAsociados.cbMesInicio.getSelectedItem();
    String ano = (String) vistaTratamientosAsociados.cbAnoInicio.getSelectedItem();

    String fechaI = validarFecha(dia, mes, ano);
   
    String diaF = (String) vistaTratamientosAsociados.cbDiaFin.getSelectedItem();
    String mesF = (String) vistaTratamientosAsociados.cbMesFin.getSelectedItem();
    String anoF = (String) vistaTratamientosAsociados.cbAnoFin.getSelectedItem();

    String fechaF = validarFecha(diaF, mesF, anoF);

    String tipo = (String) vistaTratamientosAsociados.cbTipo.getSelectedItem();
    String nombreTratamiento = (String) vistaTratamientosAsociados.cbNombreTratamiento.getSelectedItem();
    
    String consulta = cargarQuery(fechaI, fechaF, tipo, nombreTratamiento);    

    DefaultTableModel modeloTabla = (DefaultTableModel) vistaTratamientosAsociados.tablaTratamientos.getModel();
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
  private void cargarComboBoxTratamiento(){
      TratamientoBD tratamientos = new TratamientoBD();
      ResultSet rs = tratamientos.consultarTratamientos();
      vistaTratamientosAsociados.cbNombreTratamiento.addItem("-");

      try{
        while(rs.next()){
          vistaTratamientosAsociados.cbNombreTratamiento.addItem(rs.getString("Nombre"));
        }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
      }
    }
}
