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
    private static final ArrayList<news> newsArrayList = createNewsArrayList();
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
    
    
    //***********************************************************************
    // ********************START FROM HERE***********************************
    
    public static String getSpecificDate (int noOFNews) {
        return newsArrayList.get(noOFNews).returnSpecificDate();
    }
    public static String getSpecificTitle (int noOFNews) {
        return newsArrayList.get(noOFNews).returnSpecificTitle();
    }
    public static String getSpecificURL (int noOFNews) {
        return newsArrayList.get(noOFNews).returnSpecificURL();
    }
    
    // ************************************Until here*****************************************
    //**************************************************************************************
    

    
    public static void main(String[] args) {
        //SEE THE DEMO HERE
        for (int i = 0; i < newsArrayList.size(); i++) {
            System.out.println(getSpecificTitle(i));
            System.out.println(getSpecificURL(i));
            System.out.println(getSpecificDate(i));
        }
    }
    
    // by connecting to database
    public static ArrayList<news> createNewsArrayList(){
        // create arraylist that will be storing the news with only contain keyword "nature" in the tilte
        ArrayList<news> newsArray = new ArrayList<>();
        // create arraylist for each title, date, url
        ArrayList<String> titleList = new ArrayList<>();
        ArrayList<String> urlList = new ArrayList<>();
        ArrayList<String> dateList = new ArrayList<>();

        
        for (int i = 1; i <= 10; i++) {
            String[] title = Utilities.getNews(i)[0].split(" ");
            boolean hasNatureKeyword = false;
            
            // check if the titie contains keyword "nature"
            for (int j = 0; j < title.length; j++) {
                hasNatureKeyword = false;
                if (title[j].equalsIgnoreCase("nature")) {
                    hasNatureKeyword = true; break;
                }
            }
            
            // add the news with keyword "nature" in the title
            if (hasNatureKeyword) {
                titleList.add(Utilities.getNews(i)[0]);
                urlList.add(Utilities.getNews(i)[1]);
                dateList.add(Utilities.getNews(i)[2]);
            }
        }
        
        // add the news with keyword "nature" in the titile into news arrayList
        for (int i = 0; i < titleList.size(); i++) {
            news news = new news(titleList.get(i), urlList.get(i), dateList.get(i));
            newsArray.add(news);
        }
        
        // sort the ArrayList of News according to their specificDate, from the latest to the oldest news
        Collections.sort(newsArray, Collections.reverseOrder());
        
        return newsArray;
    }
    
    
//    //by using NewSample.txt
//    public static ArrayList<news> createNewsArrayList(){
//        ArrayList<news> newsArray = new ArrayList<>();
//        // declare filepath
//        String filepath = "src/main/resources/NewSample.txt";
//        // convert the file into arrrayList
//        ArrayList<String> l1 = readFileInArrayList(filepath);
//        // create arraylist for each title, date, url
//        ArrayList<String> titleList = getArrayList(l1, 3);
//        ArrayList<String> urlList = getArrayList(l1, 1);
//        ArrayList<String> dateList = getArrayList(l1, 2);
//
//        
//        for (int i = 0; i < titleList.size(); i++) {
//            String[] title = titleList.get(i).split(" ");
//            boolean hasNatureKeyword = false;
//            
//            // check if the titie contains keyword "nature"
//            for (int j = 0; j < title.length; j++) {
//                hasNatureKeyword = false;
//                if (title[j].equalsIgnoreCase("nature")) {
//                    hasNatureKeyword = true; break;
//                }
//            }
//            
//            // remove the news without keyword "nature"
//            if (!hasNatureKeyword) {
//                titleList.remove(titleList.get(i));
//                urlList.remove(urlList.get(i));
//                dateList.remove(dateList.get(i));
//                i--;
//            }
//        }
//        
//        // add the news with keyword "nature" in the titile into news arrayList
//        for (int i = 0; i < titleList.size(); i++) {
//            news news = new news(titleList.get(i), urlList.get(i), dateList.get(i));
//            newsArray.add(news);
//        }
//        
//        // sort the ArrayList of News according to their specificDate, from the latest to the oldest news
//        Collections.sort(newsArray, Collections.reverseOrder());
//        
//        return newsArray;
//    }
//    
//    
//    // create a method to read file as list
//    public static ArrayList<String> readFileInArrayList(String filepath) {
//        List<String> fileList = new ArrayList<>();
//        try {
//            fileList = Files.readAllLines(Paths.get(filepath), StandardCharsets.UTF_8);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return (ArrayList<String>)fileList;
//    }
//    
//    
//    // create a method to create titleList/urlList/dateList based on their number of line
//    public static ArrayList<String> getArrayList(ArrayList<String> originalArrayList, int multipleOfLine) {
//        ArrayList<String> newArray = new ArrayList<>();
//        for (int i = 0; i < originalArrayList.size(); i++) {
//            if ((i-multipleOfLine)%3 == 0) {
//                newArray.add(originalArrayList.get(i));
//            }
//        }
//        return newArray;
//    }
}
