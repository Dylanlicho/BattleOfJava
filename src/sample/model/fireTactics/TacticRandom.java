package sample.model.fireTactics;


import sample.model.BattleOfJava;
import sample.model.factory.GameFactory;
import sample.model.player.Player;

/**
 * The class of the fire tactic random
 */
public class TacticRandom implements  FireTactics {

    //JUSTE POUR LES TESTS AVANT LES TACTICS DE L'IA
    private static int x = -1;
    private static int y = 0;

    @Override
    public void shoot(BattleOfJava battle, Player p) {
        x++;
        if (x >= GameFactory.BOARDSIZE) {
            x = 0;
            y++;
        }
        System.out.println("AI shoot on "+x+";"+y+" with random tactic");
        p.shoot(battle,x,y);
    }

}
