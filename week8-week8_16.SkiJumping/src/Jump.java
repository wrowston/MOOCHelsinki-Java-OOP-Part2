import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Jump {
    private int length;
    private List<Integer> votes;
    private Random random;

    public Jump() {
        this.random = new Random();
        this.length = random.nextInt(61) + 60;
        this.votes = new ArrayList<Integer>();

        for (int i = 0; i < 5; i++) {
            this.votes.add(this.random.nextInt(11) + 10);
        }
    }

    public int getLength() {
        return length;
    }

    public String printVotes() {
        String votes = "[";
        for (int i = 0; i < 4; i++) {
            votes += this.votes.get(i) + ", ";
        }
        votes += this.votes.get(4) + "]";
        return votes;
    }

    public int getValidVotes() {
        Collections.sort(this.votes);
        int validVotes = 0;
        for (int i = 1; i < 4; i++) {
            validVotes += this.votes.get(i);
        }
        return validVotes;
    }

    public int totalScore() {
        return this.length + getValidVotes();
    }

    @Override
    public String toString() {
        return "    length: " + this.length + "\n" + "    judge votes: " + this.printVotes();
    }
}
