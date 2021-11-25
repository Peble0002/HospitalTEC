
package Controlador;

import DAO.BitacoraBD;
import DAO.Bitacora_CitaBD;
import DAO.CentroAtencionBD;
import DAO.CitaBD;
import DAO.Paciente_CitaBD;
import DAO.UsuarioBD;
import Modelo.Bitacora;
import Modelo.Cita;
import Vista.CancelarCita;
import Vista.VistaDoctor;
import Vista.VistaEnfermero;
import Vista.VistaPaciente;
import Vista.VistaSecretario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class ControladorCancelarCita implements ActionListener{
  public CancelarCita vistaCanceltarCita;
  private final String usuario;


  
  public ControladorCancelarCita(CancelarCita vistaCanceltarCita, String pUsuario) {
    this.vistaCanceltarCita = vistaCanceltarCita;
    usuario = pUsuario;
    
    this.vistaCanceltarCita.btnCancelar.addActionListener(this);
    this.vistaCanceltarCita.btnVolver.addActionListener(this);
    this.vistaCanceltarCita.btBuscarCitas.addActionListener(this);
   
  }
  
  @Override
   public void actionPerformed(ActionEvent e){
     switch(e.getActionCommand()){
      case "Buscar Cita":
        cargarComboBoxCitas(vistaCanceltarCita.tbCedula.getText());
        break;
      case "Cancelar": 
        cancelarCita();
        cargarComboBoxCitas(vistaCanceltarCita.tbCedula.getText());
        break;
      case "Volver":
          asignarVentanaUsuario();
          break;
      default:
          break;       
  }
}
  private void cargarComboBoxCitas(String cedula){
      Paciente_CitaBD pacienteCitaBD = new Paciente_CitaBD();
      ResultSet rs = pacienteCitaBD.consultarCitasRegistradasParaUnUsuario(cedula);
      
      try{
        while(rs.next()){
          CancelarCita.cbCitasAsociadas.addItem(rs.getString("IdCita") + " - " + rs.getString("fecha"));
        }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
      }
    }     
  
   
   
  
  public void asignarVentanaUsuario(){
    UsuarioBD usuarioBD = new UsuarioBD();  
    int tipoUsuario = usuarioBD.retonarTipo(usuario);
    switch(tipoUsuario){
      case 1:
        VistaPaciente VP = new VistaPaciente();
        ControladorVistaPaciente CVP = new ControladorVistaPaciente(VP,usuario);
        CVP.vistaPacientes.setVisible(true);
        vistaCanceltarCita.dispose();
        break;
      case 2:
        VistaSecretario VS = new VistaSecretario();
        ControladorVistaSecretario CVS = new ControladorVistaSecretario(VS,usuario);
        CVS.vistaSecretario.setVisible(true);
        vistaCanceltarCita.dispose();
        break;
      case 3:
        VistaEnfermero VE = new VistaEnfermero();
        ControladorVistaEnfermero CVE = new ControladorVistaEnfermero(VE,usuario);
        CVE.vistaEnfermero.setVisible(true);
        vistaCanceltarCita.dispose();
        break;
      case 4:
        VistaDoctor VD = new VistaDoctor();
        ControladorVistaDoctor CVD = new ControladorVistaDoctor(VD,usuario);
        CVD.vistaDoctor.setVisible(true);
        vistaCanceltarCita.dispose();
        break;
      default:
        JOptionPane.showMessageDialog(vistaCanceltarCita, "Ha ocurrido algo, por favor intent"
                + "elo a iniciar sesión nuevamente.");
        break;
    } 
  }
  
  
  public void cancelarCita(){
    CitaBD cita = new CitaBD();
    String combo = (String)CancelarCita.cbCitasAsociadas.getSelectedItem();
    String id = combo.substring(0, combo.indexOf(" - "));
    int idCita= Integer.parseInt(id);
    
    UsuarioBD usuarioBD = new UsuarioBD();  
    int tipoUsuario = usuarioBD.retonarTipo(usuario);
    LocalDate ahora = LocalDate.now();
    Date fechaHoy = Date.valueOf(ahora);
    LocalTime horaHoy = LocalTime.now();
          
    Bitacora bitacora = new Bitacora(idCita,fechaHoy , horaHoy,this.usuario);  
    String Estado;
    switch(tipoUsuario){
      case 1:
        Estado="Cancelada por paciente";       
        break;
      default:
        Estado="Cancelada por centro medico";
        break;
    }
    cita.actualizarCita(idCita,Estado);
    bitacora.setEstado(Estado);
    BitacoraBD bitacorabd = new BitacoraBD();
    bitacorabd.insertarBitacora(bitacora);
    Bitacora_CitaBD bitacora_Cita = new Bitacora_CitaBD();
    Cita citaNueva = new Cita(idCita);
    
    int idBitacora = bitacorabd.consultarIDBitacoraReciente();
    bitacora.setIdBitacora(idBitacora);
    
    bitacora_Cita.insertarBitacoraCita(bitacora, citaNueva);
    
  }
}
