package com.cester.view;

import java.util.Scanner;

import com.cester.controller.Controller;

/**
 * @author Utsav
 * @version 1.0.2
 */

public class UserMenu {
	
    /**
     * The main method is method starts and runs the application .
     * It displays a menu and handles user input to perform various operations on patient records.
     * @param args Command line arguments (not used).
     */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create an instance of controller object to run the application
		Controller ctlr = new Controller();
		
		// Create a Scanner object to read user input from the console
		Scanner sc = new Scanner(System.in);
		
		
		int choice = 0; // Variable for storing user's choice
		
		// Loop executes until the user chooses to exit (choice 6)
		while (choice != 6) {
			
			// Display the menu options
			
            System.out.println("Enter a number from 1 to 6:");
            
            System.out.println("===========================\n");
            
            System.out.println("Enter 1 To Display all Records");
            
            System.out.println("Enter 2 To Insert Record");
            
            System.out.println("Enter 3 To Update patient record by Id");
            
            System.out.println("Enter 4 To Get a single patient record");
            
            System.out.println("Enter 5 To Delete patient by Id");
            
            System.out.println("Enter 6 To Exit the application");
            
            System.out.print("Enter your choice: ");
            
         // Check if the user input is an integer
			if (sc.hasNextInt()) {
                choice = sc.nextInt(); // Read the user's choice

                
             // Run the program based on the user's choice
                switch (choice) {
                    case 1:
                        ctlr.displayAll(); // Display all records
                        break;
                    case 2:
                        ctlr.insertRec(); // Insert a new records
                        break;
                    case 3:
                        ctlr.updateRec(); // update a records
                        break;
                    case 4:
                        ctlr.findById(); // Find a record by Id
                        break;
                    case 5:
                        ctlr.deleteById(); // Delete a record by Id
                        break;
                    case 6:
                        System.exit(0); // Exit the application
                        break;
                    default:
                        System.out.println("\nInvalid option! Please enter a number from 1 to 6.\n");
                }
            } else {
            	// Display an error message if the user input is not an integer
                System.out.println("\nInvalid input! Please enter a valid number.\n");
                sc.next(); //Consume the invalid input to avoid an infinite loop
            }
        }

		
	}

}
