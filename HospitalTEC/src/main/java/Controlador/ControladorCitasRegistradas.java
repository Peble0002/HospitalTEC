/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

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
    
    this.vistaCitas.btnBuscar.addActionListener(this);
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
          VistaSecretario VS = new VistaSecretario();
          ControladorVistaSecretario CVS = new ControladorVistaSecretario(VS,usuario);
          CVS.vistaSecretario.setVisible(true);
          vistaCitas.dispose();
          break;
        case 2:
          VistaEnfermero VE = new VistaEnfermero();
          ControladorVistaEnfermero CVE = new ControladorVistaEnfermero(VE,usuario);
          CVE.vistaEnfermero.setVisible(true);
          vistaCitas.dispose();
          break;
        case 3:
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
    String dia = (String) vistaCitas.cbDiaInicio.getSelectedItem();
    String mes = (String) vistaCitas.cbMesInicio.getSelectedItem();
    String ano = (String) vistaCitas.cbAnoInicio.getSelectedItem();

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
  
}
