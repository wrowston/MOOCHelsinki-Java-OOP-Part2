package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dungeon {
    private GameBoard game;
    private int moves;
    private Scanner reader;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove){
        this.game = new GameBoard(length, height, vampires, vampiresMove);
        this.moves = moves;
        this.reader = new Scanner(System.in);
    }

    public void run(){
        int i = moves;
        System.out.println(i);
        this.game.printGameBoard();

        while(i > 0){
            if(this.game.getGamePieces().size() == 1){
                break;
            }

            String input = reader.nextLine();
            List<String> commands = new ArrayList<String>();

            for(int j = 0; j < input.length(); j++){
                commands.add(input.substring(j, j+1));
            }
            this.game.moveAndRemoveCharacters(commands);
            i--;
            System.out.println(i);
            this.game.printGameBoard();
        }

        if(this.game.getGamePieces().size() == 1) {
            System.out.println("YOU WIN");
        } else {
            System.out.println("YOU LOSE");
        }
    }
}
