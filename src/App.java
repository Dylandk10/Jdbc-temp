import java.sql.SQLException;
import java.util.Scanner;

//simple terminal commands till I make UI

public class App {

	public static void main(String[] args)  {
		String firstName = null;
		String lastName = null;
		String email = null;
		String position = null;
		int salary = 0;
		// TODO Auto-generated method stub
		System.out.println("new entry, command = entry || Look record command = lookup || Update record command = update");
		Scanner scanner = new Scanner(System.in);
		String result = scanner.nextLine();
		if(result.equals("entry")) {
			System.out.println("Enter firstname");
			scanner = new Scanner(System.in);
			String userName = scanner.nextLine();
			firstName = userName;
			System.out.println("LastName");
			scanner = new Scanner(System.in);
			lastName = scanner.nextLine();
			System.out.println("Email");
			email = scanner.nextLine();
			System.out.println("Position");
			position = scanner.nextLine();
			System.out.println("Salary");
			salary = scanner.nextInt();
			
			try {
				DataInsert dataInsert = new DataInsert(firstName, lastName, email, position, salary);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} else if(result.equals("lookup")) {
			System.out.println("enter first Name");
			Scanner scanner1 = new Scanner(System.in);
			firstName = scanner1.nextLine();
			try {
				LookUp lookUp = new LookUp(firstName);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if (result.equals("update")) {
			String fieldToChange = null;
			String newResult = null;
			System.out.println("Last Name of person you wish to update?");
			lastName = scanner.nextLine();
			System.out.println("What field do you wish to change? first_name, last_name, email, potion, salary?");
			fieldToChange = scanner.nextLine();
			if(!(fieldToChange.equals("salary"))) {
				System.out.println("Change " + fieldToChange + " To?");
				newResult = scanner.nextLine();
				try {
					UpdateDatabase updateData = new UpdateDatabase(lastName, fieldToChange, newResult);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("Change salary To?");
				newResult = scanner.nextLine();
				try {
					UpdateDatabase updataData = new UpdateDatabase(lastName, fieldToChange, newResult);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
