/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class InicioSesion implements ActionListener{
  public Principal vistaInicio;
  public UsuarioBD usuarioBD;
  
  public InicioSesion(Principal pVista){
    //Principal vistaInicio = new Principal();
    UsuarioBD usuarioBD = new UsuarioBD();
    vistaInicio = pVista;
    
    this.vistaInicio.btnIniciarSesion.addActionListener(this);
    this.vistaInicio.btnRegistrar.addActionListener(this);      
  }
  
  @Override
  public void actionPerformed(ActionEvent e){
    switch(e.getActionCommand()){
        case "Iniciar sesión":
            logInUsuario();
            break;
        case "Registrarme":
            registrarPaciente();
            break;
        default:
            break;       
    }
  }
  
  public void logInUsuario(){
    UsuarioBD usuarioBD = new UsuarioBD();
      if(vistaInicio.datosCorrectos() == false){
      JOptionPane.showMessageDialog(vistaInicio, "Alguno de los espacios de datos está"
              + " vacío.");
    }
    else{
      String nombreUsuario = vistaInicio.tbUsuario.getText();
      String contrasena = vistaInicio.tbContrasena.getText();
      if(usuarioBD.existeUsuario(nombreUsuario)){
        if(usuarioBD.validarIngreso(nombreUsuario, contrasena)){
          asignarVentanaUsuario();
        }else{
          JOptionPane.showMessageDialog(vistaInicio, "Contraseña Incorrecta");
        }
      }else{
        JOptionPane.showMessageDialog(vistaInicio, "El usuario ingresado no existe");
      }
      } 
  }
  public void asignarVentanaUsuario(){
    UsuarioBD usuarioBD = new UsuarioBD();  
    int tipoUsuario = usuarioBD.retonarTipo(vistaInicio.tbUsuario.getText(), 
            vistaInicio.tbContrasena.getText());
    switch(tipoUsuario){
      case 1:
        VistaPaciente VP = new VistaPaciente();
        VP.setVisible(true);
        vistaInicio.dispose();
        break;
      case 2:
        VistaSecretario VS = new VistaSecretario();
        VS.setVisible(true);
        vistaInicio.dispose();
        break;
      case 3:
        VistaEnfermero VE = new VistaEnfermero();
        VE.setVisible(true);
        vistaInicio.dispose();
        break;
      case 4:
        VistaDoctor VD = new VistaDoctor();
        VD.setVisible(true);
        vistaInicio.dispose(); 
        break;
      default:
        JOptionPane.showMessageDialog(vistaInicio, "Ha ocurrido algo, por favor intent"
                + "elo a iniciar sesión nuevamente.");
        break;
    } 
  }
  
  public void registrarPaciente(){
      
      RegistroPacientes vistaRegistro = new RegistroPacientes();
      vistaInicio.dispose(); 
    
      ControladorRegistroPaciente controladorRP = new ControladorRegistroPaciente(vistaRegistro);
        
      controladorRP.vistaRegistroPacientes.setVisible(true);
      controladorRP.vistaRegistroPacientes.setLocationRelativeTo(null);
     }   
}
