/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author LUIS LEITON
 */
public class AtenderCita extends javax.swing.JFrame {

    /**
     * Creates new form AtenderCita
     */
    public AtenderCita() {
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

    btnVolver = new javax.swing.JButton();
    jLabel5 = new javax.swing.JLabel();
    cbCedulasPacientes = new javax.swing.JComboBox<>();
    btnInternar = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    btnRegistrarDiagnostico = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    btnVolver.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    btnVolver.setForeground(new java.awt.Color(11, 136, 136));
    btnVolver.setText("Volver");
    btnVolver.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnVolverActionPerformed(evt);
      }
    });

    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(0, 153, 153));
    jLabel5.setText("Atender Cita");

    cbCedulasPacientes.setBackground(new java.awt.Color(192, 225, 249));
    cbCedulasPacientes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

    btnInternar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    btnInternar.setForeground(new java.awt.Color(11, 136, 136));
    btnInternar.setText("Internar Paciente");
    btnInternar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnInternarActionPerformed(evt);
      }
    });

    jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(0, 153, 153));
    jLabel2.setText("Seleccione la cédula del paciente a atender");

    btnRegistrarDiagnostico.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    btnRegistrarDiagnostico.setForeground(new java.awt.Color(11, 136, 136));
    btnRegistrarDiagnostico.setText("Registrar Diagnóstico");
    btnRegistrarDiagnostico.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnRegistrarDiagnosticoActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(35, 35, 35)
            .addComponent(btnRegistrarDiagnostico)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnInternar))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(cbCedulasPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap(43, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(btnVolver)
        .addGap(291, 291, 291))
      .addGroup(layout.createSequentialGroup()
        .addGap(251, 251, 251)
        .addComponent(jLabel5)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel5)
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(cbCedulasPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(56, 56, 56)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnRegistrarDiagnostico)
          .addComponent(btnInternar))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
        .addComponent(btnVolver)
        .addGap(36, 36, 36))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarDiagnosticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarDiagnosticoActionPerformed

    }//GEN-LAST:event_btnRegistrarDiagnosticoActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnInternarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInternarActionPerformed

    }//GEN-LAST:event_btnInternarActionPerformed

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
//            java.util.logging.Logger.getLogger(AtenderCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AtenderCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AtenderCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AtenderCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AtenderCita().setVisible(true);
//            }
//        });
//    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  public javax.swing.JButton btnInternar;
  public javax.swing.JButton btnRegistrarDiagnostico;
  public javax.swing.JButton btnVolver;
  public javax.swing.JComboBox<String> cbCedulasPacientes;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel5;
  // End of variables declaration//GEN-END:variables
}
