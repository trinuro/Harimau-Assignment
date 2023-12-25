/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author Khiew
 */
public class PasswordRecovery extends User{
    static String currentEmail;
    PasswordRecovery(String email){
        super.email = email;
        this.currentEmail = email;
        System.out.println(this);
    }
    
    PasswordRecovery(){
        super.email = this.currentEmail;
        System.out.println(this);
    }
    
    public String toString(){
        return String.format("""
                             Password Recovery Object created
                             Email: %s
                             """, this.email);
    }
    
    private String generateRecoveryPassword(){
        // This method generates a recovery password from email
        // Returns a recovery password if email exists
        // Returns "" if email does not exist or database connection fails
        // Each recovery password is valid for at most 1 hour and has a length of 10 characters
        String userPassword ="";
        
        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
        ){
        // Create SQL query
        String strSelect = String.format("SELECT password FROM user_table WHERE email = \'%s\';",email);
//        System.out.println("The SQL statement is "+strSelect);
        
        // Execute query
        ResultSet rset = stmt.executeQuery(strSelect);

        int rowCount = 0;
        // Get last_checked_in date from database
        while(rset.next()){
            userPassword = rset.getString("password");
            rowCount++;
        } 
        }catch(SQLException ex){
            System.out.println("SQL query failed.");
            ex.printStackTrace();
            return "";
        }
        String current = String.valueOf(LocalDateTime.now());
        // Hash passwordHash with current time
        String recoveryPassword = Utils.hashPassword(current, userPassword);
        
        // Write current recovery password to a file
        try{
            PrintWriter writeObj = new PrintWriter(new FileOutputStream("temp.txt"));
            writeObj.println(recoveryPassword);
            writeObj.close();
        }catch(IOException e){
            System.out.println(e);
        }
        
        // Get 6 digits starting from 4th position (
        recoveryPassword = recoveryPassword.substring(4,10);
        System.out.println("Recovery password generated");
        return recoveryPassword;
    }
    
    public boolean sendRecoveryEmail(){
        String recipientEmail = this.email;
        // This method sends a recovery email to the email address of recipient.
        // This method returns true if email was sent successfully. Else, returns false
        
        String databaseEmail="";
        String recoveryPw;
        
        // Try to retrieve email from database
        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
        ){
        // Create SQL query
        String strSelect = String.format("SELECT email FROM user_table WHERE email = \'%s\';",recipientEmail);
//        System.out.println("The SQL statement is "+strSelect);
        
        // Execute query
        ResultSet rset = stmt.executeQuery(strSelect);

        int rowCount = 0;
        // Get last_checked_in date from database
        while(rset.next()){
            databaseEmail = rset.getString("email");
//            System.out.println(databaseEmail);
            rowCount++;
        } 
        }catch(SQLException ex){
            System.out.println("SQL query failed.");
            ex.printStackTrace();
            return false;
        }
        
        // If email exists in database, generate recovery password 
        if(recipientEmail.equals(databaseEmail)){
            recoveryPw = this.generateRecoveryPassword();
        }else{
            System.out.println("Email does not exists");
            return false;
        }

        // Send recovery email to user
        try{
        String receiver = recipientEmail;
        String subject = "Harimau Account Recovery";
        String message = "Your recovery password is "+recoveryPw;
        HarimauGmailer.sendEmail( receiver, subject, message);
            
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        
        System.out.println("Recovery email sent successfully");
        return true;
    }
    
    public static boolean isRecoveryPasswordCorrect(String userPassword){
        // This method checks whether the recovery password is correct.
        // Return true if password is correct
        // Will delete temp.txt
        String recoveryPassword="";
        try{
            Scanner scanObj = new Scanner(new FileInputStream("temp.txt"));
            recoveryPassword = scanObj.nextLine().substring(4,10);
            scanObj.close();
        }catch(IOException e){
            System.out.println(e);
            return false;
        }
        // Delete file
        File file = new File("temp.txt");
        try{
            boolean result = java.nio.file.Files.deleteIfExists(file.toPath());
            if(!result)
                System.out.println("Deletion unsuccessful");
        }catch(IOException e){
            System.out.println(e);
        }

        
        // Check if the passwords are equal
        if(recoveryPassword.equals(userPassword)){
            System.out.println("Recovery password is correct");
            return true;
        }else{
            System.out.println("Recovery password is incorrect");
            return false;
        }
    }
    
    public boolean updateUserPassword(String newPassword, String confirmPassword){
        // Checks if password and confirmPassword are the same
        if(!newPassword.equals(confirmPassword)){
            return false;
        }
        
        String registrationDate = "";
        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
        ){
        // Create SQL query
        String strSelect = String.format("SELECT registration_date FROM user_table WHERE email = \'%s\';",email);
//        System.out.println("The SQL statement is "+strSelect);
        
        // Execute query
        ResultSet rset = stmt.executeQuery(strSelect);

        int rowCount = 0;
        // Get last_checked_in date from database
        while(rset.next()){
            registrationDate = rset.getString("registration_date");
            rowCount++;
        } 
        }catch(SQLException ex){
            System.out.println("SQL query failed.");
            ex.printStackTrace();
            return false;
        }
        // Hash the new password
        String hash = Utils.hashPassword(registrationDate, newPassword);
        
        // Insert new hash into the database
        try(
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
        Statement stmt = conn.createStatement();
           ){
            // Create SQL Insert
            String sqlInsert = String.format("UPDATE user_table SET password= \'%s\' WHERE email = \'%s\';", hash, email);
//            System.out.println("SQL Statement to be executed: "+sqlInsert);
            
            // Insert information into database
            int countInserted = stmt.executeUpdate(sqlInsert);
//            System.out.println(countInserted+" records inserted.");
            
        }catch(SQLException ex){
            System.out.println("SQL failed! Find Khiew");
            ex.printStackTrace();
            return false;
        }
        
        System.out.printf("Password for %s updated successfully\n",email);
        return true;
    }
}
