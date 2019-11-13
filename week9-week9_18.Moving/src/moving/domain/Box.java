package moving.domain;

import java.util.ArrayList;
import java.util.List;

public class Box implements Thing{

    private int maximumCapacity;
    private List<Thing> thingsInBox;

    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.thingsInBox = new ArrayList<Thing>();
    }

    public boolean addThing(Thing thing) {
        if (this.getVolume() + thing.getVolume() > this.maximumCapacity) {
            return false;
        }

        this.thingsInBox.add(thing);
        return true;
    }

    @Override
    public int getVolume() {
        int volume = 0;
        for (Thing thing : this.thingsInBox) {
            volume += thing.getVolume();
        }
        return volume;
    }
}
