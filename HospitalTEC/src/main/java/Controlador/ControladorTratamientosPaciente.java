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
  TratamientosAsociadosPaciente vistaTratamientosSistema;

  public ControladorTratamientosPaciente(String usuario, TratamientosAsociadosPaciente vistaTratamientosSistema) {
    this.usuario = usuario;
    this.vistaTratamientosSistema = vistaTratamientosSistema;
    
    this.vistaTratamientosSistema.btnBuscar.addActionListener(this);
    this.vistaTratamientosSistema.btnVolver.addActionListener(this);
    
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
          vistaTratamientosSistema.dispose();
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
    }if(!tipo.equals("-")){
      consulta += " AND CatalogoTratamientos.Nombre = '%" + tipo + "%'";
    }if(!nombreTratamiento.equals("-")){
      consulta += " AND Cita_Diagnostico.Dosis LIKE '%" + nombreTratamiento + "%'";
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
    String dia = (String) vistaTratamientosSistema.cbDiaInicio.getSelectedItem();
    String mes = (String) vistaTratamientosSistema.cbMesInicio.getSelectedItem();
    String ano = (String) vistaTratamientosSistema.cbAnoInicio.getSelectedItem();

    String fechaI = validarFecha(dia, mes, ano);
   
    String diaF = (String) vistaTratamientosSistema.cbDiaFin.getSelectedItem();
    String mesF = (String) vistaTratamientosSistema.cbMesFin.getSelectedItem();
    String anoF = (String) vistaTratamientosSistema.cbAnoFin.getSelectedItem();

    String fechaF = validarFecha(diaF, mesF, anoF);

    String tipo = (String) vistaTratamientosSistema.cbTipo.getSelectedItem();
    String nombreTratamiento = (String) vistaTratamientosSistema.cbNombreTratamiento.getSelectedItem();
    
    String consulta = cargarQuery(fechaI, fechaF, tipo, nombreTratamiento);    

    DefaultTableModel modeloTabla = (DefaultTableModel) vistaTratamientosSistema.tablaTratamientos.getModel();
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
      TratamientoBD tratamientos = new TratamientoBD();
      ResultSet rs = tratamientos.consultarTratamientos();
      vistaTratamientosSistema.cbNombreTratamiento.addItem("-");

      try{
        while(rs.next()){
          vistaTratamientosSistema.cbNombreTratamiento.addItem(rs.getString("NombreDiagnostico"));
        }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
      }
    }
}
