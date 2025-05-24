package fit5171.monash.edu;

import java.util.*;
import java.util.stream.Collectors;

public class Airplane
{
    private int airplaneID;
    private String airplaneModel;
    private int businessSeatsNumber;
    private int economySeatsNumber;
    private int crewSeatsNumber;
    private ArrayList<Seat> seats;
//    public static ArrayList<Airplane> airplanes = new ArrayList<Airplane>();

    public Airplane(int airplaneID, String airplaneModel, int businessSeatsNumber, int economySeatsNumber, int crewSeatsNumber, ArrayList<Seat> seats)
    {
        setSeats(seats);
        setAirplaneID(airplaneID);
        setAirplaneModel(airplaneModel);
        setBusinessSeatsNumber(businessSeatsNumber);
        setEconomySeatsNumber(economySeatsNumber);
        setCrewSeatsNumber(crewSeatsNumber);
    }

    public int getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(int airplaneID) {
        if(airplaneID<0)
        {
            throw new IllegalArgumentException("Airplane ID cannot be negative");
        }
        this.airplaneID = airplaneID;
    }

    public String getAirplaneModel() {
        return airplaneModel;
    }

    public void setAirplaneModel(String airplaneModel) {
        this.airplaneModel = airplaneModel;
    }

    public int getBusinessSeatsNumber() {
        return businessSeatsNumber;
    }

    public void setBusinessSeatsNumber(int businessSeatsNumber) {
        if(businessSeatsNumber<0 || businessSeatsNumber>80)
        {
            throw new IllegalArgumentException("Business Seats Number is between 0 and 80");
        }
        this.businessSeatsNumber = businessSeatsNumber;
    }

    public int getEconomySeatsNumber() {
        return economySeatsNumber;
    }

    public void setEconomySeatsNumber(int economySeatsNumber) {
        if(economySeatsNumber<0 || economySeatsNumber>350)
        {
            throw new IllegalArgumentException("Economy Seats Number is between 0 and 350");
        }
        this.economySeatsNumber = economySeatsNumber;
    }

    public int getCrewSeatsNumber() {
        return crewSeatsNumber;
    }

    public void setCrewSeatsNumber(int crewSeatsNumber) {
        if(crewSeatsNumber<0 || crewSeatsNumber>20)
        {
            throw new IllegalArgumentException("Crew Seats Number is between 0 and 20");
        }
        this.crewSeatsNumber = crewSeatsNumber;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = addSeat(seats);
    }

    private ArrayList<Seat> addSeat(ArrayList<Seat> seats) {
        Map<String, Seat> uniqueSeatsMap = new HashMap<>();
        for (Seat seat : seats) {
            String hash = seat.toString();
            if (!uniqueSeatsMap.containsKey(hash)) {
                uniqueSeatsMap.put(hash, seat);
            }
        }
        return new ArrayList<>(uniqueSeatsMap.values());
    }

    public String toString()
    {
        return "Airplane{" +
                "model=" + getAirplaneModel() + '\'' +
                ", business Seats=" + getBusinessSeatsNumber() + '\'' +
                ", economy Seats=" + getEconomySeatsNumber() + '\'' +
                ", crew Seats=" + getCrewSeatsNumber() + '\'' +
                '}';
    }

//	public static Airplane getAirPlaneInfo(int airplane_id) {
//		for (Airplane airplane : airplanes) {
//            if (airplane.getAirplaneID() == airplane_id) {
//                return airplane;
//            }
//        }
//		return null;
//	}

//    public static void addAirPlane(Airplane airplane) {
//        Airplane.airplane.add(airplane);
//    }
}