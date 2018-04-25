import java.sql.*;

//basic update database..
public class UpdateDatabase {
	
	public UpdateDatabase(String lastName, String fieldToChange, String resultField) throws SQLException {
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
		myStmt.executeUpdate(
				"update employees " + 
				"set " + fieldToChange + "='" + resultField  + "'" +
				"where last_name='" + lastName + "'");
		if(myStmt != null) {
			myStmt.close();
		}
		if(myConn != null) {
			myConn.close();
		}
	}

}
