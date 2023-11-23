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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class signup {
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
    
    public static boolean createNewUser(String email, String username, String password, String confirmPassword){
        //Initialise variables
        String encryptedPassword;
        String database_email="", database_username="";
        
        // Check whether confirm password is same as password
        if(!password.equals(confirmPassword)){
            return false;
        }
        
        // Query for email or username if it exists
        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
            ){
                // Create SQL query
                String strSelect = String.format("SELECT username,email FROM user_table WHERE username = \'%s\' OR email = \'%s\';",username,email);
                System.out.println("The SQL statement is "+strSelect);

                // Execute query
                ResultSet rset = stmt.executeQuery(strSelect);

                int rowCount = 0;
                while(rset.next()){
                    database_email = rset.getString("email");
                    database_username = rset.getString("username");
                    rowCount++;
            } 
            }catch(SQLException ex){
                System.out.println("SQL query failed.");
                ex.printStackTrace();
                return false;
            }

        // Check if username or email exists
        if(database_email.equals(email) || database_username.equals(username)){
            System.out.println("Email or username already exists");
            return false;
        }

        // Get current date
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);

        // Create password hash
        encryptedPassword = hashPassword(formattedDateTime,password);

        try(
//              Create connection to database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
            ){

        // SQL command to be executed
        String sqlInsert = String.format("INSERT INTO user_table(email, username, password, registration_date) VALUES(\'%s\',\'%s\',\'%s\',\'%s\');", email, username, encryptedPassword, formattedDateTime);
        System.out.println("SQL Statement to be executed: "+sqlInsert);
        // Insert information into database
        int countInserted = stmt.executeUpdate(sqlInsert);
        System.out.println(countInserted+" records inserted.");
            
        }catch(SQLException ex){
            System.out.println("SQL failed! Find Khiew");
            ex.printStackTrace();
            return false;
        }
            
            
//        System.out.println(email+" "+username+" "+encryptedPassword);
        return true;
    }

    public static String hashPassword(String dateTime, String password){
        String encryptedPassword;

        try{
            // Encrypt password and datetime with SHA hash
            encryptedPassword = toHexString(getSHA(password+dateTime));

        }catch (NoSuchAlgorithmException e) {
            System.out.println("Encryption failed.");
            System.out.println("Exception thrown for incorrect algorithm: " + e);
            return "Failed";
        }

        // return hash
        return encryptedPassword;
    }
}
