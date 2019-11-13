import java.util.ArrayList;

public class Changer {

    private ArrayList<Change> changeArray;

    public Changer() {
        this.changeArray = new ArrayList<Change>();
    }

    public void addChange(Change change){
        this.changeArray.add(change);
    }

    public String change(String characterString) {
        String changedString = characterString;
        for (Change change : changeArray) {
            changedString = change.change(changedString);
        }
        return changedString;
    }
}
