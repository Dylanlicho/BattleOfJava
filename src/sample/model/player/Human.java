package sample.model.player;

import sample.model.BattleOfJava;

/**
 * The class of the Human player
 */
public class Human extends Player {

    public Human(int num) {
        super(num);
    }

    @Override
    public void shoot(BattleOfJava battle, int x, int y){
        battle.shoot(this, x, y);
    }
}
