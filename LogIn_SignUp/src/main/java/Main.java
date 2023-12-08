
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class Main {
    public static void main(String[] args) {       
        Scanner s= new Scanner(System.in);
        
        int quit=1;
        do{
        System.out.println("Enter selection(Store/Donation): ");
        String selection=s.next();
        double point=0;
        String userName="LYW";
        s.nextLine();

        
        if (selection.equalsIgnoreCase("Store"))
        {
            System.out.println("Enter selection(Merchandise/Plant a tree): ");
            String selection2=s.nextLine();
            if (selection2.equalsIgnoreCase("Merchandise"))
            {
                store_donation.getMerchandise(point,userName); 
                System.out.println("Do you want to quit(yes(-1)/no(1)):");
                quit=s.nextInt();                
            }
            else if (selection2.equalsIgnoreCase("Plant a tree"))
            {
                store_donation.getPlantATree(point,userName);
                System.out.println("Do you want to quit(yes(-1)/no(1)):");
                quit=s.nextInt(); 
            }
        }
        else if (selection.equals("Donation"))
        {
            store_donation.getDonation(point,userName);
            System.out.println("Do you want to quit(yes(-1)/no(1)):");
            quit=s.nextInt(); 
        }
            
        }while(quit!=-1);
    }
    
  
}
