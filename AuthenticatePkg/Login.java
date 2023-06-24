package AuthenticatePkg;
import java.io.*;
import java.util.Scanner;

import CustomerPkg.Customer;
import CustomerPkg.CustomerDatabase;
import DesignPkg.Design;
public class Login {

   public Customer applyLoginCondition()
    {
      Design design = new Design();
      Scanner scan =  new Scanner(System.in);
      design.applyBlue("Enter user name :");
      design.fillPurple();
      String username = scan.nextLine();
      design.resetColor();
      design.applyBlue("Enter password :");
      design.fillPurple();
      String password = scan.nextLine();
      design.resetColor();
      CustomerDatabase customerDatabase = new CustomerDatabase();
      Customer customer = customerDatabase.findByNameAndPass(username,password);
         if(customer!=null){
            return customer;
         } 
         return null;
    }
    public static void main(String[] args) {
        
    }
}
