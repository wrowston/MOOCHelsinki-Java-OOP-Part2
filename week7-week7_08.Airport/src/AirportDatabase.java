import java.util.HashMap;


public class AirportDatabase {

    private HashMap<String, Airplane> planes = new HashMap<String, Airplane>();
    private HashMap<String, Flight> flights = new HashMap<String, Flight>();

    public void addPlane(String id, String capacity) {
        Airplane plane = new Airplane(id, Integer.parseInt(capacity));
        this.planes.put(id, plane);
    }

    public void addFlight(String id, String departureCode, String destinationCode) {
        Airplane plane = searchPlanesById(id);
        Flight flight = new Flight(plane, departureCode, destinationCode);
        this.flights.put(flight.toString(),flight);
    }

    public void printPlanes() {
        for (Airplane plane : this.planes.values()) {
            System.out.println(plane);
        }
    }

    public void printFlights() {
        for (Flight flight: this.flights.values()) {
            System.out.println(flight);
        }
    }

    public Airplane searchPlanesById(String id) {
        for (Airplane plane : this.planes.values()) {
            if (plane.getId().equals(id)) {
                return plane;
            }
        }
        return null;
    }
}