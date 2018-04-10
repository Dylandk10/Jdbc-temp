import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//basic inserting data to database
public class DataInsert {
	
	public DataInsert() throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRes = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/demo";
		String user = "student";
		String pass = "student";
		
		myConn = DriverManager.getConnection(dbUrl, user, pass);
		myStmt = myConn.createStatement();
		
		//give dynamic fields
		int rowsAffected = myStmt.executeUpdate("insert into employees " + "(last_name, first_name, email, department, salary) "
		+"values " + "('Wright', 'Eric', 'eric.wright$foo.com', 'HR', 3300.00)" );
		
		myRes = myStmt.executeQuery("select * from employees order by last_name");
		
		//print results
		while(myRes.next()) {
			System.out.println(myRes.getString("last_name") + ", " + myRes.getString("first_name"));
		}
		if(myRes != null) {
			myRes.close();
		}
		if(myStmt != null) {
			myStmt.close();
		}
		if(myConn != null) {
			myConn.close();
		}
	}

}
