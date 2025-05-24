package fit5171.monash.edu;

public class Seat {
    private int seatsNumber;
    private char rowNumber;

    public Seat(int seatsNumber, char rowNumber) {
       setSeatsNumber(seatsNumber);
       setRowNumber(rowNumber);
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        if(seatsNumber<1 || seatsNumber>7)
            throw new IllegalArgumentException("Seats Number can only be between 1 and 7");
        this.seatsNumber = seatsNumber;
    }

    public char getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(char rowNumber) {
        if(rowNumber<'A' || rowNumber>'J') {
            throw new IllegalArgumentException("Row Number can only be between A and J");
        }
        this.rowNumber = rowNumber;
    }

    public String toString() {
        return seatsNumber + " " + rowNumber;
    }
}
