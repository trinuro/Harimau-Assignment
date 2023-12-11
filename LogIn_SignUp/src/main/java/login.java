/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Khiew
 */
// Import required modules
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.File;

public class login {
    private static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
            // Static getInstance method is called with hashing SHA
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // digest() method called
            // to calculate message digest of an input
            // and return array of byte
            return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
    
    private static String toHexString(byte[] hash)
     {
             // Convert byte array into signum representation
             BigInteger number = new BigInteger(1, hash);

             // Convert message digest into hex value
             StringBuilder hexString = new StringBuilder(number.toString(16));

             // Pad with leading zeros
             while (hexString.length() < 64)
             {
                     hexString.insert(0, '0');
             }

             return hexString.toString();
     }    
    public static boolean checkPassword(String email, String username, String password) throws NoSuchAlgorithmException{
        // This function will check whether the user password is the same as password in the database
        // It receives three input: email, username and password
        // It will return true if password is correct
        
        String database_email="", database_hash="", userHash, registration_date="";
        
        // Get password hash stored in the database
        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
            ){
        // Create SQL query
        String strSelect = String.format("SELECT email,password,registration_date FROM user_table WHERE username = \'%s\';",username);
        System.out.println("The SQL statement is "+strSelect);
        
        // Execute query
        ResultSet rset = stmt.executeQuery(strSelect);

        int rowCount = 0;
        while(rset.next()){
            database_email = rset.getString("email");
            database_hash = rset.getString("password");
            registration_date = rset.getString("registration_date");
            rowCount++;
        } 
        }catch(SQLException ex){
            System.out.println("SQL query failed.");
            ex.printStackTrace();
            return false;
        }

        // Hash the inputted password
        userHash = signup.hashPassword(registration_date,password);

        //Check email
        if(!database_email.equals(email)){
            return false;
        }        
        
        // Check password
        if(!database_hash.equals(userHash)){
            return false;
        }

        return true;
    }
    
    public static void checkIn(String username){
        // This function checks in a user
        // It will update the last checked in of user and give 1 mark to user if the user checked in for the first time
        // Does not return anything
        
        // Initialise variables
        String dateString, last_checked_in_date="";
        
        // Get current date
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
        dateString = formatter.format(date);
//        System.out.println("Current date is "+dateString);
        
        // Connect to database
        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
            ){
        // Create SQL query
        String strSelect = String.format("SELECT last_checked_in FROM user_table WHERE username = \'%s\';",username);
        System.out.println("The SQL statement is "+strSelect);
        
        // Execute query
        ResultSet rset = stmt.executeQuery(strSelect);

        int rowCount = 0;
        // Get last_checked_in date from database
        while(rset.next()){
            String last_checked_in = rset.getString("last_checked_in");
            last_checked_in_date = last_checked_in.split(" ")[0];
            System.out.println(last_checked_in_date);
//            System.out.printf("%s; %s\n", database_email, database_hash);
            rowCount++;
        } 
        }catch(SQLException ex){
            System.out.println("SQL query failed.");
            ex.printStackTrace();
        }
        
        // Determine if user checked in today. If no, give 1 mark
        if(!dateString.equals(last_checked_in_date)){
            System.out.println("Receive marks!");
            // Give 1 mark
            increasePoints(username, 1);
        }
        
        //Update last_checked_in
        updateLast_checked_in(username);
    }
    
    private static void updateLast_checked_in(String username){

        // Get current date
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);
        
//        System.out.println(formattedDateTime);
        try(
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
        Statement stmt = conn.createStatement();
           ){
            // Create SQL Insert
            String sqlInsert = String.format("UPDATE user_table SET last_checked_in= \'%s\' WHERE username = \'%s\';", formattedDateTime, username);
            System.out.println("SQL Statement to be executed: "+sqlInsert);
            
            // Insert information into database
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted+" records inserted.");
            
        }catch(SQLException ex){
            System.out.println("SQL failed! Find Khiew");
            ex.printStackTrace();
        }     
    }
    
    public static void increasePoints(String username, int increment){
        // This method receives username and increment as input. 
        // It will search the database for this user and increase his/her marks by the increment.
        
        int initialPoints=0;
        
        try(
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
        Statement stmt = conn.createStatement();
           ){
            // Create SQL Query
            String sqlQuery = String.format("SELECT current_points FROM user_table WHERE username=\'%s\';",username);
            System.out.println("SQL Statement to be executed: "+sqlQuery);
            
            // Execute query
            ResultSet rset = stmt.executeQuery(sqlQuery);
            while(rset.next()){
                initialPoints = rset.getInt("current_points");
            }
            System.out.println(initialPoints);
            
            
            // Create SQL Insert
            String sqlInsert = String.format("UPDATE user_table SET current_points= %d WHERE username = \'%s\';", initialPoints+increment, username);
            System.out.println("SQL Statement to be executed: "+sqlInsert);
            
            // Insert information into database
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted+" records inserted.");
            
        }catch(SQLException ex){
            System.out.println("SQL failed! Find Khiew");
            ex.printStackTrace();
        }        
    }
    
    public static String getUserData( String username, String columnTitle){
        // This function returns data from database based on table name, username and column title
        
        String output="";

        
        // Connect to database
        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
            ){
        // Create SQL query
        String strSelect = String.format("SELECT %s FROM user_table WHERE username = \'%s\';",columnTitle,username);
        System.out.println("The SQL statement is "+strSelect);
        
        // Execute query
        ResultSet rset = stmt.executeQuery(strSelect);

        int rowCount = 0;
        // Get last_checked_in date from database
        while(rset.next()){
            output = rset.getString(columnTitle);
            rowCount++;
        } 
        }catch(SQLException ex){
            System.out.println("SQL query failed.");
            ex.printStackTrace();
            return "";
        }    
        
        return output;
    }

    
    public static long daysAfterRegistration(String username){
        // This method receives a username and returns the number of days the user has logged in
        // Returns a long variable
        
        LocalDate startDate, endDate;
        // Ignore this. It is a bug
        startDate = LocalDate.now();
        
        // Connect to database
        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
            ){
        // Create SQL query
        String strSelect = String.format("SELECT registration_date FROM user_table WHERE username = \'%s\';",username);
        System.out.println("The SQL statement is "+strSelect);
        
        // Execute query
        ResultSet rset = stmt.executeQuery(strSelect);

        int rowCount = 0;
        // Get date the user registered
        while(rset.next()){
            String registrationDate = rset.getString("registration_date").split(" ")[0];
            startDate = LocalDate.parse(registrationDate);
            rowCount++;
        } 
        }catch(SQLException ex){
            System.out.println("SQL query failed.");
            ex.printStackTrace();
            return 0;
        }    
        
        //Get current date
        endDate = LocalDate.now();
        
        return ChronoUnit.DAYS.between(startDate, endDate);
        
    }
    
    private static String generateRecoveryPassword(String email){
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
        System.out.println("The SQL statement is "+strSelect);
        
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
        String recoveryPassword = signup.hashPassword(current, userPassword);
        
        // Write current recovery password to a file
        try{
            PrintWriter writeObj = new PrintWriter(new FileOutputStream("temp.txt"));
            writeObj.println(recoveryPassword);
            writeObj.close();
        }catch(IOException e){
            System.out.println(e);
        }
        
        // Get first 10 digits starting from 4
        recoveryPassword = recoveryPassword.substring(4,10);
        
//        String recoveryPassword = signup.hashPassword(output, output)
        return recoveryPassword;
    }
    
    public static boolean sendRecoveryEmail(String recipientEmail){
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
        System.out.println("The SQL statement is "+strSelect);
        
        // Execute query
        ResultSet rset = stmt.executeQuery(strSelect);

        int rowCount = 0;
        // Get last_checked_in date from database
        while(rset.next()){
            databaseEmail = rset.getString("email");
            System.out.println(databaseEmail);
            rowCount++;
        } 
        }catch(SQLException ex){
            System.out.println("SQL query failed.");
            ex.printStackTrace();
            return false;
        }
        
        // If email exists in database, generate recovery password 
        if(recipientEmail.equals(databaseEmail)){
            recoveryPw = login.generateRecoveryPassword(recipientEmail);
        }else{
            System.out.println("Email does not exists");
            return false;
        }

        // Send recovery email to user
        try{
        String sender = Secrets.getSenderEmail();
        String receiver = recipientEmail;
        String subject = "Harimau Account Recovery";
        String message = "Your recovery password is "+recoveryPw;
        new HarimauGmailer().sendMail(sender, receiver, subject, message);
            
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
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
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean updateUserPassword(String email, String newPassword, String confirmPassword){
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
        System.out.println("The SQL statement is "+strSelect);
        
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
        String hash = signup.hashPassword(registrationDate, newPassword);
        
        // Insert new hash into the database
        try(
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
        Statement stmt = conn.createStatement();
           ){
            // Create SQL Insert
            String sqlInsert = String.format("UPDATE user_table SET password= \'%s\' WHERE email = \'%s\';", hash, email);
            System.out.println("SQL Statement to be executed: "+sqlInsert);
            
            // Insert information into database
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted+" records inserted.");
            
        }catch(SQLException ex){
            System.out.println("SQL failed! Find Khiew");
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
