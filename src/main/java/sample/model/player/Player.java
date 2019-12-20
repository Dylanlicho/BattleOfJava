package sample.model.player;


import sample.model.BattleOfJava;

import java.io.Serializable;

/**
 * The class of the player
 */
public abstract class Player  implements Serializable {

    int num;
    protected String type;
    protected boolean win;

    public Player(int num){
        this.num = num;
        setWin(false);
    }

    /**
     * The player win the game
     */
    public void win() {
        setWin(true);
    }

    public int shoot(BattleOfJava battle, int x, int y){
        return battle.shoot(this, x, y);
    }

    public int getNum() {
        return num;
    }

    public String getType() {
        return type;
    }

    public boolean asWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}
