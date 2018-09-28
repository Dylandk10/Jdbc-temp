import java.sql.*;

//basic update database..
public class UpdateDatabase {
	
	public UpdateDatabase(String lastName, String fieldToChange, String resultField) throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;
		PreparedStatement myPrepStatment = null;
		ResultSet myRes = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String pass = "";
		
		try {
			myConn = DriverManager.getConnection(dbUrl, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myStmt = myConn.createStatement();
		
		System.out.println("Before update...");
		myPrepStatment = myConn.prepareStatement("select * from employees where last_name=?");
		myPrepStatment.setString(1, lastName);
		myRes = myPrepStatment.executeQuery();
		display(myRes);
		
		//if changing salary make it integer otherwise breaks database
		if(fieldToChange.equals("salary")) {
			Integer.parseInt(resultField);
		}
		
		//give dynamic fields
		myStmt.executeUpdate(
				"update employees " + 
				"set " + fieldToChange + "='" + resultField  + "'" +
				"where last_name='" + lastName + "'");
		
		System.out.println("After update...");
		myPrepStatment = myConn.prepareStatement("select * from employees where last_name=?");
		myPrepStatment.setString(1, lastName);
		myRes = myPrepStatment.executeQuery();
		display(myRes);
		if(myStmt != null) {
			myStmt.close();
		}
		if(myConn != null) {
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
