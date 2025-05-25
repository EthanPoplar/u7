package assessment;

import java.util.LinkedHashMap;
import java.util.*;
import java.util.stream.IntStream;

public class Airplane {
    private int airplaneID;
    private String airplaneModel;
    private int businessSeatsNumber;
    private int economySeatsNumber;
    private int crewSeatsNumber;
    private Map<Character, List<String>> seatMap;


    public Airplane(int airplaneID, String airplaneModel, int businessSitsNumber, int economySeatsNumber, int crewSeatsNumber)
    {
        setAirplaneID(airplaneID);
        setAirplaneModel(airplaneModel);
        setBusinessSeatsNumber(businessSitsNumber);
        setEconomySeatsNumber(economySeatsNumber);
        setCrewSeatsNumber( crewSeatsNumber);
        buildSeatMap();
    }

    private void buildSeatMap() {
        seatMap = new LinkedHashMap<>();
        for (char row = 'A'; row <= 'J'; row++) {
            seatMap.put(row, IntStream.rangeClosed(1, 7)
                    .mapToObj(String::valueOf).toList());
        }
    }

    public Map<Character, List<String>> getSeatMap() {
        return Collections.unmodifiableMap(seatMap);
    }

    public int getAirplaneID()
    {
        return airplaneID;
    }

    public void setAirplaneID(int airplaneID)
    {
        if (airplaneID <= 0) {
            throw new IllegalArgumentException("Airplane ID must be a positive integer.");
        }
        this.airplaneID = airplaneID;
    }

    public String getAirplaneModel()
    {
        return airplaneModel;
    }

    public void setAirplaneModel(String airplaneModel)
    {
        if (airplaneModel == null || airplaneModel.trim().isEmpty()) {
            throw new IllegalArgumentException("Airplane model is required.");
        }
        this.airplaneModel = airplaneModel;
    }

    public int getBusinessSeatsNumber()
    {
        return businessSeatsNumber;
    }

    public void setBusinessSeatsNumber(int businessSeatsNumber)
    {
        if(businessSeatsNumber<0 || businessSeatsNumber>80){
            throw new IllegalArgumentException("Business Seats Number is between 0 and 80");
        }
        this.businessSeatsNumber = businessSeatsNumber;
    }

    public int getEconomySeatsNumber()
    {
        return economySeatsNumber;
    }

    public void setEconomySeatsNumber(int economySeatsNumber) {
        if(economySeatsNumber<0 || economySeatsNumber>350)
        {
            throw new IllegalArgumentException("Economy Seats Number is between 0 and 350");
        }
        this.economySeatsNumber = economySeatsNumber;
    }

    public int getCrewSeatNumber()
    {
        return crewSeatsNumber;
    }

    public void setCrewSeatsNumber(int crewSeatsNumber) {
        if(crewSeatsNumber<0 || crewSeatsNumber>20)
        {
            throw new IllegalArgumentException("Crew Seats Number is between 0 and 20");
        }
        this.crewSeatsNumber = crewSeatsNumber;
    }

    public String toString()
    {
        return "Airplane{" +
                "model=" + getAirplaneModel() + '\'' +
                ", business sits=" + getBusinessSeatsNumber() + '\'' +
                ", economy sits=" + getEconomySeatsNumber() + '\'' +
                ", crew sits=" + getCrewSeatNumber() + '\'' +
                '}';
    }
}