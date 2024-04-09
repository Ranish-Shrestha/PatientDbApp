package com.cester.model;

import java.util.Date;


/**
 * @author Ranish
 * @version 1.0.1 
 */

/**
 * Represents a Patient table with various attributes such as id, name, contact, region, disease, and visit date.
 */

public class Patient {
	
	// Private fields for patients
	private int Patientid; 
	private String Name;
	private String Contact;
	private String Region;
	private String Disease;
	private Date VisitDate;
	
	
    /**
     * Retrieves the patient Id.
     * @return The patient Id.
     */
	
	// Getters and setters for the private fields 
	public int getPatientid() {
		return Patientid;
	}
	
	
	/**
     * Sets the patient ID.
     * @param patientid The patient ID to set.
     */
	
	public void setPatientid(int patientid) {
		Patientid = patientid;
	}
	
	 /**
     * Retrieves the name of the patient.
     * @return The name of the patient.
     */
	
	public String getName() {
		return Name;
	}
	
	/**
     * Sets the name of the patient.
     * @param name The name of the patient to set.
     */
	
	public void setName(String name) {
		Name = name;
	}
	
	
	/**
     * Retrieves the contact information of the patient.
     * @return The contact information of the patient.
     */
	
	
	public String getContact() {
		return Contact;
	}
	
	
	/**
     * Sets the contact information of the patient.
     * @param contact The contact information of the patient to set.
     */
	
	public void setContact(String contact) {
		Contact = contact;
	}
	
	/**
     * Retrieves the region where the patient resides.
     * @return The region where the patient resides.
     */
	
	public String getRegion() {
		return Region;
	}
	
	  /**
     * Sets the region where the patient resides.
     * @param region The region where the patient resides to set.
     */
	
	public void setRegion(String region) {
		Region = region;
	}
	
	/**
     * Retrieves the disease diagnosed for the patient.
     * @return The disease diagnosed for the patient.
     */
	
	public String getDisease() {
		return Disease;
	}
	
	/**
     * Sets the disease diagnosed for the patient.
     * @param disease The disease diagnosed for the patient to set.
     */
	
	public void setDisease(String disease) {
		Disease = disease;
	}
	
	/**
     * Retrieves the date of the patient's visit.
     * @return The date of the patient's visit.
     */
	
	public Date getVisitDate() {
		return VisitDate;
	}
	
	/**
     * Sets the date of the patient's visit.
     * @param visitDate The date of the patient's visit to set.
     */
	
	public void setVisitDate(Date visitDate) {
		VisitDate = visitDate;
	}
	
	
    /**
     * Default constructor for the Patient class.
     */
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
     * Constructor with parameters to initialize a patient with specific attributes.
     * @param patientid The patient ID.
     * @param name The name of the patient.
     * @param contact The contact information of the patient.
     * @param region The region where the patient resides.
     * @param disease The disease diagnosed for the patient.
     * @param visitDate The date of the patient's visit.
     */
	
	// Constructor with parameters to initialize a patient with all attributes
	public Patient(int patientid, String name, String contact, String region, String disease, Date visitDate) {
		super();
		Patientid = patientid;
		Name = name;
		Contact = contact;
		Region = region;
		Disease = disease;
		VisitDate = visitDate;
	}
	
	
    /**
     * Returns a string representation of the patient object.
     * @return A string representation of the patient object.
     */
	
	// Override toString() method to provide a string representation of the patient object
	@Override
	public String toString() {
		return "Patient [Patientid=" + Patientid + ", Name=" + Name + ", Contact=" + Contact + ", Region=" + Region
				+ ", Disease=" + Disease + ", VisitDate=" + VisitDate + "]\n";
	}
	
	
	
}
