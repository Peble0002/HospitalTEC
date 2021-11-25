/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import DAO.*;
import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;

/**
 *
 * @author LUIS LEITON
 */
public class ControladorCantCitasRegistradas implements ActionListener{
  public CantCitasRegistradas vistaCantCitas;
  public String usuario;
  
  public ControladorCantCitasRegistradas(CantCitasRegistradas vistaCantCitas, String pUsuario) {
    this.vistaCantCitas = vistaCantCitas;
    usuario = pUsuario;
    cargarComboBoxAreaTrabajo();
    this.vistaCantCitas.btnBuscar.addActionListener(this);
    this.vistaCantCitas.btnVolver.addActionListener(this);
   
  }
  
  @Override
 public void actionPerformed(ActionEvent e){
   switch(e.getActionCommand()){
    case "Buscar":
      try{
        cargarResultado();
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
 
  public String cargarQuery(String fechaI, String fechaF, String area, String estado){
    String consulta = "SELECT COUNT(Cita.IdCita) AS cantidad FROM Cita";
    if(fechaI == null && fechaF == null && estado.equals("-") && area.equals("-")){
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
  
  private void cargarResultado() throws SQLException{
    String dia = (String) vistaCantCitas.cbDiaInicio.getSelectedItem();
    String mes = (String) vistaCantCitas.cbMesInicio.getSelectedItem();
    String ano = (String) vistaCantCitas.cbAnoInicio.getSelectedItem();

    String fechaI = validarFecha(dia, mes, ano);
   
    String diaF = (String) vistaCantCitas.cbDiaFin.getSelectedItem();
    String mesF = (String) vistaCantCitas.cbMesFin.getSelectedItem();
    String anoF = (String) vistaCantCitas.cbAnoFin.getSelectedItem();

    String fechaF = validarFecha(diaF, mesF, anoF);

    String area = (String) vistaCantCitas.cbAreaCita.getSelectedItem();
    String estado = (String) vistaCantCitas.cbEstado.getSelectedItem();
        
    String consulta = cargarQuery(fechaI, fechaF, area, estado);  
    
    Conexion conexion = new Conexion();
    ResultSet rs = conexion.consulta(consulta);
    rs.next();
    int cant = rs.getInt("cantidad");
    String resultado = String.valueOf(cant);
    
    vistaCantCitas.lbCantidad.setText(resultado);
  }
   
public void asignarVentanaUsuario(){
    UsuarioBD usuarioBD = new UsuarioBD(); 
      int tipoUsuario = usuarioBD.retonarTipo(usuario);
      switch(tipoUsuario){
        case 3:
          VistaEnfermero VE = new VistaEnfermero();
          ControladorVistaEnfermero CVE = new ControladorVistaEnfermero(VE,usuario);
          CVE.vistaEnfermero.setVisible(true);
          vistaCantCitas.dispose();
          break;
        case 4:
          VistaDoctor VD = new VistaDoctor();
          ControladorVistaDoctor CVD = new ControladorVistaDoctor(VD,usuario);
          CVD.vistaDoctor.setVisible(true);
          vistaCantCitas.dispose();
          break;
        default:
          JOptionPane.showMessageDialog(vistaCantCitas, "Ha ocurrido algo, por favor intent"
                  + "elo a iniciar sesión nuevamente.");
          break;
      } 
    }

 private void cargarComboBoxAreaTrabajo(){
      AreaTrabajoBD areaBD = new AreaTrabajoBD();
      ResultSet rs = areaBD.consultarAreasTrabajo();
      vistaCantCitas.cbAreaCita.addItem("-");

      try{
        while(rs.next()){
          vistaCantCitas.cbAreaCita.addItem(rs.getString("NombreArea"));
        }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
      }
    }
}
