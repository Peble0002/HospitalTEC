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
public class ControladorCantTratamientos implements ActionListener{
  public CantTratamientos vistaCantTratamientos;
  public String usuario;
  
  public ControladorCantTratamientos(CantTratamientos vistaCantTratamientos, String pUsuario) {
    this.vistaCantTratamientos = vistaCantTratamientos;
    usuario = pUsuario;
    cargarComboBoxAreaTrabajo();
    cargarComboBoxPacientes();
    this.vistaCantTratamientos.btnBuscar.addActionListener(this);
    this.vistaCantTratamientos.btnVolver.addActionListener(this);
   
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
   
  public String cargarQuery(String paciente, String area, String tipo){
    String consulta = "SELECT COUNT(CatalogoTratamientos.IdTratamiento) AS "
            + "TotalTratamientos FROM CatalogoTratamientos INNER JOIN "
            + "Cita_Diagnostico ON CatalogoTratamientos.IdTratamiento = "
            + "Cita_Diagnostico.IdTratamiento INNER JOIN Cita ON "
            + "Cita_Diagnostico.IdCita = Cita.IdCita INNER JOIN "
            + "Paciente_Cita ON Paciente_Cita.IdCita = Cita.IdCita "
            + "WHERE CatalogoTratamientos.IdTratamiento = "
            + "Cita_Diagnostico.IdTratamiento";
    if(!paciente.equals("-")){
      consulta += " AND idPaciente = '" + paciente + "'";
    }if(!area.equals("-")){
      consulta += " AND Cita.especialidad = '" + area + "'";
    }if(!tipo.equals("-")){
      consulta += " AND Cita_Diagnostico.Dosis = '" + tipo + "'";
    }
    return consulta;
  }
   
  public String cargarQueryGeneral(){
    String consulta = "SELECT COUNT(IdTratamiento) AS TotalTratamientos	FROM CatalogoTratamientos";
    return consulta;
  }
  
  private void cargarResultado() throws SQLException{
    String paciente = (String) vistaCantTratamientos.cbPacientes.getSelectedItem();
    String area = (String) vistaCantTratamientos.cbAreaCita.getSelectedItem();
    String tipo = (String) vistaCantTratamientos.cbTipo.getSelectedItem();
    String consulta;
    
    if(paciente.equals("-") && area.equals("-") && tipo.equals("-")){
      consulta = cargarQueryGeneral();  
    }else{
      consulta = cargarQuery(paciente, area, tipo);
    }
    Conexion conexion = new Conexion();
    ResultSet rs = conexion.consulta(consulta);
    rs.next();
    int cant = rs.getInt("TotalTratamientos");
    String resultado = String.valueOf(cant);
    
    vistaCantTratamientos.jLabel1.setText(resultado);
  }
   
public void asignarVentanaUsuario(){
    UsuarioBD usuarioBD = new UsuarioBD(); 
      int tipoUsuario = usuarioBD.retonarTipo(usuario);
      switch(tipoUsuario){
        case 3:
          VistaEnfermero VE = new VistaEnfermero();
          ControladorVistaEnfermero CVE = new ControladorVistaEnfermero(VE,usuario);
          CVE.vistaEnfermero.setVisible(true);
          vistaCantTratamientos.dispose();
          break;
        case 4:
          VistaDoctor VD = new VistaDoctor();
          ControladorVistaDoctor CVD = new ControladorVistaDoctor(VD,usuario);
          CVD.vistaDoctor.setVisible(true);
          vistaCantTratamientos.dispose();
          break;
        default:
          JOptionPane.showMessageDialog(vistaCantTratamientos, "Ha ocurrido algo, por favor intent"
                  + "elo a iniciar sesión nuevamente.");
          break;
      } 
    }

 private void cargarComboBoxAreaTrabajo(){
      AreaTrabajoBD areaBD = new AreaTrabajoBD();
      ResultSet rs = areaBD.consultarAreasTrabajo();
      vistaCantTratamientos.cbAreaCita.addItem("-");

      try{
        while(rs.next()){
          vistaCantTratamientos.cbAreaCita.addItem(rs.getString("NombreArea"));
        }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
      }
    }
 
 private void cargarComboBoxPacientes(){
      PacienteBD pacienteBD = new PacienteBD();
      ResultSet rs = pacienteBD.consultarPacientes();
      vistaCantTratamientos.cbPacientes.addItem("-");

      try{
        while(rs.next()){
          vistaCantTratamientos.cbPacientes.addItem(rs.getString("idPaciente"));
        }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
      }
    }
}
