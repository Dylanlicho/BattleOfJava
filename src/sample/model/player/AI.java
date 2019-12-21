package sample.model.player;


import sample.model.BattleOfJava;
import sample.model.board.Board;
import sample.model.factory.GameFactory;
import sample.model.fireTactics.FireTactics;
import sample.model.fireTactics.TacticCross;
import sample.model.fireTactics.TacticRandom;
import sample.model.ship.Ship;

import java.util.List;
import java.util.Random;

import java.io.Serializable;

/**
 * The class of the AI player
 */
public class AI extends Player implements Serializable {



    //The fire tactic of the AI
    private FireTactics tactic;

    public AI(int num) {
        super(num);
        type = GameFactory.AITYPE;
    }

    public void setTactic(int tactic) {
        switch (tactic) {
            case GameFactory.TACTICRANDOM:
                setFireTactic(new TacticRandom());
                break;
            case GameFactory.TACTICCROSS:
                setFireTactic(new TacticCross());
                break;
            default:
                break;
        }
    }

    public void shoot(BattleOfJava battle) {
        tactic.shoot(battle, this);
    }

    /**
     * set the fire tactic of the AI
     * @param tactic the new tactic
     */
    public void setFireTactic (FireTactics tactic) {
        this.tactic = tactic;
    }


    /**
     * The getter of the tactic of the AI
     * @return the tactic
     */
    public FireTactics getFireTactic () {
        return tactic;
    }

    /**
     * placement of the ships
     * @param b the boad of the player
     */
    public void placeShips(Board b) {
        Random r = new Random();
        boolean finish = false;
        int x, y;
        for (Ship s : b.getShips()) {
            while (!finish ) {
                x = r.nextInt(GameFactory.BOARDSIZE);
                y = r.nextInt(GameFactory.BOARDSIZE);
                if (x >= 0 && x + s.getWidth() - 1 < GameFactory.BOARDSIZE && y >= 0 && y + s.getHeigth() - 1 < GameFactory.BOARDSIZE) {
                    s.setPosition(x, y);
                    if (!b.shipsSuperimposed())
                        finish = true;
                }
            }
            finish = false;
        }
    }

}
