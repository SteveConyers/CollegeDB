//CreateMajorTable by Steven Conyers - 4/18/2022

import java.sql.*;	//For JDBC classes

public class CreateMajorTable
{
   public static void main(String[] args)
   {
      //Named constant for the URL.
      final String DB_URL = "jdbc:derby:CollegeDB";
	  
      try
      {
         // Create a connection to the database.
         Connection conct = DriverManager.getConnection(DB_URL);

         // Get a Statement object.
         Statement stmt = conct.createStatement();
		 
         // Make an SQL statement to create the table.
         String sql = "CREATE TABLE Major" +
                      "( Major CHAR(5) PRIMARY KEY,  " +
                      " Description CHAR(50) )"; 

         // Execute the statement.
         stmt.execute(sql);

         // Add some rows to the Major table.
         sql = "INSERT INTO MAJOR VALUES" +
               "('AA', 'Associate of Arts')";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO MAJOR VALUES" +
               "('BFA', 'Bachelor of Fine Arts')";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO MAJOR VALUES" +
               "('BS', 'Bachelor of Science')";
         stmt.executeUpdate(sql);
         
         sql = "INSERT INTO MAJOR VALUES" +
               "('BCA', 'Bachelor of Computer Applications')";
         stmt.executeUpdate(sql);
         
         sql = "INSERT INTO MAJOR VALUES" +
               "('BCE', 'Bachelor of Civil Engineering')";
         stmt.executeUpdate(sql);   
         
         System.out.println("Major table created");
         System.out.println("Rows have been created");
      }
      catch (Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
}
