//simple terminal commands till I make UI

public class App {

	public static void main(String[] args)  {
<<<<<<< HEAD
		UserInput userInput = new UserInput();
		userInput.mainMenu();
=======
		String firstName = null;
		String lastName = null;
		String email = null;
		String position = null;
		int salary = 0;
		SignIn signIn = null;
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
			System.out.println("enter last name");
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
			String signInFirstName = null;
			String signInLastName = null;
			Scanner signInScanner = new Scanner(System.in);
			//sign in make sure user has access... for testing use firt name: johnny, last name: doe, this is because HR only has access to edit user files
			System.out.println("Sign in first name:");
			signInFirstName = signInScanner.nextLine();
			System.out.println("Sign in last name:");
			signInLastName = signInScanner.nextLine();
			//check auth sign in
			try {
				signIn = new SignIn(signInFirstName, signInLastName);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(!(signIn.getEmployeeJob().equals("HR"))) {
				System.out.println("access denied");
			} else {
			
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
>>>>>>> 2a2df3fc55af8455595ca649efdf0aeba03350a8

	}

}
