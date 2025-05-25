package assessment;

import java.sql.Timestamp;

public class Flight {
    private int flightID;
    private String departTo;
    private String departFrom;
    private String code;
    private String company;
    private Timestamp dateFrom;
    private Timestamp dateTo;
    Airplane airplane;

    public Flight(int flightId, String departTo, String departFrom, String code, String company, Timestamp dateFrom,Timestamp dateTo, Airplane airplane){
        //check if flight exists in the system
        if (!FlightCollection.getFlights().isEmpty())
        {
            for(Flight flight : FlightCollection.getFlights()) {
                if (flightId == flight.getFlightID()) {
                    throw new IllegalArgumentException("Flight Already in the system");
                }
            }
        }

        if (flightId == 0 || departFrom == null || departTo == null || code == null || company == null || airplane == null || dateFrom == null || dateTo == null)
        {
            throw new IllegalArgumentException("All fields are required");
        }
        setFlightID(flightId);
        setDepartFrom(departFrom);
        setDepartTo(departTo);
        setCode(code);
        setCompany(company);
        setDateFrom(dateFrom);
        setDateTo(dateTo);
        setAirplane(airplane);
    }

    public int getFlightID()
    {
        return flightID;
    }

    public void setFlightID(int flightId)
    {
        this.flightID = flightId;
    }

    public String getDepartTo()
    {
        return departTo;
    }

    public void setDepartTo(String departTo)
    {
        if(departTo==null || departTo.isEmpty()) {
            throw new IllegalArgumentException("Depart city cannot be null");
        }
        if(departTo.equals(this.departFrom)) {
            throw new IllegalArgumentException("City of departing to can not be the same city of departing from");
        }
        this.departTo = departTo;
    }

    public String getDepartFrom()
    {
        return departFrom;
    }

    public void setDepartFrom(String departFrom)
    {
        if(departFrom==null || departFrom.isEmpty()) {
            throw new IllegalArgumentException("Depart city cannot be null");
        }

        if(departFrom.equals(this.departTo)) {
            throw new IllegalArgumentException("City of departing to can not be the same city of departing from");
        }
        this.departFrom = departFrom;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCompany()
    {
        return company;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }

    public Timestamp getDateFrom()
    {
        return dateFrom;
    }

    public void setDateFrom(Timestamp dateFrom) {
        if(dateFrom == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        checkTimeFormat(dateFrom);
        if(this.dateTo !=null && (this.dateTo.before(dateFrom) || this.dateTo.equals(dateFrom))){
            throw new IllegalArgumentException("Date cannot be after or equal the date to");
        }
        this.dateFrom = dateFrom;
    }

    public Timestamp getDateTo()
    {
        return dateTo;
    }

    public void setDateTo(Timestamp dateTo) {
        if(dateTo == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        checkTimeFormat(dateTo);
        if(this.dateFrom !=null && (dateTo.before(this.dateFrom) || dateTo.equals(this.dateFrom))){
            throw new IllegalArgumentException("Date cannot be before or equal the date from");
        }
        this.dateTo = dateTo;
    }

    public void setAirplane(Airplane airplane)
    {
        this.airplane = airplane;
    }

    public Airplane getAirplane()
    {
        return airplane;
    }

    public String toString()
    {
            return "Flight{" + airplane.toString() +
                    ", date to=" +  getDateTo() + ", " + '\'' +
                    ", date from='" + getDateFrom() + '\'' +
                    ", depart from='" + getDepartFrom() + '\'' +
                    ", depart to='" + getDepartTo() + '\'' +
                    ", code=" + getCode() + '\'' +
                    ", company=" + getCompany() + '\'' +
                    ", code=" + getCode() + '\'' +
                    '}';
    }

    private void checkTimeFormat(Timestamp date) {
        // Date format checker
        String fmt = date.toString().split(" ")[0].trim();

        if (!fmt.matches("\\d{4}-\\d{2}-\\d{2}"))
        {
            throw new IllegalArgumentException("Date must be in YYYY-MM-DD format");
        }

        // Time format checker
        String timeFrom = date.toString().split(" ")[1].split("\\.")[0].trim();

        if (!timeFrom.matches("\\d{2}:\\d{2}:\\d{2}"))
        {
            throw new IllegalArgumentException("Time must be in HH:MM:SS format");
        }
    }
}
