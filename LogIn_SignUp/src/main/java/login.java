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

public class login {
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
            // Static getInstance method is called with hashing SHA
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // digest() method called
            // to calculate message digest of an input
            // and return array of byte
            return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
    
    public static String toHexString(byte[] hash)
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
//            System.out.printf("%s; %s\n", database_email, database_hash);
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
    
    public static void updateLast_checked_in(String username){

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
}
