package com.cester.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.cester.dao.PatientDao;
import com.cester.model.Patient;

public class Controller {
	PatientDao p_dao = new PatientDao();
	
	Scanner sc = new Scanner(System.in);
	
	public void displayAll() {
		System.out.println("\n\nWelcome to Display Patient Records Option in our Application!!!");
		
		p_dao.displayPatientRecs();
	}
	
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
		
		System.out.print("Please enter the visit date of new Patient: ");
		String visit_date  = sc.nextLine();
		
		// use this SimpleDateFormat class to parse visit date from string type to date type
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date visitDate = null;
        try {
            visitDate = dateFormat.parse(visit_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		// Create an Patient Object to store in Database
		Patient pat_to_add = new Patient(id, name, contact, region, disease, visitDate);
		
		// call the insertRec() method and pass this employee as an object
		p_dao.insertPatientRec(pat_to_add);
	}
	
	public void updateRec() {
		System.out.println("\n\nWelcome to Update Patient Record Option in our Application!!!");
		
		// get the user input for Patient Object properties
		System.out.print("Please enter the Id of the Patient you want to update: ");
		int curr_id = sc.nextInt();
		
		// Consume the space to take String input for name after integer input id
		sc.nextLine();
		
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
		
		System.out.print("Please enter the new visit date of Patient: ");
		String upd_visit_date  = sc.nextLine();
		
		// use this SimpleDateFormat class to parse visit date from string type to date type
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date upd_visitDate = null;
        try {
        	upd_visitDate = dateFormat.parse(upd_visit_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		        
		// Create an Patient Object to store in Database
		Patient pat_to_update = new Patient(upd_id, upd_name, upd_contact, upd_region, upd_disease, upd_visitDate);
		
		// call the updatePatientRec() method and pass this employee as an object
		p_dao.updatePatientRec(curr_id, pat_to_update);
	}
	
	public void findById() {
		System.out.println("\n\n-------------------------------------------------------------------");
		System.out.println("Welcome to Find Patient Record By Id Optioin in our Application!!!");
		System.out.println("-------------------------------------------------------------------");
		
		System.out.print("Please Enter the Id of Patient to Get Record From Database: ");
		int id_to_fetch_rec = sc.nextInt();
		
		// pass this id to Dao Class method as an argument
		
		p_dao.getRecByPatientId(id_to_fetch_rec);
	}
	
	public void deleteById() {
		System.out.println("\n\n-------------------------------------------------------------------");
		System.out.println("Welcome to Delete Patient Record By Id Optioin in our Application!!!");
		System.out.println("-------------------------------------------------------------------");
		
		System.out.print("Please Enter the Id of Patient to Delete Record From Database: ");
		int id_to_delete_rec = sc.nextInt();
		
		// pass this id to Dao Class method as an argument
		
		p_dao.deletePatientRecById(id_to_delete_rec);
	}

}
