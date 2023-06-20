package AccountPkg;
import java.io.*;
import java.util.*;
import DesignPkg.Design;

public class Account implements Serializable
{
    private static final long  serialVersionUID = 2111865428100305111L;
    static int acc_id = 0;
    int acc_num;
    String acc_holder;
    float acc_balance;

    public Account(){}

    Account(int acc_id ,int acc_num ,String acc_holder ,float acc_balance)
    {
        this.acc_id = acc_id;
        this.acc_num = acc_num;
        this.acc_holder = acc_holder;
        this.acc_balance = acc_balance;
    }
    @Override
    public String toString()
    {
        Design design = new Design();
        // design.fillPurple();
         
        String balance = design.applyGreen(acc_balance);
        String acc_holder_c = design.setPurpleColor(acc_holder);
        return "\t" + acc_holder_c + "\t\t" +acc_num + "\t" + balance ; 
        
        // return "\nName :" + acc_holder + "\nAccount no. : " +acc_num + "\nAccount balance :" + acc_balance; 
    }
    String inputAccName() throws InputMismatchException
    {
        Design design = new Design();
        Scanner scan_str =  new Scanner(System.in);
        design.applyBlue("Enter account holders name :");
        design.fillPurple();
        String acc_holder= scan_str.nextLine();
        design.resetColor();
        return acc_holder;
           
    }
    int inputAccNum() throws InputMismatchException
    {
        Design design = new Design();
        Scanner scan =  new Scanner(System.in);
        design.applyBlue("Enter Account number :");
        design.fillPurple();
        int acc_num= scan.nextInt();
        return acc_num;
           
    }
    float inputAccBalance() throws InputMismatchException
    {
        Design design = new Design();
        Scanner scan =  new Scanner(System.in);
        design.applyBlue("Enter account balance :");
        design.fillPurple();
        float acc_balance= scan.nextFloat();
        return acc_balance;
           
    }
  public int setValidAccNum()
    {
        int acc_num = -1;
        Design design = new Design();
        boolean validAccNumInput =false; 
        while(!validAccNumInput){

            try
            {
                acc_num = inputAccNum();
                if(acc_num<=0){
                    validAccNumInput = false;
                     design.applyRed("Enter valid Account number\n");
                }
                else{
                    validAccNumInput = true;
                }
            }
            catch(InputMismatchException e)
            {
                design.applyRed("Enter valid Account number\n");     
            }
            
            design.resetColor();
      }
      if(acc_num!=-1){
        return acc_num;
      }
      else{
        return 0;
      }
    }
    public float setValidAccBalance()
    {
        float acc_balance = -1.f;
        Design design = new Design();
        boolean validAccBalInput =false; 
        while(!validAccBalInput){

            try
            {
               acc_balance = inputAccBalance();
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
 
    boolean isValidString(String name)
    {
      
        String special = "@#$%^&*!-_+=}[]/;'~1234567890";
        char arr[] = special.toCharArray();
        int len = special.length();

        for(int i =0;i<len;i++)
        {
            if(name.indexOf(arr[i]) !=-1){
                 return false;
            }
        }
        return true;
    }
    public String setValidAccName()
    {
        Design design = new Design();
        boolean validNameInput =false; 
        while(!validNameInput){
               String name = inputAccName(); 
               if(isValidString(name)){
                //  this.acc_holder = name;
                //  validNameInput = true;
                return name;
               }
               else{
                design.applyRed("Enter valid name\n");
               }
              
            design.resetColor();

         
      }
      return null;
    }
    public void addAccount()
    {
        this.acc_holder=setValidAccName();
        this.acc_num = setValidAccNum();
        this.acc_balance = setValidAccBalance();
        this.acc_id = generateUniqueAccId();
    }
    int generateUniqueAccId()
    {
        acc_id+=1;
        return acc_id;
    }
    
    boolean isAccountValid()
    {
        AccountDatabase accountDb = new AccountDatabase();
        return accountDb.findAccount(this);
    }
    public void deposit(float amount)
    {
            this.acc_balance +=amount;
            AccountDatabase accountDB = new AccountDatabase();
            accountDB.updateAccountBalance(this); 
            Design design = new Design();
            //  System.out.println("Amount successfully deposited");
            design.applyGreen("Amount successfully deposited\n");
    }

    public void whithdraw(float amount)
    {
        Design design = new Design();

        if(amount > this.acc_balance){
            // System.out.println("Do not have sufficient balance ");
            design.applyRed("Do not have sufficient balance \n");
        }
        else if(this.acc_balance == amount ){
            System.out.println("Account balance is " + this.acc_balance + " Your minimum balance should be 1000, hence cannot withdraw");
        }
        else
        {
            this.acc_balance -=amount;
            // System.out.println("Amount successfully whithdrawal");
            design.applyGreen("Amount successfully whithdrawal\n");
            AccountDatabase accountDB = new AccountDatabase();
            accountDB.updateAccountBalance(this); 
        }

    }
    public void getAccDetails()
    {
        System.out.println("_____________ Details _____________");
        System.out.println("Account Number : " + this.acc_num);
        System.out.println("Account Holder : " + this.acc_holder);
        System.out.println("Current Balance : Rs. " + this.acc_balance);
        System.out.println();
    }
    public Account getAccountFromDatabase(String acc_name , int acc_num)
    {
        AccountDatabase accountDb = new AccountDatabase();
        return accountDb.getAccountFromFile(acc_name, acc_num);
    }
    float getBalance()
    {
        return this.acc_balance;
    }
     static void menu()
    {
        Design design  = new Design();
        design.fillCyan();
        System.out.println("1.Insert");
        System.out.println("2.Display");
        System.out.println("3.search");
        System.out.println("4.Delete");
        System.out.println("5.Update");
        System.out.println("6.Sort By Account number on screen");
        System.out.println("7.Sort By Account number in file");
        System.out.println("8.Sort By Account name on screen");
        System.out.println("9.Sort By Account name in file");
        System.out.println("10.Rewrite all data of file");
        // System.out.println("10.Sort By Emp sal on screen");
        // System.out.println("11.Sort By Emp sal in file");
        System.out.println("0.Exit");
        design.resetColor();
    }
    void printData(ArrayList<Account> accountList)
    {
        Design design = new Design();

        if(accountList!=null){
        int i = 1;
          for (Account account : accountList) {
               design.line();
                 System.out.print(i + ". ");
                System.out.println(account);
                // line();
                i++;
            }
            design.line();
        }
        else{
            System.out.println("List is Empty");
        }
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
   public void AccountOperation()
    {
        Scanner scan = new Scanner(System.in);
        Scanner scan_str = new Scanner(System.in);
        AccountDatabase accountDb = new AccountDatabase();
        Design design = new Design();
        menu();
        int key =-1;
        while(true)
        {
            // System.out.print("\nEnter key :");
            boolean exceptionCaught = false;
            try{ 
                design.applyPurple("Enter key ");
                design.applyGreen("<account> :");
                key = inputKey();
            }
            catch( InputMismatchException e)
            {
               design.applyRed("Enter valid input\n");
               exceptionCaught=true;
               
            }
            if(key == 1)
            {
                ArrayList<Account>  accountList = new ArrayList<Account>();
                System.out.print("Enter total account's wants to add :");
                int n = scan.nextInt();
                for(int i =0;i<n;i++)
                {
                    Account account = new Account();
                    account.addAccount();
                    accountList.add(account);
                }
                accountDb.insertRecord(accountList);
            }
            else if(key == 2)
            {
                design.accountTableHead();
                // System.out.println("--------------------------------------");
                design.line();
                // System.out.println("sr.  "  + "Name\tAccount no.\tBalance");
                design.applyYellow("sr.\t"  + "Name\tAccount no.\tBalance\n");
                printData(accountDb.readDataFromFile());
            }
            else if(key == 3)
            {
                //  System.out.print("Enter account holders name :");
                String name = setValidAccName();

                accountDb.searchAccountByName(name);
            }
            else if(key == 4)
            {
                // System.out.print("Enter account holders name :");
                // String name = scan_str.nextLine();
                // System.out.print("Enter account number:");
                // int account_number = scan.nextInt();
                String name = setValidAccName();
                int account_number = setValidAccNum();
                accountDb.deleteRecord(name,account_number);
            }
            else if(key == 5)
            {
                System.out.print("Enter account holders name :");
                String name = scan_str.nextLine();
                System.out.print("Enter account number:");
                int account_number = scan.nextInt();
                accountDb.updateName(name, account_number);
    
            }
            else if(key == 6)
            {
                System.out.println("Sorted on Account number");
               design.line();
                System.out.println("sr.  " + "Name\tAccount no.\tBalance");
                printData(accountDb.sortByAccNumOnScreen());
            }
            else if(key == 7)
            {

              accountDb.sortByAccNumInFile();
            }
             else if(key == 8)
            {
                System.out.println("Sorted on Name ");
                design.line();
                System.out.println("sr.  " + "Name\tAccount no.\tBalance");
                printData(accountDb.sortByNameOnScreen());
            }
            else if(key == 9)
            {
              accountDb.sortByNameInFile();
            }
            else if(key == 10)
            {
              ArrayList<Account> accountList = new ArrayList<Account>();
              accountDb.setNewDataIntoFile(accountList);
            }
            else if(key==0)
            {
                System.out.println("Successfully exited.");
                break;
            }
            else{
                if(!exceptionCaught)
                System.out.println("Enter a valid key");
            }
            
        }
    }
}