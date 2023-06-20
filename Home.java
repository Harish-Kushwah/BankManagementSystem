import java.io.*;
import java.util.*;

import AccountPkg.ManageAccount;
import CustomerPkg.Customer;
import CustomerPkg.ManageCustomer;
import DesignPkg.Design;

public class Home {
    

   static void homeMenu()
    {
        Design design = new Design();
        design.fillCyan();
        System.out.println("1.Enter if you are customer");
        System.out.println("2.Enter if you are Account manager");
        System.out.println("3.Enter if you are Customer manager");
        System.out.println("4.Enter if you are bank manager");
        System.out.println("5.Enter if you are Employee");
        System.out.println("6.ENter for bank information");
        System.out.println("0.Exit");
        design.resetColor();
    }

    static int inputKey()
    {
         Scanner scan = new Scanner(System.in);
         Design design = new Design();
         design.applyPurple("Enter key ");
         design.applyGreen("<homepage> :");
         design.fillYellow();
         int key = scan.nextInt();
         design.resetColor();
         return key;
    }
    public static void main(String[] args) {
        
       
        Design design = new Design();
        design.homeSection();
        homeMenu(); 
        int key=-1;      
        while(true)
        {
            // design.fillPurple();
            // System.out.print("Enter key :");
            // design.resetColor();
            boolean exceptionCaught = false;
            try{ 
              key = inputKey();
            }
            catch( InputMismatchException e)
            {
               design.applyRed("Enter valid input\n");
                exceptionCaught = true;
               
            }
         
          
            if(key == 1)
            {
                design.customerSectionHeader();
                Customer customer = new Customer();
                customer.customerOperation();
            }
            else if(key == 2)
            {
                design.adminAccSectionHeader();
                ManageAccount manageAccount = new ManageAccount();
                manageAccount.manage();
            }
            else if(key == 3)
            {
                design.adminCustSectionHeader();
                ManageCustomer manageCustomer = new ManageCustomer();
                manageCustomer.manage();
            }
            else if(key==4)
            {
                
            }
            else if(key==5)
            {
                
            }
            else if(key==6)
            {
                
            }
            else if(key==0)
            {
                System.out.println("Successfully Exited from system.");
                break;
            }
            else {
                if(!exceptionCaught)
                System.out.println("Enter valid case.");
             }
            
            
            
        }
    }
}
