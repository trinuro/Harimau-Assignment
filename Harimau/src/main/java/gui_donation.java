
import java.awt.BorderLayout;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author user
 */
public class gui_donation extends javax.swing.JFrame {

    ExistingUser user;

    /**
     * Creates new form gui_home
     */
    
    
    public gui_donation() {
        initComponents();


        user = new ExistingUser();
        showCurrentPoint.setText(login.getUserData(user.getUsername(), "current_points"));       
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. T                                                                                                                                                                                                                                                                                                                                                                                                          ````````````````````````````````````````````````````he content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_menu = new javax.swing.JPanel();
        label_home = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        donateMoney1 = new javax.swing.JTextField();
        cfDonate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        warning = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        showCurrentPoint = new javax.swing.JLabel();
        donateHistory = new javax.swing.JButton();
        panel_main = new javax.swing.JPanel();
        btn_home = new javax.swing.JButton();
        btn_store = new javax.swing.JButton();
        btn_Quiz = new javax.swing.JButton();
        btn_donation = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(235, 243, 232));

        panel_menu.setBackground(new java.awt.Color(235, 243, 232));
        panel_menu.setMaximumSize(new java.awt.Dimension(1960, 1080));
        panel_menu.setMinimumSize(new java.awt.Dimension(1960, 1080));

        label_home.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        label_home.setText("DONATION");

        jPanel1.setBackground(new java.awt.Color(210, 227, 200));

        jLabel2.setText("Organization:");

        jLabel3.setText("Donation:");

        donateMoney1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                donateMoney1ActionPerformed(evt);
            }
        });
        donateMoney1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                donateMoney1KeyTyped(evt);
            }
        });

        cfDonate.setText("Confirm");
        cfDonate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cfDonateActionPerformed(evt);
            }
        });

        jLabel1.setText("  $");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"WWF", "GreenPeace", "The Nature Conservancy", "NWF" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        warning.setForeground(new java.awt.Color(255, 0, 0));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel4.setText("Reminder: 90% of the donation money goes to the NGO, and 10% of the money will be used to fund the project !");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(734, Short.MAX_VALUE)
                        .addComponent(cfDonate))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(warning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(donateMoney1, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(371, 371, 371))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(donateMoney1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warning)
                .addGap(35, 35, 35)
                .addComponent(cfDonate)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        donateHistory.setText("View donate history");
        donateHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                donateHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_menuLayout = new javax.swing.GroupLayout(panel_menu);
        panel_menu.setLayout(panel_menuLayout);
        panel_menuLayout.setHorizontalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_menuLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_menuLayout.createSequentialGroup()
                        .addComponent(label_home, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(640, 640, 640)
                        .addComponent(donateHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(showCurrentPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(993, Short.MAX_VALUE))
        );
        panel_menuLayout.setVerticalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_menuLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_home, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_menuLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(showCurrentPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(donateHistory))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_main.setBackground(new java.awt.Color(134, 167, 137));

        btn_home.setBackground(new java.awt.Color(134, 167, 137));
        btn_home.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btn_home.setForeground(new java.awt.Color(255, 255, 255));
        btn_home.setText("HOME");
        btn_home.setBorder(null);
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        btn_store.setBackground(new java.awt.Color(134, 167, 137));
        btn_store.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btn_store.setForeground(new java.awt.Color(255, 255, 255));
        btn_store.setText("STORE");
        btn_store.setBorder(null);
        btn_store.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_storeActionPerformed(evt);
            }
        });

        btn_Quiz.setBackground(new java.awt.Color(134, 167, 137));
        btn_Quiz.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btn_Quiz.setForeground(new java.awt.Color(255, 255, 255));
        btn_Quiz.setText("QUIZ");
        btn_Quiz.setBorder(null);
        btn_Quiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QuizActionPerformed(evt);
            }
        });

        btn_donation.setBackground(new java.awt.Color(134, 167, 137));
        btn_donation.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btn_donation.setForeground(new java.awt.Color(255, 255, 255));
        btn_donation.setText("DONATION");
        btn_donation.setBorder(null);
        btn_donation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_donationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_mainLayout = new javax.swing.GroupLayout(panel_main);
        panel_main.setLayout(panel_mainLayout);
        panel_mainLayout.setHorizontalGroup(
            panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_mainLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Quiz, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_store, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(btn_Quiz, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_store, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 175, Short.MAX_VALUE))
            .addComponent(panel_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //handle action when store button is pressed
    private void btn_storeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_storeActionPerformed
        
        gui_store StoreFrame = new gui_store();
        StoreFrame.setVisible(true);
        StoreFrame.pack();
        StoreFrame.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btn_storeActionPerformed

    //handle action when quiz button is pressed
    private void btn_QuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QuizActionPerformed
       
        gui_dailyTrivia1 QuizFrame = new gui_dailyTrivia1();
        QuizFrame.setVisible(true);
        QuizFrame.pack();
        QuizFrame.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btn_QuizActionPerformed

    //handle action when home button is pressed
    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        
        gui_home HomeFrame = new gui_home();
        HomeFrame.setVisible(true);
        HomeFrame.pack();
        HomeFrame.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btn_homeActionPerformed

    //handle action when donation button is pressed
    private void btn_donationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_donationActionPerformed
        
        gui_donation DonationFrame = new gui_donation();
        DonationFrame.setVisible(true);
        DonationFrame.pack();
        DonationFrame.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btn_donationActionPerformed

    //handle action when back button is pressed
    private void cfDonateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cfDonateActionPerformed
        String organisationName = jComboBox1.getSelectedItem().toString();
        String donationValue = donateMoney1.getText();
        double donationAmount = Double.parseDouble(donationValue);

        if(evt.getSource() == cfDonate){ 
            if(donationValue.isEmpty() || jComboBox1.getSelectedItem() == null || donationAmount <= 0){
                    JOptionPane.showMessageDialog(null, "Pleanse enter a valid donation amount and select an organization");
            }
            else{
                try{
                    store_donation.getDonationPoint(user.getUsername(), (double)donationAmount, organisationName); 
                    JOptionPane.showMessageDialog(null,"Congrats, you successfully donate to " + jComboBox1.getSelectedItem());
                }catch(NumberFormatException e){
                    //catch if the entered messsage is not a numeric String, then will show this message                    
                    JOptionPane.showMessageDialog(null,"Invalid donation amount. Try again.");
                }
            }
        }
        //clear the text after the button is clicked
        donateMoney1.setText("");
        //update the current point
        showCurrentPoint.setText(login.getUserData(user.getUsername(), "current_points"));
    }//GEN-LAST:event_cfDonateActionPerformed

    private void donateMoney1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_donateMoney1ActionPerformed
     
    }//GEN-LAST:event_donateMoney1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
    }//GEN-LAST:event_jComboBox1ActionPerformed
    
    //handle action when donate history button is pressed
    private void donateHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_donateHistoryActionPerformed
        if(evt.getSource() == donateHistory){
            JDialog dialog = new JDialog();
            dialog.setTitle("Donate history");
        
            ArrayList<String> DonationsData = Utilities.getDonationsData(user.getUsername());
            StringBuilder Donation = new StringBuilder();
            
            for(String data: DonationsData){
                Donation.append(data).append("\n");
            }          
            
            //Create JTextArea to display the donation history
            JTextArea textArea = new JTextArea(Donation.toString());
            textArea.setEditable(false);
            
            textArea.setAlignmentX(CENTER_ALIGNMENT);
            
            //add scroolpane for scrolling down
            JScrollPane scrollPane = new JScrollPane(textArea);
            
            dialog.setLayout(new BorderLayout());
            
            dialog.add(scrollPane, BorderLayout.CENTER);
            
            dialog.setSize(400,200);
            
            //make the dialog at the center of screen
            dialog.setLocationRelativeTo(null);
            
            //make the dialog visible
            dialog.setVisible(true);        
        }
    }//GEN-LAST:event_donateHistoryActionPerformed

    private void donateMoney1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_donateMoney1KeyTyped
        //To make sure the user not enter alphabet in this JTextField
        char c = evt.getKeyChar();
        
        if(!Character.isDigit(c)){
            evt.consume();
            warning.setText("Enter numbers only");
        }
        else{
            warning.setText("");
        }
            
    }//GEN-LAST:event_donateMoney1KeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Quiz;
    private javax.swing.JButton btn_donation;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_store;
    private javax.swing.JButton cfDonate;
    private javax.swing.JButton donateHistory;
    private javax.swing.JTextField donateMoney1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_home;
    private javax.swing.JPanel panel_main;
    private javax.swing.JPanel panel_menu;
    private javax.swing.JLabel showCurrentPoint;
    private javax.swing.JLabel warning;
    // End of variables declaration//GEN-END:variables
}
