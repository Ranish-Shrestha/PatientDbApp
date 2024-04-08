package com.cester.view;

import java.util.Scanner;

import java.util.InputMismatchException;

import com.cester.controller.Controller;

public class UserMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Controller ctlr = new Controller();
		
		Scanner sc = new Scanner(System.in);
		

		
		int choice = 0;
		
		while (choice != 6) {
            try {
                System.out.println("Enter a number from 1 to 6:");
                System.out.println("===========================\n");
                System.out.println("Enter 1 To Display all Records");
                System.out.println("Enter 2 To Insert Record");
                System.out.println("Enter 3 To Update patient record by Id");
                System.out.println("Enter 4 To Get a single patient record");
                System.out.println("Enter 5 To Delete patient by Id");
                System.out.println("Enter 6 To Exit the application");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                switch (choice) {
                
                    case 1:
                        ctlr.displayAll();
                        break;
                        
                    case 2:
                        ctlr.insertRec();
                        break;
                        
                    case 3:
                        ctlr.updateRec();
                        break;
                        
                    case 4:
                        ctlr.findById();
                        break;
                        
                    case 5:
                        ctlr.deleteById();
                        break;
                        
                    case 6:
                        
                        System.exit(0);
                        
                        break;
                        
                    default:
                        System.out.println("\nInvalid option! Please enter a number from 1 to 6.\n");
                }
                
                
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input! Please enter a valid number.\n");
                sc.next(); 
            }
        }
        sc.close();

			
	
	}

}
