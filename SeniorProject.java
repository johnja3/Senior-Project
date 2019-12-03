
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
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import javax.swing.*;
import java.lang.*;
import java.lang.String;

public class SeniorProject extends FinalProject {

    public static void student() throws IOException {

        int width = 400;
        int height = 200;

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
        System.out.println("Example: Mary, Fried, etc. (If you don't have a preference add a space. for Example: Mary, ,Fried)");

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
        String[][] result = new String[classes.length][11];
        Statement state = null;
        ResultSet resultSet = null;
        for (int p = 0; p < classes.length; p++) {
            try {
                Connection con = DriverManager.getConnection(connectionUrl);
                String SQL = "SELECT * FROM dbo.OASISDATA2 WHERE CourseName = '" + classes[p] + "' and Days = '"
                        + days[p] + "' and Instructor like '%" + professor[p] + "%' and startTime >= " + startingTimes[p]
                        + " and endTime <= " + endingTime[p] + "";

                state = con.createStatement();
                resultSet = state.executeQuery(SQL);

                String format;
                while (resultSet.next()) {

                    for (int i = 0; i < 11; i++) {
                        result[p][i] = resultSet.getString(i + 1);

                    }

//                    if ()
//                    {
//                        System.out.println( classes[p] + " doesnt exist within the parameters you entered. ");
//                        System.out.println("Please enter new parameters:");
//                        
//                         System.out.println("Please enter the classes you want to take. To return please press 0:");
//        System.out.println("Example: (BCS102, MTH130, BUS101)");
//
//       
//        selector = keyboard2.nextLine();
//
//        
//
//        classes = selector.split(",");
//        System.out.println("Please enter the days you would like to come to school.");
//        System.out.println("Example: MW, TR, WF, M, T, R, F");
//      
//        selector1 = keyboard3.nextLine();
//
//      
//        days = selector1.split(",");
//
//        System.out.println("Please enter the starting time");
//        System.out.println("Example: 9:00 (900), 10:00 (1000), 2:00 (1400), ect.");
//     
//        selector2 = keyboard4.nextLine();
//
//
//        startingTimes = selector2.split(",");
//
//        System.out.println("Please enter the ending time");
//        System.out.println("Example: 3:00 (1500), 5:00 (1700), 6:00 (1800), ect.");
//       
//        selectorTime = keyboard5.nextLine();
//
//
//        endingTime = selectorTime.split(",");
//
//        System.out.println("Please enter first or last name of preffered professor: ");
//        System.out.println("Example: Mary, Fried, etc. (If you don't have a preference add a space. for Example: Mary, ,Fried)");
//
//      
//        selectProfessor = keyboard6.nextLine();
//     
//
//        professor = selectProfessor.split(",");
//                    }
                    System.out.println(resultSet.getString(1)
                            + "    " + resultSet.getString(2) + "    " + resultSet.getString(3)
                            + "    " + resultSet.getString(4) + "    " + resultSet.getString(5)
                            + "    " + resultSet.getString(6) + "    " + resultSet.getString(7) + "    " + resultSet.getString(8)
                            + "    " + resultSet.getString(9) + "    " + resultSet.getString(10) + "    " + resultSet.getString(11));

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("If a class you searched for does not appear, it may be unavailable. Search for a different class or change times-days");

        int studentNum;
        System.out.print("How many classes would you like to select: ");
        studentNum = keyboard6.nextInt();

        String crnStore;
        String[] crn = new String[studentNum];
        System.out.print("Enter the CRN numbers of the classes you would like to teach: ");
        crnStore = keyboard7.nextLine();
        crn = crnStore.split(",");

        connectionUrl
                = "jdbc:sqlserver://bcs430-final-project.database.windows.net;"
                + "database=OASIS ASSISTANT;"
                + "user=farmingdale@bcs430-final-project;"
                + "password=bcs430w!;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";

        Statement state2 = null;
        ResultSet resultSet2 = null;
        String format;
        String[] header = new String[]{"CRN", "Course Name", "Credit", "Title", "Days", "Start Time", "End Time", "Act", "Rem", "Instructor", "Location"};
        String headerOutput;

        headerOutput = String.format(" %-8s%-12s  %-24s %-26s%-8s %-11s %-11s %-9s %-15s %-20s %-15s", header[0], header[1], header[2], header[3], header[4], header[5], header[6], header[7], header[8], header[9], header[10]);
        System.out.println(headerOutput);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");

        for (int p = 0; p < studentNum; p++) {
            try {
                Connection con2 = DriverManager.getConnection(connectionUrl);
                String SQL = "SELECT * FROM dbo.OASISDATA2 WHERE CRN = '" + crn[p] + "'";

                state2 = con2.createStatement();
                resultSet2 = state2.executeQuery(SQL);

                while (resultSet2.next()) {

                    for (int i = 0; i < 11; i++) {
                        result[p][i] = resultSet2.getString(i + 1);

                    }

                    format = String.format("%-10s %-13s %-8s %-40s %-10s %-10s %-10s %-7s %-7s %-27s %-5s", resultSet2.getString(1), resultSet2.getString(2), resultSet2.getString(3), resultSet2.getString(4), resultSet2.getString(5),
                            resultSet2.getString(6), resultSet2.getString(7), resultSet2.getString(8), resultSet2.getString(9), resultSet2.getString(10), resultSet2.getString(11));

                    System.out.println(format);
//                    System.out.println(resultSet2.getString(1)
//                            + "    " + resultSet2.getString(2) + "    " + resultSet2.getString(3)
//                            + "    " + resultSet2.getString(4) + "    " + resultSet2.getString(5)
//                            + "    " + resultSet2.getString(6) + "    " + resultSet2.getString(7) + "    " + resultSet2.getString(8)
//                            + "    " + resultSet2.getString(9) + "    " + resultSet2.getString(10) + "    " + resultSet2.getString(11));

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");

//        JFrame frame = new JFrame("JOptionPane show MessageDialog");
//        for (int i = 0; i < studentNum; i++)
//        {
//        JOptionPane.showMessageDialog(frame, result[studentNum-i][0] + "    " + result[studentNum - i][1] + "   " + result[studentNum - i][2] + "   " + result[studentNum-i][3] + "    "+result[studentNum-i][4] + "  " + result[studentNum-i][5]
//        +"  " + result[studentNum-i][6] + "  " + result[studentNum - i][7] + "   " + result[studentNum-i][8] + "   " + result[studentNum-i][9] +"    " +result[studentNum-i][10] + "\n" + result[studentNum-i][0] + "    " + result[studentNum-i][1] + "   " + result[studentNum-i][2] + "   " + result[studentNum-i][3] + "    "+result[studentNum-i][4] + "  " + result[studentNum-i][5]
//        +"  " + result[studentNum-i-1][6] + "  " + result[studentNum - i][7] + "   " + result[i][8] + "   " + result[i][9] +"    " +result[i][10] + "\n");
//        
//        }
//        String[][] display2DArray = new String[studentNum][11];
//        
//        for (int i = 0; i < studentNum; i++) {
//            for (int j = 0; j < 10; j++) {
//                
//            }
//        }
//        ArrayList<String> output = new ArrayList<String>();
//        ArrayList<String> outputNew = new ArrayList<String>();
//        String newOutput;
//        for (int i = 0; i < studentNum; i++) {
//
//            for (int j = 0; j < 10; j++) {
//                output.add(result[i][j]);
//
//            }
//
//            output.add("\n");
//        }
//
//        newOutput = Arrays.toString(output.toArray()).replace("[", "").replace("]", "").replace(",", "").replace(" ", "      ");
//
//        JOptionPane.showMessageDialog(frame, String.format("%10", newOutput));
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

        String Username;
        String Password;
        String fullName;
        System.out.println("Farmingdale Professor Login");
        System.out.println("---------------------------------");
        String[] pass = new String[3];
        do {
            System.out.print("Username: ");
            Scanner UNScan = new Scanner(System.in);
            Username = UNScan.next();

            System.out.print("Password: ");
            Scanner PWScan = new Scanner(System.in);
            Password = PWScan.next();

            // Store Login creds to text file
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Jonathan\\Desktop\\SeniorProject\\SeniorProject\\SeniorProject\\LoginProfessor.txt"));

            String userFromFile, passFromFile, line;

            int i = 0;
            while ((line = br.readLine()) != null) {

                pass[i] = line;
                pass[2] = line;
                i++;
            }

            if (pass[0].equals(Username) && pass[1].equals(Password)) {

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

//        System.out.println("Please enter the starting time");
//        System.out.println("Example: 9:00, 10:00, 11:00, ect.");
//        int selector2;
//        selector2 = keyboard4.nextInt();
//
//        int startingTimes;
//        startingTimes = selector2;
//
//        System.out.println("Please enter the ending time");
//        System.out.println("Example: 4:00, 5:00, 6:00, ect.");
//        int selectorTime;
//        selectorTime = keyboard5.nextInt();
//
//        int endingTime;
//        endingTime = selectorTime;
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
                Statement state2 = null;
                Statement state3 = null;
                ResultSet resultSet = null;
                ResultSet resultSet2 = null;
                ResultSet resultSet3 = null;
                for (int p = 0; p < classes.length; p++) {
                    try {
                        Connection con = DriverManager.getConnection(connectionUrl);
                        String SQL = "SELECT * FROM dbo.FacultyTest WHERE CourseName = '" + classes[p] + "' and Days = '"
                                + days[p] + "' and Instructor = 'tbd' and startTime >= " + startingTimes[p]
                                + " and endTime <= " + endingTime[p] + "";

                        state = con.createStatement();
                        resultSet = state.executeQuery(SQL);

                        while (resultSet.next()) {

                            System.out.println(resultSet.getString(1)
                                    + "    " + resultSet.getString(2) + "    " + resultSet.getString(3)
                                    + "    " + resultSet.getString(4) + "    " + resultSet.getString(5)
                                    + "    " + resultSet.getString(6) + "    " + resultSet.getString(7) + "    " + resultSet.getString(8)
                                    + "    " + resultSet.getString(9) + "    " + resultSet.getString(10) + "    " + resultSet.getString(11));

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

                int professorNum;
                System.out.print("How many classes would you like to select: ");
                professorNum = keyboard6.nextInt();

                String crnStore;
                String[] crn = new String[professorNum];
                System.out.print("Enter the CRN numbers of the classes you would like to teach: ");
                crnStore = keyboard7.nextLine();
                crn = crnStore.split(",");

                connectionUrl
                        = "jdbc:sqlserver://bcs430-final-project.database.windows.net;"
                        + "database=OASIS ASSISTANT;"
                        + "user=farmingdale@bcs430-final-project;"
                        + "password=bcs430w!;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";

                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

                for (int p = 0; p < professorNum; p++) {
                    try {
                        Connection con = DriverManager.getConnection(connectionUrl);
                        Connection con2 = DriverManager.getConnection(connectionUrl);
                        Connection con3 = DriverManager.getConnection(connectionUrl);
                        String SQL = "UPDATE dbo.FacultyTest SET Instructor = '" + pass[2] + "' WHERE CRN = '" + crn[p] + "'";
                        String SQLoutput = "SELECT * FROM dbo.FacultyTest Where CRN = '" + crn[p] + "'";
                        String SQLReset = "UPDATE dbo.FacultyTest SET Instructor = 'TBD' WHERE CRN = '" + crn[p] + "'";

                        state = con.createStatement();
                        state2 = con2.createStatement();
                        state3 = con3.createStatement();
                        state2.executeUpdate(SQL);
                        resultSet3 = state3.executeQuery(SQLoutput);

                        while (resultSet3.next()) {

                            System.out.println(resultSet3.getString(1)
                                    + "    " + resultSet3.getString(2) + "    " + resultSet3.getString(3)
                                    + "    " + resultSet3.getString(4) + "    " + resultSet3.getString(5)
                                    + "    " + resultSet3.getString(6) + "    " + resultSet3.getString(7) + "    " + resultSet3.getString(8)
                                    + "    " + resultSet3.getString(9) + "    " + resultSet3.getString(10) + "    " + resultSet3.getString(11));

                        }
//                 state.executeUpdate(SQLReset);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
            } else {
                System.out.println("Invalid credentials! Please try again");
            }
        } while (pass[0] != Username || pass[1] != Password);
        menu();

    }

    public static void administrator() throws FileNotFoundException, IOException {

        String Username;
        String Password;

        System.out.println("Farmingdale Oasis Assistant Admin Login");
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
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Jonathan\\Desktop\\SeniorProject\\SeniorProject\\SeniorProject\\LoginAdmin.txt"));

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
        Scanner keyboard = new Scanner(System.in);
        Scanner keyboard2 = new Scanner(System.in);
        Scanner keyboard3 = new Scanner(System.in);

        String columnChange;
        System.out.println("What column would you like to change?");
        System.out.println("(CourseName, Cred, Title, Days, StartTime, Endtime, Act, Rem, Instructor, Location)");
        columnChange = keyboard.nextLine();

        String crn;
        System.out.println("What is the CRN of the course you are updating?:");
        crn = keyboard3.nextLine();

        String changeTo;
        System.out.println("What would you like to change it to?:");
        changeTo = keyboard2.nextLine();

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

        String connectionUrl
                = "jdbc:sqlserver://bcs430-final-project.database.windows.net;"
                + "database=OASIS ASSISTANT;"
                + "user=farmingdale@bcs430-final-project;"
                + "password=bcs430w!;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";
        String[] result = new String[11];
        Statement state = null;
        Statement state2 = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;

        try {
            Connection con = DriverManager.getConnection(connectionUrl);
            Connection con2 = DriverManager.getConnection(connectionUrl);
            String SQL = "UPDATE dbo.Admintest SET " + columnChange + " = '" + changeTo + "' where crn = '" + crn + "'";
            String SQLoutput = "Select * from dbo.Admintest where crn = '" + changeTo + "'";
            state = con.createStatement();
            state2 = con2.createStatement();
            state.executeUpdate(SQL);
            resultSet2 = state2.executeQuery(SQLoutput);
            int i = 1;
            String format;
            System.out.println("Here is your updated record!");
            while (resultSet2.next()) {

                System.out.println(resultSet2.getString(1)
                        + "    " + resultSet2.getString(2) + "    " + resultSet2.getString(3)
                        + "    " + resultSet2.getString(4) + "    " + resultSet2.getString(5)
                        + "    " + resultSet2.getString(6) + "    " + resultSet2.getString(7) + "    " + resultSet2.getString(8)
                        + "    " + resultSet2.getString(9) + "    " + resultSet2.getString(10) + "    " + resultSet2.getString(11));

                i++;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

        menu();
    }

    public static void addRecord() throws IOException {

        Scanner keyboard = new Scanner(System.in);

        String[] classes = new String[9];
        String tempClass;
        System.out.println("Enter course you would like to add in the following format!");
        System.out.println("EX. CRN, Course Name, Credit, Title, Days, Start Time, End Time, Instructor, Location");
        tempClass = keyboard.nextLine();
        classes = tempClass.split(",");

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

        String connectionUrl
                = "jdbc:sqlserver://bcs430-final-project.database.windows.net;"
                + "database=OASIS ASSISTANT;"
                + "user=farmingdale@bcs430-final-project;"
                + "password=bcs430w!;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";
        String[] result = new String[11];
        Statement state = null;
        Statement state2 = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;

        try {
            Connection con = DriverManager.getConnection(connectionUrl);
            Connection con2 = DriverManager.getConnection(connectionUrl);
            String SQL = "Insert into dbo.Admintest (CRN, CourseName, Cred, Title, Days, StartTime, EndTime, Act, Rem, Instructor, Location)"
                    + "Values ('" + classes[0] + "', '" + classes[1] + "', '" + classes[2] + "', '" + classes[3] + "', '" + classes[4] + "', "
                    + classes[5] + ", " + classes[6] + ", '0', '30', '" + classes[7] + "', '" + classes[8] + "')";
            String SQLoutput = "Select * from dbo.Admintest where crn = '" + classes[0] + "'";
            state = con.createStatement();
            state2 = con2.createStatement();
            state.executeUpdate(SQL);
            resultSet2 = state2.executeQuery(SQLoutput);
            int i = 1;
            String format;
            System.out.println("Here is your added class!");
            while (resultSet2.next()) {

                System.out.println(resultSet2.getString(1)
                        + "    " + resultSet2.getString(2) + "    " + resultSet2.getString(3)
                        + "    " + resultSet2.getString(4) + "    " + resultSet2.getString(5)
                        + "    " + resultSet2.getString(6) + "    " + resultSet2.getString(7) + "    " + resultSet2.getString(8)
                        + "    " + resultSet2.getString(9) + "    " + resultSet2.getString(10) + "    " + resultSet2.getString(11));

                i++;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

        menu();
    }

    public static void removeRecord() throws IOException {

        Scanner keyboard = new Scanner(System.in);

        String crn;
        System.out.println("Enter the CRN you want to remove: ");
        crn = keyboard.next();

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

        String connectionUrl
                = "jdbc:sqlserver://bcs430-final-project.database.windows.net;"
                + "database=OASIS ASSISTANT;"
                + "user=farmingdale@bcs430-final-project;"
                + "password=bcs430w!;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";
        String[] result = new String[11];
        Statement state = null;
        Statement state2 = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;

        try {
            Connection con = DriverManager.getConnection(connectionUrl);
            Connection con2 = DriverManager.getConnection(connectionUrl);
            String SQL = "Delete from dbo.Admintest where crn = '" + crn + "'";
            String SQLoutput = "Select * from dbo.Admintest where crn = '" + crn + "'";
            state = con.createStatement();
            state2 = con2.createStatement();
            state.executeUpdate(SQL);
            resultSet2 = state2.executeQuery(SQLoutput);
            int i = 1;
            String format;
            System.out.println("Record deleted!");
            while (resultSet2.next()) {

                System.out.println(resultSet2.getString(1)
                        + "    " + resultSet2.getString(2) + "    " + resultSet2.getString(3)
                        + "    " + resultSet2.getString(4) + "    " + resultSet2.getString(5)
                        + "    " + resultSet2.getString(6) + "    " + resultSet2.getString(7) + "    " + resultSet2.getString(8)
                        + "    " + resultSet2.getString(9) + "    " + resultSet2.getString(10) + "    " + resultSet2.getString(11));

                System.out.println("Class has been deleted!");
                i++;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

        menu();
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
