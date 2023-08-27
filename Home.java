import java.util.*;
import AccountPkg.ManageAccount;
import AuthenticatePkg.Login;
import AuthenticatePkg.SignUp;
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
        System.out.println("4.Enter if you are Bank manager");
        System.out.println("5.Enter if you are Employee");
        System.out.println("6.Enter for bank information");
        System.out.println("0.Exit");
        design.resetColor();
    }

    static void authenticateMenu()
    {
        Design design = new Design();
        design.fillCyan();
        System.out.println("1.Login");
        System.out.println("2.SignUp");
        System.out.println("0.Exit");
        
        design.resetColor();
    }
   static Customer applyAuthentication()
    {

        Scanner scan = new Scanner(System.in);
        Design design = new Design();
        design.authenticateSection();
        authenticateMenu();

        
        while(true){
                design.applyPurple("Enter key ");
                design.applyGreen("<authenticate> :");
                design.fillYellow();
                int key = scan.nextInt();
                design.resetColor();
            if(key==1)
            {
                design.loginSection();
                Login login  = new Login();
                Customer customer = login.applyLoginCondition();
                if(customer==null){
                    design.applyRed("Unable to authenticate please enter correct details\n");
                    
                } 
                else{
                    design.applyGreen("Successfully logged in\n");
                    return customer;
                }

            }
            else if(key==2)
            {
                design.signUpSection();
                SignUp signup = new SignUp();
                Customer customer = signup.applySignUpCondition();
                if(customer==null){
                    design.applyRed("Unable to signup please enter correct details\n");
                    
                } 
                else{
                    design.applyGreen("Successfully signed up\n");
                    return customer;
                }
            }
            else if(key==0){
                System.out.println("Successfully exit from authentication module");
                break;
            }
            else{
                design.applyRed("Enter valid case");

           }
        }
        return null;
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

                Customer customer = applyAuthentication();

                if(customer!=null){
                design.customerSectionHeader(customer.getUserName());
                customer.customerOperation();
                }
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
                System.out.println("Not added");
            }
            else if(key==5)
            {
                System.out.println("Not added");
            }
            else if(key==6)
            {
                System.out.println("Not added");
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
