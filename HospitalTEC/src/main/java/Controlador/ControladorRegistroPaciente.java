/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import DAO.*;
import Modelo.Paciente;
import Vista.*;
//import Modelo.*;
import Modelo.Usuario;
//import java.awt.event.ActionEvent;
import java.sql.*;
//import javax.swing.JOptionPane;
//import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

/**
 *
 * @author LUIS LEITON
 */
public class ControladorRegistroPaciente implements ActionListener{
    
    public RegistroPacientes vistaRegistroPacientes;
    public PacienteBD pacienteBD;
    
    public ControladorRegistroPaciente(RegistroPacientes pVista){
    
    
      PacienteBD pacienteBD = new PacienteBD();
      vistaRegistroPacientes = pVista;
    
      this.vistaRegistroPacientes.btnRegistrarPaciente.addActionListener(this);
      this.vistaRegistroPacientes.btnVolver.addActionListener(this);
  }
    
    @Override
  public void actionPerformed(ActionEvent e){
    switch(e.getActionCommand()){
        case "Registrar":
            registrarPacientes();
            break;
        case "Volver":
            Principal P = new Principal();
            InicioSesion IS = new InicioSesion(P);
            IS.vistaInicio.setVisible(true);
            vistaRegistroPacientes.dispose();
            break;
        default:
            break;       
    }
  }
  
  public void registrarPacientes(){
      //PacienteBD pacienteBD = new PacienteBD();  
//      if(vistaRegistroPacientes.datosCorrectos() == false){
//      JOptionPane.showMessageDialog(vistaRegistroPacientes, "Alguno de los espacios de datos está"
//              + " vacío.");
//    }
//    else{
//      Date date = (Date) vistaRegistroPacientes.jFechaNacimiento.getDate(); //ic es la interfaz, jDate el JDatechooser
//      long d = date.getTime(); //guardamos en un long el tiempo
//      java.sql.Date fecha = new java.sql.Date(d);// parseamos al formato del sql
      //Date fecha = (Date) vistaRegistroPacientes.jFechaNacimiento.getCalendar().getTime();
      
      String dia = (String) vistaRegistroPacientes.cbDia.getSelectedItem();
      String mes = (String) vistaRegistroPacientes.cbDia.getSelectedItem();
      String ano = (String) vistaRegistroPacientes.cbDia.getSelectedItem();
      
      int pDia = Integer.parseInt(dia);
      int pMes = Integer.parseInt(mes);
      int pAno = Integer.parseInt(ano);
      
      Date fecha = new Date(pAno,pMes,pDia);
      
      String cedula = vistaRegistroPacientes.tbCedulaPaciente.getText();
      String nombre = vistaRegistroPacientes.tbNombrePaciente.getText();
      String apellido1 = vistaRegistroPacientes.tbApellido1Paciente.getText();
      String apellido2 = vistaRegistroPacientes.tbApellido2Paciente.getText();
      String contrasena = vistaRegistroPacientes.tbContrasenaPaciente.getText();
      String nacionalidad = vistaRegistroPacientes.tbNacionalidadPaciente.getText();
      String provincia = vistaRegistroPacientes.tbProvinciaPaciente.getText();
      String canton = vistaRegistroPacientes.tbCantonPaciente.getText();
      String telefono = vistaRegistroPacientes.tbTelefonoPaciente.getText();
      String tipoSangre = vistaRegistroPacientes.tbTipoSangrePaciente.getText();
      String distrito = vistaRegistroPacientes.tbDistritoPaciente.getText();
      Paciente paciente = new Paciente( fecha, tipoSangre, nacionalidad,  
              provincia,  canton, distrito,  telefono,  cedula, contrasena, 
              nombre,  apellido1, apellido2);
      pacienteBD.insertarPaciente(paciente);
       JOptionPane.showMessageDialog(vistaRegistroPacientes, "REGISTRADO");
    } 
  }  
    
    
//}
