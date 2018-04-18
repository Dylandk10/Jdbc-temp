import java.sql.SQLException;
import java.util.Scanner;

//simple terminal commands till i make GUI

public class App {

	public static void main(String[] args) {
		String firstName = null;
		String lastName = null;
		String email = null;
		String position = null;
		// TODO Auto-generated method stub
		System.out.println("new entry? update record?");
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
			
		}

	}

}
