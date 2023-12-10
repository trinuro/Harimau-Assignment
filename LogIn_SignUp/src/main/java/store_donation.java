
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class store_donation {
    
    public static int getMerchandisePoint(String userName, int id, int amount, String address){
    //this method is used to get the new point when user check out to buy merchandise
        
        //example of prize of merchanidise
        int [] prize=new int [3];
        prize[0]=100;
        prize[1]=150;
        prize[2]=50;
              
        //declare checkOut;
        int points= Integer.parseInt(login.getUserData(userName, "current_points"));
        int  pointUsed=prize[id]*amount;    
            //check out
            if(points>=pointUsed)
            {
                //update new point             
                login.increasePoints(userName, pointUsed*-1);
                
                //update purchase history in database
                Utilities.buyMerch(userName, Integer.toString(id), Integer.toString(amount), address);
                
                //update purchase history in txt file
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("MerchandiseOrder.txt",true));
                    writer.write(userName+" orders "+amount+" merch-"+id+" to "+address);
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(store_donation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
                System.out.println("Too poor, sorry");
        
        // return point
        return Integer.parseInt(login.getUserData(userName, "current_points"));        
    }
    
    public static void getPlantATree(double point, String userName){
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
                System.out.println(userName+" plant a tree with the name \""+name+"\"");
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("TreePlantOrder.txt",true));
                    writer.write(userName+" plant a tree with the name \""+name+"\"");
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(store_donation.class.getName()).log(Level.SEVERE, null, ex);
                }
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
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("Donations.txt",true));
                    writer.write(userName+" has donated $ "+donationToNGO+" to "+NGO);
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(store_donation.class.getName()).log(Level.SEVERE, null, ex);
                }
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
