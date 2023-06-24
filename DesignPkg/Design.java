package DesignPkg;
import java.io.*;
class Color
{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public void applyGreen(String str)
    {
        System.out.print(ANSI_GREEN + str + ANSI_RESET);
    }
     public String applyGreen(Float num)
    {
        String  str = Float.toString(num);
        return ANSI_GREEN + str + ANSI_RESET;
    }
     public String setPurpleColor(String str)
    {
       
        return ANSI_PURPLE + str + ANSI_RESET;
    }
    public void applyYellow(String str)
    {
        System.out.print(ANSI_YELLOW + str + ANSI_RESET);
    }
    public void applyRed(String str)
    {
        System.out.print(ANSI_RED + str + ANSI_RESET);
    }
    public void applyBlue(String str)
    {
        System.out.print(ANSI_BLUE + str + ANSI_RESET);
    }
    public void applyPurple(String str)
    {
        System.out.print(ANSI_PURPLE + str + ANSI_RESET);
    }
    public void applyWhite(String str)
    {
        System.out.print(ANSI_WHITE + str + ANSI_RESET);
    }
    public void applyCyan(String str)
    {
        System.out.print(ANSI_CYAN + str + ANSI_RESET);
    }
    public void fillGreen()
    {
        System.out.print(ANSI_GREEN);
    }
     public void fillBlue()
    {
        System.out.print(ANSI_BLUE);
    }
     public void fillYellow()
    {
        System.out.print(ANSI_YELLOW);
    }
     public void fillWhite()
    {
        System.out.print(ANSI_WHITE);
    }
     public void fillCyan()
    {
        System.out.print(ANSI_CYAN);
    }
     public void fillPurple()
    {
        System.out.print(ANSI_PURPLE);
    }
    public void resetColor()
    {
        System.out.print(ANSI_RESET);
    }
  
   
}
public class Design extends Color implements Serializable {

    private static final long  serialVersionUID = -3366073526597920847L;


    void printLine()
    {
       applyGreen("_________________ ");
    }
    void printNewLine()
    {
        System.out.println();
    }
    
   public void line()
    {
        applyCyan("-------------------------------------------------\n");

    }
    void greenYellowDesign(String str)
    {
         printLine();
         applyYellow("[" + str +"]");
         printLine();
         printNewLine();
    }

    public void customerSectionHeader()
    {
        String heading = "CUSTOMER SECTION";
        greenYellowDesign(heading);
    }
    public void customerSectionHeader(String user_name)
    {
        customerSectionHeader();

        applyPurple("Name :");
        applyGreen(user_name);
        printNewLine();

        
    }
     public void accountSectionHeader()
    {
        String heading = "ACCOUNT SECTION";
        greenYellowDesign(heading);

    }
     public void adminCustSectionHeader()
    {
        String heading = "ADMIN CUSTOMER ";
        greenYellowDesign(heading);

    }
    public void loginSection()
    {
        String heading = "LOGIN SECTION";
        greenYellowDesign(heading);
    }
     public void signUpSection()
    {
        String heading = "SIGNUP SECTION";
        greenYellowDesign(heading);
    }
    public void authenticateSection()
    {
        String heading = "AUTHENTICATE SECTION";
        greenYellowDesign(heading);
    }
      public void adminAccSectionHeader()
    {
        String heading = "ADMIN ACCOUNT SECTION";
        greenYellowDesign(heading);

    }
     public void managerSectionHeader()
    {
        String heading = "MANAGER SECTION";
        greenYellowDesign(heading);

    }
    public void createAccountSection()
    {
        String heading = "NEW ACCOUNT SECTION";
        greenYellowDesign(heading);

    }
     public void depositSection()
    {
        String heading = "DEPOSIT SECTION";
        greenYellowDesign(heading);

    }
     public void withdrawSection()
    {
        String heading = "WITHDRAW SECTION";
        greenYellowDesign(heading);

    }
    public void homeSection()
    {
        String heading = "HOME PAGE";
        greenYellowDesign(heading);

    }
    public void accountTableHead()
    {
        String heading ="ALL ACCOUNTS";
        greenYellowDesign(heading);
    }
}
