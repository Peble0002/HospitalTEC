/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.*;
import Vista.TratamientosSistema;
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
public class ControladorTratamientos implements ActionListener{
  String usuario;
  TratamientosSistema vistaTratamientosSistema;

  public ControladorTratamientos(String usuario, TratamientosSistema vistaTratamientosSistema) {
    this.usuario = usuario;
    this.vistaTratamientosSistema = vistaTratamientosSistema;
    cargarComboBoxTratamientos();
    cargarComboBoxPacientes();
    
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
        case 1:
          VistaEnfermero VE = new VistaEnfermero();
          ControladorVistaEnfermero CVE = new ControladorVistaEnfermero(VE,usuario);
          CVE.vistaEnfermero.setVisible(true);
          vistaTratamientosSistema.dispose();
          break;
        case 2:
          VistaDoctor VD = new VistaDoctor();
          ControladorVistaDoctor CVD = new ControladorVistaDoctor(VD,usuario);
          CVD.vistaDoctor.setVisible(true);
          vistaTratamientosSistema.dispose();
          break;
        default:
          JOptionPane.showMessageDialog(vistaTratamientosSistema, "Ha ocurrido "
                  + "algo, por favor intent"
                  + "elo a iniciar sesión nuevamente.");
          break;
    }
  }
  
  public String cargarQuery(String fechaI, String fechaF, String tipo, String nombre, String paciente){
    String consulta = "SELECT CatalogoTratamientos.IdTratamiento, "
            + "CatalogoTratamientos.Nombre FROM Cita INNER JOIN Paciente_Cita "
            + "ON Cita.IdCita = Paciente_Cita.IdCita INNER JOIN Cita_Diagnostico "
            + "ON Cita.IdCita = Cita_Diagnostico.IdCita INNER JOIN "
            + "CatalogoTratamientos ON Cita_Diagnostico.IdTratamiento = "
            + "CatalogoTratamientos.IdTratamiento WHERE idPaciente = '" + 
            paciente + "'";
    if(fechaI != null){
      consulta += " AND fecha >= '" + fechaI + "'";
    }if(fechaF != null){
      consulta += " AND fecha <= '" + fechaF + "'";
    }if(!tipo.equals("-")){
      consulta += " AND Cita_Diagnostico.Dosis = '" + tipo + "'";
    }if(!nombre.equals("-")){
      consulta += " AND CatalogoTratamientos.Nombre = '" + nombre + "'";
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
    String nombre = (String) vistaTratamientosSistema.cbNombreTratamiento.getSelectedItem();
    String paciente = (String) vistaTratamientosSistema.cbPacientes.getSelectedItem();
    
    String consulta = cargarQuery(fechaI, fechaF, tipo, nombre, paciente);  

    DefaultTableModel modeloTabla = (DefaultTableModel) vistaTratamientosSistema.tablaTratamientosSistema.getModel();
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
  
  private void cargarComboBoxTratamientos(){
      TratamientoBD tratamientosBD = new TratamientoBD();
      ResultSet rs = tratamientosBD.consultarTratamientos();
      vistaTratamientosSistema.cbNombreTratamiento.addItem("-");

      try{
        while(rs.next()){
          vistaTratamientosSistema.cbNombreTratamiento.addItem(rs.getString("Nombre"));
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
          vistaTratamientosSistema.cbPacientes.addItem(rs.getString("idPaciente"));
        }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
      }
    }
}
