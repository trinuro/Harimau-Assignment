
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
    
    public static boolean buyMerch(String username, String merchName, String numberOfMerch, String deliveryAddress){
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
        String sqlInsert = String.format("INSERT INTO MerchandiseOrder(buyer_id,merchandise_id,purchase_amount,delivery_address) VALUES(%s,\"%s\",\"%s\",\"%s\");", userID, merchName, numberOfMerch, deliveryAddress);
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
}