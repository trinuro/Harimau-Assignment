


import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

public class gui_dailyTrivia1 extends javax.swing.JFrame {
    
    //ExistingUser a = new ExistingUser();
    ExistingUser user = new ExistingUser("ziwei","weiwei");
    
    dailyTrivia t1 = new dailyTrivia(user.getUsername());
    //static int question =1;
    int question =t1.getQuestionSetCanBeAnswered().size();
    String[]optionList=t1.getOptions(question);
    
    
    private Map<Integer, String> userSelectedAnswers = new HashMap<>();
    private Map<Integer, String> questionMessages = new HashMap<>();
    private Map<Integer, MessageInfo> messageMap = new HashMap<>();
    
    public gui_dailyTrivia1() {
        initComponents();
//        this.setResizable(false);
//        this.setLocationRelativeTo(null);
//        this.setSize(1960,1080);
//        ExistingUser a;
    
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        panel_menu = new javax.swing.JPanel();
        label_home = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panel_dailyTrivia = new javax.swing.JPanel();
        label_Question = new javax.swing.JLabel();
        optA = new javax.swing.JRadioButton();
        optB = new javax.swing.JRadioButton();
        optC = new javax.swing.JRadioButton();
        optD = new javax.swing.JRadioButton();
        panel_quizMessage = new javax.swing.JPanel();
        quizMessage = new javax.swing.JLabel();
        label_Day = new javax.swing.JLabel();
        showCorrectAns = new javax.swing.JLabel();
        btn_submit = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
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
        label_home.setText("QUIZ");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panel_dailyTrivia.setBackground(new java.awt.Color(245, 245, 245));

        int i=1;
        dailyTrivia trivia = new dailyTrivia("hzw");
        label_Question.setText(trivia.getQuestion(i));
        label_Question.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        // Assuming label_Question is a JLabel or similar componen

        javax.swing.GroupLayout panel_dailyTriviaLayout = new javax.swing.GroupLayout(panel_dailyTrivia);
        panel_dailyTrivia.setLayout(panel_dailyTriviaLayout);
        panel_dailyTriviaLayout.setHorizontalGroup(
            panel_dailyTriviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dailyTriviaLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(label_Question, javax.swing.GroupLayout.PREFERRED_SIZE, 1067, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_dailyTriviaLayout.setVerticalGroup(
            panel_dailyTriviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dailyTriviaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(label_Question, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        String[]opt = trivia.getOptions(i);
        buttonGroup.add(optA);
        optA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        optA.setText(optionList[0]);
        optA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optAActionPerformed(evt);
            }
        });

        buttonGroup.add(optB);
        optB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        optB.setText(optionList[1]);

        buttonGroup.add(optC);
        optC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        optC.setText(optionList[2]);

        buttonGroup.add(optD);
        optD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        optD.setText(optionList[3]);

        panel_quizMessage.setBackground(new java.awt.Color(245, 245, 245));

        quizMessage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        quizMessage.setText("Choose a correct answer.");

        javax.swing.GroupLayout panel_quizMessageLayout = new javax.swing.GroupLayout(panel_quizMessage);
        panel_quizMessage.setLayout(panel_quizMessageLayout);
        panel_quizMessageLayout.setHorizontalGroup(
            panel_quizMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_quizMessageLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(quizMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 1068, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        panel_quizMessageLayout.setVerticalGroup(
            panel_quizMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_quizMessageLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(quizMessage)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        label_Day.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        //int i=1;
        //dailyTrivia trivia = new dailyTrivia("hzw");
        label_Day.setText(t1.title(question));

        showCorrectAns.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(showCorrectAns, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panel_quizMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(optD)
                            .addComponent(optC)
                            .addComponent(optB)
                            .addComponent(optA)
                            .addComponent(panel_dailyTrivia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label_Day, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_Day, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_dailyTrivia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(optA)
                .addGap(18, 18, 18)
                .addComponent(optB)
                .addGap(18, 18, 18)
                .addComponent(optC)
                .addGap(18, 18, 18)
                .addComponent(optD)
                .addGap(2, 2, 2)
                .addComponent(showCorrectAns)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_quizMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );

        btn_submit.setBackground(new java.awt.Color(0, 0, 0));
        btn_submit.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btn_submit.setForeground(new java.awt.Color(255, 255, 255));
        btn_submit.setText("Submit Answer");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        btn_next.setBackground(new java.awt.Color(0, 0, 0));
        btn_next.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btn_next.setForeground(new java.awt.Color(255, 255, 255));
        btn_next.setText("Next >>");
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_back.setBackground(new java.awt.Color(0, 0, 0));
        btn_back.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setText("<< Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_menuLayout = new javax.swing.GroupLayout(panel_menu);
        panel_menu.setLayout(panel_menuLayout);
        panel_menuLayout.setHorizontalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_menuLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_home, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panel_menuLayout.createSequentialGroup()
                            .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(938, Short.MAX_VALUE))
        );
        panel_menuLayout.setVerticalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_menuLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(label_home, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(1601, Short.MAX_VALUE))
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
            .addComponent(panel_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 1016, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_storeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_storeActionPerformed
        // TODO add your handling code here:
        gui_store StoreFrame = new gui_store();
        StoreFrame.setVisible(true);
        StoreFrame.pack();
        StoreFrame.setLocationRelativeTo(null);
        //this.dispose();
    }//GEN-LAST:event_btn_storeActionPerformed

    private void btn_QuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QuizActionPerformed
        // TODO add your handling code here:
        gui_dailyTrivia1 QuizFrame = new gui_dailyTrivia1();
        QuizFrame.setVisible(true);
        QuizFrame.pack();
        QuizFrame.setLocationRelativeTo(null);
        //this.dispose();
    }//GEN-LAST:event_btn_QuizActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        // TODO add your handling code here:
        gui_home HomeFrame = new gui_home();
        HomeFrame.setVisible(true);
        HomeFrame.pack();
        HomeFrame.setLocationRelativeTo(null);
        //this.dispose();
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_donationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_donationActionPerformed
        // TODO add your handling code here:
        gui_donation DonationFrame = new gui_donation();
        DonationFrame.setVisible(true);
        DonationFrame.pack();
        DonationFrame.setLocationRelativeTo(null);
        //this.dispose();
    }//GEN-LAST:event_btn_donationActionPerformed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        // TODO add your handling code here:
//        if(evt.getSource()==btn_submit){
        
        label_Day.setText(t1.title(question));
        MessageInfo messageInfo = null;
         
        if ((optA.isSelected() || optB.isSelected() || optC.isSelected() || optD.isSelected())){
            String userAnswer = "";

            if (optA.isSelected()) {
                userAnswer = optA.getText();
            } else if (optB.isSelected()) {
                userAnswer = optB.getText();
            }else if (optC.isSelected()) {
                userAnswer = optC.getText();
            } else if (optD.isSelected()) {
                userAnswer = optD.getText();
            }
            
            // Store the selected answer for the current question
            userSelectedAnswers.put(question, userAnswer);
           
            
            if(! t1.getIsCorrectAnswerFinally(question)){ // if originally not correct
                // has to be run to update isCorrect, numberOfAttempt and to increasuser marks if any
                t1.isCorrect(question, userAnswer);
                if (t1.getIsCorrectAnswerCurrently(question) && t1.gatNumberOfAttempt(question)<=1) {
                    panel_quizMessage.setBackground(new Color(193, 225, 193));
                    quizMessage.setText("Congratulations! Your answer is correct. You have been awarded "+
                        t1.getmarkAllocated(question)+" . You now have " +login.getUserData(user.getUsername(), "current_points")+ " points.");
                    messageInfo = new MessageInfo("Congratulations! Your answer is correct. You have been awarded " +
                            t1.getmarkAllocated(question) + ". You now have " +login.getUserData(user.getUsername(), "current_points")+ "D points.", new Color(193, 225, 193));
                
                }else if (!t1.getIsCorrectAnswerCurrently(question) && t1.gatNumberOfAttempt(question)<=1){
                    panel_quizMessage.setBackground(new Color(250, 160, 160));
                    quizMessage.setText("Your answer ["+userAnswer+"] is wrong. Do you want to give it another try?");
                    messageInfo = new MessageInfo("Your answer [" + userAnswer + "] is wrong. Do you want to give it another try?", new Color(250, 160, 160));
                    
                    // Reset radio buttons
                    buttonGroup.clearSelection();
                    
                    //Shuffle the options
                    String [] newOptionList = t1.getOptions(question);
                    
                    optA.setText(newOptionList[0]);
                    optB.setText(newOptionList[1]);
                    optC.setText(newOptionList[2]);
                    optD.setText(newOptionList[3]);
                    
                }else if (t1.getIsCorrectAnswerCurrently(question) && t1.gatNumberOfAttempt(question)>1){
                    panel_quizMessage.setBackground(new Color(193, 225, 193));
                    quizMessage.setText("Your answer is correct! Thank you your for trying~");
                    messageInfo = new MessageInfo("Your answer is correct! Thank you your for trying~",new Color(193, 225, 193));
                    
                }else if (!t1.getIsCorrectAnswerCurrently(question) && t1.gatNumberOfAttempt(question)>1){
                    panel_quizMessage.setBackground(new Color(250, 160, 160));
                    quizMessage.setText("Your answer is still wrong. The correct answer is "+t1.getAnswer(question));
                    messageInfo = new MessageInfo("Your answer is still wrong. The correct answer is " + t1.getAnswer(question), new Color(250, 160, 160));
                }
                
                
                
            }else{ // if originally answered correctly
                // has to be run to update isCorrect, numberOfAttempt and to increasuser marks if any
                t1.isCorrect(question, userAnswer);
                 
                if (t1.getIsCorrectAnswerCurrently(question)) {
                    panel_quizMessage.setBackground(new Color(193, 225, 193));
                    quizMessage.setText("Congratulations! Your answer is correct. Thank you for trying again~");
                    messageInfo = new MessageInfo("Congratulations! Your answer is correct. Thank you for trying again~",new Color(193, 225, 193));
                } else if (!t1.getIsCorrectAnswerCurrently(question)){
                    panel_quizMessage.setBackground(new Color(250, 160, 160));
                    quizMessage.setText("Your answer is wrong. The correct answer is "+t1.getAnswer(question));
                    messageInfo = new MessageInfo("Your answer is wrong. The correct answer is "+t1.getAnswer(question),new Color(250, 160, 160));
                }
            }
            
        }
        messageMap.put(question, messageInfo);
    }//GEN-LAST:event_btn_submitActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        // TODO add your handling code here:
        if(question<t1.getQuestionSetCanBeAnswered().size()){
                ++question;
                System.out.println("Question = "+question);
                
                // Reset radio buttons
                buttonGroup.clearSelection();
                
                // Reset panel_quizMessage and quizMessage
                panel_quizMessage.setBackground(new Color(245,245,245)); 
                String storedMessage = "";
                Color storedColor = null;

                // Check if there's a stored message for the current question
                if (messageMap.containsKey(question)) {
                    MessageInfo storedMessageInfo = messageMap.get(question);
                    storedMessage = storedMessageInfo.getMessage();
                    storedColor = storedMessageInfo.getBackgroundColor();
                }
                
                quizMessage.setText(storedMessage); 
                
                if (storedColor != null) {
                panel_quizMessage.setBackground(storedColor);
                } else {
                    // If there's no stored color, reset to default
                    quizMessage.setText("Choose a correct anwer.");
                    panel_quizMessage.setBackground(new Color(245, 245, 245));
                }

                optionList=t1.getOptions(question);
                label_Day.setText(t1.title(question));
                label_Question.setText(t1.getQuestion(question));
                optA.setText(optionList[0]);
                optB.setText(optionList[1]);
                optC.setText(optionList[2]);
                optD.setText(optionList[3]);
                
                String selectedAnswer = userSelectedAnswers.get(question);
                if (selectedAnswer != null) {
                    // Set the radio button based on the stored answer
                    if (selectedAnswer.equals(optA.getText())) {
                        optA.setSelected(true);
                    } else if (selectedAnswer.equals(optB.getText())) {
                        optB.setSelected(true);
                    } else if (selectedAnswer.equals(optC.getText())) {
                        optC.setSelected(true);
                    } else if (selectedAnswer.equals(optD.getText())) {
                        optD.setSelected(true);
                    }
        }
            }
        
        
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
         if(question>1){
                --question;
                System.out.println("Question = "+question);
                
                // Reset radio buttons
                buttonGroup.clearSelection();
                
                // Reset panel_quizMessage and quizMessage
                panel_quizMessage.setBackground(new Color(245,245,245)); 
                String storedMessage = "";
                Color storedColor = null;

                // Check if there's a stored message for the current question
                if (messageMap.containsKey(question)) {
                    MessageInfo storedMessageInfo = messageMap.get(question);
                    storedMessage = storedMessageInfo.getMessage();
                    storedColor = storedMessageInfo.getBackgroundColor();
                }
                
                quizMessage.setText(storedMessage); 
                
                if (storedColor != null) {
                panel_quizMessage.setBackground(storedColor);
                } else {
                    // If there's no stored color, reset to default
                    quizMessage.setText("Choose a correct anwer.");
                    panel_quizMessage.setBackground(new Color(245, 245, 245));
                }
                
                optionList=t1.getOptions(question);
                label_Day.setText(t1.title(question));
                label_Question.setText(t1.getQuestion(question));
                optA.setText(optionList[0]);
                optB.setText(optionList[1]);
                optC.setText(optionList[2]);
                optD.setText(optionList[3]);
                
                // Restore the selected answer for the current question, if any
                String selectedAnswer = userSelectedAnswers.get(question);
                if (selectedAnswer != null) {
                    // Set the radio button based on the stored answer
                    if (selectedAnswer.equals(optA.getText())) {
                        optA.setSelected(true);
                    } else if (selectedAnswer.equals(optB.getText())) {
                        optB.setSelected(true);
                    } else if (selectedAnswer.equals(optC.getText())) {
                        optC.setSelected(true);
                    } else if (selectedAnswer.equals(optD.getText())) {
                        optD.setSelected(true);
                    }
                }
            }
         
    }//GEN-LAST:event_btn_backActionPerformed

    private void optAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optAActionPerformed

//    private void showRandomQuestion() {
//        // Implement this method to update questionTextArea with a random question
//        // Use trivia object to get the question
//        String randomQuestion = "Question: " + dailyTrivia + "\nOptions: " + String.join(", ", trivia.getOptions(1));
//        JTextArea questionTextArea = (JTextArea) getContentPane().getComponent(1);
//        questionTextArea.setText(randomQuestion);
//    }
//
//    private void submitAnswer(String answer) {
//        // Implement this method to handle the user's submitted answer
//        // Use trivia object to check the answer and update the GUI accordingly
//        trivia.isCorrect(1, answer);
//        JOptionPane.showMessageDialog(this, "Is Correct: " + trivia.isCorrectAnswer(1));
//    }

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
        
//        int i=1;
//        dailyTrivia trivia = new dailyTrivia("hzw");
//        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui_dailyTrivia1().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Quiz;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_donation;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_store;
    private javax.swing.JButton btn_submit;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_Day;
    private javax.swing.JLabel label_Question;
    private javax.swing.JLabel label_home;
    private javax.swing.JRadioButton optA;
    private javax.swing.JRadioButton optB;
    private javax.swing.JRadioButton optC;
    private javax.swing.JRadioButton optD;
    private javax.swing.JPanel panel_dailyTrivia;
    private javax.swing.JPanel panel_main;
    private javax.swing.JPanel panel_menu;
    private javax.swing.JPanel panel_quizMessage;
    private javax.swing.JLabel quizMessage;
    private javax.swing.JLabel showCorrectAns;
    // End of variables declaration//GEN-END:variables
}
