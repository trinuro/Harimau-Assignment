

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class store_donation {
    
    public static double getMerchandisePoint(String userName, int id, int amount, String address){
    //this method is used to get the new point when user check out to buy merchandise
        
        //example of prize of merchanidise
        double [] prize=new double [3];
        prize[0]=100;
        prize[1]=200;
        prize[2]=80;
        
        String [] prizeName=new String [3];
        prizeName[0]="canvas bag";
        prizeName[1]="bottle";
        prizeName[2]="badge";
              
        //declare checkOut;
        double points= Double.parseDouble(login.getUserData(userName, "current_points"));
        double  pointUsed=prize[id]*amount;    
            //check out
            if(points>=pointUsed)
            {
                //update new point             
                login.increasePoints(userName, pointUsed*-1);
                
                //update purchase history in database
                Utilities.buyMerch(userName, prizeName[id], amount, address);
                
                //update purchase history in txt file
                try (PrintWriter writer = new PrintWriter(new FileOutputStream("MerchandiseOrder.txt",true))) {
                    writer.println(userName+" orders "+amount+" "+prizeName[id]+" to "+address);
                    }
                catch (IOException ex) {
                    System.out.println("Problems with file output");
                }
            }
            else
                System.out.println("Too poor, sorry");
        
        // return point
        return Double.parseDouble(login.getUserData(userName, "current_points"));        
    }
    
    public static double getPlantATreePoint(String userName, String nameTree){
        //example of prize of tree
        double prizeTree=10.0;
        
        //get current point from user;
        double points= Double.parseDouble(login.getUserData(userName, "current_points"));
        double  pointUsed=prizeTree;
            
            //check out
            if(points>=pointUsed)
            {
                //update new point             
                login.increasePoints(userName, pointUsed*-1);
                
                //update purchase history in database
                Utilities.plantNewTree(userName, nameTree);
                
                //update purchase history in txt file
                
                try (PrintWriter writer = new PrintWriter(new FileOutputStream("TreePlantOrder.txt",true))) {
                    writer.write(userName+" plant a tree with the name \""+nameTree+"\"");                
                } catch (IOException ex) {
                    System.out.println("Problems with file output");
                }
            }
            else
                System.out.println("Too poor, sorry");
            
         // return point
        return Double.parseDouble(login.getUserData(userName, "current_points")); 
    }
    
    public static double getDonationPoint(String userName, double donation, String NGO){
        
        //calculate the point will get
        double  pointGiven=donation*10.0; 
        
        //update new point             
        login.increasePoints(userName, pointGiven);
            
        //donation to NGO 
        double donationToNGO=(donation*0.9);
        
        Utilities.makeNewDonations(userName, donationToNGO, NGO);
       
        //update donation history in txt file
        try (PrintWriter writer = new PrintWriter(new FileOutputStream("Donations.txt",true))) {
            writer.write(userName+" has donated $ "+donationToNGO+" to "+NGO);
        } catch (IOException ex) {
            System.out.println("Problems with file output");
        }
        
        // return point
        return Double.parseDouble(login.getUserData(userName, "current_points"));   
    }
}
