package boxes;

import java.util.ArrayList;
import java.util.List;

public class OneThingBox extends Box {
    private List<Thing> thingsInBox;

    public OneThingBox() {
        this.thingsInBox = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) {
        if (this.thingsInBox.isEmpty()) {
            this.thingsInBox.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return this.thingsInBox.contains(thing);
    }
}
