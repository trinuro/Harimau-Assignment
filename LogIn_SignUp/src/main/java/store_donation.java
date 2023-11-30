
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
                getMerchandise(point); 
                System.out.println("Do you want to quit(yes(-1)/no(1)):");
                quit=s.nextInt();                
            }
            else if (selection2.equalsIgnoreCase("Plant a tree"))
            {
                getPlantATree(point);
                System.out.println("Do you want to quit(yes(-1)/no(1)):");
                quit=s.nextInt(); 
            }
        }
        else if (selection.equals("Donation"))
        {
            getDonation(point,userName);
            System.out.println("Do you want to quit(yes(-1)/no(1)):");
            quit=s.nextInt(); 
        }
            
        }while(quit!=-1);
    }
    
    public static void getMerchandise(double point){
        Scanner s=new Scanner(System.in);
        double [] prize=new double [3];
        prize[0]=100;
        prize[1]=150;
        prize[2]=50;
       
        int checkOut;
        
        do
        {
            System.out.println("Enter merchandise_id: ");
            int id=s.nextInt();
            System.out.println("Enter amount:");
            int amount =s.nextInt();
            s.nextLine();
            System.out.println("Enter address:");
            String address=s.nextLine(); 
            System.out.println("Do you want to check out(yes(1),no(0),exit(-1)):");
            checkOut =s.nextInt();
            if(checkOut==1)
            {
                //save to point database && merchandise history
                point=point-prize[id]*amount;
            }
            else if(checkOut==0)
            {
                System.out.println();
            }
            else if (checkOut==-1)
            {
                break;
            }            
            else
                System.out.println("error");
            }while (checkOut!=1);
                System.out.println("New Point: "+point);
                System.out.println("Do you want to show payment history for merchandise: (yes(1)/no(2))");
                int history=s.nextInt();
                if(history==1)
                {
                    //show history of merchandise
                    System.out.println("History of merchandise");
                }
    }
    
    public static void getPlantATree(double point){
        double prizeTree=10;
        Scanner s=new Scanner(System.in);
        int checkOut;
        do{
            System.out.println("Enter the name of tree: ");
            String name=s.nextLine();
            System.out.println("Do you want to check out(yes(1),no(0),exit(-1)):");
            checkOut =s.nextInt();
            if(checkOut==1)
            {
                //save to point database && plant a tree history
                point=point-prizeTree;
            }
            else if(checkOut==0)
            {
                System.out.println();
            }
            else if (checkOut==-1)
            {
                break;
            }            
            else
                System.out.println("error");
            }while (checkOut!=1);
                System.out.println("New Point: "+point);
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
        int checkOut;
        do
        {
            System.out.println("Enter donation ");
            double donation=s.nextInt();
            s.nextLine();
            System.out.println("Enter NGO:");
            String NGO =s.nextLine();
 
            System.out.println("Do you want to check out(yes(1),no(0),exit(-1)):");
            checkOut =s.nextInt();
            if(checkOut==1)
            {
                double donationToNGO=donation*0.9;
                point=point+donation*10;
                //save to donation database
                System.out.println(userName+" has donated $ "+donationToNGO+" to "+NGO);
            }
            else if(checkOut==0)
            {
                System.out.println();
            }
            else if (checkOut==-1)
            {
                break;
            }            
            else
                System.out.println("error");
            }while (checkOut!=1);
        System.out.println("New Point: "+point);
        System.out.println("Do you want to show donation history: (yes(1)/no(2))");
        int history=s.nextInt();
        if(history==1)
        {
            //show database of donation
            System.out.println("History of donation");
        }
    }
}
