/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * NewUser represents a User that just registered into the system
 * @author Khiew
 */
public class NewUser extends User{
    private String username;
    private String password;
    private String confirmPassword;
    
    /**
     * Constructor to create a NewUser object
     * @param email
     * @param username
     * @param password
     * @param confirmPassword 
     */
    public NewUser(String email, String username, String password, String confirmPassword){
        super.email = email;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    /**
     * Method to convert ExistingUser into String
     * @return 
     */    
    @Override
    public String toString(){
        return String.format("""
                          New User created
                          Username: %s
                          Email: %s
                           """,this.getUsername(), this.getEmail());
    }
    
    /**
     * Check if two NewUser are the same
     * @param person
     * @return 
     */
    public boolean equals(NewUser person){
        if(this.getUsername().equals(person.getUsername())&&this.getEmail().equals(person.getEmail())){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Accessor method to get username
     * @return 
     */
    public String getUsername(){
        return this.username;
    }
    
    /**
     * This method creates a new user in database. 
     * It accepts the email, username, password and confirm password string.
     * It will return true if a user is successfully created.
     * @return 
     */
    public boolean createNewUser(){
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
//                System.out.println("The SQL statement is "+strSelect);

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
        encryptedPassword = Utils.hashPassword(formattedDateTime,password);

        try(
//              Create connection to database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
            ){

        // SQL command to be executed
        String sqlInsert = String.format("INSERT INTO user_table(email, username, password, registration_date,current_points) VALUES(\'%s\',\'%s\',\'%s\',\'%s\',\'%d\');", email, username, encryptedPassword, formattedDateTime,1);
        // Insert information into database
        int countInserted = stmt.executeUpdate(sqlInsert);
            
        }catch(SQLException ex){
            System.out.println("SQL failed! Find Khiew");
            ex.printStackTrace();
            return false;
        }
        
        System.out.printf("User %s successfully created\n",username);
        return true;
    }
}
