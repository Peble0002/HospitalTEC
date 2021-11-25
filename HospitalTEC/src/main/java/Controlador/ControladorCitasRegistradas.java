/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.AreaTrabajoBD;
import DAO.Conexion;
import DAO.UsuarioBD;
import Vista.CitasSistema;
import Vista.VistaDoctor;
import Vista.VistaEnfermero;
import Vista.VistaPaciente;
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
public class ControladorCitasRegistradas implements ActionListener{
  String usuario;
  public CitasSistema vistaCitas;
  
  public ControladorCitasRegistradas(String usuario, CitasSistema vistaCitas) {
    this.usuario = usuario;
    this.vistaCitas = vistaCitas;
    cargarComboBoxAreaTrabajo();
    
    this.vistaCitas.btnBuscar.addActionListener(this);
    this.vistaCitas.btVolver.addActionListener(this);
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
        case 2:
          VistaSecretario VS = new VistaSecretario();
          ControladorVistaSecretario CVS = new ControladorVistaSecretario(VS,usuario);
          CVS.vistaSecretario.setVisible(true);
          vistaCitas.dispose();
          break;
        case 3:
          VistaEnfermero VE = new VistaEnfermero();
          ControladorVistaEnfermero CVE = new ControladorVistaEnfermero(VE,usuario);
          CVE.vistaEnfermero.setVisible(true);
          vistaCitas.dispose();
          break;
        case 4:
          VistaDoctor VD = new VistaDoctor();
          ControladorVistaDoctor CVD = new ControladorVistaDoctor(VD,usuario);
          CVD.vistaDoctor.setVisible(true);
          vistaCitas.dispose();
          break;
        default:
          JOptionPane.showMessageDialog(vistaCitas, "Ha ocurrido algo, por favor intent"
                  + "elo a iniciar sesión nuevamente.");
          break;
    }
  }
  
  public String cargarQuery(String fechaI, String fechaF, String estado, String area, String nombre){
    String consulta = "SELECT Cita.IdCita, fecha, (Nombre + ' ' + Apellido1 + "
            + "' ' + Apellido2) AS nombreCompleto, hora, observaciones, estado, "
            + "especialidad, correo FROM Cita INNER JOIN Paciente_Cita ON "
            + "Cita.IdCita = Paciente_Cita.IdCita INNER JOIN Usuario ON "
            + "Paciente_Cita.idPaciente = Usuario.idUsuario";
    if(fechaI == null && fechaF == null && estado.equals("-") && area.equals("-") && nombre.equals("")){
      return consulta;
    }else{
      consulta += " WHERE";
      boolean primerConsulta = true;
      if(fechaI != null){
        if(primerConsulta){
          consulta += " fecha >= '" + fechaI + "'";
          primerConsulta = false;
        }else{
          consulta += " AND fecha >= '" + fechaI + "'";
        }
      }if(fechaF != null){
        if(primerConsulta){
          consulta += " fecha <= '" + fechaF + "'";
          primerConsulta = false;
        }else{
          consulta += " AND fecha <= '" + fechaF + "'";
        } 
      }if(!estado.equals("-")){
        if(primerConsulta){
          consulta += " estado = '" + estado + "'";
          primerConsulta = false;
        }else{
          consulta += " AND estado = '" + estado + "'";
        }
      }if(!area.equals("-")){
        if(primerConsulta){
          consulta += " especialidad = '" + area + "'";
          primerConsulta = false;
        }else{
          consulta += " AND especialidad = '" + area + "'";
        }
      }if(!nombre.equals("")){
        if(primerConsulta){
          consulta += " Nombre LIKE '%" + nombre + "%'";
          primerConsulta = false;
        }else{
          consulta += " AND Nombre LIKE '%" + nombre + "%'";
        }
      }
    return consulta;
    }
  }
  
  private String validarFecha(String dia, String mes, String ano){
    if(dia.equals("-") || mes.equals("-") || ano.equals("-")){
      return null;
    }else{
      return ano + "-" + mes + "-" + dia;
    }
  }
  
  private void cargarTabla() throws SQLException{
    String dia = (String) vistaCitas.cbDiaInicio.getSelectedItem();
    String mes = (String) vistaCitas.cbMesInicio.getSelectedItem();
    String ano = (String) vistaCitas.cbAnoInicio.getSelectedItem();

    String fechaI = validarFecha(dia, mes, ano);
   
    String diaF = (String) vistaCitas.cbDiaFin.getSelectedItem();
    String mesF = (String) vistaCitas.cbMesFin.getSelectedItem();
    String anoF = (String) vistaCitas.cbAnoFin.getSelectedItem();

    String fechaF = validarFecha(diaF, mesF, anoF);

    String estado = (String) vistaCitas.cbEstado.getSelectedItem();
    String area = (String) vistaCitas.cbArea.getSelectedItem();
    String nombre = (String) vistaCitas.tbNombre.getText();
    
    String consulta = cargarQuery(fechaI, fechaF, estado, area, nombre);  

    DefaultTableModel modeloTabla = (DefaultTableModel) vistaCitas.tablaCitasSistema.getModel();
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
  private void cargarComboBoxAreaTrabajo(){
      AreaTrabajoBD areaBD = new AreaTrabajoBD();
      ResultSet rs = areaBD.consultarAreasTrabajo();
      vistaCitas.cbArea.addItem("-");
      
      try{
        while(rs.next()){
          vistaCitas.cbArea.addItem(rs.getString("NombreArea"));
        }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
      }
    }
}
