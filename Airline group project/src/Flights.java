import java.util.*;

public class Flights {
	private int flightNumber; 
	private String tripType;
	private String source;
	private String destination;
	private boolean longTrip;
	private ArrayList<String> layovers;
	private int capacityAdults;
	private int capacityChildren;
	private ArrayList<String> meals;
	private double classOnePrice;
	private double classTwoPrice;
	private double extraLuggagePrice;
	private String date;
	private String time;
	private Map<String, Integer> childrenBookings;
	private Map<String, Integer> adultBookings;
	private Map<String, Integer> childrenPurchases;
	private Map<String, Integer> adultPurchases;
	private Map<String, Integer> cancelWaitlistChildren;
	private Map<String, Integer> cancelWaitlistAdult;
	
	public Flights(int flightNumber, String tripType, String source, String destination, Boolean longTrip, ArrayList<String> layovers, int capacityAdults, int capacityChildren, double classOnePrice, double classTwoPrice, double extraLuggagePrice, String date, String time) {
		this.flightNumber = flightNumber;
		this.tripType = tripType;
		this.source = source;
		this.destination = destination;
		this.longTrip = longTrip;
		this.layovers = layovers;
		this.capacityAdults = capacityAdults;
		this.capacityChildren = capacityChildren;
		this.meals = new ArrayList<>();
		this.classOnePrice = classOnePrice;
		this.classTwoPrice = classTwoPrice;
		this.extraLuggagePrice = extraLuggagePrice;
		this.date = date;
		this.time = time;
		this.childrenBookings = new HashMap<>();
		this.adultBookings = new HashMap<>();
		this.childrenPurchases = new HashMap<>();
		this.adultPurchases = new HashMap<>();
	}
	
	/* This method views the flight number
	 *  @return the flight number
	 */
	public int getFlightNumber() {
		return flightNumber;
	}
	
	/* This method views the trip type
	 *  @return the trip type
	 */
	public String tripType() {
		return tripType;
	}
	
	/* This method views the trip's source
	 *  @return the trip's source
	 */
	public String getSource() {
		return source;
	}
	
	/* This method views the trip's destination
	 *  @return the trip's destination
	 */
	public String getDestination() {
		return destination;
	}
	
	public boolean getTrip() {
		return longTrip;
	}
	
	/* This method views the lay overs
	 *  @return the lay overs in an array list
	 */
	public ArrayList<String> getLayovers() {
		return layovers;
	}
	
	/* This method views the capacity for Adults
	 *  @return the capacity
	 */
	public int getCapacityAdults() {
		return capacityAdults;
	}
	
	/* This method views the capacity for Children
	 *  @return the capacity
	 */
	public int getCapacityChildren() {
		return capacityChildren;
	}
	
	/* This method views the meals list
	 *  @return the meals in an array list
	 */
	public ArrayList<String> getMeals() {
		return meals;
	}
	
	/* This method views the price of class one
	 *  @return the price
	 */
	public double getClassOnePrice() {
		return classOnePrice;
	}
	
	/* This method views the price of class two
	 *  @return the price
	 */
	public double getClassTwoPrice() {
		return classTwoPrice;
	}
	
	/* This method views the price of extra luggage
	 *  @return the price
	 */
	public double getExtraLuggagePrice() {
		return extraLuggagePrice;
	}
	
	/* This method views the date
	 *  @return the date
	 */
	public String getDate() {
		return date;
	}
	
	/* This method views the time
	 *  @return the time
	 */
	public String getTime() {
		return time;
	}
	
	public Map<String, Integer> getChildBookings() {
		return childrenBookings;
	}
	
	public Map<String, Integer> getAdultBookings() {
		return adultBookings;
	}
	
	public Map<String, Integer> getChildPurchases() {
		return childrenPurchases;
	}
	
	public Map<String, Integer> getAdultPurchases() {
		return adultPurchases;
	}
	
	public Map<String, Integer> getChildCancel() {
		return cancelWaitlistChildren;
	}
	
	public Map<String, Integer> getAdultCancel() {
		return cancelWaitlistAdult;
	}
	
	public void removeChildBookings(String username) {
		childrenBookings.remove(username);
	}
	
	public void removeAdultBookings(String username) {
		adultBookings.remove(username);
	}

	public void removeChildPurchases(String username) {
		childrenPurchases.remove(username);
	}

	public void removeAdultPurchases(String username) {
		adultPurchases.remove(username);
	}
	
	public void addCapacityAdults(int num) {
		capacityAdults += num;
	}

	public void addCapacityChildren(int num) {
		capacityChildren += num;
	}
	
	public void subCapacityAdults(int num) {
		capacityAdults -= num;
	}

	public void subCapacityChildren(int num) {
		capacityChildren -= num;
	}
	
	public void addChildBookings(String username, int amount) {
		childrenBookings.put(username, amount);
	}
	
	public void addAdultBookings(String username, int amount) {
		adultBookings.put(username, amount);
	}
	
	public void addChildPurchases(String username, int amount) {
		childrenPurchases.put(username, amount);
	}
	
	public void addAdultPurchases(String username, int amount) {
		adultPurchases.put(username, amount);
	}
	
	public void addAdultCancel(String username, int amount) {
		cancelWaitlistAdult.put(username, amount);
	}
	
	public void addChildCancel(String username, int amount) {
		cancelWaitlistChildren.put(username, amount);
	}
	
	public void removeAdultCancel(String username) {
		cancelWaitlistAdult.remove(username);
	}
	
	public void removeChildCancel(String username) {
		cancelWaitlistChildren.remove(username);
	}
	
	public String toString() {
		String fullString = "";
		fullString += "Flight Number: " + flightNumber + "\nTrip Type: " + tripType + "\nSource: " + source + "\nDestination: " + destination + "\nLayovers: ";
		for (String lay: layovers)
			fullString += lay + " ";
		fullString += "\nCapacity Adults: " + capacityAdults + "\nCapacity Children: " + capacityChildren + "\nMeals: ";
		for (String meal: meals)
			fullString += meal + " ";
		fullString += "\nClass One Price: " + classOnePrice + "\nClass Two Price: " + classTwoPrice + "\nExtra Luggage Price: " + extraLuggagePrice + "\nDate: " + date + "  Time: " + time;
		return fullString;
	}

}
