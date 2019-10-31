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

    public static void main(String[] args) {
        // Allows access to methods in senior project file
          SeniorProject sp = new SeniorProject();
          
          sp.menu();
    }
}
