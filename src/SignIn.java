import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//class holdempolyee job to make sure they have access t0 change records
public class SignIn {
	String employeeJob = null;
	public SignIn(String firstName, String lastName) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRes = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String pass = "";
		
		myConn = DriverManager.getConnection(dbUrl, user, pass);
		
		myStmt = myConn.prepareStatement("select * from employees where first_name=? AND last_name=?");
		myStmt.setString(1, firstName);
		myStmt.setString(2, lastName);
		myRes = myStmt.executeQuery();
		setEmployeeJob(myRes);
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
	public String setEmployeeJob(ResultSet myRes) throws SQLException {
		employeeJob = myRes.getString("department");
		return employeeJob;
	}
	public String getEmployeeJob() {
		return employeeJob;
	}
}
