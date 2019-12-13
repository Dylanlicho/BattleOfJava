package sample.model.player;


/**
 * The class of the player
 */
public abstract class Player  {

    int num;

    public Player(int num){
        this.num = num;
    }

    /**
     * The player win the game
     */
    public void win() {

    }

    public int getNum() {
        return num;
    }
}
