package sample.model.fireTactics;


import sample.model.BattleOfJava;
import sample.model.player.Player;

/**
 * The interface of the tactic fire
 */
public interface FireTactics {

     //The shoot of the player
     void shoot(BattleOfJava battle, Player p);
}
