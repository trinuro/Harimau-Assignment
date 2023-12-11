import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dailyTrivia {
        // declare filepath
        private static String filepath = "C:\\Users\\PC\\Documents\\NetBeansProjects\\harimau_newsTrial\\src\\main\\java\\com\\mycompany\\harimau_newstrial\\TriviaSample.txt";
    
        private static final ArrayList<String> l1 = readFileInArrayList(filepath);// convert the file into arrrayList
        private static final ArrayList<String> questionList = getArrayList(l1, 3);// create ArraylLst for questions
        private static final ArrayList<String> answerList = getArrayList(l1, 2);// create Arraylist for  answer
        private static final ArrayList<String> optionList = getArrayList(l1, 1);
        private static final ArrayList<String[]> trueOptionList =createTrueOptionList();
        private static final ArrayList<dailyTrivia> totalQuestionSet = createTotalQuestionSet();
        private static ArrayList<dailyTrivia> questionSetCanBeAnswered = new ArrayList<>();
        private  String specificQuestion = "";
        private  String[] specificOptions = new String[4];
        private  String specificAnswer = "";
        
        private int numberOfAttempt = 0;
        private int totalMarks = 0;
        private static int noOfDayLogin = 1;
        private boolean isCorrect = false;
        
        public dailyTrivia(){
        }
        
        public dailyTrivia(String question, String[] options, String answer){
            this.specificQuestion = question;
            this.specificOptions = options;
            this.specificAnswer = answer;
            this.numberOfAttempt = 0;
            this.isCorrect = false;
        }
        
        public static void main(String[] args) {
            setDayLogin(3);
            System.out.println(getQuestionSetCanBeAnswered().size());
            for (int i = 1; i <= getQuestionSetCanBeAnswered().size(); i++) {
                dailyTrivia trivia1 = new dailyTrivia(getQuestion(i), getOptions(i), getAnswer(i));
                trivia1.displayQuestion(i);
            }
        }
        
        public void displayQuestion(int noOfQuestion) {
        Scanner input = new Scanner(System.in);
                outer:
                while (true) {   
                    System.out.println(title(noOfQuestion));                 
                    System.out.println(getQuestion(noOfQuestion));
                    String[] optionsArray = getOptions(noOfQuestion);
                for (int j = 0 ; j < 4; j++) {
                    System.out.println(optionsArray[j]);
                }
                String option = input.nextLine();
                // check if the answer input is correct
                getQuestionSetCanBeAnswered().get(noOfQuestion-1).isCorrect(noOfQuestion, option);
                System.out.println(getQuestionSetCanBeAnswered().get(noOfQuestion-1).isCorrect);
                // if the ans is not correct and the number of attempt is less than 2, the user can answer the question
                if (!getQuestionSetCanBeAnswered().get(noOfQuestion-1).isCorrect && getQuestionSetCanBeAnswered().get(noOfQuestion-1).numberOfAttempt<2) {
                    continue outer;
                    } else break;
                }
                System.out.println("Mark allocated : " + markAllocated(noOfQuestion, getQuestionSetCanBeAnswered().get(noOfQuestion-1).numberOfAttempt));
                
    }
        
        public static ArrayList<dailyTrivia> createTotalQuestionSet() {
            ArrayList<dailyTrivia> totalquestionset = new ArrayList<>();
            for (int i = 0; i < questionList.size(); i++) {
                dailyTrivia trivias = new dailyTrivia(questionList.get(i), trueOptionList.get(i), answerList.get(i));
                totalquestionset.add(trivias);
            }
        return totalquestionset;
    }
        
    public static ArrayList<String[]> createTrueOptionList() {
        ArrayList<String[]> trueoptionList = new ArrayList<>();
        for (int noOfQuestion = 0; noOfQuestion < optionList.size(); noOfQuestion++) {
            String[] optionArray = optionList.get(noOfQuestion).split(",");
            trueoptionList.add(optionArray);
        }
        return trueoptionList;
    }
    
    //***********************************************************************
    // ********************START FROM HERE***********************************
    
    // get string of specific option based on the number of qustions & specific number of option
    public static String getQuestion(int question) {
        return questionList.get(question-1);
    }
    
    // get string array of options based on the number of qustions
    public static String[] getOptions(int question) {
        if (getQuestionSetCanBeAnswered().get(question-1).numberOfAttempt  == 0) {
            return trueOptionList.get(question-1);
        }
        return shuffledOptionsArray(trueOptionList.get(question-1));
    }
    
    public static String getAnswer(int question) {
        return answerList.get(question-1);
    }
    
    public static ArrayList<dailyTrivia> getQuestionSetCanBeAnswered(){
        if (questionSetCanBeAnswered.size() < noOfDayLogin) {
            int differenceOfDay = noOfDayLogin - questionSetCanBeAnswered.size();
            for (int i = 0; i < differenceOfDay; i++) {
                questionSetCanBeAnswered.add(totalQuestionSet.get(questionSetCanBeAnswered.size()+1+i));
            }
        }
        return questionSetCanBeAnswered;
    }
    
    public String title(int noOfQuestion) {
        if (getQuestionSetCanBeAnswered().get(noOfQuestion-1).numberOfAttempt >= 2 || getQuestionSetCanBeAnswered().get(noOfQuestion-1).isCorrect) {
            return "Day " + noOfQuestion + " Trivia ( Attempt without marks increment )";
        }
        return "Day " + noOfQuestion + " Trivia ( Attempt #" + (getQuestionSetCanBeAnswered().get(noOfQuestion-1).numberOfAttempt+1) + " )";
    }
    
    // ************************************Until here*****************************************
    //**************************************************************************************
    
    public static int getDayLogin() {
        return noOfDayLogin;
    }
    
    public static void setDayLogin(int noOFDayLogin) {
        noOfDayLogin = noOFDayLogin;
    }
    
    public void isCorrect(int noOFQuestion, String selectedAnswer) {
        if (selectedAnswer.equals(getAnswer(noOFQuestion))) {
            getQuestionSetCanBeAnswered().get(noOFQuestion-1).isCorrect = true;
        } 
        updateNoOfAttempt(noOFQuestion, getQuestionSetCanBeAnswered().get(noOFQuestion-1).numberOfAttempt, getQuestionSetCanBeAnswered().get(noOFQuestion-1).isCorrect);
        totalMarks += markAllocated(noOFQuestion, getQuestionSetCanBeAnswered().get(noOFQuestion-1).numberOfAttempt);
    }
    
    public static String[] shuffledOptionsArray(String[] options) {
        List<String> optionsList = Arrays.asList(options);
        Collections.shuffle(optionsList);
        return optionsList.toArray(options);
    }
    
    public int markAllocated(int noOfQuestion, int noOfAttempt) {
        if(getQuestionSetCanBeAnswered().get(noOfQuestion-1).isCorrect && noOfAttempt ==0){
            return 2;
        } else if (getQuestionSetCanBeAnswered().get(noOfQuestion-1).isCorrect && noOfAttempt == 1){
            return 1;
        } return 0;
    }
    
    public void updateNoOfAttempt(int noOfQuestion, int noOfAttempt, boolean isCorrect) {
        if (!isCorrect) {
            this.numberOfAttempt = ++noOfAttempt;
        }
    }
    
    // create a method to read file as list
    public static ArrayList<String> readFileInArrayList(String filepath) {
        List<String> fileList = new ArrayList<>();
        try {
            fileList = Files.readAllLines(Paths.get(filepath), StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println("No such file directory. Question cannot be obtained");
        }
        return (ArrayList<String>)fileList;
    }
    
    
    // create a method to create titleList/urlList/dateList
    public static ArrayList<String> getArrayList(ArrayList<String> originalArrayList, int multipleOfLine) {
        ArrayList<String> newArray = new ArrayList<>();
        for (int i = 0; i < originalArrayList.size(); i++) {
            if ((i-multipleOfLine)%3 == 0) {
                newArray.add(originalArrayList.get(i));
            }
        }
        return newArray;
    }
    
    public static String getData(String username, String columnTitle){
        // This function returns data from database based on username and column title
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
        }    
        
        return output;
        
        
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
