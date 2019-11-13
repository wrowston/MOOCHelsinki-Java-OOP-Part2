package boxes;

import java.util.ArrayList;
import java.util.List;

public class BlackHoleBox extends Box {
    private List<Thing> thingsInBox;

    public BlackHoleBox() {
        this.thingsInBox = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) {
        this.thingsInBox.add(thing);
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return false;
    }
}
