import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSignIn {
	String userResult = "";
	public UserSignIn(String firstName, String lastName) throws SQLException { 
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRes = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String pass = "";
		
		myConn = DriverManager.getConnection(dbUrl, user, pass);
		
		myStmt = myConn.prepareStatement("select * from employees where first_name=? and last_name=?");
		myStmt.setString(1, firstName);
		myStmt.setString(2, lastName);
		myRes = myStmt.executeQuery();
		while(myRes.next()) {
			userResult = myRes.getString("department");
		}
		
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
		
	public Boolean isUserAdmin() throws SQLException {
		Boolean result = null;
		
		if(userResult.equals("HR")) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

}
