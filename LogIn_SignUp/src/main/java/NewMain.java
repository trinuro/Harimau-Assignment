/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author user
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        signup.createNewUser("122", "hzw", "122", "122");
        login.increasePoints("hzw", 5000);
        System.out.println(Utilities.getMerchandiseData("hzw"));
        //System.out.println(news.getSpecificURL(0));
//        Utilities.getNews();
//        System.out.println(news.getSpecificDate());
//        System.out.println(dailyTrivia.getQuestionArrayList());
        dailyTrivia trivial2 = new dailyTrivia("hzw");
        System.out.println(trivial2.getOptions(1));
        System.out.println(trivial2.title(1));
        
        signup.createNewUser("weiwei", "ziwei", "145", "145");
        login.increasePoints("ziwei", 5000);
        
        //ExistingUser user = new ExistingUser("HamZW");
        ExistingUser user = new ExistingUser("ZW","ww@gmail.com");
    }
    
}
