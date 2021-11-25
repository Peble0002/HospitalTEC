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
        
        break;
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

      try{
        while(rs.next()){
          vistaCantCitas.cbAreaCita.addItem(rs.getString("NombreArea"));
        }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
      }
    }
}
