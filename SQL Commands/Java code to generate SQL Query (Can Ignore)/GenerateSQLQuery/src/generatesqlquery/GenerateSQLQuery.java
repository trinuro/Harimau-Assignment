/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package generatesqlquery;

/**
 *
 * @author Khiew
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GenerateSQLQuery {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            
            // Initialise counter
            int counter=0;
            java.util.ArrayList<String> titles = new java.util.ArrayList<String>();
            java.util.ArrayList<String> newsLinks = new java.util.ArrayList<String>();
            java.util.ArrayList<String> newsDates = new java.util.ArrayList<String>();
            java.util.ArrayList<String> newsCleanedDates = new java.util.ArrayList<String>();
            
            // Open NewSample.txt and palce it in an object
            BufferedReader reader = new BufferedReader(new FileReader("NewSample.txt"));
            // Read each line
            String line;
            while((line=reader.readLine())!=null){
                // Seperate each line of the text file into titles, links and dates
                switch(counter){
                    case 0:
                        titles.add(line);
                        counter++;
                        break;
                    case 1:
                        newsLinks.add(line);
                        counter++;
                        break;
                    case 2:
                        newsDates.add(line);
                        counter = 0;
                        break;
                }
                
            }
            // Close the file
            reader.close();
            
            
            String month = "";
           
            
            for(int i=0; i<newsDates.size();i++){
                String[] data = newsDates.get(i).split(" ");
                String temp = data[1];
                switch(temp){
                    
                    case "Jan":
                        month = "01";
                        break;
                    case "Feb":
                        month = "02";
                        break;
                    case "Mar":
                        month = "03";
                        break;
                    case "April":
                        month = "04";
                        break;
                    case "May":
                        month = "05";
                        break;
                    case "Jun":
                        month = "06";
                        break;
                    case "Jul":
                        month = "07";
                        break;
                    case "Aug":
                        month = "08";
                        break;
                    case "Sep":
                        month = "09";
                        break;
                    case "Oct":
                        month = "10";
                        break;
                    case "Nov":
                        month = "11";
                        break;
                    case "Dec":
                        month = "12";
                        break;
                    
                }
                temp = data[2]+"-"+month+"-"+data[0];
                newsCleanedDates.add(temp);
            }
            
            // Generate SQL Input Command
            // newsDates.get(i).replace(' ','-') means get the ith element of newsDates and replace space with '-'
            for(int i = 0; i<titles.size();i++){
                System.out.printf("INSERT INTO NewsSample(news_title, news_link, news_date) VALUES(\"%s\", \"%s\", \"%s\");\n",titles.get(i),newsLinks.get(i),newsCleanedDates.get(i));
            }
        }catch(IOException e){
            // Catch IO Exception
            e.printStackTrace();
        }
        
        
    }
    
}
