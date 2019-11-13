package farmsimulator;

import java.util.ArrayList;
import java.util.List;

public class Farm implements Alive {

    private String owner;
    private Barn barn;
    private List<Cow> cows;

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        this.cows = new ArrayList<Cow>();
    }

    public String getOwner() {
        return owner;
    }

    public Barn getBarn() {
        return barn;
    }

    public List<Cow> getCows() {
        return cows;
    }

    public void addCow(Cow cow) {
        this.cows.add(cow);
    }

    public void manageCows() {
        this.barn.takeCareOf(this.cows);
    }

    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.barn.installMilkingRobot(milkingRobot);
    }

    @Override
    public void liveHour() {
        for (Cow cow : this.cows) {
            cow.liveHour();
        }
    }

    public StringBuilder printCows() {
        StringBuilder print = new StringBuilder();
        if (this.cows.isEmpty()) {
            print.append("No cows.");
        }
        for (Cow cow : this.cows) {
            print.append("        ").append(cow.toString()).append("\n");
        }
        return print;
    }

    @Override
    public String toString() {
        return "Farm owner: " + this.owner + "\nBarn bulk tank: "
                + this.barn.getBulkTank().toString() + "\nAnimals:\n"
                + printCows();
    }
}
