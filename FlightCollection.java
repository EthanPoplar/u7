package assessment;

import java.util.ArrayList;
import java.util.List;

class FlightCollection {
	protected static final List<Flight> flights = new ArrayList<>();

	FlightCollection() {
		throw new IllegalStateException("FlightCollection is a utility class and cannot be instantiated");
	}

	public static List<Flight> getFlights()
	{
		return flights;
	}

	public static void addFlights(List<Flight> flights)
	{
		if (flights == null) {
			throw new NullPointerException("Cannot add null flight list");
		}
		FlightCollection.flights.addAll(flights);
	}

	public static void addFlight(Flight flight)
	{
		if (flight == null) {
			throw new NullPointerException("Cannot add null flight list");
		}
		FlightCollection.flights.add(flight);
	}

	public static void clearFlights()
	{
		FlightCollection.flights.clear();
	}

	public static Flight getFlightInfo(String city1, String city2)
	{
		//display the flights where there is a direct flight from city 1 to city2
		Flight flight = null;
		for (Flight f : flights)
		{
			if (f.getDepartFrom().equals(city2) && f.getDepartTo().equals(city1))
			{
				flight = f;
			}
		}
		return flight;
	}

	public static Flight getFlightInfo(String city)
	{
		//SELECT a flight where depart_to = city
		Flight flight = null;
		for (Flight f : flights)
		{
			if (f.getDepartTo().equals(city))
			{
				flight = f;
			}
		}
		return flight;
	}

	public static Flight getFlightInfo(int flightID)
	{
		//SELECT a flight with a particular flight id
		Flight flight =  null;

		for (Flight f : flights)
		{
			if (f.getFlightID() == flightID)
			{
				flight = f;
			}
		}
		return flight;
	}
}