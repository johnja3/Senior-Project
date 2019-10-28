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

public class FinalProjectMain {

    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {
          Scanner keyboard = new Scanner(System.in);
          SeniorProject sp = new SeniorProject();
          
          int selector;
          System.out.println("Welcome to Oasis Assistant.");
          System.out.println("___________________________");
          System.out.println("Please type an option:");
          System.out.println("1. Student");
          System.out.println("2. Teacher");
          System.out.println("3. Administrator");
          System.out.println("4. Exit OASIS Assiatnt");
          System.out.println("5. Test DB");
          selector = keyboard.nextInt();
          do{
              switch (selector) {
                  case 1:
                      sp.student();
                      
                      break;
                  case 2:
                      sp.teacher();
                      selector = 4;
                      break;
                  case 3:
                      sp.administrator();
                      selector = 4;
                      break;
                  case 4:
                      System.out.println("Good luck with your semester!");
                      System.exit(0);
                      break;
                  case 5:
                      System.out.println("Testing DB:");
                      sp.testDB();
                      break;
                   default:
                      System.out.println("Input is incorrect, try again.");
                      selector = keyboard.nextInt();
              }
            }while (selector != 4);
    }
}
