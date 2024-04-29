//InsertStudent by Steven Conyers - 4/19/2022

import java.util.Scanner;
import java.sql.*;

//This program lets the user insert a row into the Student table of the CollegeDB database

public class InsertStudent
{
   public static void main(String[] args)
   {
      String stuNum;	 //Holds student number
      String fname;      //Holds first name
      String lname;		 //Holds last name
      String major;	 	 //Holds major
      String desc;		 //Holds major description
      
      // Create a named constant for the URL.
      final String DB_URL = "jdbc:derby:CollegeDB";
      
      // Create a Scanner object for user input from keyboard.
      Scanner input = new Scanner(System.in);
      
      try
      {
         // Create a connection to the database.
         Connection conct = DriverManager.getConnection(DB_URL);
         
         System.out.println("Insert Student(s) into Student table");
         
         // Get data for new student.
         System.out.print("Enter the student number:     ");
         stuNum = input.nextLine();
         System.out.print("Enter students first name:    ");
         fname = input.nextLine();
         System.out.print("Enter students last name:     ");
         lname = input.nextLine();
         System.out.print("Enter the Students major:     ");
         major = input.nextLine();
         System.out.print("Enter the major description:  ");
         desc = input.nextLine();
         
         // Create a Statement object.
         Statement stmt = conct.createStatement();
         
         // Create a string with an INSERT statement.
         String sqlStatement = "INSERT INTO Student " + "(Student_Num, First_Name, Last_Name, Major)" + "VALUES " +
                               "('" + stuNum + "', '" + fname + "', '" + lname + "', '" + major + "')";
         
         String SqlStatement2 = "INSERT INTO MAJOR " + "(Major, Description)" + "VALUES" + 
        		 			    "('" + major + "', '" + desc + "')";
         
         // Send the statement to the DBMS.
         int rows = stmt.executeUpdate(sqlStatement);
         int rows2 = stmt.executeUpdate(SqlStatement2);
         
         // Display the results.
         System.out.println(rows + " row(s) added to the Student table.");
         System.out.println(rows2 + " row(s) added to the Major table.");
         
         // Close the connection.
         conct.close();
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
}
