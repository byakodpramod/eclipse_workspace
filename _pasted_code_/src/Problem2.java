import java.sql.*;  
import java.io.*;
import java.lang.*;

public class Problem2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Connection conn = null;  
	    try {  
	    	 //Loading JDBC ODBC Driver
	      Class.forName("oracle.jdbc.driver.OracleDriver");    
	      System.out.println("Connecting to database...");    
	      // Creating an Oracle JDBC Connection with url, username and password
	      conn = DriverManager.getConnection("jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu","gann0001","DSlt3Dt5");
	      System.out.println(conn);
	     //Creating a JDBC Statement object
	      Statement stmt = conn.createStatement();
	      
	      // Creating instance of a buffer reader to read the input
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      
	      // While loop will be executed until you have provide the option 4 which is to terminate the program
	      while(true) {
	    	  
	    	   // Displaying options to execute 
	    	  	System.out.println("\nEnter the Options from the below list");
	    	  	System.out.println("1. Select to execute option 1");
	    	  	System.out.println("2. Select to execute option 2");
	    	  	System.out.println("3. Display Customers and Translators");
	    	  	System.out.println("4. Exit");
	    	  	
	    	  	//Reading input from user
	    	  	int choice = Integer.parseInt(br.readLine());
	    	  	switch(choice) {
	    	  	
	    	  	//Case 1 is to insert a new customer by reading Id, Name and level
	    	  	case 1:
	    	  		  System.out.println("Enter Customer ID");
	    		      int cid = Integer.parseInt(br.readLine());
	    		      System.out.println("Enter Customer NAME");
	    		    	  String cname = br.readLine();
	    		    	  System.out.println("Enter Level");
	    		    	  String level1 = br.readLine();
	    		    	  
	    		    	  // Callable statement is to call stored procedure 
	    		      CallableStatement procinsert = null;
	    		      procinsert = conn.prepareCall("{call CUST_INSERT_PROCEDURE(?,?,?,?)}");
	    		      System.out.println(procinsert);
	    		      procinsert.setInt(1,cid);
	    		      procinsert.setString(2,cname);
	    		      procinsert.registerOutParameter(3,Types.FLOAT);
	    		      procinsert.setString(4,level1);
	    		      procinsert.executeUpdate();
	    		      break;
	    		// Case 2 Updates salary of translators by 10% if name is provided otherwise, it salary will be increased by 5% for
	    		//        translator who translated more than equal to 3 books else by 2%     
	    	  	case 2:
	    	  		  System.out.println("Do you want to enter author name? Yes/No");
	    	  		  String author_option = br.readLine();
	    	  		  // Case for reading the Author Name
	    	  		  if (author_option.equals("yes")) {
	    	  			  System.out.println("Enter the Author Name");
	    	  			  String author_name = br.readLine();
	    	  			  CallableStatement procauthor = null;
	    	  			  // connecting the Author_sal procedure
		    		      procauthor = conn.prepareCall("{call AUTHOR_SAL(?)}");
		    		      procauthor.setString(1,author_name);
		    		      procauthor.executeUpdate();
		    		      System.out.println("Translators salaries for the author "+author_name+" has been incremented \n");
		    		      }
	    	  		  // Case if nome is not accepted, then default salary rate will be increased based on the no of translations 
	    	  		  if (author_option.equals("no")) {
	    	  			  CallableStatement procauthor = null;
	    	  			  // Connecting Author_sal2 procedure
		    		      procauthor = conn.prepareCall("{call AUTHOR_SAL2()}");
		    		      procauthor.executeUpdate();
		    		      System.out.println("Translators salaries has been incremented \n");
	    	  		      }
	    	  		   break;
	    	    // Case 3 Displays all the customer details and translator details
	    	  	case 3:
	    	  		    System.out.println("Customer table content");
	    	  			ResultSet rset = stmt.executeQuery("select * from customer");
	    	  			while(rset.next()) {
	    	  				System.out.println(rset.getString(1)+" "+ rset.getString(2)+" "+ rset.getString(3)+" "+ rset.getString(4));}
	    	  			System.out.println("\nTranslator table content");
	    	  			ResultSet rset1 = stmt.executeQuery("select * from translator");
	    	  			while(rset1.next()) {
	    	  				System.out.println(rset1.getString(1)+" "+ rset1.getString(2)+" "+ rset1.getString(3));}
	    	  			break;
	    	  	case 4:
	    	  		    System.exit(0);
	      }
	    }
	  }   
	    //This is to handle the exceptions if arise any
	    catch (Exception e) {    
	      e.printStackTrace();    
	    } 
	}

}
