/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import javax.swing.JOptionPane;
/**
 *
 * @author Tan Zhi Wei
 */
public class signup_gui extends javax.swing.JFrame {    
//check .getUsername same or not
    
    
    
    /**
     * Creates new form signup_gui
     */
    public signup_gui() {
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

        jPanel1 = new javax.swing.JPanel();
        background = new javax.swing.JPanel();
        front = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        emailEnter = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        usernameEnter = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        passwordEnter1 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        cfPasswordEnter = new javax.swing.JPasswordField();
        back = new javax.swing.JButton();
        signupbtn = new javax.swing.JButton();
        iconDisable1 = new javax.swing.JLabel();
        iconShow1 = new javax.swing.JLabel();
        iconDisable2 = new javax.swing.JLabel();
        iconShow2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1600, 800));
        jPanel1.setLayout(null);

        background.setBackground(new java.awt.Color(134, 167, 137));
        background.setPreferredSize(new java.awt.Dimension(1600, 1000));

        front.setBackground(new java.awt.Color(235, 243, 232));
        front.setMinimumSize(new java.awt.Dimension(800, 1000));
        front.setPreferredSize(new java.awt.Dimension(800, 1000));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Sign Up");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setText("Email");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setText("Username");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setText("Comfirmed Password");

        back.setBackground(new java.awt.Color(134, 167, 137));
        back.setForeground(new java.awt.Color(235, 243, 232));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        signupbtn.setBackground(new java.awt.Color(134, 167, 137));
        signupbtn.setForeground(new java.awt.Color(235, 243, 232));
        signupbtn.setText("Sign Up");
        signupbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupbtnActionPerformed(evt);
            }
        });

        iconDisable1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/closeeye.png"))); // NOI18N
        iconDisable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                iconDisable1MousePressed(evt);
            }
        });

        iconShow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/openeye.png"))); // NOI18N
        iconShow1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                iconShow1MousePressed(evt);
            }
        });

        iconDisable2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/closeeye.png"))); // NOI18N
        iconDisable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                iconDisable2MousePressed(evt);
            }
        });

        iconShow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/openeye.png"))); // NOI18N
        iconShow2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                iconShow2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout frontLayout = new javax.swing.GroupLayout(front);
        front.setLayout(frontLayout);
        frontLayout.setHorizontalGroup(
            frontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frontLayout.createSequentialGroup()
                .addGroup(frontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frontLayout.createSequentialGroup()
                        .addGap(526, 526, 526)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(frontLayout.createSequentialGroup()
                        .addGap(415, 415, 415)
                        .addGroup(frontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameEnter, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frontLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(back)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(signupbtn)
                                .addGap(38, 38, 38))
                            .addComponent(emailEnter)
                            .addComponent(passwordEnter1)
                            .addComponent(cfPasswordEnter))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(frontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(iconDisable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(iconShow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(iconDisable2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(iconShow2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(433, Short.MAX_VALUE))
        );
        frontLayout.setVerticalGroup(
            frontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frontLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(iconDisable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordEnter1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(iconShow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frontLayout.createSequentialGroup()
                        .addComponent(cfPasswordEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addGroup(frontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(back)
                            .addComponent(signupbtn)))
                    .addGroup(frontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(iconDisable2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconShow2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(341, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(front, javax.swing.GroupLayout.PREFERRED_SIZE, 1196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addComponent(front, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        front.getAccessibleContext().setAccessibleName("");

        jPanel1.add(background);
        background.setBounds(0, 0, 1600, 1000);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iconShow2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconShow2MousePressed
        iconDisable2.setVisible(true);
        iconShow2.setEnabled(false);
        cfPasswordEnter.setEchoChar('*');
    }//GEN-LAST:event_iconShow2MousePressed

    private void iconDisable2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconDisable2MousePressed
        iconDisable2.setVisible(false);
        iconShow2.setEnabled(true);
        cfPasswordEnter.setEchoChar((char)0);
    }//GEN-LAST:event_iconDisable2MousePressed

    private void iconShow1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconShow1MousePressed
        iconDisable1.setVisible(true);
        iconShow1.setEnabled(false);
        passwordEnter1.setEchoChar('*');
    }//GEN-LAST:event_iconShow1MousePressed

    private void iconDisable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconDisable1MousePressed
        iconDisable1.setVisible(false);
        iconShow1.setEnabled(true);
        passwordEnter1.setEchoChar((char)0);
    }//GEN-LAST:event_iconDisable1MousePressed

    private void signupbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupbtnActionPerformed
        if(evt.getSource() == signupbtn){
            String email = emailEnter.getText();
            String username = usernameEnter.getText();
            String password = passwordEnter1.getText();
            String cfPassword = cfPasswordEnter.getText();
            NewUser usern = new NewUser(email,username,password,cfPassword);

            boolean isUserCreated = usern.createNewUser();
            if(isUserCreated == true){
                ExistingUser userm = new ExistingUser(username, email);
                userm.checkIn();
                setVisible(false);
                new gui_home().setVisible(true);
            }
            else{
                //if got error when fill in signup message
                JOptionPane.showMessageDialog(null,"Error! Please make sure your information are filled correctly.");               
            }
        }
    }//GEN-LAST:event_signupbtnActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        if(evt.getSource() == back){
            setVisible(false);
            new real_login_gui().setVisible(true);
        }
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(signup_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(signup_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(signup_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(signup_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signup_gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JPanel background;
    private javax.swing.JPasswordField cfPasswordEnter;
    private javax.swing.JTextField emailEnter;
    private javax.swing.JPanel front;
    private javax.swing.JLabel iconDisable1;
    private javax.swing.JLabel iconDisable2;
    private javax.swing.JLabel iconShow1;
    private javax.swing.JLabel iconShow2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordEnter1;
    private javax.swing.JButton signupbtn;
    private javax.swing.JTextField usernameEnter;
    // End of variables declaration//GEN-END:variables

}
