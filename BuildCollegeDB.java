//BuildCollegeDB by Steven Conyers - 4/18/2022

import java.sql.*;

/* This program creates the College database. */

public class BuildCollegeDB {
	public static void main(String[] args) throws Exception {
		final String DB_URL = "jdbc:derby:CollegeDB;create=true";

		try {
			// Create a connection to the database.
			Connection conct = DriverManager.getConnection(DB_URL);

			// Create a Statement object.
			Statement stmt = conct.createStatement();

			// Drop tables in College database if it already exists
			dropTables(conct);

			// Build Student table
			buildStudentTable(conct);

			// Close connection
			conct.close();
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}

	// Drop tables method if any table already exists
	public static void dropTables(Connection conct) {
		System.out.println("Checking to see if tables exists..");

		try {
			// Get Statement object
			Statement stmt = conct.createStatement();

			try {
				// Drop Student table
				stmt.execute("DROP TABLE Student");
				System.out.println("Student table has been dropped");
			} catch (SQLException ex) {
				// Empty for table no longer exists
			}

			try {
				// Drop Major table
				stmt.execute("DROP TABLE Major");
				System.out.println("Major table has been dropped");
			} catch (SQLException ex) {
				// Empty for table no longer exists
			}
		} catch (SQLException ex) {
			System.out.print("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public static void buildStudentTable(Connection conct) {
		try {
			// Get Statement object
			Statement stmt = conct.createStatement();

			// Create the Student table.
			stmt.execute("CREATE TABLE Student (" + "Student_Num CHAR(5) PRIMARY KEY, " + "First_Name CHAR (25), "
					+ "Last_Name CHAR(30)," + "Major CHAR(5))");

			// Inserting Data into rows
			// Inserting into row 1
			stmt.execute("INSERT INTO Student VALUES" + "('976', 'Sidney', 'Dean',  'AAB')");

			// Inserting into row 2
			stmt.execute("INSERT INTO Student VALUES " + "('460', 'Clark', 'Kent', 'BFA' )");

			// Inserting into row 3
			stmt.execute("INSERT INTO Student VALUES" + "('112', 'Marcus', 'Fenix', 'BS')");

			// Inserting into row 4
			stmt.execute("INSERT INTO Student VALUES" + "('001', 'Matt', 'Stonie', 'BCA')");

			// Inserting into row 5
			stmt.execute("INSERT INTO Student VALUES" + "('290', 'Corvus', 'Glave', 'BCE')");

			System.out.println("Student table has been created");
		} catch (SQLException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}
}