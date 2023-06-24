package CustomerPkg;
import java.util.*;

import AccountPkg.Account;
import AccountPkg.AccountDatabase;
import DesignPkg.Design;

import java.io.*;

public class Customer  implements Serializable 
{
    static int id = 0;
    private static final long  serialVersionUID = -3366073526597920846L;
    private int cust_id ;
    String cust_pass;
    
    String cust_address;
    String cust_username;
    String cust_name;
    String cust_city;
    String cust_email;

    Design design = new Design();

   

    void addCutomer()
    {
        Scanner scan = new Scanner(System.in);

        this.cust_id =  generateUniqueId();

        System.out.print("Enter name : ");
        this.cust_name = scan.nextLine();

        System.out.print("Set user name :");
        this.cust_username = scan.next();

        System.out.print("Enter password :");
        this.cust_pass = scan.next();

        System.out.print("Enter Email :");
        this.cust_email = scan.next();
        
       scan.nextLine();
       System.out.print("Enter Address :");
       this.cust_address = scan.nextLine();
     
    }
    int generateUniqueId()
    {
        id +=1;
        return id;
    }
    public String getUserName()
    {
        return this.cust_username;
    }

    void setPassword()
    {

    }
    void showCutomerInfo()
    {
        System.out.println("Id : "+ this.cust_id);
        System.out.println("User Name : " + this.cust_username);
        System.out.println("Name : " +this.cust_name);
        System.out.println("Email : "+this.cust_email);
        System.out.println("Address : "+ this.cust_address);

    }
    @Override
    public String toString()
    {
        return "\nId : " + this.cust_id + "\tName : " + this.cust_name + "\tUsername : " +this.cust_username+ "\tEmail : " +this.cust_email + "\tPassword : " + this.cust_pass;
        //return new StringBuffer("Name :").append(this.cust_name).append("Id ").append(this.cust_id); 
    }
    static void customerMenu1()
    {
        Design design = new Design();
        design.fillCyan();
        System.out.println("1.Creat Account");
        System.out.println("2.Deposit amount");
        System.out.println("3.Withdraw amount");
        System.out.println("4.Get Account Details");
        System.out.println("0.Exit");
        design.resetColor();
       
    }
    static void customerMenu()
    {
        Design design = new Design();
        design.fillCyan();
        System.out.print("1.Creat Account    ");
        System.out.println("\t2.Deposit amount");
        System.out.print("3.Withdraw amount   ");
        System.out.println("\t4.Get Account Details");
        System.out.println("0.Exit");
        design.resetColor();
       
    }
    static void adminMenu()
    {
        System.out.println("1.Insert");
        System.out.println("2.Display");
        System.out.println("0.Exit");
    }
    static int inputKey()
    {
         Scanner scan = new Scanner(System.in);
         Design design = new Design();
         design.fillYellow();
         int key = scan.nextInt();
         design.resetColor();
         return key;
    }
    public void customerOperation()
    {
       customerMenu();
        Scanner scan = new Scanner(System.in);
      
        int key =-1;
        while(true)
        {
            boolean exceptionCaught = false;
            try{ 
                design.applyPurple("Enter key ");
                design.applyGreen("<customer> :"); 
                key = inputKey();
            }
            catch( InputMismatchException e)
            {
               design.applyRed("Enter valid input\n");
               exceptionCaught = true;
               
            }

            if(key == 1)
            {
                design.createAccountSection();
                this.createAccount();
            }
            else if(key == 2)
            {
                design.depositSection();
                this.depositAmount();
            }
            else if(key == 3)
            {
                design.withdrawSection();
                this.withdrawAmount();
            }
            else if(key == 4)
            {
                design.accountSectionHeader();
                 Account account = transactionAccount();
                 if(account!=null)
                 account.getAccDetails();
            }
            else if(key == 0)
            {
                System.out.println("Successfully exited.");
                break;
            }
            else{
                if(!exceptionCaught)
                System.out.println("Enter valid case ");
            }
            
        }

    } 
    public Customer signUpCustomer()
    {
        this.addCutomer();
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        customerList.add(this);
        CustomerDatabase customerDb = new CustomerDatabase();
        customerDb.insertRecord(customerList);
         return this;
        

    }
    public void adminOperation()
    {
        adminMenu();
         Scanner scan = new Scanner(System.in);

        CustomerDatabase customerDB = new CustomerDatabase();
        int key =-1;
        while(true)
        {

            boolean exceptionCaught = false;
             try{ 
                design.applyPurple("Enter key ");
                design.applyGreen("<admin> :");
                key = inputKey();
            }
            catch( InputMismatchException e)
            {
               design.applyRed("Enter valid input\n");
               exceptionCaught = true;
               
            }

              if(key == 1)
            {
                System.out.println("Enter how many customer wants to add :");
                int n = scan.nextInt();
                ArrayList<Customer> customerList = new ArrayList<Customer>();
                for(int i =0; i<n;i++)
                {
                    Customer customer = new Customer();
                    customer.addCutomer();
                    customerList.add(customer);
                }
                customerDB.insertRecord(customerList);
            }
            else if(key == 2)
            {
                 try{
                 ArrayList<Customer> customerList = customerDB.readDataFromFile();
                  customerDB.printRecord(customerList);
                 }
                 catch( StreamCorruptedException st){
                    System.out.println("Stream was corrupted ,Please insert data first ");
                 }
                 catch(IOException e)
                 {
                    System.out.println("No record present in database ");
                 }
               
            }
            else if(key==0){
                System.out.println("Successfully exited.");
                break;
            }
            else{
                if(!exceptionCaught)
                System.out.println("Enter valid case");
            }
        }
    }
    public void createAccount()
    {
        Design design = new Design();
        Account account = new Account();
        account.addAccount();
        if(account!=null)
        {
            ArrayList<Account> accountList = new ArrayList<Account>();
            AccountDatabase accountDB = new AccountDatabase();
            accountList.add(account);
            accountDB.insertRecord(accountList);

            design.applyGreen("Account created Successfully..!\n");
                    
        }
    }
    Account getAccountDetails(String cust_name , int cust_account_number)
    {
        Account account = new Account();
        account = account.getAccountFromDatabase(cust_name ,cust_account_number);
        if(account!=null)
        return account;
        else{
        
            design.applyRed("No account details found\n");
            return null;
        }
    }
     Account transactionAccount()
    {
        Account account = new Account();
        String cust_name = account.setValidAccName();
        int cust_account_number = account.setValidAccNum();
        
        return getAccountDetails(cust_name , cust_account_number);
    }
     
    float inputAmount()
    {
        Scanner scan =  new Scanner(System.in);
        Design design = new Design();
        design.fillPurple();
        float acc_balance= scan.nextFloat();
        design.resetColor();
        return acc_balance;
    }
     public float setValidAmount(String title)
    {
        float acc_balance = -1.f;
        Design design = new Design();
        boolean validAccBalInput =false; 
        while(!validAccBalInput){

            try
            {
              design.applyBlue(title);
               acc_balance = inputAmount();
               if(acc_balance<=0){
                    validAccBalInput = false;
                     design.applyRed("Enter valid Account balance\n");
                }
                else{
                    validAccBalInput = true;
                }
            }
            catch(InputMismatchException e)
            {
                design.applyRed("Enter valid Account Balance\n");   
            }
            
            design.resetColor();
      }
       if(validAccBalInput){
         return acc_balance;
      }
      else{
        return -1;
      }
    }

    public void depositAmount()
    {
         Scanner scan =  new Scanner(System.in);
         Design design = new Design();
        Account account = transactionAccount();
        if(account!=null){
            // System.out.print("Enter amount to deposit :");
            String title = "Enter amount to deposit :";
            float amount = setValidAmount(title);
            account.deposit(amount);
            account.getAccDetails();
        }
    }
    public void withdrawAmount()
    {
         Scanner scan =  new Scanner(System.in);
    
        Account account = transactionAccount();
        if(account!=null){
            // System.out.print("Enter amount to withdraw :");
             String title = "Enter amount to withdraw :";
            float amount = setValidAmount(title);

            account.whithdraw(amount);
            account.getAccDetails();
        }
    }

}
