/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 *
 * @author Khiew
 */
public class ExistingUser extends User{
    private static String username;
    
    public ExistingUser(){
        
    }
    // Constructor method
    public ExistingUser(String name, String email){
        setUsername(name);
        // Check if user exists. Will throw exception if user does not exist
        if(this.getUserData("email").equals("")){
            throw new IllegalArgumentException("User does not exist");
        }
        setEmail(email);
    }

    ExistingUser(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
//    // copy constructor
//    public ExistingUser(ExistingUser p){
//        if(p==null){
//            System.exit(0);
//        }
//        
//    }
    
    // toString method
    public String toString(){
        return String.format("""
                             Existing user
                             Username: %s
                             Email: %s
                             """,this.getUsername(),this.getEmail());
    }
    
    // Equals method
    public boolean equals(ExistingUser person){
        if(this.getUsername().equals(person.getUsername())&&this.getEmail().equals(person.getEmail())){
            return true;
        }else{
            return false;
        }
    }
    
    // Accessor method to get username
    public String getUsername(){
        return this.username;
    }
    
    // Mutator method to set username
    private void setUsername(String u){
        this.username = u;
    }
    
    // Mutator method to set email
    private void setEmail(String email){
        this.email = email;
    }
    
    public void checkIn(){
        // This function checks in a user
        // It will update the last checked in of user and give 1 mark to user if the user checked in for the first time
        // It will update the database to show that the user is currently logged in
        // Does not return anything

        // Initialise variables
        String dateString, last_checked_in_date="";

        // Get current date
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
        dateString = formatter.format(date);

        // Connect to database
        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
            ){
        // Create SQL query
        String strSelect = String.format("SELECT last_checked_in FROM user_table WHERE username = \'%s\';",this.username);
//        System.out.println("The SQL statement is "+strSelect);

        // Execute query
        ResultSet rset = stmt.executeQuery(strSelect);

        int rowCount = 0;
        // Get last_checked_in date from database
        while(rset.next()){
            String last_checked_in = rset.getString("last_checked_in");
            last_checked_in_date = last_checked_in.split(" ")[0];
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
            increasePoints(1);
        }

        //Update last_checked_in
        updateLast_checked_in();

        // Update logged_in boolean variable in database
        try(
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
        Statement stmt = conn.createStatement();
           ){
            // Create SQL Insert
            String sqlInsert = String.format("UPDATE user_table SET logged_in= \'%d\' WHERE username = \'%s\';", 1, this.username);
//            System.out.println("SQL Statement to be executed: "+sqlInsert);

            // Insert information into database
            int countInserted = stmt.executeUpdate(sqlInsert);
//            System.out.println(countInserted+" records inserted.");

        }catch(SQLException ex){
            System.out.println("SQL failed! Find Khiew");
            ex.printStackTrace();
        }
        
        System.out.println("User logged in successfully");
    }
    
    public void increasePoints(double increment){
        // This method receives username and increment as input. 
        // It will search the database for this user and increase his/her marks by the increment.

        double initialPoints=0;
        
        try(
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
        Statement stmt = conn.createStatement();
           ){
            // Create SQL Query
            String sqlQuery = String.format("SELECT current_points FROM user_table WHERE username=\'%s\';",username);
//            System.out.println("SQL Statement to be executed: "+sqlQuery);

            // Execute query
            ResultSet rset = stmt.executeQuery(sqlQuery);
            while(rset.next()){
                initialPoints = rset.getDouble("current_points");
            }
//            System.out.println(initialPoints);


            // Create SQL Insert
            String sqlInsert = String.format("UPDATE user_table SET current_points= %f WHERE username = \'%s\';", initialPoints+increment, username);
//            System.out.println("SQL Statement to be executed: "+sqlInsert);

            // Insert information into database
            int countInserted = stmt.executeUpdate(sqlInsert);
//            System.out.println(countInserted+" records inserted.");

        }catch(SQLException ex){
            System.out.println("SQL failed! Find Khiew");
            ex.printStackTrace();
        }        
        
        System.out.printf("Increased %s's points by %f\n",username,increment);
    }
    
    private void updateLast_checked_in(){

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
        System.out.printf("Updated last_checked_in of %s in database\n",username);
    }
    
    public boolean checkPassword(String password) throws NoSuchAlgorithmException{
        // Static method: Can be called without instantiating an object
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
//        System.out.println("The SQL statement is "+strSelect);
        
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
        userHash = Utils.hashPassword(registration_date,password);

        //Check email
        if(!database_email.equals(email)){
            return false;
        }        
        
        // Check password
        if(!database_hash.equals(userHash)){
            return false;
        }
        
        System.out.println("Password is correct");
        return true;
    }
    
    public long daysAfterRegistration(){
        // This method receives a username and returns the number of days the user has logged in
        // Returns a long variable
        
        LocalDate startDate, endDate;
        startDate = LocalDate.now();
        
        // Connect to database
        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
            ){
        // Create SQL query
        String strSelect = String.format("SELECT registration_date FROM user_table WHERE username = \'%s\';",username);
//        System.out.println("The SQL statement is "+strSelect);
        
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
        
        System.out.println("Returned number of days after registration");
        return ChronoUnit.DAYS.between(startDate, endDate);
        
    }
    
    public String getUserData(String columnTitle){
        // This function returns data from database based on table name, username and column title
        
        String output="";

        
        // Connect to database
        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
            ){
        // Create SQL query
        String strSelect = String.format("SELECT %s FROM user_table WHERE username = \'%s\';",columnTitle,username);
//        System.out.println("The SQL statement is "+strSelect);
        
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
        
        System.out.println("Successfully querried database for user data");
        return output;
    }
    
    public void checkOut(){
        // This method signs a user out
        // It updates the database to show that the user is currently logged out
        // Returns nothing
        
        // Update logged_in boolean variable in database
        try(
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
        Statement stmt = conn.createStatement();
           ){
            // Create SQL Insert
            String sqlInsert = String.format("UPDATE user_table SET logged_in= \'%d\' WHERE username = \'%s\';", 0, username);
//            System.out.println("SQL Statement to be executed: "+sqlInsert);
            
            // Insert information into database
            int countInserted = stmt.executeUpdate(sqlInsert);
//            System.out.println(countInserted+" records inserted.");
            
        }catch(SQLException ex){
            System.out.println("SQL failed! Find Khiew");
            ex.printStackTrace();
        }
        
        System.out.println("User successfully logged out");
    }
}
