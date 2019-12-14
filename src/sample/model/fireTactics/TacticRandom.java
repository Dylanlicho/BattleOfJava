package sample.model.fireTactics;


import sample.model.BattleOfJava;
import sample.model.factory.GameFactory;
import sample.model.player.Player;

import java.util.Random;

/**
 * The class of the fire tactic random
 */
public class TacticRandom implements FireTactics {

    private boolean[][] tilesShot;
    private Random random;

    public TacticRandom() {
        this.tilesShot = new boolean[GameFactory.BOARDSIZE][GameFactory.BOARDSIZE];
        this.random = new Random();
        for (int i = 0 ; i < GameFactory.BOARDSIZE ; i++) {
            for (int j = 0 ; j < GameFactory.BOARDSIZE ; j++) {
                tilesShot[i][j] = false;
            }
        }
    }


    @Override
    public void shoot(BattleOfJava battle, Player p) {
        int x;
        int y;
        do {
            x = random.nextInt(GameFactory.BOARDSIZE);
            y = random.nextInt(GameFactory.BOARDSIZE);
        } while (tilesShot[x][y]);
        System.out.println("AI shoot on "+x+";"+y+" with random tactic");
        tilesShot[x][y] = true;
        p.shoot(battle,x,y);
    }

}
