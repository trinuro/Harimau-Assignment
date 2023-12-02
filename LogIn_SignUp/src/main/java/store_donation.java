
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class store_donation {
    
    public static void getMerchandise(double point){
        Scanner s=new Scanner(System.in);
        
        //example of prize of merchanidise
        double [] prize=new double [3];
        prize[0]=100;
        prize[1]=150;
        prize[2]=50;
              
        //declare checkOut;
        int checkOut;
        
        //do-while loop for merchandise
        do
        {
            //enter id of merchandise
            System.out.println("Enter merchandise_id: ");
            int id=s.nextInt();
            
            //enter amount of the merchandise picked
            System.out.println("Enter amount:");
            int amount =s.nextInt();
            
            //to store useless space
            s.nextLine();
            
            // User address
            System.out.println("Enter address:");
            String address=s.nextLine(); 
            
            //Confirmation of check out
            System.out.println("Do you want to check out(yes(1),no(0),exit(-1)):");
            checkOut =s.nextInt();
            
            //check out
            if(checkOut==1)
            {
                //save to point database && merchandise history
                point=point-prize[id]*amount;
            }
            
            //not checking out, return to enter merchandise id
            else if(checkOut==0)
            {
                System.out.println();
            }
            
            //exit, return to home page
            else if (checkOut==-1)
            {
                break;
            }            
            else
                System.out.println("error");
            }while (checkOut!=1);
        
        // print point
        System.out.println("New Point: "+point);
             
        //history (need to connect to databse)
        System.out.println("Do you want to show payment history for merchandise: (yes(1)/no(2))");
        int history=s.nextInt();
        
        if(history==1)
        {
            //show history of merchandise
            System.out.println("History of merchandise");
        }
    }
    
    public static void getPlantATree(double point){
        Scanner s=new Scanner(System.in);
        
        //example of prize of tree
        double prizeTree=10;
        
        //declare checkOut;
        int checkOut;
        
        //do-while loop for plant a tree
        do{
            // User input tree name
            System.out.println("Enter the name of tree: ");
            String name=s.nextLine();
            
            //Confirmation of check out
            System.out.println("Do you want to check out(yes(1),no(0),exit(-1)):");
            checkOut =s.nextInt();
            
            //check out
            if(checkOut==1)
            {
                //save to point database && plant a tree history
                point=point-prizeTree;
            }
            //not checking out, return to enter tree name
            else if(checkOut==0)
            {
                System.out.println();
            }
            
            //exit, return to home page
            else if (checkOut==-1)
            {
                break;
            }            
            else
                System.out.println("error");
            }while (checkOut!=1);
        
        // print point
        System.out.println("New Point: "+point);
        
        //history (need to connect to databse)
        System.out.println("Do you want to show payment history for plant a tree: (yes(1)/no(2))");
        int history=s.nextInt();
        
        if(history==1)
        {
            //show database of history
            System.out.println("History of plant a tree");
        }
        
        
    }
    
    public static void getDonation(double point, String userName){
        Scanner s=new Scanner(System.in);
        
         //declare checkOut;
        int checkOut;
        
        //do-while loop for donation
        do
        {
            //user input amount of donation($)
            System.out.println("Enter donation ($)");
            double donation=s.nextInt();
            
            //store useless space
            s.nextLine();
            
            //user input NGO
            System.out.println("Enter NGO:");
            String NGO =s.nextLine();
            
            //Confirmation of check out
            System.out.println("Do you want to check out(yes(1),no(0),exit(-1)):");
            checkOut =s.nextInt();
            
            //check out  
            if(checkOut==1)
            {
                double donationToNGO=donation*0.9;
                point=point+donation*10;
                //save to donation database
                System.out.println(userName+" has donated $ "+donationToNGO+" to "+NGO);
            }
            
            //not checking out, return to enter donation
            else if(checkOut==0)
            {
                System.out.println();
            }
            
            //exit, return to home page
            else if (checkOut==-1)
            {
                break;
            }            
            else
                System.out.println("error");
            }while (checkOut!=1);
        
        // print point
        System.out.println("New Point: "+point);
        
        //history (need to connect to databse)
        System.out.println("Do you want to show donation history: (yes(1)/no(2))");
        int history=s.nextInt();
        
        if(history==1)
        {
            //show database of donation
            System.out.println("History of donation");
        }
    }
}
