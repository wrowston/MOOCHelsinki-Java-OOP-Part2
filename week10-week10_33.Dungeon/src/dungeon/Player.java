package dungeon;

import java.util.List;

public class Player extends GamePiece {

    public Player(String name, int length, int height) {
        super(name, length, height);
        this.x = 0;
        this.y = 0;
    }

    @Override
    public void move(List<String> moves) {
        for (String m : moves) {
            if (m.equals("w") && this.y - 1 < this.height && this.y - 1 >= 0) {
                this.y -= 1;
            } else if (m.equals("s") && this.y + 1 < this.height && this.y + 1 >= 0){
                this.y += 1;
            }else if(m.equals("a") && this.x - 1 < this.length && this.x - 1 >= 0){
                this.x -= 1;
            }else if(m.equals("d") && this.x + 1 < this.length && this.x + 1 >= 0){
                this.x += 1;
            }
        }
    }

    @Override
    public String toString() {
        return this.name + " " + this.x + " " + this.y;
    }
}
