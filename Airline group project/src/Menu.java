import java.util.*;

public class Menu { 

	private Map<String, User> users;
	
	private Map<String, Administrator> administrators;
	
	private Map<String, Airline> airlines;
	
	Scanner scan = new Scanner(System.in);
	
	Menu() {	
		
		this.users = new HashMap<>();
		this.administrators = new HashMap<>();
		this.airlines = new HashMap<>();
		
		System.out.println("Welcome to the Airport!");
	}
	
	public void menuStart() {
		System.out.print("\nDo you have an account: ");
		String answer = scan.next();
		if (answer.equalsIgnoreCase("yes"))
			login();
		else
			register();
	}
	
	public void register() {
		System.out.println("\nRegister Screen");
		System.out.print("Are you registering as a user or administator: ");
		String accountType = scan.next();
		System.out.print("Enter username: ");
		String username = scan.next();
		System.out.print("Enter password: ");
		String password = scan.next();
			
		if (accountType.equalsIgnoreCase("user"))
		{
			if (check(accountType, username))
			{
				System.out.println("\nThat username already exist.");
				menuStart();
			} 
			else
			{
				System.out.println("\nYour account has been created.");
				addUser(username, password);
				menuStart();
			}
		}
		else
		{
			if (check(accountType, username))
			{
				System.out.println("\nThat username already exist.");
				menuStart();
			} 
			else
			{
				System.out.println("\nYour account has been created.");
					
				addAdministrator(username, password);
				menuStart();
			}		
		}	
	}

	public void login() {
		System.out.println("\nLogin Screen");
		System.out.print("Are you a user or administrator: ");
		String accountType = scan.next();
		System.out.print("Enter you username: ");
		String username = scan.next();
		System.out.print("Enter your password: ");
		String password = scan.next();

		if (!verify(username, password, accountType)) 
		{
			System.out.println("Your password doesn't match with your username.");
			menuStart(); 
		}
		
		int input = 0;
		if (accountType.equalsIgnoreCase("user"))
		{
			while (input != 9)
			{

				System.out.println("\nWelcome to the Menu " + username + "!");
				System.out.println("The following are the options: ");
				System.out.println("Enter 1 to SEARCH for your flight.");
				System.out.println("Enter 2 to do a FILTERED SEARCH.");
				System.out.println("Enter 3 to BOOK A FLIGHT.");
				System.out.println("Enter 4 to PURCHASE A FLIGHT.");
				System.out.println("Enter 5 to VIEW your vouchers.");
				System.out.println("Enter 6 to CANCEL a flight.");
				System.out.println("Enter 7 to LEAVE A RATING.");
				System.out.println("Enter 8 to view your BOOKING HISTORY.");
				System.out.println("Enter 9 to LOGOUT");
				System.out.print("Option: ");
				
				User user = users.get(username);
				int option = scan.nextInt();
				input = option;
				switch (option) {
						case 1: 
							user.search(airlines);
							break;
						case 2: 
							user.filter(airlines);
							break;
						case 3:
							user.book(airlines);
							break;
						case 4: 
							user.purchase(airlines);
							break;
						case 5: 
							user.viewVouchers(airlines);
							break;
						case 6: 
							user.cancel(airlines);
							break;
						case 7: 
							user.giveRating(airlines);
							break;
						case 8: 
							user.getPurchaseLog(airlines);
							break;
						case 9:
							System.out.println("\nThank you come again!");
							menuStart();
							break;
									
				}
			
			}
		} else 
		{
			
			while (input != 6) 
			{
				
				System.out.println("\nWelcome to the Menu " + username + "!");
				System.out.println("The following are the options: ");
				System.out.println("Enter 1 to ALTER FLIGHTS.");
				System.out.println("Enter 2 to edit the BLACKLIST.");
				System.out.println("Enter 3 to view RATINGS.");
				System.out.println("Enter 4 to give  VOUCHERS.");
				System.out.println("Enter 5 to approve VOUCHERS.");
				System.out.println("Enter 6 to LOGOUT.");
				System.out.print("Option: ");
			
				Administrator admin = administrators.get(username);
				if (getJob(username).equalsIgnoreCase("Deny"))
				{
					System.out.println("You currently are not employed");
					menuStart();
				}
				Airline adminJob = airlines.get(getJob(username));
				int option = scan.nextInt();
				input = option;
				switch (option) {
						case 1: 
							System.out.println('A');
							admin.alterFlights(adminJob);
							break;
						case 2: 
							admin.blacklist(adminJob);
							break;
						case 3: 
							admin.viewRatings(adminJob);
							break;
						case 4: 
							admin.giveVoucher(adminJob, users);
							break;
						case 5:
							admin.approveVoucher(adminJob, users);
							break;
						case 6:
							System.out.println("\nThank you come again!");
							menuStart();
							break;
				}
			}
		}

	}
	
	public void addAirlines(String name, ArrayList<String> employees)
	{
		airlines.put(name, new Airline(name, employees));
	}
	
	private void addAdministrator(String username, String password) {
		administrators.put(username, new Administrator(username, password, "administrator"));
	}
	private void addUser(String username, String password) {
		users.put(username, new User(username, password, "user"));
	}

	private boolean verify(String username, String password, String accountType) {
		if (accountType.equalsIgnoreCase("user"))
		{
			for (User value: users.values())
			{
				if (value.getUsername().equals(username) && value.getPassword().equals(password))
					return true;
			}
		}
		else
		{
			for (Administrator value: administrators.values())
			{
				if (value.getUsername().equals(username) && value.getPassword().equals(password))
					return true;
			}
		}
		return false;
		
	
	}
	private boolean check(String accountType, String username) {
		if(accountType.equalsIgnoreCase("user")) 
		{
			if (users.containsKey(username))
				return true;
			else 
				return false;
		}
		else 
		{
			if (administrators.containsKey(username))
				return true;
			else
				return false;
		}
	}
	
	private String getJob(String username) {
		for (Airline value: airlines.values())
		{
			if (value.getAdministrators().contains(username))
			{
				return value.name;
			}
		}
		return "Deny";
	}
	
	public static void main(String[] args){

		Menu menu = new Menu();
		ArrayList<String> unitedEmployees = new ArrayList<>();
		ArrayList<String> americanEmployees = new ArrayList<>();
		unitedEmployees.add("Robers");
		unitedEmployees.add("Bill");
		americanEmployees.add("Rachel");
		americanEmployees.add("Steve");
		menu.addAirlines("United", unitedEmployees);
		menu.addAirlines("American", americanEmployees);
		menu.menuStart();
		

	}
}
