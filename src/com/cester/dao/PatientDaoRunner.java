package com.cester.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cester.model.Patient;

/**
 * The PatientDaoRunner class serves as a runner program to interact with the PatientDao class.
 * It demonstrates various operations such as displaying patient records, inserting, updating, and deleting records.
 */

public class PatientDaoRunner {
	
    /**
     * The main method is method starts and runs the application .
     * It displays a menu and handles user input to perform various operations on patient records.
     * @param args Command line arguments (not used).
     */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create an instance of PatientDao class to interact with the patient records
		PatientDao obj = new PatientDao();
		
		// display all patients
		obj.displayPatientRecs();
		
		// get patient details by patient id
		obj.getRecByPatientId(3);
		
		// use this SimpleDateFormat class to parse visit date from string type to date type
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date visitDate = null;
        try {
        	// Parse the visit date string into a Date object
            visitDate = dateFormat.parse("2024-01-04");
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
     // Create a new Patient object with specific details
		Patient pat = new Patient(7, "Morgan FreeMan", "416-111-2234", "Markham", "OCD", visitDate);
		
		// Insert the newly created patient record into the database
		obj.insertPatientRec(pat);
		
		 // Create a new Patient object with updated details
		Patient update_pat = new Patient(6, "Morgan", "965-623-8562", "Brampton", "OCD", visitDate);
		// needed current patient id to update the patient update details
		
		obj.updatePatientRec(7, update_pat); 
		
		// Delete the patient record with id 6 from the database
		obj.deletePatientRecById(6);
	}


}
