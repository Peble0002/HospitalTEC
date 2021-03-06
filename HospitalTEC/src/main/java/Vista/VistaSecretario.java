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
        btnVolver = new javax.swing.JButton();
        btnRATrabajo = new javax.swing.JButton();

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

        btnVolver.setBackground(new java.awt.Color(0, 102, 102));
        btnVolver.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnRATrabajo.setBackground(new java.awt.Color(0, 102, 102));
        btnRATrabajo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRATrabajo.setText("Registro ??rea de trabajo");
        btnRATrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRATrabajoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAsignarCita)
                        .addGap(18, 18, 18)
                        .addComponent(btnHospitalizaciones)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarCita)
                        .addGap(18, 18, 18)
                        .addComponent(btnCitasRegistradas))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(287, 287, 287)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(294, 294, 294)
                                .addComponent(btnRATrabajo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(21, 21, 21))
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
                    .addComponent(btnCancelarCita)
                    .addComponent(btnAsignarCita)
                    .addComponent(btnVolver))
                .addGap(44, 44, 44)
                .addComponent(btnRATrabajo)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCitaActionPerformed

    }//GEN-LAST:event_btnCancelarCitaActionPerformed

    private void btnAsignarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarCitaActionPerformed

    }//GEN-LAST:event_btnAsignarCitaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnCitasRegistradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitasRegistradasActionPerformed

    }//GEN-LAST:event_btnCitasRegistradasActionPerformed

    private void btnHospitalizacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHospitalizacionesActionPerformed

    }//GEN-LAST:event_btnHospitalizacionesActionPerformed

    private void btnRATrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRATrabajoActionPerformed

    }//GEN-LAST:event_btnRATrabajoActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VistaSecretario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VistaSecretario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VistaSecretario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VistaSecretario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VistaSecretario().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAsignarCita;
    public javax.swing.JButton btnCancelarCita;
    public javax.swing.JButton btnCitasRegistradas;
    public javax.swing.JButton btnHospitalizaciones;
    public javax.swing.JButton btnRATrabajo;
    public javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
