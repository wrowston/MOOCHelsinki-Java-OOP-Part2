import java.util.HashMap;
import java.util.Map;

public class Athlete implements Comparable<Athlete>{
    private String name;
    private Map<Integer, Jump> score;

    public Athlete(String name) {
        this.name = name;
        this.score = new HashMap<Integer, Jump>();
    }

    public String getName() {
        return name;
    }

    public void jump(int round) {
        this.score.put(round, new Jump());
    }

    public Jump getJumpScore(int round) {
        return this.score.get(round);
    }

    public int getTotalScore() {
        int totalScore = 0;

        for (Jump jump : this.score.values()) {
            totalScore += jump.totalScore();
        }
        return totalScore;
    }

    public String printResults() {
        return this.name + " (" + this.getTotalScore() + " points)";
    }

    public String printLengths() {
        String printLengths = "";
        for (Jump jump : this.score.values()) {
            printLengths = " " + jump.getLength() + " m,";
        }
        printLengths = printLengths.substring(0, printLengths.length() - 1); //deletes comma at the end
        return printLengths;
    }

    @Override
    public int compareTo(Athlete athlete) {
        return this.getTotalScore() - athlete.getTotalScore();
    }

    @Override
    public String toString() {
        return "           " + this.printResults() + "\n            jump lengths:" + this.printLengths();
    }
}
