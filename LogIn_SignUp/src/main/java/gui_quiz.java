

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author user
 */
public class gui_quiz extends javax.swing.JFrame {
    ExistingUser user = new ExistingUser();
    /**
     * Creates new form gui_home
     */
    public gui_quiz() {
        initComponents();
//        this.setResizable(false);
//        this.setLocationRelativeTo(null);
//        this.setSize(1960,1080);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_menu = new javax.swing.JPanel();
        panel_main = new javax.swing.JPanel();
        btn_home = new javax.swing.JButton();
        btn_quiz = new javax.swing.JButton();
        btn_store = new javax.swing.JButton();
        btn_donation = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(235, 243, 232));

        panel_menu.setBackground(new java.awt.Color(235, 243, 232));
        panel_menu.setMaximumSize(new java.awt.Dimension(1960, 1080));
        panel_menu.setMinimumSize(new java.awt.Dimension(1960, 1080));

        javax.swing.GroupLayout panel_menuLayout = new javax.swing.GroupLayout(panel_menu);
        panel_menu.setLayout(panel_menuLayout);
        panel_menuLayout.setHorizontalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2170, Short.MAX_VALUE)
        );
        panel_menuLayout.setVerticalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panel_main.setBackground(new java.awt.Color(134, 167, 137));

        btn_home.setBackground(new java.awt.Color(134, 167, 137));
        btn_home.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btn_home.setForeground(new java.awt.Color(255, 255, 255));
        btn_home.setText("HOME");
        btn_home.setBorder(null);

        btn_quiz.setBackground(new java.awt.Color(134, 167, 137));
        btn_quiz.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btn_quiz.setForeground(new java.awt.Color(255, 255, 255));
        btn_quiz.setText("STORE");
        btn_quiz.setBorder(null);
        btn_quiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quizActionPerformed(evt);
            }
        });

        btn_store.setBackground(new java.awt.Color(134, 167, 137));
        btn_store.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btn_store.setForeground(new java.awt.Color(255, 255, 255));
        btn_store.setText("QUIZ");
        btn_store.setBorder(null);
        btn_store.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_storeActionPerformed(evt);
            }
        });

        btn_donation.setBackground(new java.awt.Color(134, 167, 137));
        btn_donation.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btn_donation.setForeground(new java.awt.Color(255, 255, 255));
        btn_donation.setText("DONATION");
        btn_donation.setBorder(null);

        javax.swing.GroupLayout panel_mainLayout = new javax.swing.GroupLayout(panel_main);
        panel_main.setLayout(panel_mainLayout);
        panel_mainLayout.setHorizontalGroup(
            panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_mainLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_store, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_quiz, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_donation, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_mainLayout.setVerticalGroup(
            panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_mainLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_donation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_store, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_quiz, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(panel_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_quizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quizActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_quizActionPerformed

    private void btn_storeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_storeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_storeActionPerformed

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
            java.util.logging.Logger.getLogger(gui_quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui_quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui_quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui_quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui_quiz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_donation;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_quiz;
    private javax.swing.JButton btn_store;
    private javax.swing.JPanel panel_main;
    private javax.swing.JPanel panel_menu;
    // End of variables declaration//GEN-END:variables
}
