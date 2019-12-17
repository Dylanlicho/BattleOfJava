package sample.model.player;


import sample.model.BattleOfJava;
import sample.model.factory.GameFactory;
import sample.model.fireTactics.FireTactics;
import sample.model.fireTactics.TacticCross;
import sample.model.fireTactics.TacticRandom;

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

}
