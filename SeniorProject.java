
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
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;


public class SeniorProject extends FinalProjectMain {

    public static void student() throws IOException {

        Scanner keyboard = new Scanner(System.in);
        Scanner keyboard2 = new Scanner(System.in);
        Scanner keyboard3 = new Scanner(System.in);
        Scanner keyboard4 = new Scanner(System.in);
        Scanner keyboard5 = new Scanner(System.in);
        Scanner keyboard6 = new Scanner(System.in);
        Scanner keyboard7 = new Scanner(System.in);
        Scanner keyboard8 = new Scanner(System.in);
        Scanner keyboard9 = new Scanner(System.in);
        int amountClass;
        System.out.println("How many classes are you going to take?");
        amountClass = keyboard.nextInt();
        System.out.println("Please enter the classes you want to take. To return please press 0:");
        System.out.println("Example: (BCS102, MTH130, BUS101)");

        String selector;
        selector = keyboard2.nextLine();

        String[] classes = new String[amountClass];

        classes = selector.split(",");
        System.out.println("Please enter the days you would like to come to school.");
        System.out.println("Example: MW, TR, WF, M, T, R, F");
        String selector1;
        selector1 = keyboard3.nextLine();

        String[] days = new String[amountClass];
        days = selector1.split(",");

        System.out.println("Please enter the starting time");
        System.out.println("Example: 9:00 (900), 10:00 (1000), 2:00 (1400), ect.");
        String selector2;
        selector2 = keyboard4.nextLine();

        String[] startingTimes = new String[amountClass];

        startingTimes = selector2.split(",");

        System.out.println("Please enter the ending time");
        System.out.println("Example: 3:00 (1500), 5:00 (1700), 6:00 (1800), ect.");
        String selectorTime;
        selectorTime = keyboard5.nextLine();

        String[] endingTime = new String[amountClass];
        endingTime = selectorTime.split(",");

        System.out.println("Please enter first or last name of preffered professor: ");
        System.out.println("Example: give an example");

        String selectProfessor;
        selectProfessor = keyboard6.nextLine();
        String[] professor = new String[amountClass];

        professor = selectProfessor.split(",");

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

        String connectionUrl
                = "jdbc:sqlserver://bcs430-final-project.database.windows.net;"
                + "database=OASIS ASSISTANT;"
                + "user=farmingdale@bcs430-final-project;"
                + "password=bcs430w!;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";

        Statement state = null;
        ResultSet resultSet = null;
        for (int p = 0; p < classes.length; p++) {
            try {
                Connection con = DriverManager.getConnection(connectionUrl);
                String SQL = "SELECT top 1 * FROM dbo.OASISDATA2 WHERE CourseName = '" + classes[p] + "' and Days = '"
                        + days[p] + "' and Instructor like '%" + professor[p] + "%' and startTime >= " + startingTimes[p]
                        + " and endTime <= " + endingTime[p] + "";

                state = con.createStatement();
                resultSet = state.executeQuery(SQL);
                int i = 1;
                String format;
                while (resultSet.next()) {

//                    if (!resultSet.next())
//                    {
//                        SQL = "SELECT top 1 * FROM dbo.OASISDATA2 WHERE CourseName = '" + classes[p] + "' and Days = '"
//                        + days[p] + "' and startTime >= " + startingTimes[p] 
//                        + " and endTime <= " + endingTime + "";
//                        
//                    }
                    System.out.println(resultSet.getString(1)
                            + "    " + resultSet.getString(2) + "    " + resultSet.getString(3)
                            + "    " + resultSet.getString(4) + "    " + resultSet.getString(5)
                            + "    " + resultSet.getString(6) + "    " + resultSet.getString(7) + "    " + resultSet.getString(8)
                            + "    " + resultSet.getString(9) + "    " + resultSet.getString(10) + "    " + resultSet.getString(11));

//                    format = String.format("%-25s", resultSet.getString(1));
//                    format += String.format("%-40s", resultSet.getString(2));
//                    format += String.format("%-40s", resultSet.getString(3));
//                    format += String.format("%-40s", resultSet.getString(4));
//                    format += String.format("%-40s", resultSet.getString(5));
//                    format += String.format("%-40s", resultSet.getString(6));
//                    format += String.format("%-40s", resultSet.getString(7));
//                    format += String.format("%-40s", resultSet.getString(8));
//                    format += String.format("%-25s", resultSet.getString(9));
//                    format += String.format("%-25s", resultSet.getString(10));
//                    format += String.format("%-25s", resultSet.getString(11));
                    i++;

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

        menu();

    }

    public static void teacher() throws IOException {

        Scanner keyboard = new Scanner(System.in);
        Scanner keyboard2 = new Scanner(System.in);
        Scanner keyboard3 = new Scanner(System.in);
        Scanner keyboard4 = new Scanner(System.in);
        Scanner keyboard5 = new Scanner(System.in);
        Scanner keyboard6 = new Scanner(System.in);
        Scanner keyboard7 = new Scanner(System.in);
        Scanner keyboard8 = new Scanner(System.in);
        Scanner keyboard9 = new Scanner(System.in);

        int amountClass;
        System.out.println("How many classes do you want to teach?");
        amountClass = keyboard.nextInt();
        System.out.println("Please enter the classes you want to teach.");
        System.out.println("Example: (BCS102, MTH130, BUS101)");

        String selector;
        selector = keyboard2.nextLine();

        String[] classes = new String[amountClass];

        classes = selector.split(",");
        System.out.println("Please enter the days you would like to teach");
        System.out.println("Example: MW, TR, WF, M, T, R, F");
        String selector1;
        selector1 = keyboard3.nextLine();

        String[] days = new String[amountClass];
        days = selector1.split(",");

        System.out.println("Please enter the starting time");
        System.out.println("Example: 9:00, 10:00, 11:00, ect.");
        int selector2;
        selector2 = keyboard4.nextInt();

        int startingTimes;
        startingTimes = selector2;

        System.out.println("Please enter the ending time");
        System.out.println("Example: 4:00, 5:00, 6:00, ect.");
        int selectorTime;
        selectorTime = keyboard5.nextInt();

        int endingTime;
        endingTime = selectorTime;

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

        String connectionUrl
                = "jdbc:sqlserver://bcs430-final-project.database.windows.net;"
                + "database=OASIS ASSISTANT;"
                + "user=farmingdale@bcs430-final-project;"
                + "password=bcs430w!;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";

        Statement state = null;
        ResultSet resultSet = null;
        for (int p = 0; p < classes.length; p++) {
            try {
                Connection con = DriverManager.getConnection(connectionUrl);
                String SQL = "SELECT top 1 * FROM dbo.FacultyTest WHERE CourseName = '" + classes[p] + "' and Days = '"
                        + days[p] + "' and Instructor = 'tbd' and startTime >= " + startingTimes
                        + " and endTime <= " + endingTime + "";

                state = con.createStatement();
                resultSet = state.executeQuery(SQL);
                int i = 1;

                while (resultSet.next()) {

                    System.out.println(resultSet.getString(1)
                            + "    " + resultSet.getString(2) + "    " + resultSet.getString(3)
                            + "    " + resultSet.getString(4) + "    " + resultSet.getString(5)
                            + "    " + resultSet.getString(6) + "    " + resultSet.getString(7) + "    " + resultSet.getString(8)
                            + "    " + resultSet.getString(9) + "    " + resultSet.getString(10) + "    " + resultSet.getString(11));

                    i++;

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

        menu();

    }

    public static void administrator() throws FileNotFoundException, IOException {

        String Username;
        String Password;

        System.out.println("Farmingdale Oasis Assistant Login");
        System.out.println("---------------------------------");
        String[] pass = new String[2];
        do {
            System.out.print("Username: ");
            Scanner UNScan = new Scanner(System.in);
            Username = UNScan.next();
            
            System.out.print("Password: ");
            Scanner PWScan = new Scanner(System.in);
            Password = PWScan.next();

            // Store Login creds to text file
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\jorda\\Documents\\School Shtuffs\\Senior Project\\LoginTest\\LoginDB.txt"));
            String userFromFile, passFromFile, line;

            int i = 0;
            while ((line = br.readLine()) != null) {

                pass[i] = line;

                i++;
            }

            if (pass[0].equals(Username) && pass[1].equals(Password)) {
                Scanner keyboard = new Scanner(System.in);
                String selector;

                System.out.println("Welcome to the Admin Center");
                System.out.println("___________________________");
                System.out.println("Please type an option:");
                System.out.println("1. Update table");
                System.out.println("2. Add Record");
                System.out.println("3. Remove Record");
                System.out.println("4. Exit Admin Center");
                selector = keyboard.next();

                switch (selector) {
                    case "1":
                        updateTable();
                        break;
                    case "2":
                        addRecord();
                        break;
                    case "3":
                        removeRecord();
                        break;
                    case "4":
                        System.out.println("Hope you didn't break anything - IT");
                        menu();
                        break;

                    default:
                        System.out.println("Input is incorrect, try again.");
                        System.out.println();
                        menu();

                        break;
                }

            } else {
                System.out.println("Invalid credentials! Please try again");
            }

        } while (pass[0] != Username || pass[1] != Password);

    }

    public static void updateTable() throws IOException {
        System.out.println("Testing update table function");

        administrator();
    }

    public static void addRecord() throws IOException {
        System.out.println("Testing add record function");
        administrator();
    }

    public static void removeRecord() throws IOException {

        System.out.println("Testing remove record function");
        administrator();
    }

    public static void menu() throws IOException {
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

            default:
                System.out.println("Input is incorrect, try again.");
                System.out.println();
                menu();
        }

    }

}
