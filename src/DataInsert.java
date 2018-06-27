import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//basic inserting data to database
public class DataInsert {
	
	public DataInsert(String name, String lastName, String newEmail, String position, int newSalary) throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRes = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String pass = "";
		
		myConn = DriverManager.getConnection(dbUrl, user, pass);
		myStmt = myConn.createStatement();
		
		//give dynamic fields
		myStmt.executeUpdate("insert into employees " + "(last_name, first_name, email, department, salary) "
		+"values " + "('" + lastName + "','" + name + "','" + newEmail + "','" + position + "','" + newSalary + ")" );
		
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
