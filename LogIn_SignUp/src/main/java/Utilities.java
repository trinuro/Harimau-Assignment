
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Khiew
 */
public class Utilities {
        
    public static ArrayList<String> getMerchandiseData(String username){
        // This method accepts a username and returns all rows in tables about the user
        // Returns "" if user did not buy anything
        String outputString = "";
        ArrayList<String> output = new ArrayList<String>();


        // Connect to database
        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
            ){
        // Create SQL query
        String strSelect = String.format("""
            SELECT user_table.username, MerchandiseOrder.merchandise_id, MerchandiseOrder.purchase_amount, MerchandiseOrder.delivery_address 
            FROM user_table
            JOIN MerchandiseOrder
            ON MerchandiseOrder.buyer_id = user_table.user_id
            WHERE username = "%s";                             
                                         """, username);
        System.out.println("The SQL statement is "+strSelect);

        // Execute query
        ResultSet rset = stmt.executeQuery(strSelect);

        int rowCount = 0;
        // Get purchase history of a user from database
        while(rset.next()){
            outputString = String.format("%s orders %s %s to %s", rset.getString("username"), rset.getString("merchandise_id"), rset.getString("purchase_amount"),rset.getString("delivery_address"));
            output.add(outputString);
            rowCount++;
        } 
        }catch(SQLException ex){
            System.out.println("SQL query failed.");
            ex.printStackTrace();
        }    

        return output;            
    }
    
    public static boolean buyMerch(String username, String merchName, int numberOfMerch, String deliveryAddress){
        String userID = login.getUserData(username, "user_id");
        if(userID.equals("")){
            // Returns false if user does not exists
            return false;
        }
        try(
//          Create connection to database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
        ){

        // SQL command to be executed
        String sqlInsert = String.format("INSERT INTO MerchandiseOrder(buyer_id,merchandise_id,purchase_amount,delivery_address) VALUES(%s,\"%s\",\"%d\",\"%s\");", userID, merchName, numberOfMerch, deliveryAddress);
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
    
    public static ArrayList<String> getTreePlantedData(String username){
        // This method accepts a username and returns all rows in tables about the user
        // Returns "" if user did not buy anything
        String outputString = "";
        ArrayList<String> output = new ArrayList<String>();


        // Connect to database
        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
            ){
        // Create SQL query
        String strSelect = String.format("""
            SELECT user_table.username, trees.tree_name
            FROM user_table
            JOIN trees
            ON trees.buyer_id = user_table.user_id
            WHERE username = "%s";                          
                                         """, username);
        System.out.println("The SQL statement is "+strSelect);

        // Execute query
        ResultSet rset = stmt.executeQuery(strSelect);

        int rowCount = 0;
        // Get purchase history of a user from database
        while(rset.next()){
            outputString = String.format("%s plants a tree with the name \"%s\" ", rset.getString("username"), rset.getString("tree_name"));
            output.add(outputString);
            rowCount++;
        } 
        }catch(SQLException ex){
            System.out.println("SQL query failed.");
            ex.printStackTrace();
        }    

        return output;            
    }
    
    public static boolean plantNewTree(String username, String treeName){
        // This method receives username and tree name as input. 
        // It will add a new entry into the trees table for that user.
        
        // Get user ID given username
        String userID = login.getUserData(username, "user_id");
        // Check whether user exists
        if(userID.equals("")){
            return false;
        }
        try(
//          Create connection to database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
        ){

        // SQL command to be executed
        String sqlInsert = String.format("INSERT INTO trees(buyer_id, tree_name) VALUES(%s,\"%s\");", userID, treeName);
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
    
    public static ArrayList<String> getDonationsData(String username){
        // This methods retrieve all donations a user has made given his username
        
        String outputString;
        ArrayList<String> output= new ArrayList<String>();
        
        // Connect to database
        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
            ){
        // Create SQL query
        String strSelect = String.format("""
            SELECT user_table.username, donations_history.donation_amount, donations_history.organisation
            FROM user_table
            JOIN donations_history
            ON donations_history.donor_id = user_table.user_id
            WHERE username = "%s";                        
                                         """, username);
        System.out.println("The SQL statement is "+strSelect);

        // Execute query
        ResultSet rset = stmt.executeQuery(strSelect);

        int rowCount = 0;
        // Get purchase history of a user from database
        while(rset.next()){
            outputString = String.format("%s has donated %s to %s", rset.getString("username"), rset.getString("donation_amount"),rset.getString("organisation"));
            output.add(outputString);
            rowCount++;
        } 
        }catch(SQLException ex){
            System.out.println("SQL query failed.");
            ex.printStackTrace();       
        }    

        return output;  
    }
    
    public static boolean makeNewDonations(String username, int donationAmount, String organisationName){
        // Get user ID given username
        String userID = login.getUserData(username, "user_id");
        // Check whether user exists
        if(userID.equals("")){
            return false;
        }
        try(
//          Create connection to database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
        ){

        // SQL command to be executed
        String sqlInsert = String.format("INSERT INTO donations_history(donor_id,donation_amount,organisation) VALUES(%s,%d,\"%s\");", userID, donationAmount,organisationName);
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
    
    public static String[] getNews(int newsIdentifier){
        // This method returns a row given the position of news in NewsSample.txt
        // This method returns a 3 element String array. 
        // 1st element: title
        // 2nd element: link
        // 3rd element: date
        
        String[] output= new String[3];

        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
            ){
        // Create SQL query
        String strSelect = String.format("SELECT news_title, news_link, news_date FROM NewsSample WHERE news_id=%d;",newsIdentifier);
        System.out.println("The SQL statement is "+strSelect);

        // Execute query
        ResultSet rset = stmt.executeQuery(strSelect);

        int rowCount = 0;
        // Get purchase history of a user from database
        while(rset.next()){
//            outputString = String.format("%s has donated %s to %s", rset.getString("username"), rset.getString("donation_amount"),rset.getString("organisation"));
//            output.add(outputString);
            output[0] = rset.getString("news_title");
            output[1] = rset.getString("news_link");
            output[2] = rset.getString("news_date");
            rowCount++;
        } 
        }catch(SQLException ex){
            System.out.println("SQL query failed.");
            ex.printStackTrace();   
        }
        return output;
    }
    
        public static String[] getTrivia(int triviaNumber){
        // This method returns a row given the position of news in TriviaSample.txt
        // This method returns a 3 element String array. 
        // 1st element: question
        // 2nd element: options
        // 3rd element: answers
        
        String[] output= new String[3];

        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
            ){
        // Create SQL query
        String strSelect = String.format("SELECT question, options, answer FROM TriviaSample WHERE question_id=%d;",triviaNumber);
        System.out.println("The SQL statement is "+strSelect);

        // Execute query
        ResultSet rset = stmt.executeQuery(strSelect);

        int rowCount = 0;
        // Get questions, options and answer from the database
        while(rset.next()){
            output[0] = rset.getString("question");
            output[1] = rset.getString("options");
            output[2] = rset.getString("answer");
            rowCount++;
        } 
        }catch(SQLException ex){
            System.out.println("SQL query failed.");
            ex.printStackTrace();   
        }
        return output;
    }
}
