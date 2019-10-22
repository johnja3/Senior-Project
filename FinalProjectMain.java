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













/*import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SeniorProject 
{


    public static void main(String[] args) 
    {
       
        Scanner keyboard = new Scanner(System.in);
        
        
        int selector;
        System.out.println("Welcome to Oasis Assistant.");
        System.out.println("1. Student");
        System.out.println("2. Teacher");
        System.out.println("3. Administrator");
        System.out.println("4. Exit OASIS Assiatnt");
        selector = keyboard.nextInt();
        

        
        
        
        do{
            switch (selector) {
               
                case 1:
                    student();
                    selector = 4;
                    break;
                case 2:
                    teacher();
                    selector = 4;
                    break;
                case 3:
                    administrator();
                    selector = 4;
                    break;
                case 4:
                    System.out.println("Good luck with your semester!");
                    break;
                 default:
                    System.out.println("You did not select one of the options. Please try again.");
                    selector = keyboard.nextInt();
                 
            }
        
        }while (selector != 4);
        
    }
    
    
    public static void student()
    {
        System.out.println("Testing student");
        
        
        
        
    }
    
    public static void teacher()
    {
        
        System.out.println("testing teacher");
    }
    
    public static void administrator()
    {
        System.out.println("Testing admin");
    }
    
    
    
    
}
*/