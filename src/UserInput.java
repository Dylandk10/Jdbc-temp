import java.sql.SQLException;
import java.util.Scanner;

public class UserInput {
	String firstName = "";
	String lastName = "";
	String email = "";
	String position = "";
	int salary = 0;
	public void mainMenu() {
		System.out.println("new entry, command = entry || Look record command = lookup || Update record command = update");
		Scanner scanner = new Scanner(System.in);
		String result = scanner.nextLine();
		if(result.equals("lookup")) {
			lookUpUser();
		} else if(result.equals("entry")) {
			takeNewEntery();
		} else if (result.equals("update")) {
			updateUser();
		}
	}
	//loop up user method 
	public void lookUpUser() {
		System.out.println("enter first Name");
		Scanner scanner1 = new Scanner(System.in);
		firstName = scanner1.nextLine();
		try {
			LookUp lookUp = new LookUp(firstName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//new entery method 
	public void takeNewEntery() {
		Scanner scanner2 = new Scanner(System.in);
		String result = scanner2.nextLine();
		if(result.equals("entry")) {
			System.out.println("Enter firstname");
			scanner2 = new Scanner(System.in);
			String userName = scanner2.nextLine();
			firstName = userName;
			System.out.println("LastName");
			scanner2 = new Scanner(System.in);
			lastName = scanner2.nextLine();
			System.out.println("Email");
			email = scanner2.nextLine();
			System.out.println("Position");
			position = scanner2.nextLine();
			System.out.println("Salary");
			salary = scanner2.nextInt();
			
			try {
				DataInsert dataInsert = new DataInsert(firstName, lastName, email, position, salary);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//update user method 
	public void updateUser() {
		//checks to make sure user is admin = "HR"
		if(signInUser() == true) {
			Scanner scanner3 = new Scanner(System.in);
			String fieldToChange = null;
			String newResult = null;
			
			System.out.println("Last Name of person you wish to update?");
			lastName = scanner3.nextLine();
			System.out.println("What field do you wish to change? first_name, last_name, email, potion, salary?");
			fieldToChange = scanner3.nextLine();
			if(!(fieldToChange.equals("salary"))) {
				System.out.println("Change " + fieldToChange + " To?");
				newResult = scanner3.nextLine();
				try {
					UpdateDatabase updateData = new UpdateDatabase(lastName, fieldToChange, newResult);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("Change salary To?");
				newResult = scanner3.nextLine();
				try {
					UpdateDatabase updataData = new UpdateDatabase(lastName, fieldToChange, newResult);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		} 
		else {
			System.out.println("Error with signin");
		}
	}
	//sign in user result comes from isUser admin 
	public Boolean signInUser() {
		Boolean result = null;
		String signInFirstName = "";
		String signInLastName = "";
		Scanner scannerFirstName = new Scanner(System.in);
		Scanner scannerLastName = new Scanner(System.in);
		System.out.println("Sign In first Name");
		signInFirstName = scannerFirstName.nextLine();
		System.out.println("Sign In Last Name");
		signInLastName = scannerLastName.nextLine();
		try {
			UserSignIn userSingIn = new UserSignIn(signInFirstName, signInLastName);
			result = userSingIn.isUserAdmin();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
