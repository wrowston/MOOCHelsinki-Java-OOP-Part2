package movable;

import java.util.ArrayList;
import java.util.List;

public class Group implements Movable {
    private List<Movable> groupOrganisms;

    public Group() {
        this.groupOrganisms = new ArrayList<Movable>();
    }

    public void addToGroup(Movable movable) {
        this.groupOrganisms.add(movable);
    }

    @Override
    public String toString() {
        StringBuilder group = new StringBuilder();
        for (Movable movable : this.groupOrganisms) {
            group.append(movable.toString()).append("\n");
        }
        return group.toString();
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable movable : this.groupOrganisms) {
            movable.move(dx, dy);
        }
    }
}
