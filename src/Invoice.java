public class Invoice { 
	
	String airlineName;
	int flightNumber;
	double price;
	String typeOfTickets;
	
	Invoice(String airlineName, int flightNumber, double price, String typeOfTickets) {
		this.airlineName = airlineName;
		this.flightNumber = flightNumber;
		this.price = price;
		this.typeOfTickets = typeOfTickets;
	}
	
	public int getFlightNumber(){
		return flightNumber;
	}
	
	public String getAirlineName() {
		return airlineName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getType() {
		return typeOfTickets;
	}
	
	@Override
	public String toString() {
		return "\nFlight number: " + flightNumber + "\nAirline: " + airlineName+ "\nType of ticket: " + typeOfTickets + "/nPrice: " + price  + "\n";
	}
	
}
