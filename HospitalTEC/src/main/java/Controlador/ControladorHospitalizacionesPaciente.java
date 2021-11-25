/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.Conexion;
import Vista.HospitalizacionesAsociadasPaciente;
import Vista.VistaPaciente;
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
public class ControladorHospitalizacionesPaciente  implements ActionListener{
  public HospitalizacionesAsociadasPaciente vistahospitalizacionesPaciente;
  String usuario;

  public ControladorHospitalizacionesPaciente(HospitalizacionesAsociadasPaciente hospitalizacionesSistema, String usuario) {
    this.vistahospitalizacionesPaciente = hospitalizacionesSistema;
    this.usuario = usuario;
    
    this.vistahospitalizacionesPaciente.btnBuscar.addActionListener(this);
    this.vistahospitalizacionesPaciente.btnVolver.addActionListener(this);
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
          vistahospitalizacionesPaciente.dispose();
          break;
      default:
        break;       
    }
  }
  
  public String cargarQuery(){
    return "SELECT fechaInicio, fechaFin, nombreCentro, (Nombre + ' ' + "
            + "Apellido1 + ' ' + Apellido2) AS nombreCompleto FROM Internado "
            + "INNER JOIN Internado_Centro ON Internado.codInternado = "
            + "Internado_Centro.codInternado INNER JOIN CentroAtencion ON "
            + "CentroAtencion.Codigo = Internado_Centro.Codigo INNER JOIN "
            + "Internado_Doctor ON Internado.codInternado = "
            + "Internado_Doctor.codInternado INNER JOIN Usuario ON "
            + "Internado_Doctor.IDFuncionario = Usuario.idUsuario WHERE "
            + "IdInternado = '" + usuario + "'";
  }
  
  private void cargarTabla() throws SQLException{
    
    String consulta = cargarQuery();    

    DefaultTableModel modeloTabla = (DefaultTableModel) vistahospitalizacionesPaciente.tablaHospitalizaciones.getModel();
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
