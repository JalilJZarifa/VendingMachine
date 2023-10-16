import java.util.*;
import java.lang.System;
/**
 * Main class
 *
 * Jalil Zarifa
 * 8/12/22
 */
public class Main
{
    /**
     * The main method that will be called in order to start the SnackBar operation. It currently contains the start() method which essentially starts the
     * program.
     */
     public static void main(String[] args){
        start();
    }
    /**
     * The menu is the array of options displayed to the user after certain tasks have been executed. It gives the user a couple options which leads them
     * down different paths. Simply put, the user can either start the simulation again or exit the program.
     */
    static void menu() {
        int option;
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Options: ");
         System.out.println("1. Start again");
         System.out.println("2. Exit program");
         option = keyboard.nextInt();
         if(option == 1){
             start();
         }else if(option==2) {
             System.exit(0);
         }else {
             System.out.println("Please enter a valid option");
                menu();
         }
         
    }
    
     /**
      * The number of students, crisps and the cost of the snackBar object are left undeclared. This is to allow the user to make the decision. First a
      * scanner is implemented where it will welcome the user and then prompt them to enter the number of the required inputs as stated previously. The 
      * prompt allows the next input of the user to be used in the scanner and ultimately added to the currently undeclared ints.Once all the inputs have
      * been collected, they will then be added to the snackBar object and the user will be met with the two options of the snackBar methods, describe or
      * run. After running the program the user will be met with the menu() function. Otherwise they will describe the current state of the snack bar where
      * they will then be given the option to run it. After this, the menu() function is once again called.
      * 
      * There are a couple issues with this method. Firstly, the int's are only local to this method and so if I wanted to break down this method and 
      * make it more efficient by providing more options, it would prove difficult as I would first need to allow the ints to be local to the class 
      * rather than just the start method.
      * 
      * Additionally, there is a lack of validation. If the user were to input a char or a double when prompted, the program would simply crash and it 
      * would have to be run again. Although there is basic validation in the if statement (where if the user doesn't input 1 or 2, they're met with the 
      * basic menu function() ) This isn't enough to avoid the program essentially breaking.
      */
     static void start(){
        int numofstudents;
        int numofcrisps;
        int cost;
        int option;
        int steps;
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the Snack Bar!");
        System.out.println("Please enter the number of students you would like to attend the Snack Bar: ");
        numofstudents= keyboard.nextInt();
        System.out.println("Thanks! Now enter the number of crisps you would like to be in the Snack Machine: ");
        numofcrisps = keyboard.nextInt();
        System.out.println("Perfect! Lastly, we need to determine the cost of each crisp:");
        cost = keyboard.nextInt(); 
        
        snackBar snackbar = new snackBar(numofstudents, numofcrisps, cost);
        System.out.println("Now that's out the way, please choose one of these options:");
        System.out.println("1: Run Snack Bar");
        System.out.println("2: Describe current state of Snack Bar");
        option = keyboard.nextInt();
        if(option == 1){
             System.out.println("How many steps would you like the Snack Bar to go through?");
             steps = keyboard.nextInt();
             snackbar.runSnackBar(steps);
         }else if (option == 2){
             int a;
             snackbar.describe();
             System.out.println("Press 1 to run the snack bar!");
             a = keyboard.nextInt();
             if (a==1) {
                 System.out.println("How many steps would you like the Snack Bar to go through?");
                 steps = keyboard.nextInt();
                 snackbar.runSnackBar(steps);
             }
         }else {
             System.out.println("That's not a valid option");
             menu();
         }
         
        System.out.println("Thanks for simulating!");
        menu();
    }
}
