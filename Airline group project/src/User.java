import java.util.*;

public class User extends Person {

	String username;
	String password;
	String accountType;
	double vouchers;
	Map<Integer, Invoice> purchaseHistory;
	int counterPurchaseKeys = 0;
	
	Scanner scan = new Scanner(System.in);
	
	User(String username, String password, String accountType) {
		super(username, password, accountType);

		this.purchaseHistory = new HashMap<>();
		this.vouchers = 0.0;
		
	}

	/* This method is the search option for the Menu
	 */
	public void search(Map<String, Airline> airlines) {
		System.out.println("\nSearch Menu Option");
		System.out.println("After searching if you're wanting to book/purchase a flight, remember the flight number.");
		System.out.print("Would you like a Round Trip or One Way Trip: ");
		String tripType = scan.next();
		System.out.print("Enter the date for takeoff (xx/xx/xx): ");
		String takeoff = scan.next();
		if (tripType.equalsIgnoreCase("Round Trip"))
		{
			System.out.print("Enter the date for the second takeoff (xx/xx/xx): ");
			takeoff += " " + scan.next();
		}
		System.out.print("Enter the source of the trip (City, State): ");
		String source = scan.next();
		System.out.print("Enter the destination of the trip: ");
		String destination = scan.next();
		System.out.print("Would you like to view the amount of Adult or Children tickets: ");
		String ticketType = scan.next();
		System.out.print("How many tickets: ");
		int tickets = scan.nextInt();
		
		for (Airline value: airlines.values())
		{
			if (!value.getBlacklist().contains(username))
				for (Flights flights: value.getFlights().values())
					if (flights.tripType().equalsIgnoreCase(tripType) && flights.getDate().equalsIgnoreCase(takeoff) && flights.getSource().equalsIgnoreCase(source) && flights.getDestination().equalsIgnoreCase(destination))
					{
						if (ticketType.equalsIgnoreCase("Adult") && flights.getCapacityAdults() > tickets)
							System.out.println(flights.toString()); 
						else if (ticketType.equalsIgnoreCase("Children") && flights.getCapacityChildren() > tickets)
							System.out.println(flights.toString());
					}
		}

	}
	
	/* This method is the filter search option for the Menu
	 */
	public void filter(Map<String, Airline> airlines) {
		
		int input = 0;
		while (input != 12) {
			System.out.println("\nFilter Menu Option");
			System.out.println("After searching if you're wanting to book/purchase a flight, remember the flight number.");
			System.out.println("Enter the correct number according to the MENU");
			System.out.println("1 for Trip Type Filtered Search");
			System.out.println("2 for Source Filtered Search");
			System.out.println("3 for Destination Filtered Search");
			System.out.println("4 for Layovers Filtered Search");
			System.out.println("5 for Capacity Adults Filtered Search");
			System.out.println("6 for Capacity Children Filtered Search");
			System.out.println("7 for Meal Filtered Search");
			System.out.println("7 for Class One Price Filtered Search");
			System.out.println("8 for Class Two Price Filtered Search");
			System.out.println("9 for Extra Luggage Price Filtered Search");
			System.out.println("10 for Date Filtered Search");
			System.out.println("11 for Time Filtered Search");
			System.out.println("12 to search");
			
			Map<Integer, Flights> validFlightNumbers = new HashMap<>();
			int option = scan.nextInt();
			input = option;
			switch (option) {
					case 1: 
						System.out.print("Would you like a Round Trip or One Way Trip: ");
						String trip = scan.next();
						for (Airline value: airlines.values())
						{
							if (!value.getBlacklist().contains(username))
								for (Flights flights: value.getFlights().values())
								{
									if (flights.tripType().equalsIgnoreCase(trip))
										validFlightNumbers.put(flights.getFlightNumber(), flights);
								}
						}
						if (validFlightNumbers.size() >= 1)
							for (Flights flights: validFlightNumbers.values())
								if (!(flights.tripType().equalsIgnoreCase(trip)))
									validFlightNumbers.remove(flights.getFlightNumber(), flights);
						break;
					case 2: 
						System.out.print("Enter the source of the trip (City, State): ");
						String source = scan.next();
						for (Airline value: airlines.values())
						{
							if (!value.getBlacklist().contains(username))
								for (Flights flights: value.getFlights().values())
								{
									if (flights.getSource().equalsIgnoreCase(source))
										validFlightNumbers.put(flights.getFlightNumber(), flights);
								}
						}
						if (validFlightNumbers.size() >= 1)
							for (Flights flights: validFlightNumbers.values())
								if (!(flights.getSource().equalsIgnoreCase(source)))
									validFlightNumbers.remove(flights.getFlightNumber(), flights);
						break;
					case 3:
						System.out.print("Enter the destination of the trip: ");
						String destination = scan.next();
						for (Airline value: airlines.values())
						{
							if (!value.getBlacklist().contains(username))
								for (Flights flights: value.getFlights().values())
								{
									if (flights.getDestination().equalsIgnoreCase(destination))
										validFlightNumbers.put(flights.getFlightNumber(), flights);
								}
						}
						if (validFlightNumbers.size() >= 1)
							for (Flights flights: validFlightNumbers.values())
								if (!(flights.getDestination().equalsIgnoreCase(destination)))
									validFlightNumbers.remove(flights.getFlightNumber(), flights);
						break;
					case 4: 
						System.out.print("What is the max amount of layovers: ");
						int maxLayovers = scan.nextInt();
						for (Airline value: airlines.values())
						{
							if (!value.getBlacklist().contains(username))
								for (Flights flights: value.getFlights().values())
								{
									if (flights.getLayovers().size() < maxLayovers)
										validFlightNumbers.put(flights.getFlightNumber(), flights);
								}
						}
						if (validFlightNumbers.size() >= 1)
							for (Flights flights: validFlightNumbers.values())
								if (!(flights.getLayovers().size() < maxLayovers))
									validFlightNumbers.remove(flights.getFlightNumber(), flights);
						break;
					case 5: 
						System.out.print("How many children tickets are you seeking: ");
						int children = scan.nextInt();
						for (Airline value: airlines.values())
						{
							if (!value.getBlacklist().contains(username))
								for (Flights flights: value.getFlights().values())
								{
									if (flights.getCapacityChildren() > children)
										validFlightNumbers.put(flights.getFlightNumber(), flights);
								}
						}
						if (validFlightNumbers.size() >= 1)
							for (Flights flights: validFlightNumbers.values())
								if (!(flights.getCapacityChildren() > children))
									validFlightNumbers.remove(flights.getFlightNumber(), flights);
						break;
					case 6: 
						System.out.print("How many adult tickets are you seeking: ");
						int adults = scan.nextInt();
						for (Airline value: airlines.values())
						{
							if (!value.getBlacklist().contains(username))
								for (Flights flights: value.getFlights().values())
								{
									if (flights.getCapacityAdults() > adults)
										validFlightNumbers.put(flights.getFlightNumber(), flights);
								}
						}
						if (validFlightNumbers.size() >= 1)
							for (Flights flights: validFlightNumbers.values())
								if (!(flights.getCapacityAdults() > adults))
									validFlightNumbers.remove(flights.getFlightNumber(), flights);
						break;
					case 7: 
						System.out.print("Only flights will a meal option will show");
						for (Airline value: airlines.values())
						{
							if (!value.getBlacklist().contains(username))
								for (Flights flights: value.getFlights().values())
								{
									if (flights.getTrip() == true)
										validFlightNumbers.put(flights.getFlightNumber(), flights);
								}
						}
						if (validFlightNumbers.size() >= 1)
							for (Flights flights: validFlightNumbers.values())
								if (flights.getTrip() == false)
									validFlightNumbers.remove(flights.getFlightNumber(), flights);
						break;
					case 8: 
						System.out.print("What's the max price for class one: ");
						double priceC1 = scan.nextDouble();
						for (Airline value: airlines.values())
						{
							if (!value.getBlacklist().contains(username))
								for (Flights flights: value.getFlights().values())
								{
									if (flights.getClassOnePrice() < priceC1)
										validFlightNumbers.put(flights.getFlightNumber(), flights);
								}
						}
						if (validFlightNumbers.size() >= 1)
							for (Flights flights: validFlightNumbers.values())
								if (!(flights.getClassOnePrice() < priceC1))
									validFlightNumbers.remove(flights.getFlightNumber(), flights);
						break;
					case 9: 
						System.out.print("What's the max price for class two: ");
						double priceC2 = scan.nextDouble();
						for (Airline value: airlines.values())
						{
							if (!value.getBlacklist().contains(username))
								for (Flights flights: value.getFlights().values())
								{
									if (flights.getClassOnePrice() < priceC2)
										validFlightNumbers.put(flights.getFlightNumber(), flights);
								}
						}
						if (validFlightNumbers.size() >= 1)
							for (Flights flights: validFlightNumbers.values())
								if (!(flights.getClassOnePrice() < priceC2))
									validFlightNumbers.remove(flights.getFlightNumber(), flights);
						break;
					case 10:
						System.out.print("What's the max price for extra luggage: ");
						double luggage = scan.nextDouble();
						for (Airline value: airlines.values())
						{
							if (!value.getBlacklist().contains(username))
								for (Flights flights: value.getFlights().values())
								{
									if (flights.getExtraLuggagePrice() < luggage)
										validFlightNumbers.put(flights.getFlightNumber(), flights);
								}
						}
						if (validFlightNumbers.size() >= 1)
							for (Flights flights: validFlightNumbers.values())
								if (!(flights.getExtraLuggagePrice() < luggage))
									validFlightNumbers.remove(flights.getFlightNumber(), flights);
						break;
					case 11: 
						System.out.print("Enter the date(s) for takeoff (xx/xx/xx): ");
						String date = scan.next();
						for (Airline value: airlines.values())
						{
							if (!value.getBlacklist().contains(username))
								for (Flights flights: value.getFlights().values())
								{
									if (flights.getDate().equalsIgnoreCase(date))
										validFlightNumbers.put(flights.getFlightNumber(), flights);
								}
						}
						if (validFlightNumbers.size() >= 1)
							for (Flights flights: validFlightNumbers.values())
								if (!(flights.getDate().equalsIgnoreCase(date)))
									validFlightNumbers.remove(flights.getFlightNumber(), flights);
						break;
					case 12: 
						System.out.println("What time(s) for take (xx:xx xx): ");
						String time = scan.next();
						for (Airline value: airlines.values())
						{
							if (!value.getBlacklist().contains(username))
								for (Flights flights: value.getFlights().values())
								{
									if (flights.getTime().equalsIgnoreCase(time))
										validFlightNumbers.put(flights.getFlightNumber(), flights);
								}
						}
						if (validFlightNumbers.size() >= 1)
							for (Flights flights: validFlightNumbers.values())
								if (!(flights.getTime().equalsIgnoreCase(time)))
									validFlightNumbers.remove(flights.getFlightNumber(), flights);
						break;
					case 13:
						System.out.println("Searching");
						System.out.println("The following flights are available according to your filtered search");
						if (validFlightNumbers.size() >= 1)
							for (Flights flights: validFlightNumbers.values())
								if ((flights.getCapacityAdults() == 0) && (flights.getCapacityChildren() == 0))
									validFlightNumbers.remove(flights.getFlightNumber(), flights);
								else
									System.out.println(flights.toString());
						break;
			}
		}
	}
	
	/* This method is the booking option for the Menu
	 */
	void book(Map<String, Airline> airlines) {
		System.out.print("What is flight number of the flight you're wanting to book: ");
		int flightNumber = scan.nextInt();
		for (Airline value: airlines.values())
			for (Flights flight: value.getFlights().values())
			{
				if (flight.getFlightNumber() == flightNumber)
				{
					System.out.print("How many adult tickets would you like to book: ");
					int numATickets = scan.nextInt();
					if (flight.getCapacityAdults() > numATickets)
					{
						flight.addAdultBookings(username, numATickets);
						flight.subCapacityAdults(numATickets);
					}
					System.out.print("How many child tickets would you like to book: ");
					int numCTickets = scan.nextInt();
					if (flight.getCapacityChildren() > numCTickets)
					{
						flight.addChildBookings(username, numCTickets);
						flight.subCapacityChildren(numCTickets);
				
					}
				}
			}
					
	}
	/* This method is the purchase option for the Menu
	 */
	void purchase(Map<String, Airline> airlines){
		System.out.print("What is flight number of the flight you're wanting to book: ");
		int flightNumber = scan.nextInt();
		System.out.print("Are you purchasing Adult or Children Tickets: ");
		String typeOfTicket = scan.next();
		System.out.print("Are you purchasing class one or two: ");
		int classNumber = scan.nextInt();
		System.out.print("Are you bringing extra luggage: ");
		String exLuggage = scan.next();
		System.out.println("How much of your vouchers would you like to use? (Enter 0.0 if you don't want to): ");
		double voucherAmount = scan.nextDouble();
		if (!(vouchers - voucherAmount >= 0))
		{
			voucherAmount = 0;
			System.out.println("The amount of vouchers you're wanting is too high.");
		}
		else 
		{
			for (Airline value: airlines.values())
				for (Flights flight: value.getFlights().values())
				{
					if (typeOfTicket.equalsIgnoreCase("children") && flight.getFlightNumber() == flightNumber)
					{
						int amount = flight.getChildBookings().get(username);
						flight.removeChildBookings(username);
						flight.subCapacityChildren(amount);
						flight.addChildPurchases(username, amount);
						
						double price = flight.getExtraLuggagePrice();
						
						if (classNumber == 1)
						{
							if (exLuggage.equalsIgnoreCase("yes"))
								price += flight.getClassOnePrice();
							else
								price = flight.getClassOnePrice();
		
							purchaseHistory.put(counterPurchaseKeys, new Invoice(value.getName(), flightNumber, (price - voucherAmount), "child"));
						}
						else 
						{
							if (exLuggage.equalsIgnoreCase("yes"))
								price += flight.getClassTwoPrice();
							else
								price = flight.getClassTwoPrice();
		
							purchaseHistory.put(counterPurchaseKeys, new Invoice(value.getName(), flightNumber, (price - voucherAmount), "child"));
						}
					}
					else if (typeOfTicket.equalsIgnoreCase("adult") && flight.getFlightNumber() == flightNumber)
					{
						int amount = flight.getAdultBookings().get(username);
						flight.removeAdultBookings(username);
						flight.subCapacityAdults(amount);
						flight.addAdultPurchases(username, amount);
						
						double price = flight.getExtraLuggagePrice();
						
						if (classNumber == 1)
						{
							if (exLuggage.equalsIgnoreCase("yes"))
								price += flight.getClassOnePrice();
							else
								price = flight.getClassOnePrice();
		
							purchaseHistory.put(counterPurchaseKeys, new Invoice(value.getName(), flightNumber, (price - voucherAmount), "adult"));
						}
						else 
						{
							if (exLuggage.equalsIgnoreCase("yes"))
								price += flight.getClassTwoPrice();
							else
								price = flight.getClassTwoPrice();
		
							purchaseHistory.put(counterPurchaseKeys, new Invoice(value.getName(), flightNumber, (price - voucherAmount), "adult"));
						}
					}
					counterPurchaseKeys += 1;
				}
		}
	}
	
	/* This method is for viewing your vouchers on the Menu
	 */
	public void viewVouchers(Map<String, Airline> airlines) {
		System.out.println("Your current voucher balance: " + vouchers);
	}
	
	void giveRating(Map<String, Airline> airlines) {
		System.out.println("Give Ratings");
		System.out.println("Type your username: ");
		String name = scan.next();
		System.out.println("Type the airline you flew: ");
		String airline = scan.next();
		System.out.println("Type flight number you were a part of: ");
		int flight = scan.nextInt();
		Map<Integer, Flights> flights = airlines.get(airline).getFlights();
		Map<String, Integer> adultPurchases = flights.get(flight).getAdultPurchases();
		if (adultPurchases.containsKey(username))
		{
			System.out.println("Type amount of stars you give this flight(1-5): ");
			int stars = scan.nextInt();
			System.out.println("Type a comment: ");
			String comment = scan.nextLine();
			Ratings r1 = new Ratings(name, stars, comment);
			airlines.get(airline).addRatings(name, r1);
		}
		else
			System.out.println("You can't review this flight");
	}
	
	/* This method is the get ratings option for the Menu
	 */
	void getRatings(Map<String, Airline> airlines) {
		System.out.println("Get Ratings");
		System.out.println("Type airline you want to see ratings from: ");
		String airlineName = scan.next();
		Airline a1 = airlines.get(airlineName);
		Map<String, Ratings >ratingsMap = a1.getRatings();
		for (Ratings rating: ratingsMap.values())
			System.out.println(rating.toString());
	}
	
	/* This method is to cancel a purchase on the menu
	 */
	void cancel(Map<String, Airline> airlines) {
		// ask for the flight number
		int flightNumber = scan.nextInt();
		// use that flight number to find the flight
		// ask if they're canceling an adult ticket or child ticket
		System.out.println("Are you cancelling a child ticket or an adult ticket? (child/adult)");
		String ticketType = scan.nextLine();
		
		for (Airline value: airlines.values()) 
		{
			for (Flights flight: value.getFlights().values()) 
			{
				//check if the flight numbers are the same
				if(flight.getFlightNumber() == flightNumber) 
				{
					// if adult ticket
					if(ticketType.equalsIgnoreCase("adult")) 
					{
						// check to see if their username is in the purchases map for adult 
						if(flight.getAdultPurchases().containsKey(username)) {
							// remove that purchase
							flight.removeAdultPurchases(username);
							// add to the cancel waitlist for adults
							flight.addAdultCancel(username, flight.getAdultPurchases().get(username));
							
						}
					}
					// if child ticket
					else if(ticketType.equalsIgnoreCase("child")) 
					{
						// check to see if their username is in the map for child
						if(flight.getChildPurchases().containsKey(username)) {
							// remove that purchase
							flight.removeChildPurchases(username);
							// add to the cancel waitlist for child
							flight.addChildCancel(username, flight.getChildPurchases().get(username));
						}
					}
					else
						System.out.println("Invalid ticket type, try again.");
						cancel(airlines);
				}
			}
		}
	}
	
	/* This method is to view your purchase history on the Menu
	 */
	void getPurchaseLog(Map<String, Airline> airlines) {
		for(int i = 0; i < counterPurchaseKeys; i++) {
			System.out.println(purchaseHistory.get(i));
		}
	}
	
	public void addVoucher(double amount) {
		this.vouchers += amount;
	}
	
	public Map<Integer, Invoice> getPurchaseHistory () {
		return purchaseHistory;
	}
	

}
