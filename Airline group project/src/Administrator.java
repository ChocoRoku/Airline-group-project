import java.util.*;

public class Administrator extends Person{

	String username;
	String password;
	String accountType;
	
	
	Administrator(String username, String password, String accountType) {
		super(username, password, accountType);
		// TODO: add fields!!	
	}
	
	/* This method is the alter flight option for the Menu
	 */
	public void alterFlights(Airline airline) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Alter Flights");
		System.out.println("Press 1 to add a flight");
		System.out.println("Press 2 to remove a flight");
		int choice = scan.nextInt();
		switch (choice) {
		case 1: // Questions for the search option
			System.out.println("Type flight number: ");
			int flightNumber = scan.nextInt(); 
			System.out.println("Type trip type: ");
			String tripType = scan.next();
			System.out.println("Type trip source: ");
			String source = scan.next();
			System.out.println("Type trip destination: ");
			String destination = scan.next();
			System.out.println("Is this a long trip (true/false): ");
			boolean longTripQuestion = scan.nextBoolean();
			System.out.println("Type amount of layovers:");
			ArrayList<String> layovers = new ArrayList<String>();
			int numLayovers = scan.nextInt();
			for (int i = 0; i < numLayovers; i++)
			{
				System.out.println("Type layover:");
				String layover = scan.next();
				layovers.add(layover);
			}
			System.out.println("Type the adult capacity:");
			int capacityAdults = scan.nextInt();
			System.out.println("Type the children capacity:");
			int capacityChildren = scan.nextInt();
			System.out.println("Type the first class price:");
			double classOnePrice = scan.nextDouble();
			System.out.println("Type the second class price:");
			double classTwoPrice = scan.nextDouble();
			System.out.println("Type price for bringing extra luggage:");
			double extraLuggagePrice = scan.nextDouble();
			System.out.println("Type date of flight");
			String date = scan.next();
			System.out.println("Type time of flight");
			String time = scan.next();
			Flights newFlight = new Flights(flightNumber, tripType, source, destination, longTripQuestion, layovers, capacityAdults, capacityChildren, classOnePrice, classTwoPrice, extraLuggagePrice, date, time);
			airline.addFlights(flightNumber, newFlight);
			System.out.println("You added a new Flight " + newFlight.toString());
			break;
		case 2: // Questions for the filtered search option
			System.out.println("Type flight number you want to remove:");
			int flightNum = scan.nextInt();
			airline.removeFlights(flightNum);
			break;
		}
		
		
	}
	
	/* This method is the blacklist option for the Menu
	 */
	public void blacklist(Airline airline) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Blacklist");
		System.out.println("Type the username of the user you want to blacklist:");
		String username = scan.next();
		
		airline.addBlacklist(username);
	}
	
	/* This method is the view ratings option for the Menu
	 */
	public void viewRatings(Airline airline) {
		System.out.println("View Ratings");
		Map<String, Ratings >ratingsMap = airline.getRatings();
		for (Ratings rating: ratingsMap.values())
			System.out.println(rating.toString());
	}
	
	/* This method is the give vouchers option for the Menu
	 */
	public void giveVoucher(Airline airline, Map<String, User> users) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Give Voucher");
		System.out.println("Type name of user getting voucher: ");
		String name = scan.next();
		System.out.println("How much would you like to give them as a voucher: ");
		double amount = scan.nextDouble();
		users.get(name).addVoucher(amount);
	}
	
	/* This method is the approve voucher option for the Menu
	 */
	public void approveVoucher(Airline airline, Map<String, User> users) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Approve Voucher");
		System.out.println("The following are the current vouchers waiting for approval.");
		for (Flights flight: airline.getFlights().values())
		{
			System.out.println("\nFlight Number: " + flight.getFlightNumber());
			System.out.println("\n" + flight.getChildCancel());
		}
		
		for (Flights flight: airline.getFlights().values())
		{
			System.out.println(flight.getAdultCancel() + "\n");
		}
		
		System.out.print("Would you like to approve any usernames requested refund: ");
		String approve = scan.next();
		
		System.out.print("What is the username you'd like approve: ");
		String usernameWaiting = scan.next();
		
		int flightNumberCheck = 0;
		if (approve.equalsIgnoreCase("yes"))
		{
			for (Flights flight: airline.getFlights().values())
			{
				if (flight.getAdultCancel().containsKey(usernameWaiting))
				{
					flightNumberCheck = flight.getFlightNumber();
					int amount = flight.getAdultCancel().get(usernameWaiting);
					flight.removeAdultCancel(usernameWaiting);
					flight.addCapacityAdults(amount);
				}
				if (flight.getChildCancel().containsKey(usernameWaiting))
				{
					flightNumberCheck = flight.getFlightNumber();
					int amount = flight.getChildCancel().get(usernameWaiting);
					flight.removeChildCancel(usernameWaiting);
					flight.addCapacityChildren(amount);
				}
			}
		}
		
		User userProfile = users.get(usernameWaiting);
		Map<Integer, Invoice> invoices = userProfile.getPurchaseHistory();
		for (Invoice invoice: invoices.values())
			if (invoice.getFlightNumber() == flightNumberCheck)
			{
				users.get(usernameWaiting).addVoucher(invoice.getPrice());
			}
		
	}

}
