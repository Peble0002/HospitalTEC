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
      String dia = (String) vistaSolicitarCita.cbDia.getSelectedItem();
      String mes = (String) vistaSolicitarCita.cbMes.getSelectedItem();
      String ano = (String) vistaSolicitarCita.cbAno.getSelectedItem();
      
      int pDia = Integer.parseInt(dia);
      int pMes = Integer.parseInt(mes);
      int pAno = Integer.parseInt(ano);
      pAno = pAno-1900;
      pMes = pMes-1;
      Date fecha = new Date(pAno,pMes,pDia); 
      
      
    }
}
