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
 * ExistingUser class represents a user that is currently interacting with the program
 * @author Khiew
 */
public class ExistingUser extends User{
    private static String username;
    private static String currentEmail;
    
    /**
     * Constructor method that creates a user with a name and email address
     * @param name
     * @param email 
     */
    public ExistingUser(String name, String email){
        setUsername(name);
        // Check if user exists. Will throw exception if user does not exist
        if(this.getUserData("email").equals("")){
            throw new IllegalArgumentException("User does not exist");
        }
        setEmail(email);
        setCurrentEmail(email);
        System.out.println(this.toString());
    }

    /**
     * Empty constructor that is used to initialise an object referencing the previous ExistingUser
     */
    public ExistingUser(){
        setUsername(this.getUsername());
        setEmail(this.getCurrentEmail());
        System.out.println(this.toString());
    }
    
    /**
     * Copy constructor
     */ 
    public ExistingUser(ExistingUser p){
        if(p==null){
            System.exit(0);
        }
        setUsername(p.getUsername());
        setEmail(p.getEmail());
        System.out.println(this.toString());
    }
    
    /**
     * Method to convert ExistingUser into String
     * @return 
     */
    
    public String toString(){
        return String.format("""
                             Existing user
                             Username: %s
                             Email: %s
                             """,this.getUsername(),this.getEmail());
    }
    
    /**
     * Check if two ExistingUser are the same
     * @param person
     * @return 
     */
    public boolean equals(ExistingUser person){
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
        return username;
    }
    
    /**
     * Accessor method to get current email
     * @return 
     */
    public String getCurrentEmail(){
        return this.currentEmail;
    }
    
    /**
     * Mutator method to set username
     * @param u 
     */
    private void setUsername(String u){
        this.username = u;
    }
    
    /**
     * Mutator method to set currentEmail
     * @param email 
     */
    private void setCurrentEmail(String email){
        this.currentEmail = email;
        }
    
    /**
     * Mutator method to set email
     * @param email 
     */
    private void setEmail(String email){
        this.email = email;
    }
    
    /**
     * This function checks in a user.
     * It will update the last checked in of user and give 1 mark to user if the user checked in for the first time.
     * It will update the database to show that the user is currently logged in.
     */
    public void checkIn(){

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
        
        // Update trial_history table
        this.updateTrialHistory();

        System.out.println("User logged in successfully");
    }
    
    /**
     * This method receives username and increment as input. 
     * It will search the database for this user and increase his/her marks by the increment.
     * @param increment 
     */
    public void increasePoints(double increment){

        double initialPoints=0;
        
        try(
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
        Statement stmt = conn.createStatement();
           ){
            // Create SQL Query
            String sqlQuery = String.format("SELECT current_points FROM user_table WHERE username=\'%s\';",username);

            // Execute query
            ResultSet rset = stmt.executeQuery(sqlQuery);
            while(rset.next()){
                initialPoints = rset.getDouble("current_points");
            }

            // Create SQL Insert
            String sqlInsert = String.format("UPDATE user_table SET current_points= %f WHERE username = \'%s\';", initialPoints+increment, username);

            // Insert information into database
            int countInserted = stmt.executeUpdate(sqlInsert);

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
        
        try(
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
        Statement stmt = conn.createStatement();
           ){
            // Create SQL Insert
            String sqlInsert = String.format("UPDATE user_table SET last_checked_in= \'%s\' WHERE username = \'%s\';", formattedDateTime, username);            
            // Insert information into database
            int countInserted = stmt.executeUpdate(sqlInsert);
            
        }catch(SQLException ex){
            System.out.println("SQL failed! Find Khiew");
            ex.printStackTrace();
        }     
        System.out.printf("Updated last_checked_in of %s in database\n",username);
    }
    
    /**
     * This method will check whether the user password is the same as password in the database.
     * It receives three input: email, username and password
     * @param password
     * @return
     * @throws NoSuchAlgorithmException 
     */
    public boolean checkPassword(String password) throws NoSuchAlgorithmException{
        
        String database_email="", database_hash="", userHash, registration_date="";
        
        // Get password hash stored in the database
        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
            ){
        // Create SQL query
        String strSelect = String.format("SELECT email,password,registration_date FROM user_table WHERE username = \'%s\';",username);
        
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
    
    /**
     * This method receives a username and returns the number of days the user has logged in
     * @return 
     */
    public long daysAfterRegistration(){
        
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
    
    /**
     * This method returns data from database based on table name, username and column title
     * @param columnTitle
     * @return 
     */
    public String getUserData(String columnTitle){
        
        String output="";
        
        // Connect to database
        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
            ){
        // Create SQL query
        String strSelect = String.format("SELECT %s FROM user_table WHERE username = \'%s\';",columnTitle,username);
        
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
    
    private boolean insertNewQuestionAttempt(int questionID, int numberOfTries){
        // This method will create a new row for in trial_history table for specified user and question
        // Returns true if successful

        String userID = login.getUserData(this.username, "user_id");

        try(
    //          Create connection to database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
        ){

        // SQL command to be executed
        String sqlInsert = String.format("INSERT INTO trial_history VALUES(%s,%d,%d,0,0);", userID, questionID,numberOfTries);
        // Insert information into database
        int countInserted = stmt.executeUpdate(sqlInsert);

        }catch(SQLException ex){
            System.out.println("SQL failed! Find Khiew");
            ex.printStackTrace();
            return false;
        }
        System.out.println("Successful Insert: New row in trial_history created.");
        return true;
    }
    
    private boolean isTrialHistoryUpdated(int questionID){
            // Check if entry alrady exist in the table
            boolean doesEntryExist = false;
            try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
                Statement stmt = conn.createStatement();
                ){
            // Create SQL query
            String strSelect = String.format("""
                                             SELECT trial_history.user_id
                                             FROM user_table
                                             JOIN trial_history
                                             ON trial_history.user_id = user_table.user_id
                                             WHERE username = "%s" and trivia_id = %d;
                                             """,username,questionID);

            // Execute query
            ResultSet rset = stmt.executeQuery(strSelect);

            // Get questions, options and answer from the database
            while(rset.next()){
                String user_id = rset.getString("user_id");
                System.out.println(user_id);
                if(!user_id.equals("")){
                    doesEntryExist = true;
                }
            } 
            }catch(SQLException ex){
                System.out.printf("Failed to query database for number_of_tries of %s for question %d\n",username,questionID);
                ex.printStackTrace();   
                return false;
            }           
            if(doesEntryExist)
                System.out.println("User and question combination already exist");
            else
                System.out.println("User and question combination does not exist");
            
            return doesEntryExist;
    }
    
    /**
     * This method will determine how many questions a user can answer and create the corresponding number of entries in Trial History table
     */
    public void updateTrialHistory(){
        int daysAfterRegister = (int) this.daysAfterRegistration();
        System.out.println(daysAfterRegister);
        int questionToday = daysAfterRegister+1;
        
        // Create loop that checks whether there is a entry for today's and yesterday's question
        while(questionToday>0){
            if(!this.isTrialHistoryUpdated(questionToday)){
                // Trial history not updated yet, so insert today's question
                this.insertNewQuestionAttempt(questionToday, 0);
            }
            // Check for previous day's questions
            questionToday--;
        }

    }
}