
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author user
 */
public class gui_merchandise extends javax.swing.JFrame {

    /**
     * Creates new form gui_home
     */
    public gui_merchandise() {
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
        label_home = new javax.swing.JLabel();
        panel_obj1 = new javax.swing.JPanel();
        img_obj1 = new javax.swing.JLabel();
        name_obj1 = new javax.swing.JLabel();
        point_obj1 = new javax.swing.JLabel();
        text_obj1Quantity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        text_obj1Address = new javax.swing.JTextField();
        add_obj1 = new javax.swing.JButton();
        panel_obj2 = new javax.swing.JPanel();
        name_obj2 = new javax.swing.JLabel();
        img_obj2 = new javax.swing.JLabel();
        point_obj2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        text_obj2Quantity = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        text_obj2Address = new javax.swing.JTextField();
        add_obj2 = new javax.swing.JButton();
        panel_obj3 = new javax.swing.JPanel();
        name_obj3 = new javax.swing.JLabel();
        img_obj3 = new javax.swing.JLabel();
        point_obj3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        text_obj3Quantity = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        text_obj3Address = new javax.swing.JTextField();
        add_obj3 = new javax.swing.JButton();
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
        label_home.setText("Merchandise");

        panel_obj1.setBackground(new java.awt.Color(255, 255, 255));

        img_obj1.setText("jLabel1");

        name_obj1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        name_obj1.setText("      canvas bag");

        point_obj1.setText("100 points");
        int pointObj1 = point_obj1;

        text_obj1Quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_obj1QuantityActionPerformed(evt);
            }
        });

        jLabel4.setText("Quantity");

        jLabel7.setText("Address");

        text_obj1Address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_obj1AddressActionPerformed(evt);
            }
        });

        add_obj1.setBackground(new java.awt.Color(0, 0, 0));
        add_obj1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        add_obj1.setForeground(new java.awt.Color(255, 255, 255));
        add_obj1.setText("Add");
        add_obj1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_obj1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_obj1Layout = new javax.swing.GroupLayout(panel_obj1);
        panel_obj1.setLayout(panel_obj1Layout);
        panel_obj1Layout.setHorizontalGroup(
            panel_obj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_obj1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_obj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_obj1Layout.createSequentialGroup()
                        .addComponent(point_obj1)
                        .addGap(146, 146, 146))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_obj1Layout.createSequentialGroup()
                        .addComponent(name_obj1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_obj1Layout.createSequentialGroup()
                        .addGroup(panel_obj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(add_obj1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_obj1Layout.createSequentialGroup()
                                .addGroup(panel_obj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(panel_obj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text_obj1Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(text_obj1Address, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(40, 40, 40))))
            .addGroup(panel_obj1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(img_obj1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panel_obj1Layout.setVerticalGroup(
            panel_obj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_obj1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(img_obj1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(name_obj1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(point_obj1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_obj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_obj1Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_obj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(text_obj1Address, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(add_obj1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        panel_obj2.setBackground(new java.awt.Color(255, 255, 255));

        name_obj2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        name_obj2.setText("            cap");

        img_obj2.setText("jLabel1");

        point_obj2.setText(" 200 points");

        jLabel5.setText("Quantity");

        text_obj2Quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_obj2QuantityActionPerformed(evt);
            }
        });

        jLabel8.setText("Address");

        add_obj2.setBackground(new java.awt.Color(0, 0, 0));
        add_obj2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        add_obj2.setForeground(new java.awt.Color(255, 255, 255));
        add_obj2.setText("Add");
        add_obj2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_obj2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_obj2Layout = new javax.swing.GroupLayout(panel_obj2);
        panel_obj2.setLayout(panel_obj2Layout);
        panel_obj2Layout.setHorizontalGroup(
            panel_obj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_obj2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_obj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_obj2Layout.createSequentialGroup()
                        .addComponent(name_obj2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_obj2Layout.createSequentialGroup()
                        .addGroup(panel_obj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(add_obj2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_obj2Layout.createSequentialGroup()
                                .addGroup(panel_obj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(panel_obj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text_obj2Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(text_obj2Address, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30))))
            .addGroup(panel_obj2Layout.createSequentialGroup()
                .addGroup(panel_obj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_obj2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(img_obj2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_obj2Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(point_obj2)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panel_obj2Layout.setVerticalGroup(
            panel_obj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_obj2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(img_obj2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(name_obj2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(point_obj2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_obj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(text_obj2Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_obj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(text_obj2Address, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(add_obj2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        panel_obj3.setBackground(new java.awt.Color(255, 255, 255));

        name_obj3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        name_obj3.setText("badge");

        img_obj3.setText("jLabel1");

        point_obj3.setText("80 points");

        jLabel6.setText("Quantity");

        text_obj3Quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_obj3QuantityActionPerformed(evt);
            }
        });

        jLabel9.setText("Address");

        add_obj3.setBackground(new java.awt.Color(0, 0, 0));
        add_obj3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        add_obj3.setForeground(new java.awt.Color(255, 255, 255));
        add_obj3.setText("Add");
        add_obj3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_obj3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_obj3Layout = new javax.swing.GroupLayout(panel_obj3);
        panel_obj3.setLayout(panel_obj3Layout);
        panel_obj3Layout.setHorizontalGroup(
            panel_obj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_obj3Layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addGroup(panel_obj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_obj3Layout.createSequentialGroup()
                        .addComponent(name_obj3)
                        .addGap(154, 154, 154))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_obj3Layout.createSequentialGroup()
                        .addComponent(point_obj3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142))))
            .addGroup(panel_obj3Layout.createSequentialGroup()
                .addGroup(panel_obj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(add_obj3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_obj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panel_obj3Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(img_obj3, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel_obj3Layout.createSequentialGroup()
                            .addGap(67, 67, 67)
                            .addGroup(panel_obj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel6))
                            .addGap(18, 18, 18)
                            .addGroup(panel_obj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(text_obj3Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(text_obj3Address)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_obj3Layout.setVerticalGroup(
            panel_obj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_obj3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(img_obj3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(name_obj3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(point_obj3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_obj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(text_obj3Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_obj3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(text_obj3Address, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(add_obj3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel_menuLayout = new javax.swing.GroupLayout(panel_menu);
        panel_menu.setLayout(panel_menuLayout);
        panel_menuLayout.setHorizontalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_menuLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_menuLayout.createSequentialGroup()
                        .addComponent(panel_obj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(panel_obj2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(panel_obj3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label_home, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1008, Short.MAX_VALUE))
        );
        panel_menuLayout.setVerticalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_menuLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(label_home, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_obj3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panel_obj2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel_obj1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
            .addComponent(panel_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void text_obj1QuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_obj1QuantityActionPerformed
        // TODO add your handling code here:
        //String obj1_quantity = text_obj1Quantity.getText(); 
        
    }//GEN-LAST:event_text_obj1QuantityActionPerformed

    private void text_obj2QuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_obj2QuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_obj2QuantityActionPerformed

    private void text_obj3QuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_obj3QuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_obj3QuantityActionPerformed

    private void add_obj2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_obj2ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource() == add_obj1){
             String obj2_quantity = text_obj2Quantity.getText();
             String obj2_address = text_obj2Address.getText();
            
             int point_obj2 = 200;
            
        }
    }//GEN-LAST:event_add_obj2ActionPerformed

    private void add_obj1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_obj1ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource() == add_obj1){
             String obj1_quantity = text_obj1Quantity.getText();
             String obj1_address = text_obj1Address.getText();
            
             int point_obj1 = 100;
             
             
             Utilities.getMerchandiseData("ss");
        }
    }//GEN-LAST:event_add_obj1ActionPerformed

    private void text_obj1AddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_obj1AddressActionPerformed
        // TODO add your handling code here:
        //String obj1_address = text_obj1Address.getText();
    }//GEN-LAST:event_text_obj1AddressActionPerformed

    private void add_obj3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_obj3ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource() == add_obj1){
             String obj3_quantity = text_obj3Quantity.getText();
             String obj3_address = text_obj3Address.getText();
            
             int point_obj3 = 80;
             
            
        }
    }//GEN-LAST:event_add_obj3ActionPerformed

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
    private javax.swing.JButton add_obj1;
    private javax.swing.JButton add_obj2;
    private javax.swing.JButton add_obj3;
    private javax.swing.JButton btn_Quiz;
    private javax.swing.JButton btn_donation;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_store;
    private javax.swing.JLabel img_obj1;
    private javax.swing.JLabel img_obj2;
    private javax.swing.JLabel img_obj3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel label_home;
    private javax.swing.JLabel name_obj1;
    private javax.swing.JLabel name_obj2;
    private javax.swing.JLabel name_obj3;
    private javax.swing.JPanel panel_main;
    private javax.swing.JPanel panel_menu;
    private javax.swing.JPanel panel_obj1;
    private javax.swing.JPanel panel_obj2;
    private javax.swing.JPanel panel_obj3;
    private javax.swing.JLabel point_obj1;
    private javax.swing.JLabel point_obj2;
    private javax.swing.JLabel point_obj3;
    private javax.swing.JTextField text_obj1Address;
    private javax.swing.JTextField text_obj1Quantity;
    private javax.swing.JTextField text_obj2Address;
    private javax.swing.JTextField text_obj2Quantity;
    private javax.swing.JTextField text_obj3Address;
    private javax.swing.JTextField text_obj3Quantity;
    // End of variables declaration//GEN-END:variables
}