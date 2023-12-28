
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
            SELECT user_table.username, MerchandiseOrder.purchase_amount, MerchandiseOrder.merchandise_id, MerchandiseOrder.delivery_address 
            FROM user_table
            JOIN MerchandiseOrder
            ON MerchandiseOrder.buyer_id = user_table.user_id
            WHERE username = "%s";                             
                                         """, username);

        // Execute query
        ResultSet rset = stmt.executeQuery(strSelect);

        int rowCount = 0;
        // Get purchase history of a user from database
        while(rset.next()){
            outputString = String.format("%s orders %s %s to %s", rset.getString("username"), rset.getString("purchase_amount"), rset.getString("merchandise_id"),rset.getString("delivery_address"));
            output.add(outputString);
            rowCount++;
        } 
        }catch(SQLException ex){
            System.out.println("SQL query failed.");
            ex.printStackTrace();
        }    
        System.out.printf("Successful query for merchandise data of %s\n",username);
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
        // Insert information into database
        int countInserted = stmt.executeUpdate(sqlInsert);
            
        }catch(SQLException ex){
            System.out.println("SQL failed! Find Khiew");
            ex.printStackTrace();
            return false;
        }
        System.out.printf("Successful insert: %s bought merch\n",username);
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
        System.out.printf("Successful query for tree planted by %s\n",username);
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
        // Insert information into database
        int countInserted = stmt.executeUpdate(sqlInsert);
            
        }catch(SQLException ex){
            System.out.println("SQL failed! Find Khiew");
            ex.printStackTrace();
            return false;
        }
        System.out.printf("Successful insert: %s planted %s",username,treeName);
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
        System.out.println("Successful query for donations data");
        return output;  
    }
    
    public static boolean makeNewDonations(String username, double donationAmount, String organisationName){
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
        String sqlInsert = String.format("INSERT INTO donations_history(donor_id,donation_amount,organisation) VALUES(%s,%f,\"%s\");", userID, donationAmount,organisationName);
        // Insert information into database
        int countInserted = stmt.executeUpdate(sqlInsert);
            
        }catch(SQLException ex){
            System.out.println("SQL failed! Find Khiew");
            ex.printStackTrace();
            return false;
        }
        System.out.printf("Success insert: %s donated %f to %s\n",username,donationAmount,organisationName);
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
        System.out.printf("Successfully get news number %d\n",newsIdentifier);
        
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
            System.out.printf("Successfully get trivia number %d\n",triviaNumber);
            return output;
        }
        
        public static int getNumberOfTries(String username, int question_id){
            // This method accepts username and question_id.
            // It returns the number of times the user attempted the question
            // Will return -1 if user/question does not exist
            
            int numberOfTries = 0;
            
            // Query database for number of tries
            try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
                Statement stmt = conn.createStatement();
                ){
            // Create SQL query
            String strSelect = String.format("""
                                             SELECT number_of_tries 
                                             FROM user_table
                                             JOIN trial_history
                                             ON trial_history.user_id = user_table.user_id
                                             WHERE username = "%s" and trivia_id = %d;
                                             """,username,question_id);

            // Execute query
            ResultSet rset = stmt.executeQuery(strSelect);

            // Get questions, options and answer from the database
            while(rset.next()){
                numberOfTries = Integer.parseInt(rset.getString("number_of_tries"));
            } 
            }catch(SQLException ex){
                System.out.printf("Failed to query database for number_of_tries of %s for question %d\n",username,question_id);
                ex.printStackTrace();   
                return -1;
            }            
            
            System.out.printf("Successful query: %s attempted question %d %d times\n",username,question_id,numberOfTries);
            return numberOfTries;
        }
        
        private static boolean insertNewQuestionAttempt(String username, int questionID, int numberOfTries){
            // This method will create a new row for in trial_history table for specified user and question
            // Returns true if successful
            
            String userID = login.getUserData(username, "user_id");
            
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
        
        
        private static boolean updateNumberOfTries(String username, int questionID, int numberOfTries){
            // This method will update the number of tries of an existing entry in trial_history
            // Returns true if number_of_trials for a specific user and question is successfully updated
            
            String userID = login.getUserData(username, "user_id");
            try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
               ){
                // Create SQL Insert
                String sqlInsert = String.format("""
                                                 UPDATE trial_history 
                                                 SET number_of_tries = %d
                                                 WHERE user_id = %s AND trivia_id = %d;
                                                 """, numberOfTries, userID, questionID);

                // Insert information into database
                int countInserted = stmt.executeUpdate(sqlInsert);

            }catch(SQLException ex){
                System.out.println("SQL failed! Find Khiew");
                ex.printStackTrace();
                return false;
            }              
            System.out.printf("Successful Update: Updated number of tries of %s for question %d\n",username,questionID);
            return true;
        }
        
        public static boolean setNumberOfTries(String username, int question_id, int numberOfTries){
            // This method receives username, question_id and numberOfTries
            // It will create a new entry if the entry does not exist in trial_history
            // It will update entry if the entry exists in trial_history
            // Returns true if method is succussful
            
            // Check if entry alrady exist in the table
            boolean doesEntryExist = true;
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
                                             """,username,question_id);

            // Execute query
            ResultSet rset = stmt.executeQuery(strSelect);

            // Get questions, options and answer from the database
            while(rset.next()){
                String user_id = rset.getString("user_id");
                if(user_id.equals("")){
                    doesEntryExist = false;
                }
            } 
            }catch(SQLException ex){
                System.out.printf("Failed to query database for number_of_tries of %s for question %d\n",username,question_id);
                ex.printStackTrace();   
                return false;
            }            
            
            // Check if there is an entry for this user and this question in trial_history
            if(!doesEntryExist){
                System.out.printf("No entry found for this combination. Create new entry for user %s, question %d\n",username,question_id);
                // Create a new entry for this user if entry does not exist
                boolean insertSuccessful = insertNewQuestionAttempt(username, question_id,numberOfTries);
                if(insertSuccessful){
                    System.out.printf("Succesfully set number of tries for %s and question %d\n",username,question_id);
                    return true;

                }else{
                    System.out.println("Failed to insert new entry. User/question does not exist");
                    return false;
                }
            }else{
                boolean updateSuccessful = updateNumberOfTries(username, question_id,numberOfTries);
                if(updateSuccessful){
                    System.out.printf("Succesfully set number of tries for %s and question %d\n",username,question_id);
                    return true;
                }
                else{
                    System.out.println("Failed to update entry in trial_history");
                    return false;
                }
            }
        }
        
        public static boolean getIsCorrectFinally(String username, int question_id){
            // This method returns the boolean value of isCorrectCurrently for a certain user and question
            // This method assumes that user already exist.
            // This method will also return false if query fails. Check terminal output
            
            boolean isCorrectFinally = false;
            try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
                Statement stmt = conn.createStatement();
                ){
            // Create SQL query
            String strSelect = String.format("""
                                             SELECT isCorrectFinally
                                             FROM user_table
                                             JOIN trial_history
                                             ON trial_history.user_id = user_table.user_id
                                             WHERE username = "%s" and trivia_id = %d;
                                             """,username,question_id);

            // Execute query
            ResultSet rset = stmt.executeQuery(strSelect);

            // Get questions, options and answer from the database
            while(rset.next()){
                isCorrectFinally = rset.getBoolean("isCorrectFinally");
            } 
            }catch(SQLException ex){
                System.out.printf("Failed to query database for number_of_tries of %s for question %d\n",username,question_id);
                ex.printStackTrace();   
                return false;
            }            
            
            System.out.printf("Database query successful: isCorrectFinally is %b\n",isCorrectFinally);
            return isCorrectFinally;
        }
        
        public static boolean getIsCorrectCurrently(String username, int question_id){
         // This method returns the boolean value of isCorrectCurrently for a certain user and question
         // This method assumes that user already exist.
         // This method will also return false if query fails. Check terminal output

            boolean isCorrectCurrently = false;
            try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
                Statement stmt = conn.createStatement();
                ){
            // Create SQL query
            String strSelect = String.format("""
                                             SELECT isCorrectCurrently
                                             FROM user_table
                                             JOIN trial_history
                                             ON trial_history.user_id = user_table.user_id
                                             WHERE username = "%s" and trivia_id = %d;
                                             """,username,question_id);

            // Execute query
            ResultSet rset = stmt.executeQuery(strSelect);

            // Get questions, options and answer from the database
            while(rset.next()){
                isCorrectCurrently = rset.getBoolean("isCorrectCurrently");
            } 
            }catch(SQLException ex){
                System.out.printf("Failed to query database for number_of_tries of %s for question %d\n",username,question_id);
                ex.printStackTrace();   
                return false;
            }            

            System.out.printf("Database query successful: isCorrectCurrently is %b\n",isCorrectCurrently);
            return isCorrectCurrently;
    }
           
        public static boolean setIsCorrectFinally(String username, int question_id, boolean newValue){
            // This method set isCorrectFinally of a specified user and question_id
            // Returns true if update successful
            
            String userID = login.getUserData(username, "user_id");
            int isCorrectFinallyValue;
            if(newValue)
                isCorrectFinallyValue = 1;
            else
                isCorrectFinallyValue = 0;
            
            try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
               ){
                // Create SQL Insert
                String sqlInsert = String.format("UPDATE trial_history SET isCorrectFinally = %d WHERE user_id = %s and trivia_id = %d;", isCorrectFinallyValue, userID,question_id);

                // Insert information into database
                int countInserted = stmt.executeUpdate(sqlInsert);

            }catch(SQLException ex){
                System.out.println("SQL failed! Find Khiew");
                ex.printStackTrace();
                return false;
            }              
            
            System.out.println("Successful Update: Updated isCorrectFinally of "+username+" for question "+question_id);
            return true;
        }
        
        public static boolean setIsCorrectCurrently(String username, int question_id, boolean newValue){
            // This method set isCorrectFinally of a specified user and question_id
            // Returns true if update successful
            
            String userID = login.getUserData(username, "user_id");
            int isCorrectCurrentlyValue;
            if(newValue)
                isCorrectCurrentlyValue = 1;
            else
                isCorrectCurrentlyValue = 0;
            
            try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
            Statement stmt = conn.createStatement();
               ){
                // Create SQL Insert
                String sqlInsert = String.format("UPDATE trial_history SET isCorrectCurrently = %d WHERE user_id = %s and trivia_id = %d;", isCorrectCurrentlyValue, userID,question_id);

                // Insert information into database
                int countInserted = stmt.executeUpdate(sqlInsert);

            }catch(SQLException ex){
                System.out.println("SQL failed! Find Khiew");
                ex.printStackTrace();
                return false;
            }              
            
            System.out.println("Successful Update: Updated isCorrectCurrently of "+username+" for question "+question_id);
            return true;
        }
        
}
