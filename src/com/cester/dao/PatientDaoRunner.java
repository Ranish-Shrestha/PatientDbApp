package com.cester.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cester.model.Patient;

public class PatientDaoRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PatientDao obj = new PatientDao();
		
		// display all patients
		obj.displayPatientRecs();
		
		// get patient details by patient id
		obj.getRecByPatientId(3);
		
		// use this SimpleDateFormat class to parse visit date from string type to date type
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date visitDate = null;
        try {
            visitDate = dateFormat.parse("2024-01-04");
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		Patient pat = new Patient(7, "Morgan FreeMan", "416-111-2234", "Markham", "OCD", visitDate);
		obj.insertPatientRec(pat);
		
		Patient update_pat = new Patient(6, "Morgan", "965-623-8562", "Brampton", "OCD", visitDate);
		// needed current patient id to update the patient update details
		obj.updatePatientRec(7, update_pat); 
		
		obj.deletePatientRecById(6);
	}


}
