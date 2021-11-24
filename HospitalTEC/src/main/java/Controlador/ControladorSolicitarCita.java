
package Controlador;

import DAO.*;
import Vista.*;
import Modelo.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;

/* Clase para conectar con la tabla Bitacora
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (22/11/2021)
 */
public class ControladorSolicitarCita implements ActionListener{
  public SolicitarCita vistaSolicitarCita;
    public String usuario;
    
    public ControladorSolicitarCita(SolicitarCita pVista, String pUsuario){
      cargarComboBoxAreaTrabajo();
      vistaSolicitarCita = pVista;
      usuario = pUsuario;
    
      this.vistaSolicitarCita.btnSolicitarCita.addActionListener(this);
      this.vistaSolicitarCita.btnVolver.addActionListener(this);
      
  }
    
     @Override
     public void actionPerformed(ActionEvent e){
       switch(e.getActionCommand()){
          case "Solicitar":
              registroCita();
            break;
        case "Volver":
            VistaPaciente VP = new VistaPaciente();
            ControladorVistaPaciente CVP = new ControladorVistaPaciente(VP,usuario);
            CVP.vistaPacientes.setVisible(true);
            vistaSolicitarCita.dispose();
            break;
        default:
            break;       
    }
  }
     
     /*
     * carga el combobox
     */
    private void cargarComboBoxAreaTrabajo(){
      AreaTrabajoBD areaBD = new AreaTrabajoBD();
      ResultSet rs = areaBD.consultarAreasTrabajo();

      try{
        while(rs.next()){
          vistaSolicitarCita.cbAreaCita.addItem(rs.getString("codigo") + " - " + rs.getString("NombreArea"));
        }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
      }
    }
    
    public void registroCita(){
      if(vistaSolicitarCita.datosCorrectos() == false){
      JOptionPane.showMessageDialog(vistaSolicitarCita, "Alguno de los "
              + "espacios de datos está vacío.");
      }
      else{
        CitaBD conexionCita = new CitaBD();
        Paciente_CitaBD conexionPC = new Paciente_CitaBD();
        String dia = (String) vistaSolicitarCita.cbDia.getSelectedItem();
        String mes = (String) vistaSolicitarCita.cbMes.getSelectedItem();
        String ano = (String) vistaSolicitarCita.cbAno.getSelectedItem();

        int pDia = Integer.parseInt(dia);
        int pMes = Integer.parseInt(mes);
        int pAno = Integer.parseInt(ano);
        pAno = pAno-1900;
        pMes = pMes-1;
        Date fecha = new Date(pAno,pMes,pDia);

        String horas = (String) vistaSolicitarCita.cbHora.getSelectedItem();
        String minutos = (String) vistaSolicitarCita.cbMinutos.getSelectedItem();

        int pHoras = Integer.parseInt(horas);
        int pMinutos = Integer.parseInt(minutos);

        LocalTime hora = LocalTime.of(pHoras, pMinutos);

        String observacion = (String) vistaSolicitarCita.tbObservacion.getText();
        String especialidad = (String) vistaSolicitarCita.cbAreaCita.getSelectedItem();

        Cita citaNueva = new Cita(fecha, hora, observacion, especialidad);
        conexionCita.insertarCita(citaNueva, "Registrada");
        int IdCita = conexionCita.consultarIDCitaReciente();
        citaNueva.setIdCita(IdCita);
        conexionPC.insertarPaciente_Cita(citaNueva, this.usuario);
        LocalDate ahora = LocalDate.now();
        Date fechaHoy = Date.valueOf(ahora);
        LocalTime horaHoy = LocalTime.now();

        Bitacora bitacora = new Bitacora(IdCita,fechaHoy , horaHoy,this.usuario);
        BitacoraBD bitacorabd = new BitacoraBD();
        bitacorabd.insertarBitacora(bitacora);
        int idBitacora = bitacorabd.consultarIDBitacoraReciente();
        bitacora.setIdBitacora(idBitacora);
        Bitacora_CitaBD bitacora_Cita = new Bitacora_CitaBD();
        bitacora_Cita.insertarBitacoraCita(bitacora, citaNueva);
      }
  }
}
