package sample.model.player;


import sample.model.BattleOfJava;

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

    public abstract void shoot(BattleOfJava battle, int x, int y);

    public int getNum() {
        return num;
    }
}
