//ViewTableData by Steven Conyers - 4/19/2022

import java.sql.*; //Needed for JDBC classes

/* This program  uses the SQL Select statement
     to view data from created tables */

public class ViewTableData
{
   public static void main(String[] args)
   {
      // Create a named constant for the URL.
      final String DB_URL = "jdbc:derby:CollegeDB";
      
      try
      {
         // Create a connection to the database.
         Connection conct = DriverManager.getConnection(DB_URL);
         
         // Create a Statement object.
         Statement stmt = conct.createStatement();
         
         // Create a string with a SELECT statement.
         String sqlStatement =  "SELECT S.Student_Num, S.First_Name, S.Last_Name, M.Major, M.Description FROM Student S, Major M WHERE S.Major = M.Major";
         						
         
         // Send the statement to the DBMS.
         ResultSet result = stmt.executeQuery(sqlStatement);
         
         // Display a header for the listing.
         System.out.println("Database of all students");
         System.out.println("--------------------------------");
         
         // Display the contents of the result set.
         // The result set will have three columns.
         while (result.next())
         {
            System.out.println(result.getString("Student_Num") +
                               result.getString("First_Name") +
                               result.getString("Last_Name") +
                               result.getString("Major") +
                               result.getString("Description"));
         }
         
         // Close the connection.
         conct.close();
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
}