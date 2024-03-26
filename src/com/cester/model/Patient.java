package com.cester.model;

import java.util.Date;

public class Patient {
	private int Patientid;
	private String Name;
	private String Contact;
	private String Region;
	private String Disease;
	private Date VisitDate;
	
	
	public int getPatientid() {
		return Patientid;
	}
	public void setPatientid(int patientid) {
		Patientid = patientid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public String getDisease() {
		return Disease;
	}
	public void setDisease(String disease) {
		Disease = disease;
	}
	public Date getVisitDate() {
		return VisitDate;
	}
	public void setVisitDate(Date visitDate) {
		VisitDate = visitDate;
	}
	
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Patient(int patientid, String name, String contact, String region, String disease, Date visitDate) {
		super();
		Patientid = patientid;
		Name = name;
		Contact = contact;
		Region = region;
		Disease = disease;
		VisitDate = visitDate;
	}
	
	@Override
	public String toString() {
		return "Patient [Patientid=" + Patientid + ", Name=" + Name + ", Contact=" + Contact + ", Region=" + Region
				+ ", Disease=" + Disease + ", VisitDate=" + VisitDate + "]\n";
	}
	
	
	
}
