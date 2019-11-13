package dungeon;

import java.util.List;

public abstract class GamePiece {
    String name;
    int x;
    int y;
    int length;
    int height;

    public GamePiece(String name, int length, int height) {
        this.name = name;
        this.length = length;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void move(List<String> moves) {

    }

    public void move(int moves, boolean vampiresMove) {

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return this.name + " " + this.x + " " + this.y;
    }

    @Override
    public boolean equals(Object object){
        if (object == null) {
            return false;
        }
        GamePiece compared = (GamePiece) object;
        if (this.x == compared.x && this.y == compared.y) {
            return true;
        } else {
            return false;
        }
    }
}

