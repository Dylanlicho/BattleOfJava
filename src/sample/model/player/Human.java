package sample.model.player;

import sample.model.BattleOfJava;
import sample.model.factory.GameFactory;

/**
 * The class of the Human player
 */
public class Human extends Player {

    public Human(int num) {
        super(num);
        type = GameFactory.HUMANTYPE;
    }

}
