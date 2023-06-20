package AccountPkg;

import java.io.*;
import java.util.*;

import CustomerPkg.Customer;

public class AccountDatabase
{

     //previous data will be erased  
    void setNewDataIntoFile(ArrayList<Account> accountList)
    {
     
        File file = new File("Files/AccountInfo.txt");
        try
        {
            FileOutputStream  f_out = new FileOutputStream(file);
            ObjectOutputStream obj_out = new ObjectOutputStream(f_out); 
            obj_out.writeObject(accountList);
            obj_out.close();
            f_out.close();


        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }

    ArrayList<Account> readDataFromFile()
    {
        File file = new File("Files/AccountInfo.txt");

        if(file.isFile()){
            ArrayList<Account> accountList = new ArrayList<Account>();
            
            try{
                FileInputStream  f_in = new FileInputStream(file);
                ObjectInputStream obj_in = new ObjectInputStream(f_in);
                accountList = (ArrayList<Account>) obj_in.readObject();
                obj_in.close();
                f_in.close();
                return accountList;
            }
            catch(IOException e)
            {
                System.out.println(e);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
           
            return null;
        }
        else{
            System.out.println("File not found");
            return null;
        }

    }

    void deleteRecord(String name ,int account_number)
    {
        ArrayList<Account> accountList = readDataFromFile();
        boolean found = false;
        for(Account account : accountList){
            if(account.acc_holder.equalsIgnoreCase(name) && account.acc_num == account_number){
                accountList.remove(account);
                found = true;
                break;
            }
        }
        if(found){
            setNewDataIntoFile(accountList);
            System.out.println("Record Successfully Deleted");
        }
        else{
            System.out.println("Record not found");
        }
    }
    boolean findAccount(Account new_account)
    {
        ArrayList<Account> accountList = readDataFromFile();
        for(Account account : accountList){
            if(account.acc_holder.equalsIgnoreCase(new_account.acc_holder) && account.acc_num == new_account.acc_num){
               return true;
            }
        }
        return false;
    }
    Account getAccountFromFile(String customer_name , int cust_account_number)
    {
      ArrayList<Account> accountList = readDataFromFile();
        for(Account account : accountList){
            if(account.acc_holder.equalsIgnoreCase(customer_name) && account.acc_num == cust_account_number){
               return account;
            }
        }
        return null;
        
    }
    void searchAccountByName(String name)
    {
        ArrayList<Account> accountList = readDataFromFile();
        boolean found = false;
        for(Account account : accountList)
        {
            if(account.acc_holder.equalsIgnoreCase(name)){
                found = true;
                 System.out.println("Record Found :");
                 System.out.println(account);
                break;
            }
        }
        if(!found){
            System.out.println("No Record of name : " + name );
            System.out.println("Please check your details..");
        }
    }
    void updateName(String name , int account_number)
    {
        Scanner scan_str = new Scanner(System.in);
        ArrayList<Account> accountList = readDataFromFile();
        boolean found = false;
       
        for(Account account : accountList)
        {
            if(account.acc_holder.equalsIgnoreCase(name) && account.acc_num==account_number){

                found = true;

                System.out.print("Enter new  name :");
                String new_name = scan_str.nextLine();
                
                account.acc_holder = new_name;
                setNewDataIntoFile(accountList);
                System.out.println("Name updated successfully..");
            }
        }
        if(!found)
        {
            System.out.println("Record not found of name :" + name) ;
        }

    }
    void updateAccountBalance(Account new_account)
    {
      ArrayList<Account> accountList = readDataFromFile();
      boolean found = false;
      for(Account account : accountList)
      {
        if(account.acc_holder.equalsIgnoreCase(new_account.acc_holder) && account.acc_num == new_account.acc_num)
        {
            account.acc_balance = new_account.acc_balance;
            found = true;
            break;
        }
      }
      setNewDataIntoFile(accountList);
    
      if(!found){
        System.out.println("Record not found of name :" + new_account.acc_holder);
      }
    }
  public void insertRecord(ArrayList<Account> accountList)
    {
         File file = new File("Files/AccountInfo.txt");
         ArrayList<Account> tempAccountList = new ArrayList<Account>();

         /*
          * read all the data from the file into arraylist
            then append extra data into list
            write that new list into file
          */
        if(file.length() !=0){ 
            tempAccountList = readDataFromFile();
        }

        //append the data
        for(Account account : accountList){
            tempAccountList.add(account);
        }
        setNewDataIntoFile(tempAccountList);
        
    }

    ArrayList<Account> sortAccountListOnAccNum(ArrayList<Account> accountList )
    {
            Comparator cmp = new Comparator<Account>()
            {
            public int compare(Account a1 , Account a2){
                return a1.acc_num - a2.acc_num;
            }
            };
            Collections.sort(accountList ,cmp);
            return accountList;
    }
    ArrayList<Account> sortAccountListOnName(ArrayList<Account> accountList)
    {
        Comparator cmp = new Comparator<Account>() {
            public int compare(Account a1 , Account a2)
            {
                return a1.acc_holder.compareTo(a2.acc_holder);
            }
        };
        Collections.sort(accountList , cmp);
        return accountList;
    }
    ArrayList<Account> sortByNameOnScreen()
    {
        ArrayList<Account> accountList = readDataFromFile();
        accountList = sortAccountListOnName(accountList);
        return accountList;
    }
    void sortByNameInFile()
    {
        ArrayList<Account> accountList = readDataFromFile();
        accountList = sortAccountListOnName(accountList);
        setNewDataIntoFile(accountList);
    }
   ArrayList<Account> sortByAccNumOnScreen()
    {
        ArrayList<Account> accountList = new ArrayList<Account>();
        accountList = readDataFromFile();
        accountList = sortAccountListOnAccNum(accountList);
        return accountList;
        
    }
    void sortByAccNumInFile()
    {
        ArrayList<Account> accountList = new ArrayList<Account>();
        accountList = readDataFromFile();
        accountList = sortAccountListOnAccNum(accountList);
        setNewDataIntoFile(accountList);
    }
    
    
 
}

