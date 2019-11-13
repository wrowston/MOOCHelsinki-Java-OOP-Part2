package dungeon;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private Pieces pieces;
    private List<String> gameBoard;
    private int length;
    private int height;
    private boolean vampiresMove;

    public GameBoard(int length, int height, int vampires,boolean vampiresMove) {
        this.pieces = new Pieces(length, height, vampires);
        this.gameBoard = new ArrayList<String>();
        this.length = length;
        this.height = height;
        this.vampiresMove = vampiresMove;
    }

    public void createGrid() {
        this.gameBoard.clear();
        List<GamePiece> players = this.pieces.getPieces();

        for (int y = 0; y < length; y++) {
            List<GamePiece> playersOnY = new ArrayList<GamePiece>();
            for (GamePiece gp : players) {
                if (gp.getY() == y) {
                    playersOnY.add(gp);
                }
            }
            String line = "";
            for(int x = 0; x < this.length; x++){
                boolean containsPlayer = false;
                for(GamePiece gamePiece : playersOnY){
                    if(x == gamePiece.getX()){
                        line += gamePiece.getName();
                        containsPlayer = true;
                    }
                }
                if(!containsPlayer){
                    line += ".";
                }
            }
            this.gameBoard.add(line);
        }
    }

    public List<GamePiece> getGamePieces(){
        return this.pieces.getPieces();
    }

    public void printGameBoard(){
        System.out.println();
        this.pieces.printPieces();

        System.out.println();
        this.createGrid();

        for(String g : this.gameBoard){
            System.out.println(g);
        }
        System.out.println();
    }

    public void moveAndRemoveCharacters(List<String> moves){
        this.pieces.moveAndRemovePieces(moves, vampiresMove);
    }
}
