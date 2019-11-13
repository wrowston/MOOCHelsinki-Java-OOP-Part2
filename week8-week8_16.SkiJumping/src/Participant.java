import java.util.HashMap;
import java.util.Map;

public class Participant implements Comparable<Participant> {

    private String name;
    private Map<Integer, Points> points;

    public Participant(String name) {
        this.name = name;
        this.points = new HashMap<Integer, Points>();
    }

    public String getName() {
        return name;
    }

    public void jump(int round) {
        points.put(round, new Points());
    }

    public int totalScore() {
        int total = 0;

        for (Points p : points.values()) {
            total += p.calculateScore();
        }

        return total;
    }

    @Override
    public int compareTo(Participant other) {
        return this.totalScore() - other.totalScore();
    }

    public void printRoundLength(int round) {
        Points roundPoints = points.get(round);

        System.out.println(roundPoints.getLength());
    }

    public void printLengths() {
        int nPoints = points.size();

        for (int i = 1; i <= nPoints; i++) {
            Points roundPoints = points.get(i);
            if (i < nPoints) {
                System.out.print(roundPoints.getLength() + " m, ");
            } else {
                System.out.println(roundPoints.getLength() + " m");
            }
        }
    }

    public void printJumpResults(int round) {
        Points roundPoints = points.get(round);

        System.out.println("  " + name);
        System.out.println("    length: " + roundPoints.getLength());
        System.out.print("    judge votes: ");
        roundPoints.printVotes();
        System.out.println();
    }
}