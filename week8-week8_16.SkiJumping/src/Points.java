import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Points {

    private Random random;
    private int length;
    private List<Integer> votes;

    public Points() {
        this.random = new Random();
        // Random int between 60 - 120
        this.length = random.nextInt(61) + 60;
        this.votes = new ArrayList<Integer>();
        generateVotes();
    }

    public int getLength() {
        return length;
    }

    private void generateVotes() {
        for (int i = 0; i < 5; i++) {
            // Random int between 10 - 20
            votes.add(random.nextInt(11) + 10);
        }
    }

    public void printVotes() {
        System.out.print("[");
        for (int i = 0; i < 4; i++) {
            System.out.print(votes.get(i) + ", ");
        }
        System.out.print(votes.get(4) + "]");
    }

    public int calculateScore() {
        int total = 0;

        Collections.sort(votes);
        for (int i = 1; i < votes.size() - 1; i++) {
            total += votes.get(i);
        }

        return total + length;
    }
}
