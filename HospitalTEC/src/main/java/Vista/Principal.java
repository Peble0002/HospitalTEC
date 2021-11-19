/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Controlador.*;

/**
 *
 * @author pablo
 */
public class Principal extends javax.swing.JFrame {
  Conexion conexion = new Conexion();
  /**
   * Creates new form Principal
   */
  public Principal() {
    conexion.getConexion();
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnIniciarSesion = new javax.swing.JButton();
        tbContrasena = new javax.swing.JPasswordField();
        btnPaciente = new javax.swing.JButton();
        btnDoctor = new javax.swing.JButton();
        btnEnfermero = new javax.swing.JButton();
        btnSecretario = new javax.swing.JButton();
        btnRegistrarPaciente = new javax.swing.JButton();
        btnSecretario1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 102, 255));

        tbUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Usuario:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Contraseña:");

        jLabel3.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Bienvenidos al Hospital TEC");

        btnIniciarSesion.setBackground(new java.awt.Color(0, 102, 102));
        btnIniciarSesion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIniciarSesion.setText("Iniciar sesión");

        tbContrasena.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnPaciente.setBackground(new java.awt.Color(0, 102, 102));
        btnPaciente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPaciente.setText("Paciente");
        btnPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacienteActionPerformed(evt);
            }
        });

        btnDoctor.setBackground(new java.awt.Color(0, 102, 102));
        btnDoctor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDoctor.setText("Doctor");
        btnDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoctorActionPerformed(evt);
            }
        });

        btnEnfermero.setBackground(new java.awt.Color(0, 102, 102));
        btnEnfermero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEnfermero.setText("Enfermero");
        btnEnfermero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnfermeroActionPerformed(evt);
            }
        });

        btnSecretario.setBackground(new java.awt.Color(0, 102, 102));
        btnSecretario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSecretario.setText("Secretario");
        btnSecretario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecretarioActionPerformed(evt);
            }
        });

        btnRegistrarPaciente.setBackground(new java.awt.Color(0, 102, 102));
        btnRegistrarPaciente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrarPaciente.setText("Registrarme");
        btnRegistrarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPacienteActionPerformed(evt);
            }
        });

        btnSecretario1.setBackground(new java.awt.Color(0, 102, 102));
        btnSecretario1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSecretario1.setText("Administrador");
        btnSecretario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecretario1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tbUsuario)
                            .addComponent(tbContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnPaciente)
                        .addGap(26, 26, 26)
                        .addComponent(btnDoctor)
                        .addGap(18, 18, 18)
                        .addComponent(btnEnfermero)
                        .addGap(35, 35, 35)
                        .addComponent(btnSecretario)
                        .addGap(18, 18, 18)
                        .addComponent(btnSecretario1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(btnRegistrarPaciente)
                        .addGap(61, 61, 61)
                        .addComponent(btnIniciarSesion)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tbContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciarSesion)
                    .addComponent(btnRegistrarPaciente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnfermero)
                    .addComponent(btnDoctor)
                    .addComponent(btnPaciente)
                    .addComponent(btnSecretario)
                    .addComponent(btnSecretario1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacienteActionPerformed
      VistaPaciente VP = new VistaPaciente();
      VP.setVisible(true);
      
      this.dispose();  
    }//GEN-LAST:event_btnPacienteActionPerformed

    private void btnRegistrarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPacienteActionPerformed
      RegistroPacientes RP = new RegistroPacientes();
      RP.setVisible(true);
      
      this.dispose();
    }//GEN-LAST:event_btnRegistrarPacienteActionPerformed

    private void btnDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoctorActionPerformed
      VistaDoctor VD = new VistaDoctor();
      VD.setVisible(true);
      
      this.dispose(); 
    }//GEN-LAST:event_btnDoctorActionPerformed

    private void btnEnfermeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnfermeroActionPerformed
      VistaEnfermero VE = new VistaEnfermero();
      VE.setVisible(true);
      
      this.dispose();
    }//GEN-LAST:event_btnEnfermeroActionPerformed

    private void btnSecretarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecretarioActionPerformed
      VistaSecretario VS = new VistaSecretario();
      VS.setVisible(true);
      
      this.dispose();
    }//GEN-LAST:event_btnSecretarioActionPerformed

    private void btnSecretario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecretario1ActionPerformed
      Administrador AD = new Administrador();
      AD.setVisible(true);
      
      this.dispose();  
    }//GEN-LAST:event_btnSecretario1ActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Principal().setVisible(true);
      }
    });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDoctor;
    public javax.swing.JButton btnEnfermero;
    public javax.swing.JButton btnIniciarSesion;
    public javax.swing.JButton btnPaciente;
    public javax.swing.JButton btnRegistrarPaciente;
    public javax.swing.JButton btnSecretario;
    public javax.swing.JButton btnSecretario1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JPasswordField tbContrasena;
    public javax.swing.JTextField tbUsuario;
    // End of variables declaration//GEN-END:variables
}
