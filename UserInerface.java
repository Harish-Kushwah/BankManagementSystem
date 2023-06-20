import java.util.Scanner;

import AccountPkg.*;
import CustomerPkg.*;
public class UserInerface {
    
    static void menu()
    {
        System.out.println("1.Manage Account");
        System.out.println("2.Manage customer");
        System.out.println("0.Exit");
    }
    public static void main(String[] args) {
        
        Account ac = new Account();
        Customer cust = new Customer();
        
        Scanner scan = new Scanner(System.in);
        menu();
        int key =-1;
        while(true)
        {
            System.out.print("\nEnter your choise ");
            key = scan.nextInt();

            if(key==1)
            {
                System.out.println("___________[ACCOUNT SECTION]_____________");
               ac.AccountOperation();
            }
            else if(key == 2)
            {
                System.out.println("___________[CUSTOMER SECTION]_____________");
                cust.customerOperation();
            }
            else if(key==0){
                break;
            }
        }
    }
}
