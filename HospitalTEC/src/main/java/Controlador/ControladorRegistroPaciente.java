/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import DAO.*;
import Modelo.*;
import Vista.*;
import java.sql.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Clase para la conexion con AreaTrabajo
 * @author  Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (22/11/2021)
 */
public class ControladorRegistroPaciente implements ActionListener{
    
    public RegistroPacientes vistaRegistroPacientes = new RegistroPacientes();
    public PacienteBD pacienteBD = new PacienteBD();
    public ArrayList<String> telefonos = new ArrayList<String>();
    public ArrayList<Vacuna> vacunas = new ArrayList<Vacuna>();
    public int codigoVacuna;
    
    public ControladorRegistroPaciente(RegistroPacientes pVista){
    
    
      PacienteBD pacienteBaseDatos = new PacienteBD();
      vistaRegistroPacientes = pVista;
      cargarComboBoxVacunas();
    
      this.vistaRegistroPacientes.btnRegistrarPaciente.addActionListener(this);
      this.vistaRegistroPacientes.btnVolver.addActionListener(this);
      this.vistaRegistroPacientes.btnRegistrarTelefono.addActionListener(this);
      this.vistaRegistroPacientes.btnRegistraVacunas.addActionListener(this);
  }
    
    /**
     * carga el combobox
     */
    private void cargarComboBoxVacunas(){
      VacunaBD vacunasBD = new VacunaBD();
      ResultSet rs = vacunasBD.consultarVacunas();

      try{
        while(rs.next()){
          vistaRegistroPacientes.cbNombreVacunas.addItem(rs.getString("idVacuna")
                  +" - " + rs.getString("nombre"));
        }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
      }
    }
    
    @Override
  public void actionPerformed(ActionEvent e){
    switch(e.getActionCommand()){
        case "Registrar":
            registrarPacientes();
            break;
        case "Registrar Vacuna":
            registrarVacunas();
            break;
        case "Agregar":
            registrarTelefonos();
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
  
  public void registrarTelefonos(){
    String tbValidar = vistaRegistroPacientes.tbTelefonoPaciente.getText();
    if( tbValidar.equals("")){
     JOptionPane.showMessageDialog(vistaRegistroPacientes, "Se debe ingresar "
               + "un número de teléfono"); 
    }else{
    String telefono = vistaRegistroPacientes.tbTelefonoPaciente.getText();
    telefonos.add(telefono);
    JOptionPane.showMessageDialog(vistaRegistroPacientes, "Se agregó el teléfono");
    }
  }
  
  public void registrarVacunas(){
    String tbValidar = vistaRegistroPacientes.tbNumeroLote.getText();
    if( tbValidar.equals("")){
       JOptionPane.showMessageDialog(vistaRegistroPacientes, "Se debe ingresar "
               + "el número de lote"); 
    }else{
    String nombre = (String) vistaRegistroPacientes.cbNombreVacunas.getSelectedItem();  
    String idVacunaS = nombre.substring(0, nombre.indexOf("-")-1);
    codigoVacuna = Integer.parseInt(idVacunaS);
    String dia = (String) vistaRegistroPacientes.cbDiaVacuna.getSelectedItem();
    String mes = (String) vistaRegistroPacientes.cbMesVacuna.getSelectedItem();
    String ano = (String) vistaRegistroPacientes.cbAnoVacuna.getSelectedItem();
      
    int pDia = Integer.parseInt(dia);
    int pMes = Integer.parseInt(mes);
    int pAno = Integer.parseInt(ano);
    pAno = pAno-1900;
    pMes = pMes-1;
    Date fecha = new Date(pAno,pMes,pDia); 
    
    String lote = vistaRegistroPacientes.tbNumeroLote.getText();
    
    Vacuna vacunaNueva = new Vacuna(fecha,nombre,lote,codigoVacuna);
    vacunas.add(vacunaNueva);
    JOptionPane.showMessageDialog(vistaRegistroPacientes, "Se agregó la vacuna");
    }
  }
  
  public void registrarPacientes(){
   
    Telefono_PacienteBD telefonoPaciente = new Telefono_PacienteBD();
    Paciente_VacunaBD pacienteVacuna = new Paciente_VacunaBD();
    
    if(vistaRegistroPacientes.datosCorrectos() == false){
      JOptionPane.showMessageDialog(vistaRegistroPacientes, "Alguno de los espacios de datos está"
              + " vacío.");
    }
    else{
      
      String dia = (String) vistaRegistroPacientes.cbDia.getSelectedItem();
      String mes = (String) vistaRegistroPacientes.cbMes.getSelectedItem();
      String ano = (String) vistaRegistroPacientes.cbAno.getSelectedItem();
      
      int pDia = Integer.parseInt(dia);
      int pMes = Integer.parseInt(mes);
      int pAno = Integer.parseInt(ano);
      pAno = pAno-1900;
      pMes = pMes-1;
      Date fecha = new Date(pAno,pMes,pDia);
      
      String cedula = vistaRegistroPacientes.tbCedulaPaciente.getText();
      String nombre = vistaRegistroPacientes.tbNombrePaciente.getText();
      String apellido1 = vistaRegistroPacientes.tbApellido1Paciente.getText();
      String apellido2 = vistaRegistroPacientes.tbApellido2Paciente.getText();
      String contrasena = vistaRegistroPacientes.tbContrasenaPaciente.getText();
      String nacionalidad = vistaRegistroPacientes.tbNacionalidadPaciente.getText();
      String provincia = vistaRegistroPacientes.tbProvinciaPaciente.getText();
      String canton = vistaRegistroPacientes.tbCantonPaciente.getText();
      String tipoSangre = vistaRegistroPacientes.tbTipoSangrePaciente.getText();
      Paciente paciente = new Paciente( fecha, tipoSangre, nacionalidad,  
              provincia,  canton, cedula, contrasena, 
              nombre,  apellido1, apellido2);
      pacienteBD.insertarPaciente(paciente);
      
      String tel;
      
      for(int i=0; i<telefonos.size();i++){
        
          tel = telefonos.get(i);
          telefonoPaciente.insertarPacienteTelefono(cedula,tel);
      }
      
      Vacuna insertarV = new Vacuna(); 

      for(int x=0; x<vacunas.size();x++){
          
          insertarV = vacunas.get(x);
          pacienteVacuna.insertarPacienteVacuna(paciente,insertarV);
      }
      JOptionPane.showMessageDialog(vistaRegistroPacientes, "Se ha registrado "
              + "el paciente exitosamente");
    } 
  }  
    
}
