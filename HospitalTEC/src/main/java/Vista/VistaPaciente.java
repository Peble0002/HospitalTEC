/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author LUIS LEITON
 */
public class VistaPaciente extends javax.swing.JFrame {

    /**
     * Creates new form VistaPaciente
     */
    public VistaPaciente() {
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

        btnSolicitarCita = new javax.swing.JButton();
        btnCancelarCita = new javax.swing.JButton();
        btnCitasAsociadas = new javax.swing.JButton();
        btnDiagnosticos = new javax.swing.JButton();
        btnHospitalizaciones = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnTratamientos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSolicitarCita.setBackground(new java.awt.Color(0, 102, 102));
        btnSolicitarCita.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSolicitarCita.setText("Solicitar cita");
        btnSolicitarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarCitaActionPerformed(evt);
            }
        });

        btnCancelarCita.setBackground(new java.awt.Color(0, 102, 102));
        btnCancelarCita.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelarCita.setText("Cancelar cita");
        btnCancelarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCitaActionPerformed(evt);
            }
        });

        btnCitasAsociadas.setBackground(new java.awt.Color(0, 102, 102));
        btnCitasAsociadas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCitasAsociadas.setText("Citas asociadas");
        btnCitasAsociadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitasAsociadasActionPerformed(evt);
            }
        });

        btnDiagnosticos.setBackground(new java.awt.Color(0, 102, 102));
        btnDiagnosticos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDiagnosticos.setText("Diagnósticos");
        btnDiagnosticos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiagnosticosActionPerformed(evt);
            }
        });

        btnHospitalizaciones.setBackground(new java.awt.Color(0, 102, 102));
        btnHospitalizaciones.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHospitalizaciones.setText("Hospitalizaciones");
        btnHospitalizaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHospitalizacionesActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Bienvenido");

        btnVolver.setBackground(new java.awt.Color(0, 102, 102));
        btnVolver.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnTratamientos.setBackground(new java.awt.Color(0, 102, 102));
        btnTratamientos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTratamientos.setText("Tratamientos");
        btnTratamientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTratamientosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSolicitarCita)
                .addGap(39, 39, 39)
                .addComponent(btnCancelarCita)
                .addGap(36, 36, 36)
                .addComponent(btnCitasAsociadas)
                .addGap(33, 33, 33)
                .addComponent(btnDiagnosticos)
                .addGap(27, 27, 27)
                .addComponent(btnTratamientos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnHospitalizaciones)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(btnVolver)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSolicitarCita)
                    .addComponent(btnCancelarCita)
                    .addComponent(btnCitasAsociadas)
                    .addComponent(btnDiagnosticos)
                    .addComponent(btnHospitalizaciones)
                    .addComponent(btnTratamientos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCitaActionPerformed
        CancelarCita CC = new CancelarCita();
        CC.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnCancelarCitaActionPerformed

    private void btnSolicitarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarCitaActionPerformed
        SolicitarCita SC = new SolicitarCita();
        SC.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnSolicitarCitaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
      Principal P = new Principal();
      P.setVisible(true);

      this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnCitasAsociadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitasAsociadasActionPerformed
      CitasAsociadasPaciente CAP = new CitasAsociadasPaciente();
      CAP.setVisible(true);

      this.dispose();
    }//GEN-LAST:event_btnCitasAsociadasActionPerformed

    private void btnDiagnosticosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiagnosticosActionPerformed
      DiagnosticosAsociadosPaciente DAP = new DiagnosticosAsociadosPaciente();
      DAP.setVisible(true);

      this.dispose();
    }//GEN-LAST:event_btnDiagnosticosActionPerformed

    private void btnTratamientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTratamientosActionPerformed
      TratamientosAsociadosPaciente TAP = new TratamientosAsociadosPaciente();
      TAP.setVisible(true);

      this.dispose(); 
    }//GEN-LAST:event_btnTratamientosActionPerformed

    private void btnHospitalizacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHospitalizacionesActionPerformed
      HospitalizacionesAsociadasPaciente HAP = new HospitalizacionesAsociadasPaciente();
      HAP.setVisible(true);

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
            java.util.logging.Logger.getLogger(VistaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelarCita;
    public javax.swing.JButton btnCitasAsociadas;
    public javax.swing.JButton btnDiagnosticos;
    public javax.swing.JButton btnHospitalizaciones;
    public javax.swing.JButton btnSolicitarCita;
    public javax.swing.JButton btnTratamientos;
    public javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
