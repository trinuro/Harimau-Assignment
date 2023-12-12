/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.Scanner;
public class gui {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        signup.createNewUser("weiwei20110016@gmail.com", "HZW", "123456789", "123456789");
        // Send recovery email to user
        login.sendRecoveryEmail("weiwei20110016@gmail.com");
        // Receive recovery password from user
        System.out.println("Please enter your recovery password: ");
        Scanner scanObj = new Scanner(System.in);
        String userRecoveryPw = scanObj.nextLine();
        // Check if password is correct
        if(login.isRecoveryPasswordCorrect(userRecoveryPw)){
            System.out.println("User recovery successful");
            // If recovery password is correct, change user's password
            System.out.println("Please enter new password: ");
            String newPassword = scanObj.nextLine();
            System.out.println("Please confirm the password: ");
            String confirmPassword = scanObj.nextLine();
            String email = "weiwei20110016@gmail.com";
            if (login.updateUserPassword(email, newPassword, confirmPassword))
                System.out.println("Password updated");
        }else{
            System.out.println("Sorry, password is wrong. Please request a new one[Y/N]: ");
            if(scanObj.nextLine().equals("Y"))
                login.sendRecoveryEmail("weiwei20110016@gmail.com");
        }
        
        // User tries to login
        try{
            if(login.checkPassword("weiwei20110016@gmail.com", "HZW", "1234567890")){
                System.out.println("Success!");
            }
        }catch(Exception e){
            System.out.println(e);
    }
    }
    
}
