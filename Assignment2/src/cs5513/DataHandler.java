package cs5513;

//import all necessary libraries
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.lang.*;
import oracle.jdbc.pool.OracleDataSource;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import oracle.jdbc.driver.OracleDriver;

public class DataHandler {
		String jdbcUrl = "jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu";
		static String userid = "gann0001"; 
		static String pword = "YDpg7Sj4";
		Connection conn;
		Statement stmt;
		ResultSet rset;
		String query;
		String sqlString, sqlString2, sqlString3;
		
		private static void connectionOracle() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		public static Connection connectionToOracle() {
			connectionOracle();
			String host = "jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu";
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(host, userid, pword);
				System.out.println(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}

		
		public boolean authenticateUser(String username, String password) throws ClassNotFoundException, SQLException {
				//this.jdbcUrl= jdbcUrl;
				//this.userid = username;
				//this.password = password;
//				OracleDataSource ds;
//				ds = new OracleDataSource();
//				ds.setURL(jdbcUrl);
//				conn = ds.getConnection(userid, password); //connect to DB
				if(username.equals(userid) && password.equals(pword)) {
					conn = connectionToOracle();
				//conn = DriverManager.getConnection("jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu","gann0001","YDpg7Sj4");
				return true;
				}
				else {
					System.out.println("Invalid user credentials");
					return false;
				}	
			}
		public String query1(String pid, String name, String sex, String address,int day_ad,int month_ad, int year_ad, int day_dis,int month_dis, int year_dis, String contactno1, String contactno2) throws SQLException,FileNotFoundException {
			conn = connectionToOracle();
			if(conn != null) {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			sqlString = "INSERT INTO PATIENT_TAB VALUES ('" + pid + "','" + name + "','" + sex + "','" + address + "', STAY_PERIOD_TYP(DATE_ADMITTED_TYP(" + day_ad + "," + month_ad + "," + year_ad + "),DATE_DISCHARGED_TYP(" + day_dis + "," + month_dis + "," + year_dis + ")), CONTACT_NO_TYP('" + contactno1 + "','" + contactno2 + "'))";
			System.out.println("\nInserting: " + sqlString);
			stmt.execute(sqlString); //execute the query
			// got here, it is time to return the success status
			return "Success";
			}
			else {
				return "failed";
			}
	}
		public String query2(int eid, String name, String contact_no, String sex,int salary,String street, String city, String state, int zipcode, String level) throws SQLException,FileNotFoundException {
			conn = connectionToOracle();
			if(conn != null) {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			sqlString = "INSERT INTO NURSE_TAB VALUES (" + eid + ",'" + name + "','" + contact_no + "','" + sex + "'," + salary + ", E_ADDRESS_TYP('" + street + "','" + city + "','" + state + "'," + zipcode + "), '"+ level +"')";
			System.out.println("\nInserting: " + sqlString);
			stmt.execute(sqlString); //execute the query
			return "Success";
			}
			else {
				return "failed";
			}
	}
		
		public String query3(int eid, String name, String contact_no, String sex,int salary,String street, String city, String state, int zipcode, String specialization, int pid) throws SQLException,FileNotFoundException {
			conn = connectionToOracle();
			if(conn != null) {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			sqlString = "INSERT INTO DOCTOR_TAB VALUES (" + eid + ",'" + name + "','" + contact_no + "','" + sex + "'," + salary + ", E_ADDRESS_TYP('" + street + "','" + city + "','" + state + "'," + zipcode + "), '"+ specialization +"')";
			System.out.println("\nInserting: " + sqlString);
			stmt.execute(sqlString); //execute the query
			sqlString2 = "INSERT INTO CARES_TAB SELECT REF(P), REF(D) FROM PATIENT_TAB P, DOCTOR_TAB D WHERE P.PID = " + pid + " AND D.EID = " + eid + "";
			System.out.println("\nInserting: " + sqlString2);
			stmt.execute(sqlString2); //execute the query
			return "Success";
			}
			else {
				return "failed";
			}
	}
		
		public String query4(String roomid, String roomtype, int pid, int eid) throws SQLException,FileNotFoundException {
			conn = connectionToOracle();
			if(conn != null) {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			sqlString = "INSERT INTO ROOM_TAB VALUES ('" + roomid + "','" + roomtype + "')";
			System.out.println("\nInserting: " + sqlString);
			stmt.execute(sqlString); //execute the query
			sqlString2 = "INSERT INTO ASSIGNED_TAB SELECT REF(P), REF(R) FROM PATIENT_TAB P, ROOM_TAB R WHERE P.PID = " + pid + " AND R.ROOM_ID = '" + roomid + "'";
			System.out.println("\nInserting: " + sqlString2);
			stmt.execute(sqlString2); //execute the query
			sqlString3 = "INSERT INTO ATTENDS_TO_TAB SELECT REF(N), REF(R) FROM NURSE_TAB N, ROOM_TAB R WHERE N.EID = " + eid + " AND R.ROOM_ID = '" + roomid + "'";
			System.out.println("\nInserting: " + sqlString3);
			stmt.execute(sqlString3); //execute the query
			return "Success";
			}
			else {
				return "failed";
			}
	}
		
		public String query5(String code, String medname, int pid, int quantity) throws SQLException,FileNotFoundException {
			conn = connectionToOracle();
			if(conn != null) {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			sqlString = "INSERT INTO MEDICINE_TAB VALUES ('" + code + "','" + medname + "')";
			System.out.println("\nInserting: " + sqlString);
			stmt.execute(sqlString); //execute the query
			sqlString2 = "INSERT INTO IS_GIVEN_TAB SELECT " + quantity + ", REF(P), REF(M) FROM PATIENT_TAB P, MEDICINE_TAB M WHERE P.PID =  " + pid + " AND M.CODE = '" + code + "'";
			System.out.println("\nInserting: " + sqlString2);
			stmt.execute(sqlString2); //execute the query
			return "Success";
			}
			else {
				return "failed";
			}
	}
		
		public ResultSet query6(int month,int year) throws SQLException {
			conn = connectionToOracle();
			ResultSet rset = null;
			if(conn != null) {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			sqlString = "select p.pid, p.name, p.sex, p.address, p.stay_period.date_admitted.day, "
					+ "p.stay_period.date_admitted.month, p.stay_period.date_admitted.year, "
					+ "p.stay_period.date_discharged.day, p.stay_period.date_discharged.month, "
					+ "p.stay_period.date_discharged.year, p.contact_no from patient_tab p "
					+ "WHERE (p.stay_period.date_admitted.year <= " + year + "AND "
							+ "p.stay_period.date_discharged.year>=" + year + " ) AND "
									+ "(p.stay_period.date_admitted.month= " + month + ") OR "
											+ "(p.stay_period.date_admitted.month < " + month + " AND "
													+ "p.stay_period.date_discharged.month >=" + month + ")";
			System.out.println("\nSelect Query: " + sqlString);
			rset = stmt.executeQuery(sqlString);
			if(rset == null) System.out.println(rset);
			return rset;
			}
			else {
				System.out.println("Error in Connection");
				return rset;
			}
			}
		
		public ResultSet query7() throws SQLException {
			conn = connectionToOracle();
			ResultSet rset = null;
			if(conn != null) {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			sqlString = "SELECT D.EID, D.E_NAME, D.CONTACT_NO, D.SEX, D.SALARY, D.E_ADDRESS.STREET, D.E_ADDRESS.CITY, D.E_ADDRESS.STATE, D.E_ADDRESS.ZIPCODE, D.SPECIALIZATION " + 
					"FROM DOCTOR_TAB D INNER JOIN CARES_TAB C ON D.EID = (C.EID).EID GROUP BY D.EID, D.E_NAME, D.CONTACT_NO, D.SEX, D.SALARY, D.E_ADDRESS.STREET, D.E_ADDRESS.CITY, D.E_ADDRESS.STATE, D.E_ADDRESS.ZIPCODE, D.SPECIALIZATION HAVING COUNT((C.PID).PID) > 2"; 
			System.out.println("\nSelect Query: " + sqlString);
			rset = stmt.executeQuery(sqlString);
			if(rset == null) System.out.println(rset);
			return rset;
			}
			else {
				System.out.println("Error in Connection");
				return rset;
			}
			}
		
		public ResultSet query8(String code) throws SQLException {
			conn = connectionToOracle();
			ResultSet rset = null;
			if(conn != null) {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			sqlString = "SELECT N.EID, N.E_NAME, N.CONTACT_NO, N.SEX, N.SALARY, N.E_ADDRESS.STREET, N.E_ADDRESS.CITY, N.E_ADDRESS.STATE, N.E_ADDRESS.ZIPCODE, N.LEVEL1\n" + 
					"FROM NURSE_TAB N \n" + 
					"INNER JOIN ATTENDS_TO_TAB AT ON N.EID = (AT.EID).EID\n" + 
					"INNER JOIN ROOM_TAB R ON  (AT.ROOM_ID).ROOM_ID= R.ROOM_ID\n" + 
					"INNER JOIN ASSIGNED_TAB A ON R.ROOM_ID = (A.ROOM_ID).ROOM_ID\n" + 
					"INNER JOIN IS_GIVEN_TAB IG ON (A.PID).PID = (IG.PID).PID\n" + 
					"WHERE (IG.CODE).CODE = '" + code + "'"; 
			System.out.println("\nSelect Query: " + sqlString);
			rset = stmt.executeQuery(sqlString);
			if(rset == null) System.out.println(rset);
			return rset;
			}
			else {
				System.out.println("Error in Connection");
				return rset;
			}
			}
		
		public String query9(int year) throws SQLException {
			conn = connectionToOracle();
			if(conn != null) {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			sqlString = "Delete all the patients who were discharged before a particular year.\n" + 
					"DELETE\n" + 
					" from patient_tab p\n" + 
					"WHERE p.stay_period.date_discharged.year < " + year + ""; 
			System.out.println("\nSelect Query: " + sqlString);
			rset = stmt.executeQuery(sqlString);
			return "Success";
			}
			else {
				return "failed";
			}
		}
		
		public String query10() throws SQLException {
			conn = connectionToOracle();
			if(conn != null) {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			sqlString = "DELETE FROM Patient_tab p\n" + 
					"WHERE p.PID NOT IN (\n" + 
					"SELECT (a.PID).PID FROM assigned_tab a\n" + 
					")"; 
			System.out.println("\nSelect Query: " + sqlString);
			rset = stmt.executeQuery(sqlString);
			return "Success";
			}
			else {
				return "failed";
			}
		}
}
