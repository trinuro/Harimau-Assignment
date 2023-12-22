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
        return (int)login.daysAfterRegistration(username);
    }
    
    public static void main(String[] args) {
        dailyTrivia trvia1 = new dailyTrivia("Lim");
        dailyTrivia trvia2 = new dailyTrivia("Lim");
        Scanner input = new Scanner(System.in);
        while (true) {            
            System.out.println("Enter your username");
            int user = input.nextInt();
            System.out.println("Enter the question you want:");
            int noOfQuestion = input.nextInt();
            if (user == 1) {
                System.out.println(trvia1.getNumberOFAttempt());
                trvia1.displayQuestion(noOfQuestion);
            }else trvia2.displayQuestion(noOfQuestion);
            
        }
        
    }
        
    //***********************************************************************
    // *******************START FROM HERE**********************************
    
    // get string of specific question based on the number of qustions (from 1 to 10)
    @Override
    public String getQuestion(int question) {
        return super.getQuestion(question);
    }
    
    // get string array of options based on the number of qustions (from 1 to 10)
    @Override
    public String[] getOptions(int question) {
        System.out.println("No of attempt = " + getQuestionSetCanBeAnswered().get(question-1).getNumberOFAttempt());
        if (getQuestionSetCanBeAnswered().get(question-1).getNumberOFAttempt()  == 0) {
            System.out.println("No shuffle");
            String[] currentOptionList = super.getOriginalOptions(question);
            return currentOptionList;
        }
        System.out.println("shuffled");
        String[] currentOptionList = shuffledOptionsArray(super.getOptions(question));
        return currentOptionList;
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
    
     // return int numberOfAttempt
    public int gatNumberOfAttempt(int question){
        return getQuestionSetCanBeAnswered().get(question-1).getNumberOFAttempt();
    }
    
    // return the double marks value allocated for the given question
    public double getmarkAllocated(int noOfQuestion) {
        return markAllocated(noOfQuestion, getQuestionSetCanBeAnswered().get(noOfQuestion-1).getNumberOFAttempt());
    }
    
    // return the boolean value of the answer chosen
    public boolean getIsCorrectAnswerCurrently(int noOfQuestion) {
        return getQuestionSetCanBeAnswered().get(noOfQuestion-1).getIsCorrectForTrial();
    }
    
    // return the boolean value of the answer chosen
    public boolean getIsCorrectAnswerFinally(int noOfQuestion) {
        return getQuestionSetCanBeAnswered().get(noOfQuestion-1).getIsCorrect();
    }
    
    // return string value of the title (not neccesary to be used)
    public String title(int noOfQuestion) {
        if (getQuestionSetCanBeAnswered().get(noOfQuestion-1).getNumberOFAttempt() >= 2 || getIsCorrectAnswerFinally(noOfQuestion)) {
            return "Day " + noOfQuestion + " Trivia ( Attempt without marks increment )";
        }
        return "Day " + noOfQuestion + " Trivia ( Attempt #" + (getQuestionSetCanBeAnswered().get(noOfQuestion-1).getNumberOFAttempt()+1) + " )";
    }
    
    // has to be run to update isCorrect, numberOfAttempt and to increasuser marks if any
    public void isCorrect(int noOFQuestion, String selectedAnswer) {
        if (!getIsCorrectAnswerFinally(noOFQuestion)) {
            getQuestionSetCanBeAnswered().get(noOFQuestion-1).setIsCorrect(noOFQuestion, selectedAnswer.equals(getAnswer(noOFQuestion)));
            getQuestionSetCanBeAnswered().get(noOFQuestion-1).setIsCorrectForTrial(noOFQuestion, selectedAnswer.equals(getAnswer(noOFQuestion)));
            updateNoOfAttempt(noOFQuestion, getQuestionSetCanBeAnswered().get(noOFQuestion-1).getNumberOFAttempt(), getIsCorrectAnswerFinally(noOFQuestion));
            login.increasePoints(username, getmarkAllocated(noOFQuestion));
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
        System.out.println(getIsCorrectAnswerCurrently(noOfQuestion));
                
        System.out.println("Mark allocated : " + getmarkAllocated(noOfQuestion));
                
    }
    
    // return the string value of the username
    public String getUsername() {
        return this.username;
    }
    
    // ***********************************Until here****************************************
    //**************************************************************************************
   
    private static String[] shuffledOptionsArray(String[] options) {
        List<String> optionsList = Arrays.asList(options);
        Collections.shuffle(optionsList);
        return optionsList.toArray(options);
    }
    
    private double markAllocated(int noOfQuestion, int noOfAttempt) {
        if(getIsCorrectAnswerFinally(noOfQuestion) && noOfAttempt == 0){
            return 2;
        } else if (getIsCorrectAnswerFinally(noOfQuestion) && noOfAttempt == 1){
            return 1;
        } return 0;
    }
    
    private void updateNoOfAttempt(int noOfQuestion, int noOfAttempt, boolean isCorrect) {
        if (!isCorrect) {
            getQuestionSetCanBeAnswered().get(noOfQuestion-1).setNumberOFAttempt(++noOfAttempt);
        }
    }
}

        
class Trivia {
     // declare filepath
    private static String filepath = "src/main/resources/TriviaSample.txt";
    
    private static final ArrayList<String> l1 = readFileInArrayList(filepath);// convert the file into arrrayList
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
        
    private static ArrayList<Trivia> createTotalQuestionSet() {
        ArrayList<Trivia> totalquestionset = new ArrayList<>();
        for (int i = 0; i < questionList.size(); i++) {
            Trivia trivias = new Trivia(questionList.get(i), trueOptionList.get(i).clone(), answerList.get(i));
            totalquestionset.add(trivias);
        }
        return totalquestionset;
    }
        
    public static ArrayList<Trivia> getTotalQuestionSet() {
        return totalQuestionSet;
    } 
        
    private static ArrayList<String[]> createTrueOptionList() {
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
    
    public String[] getOriginalOptions(int question) {
        return trueOptionList.get(question-1);
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
    
//    // by connecting to database
//    // create a method to create questionList
//    private static ArrayList<String> getQuestionArrayList() {
//        ArrayList<String> newArray = new ArrayList<>();
//        for (int i = 1; i <= 10; i++) {
//            newArray.add(Utilities.getTrivia(i)[0]);
//        }
//        return newArray;
//    }
//    // create a method to create optionsList
//    private static ArrayList<String> getOptionsArrayList() {
//        ArrayList<String> newArray = new ArrayList<>();
//        for (int i = 1; i <= 10; i++) {
//            newArray.add(Utilities.getTrivia(i)[1]);
//        }
//        return newArray;
//    }
//    // create a method to create answerList
//    private static ArrayList<String> getAnswerArrayList() {
//        ArrayList<String> newArray = new ArrayList<>();
//        for (int i = 1; i <= 10; i++) {
//            newArray.add(Utilities.getTrivia(i)[2]);
//        }
//        return newArray;
//    }
//    
    // create a method to read file as list by using TriviaSample.txt file
    public static ArrayList<String> readFileInArrayList(String filepath) {
        List<String> fileList = new ArrayList<>();
        try {
            fileList = Files.readAllLines(Paths.get(filepath), StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println("No such file directory. Question cannot be obtained");
        }
        return (ArrayList<String>)fileList;
    }
    
    // create a method to create questionList/answerList/optionsList
    public static ArrayList<String> getArrayList(ArrayList<String> originalArrayList, int multipleOfLine) {
        ArrayList<String> newArray = new ArrayList<>();
        for (int i = 0; i < originalArrayList.size(); i++) {
            if ((i-multipleOfLine)%3 == 0) {
                newArray.add(originalArrayList.get(i));
            }
        }
        return newArray;
    }
    // create a method to create questionList
    private static ArrayList<String> getQuestionArrayList() {
        ArrayList<String> newArray = getArrayList(l1, 3);
        return newArray;
    }
    // create a method to create optionsList
    private static ArrayList<String> getOptionsArrayList() {
        ArrayList<String> newArray = getArrayList(l1, 1);
        return newArray;
    }
    // create a method to create answerList
    private static ArrayList<String> getAnswerArrayList() {
        ArrayList<String> newArray = getArrayList(l1, 2);
        return newArray;
    }
}