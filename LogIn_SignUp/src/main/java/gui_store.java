

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author user
 */
public class gui_store extends javax.swing.JFrame {
    ExistingUser user = new ExistingUser();
    
    /**
     * Creates new form gui_home
     */
    public gui_store() {
        initComponents();
        showCurrentPoint.setText(login.getUserData(user.getUsername(), "current_points"));

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
        label_home = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_merchandise = new javax.swing.JButton();
        img_merchandise = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_plantTree = new javax.swing.JButton();
        img_plantTree = new javax.swing.JLabel();
        showCurrentPoint = new javax.swing.JLabel();
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
        label_home.setText("STORE");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btn_merchandise.setBackground(new java.awt.Color(0, 0, 0));
        btn_merchandise.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btn_merchandise.setForeground(new java.awt.Color(255, 255, 255));
        btn_merchandise.setText("Merchandise");
        btn_merchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_merchandiseActionPerformed(evt);
            }
        });

        img_merchandise.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+("\\src\\main\\Images\\imgStore.jpg")));
        img_merchandise.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(btn_merchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(img_merchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(img_merchandise, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_merchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btn_plantTree.setBackground(new java.awt.Color(0, 0, 0));
        btn_plantTree.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btn_plantTree.setForeground(new java.awt.Color(255, 255, 255));
        btn_plantTree.setText("Plant A Tree");
        btn_plantTree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_plantTreeActionPerformed(evt);
            }
        });

        img_plantTree.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+("\\src\\main\\Images\\imgTree.jpg")));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(btn_plantTree, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(img_plantTree, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(img_plantTree, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btn_plantTree, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout panel_menuLayout = new javax.swing.GroupLayout(panel_menu);
        panel_menu.setLayout(panel_menuLayout);
        panel_menuLayout.setHorizontalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_menuLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_menuLayout.createSequentialGroup()
                        .addComponent(label_home, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(716, 716, 716)
                        .addComponent(showCurrentPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_menuLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1216, Short.MAX_VALUE))
        );
        panel_menuLayout.setVerticalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_menuLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_home, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showCurrentPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(panel_mainLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Quiz, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_store, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_donation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    //handle action when plant a tree button is pressed
    private void btn_plantTreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_plantTreeActionPerformed
        
        gui_plantTree DonationFrame = new gui_plantTree();
        DonationFrame.setVisible(true);
        DonationFrame.pack();
        DonationFrame.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btn_plantTreeActionPerformed

    //handle action when merchandise button is pressed
    private void btn_merchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_merchandiseActionPerformed
        
        gui_merchandise StoreFrame = new gui_merchandise();
        StoreFrame.setVisible(true);
        StoreFrame.pack();
        StoreFrame.setLocationRelativeTo(null);

    }//GEN-LAST:event_btn_merchandiseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Quiz;
    private javax.swing.JButton btn_donation;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_merchandise;
    private javax.swing.JButton btn_plantTree;
    private javax.swing.JButton btn_store;
    private javax.swing.JLabel img_merchandise;
    private javax.swing.JLabel img_plantTree;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label_home;
    private javax.swing.JPanel panel_main;
    private javax.swing.JPanel panel_menu;
    private javax.swing.JLabel showCurrentPoint;
    // End of variables declaration//GEN-END:variables
}
