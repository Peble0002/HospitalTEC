
package Controlador;
import DAO.*;
import Vista.*;
import Modelo.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;


/**
 *
 * @author LUIS LEITON
 */
public class ControladorAtenderCita implements ActionListener {
  public AtenderCita vistaAtenderCita;
  public String usuario;
  public String paciente;
    
  public ControladorAtenderCita(AtenderCita pVista, String pUsuario){
    
    vistaAtenderCita = pVista;
    usuario = pUsuario;
    cargarComboBoxCitasRegistradas();
    this.vistaAtenderCita.btnInternar.addActionListener(this);
    this.vistaAtenderCita.btnRegistrarBitacora.addActionListener(this);
    this.vistaAtenderCita.btnRegistrarDiagnostico.addActionListener(this);
    this.vistaAtenderCita.btnVolver.addActionListener(this);
    
  }
    
     @Override
     public void actionPerformed(ActionEvent e){
       switch(e.getActionCommand()){
        case "Registrar Diagnóstico":
          paciente = (String) vistaAtenderCita.cbCedulasPacientes.getSelectedItem();
          RegistrarDiagnosticoPaciente RDP = new RegistrarDiagnosticoPaciente();
          ControladorDiagnosticoPaciente CDP = new ControladorDiagnosticoPaciente(RDP,usuario,paciente);
          CDP.vistaDiagnosticoPaciente.setVisible(true);
          vistaAtenderCita.dispose();
          break;
        case "Internar Paciente": 
          paciente = (String) vistaAtenderCita.cbCedulasPacientes.getSelectedItem();
          RegistroInternado RI = new RegistroInternado();
          ControladorRegistroInternado CRI = new ControladorRegistroInternado(RI,usuario,paciente);
          CRI.vistaRegistroInternado.setVisible(true);
          vistaAtenderCita.dispose();
          break;
        case "Volver":
            VistaDoctor VD = new VistaDoctor();
            ControladorVistaDoctor CVD = new ControladorVistaDoctor(VD,usuario);
            CVD.vistaDoctor.setVisible(true);
            vistaAtenderCita.dispose();
            break;
        default:
            break;       
    }
  }
     
      /**
     * carga el combobox
     */
    private void cargarComboBoxCitasRegistradas(){
      CitaBD citaBD = new CitaBD();
      ResultSet rs = citaBD.consultarCitasRegistradas();

      try{
        while(rs.next()){
          vistaAtenderCita.cbCedulasPacientes.addItem(rs.getString("IdPaciente"));
        }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
      }
    }
    
    
}
