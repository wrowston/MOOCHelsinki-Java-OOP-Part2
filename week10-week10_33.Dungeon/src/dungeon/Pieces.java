package dungeon;

import java.util.ArrayList;
import java.util.List;

public class Pieces {
    private List<GamePiece> pieces;

    public Pieces(int length, int height, int vampires) {
        this.pieces = new ArrayList<GamePiece>();
        Player player = new Player("@", length, height);
        this.pieces.add(player);

        while (this.pieces.size() <= vampires) {
            Vampire v = new Vampire("v", length, height);
            if (!this.pieces.contains(v)) {
                this.pieces.add(v);
            }
        }
    }

    public void printPieces() {
        for (GamePiece gamePiece : this.pieces) {
            System.out.println(gamePiece);
        }
    }

    public List<GamePiece> getPieces() {
        return this.pieces;
    }

    public void moveAndRemovePieces(List<String> moves, boolean vampiresMove) {
        List<GamePiece> movedVampires = new ArrayList<GamePiece>();
        GamePiece player = new Player("", 0, 0);

        for (GamePiece gamePiece : this.pieces) {
            if (gamePiece.getName().equals("@")) {
                gamePiece.move(moves);
                player = gamePiece;
            } else {
                gamePiece.move(moves.size(), vampiresMove);
                if (!movedVampires.contains(gamePiece)) {
                    movedVampires.add(gamePiece);
                }
            }
        }
        List<GamePiece> toBeRemoved = new ArrayList<GamePiece>();
        for (GamePiece vampire : movedVampires) {
            if (vampire.equals(player)) {
                toBeRemoved.add(vampire);
            }
        }
        movedVampires.removeAll(toBeRemoved);
        this.pieces.clear();;
        this.pieces.add(player);
        this.pieces.addAll(movedVampires);
    }
}
