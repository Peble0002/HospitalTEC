/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author LUIS LEITON
 */
public class VistaSecretario extends javax.swing.JFrame {

    /**
     * Creates new form VistaSecretario
     */
    public VistaSecretario() {
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

        btnCancelarCita = new javax.swing.JButton();
        btnCitasRegistradas = new javax.swing.JButton();
        btnHospitalizaciones = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnAsignarCita = new javax.swing.JButton();
        btnRCentroMedico = new javax.swing.JButton();
        btnRDiagnosticos = new javax.swing.JButton();
        btnAsignarTD = new javax.swing.JButton();
        btnRATrabajo = new javax.swing.JButton();
        btnRTratamientos = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCancelarCita.setBackground(new java.awt.Color(0, 102, 102));
        btnCancelarCita.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelarCita.setText("Cancelar cita");
        btnCancelarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCitaActionPerformed(evt);
            }
        });

        btnCitasRegistradas.setBackground(new java.awt.Color(0, 102, 102));
        btnCitasRegistradas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCitasRegistradas.setText("Citas registradas");
        btnCitasRegistradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitasRegistradasActionPerformed(evt);
            }
        });

        btnHospitalizaciones.setBackground(new java.awt.Color(0, 102, 102));
        btnHospitalizaciones.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHospitalizaciones.setText("Hospitalizaciones registradas");
        btnHospitalizaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHospitalizacionesActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Bienvenido");

        btnAsignarCita.setBackground(new java.awt.Color(0, 102, 102));
        btnAsignarCita.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAsignarCita.setText("Asignar cita");
        btnAsignarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarCitaActionPerformed(evt);
            }
        });

        btnRCentroMedico.setBackground(new java.awt.Color(0, 102, 102));
        btnRCentroMedico.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRCentroMedico.setText("Registrar Centro Médico");
        btnRCentroMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRCentroMedicoActionPerformed(evt);
            }
        });

        btnRDiagnosticos.setBackground(new java.awt.Color(0, 102, 102));
        btnRDiagnosticos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRDiagnosticos.setText("Registrar Diagnósticos");
        btnRDiagnosticos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRDiagnosticosActionPerformed(evt);
            }
        });

        btnAsignarTD.setBackground(new java.awt.Color(0, 102, 102));
        btnAsignarTD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAsignarTD.setText("Asociar Tratamiento-Diagnóstico");
        btnAsignarTD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarTDActionPerformed(evt);
            }
        });

        btnRATrabajo.setBackground(new java.awt.Color(0, 102, 102));
        btnRATrabajo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRATrabajo.setText("Registro Área de trabajo");
        btnRATrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRATrabajoActionPerformed(evt);
            }
        });

        btnRTratamientos.setBackground(new java.awt.Color(0, 102, 102));
        btnRTratamientos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRTratamientos.setText("Registro Tratamiento");
        btnRTratamientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRTratamientosActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(0, 102, 102));
        btnVolver.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnHospitalizaciones)
                                .addGap(50, 50, 50)
                                .addComponent(btnCancelarCita)))
                        .addGap(73, 73, 73)
                        .addComponent(btnCitasRegistradas)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRCentroMedico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRDiagnosticos)
                                .addGap(43, 43, 43)
                                .addComponent(btnRTratamientos))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnVolver))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnRATrabajo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                        .addComponent(btnAsignarCita)))
                                .addGap(39, 39, 39)
                                .addComponent(btnAsignarTD)))
                        .addGap(56, 56, 56))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCitasRegistradas)
                    .addComponent(btnHospitalizaciones)
                    .addComponent(btnCancelarCita))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRCentroMedico)
                    .addComponent(btnRDiagnosticos)
                    .addComponent(btnRTratamientos))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRATrabajo)
                    .addComponent(btnAsignarCita)
                    .addComponent(btnAsignarTD))
                .addGap(34, 34, 34)
                .addComponent(btnVolver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCitaActionPerformed
      CancelarCitaSecretario CCS = new CancelarCitaSecretario();
      CCS.setVisible(true);

      this.dispose();
    }//GEN-LAST:event_btnCancelarCitaActionPerformed

    private void btnAsignarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarCitaActionPerformed

    }//GEN-LAST:event_btnAsignarCitaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Principal P = new Principal();
        P.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnRCentroMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRCentroMedicoActionPerformed
      RegistrarCentroAtencion RCA = new RegistrarCentroAtencion();
      RCA.setVisible(true);

      this.dispose();
    }//GEN-LAST:event_btnRCentroMedicoActionPerformed

    private void btnRDiagnosticosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRDiagnosticosActionPerformed
      RegistrarCatalogoDiagnosticos RCD = new RegistrarCatalogoDiagnosticos();
      RCD.setVisible(true);

      this.dispose();
    }//GEN-LAST:event_btnRDiagnosticosActionPerformed

    private void btnRTratamientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRTratamientosActionPerformed
      RegistrarTratamiento RT = new RegistrarTratamiento();
      RT.setVisible(true);

      this.dispose();
    }//GEN-LAST:event_btnRTratamientosActionPerformed

    private void btnRATrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRATrabajoActionPerformed
      RegistroAreaTrabajo RAT = new RegistroAreaTrabajo();
      RAT.setVisible(true);

      this.dispose();
    }//GEN-LAST:event_btnRATrabajoActionPerformed

    private void btnAsignarTDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarTDActionPerformed
      AsociarTratamientoDiagnostico ATD = new AsociarTratamientoDiagnostico();
      ATD.setVisible(true);

      this.dispose();
    }//GEN-LAST:event_btnAsignarTDActionPerformed

    private void btnCitasRegistradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitasRegistradasActionPerformed
      CitasSistema CS = new CitasSistema();
      CS.setVisible(true);

      this.dispose();
    }//GEN-LAST:event_btnCitasRegistradasActionPerformed

    private void btnHospitalizacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHospitalizacionesActionPerformed
      HospitalizacionesSistema HS = new HospitalizacionesSistema();
      HS.setVisible(true);

      this.dispose();
    }//GEN-LAST:event_btnHospitalizacionesActionPerformed

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
            java.util.logging.Logger.getLogger(VistaSecretario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaSecretario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaSecretario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaSecretario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaSecretario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAsignarCita;
    public javax.swing.JButton btnAsignarTD;
    public javax.swing.JButton btnCancelarCita;
    public javax.swing.JButton btnCitasRegistradas;
    public javax.swing.JButton btnHospitalizaciones;
    public javax.swing.JButton btnRATrabajo;
    public javax.swing.JButton btnRCentroMedico;
    public javax.swing.JButton btnRDiagnosticos;
    public javax.swing.JButton btnRTratamientos;
    public javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
