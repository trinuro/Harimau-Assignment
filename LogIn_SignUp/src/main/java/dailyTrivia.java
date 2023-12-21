import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dailyTrivia extends Trivia{
    private String username;
    private ArrayList<Trivia> questionSetCanBeAnswered = new ArrayList<>();
    private int noOfDayLogin = 1;
    
    public dailyTrivia(String username){
        this.username = username;
        this.noOfDayLogin = getDayLogin(username);
        this.questionSetCanBeAnswered = getQuestionSetCanBeAnswered();
    }
    
    public int getDayLogin(String username) {
        return 3;
    }
    
    //***********************************************************************
    // ********************START FROM HERE***********************************
    
    // get string of specific question based on the number of qustions (from 1 to 10)
    @Override
    public String getQuestion(int question) {
        return super.getQuestion(question);
    }
    
    // get string array of options based on the number of qustions (from 1 to 10)
    @Override
    public String[] getOptions(int question) {
        if (questionSetCanBeAnswered.get(question-1).getNumberOFAttempt()  == 0) {
            return super.getOptions(question);
        }
        return shuffledOptionsArray(super.getOptions(question));
    }
    
    // get string of answer based on the number of qustions (from 1 to 10)
    @Override
    public String getAnswer(int question) {
        return super.getAnswer(question);
    }
    
    // get the question set that can be answered by the user in according to their no of day login
    // getQuestionSetCanBeAnswered().size() will return the size of the ArrayList, which is the same as the no of day login
    public ArrayList<Trivia> getQuestionSetCanBeAnswered(){
        if (questionSetCanBeAnswered.size() < noOfDayLogin) {
            int differenceOfDay = noOfDayLogin - questionSetCanBeAnswered.size();
            for (int i = 0; i < differenceOfDay; i++) {
                questionSetCanBeAnswered.add(new Trivia(questionSetCanBeAnswered.size()+1+i));
            }
        }
        return questionSetCanBeAnswered;
    }
    
    // return the double marks value allocated for the given question
    public double getmarkAllocated(int noOfQuestion) {
        return markAllocated(noOfQuestion, getQuestionSetCanBeAnswered().get(noOfQuestion-1).getNumberOFAttempt());
    }
    
    // return the boolean value of the answer chosen
    public boolean isCorrectAnswer(int noOfQuestion) {
        return getQuestionSetCanBeAnswered().get(noOfQuestion-1).getIsCorrectForTrial();
    }
    
    // return string value of the title (not neccesary to be used)
    public String title(int noOfQuestion) {
        if (getQuestionSetCanBeAnswered().get(noOfQuestion-1).getNumberOFAttempt() >= 2 || getQuestionSetCanBeAnswered().get(noOfQuestion-1).getIsCorrect()) {
            return "Day " + noOfQuestion + " Trivia ( Attempt without marks increment )";
        }
        return "Day " + noOfQuestion + " Trivia ( Attempt #" + (getQuestionSetCanBeAnswered().get(noOfQuestion-1).getNumberOFAttempt()+1) + " )";
    }
    
    // has to be run to update isCorrect, numberOfAttempt and to increasuser marks if any
    public void isCorrect(int noOFQuestion, String selectedAnswer) {
        if (!getQuestionSetCanBeAnswered().get(noOFQuestion-1).getIsCorrect()) {
            getQuestionSetCanBeAnswered().get(noOFQuestion-1).setIsCorrect(noOFQuestion, selectedAnswer.equals(getAnswer(noOFQuestion)));
            getQuestionSetCanBeAnswered().get(noOFQuestion-1).setIsCorrectForTrial(noOFQuestion, selectedAnswer.equals(getAnswer(noOFQuestion)));
            updateNoOfAttempt(noOFQuestion, getQuestionSetCanBeAnswered().get(noOFQuestion-1).getNumberOFAttempt(), getQuestionSetCanBeAnswered().get(noOFQuestion-1).getIsCorrect());
            increasePoints(username, getmarkAllocated(noOFQuestion));
        } else {
            getQuestionSetCanBeAnswered().get(noOFQuestion-1).setIsCorrectForTrial(noOFQuestion, selectedAnswer.equals(getAnswer(noOFQuestion)));
            System.out.println("Thanks for trying again");
        }
        
    }
    
    // can be run for tesing the output
    public void displayQuestion(int noOfQuestion) {
        Scanner input = new Scanner(System.in); 
        System.out.println(title(noOfQuestion));                 
        System.out.println(getQuestion(noOfQuestion));
        String[] optionList  = getOptions(noOfQuestion);
        for (int j = 0; j < 4; j++) {
            System.out.println(optionList[j]);
        }
        String option = input.nextLine();
        // check if the answer input is correct
        this.isCorrect(noOfQuestion, option);
        System.out.println(isCorrectAnswer(noOfQuestion));
                
        System.out.println("Mark allocated : " + getmarkAllocated(noOfQuestion));
                
    }
    
    // return the string value of the username
    public String getUsername() {
        return this.username;
    }
    
    // ************************************Until here*****************************************
    //**************************************************************************************
    
    
    public void setDayLogin(int noOFDayLogin) {
        this.noOfDayLogin = noOFDayLogin;
    }
    
    private static String[] shuffledOptionsArray(String[] options) {
        List<String> optionsList = Arrays.asList(options);
        Collections.shuffle(optionsList);
        return optionsList.toArray(options);
    }
    
    private double markAllocated(int noOfQuestion, int noOfAttempt) {
        if(isCorrectAnswer(noOfQuestion) && noOfAttempt == 0){
            return 2;
        } else if (isCorrectAnswer(noOfQuestion) && noOfAttempt == 1){
            return 1;
        } return 0;
    }
    
    private void updateNoOfAttempt(int noOfQuestion, int noOfAttempt, boolean isCorrect) {
        if (!isCorrect) {
            getQuestionSetCanBeAnswered().get(noOfQuestion-1).setNumberOFAttempt(++noOfAttempt);
        }
    }
    
    private static void increasePoints(String username, double increment){
//        int initialPoints=0;
//        
//        try(
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_data", "root", "harimau");
//        Statement stmt = conn.createStatement();
//           ){
//            // Create SQL Query
//            String sqlQuery = String.format("SELECT current_points FROM user_table WHERE username=\'%s\';",username);
//            System.out.println("SQL Statement to be executed: "+sqlQuery);
//            
//            // Execute query
//            ResultSet rset = stmt.executeQuery(sqlQuery);
//            while(rset.next()){
//                initialPoints = rset.getInt("current_points");
//            }
//            System.out.println(initialPoints);
//            
//            
//            // Create SQL Insert
//            String sqlInsert = String.format("UPDATE user_table SET current_points= %d WHERE username = \'%s\';", initialPoints+increment, username);
//            System.out.println("SQL Statement to be executed: "+sqlInsert);
//            
//            // Insert information into database
//            int countInserted = stmt.executeUpdate(sqlInsert);
//            System.out.println(countInserted+" records inserted.");
//            
//        }catch(SQLException ex){
//            System.out.println("SQL failed! Find Khiew");
//            ex.printStackTrace();
//        }        
    }
}

        
class Trivia {
//        // declare filepath
//        private static String filepath = "C:\\Users\\PC\\Documents\\NetBeansProjects\\harimau_newsTrial\\src\\main\\java\\com\\mycompany\\harimau_newstrial\\TriviaSample.txt";
//    
//        private static final ArrayList<String> l1 = readFileInArrayList(filepath);// convert the file into arrrayList
        private static final ArrayList<String> questionList = getQuestionArrayList();// create ArraylLst for questions
        private static final ArrayList<String> answerList = getAnswerArrayList();// create Arraylist for  answer
        private static final ArrayList<String> optionList = getOptionsArrayList();
        private static final ArrayList<String[]> trueOptionList =createTrueOptionList();
        private static final ArrayList<Trivia> totalQuestionSet = createTotalQuestionSet();
        private  String specificQuestion = "";
        private  String[] specificOptions = new String[4];
        private  String specificAnswer = "";
        private int numberOfAttempt;
        private boolean isCorrect ;
        private boolean isCorrectForTrial;
        
        public Trivia() {
        }
        
        public Trivia(int noOfQuestion){
            this.specificQuestion = questionList.get(noOfQuestion-1);
            this.specificOptions = trueOptionList.get(noOfQuestion-1);
            this.specificAnswer = answerList.get(noOfQuestion-1);
            this.numberOfAttempt = 0;
            this.isCorrect = false;
            this.isCorrectForTrial = false;
        }
        
        public Trivia(String question, String[] options, String answer){
            this.specificQuestion = question;
            this.specificOptions = options;
            this.specificAnswer = answer;
            this.numberOfAttempt = 0;
            this.isCorrect = false;
        }
        
        public static ArrayList<Trivia> createTotalQuestionSet() {
            ArrayList<Trivia> totalquestionset = new ArrayList<>();
            for (int i = 0; i < questionList.size(); i++) {
                Trivia trivias = new Trivia(questionList.get(i), trueOptionList.get(i), answerList.get(i));
                totalquestionset.add(trivias);
            }
            return totalquestionset;
        }
        
        public static ArrayList<Trivia> getTotalQuestionSet() {
            return totalQuestionSet;
        } 
        
    public static ArrayList<String[]> createTrueOptionList() {
        ArrayList<String[]> trueoptionList = new ArrayList<>();
        for (int noOfQuestion = 0; noOfQuestion < optionList.size(); noOfQuestion++) {
            String[] optionArray = optionList.get(noOfQuestion).split(",");
            trueoptionList.add(optionArray);
        }
        return trueoptionList;
    }
    
    public String getQuestion(int question) {
        return totalQuestionSet.get(question-1).specificQuestion;
    }
    
    // get string array of options based on the number of qustions
    public String[] getOptions(int question) {
        return totalQuestionSet.get(question-1).specificOptions;
    }
    
    public String getAnswer(int question) {
        return totalQuestionSet.get(question-1).specificAnswer;
    }
    
    public int getNumberOFAttempt() {
        return this.numberOfAttempt;
    }
    
    public boolean getIsCorrect() {
        return this.isCorrect;
    }
    
    public void setIsCorrect(int question, boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
    
    public boolean getIsCorrectForTrial() {
        return this.isCorrectForTrial;
    }
    
    public void setIsCorrectForTrial(int question, boolean isCorrect) {
        this.isCorrectForTrial = isCorrect;
    }
    
    public void setNumberOFAttempt(int noOfAttempt) {
        this.numberOfAttempt = noOfAttempt;
    }
    
    // by connecting to database
    // create a method to create questionList
    public static ArrayList<String> getQuestionArrayList() {
        ArrayList<String> newArray = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            newArray.add(Utilities.getTrivia(i)[0]);
        }
        return newArray;
    }
    // create a method to create optionsList
    public static ArrayList<String> getOptionsArrayList() {
        ArrayList<String> newArray = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            newArray.add(Utilities.getTrivia(i)[1]);
        }
        return newArray;
    }
    // create a method to create answerList
    public static ArrayList<String> getAnswerArrayList() {
        ArrayList<String> newArray = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            newArray.add(Utilities.getTrivia(i)[2]);
        }
        return newArray;
    }
    
//    // create a method to read file as list by using TriviaSample.txt file
//    public static ArrayList<String> readFileInArrayList(String filepath) {
//        List<String> fileList = new ArrayList<>();
//        try {
//            fileList = Files.readAllLines(Paths.get(filepath), StandardCharsets.UTF_8);
//        } catch (Exception e) {
//            System.out.println("No such file directory. Question cannot be obtained");
//        }
//        return (ArrayList<String>)fileList;
//    }
//    
//    // create a method to create questionList/answerList/optionsList
//    public static ArrayList<String> getArrayList(ArrayList<String> originalArrayList, int multipleOfLine) {
//        ArrayList<String> newArray = new ArrayList<>();
//        for (int i = 0; i < originalArrayList.size(); i++) {
//            if ((i-multipleOfLine)%3 == 0) {
//                newArray.add(originalArrayList.get(i));
//            }
//        }
//        return newArray;
//    }
//    // create a method to create questionList
//    public static ArrayList<String> getQuestionArrayList() {
//        ArrayList<String> newArray = getArrayList(l1, 3);
//        return newArray;
//    }
//    // create a method to create optionsList
//    public static ArrayList<String> getOptionsArrayList() {
//        ArrayList<String> newArray = getArrayList(l1, 1);
//        return newArray;
//    }
//    // create a method to create answerList
//    public static ArrayList<String> getAnswerArrayList() {
//        ArrayList<String> newArray = getArrayList(l1, 2);
//        return newArray;
//    }
}