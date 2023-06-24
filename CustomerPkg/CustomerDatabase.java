package CustomerPkg;
import java.io.*;
import java.util.*;
public class CustomerDatabase {
    
    void setNewDateIntoFile(ArrayList<Customer> customerList) throws InvalidClassException
    {
        if(customerList!=null)
        {
            File file = new File("Files/CustomerInfo.txt");

            try{
                FileOutputStream f_out = new FileOutputStream(file);
                ObjectOutputStream obj_out = new ObjectOutputStream(f_out);
                obj_out.writeObject(customerList);
                
                f_out.close();
                obj_out.close();

            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    ArrayList<Customer> readDataFromFile() throws StreamCorruptedException,IOException
    {
        File  file = new File("Files/CustomerInfo.txt");
        ArrayList<Customer> customerList = new ArrayList<Customer>(); 
        if(file.isFile())
        {
           try{
              FileInputStream f_in = new FileInputStream(file);
              ObjectInputStream obj_in = new ObjectInputStream(f_in);
              customerList = (ArrayList<Customer> )obj_in.readObject();
              obj_in.close();
              f_in.close();
              return customerList;

           }
            catch (ClassNotFoundException e) {
                System.out.println("I am from readData from file fun 2");

                e.printStackTrace();
            }
        }
        else{
            System.out.println("File Not Found.");
        }

        return null;
    }

    public Customer findByNameAndPass(String usr_name ,String pass)
    {
        
        try{
            ArrayList<Customer> customerList = readDataFromFile();
            if(customerList!=null)
            {
                for(Customer customer : customerList){
                    if(customer.cust_username.equals(usr_name) && customer.cust_pass.equals(pass)){
                        return customer;
                    }
                }
            }
           
        }
        catch( StreamCorruptedException st )
        {
            //    System.out.println("Stream was Corrupted ");
             return null;
        }
        catch( IOException e)
        {
            System.out.println("File is empty ");
             return null;
        }
         return null;
    }
    void insertRecord(ArrayList<Customer> customerList)
    {
        try{
        File file = new File("Files/CustomerInfo.txt");

          ArrayList<Customer> tempCustomerList = new ArrayList<Customer>();

            try{
                if(file.length()!=0){
                    tempCustomerList =   readDataFromFile();
                }
            }
            catch( StreamCorruptedException st )
            {
                //    System.out.println("Stream was Corrupted ");
            }
            catch( IOException e)
            {
                System.out.println("Input out exception ");
            }
            
            //Append the remaining customer record
            for(Customer  customer :customerList){
                tempCustomerList.add(customer);
            }
          
          setNewDateIntoFile(tempCustomerList);
          }

        catch( InvalidClassException i)
        {
        System.out.println("Invalid class exception caught ");
        // deleteFile();
        }
    
         
          
    }
    
    private void deleteFile()
    {
         File file = new File("Files/CustomerInfo.txt");
           Scanner scan = new Scanner(System.in);
            System.out.println("Enter \"Erase\" to  erase the data :");
            String input = scan.nextLine();
            if( input.equalsIgnoreCase("Erase")){
                if(file.delete())
                {
                    System.out.println("File deleted successfully ");
                }
                else{
                    System.out.println("Unable to delete file");
                }

            }
            else{
                System.out.println("Enter valid input :");
            }
    }
    
    void printRecord(ArrayList<Customer> customerList)
    {
        if(customerList!=null){
            for(Customer customer : customerList)
            {
                System.out.println(customer);
            }
        }
        else{
            System.out.println("Customer List is Empty ");
        }
    }
}
