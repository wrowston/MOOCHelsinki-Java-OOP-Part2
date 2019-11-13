package boxes;

import java.util.ArrayList;
import java.util.List;

public class MaxWeightBox extends Box {
    private int maxWeight;
    private List<Thing> thingsInBox;

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.thingsInBox = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) {
        int thingsListWeight = 0;
        for (Thing t : this.thingsInBox) {
            thingsListWeight += t.getWeight();
        }

        if (thingsListWeight + thing.getWeight() <= this.maxWeight) {
            this.thingsInBox.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return this.thingsInBox.contains(thing);
    }
}
