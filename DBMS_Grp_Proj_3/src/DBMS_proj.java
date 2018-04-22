import java.sql.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.io.IOException;
public class DBMS_proj {
	 /**
     * @param args the command line arguments
     */
    public static void print(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, NumberFormatException, IOException {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        try {
            Connection dbConnection = DriverManager.getConnection("jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu", "byak0000", "REin7Pi9");
            System.out.println(dbConnection);
        } catch (SQLException x) {
            System.out.println("Couldn’t get connection!");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {

			//trying to connect to oracle driver 
            Class.forName("oracle.jdbc.OracleDriver");

        } catch (Exception x) {

			//if the try fails, handling the exception 
            System.out.println("Unable to load the driver bclass!");

        }

		//Connect to the database using user name and password and thin client 
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu", "byak0000", "REin7Pi9");

        //display options to user which he can select
        while (true) {
            System.out.println("WELCOME TO THE CLIENT AND DONOR DATABASE SYSTEM");
            System.out.println("Given queries and their description");
            System.out.println();
            System.out.println("1. Enter a new team into the database : ");
            System.out.println("2. Enter a new client into the database and associate him or her with a team : ");
            System.out.println("3. Enter a new volunteer into the database and associate him or her with a team : ");
            System.out.println("4. Enter the number of hours a volunteer worked this month for a particular team : ");
            System.out.println("5. Enter a new employee into the database and associate him or her with a team : ");
            System.out.println("6. Enter an expense charged by an employee : ");
            System.out.println("7. Enter a new organization and associate it to a PAN teams : ");
            System.out.println("8. Enter a new donor and associate him or her with donations : ");
            System.out.println("9. Enter a new organization and associate it with donations : ");
            System.out.println("10. Retrieve the name and phone number of the doctor of a particular client : ");
            System.out.println("11. Retrieve the total amount of expenses charged by each employee for a particular period of time : ");
            System.out.println("12. Retrieve the list of volunteers that are members of teams that support a particular client : ");
            System.out.println("13. Retrieve the names and contact information of the clients that are supported by teams sponsored by an organization whose name starts with a letter between B and K : ");
            System.out.println("14. Retrieve the name and total amount donated by donors that are also employees and indicate if each donor wishes to remain anonymous : ");
            System.out.println("15. For each team, retrieve the name and associated contact information of the volunteer that has worked the most total hours between March and June : ");
            System.out.println("16. Increase the salary by 10% of all employees to whom more than one team must report : ");
            System.out.println("17. Delete all clients who do not have health insurance and whose value of importance for transportation is less than 5 : ");
            System.out.println("18. Import: enter new customers from a data file until the file is empty");
            System.out.println("19. Export: Retrieve the customers (in name order) whose assemblies are painted RED using a given painting method and output them to a data file instead of screen :");
            System.out.println("20. QUIT");
            System.out.println("Enter the choice : ");
            Statement stmt = conn.createStatement();
            int choice;
            choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    //Query no 1 :Enter a new team
                    System.out.println("Executing query 1.... ");
                    System.out.println("Enter team name : ");
                    String tname = (br.readLine());
                    System.out.println("Enter team type : ");
                    String ttype = (br.readLine());
                    System.out.println("Enter team formed date : ");
                    String tdate = (br.readLine());
                    stmt.executeUpdate("INSERT INTO PAN_TEAM VALUES ('"+ tname +"','"+ ttype +"','"+ tdate +"')");
                    ResultSet rset = stmt.executeQuery("select * from PAN_TEAM");
                    while (rset.next()) {
                        System.out.println(rset.getString(1) + " | " + rset.getString(2) + " | " + rset.getString(3));
                    }
                    break;
                case 2:
                    //Query no 2:Enter a new client and his team details 
                    System.out.println("Executing query 2.... ");
                    System.out.println("Enter client SSN : ");
                    int cssn = Integer.parseInt(br.readLine());
                    System.out.println("Enter client doctor name : ");
                    String cdname = (br.readLine());
                    System.out.println("Enter client doctor phone number : ");
                    long cdphone = Long.parseLong(br.readLine());
                    System.out.println("Enter client attorney name : ");
                    String caname = (br.readLine());
                    System.out.println("Enter client attorney phone number : ");
                    long caphone = Long.parseLong(br.readLine());
                    System.out.println("Enter client asssigned date : ");
                    String cassdate = (br.readLine());
                    stmt.executeUpdate("INSERT INTO CLIENT VALUES ('" + cssn + "','" + cdname + "','" + cdphone + "','" + caname + "','" + caphone + "','" + cassdate +"')");
                    System.out.println("How many teams do you want him to be associated with?");
                    int numteam = Integer.parseInt(br.readLine());
                    for (int i=1;i<=numteam;i++) {
                    		System.out.println("Enter "+i+" team name : ");
                    		String ctname = (br.readLine());
                    		System.out.println("Enter client care status(active/inactive) : ");
                    		String ctcstat = (br.readLine());
                    		stmt.executeUpdate("INSERT INTO CARES_FOR VALUES ('" + cssn + "','" + ctname + "','" + ctcstat + "')");
                    }
                    break;

                case 3:
                    //Query 3:Enter volunteer and his team details
                    System.out.println("Executing query 3.... ");
                    System.out.println("Enter volunteer SSN : ");
                    int vssn = Integer.parseInt(br.readLine());
                    System.out.println("Enter volunteer join date : ");
                    String vjoin = (br.readLine());
                    System.out.println("Enter volunteer trained date : ");
                    String vtrain = (br.readLine());
                    System.out.println("Enter trained location : ");
                    String vloc = (br.readLine());
                    stmt.executeUpdate("INSERT INTO VOLUNTEER VALUES ('" + vssn + "','" + vjoin + "','" + vtrain + "','" + vloc + "')");
                    System.out.println("How many teams do you want him to be associated with?");
                    int numteam3 = Integer.parseInt(br.readLine());
                    for (int i=1;i<=numteam3;i++) {
                    		System.out.println("Enter "+i+" team name : ");
                    		String vtname = (br.readLine());
                    		System.out.println("Enter number of hours volunteer worked : ");
                    		int vhr = Integer.parseInt(br.readLine());
                    		System.out.println("Enter month in which volunteer worked : ");
                    		String vmon = (br.readLine());
                    		System.out.println("Enter volunteer care status(active/inactive) : ");
                    		String vcare = (br.readLine());
                    		stmt.executeUpdate("INSERT INTO V_SERVE VALUES ('" + vssn + "','" + vtname + "','" + vhr + "','" + vmon + "','" + vcare +"')");
                    }
                    break;
                case 4:
                    //Query 4: Enter volunteer details with number of hours he worked on a team
                		System.out.println("Executing query 4.... ");
                		System.out.println("Enter volunteer SSN : ");
                		int vssn1 = Integer.parseInt(br.readLine());
                		System.out.println("Enter team name : ");
                		String vtname1 = (br.readLine());
                		System.out.println("Enter number of hours volunteer worked : ");
                		int vhr1 = Integer.parseInt(br.readLine());
                		System.out.println("Enter month in which volunteer worked : ");
                		String vmon1 = (br.readLine());
                		System.out.println("Enter volunteer care status(active/inactive) : ");
                		String vcare1= (br.readLine());
                		stmt.executeUpdate("INSERT INTO V_SERVE VALUES ('" + vssn1 + "','" + vtname1 + "','" + vhr1 + "','" + vmon1 + "','" + vcare1 +"')");
                    break;
                case 5:
                    //Query 5: Enter volunteer and his team details
                		System.out.println("Executing query 5.... ");
                		System.out.println("Enter Employee SSN : ");
                		int essn = Integer.parseInt(br.readLine());
                		System.out.println("Enter employee salary : ");
                		int esal = Integer.parseInt(br.readLine());
                		System.out.println("Enter employee marriage status : ");
                		String emarr = (br.readLine());
                		System.out.println("Enter Employee hire date : ");
                		String ehire = (br.readLine());
                		stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES ('" + essn + "','" + esal + "','" + emarr + "','" + ehire + "')");
                		System.out.println("How many teams do you want him to be associated with?");
                		int numteam5 = Integer.parseInt(br.readLine());
                		for (int i=1;i<=numteam5;i++) {
                			System.out.println("Enter "+i+" team name : ");
                			String etname = (br.readLine());
                			System.out.println("Enter date on which team reports to the employee : ");
                			String rdate = (br.readLine());
                			System.out.println("Enter report description : ");
                			String rdesc = (br.readLine());
                			stmt.executeUpdate("INSERT INTO REPORT_TO VALUES ('" + essn + "','" + etname + "','" + rdate + "','" + rdesc + "')");
                		}
                    break;
                case 6:
                    //Query 6: Enter expense details charged by an employee
                		System.out.println("Executing query 6.... ");
                		System.out.println("Enter Employee SSN : ");
                		int essn1 = Integer.parseInt(br.readLine());
                		System.out.println("Enter expense date: ");
                		String expdate = (br.readLine());
                		System.out.println("Enter expense amount : ");
                		int expamnt = Integer.parseInt(br.readLine());
                		System.out.println("Enter expense description : ");
                		String expdesc = (br.readLine());
                		stmt.executeUpdate("INSERT INTO E_EXPENSE VALUES ('" + essn1 + "','" + expdate + "','" + expamnt + "','" + expdesc + "')");
                    break;

                case 7:
                    //Query 7:. Enter organization details with team details to which it should be associated 
                		System.out.println("Executing query 7.... ");
                		System.out.println("Enter organization name : ");
                		String orgname = (br.readLine());
                		System.out.println("Enter organization mail address : ");
                		String orgmail = (br.readLine());
                		System.out.println("Enter organization phone : ");
                		long orgphone = Long.parseLong(br.readLine());
                		System.out.println("Enter contact person name : ");
                		String contper = (br.readLine());
                		System.out.println("Enter annonymous status : ");
                		String ogrannst = (br.readLine());
                		stmt.executeUpdate("INSERT INTO ORGANIZATIONS VALUES ('" + orgname + "','" + orgmail + "','" + orgphone + "','" + contper + "','" + ogrannst + "')");                		
                		System.out.println("How many teams do you want organization to be associated with?");
                		int numteam7 = Integer.parseInt(br.readLine());
                		for (int i=1;i<=numteam7;i++) {
                			System.out.println("Enter "+i+" team name : ");
                			String orgtname = (br.readLine());
                			stmt.executeUpdate("INSERT INTO SPONSORS VALUES ('" + orgtname + "','" + orgname + "')");
                		}
                    break;

                case 8:
                    //Query 8:. Enter Donor and associate him with donations
                		System.out.println("Executing query 8.... ");
                		System.out.println("Enter Donor SSN : ");
                		int dssn = Integer.parseInt(br.readLine());
                		System.out.println("Enter annonymous status : ");
                		String dannyst = (br.readLine());
                		stmt.executeUpdate("INSERT INTO DONOR VALUES ('" + dssn + "','" + dannyst + "')");
                		System.out.println("Enter how many donations the donor wants to be associated with?");
                		int numdon = Integer.parseInt(br.readLine());
                		for (int i=1;i<=numdon;i++) {
                			System.out.println("Enter "+i+" donation date : ");
                			String ddate = (br.readLine());
                			System.out.println("Enter donation amount : ");
                			int damnt = Integer.parseInt(br.readLine());
                			System.out.println("Enter campaign name : ");
                			String campname = (br.readLine());                		
                			stmt.executeUpdate("INSERT INTO DONATIONS VALUES ('" + dssn + "','" + ddate + "','" + damnt + "','" + campname + "')");
                		}
                    break;

                case 9:
                    //Query 9:Enter organization and associate with donations
                		System.out.println("Executing query 9.... ");
                		System.out.println("Enter organization name : ");
                		String orgname1 = (br.readLine());
                		System.out.println("Enter organization mail address : ");
                		String orgmail1 = (br.readLine());
                		System.out.println("Enter organization phone : ");
                		long orgphone1 = Long.parseLong(br.readLine());
                		System.out.println("Enter contact person name : ");
                		String contper1= (br.readLine());
                		System.out.println("Enter annonymous status : ");
                		String ogrannst1 = (br.readLine());
                		stmt.executeUpdate("INSERT INTO ORGANIZATIONS VALUES ('" + orgname1 + "','" + orgmail1 + "','" + orgphone1 + "','" + contper1 + "','" + ogrannst1 + "')");
            			System.out.println("Enter how many donations the organization wants to be associated with?");
            			int numdon9 = Integer.parseInt(br.readLine());
                		for (int i=1;i<=numdon9;i++) {
                			System.out.println("Enter "+i+" donation date : ");
                			String ddate1 = (br.readLine());
                			System.out.println("Enter donation amount : ");
                			int damnt1 = Integer.parseInt(br.readLine());
                			System.out.println("Enter campaign name : ");
                			String campname1 = (br.readLine());            			
                			stmt.executeUpdate("INSERT INTO ORG_DONATIONS VALUES ('" + orgname1 + "','" + ddate1 + "','" + damnt1 + "','" + campname1 + "')");
                		}
            			break;

                case 10:
                    //Query 10:Retrieve the doctor name and phone of a client
                    System.out.println("Executing query 10.... ");
                    stmt = conn.createStatement();
                    System.out.println("Enter the SSN of a client : ");
                    int c_ssn = Integer.parseInt(br.readLine());
                    String selectTableSQL10 = "SELECT C_DOC_NAME,C_DOC_PH FROM CLIENT WHERE C_SSN='" + c_ssn + "'";
                    Statement statement10 = conn.createStatement();
                    ResultSet rsett10 = statement10.executeQuery(selectTableSQL10);
                    while (rsett10.next()) {
                        System.out.println(rsett10.getString(1) + " | " + rsett10.getString(2));
                    }
                    break;
                    
                case 11:
                    //Query 11 :Retrieve the total amount of expenses charged by each employee for a particular period of time
                    System.out.println("Executing query 11.... ");
                    System.out.println("Enter start date :");
                    String startdate = br.readLine();
                    System.out.println("Enter end date :");
                    String enddate = br.readLine();
                    String selectTableSQL11 = "SELECT E_SSN,SUM(EXP_AMNT) AS TOTAL FROM E_EXPENSE WHERE EXP_DATE BETWEEN '" + startdate +"' AND '" + enddate + "' GROUP BY E_SSN ORDER BY TOTAL";
                    Statement statement11 = conn.createStatement();
                    ResultSet rsett11 = statement11.executeQuery(selectTableSQL11);
                    while (rsett11.next()) {
                        System.out.println(rsett11.getString(1) + " | " + rsett11.getString(2));
                    }
                    break;
                    
                case 12:
                    //Query 12:. Retrieve the list of volunteers that are members of teams that support a particular client
                    System.out.println("Executing query 12.... ");
                    System.out.println("Enter the Client SSN : ");
                    int cssn12 = Integer.parseInt(br.readLine());
                    String selectTableSQL12 = "SELECT DISTINCT(V.V_SSN) from VOLUNTEER V, CLIENT C, PAN_TEAM T, V_SERVE S, CARES_FOR CF WHERE V.V_SSN = S.V_SSN and S.T_NAME = T.T_NAME AND T.T_NAME = CF.T_NAME AND CF.C_SSN = C.C_SSN AND C.C_SSN ='" + cssn12 + "'";
                    Statement statement12 = conn.createStatement();
                    ResultSet rsett12 = statement12.executeQuery(selectTableSQL12);
                    while (rsett12.next()) {
                        System.out.println(rsett12.getString(1));
                    }
                    break;
                    
                case 13:
                    //Query 13:Retrieve the names and contact information of the clients that are supported by teams sponsored by an organization whose name starts with a letter between B and K
                		System.out.println("Executing query 13.... ");
                		String selectTableSQL13 = "SELECT P_NAME,P_MAIL_ADDR,P_EMAIL,P_HOME_NUM,P_WORK_NUM,P_CELL_NUM FROM PERSON P,CLIENT C,CARES_FOR CF,PAN_TEAM PT WHERE P.P_SSN = C.C_SSN AND C.C_SSN = CF.C_SSN AND CF.T_NAME = PT.T_NAME AND CF.T_NAME IN (SELECT UNIQUE(T_NAME) FROM SPONSORS WHERE ORG_NAME BETWEEN 'B%' AND 'K%') ORDER BY P_NAME";
                		Statement statement13 = conn.createStatement();
                		ResultSet rsett13 = statement13.executeQuery(selectTableSQL13);
                		while (rsett13.next()) {
                            System.out.println(rsett13.getString(1) + " | " + rsett13.getString(2) + " | " + rsett13.getString(3) + " | " + rsett13.getString(4) + " | " + rsett13.getString(5) + " | " + rsett13.getString(6));
                        }
                    break;
                		
                case 14:
                    //Query 14:Retrieve the name and total amount donated by donors that are also employees
                		System.out.println("Executing query 14.... ");
                		String selectTableSQL14 = "SELECT P.P_NAME, SUM(DD.DONATE_AMNT),D.D_ANON_STAT FROM DONOR D, DONATIONS DD, EMPLOYEE E, PERSON P WHERE  D.D_SSN = DD.D_SSN AND D.D_SSN = E.E_SSN and P.P_SSN = E.E_SSN GROUP BY P.P_NAME, D.D_ANON_STAT";
                		Statement statement14 = conn.createStatement();
                		ResultSet rsett14 = statement14.executeQuery(selectTableSQL14);
                		while (rsett14.next()) {
                        System.out.println(rsett14.getString(1) + " | " + rsett14.getString(2) + " | " + rsett14.getString(3));
                    }
                		break;
                		
                case 15:
                    //Query 15:For each team, retrieve the name and associated contact information of the volunteer that has worked the most total hours between March and June
                    System.out.println("Executing query 15");
                    String selectTableSQL15 = "SELECT P.P_NAME,P.P_MAIL_ADDR,P.P_EMAIL,P.P_HOME_NUM,P.P_WORK_NUM,P.P_CELL_NUM,VS.T_NAME FROM PERSON P,V_SERVE VS WHERE P.P_SSN = VS.V_SSN AND (VS.T_NAME,VS.V_SSN) IN(SELECT T_NAME,V_SSN FROM(SELECT V_SSN,T_NAME,SUM(SERVE_HR) AS TOT_HR FROM V_SERVE WHERE SERVE_MON BETWEEN 3 AND 12 GROUP BY V_SSN,T_NAME ORDER BY TOT_HR DESC) WHERE TOT_HR IN (SELECT MAX(TOT_HR) FROM(SELECT V_SSN,T_NAME,SUM(SERVE_HR) AS TOT_HR FROM V_SERVE WHERE SERVE_MON BETWEEN 3 AND 12 GROUP BY V_SSN,T_NAME ORDER BY TOT_HR DESC)GROUP BY T_NAME))";
            			Statement statement15 = conn.createStatement();
            			ResultSet rsett15 = statement15.executeQuery(selectTableSQL15);
            			while (rsett15.next()) {
            				System.out.println(rsett15.getString(1) + " | " + rsett15.getString(2) + " | " + rsett15.getString(3) + " | " + rsett15.getString(4) + " | " + rsett15.getString(5) + " | " + rsett15.getString(6) + " | " + rsett15.getString(7));
            			}
            			break;
            			
                case 16:
                    //Query 16:Increase the salary by 10% of all employees to whom more than one team must report
                		System.out.println("Executing query 16.... ");
                		String selectTableSQL16 = "SELECT P.P_NAME, SUM(DD.DONATE_AMNT),D.D_ANON_STAT FROM DONOR D, DONATIONS DD, EMPLOYEE E, PERSON P WHERE D.D_SSN = E.E_SSN and P.P_SSN = E.E_SSN GROUP BY P.P_NAME, D.D_ANON_STAT";
                		Statement statement16 = conn.createStatement();
                		statement16.executeQuery(selectTableSQL16);
                		System.out.println("Eligible Employees salary has been increased");
                		ResultSet rsett16_temp = statement16.executeQuery("select * from EMPLOYEE");
                		while (rsett16_temp.next()) {
                            System.out.println(rsett16_temp.getString(1) + " | " + rsett16_temp.getString(2) + " | " + rsett16_temp.getString(3) + " | " + rsett16_temp.getString(4));
                        }
                		break;

                case 17:
                    //Delete all clients who do not have health insurance and whose value of importance for transportation is less than 5 
                		System.out.println("Executing query 17.... ");
                		String selectTableSQL17 = "DELETE FROM CLIENT WHERE C_SSN IN(SELECT C.C_SSN FROM CLIENT C,C_COV_BY CB,INS_POLICY IP WHERE IP.INS_POL_ID =CB.INS_POL_ID AND CB.C_SSN = C.C_SSN AND IP.POL_TYPE != 'health' INTERSECT SELECT C.C_SSN FROM CLIENT C,CLIENT_NEED CN WHERE CN.C_SSN = C.C_SSN AND CN.NEED_TYPE ='transportation' and CN.NEED_IMPO < 5)";
                		Statement statement17 = conn.createStatement();
                		statement17.executeQuery(selectTableSQL17);
                		System.out.println("Eligible Clients have been deleted");
                		break;
                case 18:
                    //Query 18 Import new team from a data file until the file is empty
                		System.out.println("Executing query 18.... ");
                    // get user input file
                    System.out.println("Enter Input file name");
                    String inputfile = br.readLine();
                    String finalstring = "/Users/byakodpramod/Desktop/" + inputfile;
                    FileInputStream is = new FileInputStream(finalstring);
                    DataInputStream ds = new DataInputStream(is);
                    BufferedReader br1 = new BufferedReader(new InputStreamReader(ds));
                    String strimport;
                    while ((strimport = br1.readLine()) != null) {
                        String im[] = strimport.split("\\s+");
                        String team_name = im[0];
                        String team_type = im[1];
                        String team_form = im[2];
                        stmt.executeUpdate("insert into PAN_TEAM values('" + team_name + "','" + team_type + "','" + team_form + "')");
                    }
                    System.out.println("Importing values from text to database.");

                    break;
                case 19:
                    //Query 19:Export person name and person mail address to an external file
                		System.out.println("Executing query 19.... ");
                    ResultSet rsexport = stmt.executeQuery("select P_NAME,P_MAIL_ADDR from PERSON");
                    String str18 = null;
                    String str19 = null;
                    // get user input
                    System.out.println("Enter output file name");
                    String strexport = br.readLine();
                    String finaloutput = "/Users/byakodpramod/Desktop/" + strexport;
                    BufferedWriter out = new BufferedWriter(new FileWriter(finaloutput));
                    while (rsexport.next()) {
                        str18 = rsexport.getString(1);
                        str19 = rsexport.getString(2);
                        out.write(str18+ " | "+ str19);
                        out.write('\n');
                    }
                    System.out.println("Exporting values ");
                    System.out.println("completed.");
                    out.close();
                    break;

                case 20:
                    //QUIT
                		System.out.println("Executing query 20.... ");
                    stmt.close();
                    conn.close();
                    System.out.println("Exit....");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Select an option between 1-20");

            }
        }
    }

}
