import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.text.SimpleDateFormat;
import java.util.*;

public class news implements Comparable<news>{
    private String specificDate;
    private String specificTitle;
    private String specificURL;
    private Date holdDate;
    private static ArrayList<news> newsArrayList = new ArrayList<>();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
    
    public news(String specifictTitle, String specificURL, String specificDate) {
        this.specificTitle = specifictTitle;
        this.specificURL = specificURL;
        this.specificDate = specificDate;
        try {
            this.holdDate = simpleDateFormat.parse(specificDate);
        } catch (Exception e) {
            System.out.println("Invalid date");
        }
        
    }
    
    @Override
    public int compareTo(news news){
        return getSpecificHoldDate().compareTo(news.getSpecificHoldDate());
    }
    
    // get method for each data field
    public Date getSpecificHoldDate () {
        return holdDate;
    }
    public String returnSpecificDate () {
        return specificDate;
    }
    public String returnSpecificTitle () {
        return specificTitle;
    }
    public String returnSpecificURL () {
        return specificURL;
    }
    //WHAT CAN BE USED
    public static String getSpecificDate (int noOFNews) {
        return newsArrayList.get(noOFNews).returnSpecificDate();
    }
    public static String getSpecificTitle (int noOFNews) {
        return newsArrayList.get(noOFNews).returnSpecificTitle();
    }
    public static String getSpecificURL (int noOFNews) {
        return newsArrayList.get(noOFNews).returnSpecificURL();
    }
    //UNTIL HERE (JUST THESE 3 METHOD)
    
    // det method for each data field except holdDate as holdDate is depending the specificDate
    public void setSpecificDate (String specificDate) {
       this.specificDate = specificDate;
    }
    public void setSpecificTitle (String specificTitle) {
       this.specificTitle = specificTitle;
    }
    public void setSpecificURL (String specificURL) {
        try {
            this.holdDate = simpleDateFormat.parse(specificDate);
        } catch (Exception e) {
            System.out.println("Invalid date");
        }
       this.specificURL = specificURL;
    }
    
    public static void main(String[] args){
        // declare filepath
        System.out.println("curretn : " + System.getProperty("user.dir"));
//        String filepath = "C:\\Users\\PC\\Documents\\NetBeansProjects\\harimau_newsTrial\\src\\main\\java\\com\\mycompany\\harimau_newstrial\\NewsSample.txt";
        String filepath = "NewSample.txt";
        
        // convert the file into arrrayList
        ArrayList<String> l1 = readFileInArrayList(filepath);
        
        // create arraylist for each title, date, url
        ArrayList<String> titleList = getArrayList(l1, 3);
        ArrayList<String> urlList = getArrayList(l1, 1);
        ArrayList<String> dateList = getArrayList(l1, 2);

        
        for (int i = 0; i < titleList.size(); i++) {
            String[] title = titleList.get(i).split(" ");
            boolean hasNatureKeyword = false;
            for (int j = 0; j < title.length; j++) {
                hasNatureKeyword = false;
                if (title[j].equalsIgnoreCase("nature")) {
                    hasNatureKeyword = true; break;
                }
            }
            if (!hasNatureKeyword) {
                titleList.remove(titleList.get(i));
                urlList.remove(urlList.get(i));
                dateList.remove(dateList.get(i));
                i--;
            }
        }
        
        for (int i = 0; i < titleList.size(); i++) {
            news news = new news(titleList.get(i), urlList.get(i), dateList.get(i));
            newsArrayList.add(news);
        }
        
        // sort the ArrayList of News according to their specificDate
        Collections.sort(newsArrayList, Collections.reverseOrder());
        
        //SEE THE DEMO HERE
        for (int i = 0; i < newsArrayList.size(); i++) {
            System.out.println(getSpecificTitle(i));
            System.out.println(getSpecificURL(i));
            System.out.println(getSpecificDate(i));
        }
        
        
    }
    
    
    // create a method to read file as list
    public static ArrayList<String> readFileInArrayList(String filepath) {
        List<String> fileList = new ArrayList<>();
        try {
            fileList = Files.readAllLines(Paths.get(filepath), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
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
   
}