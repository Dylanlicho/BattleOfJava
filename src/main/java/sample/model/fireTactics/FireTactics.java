package sample.model.fireTactics;


import sample.model.BattleOfJava;
import sample.model.player.Player;

/**
 * The interface of the tactic fire
 */
public interface FireTactics {

     void shoot(BattleOfJava battle, Player p);
}
