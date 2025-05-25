package fit5171.monash.edu;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Flight {
    private int flightID;
    private String departTo;
    private String departFrom;
    private String code;
    private String company;
    private Timestamp dateFrom;
    private Timestamp dateTo;
    Airplane airplane;

    public Flight(int flight_id, String departTo, String departFrom, String code, String company, Timestamp dateFrom,Timestamp dateTo, Airplane airplane) throws ParseException {
            setFlightID(flight_id);
            setDepartTo(departTo);
            setDepartFrom(departFrom);
            setCode(code);
            setCompany(company);
            setAirplane(airplane);
            setDateTo(dateTo);
            setDateFrom(dateFrom);
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightid) {
        this.flightID = flightid;
    }

    public String getDepartTo() {
        return departTo;
    }

    public void setDepartTo(String departTo) {
        if(departTo==null || departTo.isEmpty()) {
            throw new IllegalArgumentException("Depart city cannot be null");
        }
        if(departTo.equals(this.departFrom)) {
            throw new IllegalArgumentException("City of departing to can not be the same city of departing from");
        }
        this.departTo = departTo;
    }

    public String getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(String departFrom) {
        if(departFrom==null || departFrom.isEmpty()) {
            throw new IllegalArgumentException("Depart city cannot be null");
        }

        if(departFrom.equals(this.departTo)) {
            throw new IllegalArgumentException("City of departing to can not be the same city of departing from");
        }
        this.departFrom = departFrom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Timestamp getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Timestamp dateFrom) throws ParseException {
        checkTimeFormat(dateFrom);
        if(this.dateTo !=null && (this.dateTo.before(dateFrom) || this.dateTo.equals(dateFrom))){
            throw new IllegalArgumentException("Date cannot be before or equal the date from");
        }
        this.dateFrom = dateFrom;
    }

    private void checkTimeFormat(Timestamp date) throws ParseException {
        if(date == null){
            throw new IllegalArgumentException("Date cannot be null");
        }
        String inputDate = date.toString();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            format.parse(inputDate);
        }catch (ParseException e){
            throw new ParseException("Date must be in YYYY-MM-DD HH:MM:SS format.", 0);
        }
    }

    public Timestamp getDateTo() {
        return dateTo;
    }

    public void setDateTo(Timestamp dateTo) throws ParseException {
        checkTimeFormat(dateTo);
        if(this.dateFrom !=null && (dateTo.before(this.dateFrom) || dateTo.equals(this.dateFrom))){
            throw new IllegalArgumentException("Date cannot be before or equal the date from");
        }
        this.dateTo = dateTo;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Airplane getAirplane() {
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
}

