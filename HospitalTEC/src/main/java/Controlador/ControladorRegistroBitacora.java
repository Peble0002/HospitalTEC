/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import DAO.*;
import Modelo.Paciente;
import Vista.*;
import java.sql.*;

import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author LUIS LEITON
 */
public class ControladorRegistroBitacora implements ActionListener{
  public RegistroBitacora vistaRegistroBitacora;
  public String usuario;
  public String paciente;
    
  public ControladorRegistroBitacora(RegistroBitacora pVista, String pUsuario, String pPaciente){
    
    vistaRegistroBitacora = pVista;
    usuario = pUsuario;
    paciente = pPaciente;
    
    this.vistaRegistroBitacora.btnRegistrarBitacora.addActionListener(this);
    this.vistaRegistroBitacora.btnVolver.addActionListener(this);
    
  }
    
   @Override
   public void actionPerformed(ActionEvent e){
     switch(e.getActionCommand()){
      case "Registrar":
        registrarBitacoraCita();
        break;
      case "Volver":
          AtenderCita AC = new AtenderCita();
          ControladorAtenderCita CAC = new ControladorAtenderCita(AC,usuario);
          CAC.vistaAtenderCita.setVisible(true);
          vistaRegistroBitacora.dispose();
          break;
        default:
          break;       
    }
  }
     
  public void registrarBitacoraCita(){
    String estado = (String) vistaRegistroBitacora.cbEstado.getSelectedItem();
    
    String dia = (String) vistaRegistroBitacora.cbDia.getSelectedItem();
    String mes = (String) vistaRegistroBitacora.cbMes.getSelectedItem();
    String ano = (String) vistaRegistroBitacora.cbAno.getSelectedItem();
      
    int pDia = Integer.parseInt(dia);
    int pMes = Integer.parseInt(mes);
    int pAno = Integer.parseInt(ano);
    pAno = pAno-1900;
    pMes = pMes-1;
    Date fechaAplicacion = new Date(pAno,pMes,pDia);
    
    //FALTAA LA HORA
    String hora = (String) vistaRegistroBitacora.cbHora.getSelectedItem();
    String minutos = (String) vistaRegistroBitacora.cbMinutos.getSelectedItem();
    
    

    
//    Paciente paciente = new Paciente( fecha, tipoSangre, nacionalidad,  
//            provincia,  canton, distrito,  telefono,  cedula, contrasena, 
//            nombre,  apellido1, apellido2);
//    pacienteBD.insertarPaciente(paciente);
    JOptionPane.showMessageDialog(vistaRegistroBitacora, "REGISTRADO");    
  }     
}
