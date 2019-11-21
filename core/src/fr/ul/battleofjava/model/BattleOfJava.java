package fr.ul.battleofjava.model;

import fr.ul.battleofjava.model.board.Board;
import fr.ul.battleofjava.model.player.Player;
import fr.ul.battleofjava.model.ship.Ship;

import java.io.File;

public class BattleOfJava {

    //The first player
    private Player J1;
    //The second player
    private Player J2;
    //The board of the player 1
    private Board boardJ1;
    //The board of the player 2
    private Board boardJ2;

    /**
     * The constructor of the class BattleOfJava 
     */
    public BattleOfJava() {

    }

    /**
     * Start a new game
     * @param playerAmount the number of human player
     */
    public void startNewGame(int playerAmount) {}

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
    public void shoot(Player currentPlayer, float x, float y) {}

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

    

}
