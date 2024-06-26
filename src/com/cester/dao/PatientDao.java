package com.cester.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cester.model.Patient;

/**
 * PatientDao class for database connectivity
 * */

public class PatientDao {
	
	/**
	 * This class provides methods to interact with the database table 'patients'.
	 */
	
	 /**
     * Establishes a connection to the database.
     * 
     * @return A Connection object representing the database connection.
     */
	
	public Connection setupConnection() { // This method returns a Connection Object.It uses DriverManager CLass to setup Connection using method getConnection()
		
		// create a variable of Connection type
		Connection con = null;
		
		//Write Credentials
		//jdbc:mysql://localhost:port/database_name
		String url = "jdbc:mysql://localhost:3306/PatientRecords"; 
		String user = "root";
//		String pwd = "12345"; // this is password for ranish
		//String pwd = "your_password"; // this is password for rahul
		String pwd = "122111"; // this is password for utsav
		
		//load the driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			// call the DriverManager class method
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection Successfull");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}
	
    /**
     * Retrieves all patient records from the database.
     * 
     * @return A list of Patient objects representing the patient records.
     */
	
	public List<Patient> displayPatientRecs(){
		List<Patient> patients = new ArrayList<>();
		
		//Call  the method for connection to database
		Connection con = setupConnection();
		String sql = "SELECT * FROM patients";
		
		// Statement interface is needed as it is a select query
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			//while result set has the record
			while(rs.next()) { //this gets the top row from the set
				Patient patient_from_top_row = new Patient(rs.getInt("Patientid"), 
						rs.getString("Name"), rs.getString("Contact"), rs.getString("Region"), 
						rs.getString("Disease"), rs.getDate("VisitDate"));
				
				patients.add(patient_from_top_row);
			}
			
			System.out.println(patients);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return patients;
	}
	
    /**
     * Inserts a new patient record into the database.
     * 
     * @param patient_rec The Patient object representing the record to be inserted.
     */
	
	public void insertPatientRec(Patient patient_rec) {
		// call the method for connection
		Connection con = setupConnection();
		
		String sql = "INSERT INTO patients (Patientid, Name, Contact, Region, Disease, VisitDate) "
				+ "Values(?,?,?,?,?,?)";
		
		// For question marks in a query we use prepared statement
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			// this gives setter methods so
			pstmt.setInt(1, patient_rec.getPatientid());
			pstmt.setString(2, patient_rec.getName());
			pstmt.setString(3, patient_rec.getContact());
			pstmt.setString(4, patient_rec.getRegion());
			pstmt.setString(5, patient_rec.getDisease());
			pstmt.setDate(6, new java.sql.Date(patient_rec.getVisitDate().getTime()));
			
			int status = pstmt.executeUpdate();
			
			if(status > 0) {
				System.out.println("Patient record inserted sucessfully!");
				displayPatientRecs();
			}
			else {
				System.out.println("Try again. Error occured. It happens!");
			}
			
		/**
		 * Catch block to handle SQLExceptions that might occur during database operations.
		 * 
		 * @param e The SQLException object representing the exception.
		 */	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
     * Retrieves a patient record from the database by its ID.
     * 
     * @param patientid_to_fetch_rec the Id of the patient to retrieve the record.
     * @return A Patient object representing the retrieved patient record.
     */
	
	public Patient getRecByPatientId(int patientid_to_fetch_rec) {
		
		// create a variable of Return Type Patient
		Patient patient_to_fetch_byId  = null;
		
		// call setupConnection to connect database
		Connection con = setupConnection();
		
		//Write the SQL Query
		
		String sql = "SELECT * FROM patients where Patientid=?";
		
		// For query with question marks we use PreparedStatement
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			// Use the Setter Method to set the value for question mark
			pstmt.setInt(1, patientid_to_fetch_rec);
			
			// call the execute query to get the result set
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// create an Patient object using top row in result set
				patient_to_fetch_byId = new Patient(rs.getInt("Patientid"), 
						rs.getString("Name"), rs.getString("Contact"), rs.getString("Region"), 
						rs.getString("Disease"), rs.getDate("VisitDate"));
				System.out.println(patient_to_fetch_byId);
			} else {
				System.out.println("\nId not found!! Please Try Again!\n");
			}
			
		/**
		 * Catch block to handle SQLExceptions that might occur during database operations.
		 * 
		 * @param e The SQLException object representing the exception.
		 */	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return patient_to_fetch_byId;
		
	}
	
	 /**
     * Deletes a patient record from the database by its ID.
     * 
     * @param patientid_to_delete The ID of the patient record to delete.
     */
	
	public void deletePatientRecById(int patientid_to_delete) {
		// call setupConnection()
		Connection con = setupConnection();
		
		//Write SQL Query
		String sql = "DELETE FROM patients WHERE Patientid=?";
		
		//For Query with question marks we use preparedStatement
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			// set the value for question mark
			pstmt.setInt(1, patientid_to_delete);
			
			// call executeUpdate() which returns 1 if query worked
			int status = pstmt.executeUpdate();
			
			if(status>0) {
				System.out.println("Patient Record Deleted Successfully!");
				displayPatientRecs();
			}
			else {
				System.out.println("\nId not found!! Please Try Again!\n");
			}
			
		/**
		 * Catch block to handle SQLExceptions that might occur during database operations.
		 * 
		 * @param e The SQLException object representing the exception.
		 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    /**
     * Updates a patient record in the database.
     * 
     * @param curr_patient_id The ID of the patient record to update.
     * @param update_patient The updated Patient object representing the new record details.
     */
	
	public void updatePatientRec(int curr_patient_id, Patient update_patient) {
		// call the method for connection
		Connection con = setupConnection();
		
		
		String sql = "UPDATE patients SET Patientid=?, Name=?, Contact=?, Region=?, Disease=?, VisitDate=? "
				+ "WHERE Patientid=?";
		
		// For question marks in a query we use prepared statement
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			// this gives setter methods so
			pstmt.setInt(1, update_patient.getPatientid());
			pstmt.setString(2, update_patient.getName());
			pstmt.setString(3, update_patient.getContact());
			pstmt.setString(4, update_patient.getRegion());
			pstmt.setString(5, update_patient.getDisease());
			pstmt.setDate(6, new java.sql.Date(update_patient.getVisitDate().getTime()));
			pstmt.setInt(7, curr_patient_id);
			
			int status = pstmt.executeUpdate();
			
			if(status > 0) {
				
				System.out.println("Patient record updated sucessfully!");
				displayPatientRecs();
			}
			else {
				System.out.println("\nId not found!! Please Try Again!\n");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
