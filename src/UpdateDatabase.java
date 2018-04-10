import java.sql.*;

//basic update database..
public class UpdateDatabase {
	
	public UpdateDatabase() throws SQLException {
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
				"set email='john.doe@gmail.example' " +
				"where last_name='Doe' and first_name='John'");
		if(myStmt != null) {
			myStmt.close();
		}
		if(myConn != null) {
			myConn.close();
		}
	}

}
