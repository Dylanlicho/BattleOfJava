package sample.model;


import sample.model.board.Board;
import sample.model.board.Tile;
import sample.model.factory.GameFactory;
import sample.model.player.Player;
import sample.model.ship.Ship;

import java.io.File;
import java.util.Observable;

public class BattleOfJava extends Observable {


    //The first player
    private Player j1;
    //The second player
    private Player j2;
    //The board of the player 1
    private Board boardJ1;
    //The board of the player 2
    private Board boardJ2;

    /**
     * The constructor of the class BattleOfJava
     */
    public BattleOfJava() {
        startNewGame(1);
    }

    /**
     * Start a new game
     * @param playerAmount the number of human player
     */
    public void startNewGame(int playerAmount) {
        boardJ1 = new Board(GameFactory.MARGIN);
        boardJ2 = new Board((int)GameFactory.WORLDHEIGHT - 10 * GameFactory.TILEWIDTH - GameFactory.MARGIN);
    }

    /**
     * Set the age of the game
     * @param age the age
     */
    public void setAge(int age) {}

    /**
     * Set the position of a ship
     * @param p the player who will move a ship
     * @param s the ship which is moved
     * @param x the new X position
     * @param y the new Y position
     */
    public void setPosition(Player p, Ship s, int x, int y) {}

    /**
     * The player shoot
     * @param currentPlayer the player who shoot
     * @param x the position of the shoot in abscissa
     * @param y the position of the shoot in ordinate
     */
    public void shoot(Player currentPlayer, int x, int y) {
        if(currentPlayer == j1){
            boardJ2.shoot(x, y);
            if(boardJ2.isAllSunk()){
                currentPlayer.win();
            }
        }
        else {  // currentPlayer == j2
            boardJ1.shoot(x, y);
            if(boardJ1.isAllSunk()){
                currentPlayer.win();
            }
        }
    }

    /**
     * load a game
     */
    public void load() { }

    /**
     * load a file
     * @param file the name of the file
     */
    public void loadFile(File file) { }

    /**
     * save the game
     */
    public void save() {}


    public Tile getTileBoardJ1(int x, int y) {
        return boardJ1.getTile(x, y);
    }

    public Tile getTileBoardJ2(int x, int y) {
        return boardJ2.getTile(x,y);
    }

}
