import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 *
 * @author limxinying
 */
public class dailyTrivia extends Trivia{
    private String username;
    private ArrayList<Trivia> questionSetCanBeAnswered = new ArrayList<>();
    private int noOfDayLogin;
    
    /**
     * constructor
     * @param username the username for this
     */
    public dailyTrivia(String username){
        this.username = username;
        this.noOfDayLogin = getDayLogin(username);
        this.questionSetCanBeAnswered = getQuestionSetCanBeAnswered();
    }
    
    /**
     * @param username the username for this
     * @return the number of days since user signed up
     */
    public int getDayLogin(String username) {
        return (int)login.daysAfterRegistration(username);
    }


    //***********************************
    // *******START FROM HERE************

    /**
     * @param question the number of question answering
     * @return the specific question based on the number of questions (from 1 to 10)
     */
    @Override
    public String getQuestion(int question) {
        return super.getQuestion(question);
    }
    
    /**
     * @param question the number of question answering
     * @return the string array of options based on the number of questions (from 1 to 10)
     */
    @Override
    public String[] getOptions(int question) {
        System.out.println("No of attempt for" + question +" = " + Utilities.getNumberOfTries(getUsername(), question));
        if (Utilities.getNumberOfTries(getUsername(), question) == 0) {
            System.out.println("No shuffle");
            String[] currentOptionList = super.getOriginalOptions(question);
            return currentOptionList;
        }
        System.out.println("shuffled");
        String[] currentOptionList = shuffledOptionsArray(super.getOptions(question));
        return currentOptionList;
    }
    
    /**
     * @param question the number of question answering
     * @return the answer based on the number of questions (from 1 to 10)
     */    
    @Override
    public String getAnswer(int question) {
        return super.getAnswer(question);
    }
    
    /**
     * @return the question set that can be answered of this according to user's number of day registered
     */
    public ArrayList<Trivia> getQuestionSetCanBeAnswered(){
        if (questionSetCanBeAnswered.size() <= noOfDayLogin) {
            int differenceOfDay = noOfDayLogin +1 - questionSetCanBeAnswered.size();
            for (int i = 0; i < differenceOfDay; i++) {
                if (questionSetCanBeAnswered.size() < 10) {
                    questionSetCanBeAnswered.add(new Trivia(questionSetCanBeAnswered.size()+1));
                }
            }
        }
        return questionSetCanBeAnswered;
    }
    
    /**
     * @param question the number of question answering
     * @return the number of attempt based on the specific number of questions (from 1 to 10)
     */
    public int gatNumberOfAttempt(int question){
        return Utilities.getNumberOfTries(getUsername(), question);
    }
    
    /**
     * @param question the number of question answering
     * @return marks value allocated for the given question (from 1 to 10)
     */
    public double getmarkAllocated(int question) {
        return markAllocated(question, gatNumberOfAttempt(question));
    }
    
    /**
     * @param question the number of question answering
     * @return the boolean value of the answer chosen currently
     */
    public boolean getIsCorrectAnswerCurrently(int question) {
        return Utilities.getIsCorrectCurrently(getUsername(), question);
    }
    
    /**
     * @param question the number of question answering
     * @return the boolean value of the answer chosen finally for the specific question
     */
    public boolean getIsCorrectAnswerFinally(int question) {
        return Utilities.getIsCorrectFinally(getUsername(), question);
    }
    
    /**
     * @param question the number of question answering
     * @return the the title for the specific question according to the number of attempts or user's answers
     */
    public String title(int question) {
        if (gatNumberOfAttempt(question) >= 2 || getIsCorrectAnswerFinally(question)) {
            return "Day " + question + " Trivia ( Attempt without marks increment )";
        }
        return "Day " + question + " Trivia ( Attempt #" + (gatNumberOfAttempt(question)+1) + " )";
    }
    
    /**
     * <p> has to be run to update isCorrect, numberOfAttempt and to increase user marks if any
     * @param question the number of question answering
     * @param selectedAnswer the answer selected by user
     */
    public void isCorrect(int question, String selectedAnswer) {
        System.out.println("no of qustion"+ question);
        System.out.println("ans "+getAnswer(question));
        System.out.println("selectedAnswer "+ selectedAnswer);
        System.out.println(selectedAnswer.equals(getAnswer(question)));
        updateNoOfAttempt(question, Utilities.getNumberOfTries(getUsername(), question), true);

        if (!getIsCorrectAnswerFinally(question)) {
            System.out.println("Wrong initially");
            Utilities.setIsCorrectCurrently(getUsername(), question, selectedAnswer.equals(getAnswer(question)));

            Utilities.setIsCorrectFinally(getUsername(), question,selectedAnswer.equals(getAnswer(question)));
            updateNoOfAttempt(question, Utilities.getNumberOfTries(getUsername(), question), selectedAnswer.equals(getAnswer(question)));
            login.increasePoints(username, getmarkAllocated(question));
        } else {
            Utilities.setIsCorrectCurrently(getUsername(), question, selectedAnswer.equals(getAnswer(question)));
            System.out.println("Thanks for trying again");
        }
    }
    
    /**
     * @return this username
     */
    public String getUsername() {
        return this.username;
    }
    
    // *************Until here**************
    //***********************************
   
    /**
     * <p> has to be run to update isCorrect, numberOfAttempt and to increase user marks if any
     * @param options the string array of the options
     * @return a shuffled string array of options
     */
    private static String[] shuffledOptionsArray(String[] options) {
        List<String> optionsList = Arrays.asList(options);
        Collections.shuffle(optionsList);
        return optionsList.toArray(options);
    }
    
    /**
     * <p> has to be run to update isCorrect, numberOfAttempt and to increase user marks if any
     * @param question the number of question answering
     * @param noOfAttempt the total number of attempts of the user for the specific question
     * @return the mark allocated to the user according the the number of attempts
     */
    private double markAllocated(int question, int noOfAttempt) {
        if(getIsCorrectAnswerFinally(question) && noOfAttempt == 0){
            return 2;
        } else if (getIsCorrectAnswerFinally(question) && noOfAttempt == 1){
            return 1;
        } return 0;
    }
    
    /**
     * <p> to update isCorrect, numberOfAttempt and to increase user marks if any
     * @param question the number of question answering
     * @param noOfAttempt the previous number of attempts of the user for the specific question
     * @param isCorrect the boolean value whether the user answered correctly
     */
    private void updateNoOfAttempt(int noOfQuestion, int noOfAttempt, boolean isCorrect) {
        if (!isCorrect) {
            Utilities.setNumberOfTries(getUsername(), noOfQuestion, noOfAttempt+1);
            System.out.println("the number of trial is updated");
        }
    }
}


// create a class for obtaining the daily trivia question
class Trivia {

//     // declare filepath
//    private static String filepath = "src/main/resources/TriviaSample.txt";
//    
//    private static final ArrayList<String> l1 = readFileInArrayList(filepath);// convert the file into arrrayList

    private static final ArrayList<String> questionList = getQuestionArrayList();// create ArraylLst for questions
    private static final ArrayList<String> answerList = getAnswerArrayList();// create Arraylist for  answer
    private static final ArrayList<String> optionList = getOptionsArrayList();
    private static final ArrayList<String[]> trueOptionList =createTrueOptionList();
    private static final ArrayList<Trivia> totalQuestionSet = createTotalQuestionSet();
    private  String specificQuestion = "";
    private  String[] specificOptions = new String[4];
    private  String specificAnswer = "";
    
    /**
     * a no-arg constructor
     */     
    public Trivia() {
    }
    
    /**
     * a constructor
     * @param question the number of question answering
     */     
    public Trivia(int question){
        this.specificQuestion = questionList.get(question-1);
        this.specificOptions = trueOptionList.get(question-1);
        this.specificAnswer = answerList.get(question-1);
    }
    
    /**
     * a constructor
     * @param question the number of question answering
     * @param options the string array that consist of four options for the specific question
     * @param answer the answer for the specific question
     */
    public Trivia(String question, String[] options, String answer){
        this.specificQuestion = question;
        this.specificOptions = options;
        this.specificAnswer = answer;
    }
    
    private static ArrayList<Trivia> createTotalQuestionSet() {
        ArrayList<Trivia> totalquestionset = new ArrayList<>();
        for (int i = 0; i < questionList.size(); i++) {
            Trivia trivias = new Trivia(questionList.get(i), trueOptionList.get(i).clone(), answerList.get(i));
            totalquestionset.add(trivias);
        }
        return totalquestionset;
    }

    private static ArrayList<String[]> createTrueOptionList() {
        ArrayList<String[]> trueoptionList = new ArrayList<>();
        for (int noOfQuestion = 0; noOfQuestion < optionList.size(); noOfQuestion++) {
            String[] optionArray = optionList.get(noOfQuestion).split(",");
            trueoptionList.add(optionArray);
        }
        return trueoptionList;
    }
    
    /**
     * @param question the number of question answering
     * @return the specific question based on the number of questions (from 1 to 10)
     */
    public String getQuestion(int question) {
        return totalQuestionSet.get(question-1).specificQuestion;
    }
    
    /**
     * @param question the number of question answering
     * @return the string array of options based on the number of questions (from 1 to 10)
     */
    public String[] getOptions(int question) {
        return totalQuestionSet.get(question-1).specificOptions;
    }
    
    /**
     * @param question the number of question answering
     * @return the string array of options based on the number of questions (from 1 to 10) with original sequence
     */
    public String[] getOriginalOptions(int question) {
        return trueOptionList.get(question-1);
    }
    
    /**
     * @param question the number of question answering
     * @return the answer based on the number of questions (from 1 to 10)
     */  
    public String getAnswer(int question) {
        return totalQuestionSet.get(question-1).specificAnswer;
    }

    /**
     * @return the questionList for all questions (from 1 to 10) from database
     */  
    public static ArrayList<String> getQuestionArrayList() {

        ArrayList<String> newArray = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            newArray.add(Utilities.getTrivia(i)[0]);
        }
        return newArray;
    }

    /**
     * @return the optionsList for all questions (from 1 to 10) from database
     */  
    public static ArrayList<String> getOptionsArrayList() {
        ArrayList<String> newArray = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            newArray.add(Utilities.getTrivia(i)[1]);
        }

        return newArray;
    }
    
    /**
     * @return the answerList for all questions (from 1 to 10) from database
     */  
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