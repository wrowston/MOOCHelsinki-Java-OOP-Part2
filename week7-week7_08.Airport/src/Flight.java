public class Flight {

    private Airplane airplane;
    private String departureCode;
    private String destinationCode;

    public Flight(Airplane airplane, String departureCode, String destinationCode) {
        this.airplane = airplane;
        this.departureCode = departureCode;
        this.destinationCode = destinationCode;
    }

    @Override
    public String toString() {
        return this.airplane + " (" + this.departureCode + "-" + this.destinationCode + ")";
    }
}
