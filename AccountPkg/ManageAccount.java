package AccountPkg;
import java.io.*;
import java.util.*;

public class ManageAccount
{
    public void manage()
    {
         Account ac = new Account();
         ac.AccountOperation();
    }
    public static void main(String[] args) {
        ManageAccount ma = new ManageAccount();
        ma.manage();
    }
   
}


