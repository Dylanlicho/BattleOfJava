package sample.model.player;

import sample.model.BattleOfJava;
import sample.model.factory.GameFactory;

import java.io.Serializable;

/**
 * The class of the Human player
 */
public class Human extends Player implements Serializable {

    public Human(int num) {
        super(num);
        type = GameFactory.HUMANTYPE;
    }

}
