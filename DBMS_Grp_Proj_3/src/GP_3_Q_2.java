import java.sql.*;
import java.io.IOException;
import oracle.jdbc.OracleTypes;
public class GP_3_Q_2 {
	public static void main(String [] args) throws SQLException, ClassNotFoundException
	{
		System.out.println("Hello");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			Connection dbConnection = DriverManager.getConnection("jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu","byak0000","REin7Pi9");
			System.out.println(dbConnection);
		}
		catch(SQLException x)
		{
			System.out.println("Could not get the connection established");
		}
	}

}
