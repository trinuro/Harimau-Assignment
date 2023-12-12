
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
    
    public static double getMerchandisePoint(String userName, int id, int amount, String address){
    //this method is used to get the new point when user check out to buy merchandise
        
        //example of prize of merchanidise
        double [] prize=new double [3];
        prize[0]=100;
        prize[1]=150;
        prize[2]=50;
              
        //declare checkOut;
        double points= Double.parseDouble(login.getUserData(userName, "current_points"));
        double  pointUsed=prize[id]*amount;    
            //check out
            if(points>=pointUsed)
            {
                //update new point             
                login.increasePoints(userName, pointUsed*-1);
                
                //update purchase history in database
                Utilities.buyMerch(userName, Integer.toString(id), amount, address);
                
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
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("TreePlantOrder.txt",true));
                    writer.write(userName+" plant a tree with the name \""+nameTree+"\"");
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(store_donation.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Donations.txt",true));
            writer.write(userName+" has donated $ "+donationToNGO+" to "+NGO);
            writer.close();
            } catch (IOException ex) {
                Logger.getLogger(store_donation.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        // return point
        return Double.parseDouble(login.getUserData(userName, "current_points"));   
    }
}
