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
        
    }
    
}
