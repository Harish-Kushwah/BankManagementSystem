package AuthenticatePkg;
import java.io.*;
import java.util.*;
import AccountPkg.*;
import CustomerPkg.Customer;
import DesignPkg.Design;
public class SignUp {

    public Customer applySignUpCondition()
    {
        Customer customer = new Customer();
        customer = customer.signUpCustomer();
        if(customer !=null)
        return customer;
        
        return null;

    }
    public static void main(String[] args) {
        
        

    }
}
