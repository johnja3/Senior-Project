import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

// DB imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;

public class SeniorProject extends FinalProjectMain
{   
    
    public static void student(){
        System.out.println("Testing student prompt:");
        
        Scanner keyboard = new Scanner(System.in);
        Scanner keyboard2 = new Scanner(System.in);
        Scanner keyboard3 = new Scanner(System.in);
        Scanner keyboard4 = new Scanner(System.in);
        int amountClass;
        System.out.println("How many classes are you going to take?");
        amountClass = keyboard.nextInt();
        System.out.println("Please enter the classes you want to take. To return please press 0:");
        System.out.println("Example: (BCS102, MTH130, BUS101)");
        String selector;
        selector = keyboard2.nextLine();
        
        String[] toppings = new String[amountClass];
        
        toppings = selector.split(",");
        
        for(int i=0; i < toppings.length; i++){
			System.out.print(toppings[i] + " " );
        
        }
    }
    
    public static void teacher(){
        System.out.println("Testing teacher");
    }
    
    public static void administrator(){
        System.out.println("Testing admin");
    }
    
    public static void menu(){
        // Takes user input
          Scanner keyboard = new Scanner(System.in);
          String selector;
          
          // Displays menu
          System.out.println("Welcome to Oasis Assistant.");
          System.out.println("___________________________");
          System.out.println("Please type an option:");
          System.out.println("1. Student");
          System.out.println("2. Teacher");
          System.out.println("3. Administrator");
          System.out.println("4. Exit OASIS Assiatnt");
          System.out.println("5. Test DB");
          selector = keyboard.next();
          
          switch (selector) {
                  case "1":
                      student();
                      break;
                  case "2":
                      teacher();
                      break;
                  case "3":
                      administrator();
                      break;
                  case "4":
                      System.out.println("Good luck with your semester!");
                      System.exit(0);
                      break;
                  case "5":
                      System.out.println("Testing DB:");
                      testDB();
                      break;
                   default:
                      System.out.println("Input is incorrect, try again.");
                      System.out.println();
                      menu();
              }
    }
    
    public static void testDB(){    
        String connectionUrl =
                "jdbc:sqlserver://bcs430-final-project.database.windows.net;"
                        + "database=OASIS ASSISTANT;"
                        + "user=farmingdale@bcs430-final-project;"
                        + "password=bcs430w!;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
        
        Statement state = null;
        ResultSet resultSet = null;

        try{
            Connection con = DriverManager.getConnection(connectionUrl);
                    String SQL = "SELECT * FROM dbo.BCS102 WHERE crse = 102;";
                    state = con.createStatement();
                    resultSet = state.executeQuery(SQL);
                    
                    while(resultSet.next()){
                        System.out.println(resultSet.getString(1) +
                                "    " + resultSet.getString(2) + "     " + resultSet.getString(3) + "     " + 
                                resultSet.getString(4) + "     " + resultSet.getString(5) + "     " + 
                                resultSet.getString(6) + "     " + resultSet.getString(7) + "     " + resultSet.getString(8) +
                                "     " +resultSet.getString(9) + "     " +resultSet.getString(10) + "     " +resultSet.getString(11) + 
                                "     "/* +resultSet.getString(12)*/);
                    }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }  
}
