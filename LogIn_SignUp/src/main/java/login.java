/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Khiew
 */
// Import required modules

import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class login {

    /**
     * This method will search the database for this user and increase his/her marks by the increment.
     * @param username
     * @param increment 
     */
    public static void increasePoints(String username, double increment){
        
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
            String sqlInsert = String.format("UPDATE user_table SET current_points= %f WHERE username = \'%s\';", initialPoints+increment, username);
            System.out.println("SQL Statement to be executed: "+sqlInsert);
            
            // Insert information into database
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted+" records inserted.");
            
        }catch(SQLException ex){
            System.out.println("SQL failed! Find Khiew");
            ex.printStackTrace();
        }        
    }
    
    /**
     * This method returns data from database based on table name, username and column title
     * @param username
     * @param columnTitle
     * @return data from database 
     */
    public static String getUserData( String username, String columnTitle){        
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
        
        return output;
    }

    /**
     * This method receives a username and returns the number of days the user has logged in
     * @param username
     * @return number of days the user has logged in
     */
    
    public static long daysAfterRegistration(String username){
        
        LocalDate startDate, endDate;
        startDate = LocalDate.now();
        
        // Connect to database
        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
            ){
        // Create SQL query
        String strSelect = String.format("SELECT registration_date FROM user_table WHERE username = \'%s\';",username);
        
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

}
