import java.util.ArrayList;

public class Box implements ToBeStored{

    private double maxWeight;
    private ArrayList<ToBeStored> storedInBox;

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        this.storedInBox = new ArrayList<ToBeStored>();
    }

    public void add(ToBeStored stored) {
        double weight = weight() + stored.weight();
        if (weight <= this.maxWeight) {
            this.storedInBox.add(stored);
        }
    }

    public int howManyThingsStored() {
        return this.storedInBox.size();
    }

    @Override
    public String toString() {
        return "Box: " + howManyThingsStored() + " things, total weight " + weight() + " kg";
    }

    @Override
    public double weight() {
        double weight = 0;

        for (ToBeStored stored : this.storedInBox) {
            weight += stored.weight();
        }
        return weight;
    }
}

