package fit5171.monash.edu;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;

public class FlightCollection {
	
	public static ArrayList<Flight> flights = new ArrayList<>();

	public static ArrayList<Flight> getFlights() {
		return flights;
	}

	public static void addFlights(ArrayList<Flight> newFlights) {
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());

		if (newFlights == null) {
			throw new IllegalArgumentException("flights cannot be null");
		}

		ArrayList<Flight> validFlights = new ArrayList<>();

		for (Flight flight : newFlights) {
			if (flight == null || flight.getDateFrom().before(currentTime)) {
				continue;
			}

			boolean isDuplicate = false;

			for (Flight validFlight : validFlights) {
				if (validFlight.getFlightID() == flight.getFlightID()) {
					isDuplicate = true;
					break;
				}
			}
			if (isDuplicate) {
				continue;
			}

			for (Flight existFlight : flights) {
				if (existFlight.getFlightID() == flight.getFlightID()) {
					isDuplicate = true;
					break;
				}
			}
			if (!isDuplicate) {
				validFlights.add(flight);
			}
		}

		FlightCollection.flights.addAll(validFlights);
	}
	
	public static Flight getFlightInfo(String city1, String city2) {
//		removeAllDepartedFlights();
		city1 = city1.trim().toLowerCase();
		city2 = city2.trim().toLowerCase();

		if (city1.isEmpty() || city2.isEmpty()) {
			throw new IllegalArgumentException("City names cannot be empty");
		}

		if (city1.equals(city2)) {
			throw new IllegalArgumentException("Departure and arrival cities cannot be the same");
		}

		if (!isValidCityName(city1) || !isValidCityName(city2)) {
			throw new IllegalArgumentException("City name contains invalid characters");
		}

    	for (Flight flight : flights) {
			if(flight.getDepartFrom().toLowerCase().equals(city1) && flight.getDepartTo().toLowerCase().equals(city2)) {
				return flight;
			}
		}
		return null;
    }
    
    public static Flight getFlightInfo(String city) {
//		removeAllDepartedFlights();

		if (city == null || city.isEmpty()) {
			throw new IllegalArgumentException("City name cannot be empty");
		}

		city = city.trim().toLowerCase();

		if (!isValidCityName(city)) {
			throw new IllegalArgumentException("City name contains invalid characters");
		}

		for (Flight flight : flights) {
			System.out.println(flight.getDepartTo().toLowerCase() + " " +city  + " " + flight.getDepartTo().toLowerCase().equals(city));
			if(flight.getDepartTo().toLowerCase().equals(city)) {
				return flight;
			}
		}
		return null;
    }

    public static Flight getFlightInfo(int flight_id) {
		removeAllDepartedFlights();

		if (flight_id < 0) {
			throw new IllegalArgumentException("Flight ID cannot be negative");
		}

		for (Flight flight : flights) {
			if(flight.getFlightID() == flight_id) {
				return flight;
			}
		}
    	throw new IllegalArgumentException("Flight not found.");
    }

	// helper function to check if city name is valid
	private static boolean isValidCityName(String cityName) {
		// City names should only contain letters, spaces, and hyphens
		return cityName.matches("^[a-z\\s\\-]+$");
	}

	// helper function to remove all departed flights from flights list
	private static void removeAllDepartedFlights() {
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		Iterator<Flight> iterator = flights.iterator();
		while (iterator.hasNext()) {
			Flight flight = iterator.next();
			if (flight.getDateFrom().before(currentTime)) {
				iterator.remove();
			}
		}
	}
}
