import java.util.*;

public class Airline extends Account{
	ArrayList<Traveler> blacklist;
	ArrayList<Flight> flights;

	//TODO: I don't really get the meaning of the ratings.
	Map<String, Ratings> ratings;
	
	
	Airline(String username, String password) {
		super(username, password);

		this.blacklist = new ArrayList<Traveler>();
		this.ratings = new HashMap<>();
	}
	
	/* This method adds a user to the blacklist list
	 *  @param user the object that's going to be added to the blacklist list
	 */
	public void addBlacklist(Traveler traveler) {
		this.blacklist.add(traveler);
	}
	
	/* This method adds an administrator to the administrators list
	 *  @param admin the object that's going to be added to the administrators list
	 */

	
	/* This method adds a flight to the flights list
	 *  @param flight the object that's going to be added to the flights list
	 */
	public void addFlights(Flight flight) {
		flights.add(flight);
	}
	
	public void removeFlights(Flight flight) {flights.remove(flight);}

	
	/* This method adds a rating to the ratings list
	 *  @param rating the object that's going to be added to the ratings list
	 */
//	public void addRatings(String username, Ratings rating) {
//		this.ratings.put(username, rating);
//	}
	
	/* This method views the airline's name
	 *  @return the airline name
	 */

	
	/* This method views the blacklist list
	 *  @return the blacklist list as an array list
	 */
	public ArrayList<Traveler> getBlacklist() {
		return blacklist;
	}
	
	/* This method views the administrators list
	 *  @return the administrator list as an array list
	 */

	
	/* This method views the flights list
	 *  @return the flights list as an array list
	 */
	public ArrayList<Flight> getFlights() {
		return flights;
	}
	
	/* This method views the ratings list
	 *  @return the ratings list as an array list
	 */
	public Map<String, Ratings> getRatings() {
		return ratings;
	}

}
 