

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author user
 */
public class gui_plantTree extends javax.swing.JFrame {

    /**
     * Creates new form gui_home
     */
    private ExistingUser a;
    
    public gui_plantTree() {
        a = new ExistingUser();
        
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        panel_menu = new javax.swing.JPanel();
        label_home = new javax.swing.JLabel();
        plantTree1BG = new javax.swing.JPanel();
        tree1 = new javax.swing.JLabel();
        nameTree1 = new javax.swing.JLabel();
        tree1btn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        nameOfTree1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        plantTree2BG = new javax.swing.JPanel();
        tree2 = new javax.swing.JLabel();
        nameTree2 = new javax.swing.JLabel();
        tree2btn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        nameOfTree2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        plantTree2BG1 = new javax.swing.JPanel();
        tree3 = new javax.swing.JLabel();
        nameTree3 = new javax.swing.JLabel();
        tree3btn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        nameOfTree3 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        purchaseHistorybtn = new javax.swing.JButton();
        panel_main = new javax.swing.JPanel();
        btn_home = new javax.swing.JButton();
        btn_store = new javax.swing.JButton();
        btn_Quiz = new javax.swing.JButton();
        btn_donation = new javax.swing.JButton();

        jPopupMenu1.setBackground(new java.awt.Color(235, 243, 232));
        jPopupMenu1.setMaximumSize(new java.awt.Dimension(400, 400));
        jPopupMenu1.setMinimumSize(new java.awt.Dimension(400, 400));
        jPopupMenu1.setPreferredSize(new java.awt.Dimension(400, 400));

        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(235, 243, 232));

        panel_menu.setBackground(new java.awt.Color(235, 243, 232));
        panel_menu.setMaximumSize(new java.awt.Dimension(1960, 1080));
        panel_menu.setMinimumSize(new java.awt.Dimension(1960, 1080));

        label_home.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        label_home.setText("Plant A Tree");

        plantTree1BG.setBackground(new java.awt.Color(210, 227, 200));

        tree1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tree1redo.jpg"))); // NOI18N

        nameTree1.setText("Cottonwood");

        tree1btn.setText("Plant");
        tree1btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tree1btnActionPerformed(evt);
            }
        });

        jLabel3.setText("Points needed: 20 points");

        nameOfTree1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameOfTree1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Name of tree: ");

        javax.swing.GroupLayout plantTree1BGLayout = new javax.swing.GroupLayout(plantTree1BG);
        plantTree1BG.setLayout(plantTree1BGLayout);
        plantTree1BGLayout.setHorizontalGroup(
            plantTree1BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plantTree1BGLayout.createSequentialGroup()
                .addGroup(plantTree1BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plantTree1BGLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(tree1btn))
                    .addGroup(plantTree1BGLayout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(nameTree1))
                    .addGroup(plantTree1BGLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(plantTree1BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(nameOfTree1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plantTree1BGLayout.createSequentialGroup()
                .addGap(0, 137, Short.MAX_VALUE)
                .addComponent(tree1)
                .addGap(132, 132, 132))
        );
        plantTree1BGLayout.setVerticalGroup(
            plantTree1BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plantTree1BGLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(tree1)
                .addGap(18, 18, 18)
                .addComponent(nameTree1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(37, 37, 37)
                .addGroup(plantTree1BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(nameOfTree1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(tree1btn)
                .addGap(56, 56, 56))
        );

        jLabel2.setText("Point:  ");

        plantTree2BG.setBackground(new java.awt.Color(210, 227, 200));

        tree2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tree2redo.jpg"))); // NOI18N

        nameTree2.setText("Magnolia");

        tree2btn.setText("Plant");
        tree2btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tree2btnActionPerformed(evt);
            }
        });

        jLabel4.setText("Points needed: 30 points");

        jLabel10.setText("Name of tree: ");

        javax.swing.GroupLayout plantTree2BGLayout = new javax.swing.GroupLayout(plantTree2BG);
        plantTree2BG.setLayout(plantTree2BGLayout);
        plantTree2BGLayout.setHorizontalGroup(
            plantTree2BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plantTree2BGLayout.createSequentialGroup()
                .addGroup(plantTree2BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plantTree2BGLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(tree2btn))
                    .addGroup(plantTree2BGLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(tree2))
                    .addGroup(plantTree2BGLayout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(nameTree2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(plantTree2BGLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(plantTree2BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(nameOfTree2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        plantTree2BGLayout.setVerticalGroup(
            plantTree2BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plantTree2BGLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(tree2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(nameTree2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(40, 40, 40)
                .addGroup(plantTree2BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameOfTree2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(tree2btn)
                .addContainerGap())
        );

        plantTree2BG1.setBackground(new java.awt.Color(210, 227, 200));

        tree3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tree3redo.jpg"))); // NOI18N

        nameTree3.setText("Beech");

        tree3btn.setText("Plant");
        tree3btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tree3btnActionPerformed(evt);
            }
        });

        jLabel5.setText("Points needed: 40 points");

        jLabel12.setText("Name of tree:");

        javax.swing.GroupLayout plantTree2BG1Layout = new javax.swing.GroupLayout(plantTree2BG1);
        plantTree2BG1.setLayout(plantTree2BG1Layout);
        plantTree2BG1Layout.setHorizontalGroup(
            plantTree2BG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plantTree2BG1Layout.createSequentialGroup()
                .addGroup(plantTree2BG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(plantTree2BG1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(tree3))
                    .addGroup(plantTree2BG1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameOfTree3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addContainerGap(133, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plantTree2BG1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(nameTree3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(plantTree2BG1Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plantTree2BG1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tree3btn)
                .addGap(181, 181, 181))
        );
        plantTree2BG1Layout.setVerticalGroup(
            plantTree2BG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plantTree2BG1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(tree3, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(nameTree3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(31, 31, 31)
                .addGroup(plantTree2BG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(nameOfTree3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tree3btn)
                .addGap(60, 60, 60))
        );

        purchaseHistorybtn.setText("View purchase history");
        purchaseHistorybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseHistorybtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_menuLayout = new javax.swing.GroupLayout(panel_menu);
        panel_menu.setLayout(panel_menuLayout);
        panel_menuLayout.setHorizontalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_menuLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_menuLayout.createSequentialGroup()
                        .addComponent(plantTree1BG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(plantTree2BG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(plantTree2BG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel_menuLayout.createSequentialGroup()
                        .addComponent(label_home, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 963, Short.MAX_VALUE)
                        .addComponent(purchaseHistorybtn)
                        .addGap(85, 85, 85)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1053, 1053, 1053))))
        );
        panel_menuLayout.setVerticalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_menuLayout.createSequentialGroup()
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_menuLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(purchaseHistorybtn)
                            .addComponent(jLabel2))
                        .addGap(23, 23, 23))
                    .addGroup(panel_menuLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(label_home, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(plantTree2BG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(plantTree1BG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(plantTree2BG1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btn_storeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_storeActionPerformed
        // TODO add your handling code here:
        gui_quiz QuizFrame = new gui_quiz();
        QuizFrame.setVisible(true);
        QuizFrame.pack();
        QuizFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btn_storeActionPerformed

    private void btn_QuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QuizActionPerformed
        // TODO add your handling code here:
        gui_quiz QuizFrame = new gui_quiz();
        QuizFrame.setVisible(true);
        QuizFrame.pack();
        QuizFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btn_QuizActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        // TODO add your handling code here:
        gui_home HomeFrame = new gui_home();
        HomeFrame.setVisible(true);
        HomeFrame.pack();
        HomeFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_donationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_donationActionPerformed
        // TODO add your handling code here:
        gui_donation DonationFrame = new gui_donation();
        DonationFrame.setVisible(true);
        DonationFrame.pack();
        DonationFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btn_donationActionPerformed

    private void tree1btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tree1btnActionPerformed
            if(evt.getSource() == tree1btn){
                String treename = nameOfTree1.getText();

            store_donation.getPlantATreePoint(a.getUsername(), treename);
            }
    }//GEN-LAST:event_tree1btnActionPerformed

    private void tree2btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tree2btnActionPerformed
        if(evt.getSource() == tree2btn){
                String treename = nameOfTree2.getText();

                store_donation.getPlantATreePoint(a.getUsername(), treename);
                }
    }//GEN-LAST:event_tree2btnActionPerformed

    private void tree3btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tree3btnActionPerformed
        if(evt.getSource() == tree3btn){
                String treename = nameOfTree3.getText();

                    store_donation.getPlantATreePoint(a.getUsername(), treename);
                }
    }//GEN-LAST:event_tree3btnActionPerformed

    private void nameOfTree1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameOfTree1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameOfTree1ActionPerformed

    private void purchaseHistorybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseHistorybtnActionPerformed
        
        if(evt.getSource() == purchaseHistorybtn){
            //getTreePlantedData
        }
    }//GEN-LAST:event_purchaseHistorybtnActionPerformed

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
            java.util.logging.Logger.getLogger(gui_donation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui_donation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui_donation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui_donation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui_donation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Quiz;
    private javax.swing.JButton btn_donation;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_store;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel label_home;
    private javax.swing.JTextField nameOfTree1;
    private javax.swing.JTextField nameOfTree2;
    private javax.swing.JTextField nameOfTree3;
    private javax.swing.JLabel nameTree1;
    private javax.swing.JLabel nameTree2;
    private javax.swing.JLabel nameTree3;
    private javax.swing.JPanel panel_main;
    private javax.swing.JPanel panel_menu;
    private javax.swing.JPanel plantTree1BG;
    private javax.swing.JPanel plantTree2BG;
    private javax.swing.JPanel plantTree2BG1;
    private javax.swing.JButton purchaseHistorybtn;
    private javax.swing.JLabel tree1;
    private javax.swing.JButton tree1btn;
    private javax.swing.JLabel tree2;
    private javax.swing.JButton tree2btn;
    private javax.swing.JLabel tree3;
    private javax.swing.JButton tree3btn;
    // End of variables declaration//GEN-END:variables
}
