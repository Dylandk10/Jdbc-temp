import java.sql.*;

//basic update database..
public class UpdateDatabase {
	
	public UpdateDatabase(String name, String lastName, String email, String position, int salary) throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;;
		
		String dbUrl = "jdbc:mysql://localhost:3306/demo";
		String user = "student";
		String pass = "student";
		
		try {
			myConn = DriverManager.getConnection(dbUrl, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myStmt = myConn.createStatement();
		
		System.out.println("Before update...");
		
		//give dynamic fields
		int roswAffected = myStmt.executeUpdate(
				"update employees " + 
				"set email='" + email + "'" +
				"where last_name='" + lastName + "' and first_name='" + name + "'");
		if(myStmt != null) {
			myStmt.close();
		}
		if(myConn != null) {
			myConn.close();
		}
	}

}
