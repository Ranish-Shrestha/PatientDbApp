package com.cester.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.cester.dao.PatientDao;
import com.cester.model.Patient;


/**
 * @author Rahul
 * @version 1.0.3
 */

/**
 * Controller class to handle interactions between user inputs and DAO operations.
 */

public class Controller {
	
	// create an instance object to interact with patient records
	PatientDao p_dao = new PatientDao();
	
	// Create a Scanner object to read user input from the console
	Scanner sc = new Scanner(System.in);
	
	
    /**
     * Method to display all patient records.
     */
	public void displayAll() {
		System.out.println("\n\nWelcome to Display Patient Records Option in our Application!!!");
		
		// Call the displayPatientRecs() method from PatientDao to display all records
		p_dao.displayPatientRecs();
	}
	
	
    /**
     * Method to insert a new patient record.
     */
	public void insertRec() {
		System.out.println("\n\nWelcome to Insert Patient Record Option in our Application!!!");
		
		// get the user input for Patient Object properties
		System.out.print("Please enter the Id of new Patient: ");
		int id = sc.nextInt();
		
		// Consume the space to take String input for name after integer input id
		sc.nextLine();
		
		System.out.print("Please enter the name of new Patient: ");
		String name = sc.nextLine();
		
		System.out.print("Please enter the contact of new Patient: ");
		String contact = sc.nextLine();
		
		System.out.print("Please enter the region of new Patient: ");
		String region = sc.nextLine();

		System.out.print("Please enter the disease of new Patient: ");
		String disease  = sc.nextLine();
		
		// Parse the visit date value entered by the user
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date visitDate = null;

        boolean validDate = false;
        while (!validDate) {
            System.out.print("Please enter the new visit date of Patient (yyyy-MM-dd): ");
            String visit_date = sc.nextLine();

            try {
                visitDate = dateFormat.parse(visit_date);
                validDate = true;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
            }
        }
		
		// Create an Patient Object to store in Database
		Patient pat_to_add = new Patient(id, name, contact, region, disease, visitDate);
		
		// call the insertRec() method and pass this employee as an object
		p_dao.insertPatientRec(pat_to_add);
	}
	
	 /**
     * Method to update a patient record.
     */
	public void updateRec() {
		System.out.println("\n\nWelcome to Update Patient Record Option in our Application!!!");
		
		// get the user input for Patient Object properties
		System.out.print("Please enter the Id of the Patient you want to update: ");
		int curr_id = sc.nextInt();
		
		// Consume the space to take String input for name after integer input id
		sc.nextLine();
		
		
		// Get user input for the new details of the patient
		System.out.print("Please enter the new Id of Patient: ");
		int upd_id = sc.nextInt();
		
		// Consume the space to take String input for name after integer input id
		sc.nextLine();
		
		System.out.print("Please enter the new name of Patient: ");
		String upd_name = sc.nextLine();
		
		System.out.print("Please enter the new contact of Patient: ");
		String upd_contact = sc.nextLine();
		
		System.out.print("Please enter the new region of Patient: ");
		String upd_region = sc.nextLine();

		System.out.print("Please enter the new disease of Patient: ");
		String upd_disease = sc.nextLine();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date upd_visitDate = null;

        boolean validDate = false;
        while (!validDate) {
            System.out.print("Please enter the new visit date of Patient (yyyy-MM-dd): ");
            String upd_visit_date = sc.nextLine();

            try {
                upd_visitDate = dateFormat.parse(upd_visit_date);
                validDate = true;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
            }
        }
		        
		// Create an Patient Object to store in Database
		Patient pat_to_update = new Patient(upd_id, upd_name, upd_contact, upd_region, upd_disease, upd_visitDate);
		
		// call the updatePatientRec() method and pass this employee as an object
		p_dao.updatePatientRec(curr_id, pat_to_update);
	}
	
    /**
     * Method to find a patient record by Id.
     */
	public void findById() {
		System.out.println("\n\n-------------------------------------------------------------------");
		System.out.println("Welcome to Find Patient Record By Id Optioin in our Application!!!");
		System.out.println("-------------------------------------------------------------------");
		
		// Get user input to find patient from the Id 
		System.out.print("Please Enter the Id of Patient to Get Record From Database: ");
		int id_to_fetch_rec = sc.nextInt();
		
		// pass this id to Dao Class method as an argument
		p_dao.getRecByPatientId(id_to_fetch_rec);
	}
	
    /**
     * Method to delete a patient record by ID.
     */
	public void deleteById() {
		System.out.println("\n\n-------------------------------------------------------------------");
		System.out.println("Welcome to Delete Patient Record By Id Optioin in our Application!!!");
		System.out.println("-------------------------------------------------------------------");
		
		// Get user input for the ID of the patient to delete
		System.out.print("Please Enter the Id of Patient to Delete Record From Database: ");
		int id_to_delete_rec = sc.nextInt();
		
		// pass this id to Dao Class method as an argument
		p_dao.deletePatientRecById(id_to_delete_rec);
	}

}
