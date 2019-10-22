import java.io.*;
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
