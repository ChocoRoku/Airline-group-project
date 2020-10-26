import java.util.*;

public class Airline { 
	String name;
	ArrayList<String> blacklist;
	ArrayList<String> administrators;
	Map<Integer, Flights> flights;
	Map<String, Ratings> ratings;
	
	
	Airline(String name, ArrayList<String> adminList) {
		this.name = name;
		this.blacklist = new ArrayList<>();
		this.administrators = adminList;
		this.ratings = new HashMap<>();
	}
	
	/* This method adds a user to the blacklist list
	 *  @param user the object that's going to be added to the blacklist list
	 */
	public void addBlacklist(String username) {
		this.blacklist.add(username);
	}
	
	/* This method adds an administrator to the administrators list
	 *  @param admin the object that's going to be added to the administrators list
	 */
	public void addAdministrator(String username) {
		this.administrators.add(username);
	}
	
	/* This method adds a flight to the flights list
	 *  @param flight the object that's going to be added to the flights list
	 */
	public void addFlights(int flightNumber, Flights flight) {
		this.flights.put(flightNumber, flight);
	}
	
	public void removeFlights(int flightNumber) {
		this.flights.remove(flightNumber);
	}

	
	/* This method adds a rating to the ratings list
	 *  @param rating the object that's going to be added to the ratings list
	 */
	public void addRatings(String username, Ratings rating) {
		this.ratings.put(username, rating);
	}
	
	/* This method views the airline's name
	 *  @return the airline name
	 */
	public String getName() {
		return name;
	}
	
	/* This method views the blacklist list
	 *  @return the blacklist list as an array list
	 */
	public ArrayList<String> getBlacklist() {
		return blacklist;
	}
	
	/* This method views the administrators list
	 *  @return the administrator list as an array list
	 */
	public ArrayList<String> getAdministrators() {
		return administrators;
	}
	
	/* This method views the flights list
	 *  @return the flights list as an array list
	 */
	public Map<Integer, Flights> getFlights() {
		return flights;
	}
	
	/* This method views the ratings list
	 *  @return the ratings list as an array list
	 */
	public Map<String, Ratings> getRatings() {
		return ratings;
	}

}
 