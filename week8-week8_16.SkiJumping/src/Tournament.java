import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tournament {

    private List<Participant> participants;
    private Points points;
    private int roundNum;

    public Tournament() {
        this.participants = new ArrayList<Participant>();
        this.points = new Points();
        this.roundNum = 1;
    }

    public void addParticipant(String name) {
        participants.add(new Participant(name));
    }

    public void playRound() {
        printJumpOrder();

        for (Participant p : participants) {
            p.jump(roundNum);
        }

        printRoundResults();
        roundNum++;
    }

    public int getRound() {
        return roundNum;
    }

    public void sortParticipants() {
        Collections.sort(participants);
    }

    public void printJumpOrder() {
        sortParticipants();

        int count = 1;
        for (Participant p : participants) {
            System.out.println("  " + count + ". " + p.getName() + " ("
                    + p.totalScore() + " points)");
            count++;
        }
    }

    public void printRoundResults() {
        System.out.println("\nResults of round " + roundNum);

        for (Participant p : participants) {
            p.printJumpResults(roundNum);
        }
    }

    public void printFinalResults() {
        // Sort by descending
        Collections.sort(participants);
        Collections.reverse(participants);

        System.out.println("Position    Name");
        for (int i = 0; i < participants.size(); i++) {
            Participant p = participants.get(i);

            System.out.println((i + 1) + "           " + p.getName() + " ("
                    + p.totalScore() + " points)");
            System.out.print("            jump lengths: ");
            p.printLengths();
        }
    }
}