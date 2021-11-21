/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Vista.*;

/**
 *
 * @author LUIS LEITON
 */
public class GestorControladores {
    
 public static void main(String[] args) {
      Principal vista = new Principal();
    
      InicioSesion controladorInicio = new InicioSesion(vista);
        
      controladorInicio.vistaInicio.setVisible(true);
      controladorInicio.vistaInicio.setLocationRelativeTo(null);   
 }
}
