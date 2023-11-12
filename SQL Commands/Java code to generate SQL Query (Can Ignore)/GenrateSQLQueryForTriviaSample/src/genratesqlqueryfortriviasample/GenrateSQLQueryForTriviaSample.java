/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package genratesqlqueryfortriviasample;

/**
 *
 * @author Khiew
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GenrateSQLQueryForTriviaSample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            // Initialise variables
            int count = 0;
            java.util.ArrayList<String> questions = new java.util.ArrayList<String>();
            java.util.ArrayList<String> options = new java.util.ArrayList<String>();
            java.util.ArrayList<String> answers = new java.util.ArrayList<String>();
            
            
            // Make a reader object
            BufferedReader reader = new BufferedReader(new FileReader("TriviaSample.txt"));
            String line;

            // Iterate through each line
            while((line=reader.readLine())!=null){
                // Seperate each lines by contents
                switch(count){
                    case 0:
                        questions.add(line);
                        count++;
                        break;
                    case 1:
                        options.add(line);
                        count++;
                        break;
                    case 2:
                        answers.add(line);
                        count = 0;
                        break;
                        
                }
            }
                System.out.println("Hi");
                // close reader object
                reader.close();
                
                //generate sql query
                for(int i = 0; i<questions.size();i++){
                    System.out.printf("INSERT INTO TriviaSample(question, options, answer) VALUES(\"%s\",\"%s\",\"%s\");",questions.get(i), options.get(i), answers.get(i));
                    System.out.println("");
                }   

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
