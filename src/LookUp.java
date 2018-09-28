import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LookUp {
	public LookUp(String lastName) throws SQLException {
	Connection myConn = null;
	PreparedStatement myStmt = null;
	ResultSet myRes = null;
	
	String dbUrl = "jdbc:mysql://localhost:3306/demo";
	String user = "root";
	String pass = "";
	
	myConn = DriverManager.getConnection(dbUrl, user, pass);
	
	myStmt = myConn.prepareStatement("select * from employees where last_name=?");
	myStmt.setString(1, lastName);
	myRes = myStmt.executeQuery();
	display(myRes);
	
	if (myRes != null) {
		myRes.close();
	}
	
	if (myStmt != null) {
		myStmt.close();
	}
	
	if (myConn != null) {
		myConn.close();
	}
	
	}
	public static void display(ResultSet myRs) throws SQLException {
		while (myRs.next()) {
			String lastName = myRs.getString("last_name");
			String firstName = myRs.getString("first_name");
			double salary = myRs.getDouble("salary");
			String department = myRs.getString("department");
			
			System.out.printf("%s, %s, %.2f, %s\n", lastName, firstName, salary, department);
		}
	}

}
