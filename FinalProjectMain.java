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
        System.out.println("Testing student");      
    }
    
    public static void teacher(){
        System.out.println("Testing teacher");
    }
    
    public static void administrator(){
        System.out.println("Testing admin");
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
