package sample.model.fireTactics;


import sample.model.BattleOfJava;
import sample.model.factory.GameFactory;
import sample.model.player.Player;

import java.io.Serializable;
import java.util.Random;

/**
 * The class of the fire tactic cross
 */
public class TacticCross implements FireTactics, Serializable {

    private boolean[][] tilesShot;
    private Random random;
    private int shotInitCrossX;
    private int shotInitCrossY;
    private boolean[] cross;

    private static final int CROSSLEFT = 0;
    private static final int CROSSUP = 1;
    private static final int CROSSRIGHT = 2;
    private static final int CROSSDOWN = 3;

    public TacticCross() {
        this.tilesShot = new boolean[GameFactory.BOARDSIZE][GameFactory.BOARDSIZE];
        this.random = new Random();
        for (int i = 0 ; i < GameFactory.BOARDSIZE ; i++) {
            for (int j = 0 ; j < GameFactory.BOARDSIZE ; j++) {
                tilesShot[i][j] = false;
            }
        }
        this.shotInitCrossX = -1;
        this.shotInitCrossY = -1;
        this.cross = new boolean[4];
        for (int i = 0 ; i < 4 ; i++) {
            this.cross[i] = false;
        }
    }

    @Override
    public void shoot(BattleOfJava battle, Player p) {
        int x;
        int y;
        if (this.shotInitCrossX < 0 || this.shotInitCrossY < 0) {
            do {
                x = random.nextInt(GameFactory.BOARDSIZE);
                y = random.nextInt(GameFactory.BOARDSIZE);
            } while (tilesShot[x][y]);
            this.shotInitCrossX = x;
            this.shotInitCrossY = y;
            if (x - 1 < 0) {
                cross[CROSSLEFT] = true;
            }
            if (y - 1 < 0) {
                cross[CROSSUP] = true;
            }
            if (x + 1 >= GameFactory.BOARDSIZE) {
                cross[CROSSRIGHT] = true;
            }
            if (y + 1 >= GameFactory.BOARDSIZE) {
                cross[CROSSDOWN] = true;
            }
            if (!cross[CROSSLEFT] && tilesShot[shotInitCrossX - 1][shotInitCrossY]) {
                cross[CROSSLEFT] = true;
            }
            if (!cross[CROSSUP] && tilesShot[shotInitCrossX][shotInitCrossY - 1]) {
                cross[CROSSUP] = true;
            }
            if (!cross[CROSSRIGHT] && tilesShot[shotInitCrossX + 1][shotInitCrossY]) {
                cross[CROSSRIGHT] = true;
            }
            if (!cross[CROSSDOWN] && tilesShot[shotInitCrossX][shotInitCrossY + 1]) {
                cross[CROSSDOWN] = true;
            }
            int checker = 0;
            for (int i = 0 ; i < 4 ; i++) {
                if (cross[i]) {
                    checker += 1;
                }
            }
            if (checker >= 4) {
                this.shotInitCrossY = -1;
                this.shotInitCrossX = -1;
                for (int i = 0; i < 4; i++) {
                    cross[i] = false;
                }
            }
        }
        else {
            int direction = 0;
            while (cross[direction]) {
                direction += 1;
            }
            switch (direction) {
                case CROSSLEFT:
                    x = this.shotInitCrossX - 1;
                    y = this.shotInitCrossY;
                    break;
                case CROSSUP:
                    x = this.shotInitCrossX;
                    y = this.shotInitCrossY - 1;
                    break;
                case CROSSRIGHT:
                    x = this.shotInitCrossX + 1;
                    y = this.shotInitCrossY;
                    break;
                case CROSSDOWN:
                    x = this.shotInitCrossX;
                    y = this.shotInitCrossY + 1;
                    break;
                default:
                    x = this.shotInitCrossX;
                    y = this.shotInitCrossY;
                    break;
            }
            cross[direction] = true;
        }
        int checker = 0;
        for (int i = 0 ; i < 4 ; i++) {
            if (cross[i]) {
                checker += 1;
            }
        }
        if (checker >= 4) {
            this.shotInitCrossY = -1;
            this.shotInitCrossX = -1;
            for (int i = 0; i < 4; i++) {
                cross[i] = false;
            }
        }
        tilesShot[x][y] = true;
        p.shoot(battle,x,y);
    }
}
