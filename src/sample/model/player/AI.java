package sample.model.player;


import sample.model.BattleOfJava;
import sample.model.fireTactics.FireTactics;

/**
 * The class of the AI player
 */
public class AI extends Player {

    //The fire tactic of the AI
    private FireTactics tactic;

    public AI(int num) {
        super(num);
    }

    @Override
    public void shoot(BattleOfJava battle, int x, int y) {
        System.out.println("shoot of AI");
        try {
            wait(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("AI have shoot");
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
