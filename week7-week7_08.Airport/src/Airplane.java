public class Airplane {

    private String airplaneID;
    private int capacity;

    public Airplane(String id, int capacity) {
        this.airplaneID = id;
        this.capacity = capacity;
    }

    public String getId() {
        return this.airplaneID;
    }

    @Override
    public String toString() {
        return this.airplaneID + " (" + this.capacity + " ppl)";
    }
}
