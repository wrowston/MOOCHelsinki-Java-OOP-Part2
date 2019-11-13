package dungeon;

import java.util.Random;

public class Vampire extends GamePiece{

    private Random random;

    public Vampire(String name, int length, int height) {
        super(name, length, height);
        this.random = new Random();
        this.x = random.nextInt(length);
        this.y = random.nextInt(height);
    }

    @Override
    public void move(int moves, boolean vampireMoves){
        if(vampireMoves){
            for(int i = 0; i < moves; i++){
                int rand = random.nextInt(4);
                if(rand == 0 && this.x + 1 < this.length && this.x + 1 >= 0){
                    this.x += 1;
                }else if(rand == 1 && this.x - 1 < this.length && this.x - 1 >= 0){
                    this.x -= 1;
                }else if(rand == 2 && this.y + 1 < this.height && this.y + 1 >= 0){
                    this.y += 1;
                }else if(rand == 3 && this.y - 1 < this.height && this.y - 1 >= 0){
                    this.y -= 1;
                }
            }
        }
    }

    @Override
    public String toString() {
        return this.name + " " + this.x + " " + this.y;
    }
}
