package sample.model;


import sample.model.board.Board;
import sample.model.board.EnumState;
import sample.model.board.Tile;
import sample.model.factory.GameFactory;
import sample.model.player.AI;
import sample.model.player.Human;
import sample.model.player.Player;
import sample.model.ship.Ship;

import java.io.File;
import java.util.Observable;

public class BattleOfJava extends Observable {


    //The first player
    private Player j1;
    //The second player
    private Player j2;
    //The current player
    private Player currentPlayer;
    //The board of the player 1
    private Board boardJ1;
    //The board of the player 2
    private Board boardJ2;
    // Age of the ship
    private int age;
    //The game is start
    private boolean start;



    /**
     * The constructor of the class BattleOfJava
     */
    public BattleOfJava() {
        j1 = new Human(1);
        j2 = new AI(2);
        startNewGame(1,GameFactory.TACTICRANDOM);
        ////////////////// Pour les tests ///////////////////
         currentPlayer = j1; ////////////////////////////////
        //////Avouez c'est beau et vous êtes jaloux/////////
        setAge(GameFactory.CENTURY15S);
    }

    public Board getBoard(Player player) {
        if(player.getNum() == 1) {
            return boardJ1;
        }else{
            return boardJ2;
        }
    }


    /**
     * start a new game
     * @param century the century
     * @param IAtactic the tactic of the AI
     */
    public void startNewGame(int century, int IAtactic) {
        boardJ1 = new Board();
        boardJ2 = new Board();
        setAge(century);
        setTactic(IAtactic);
        setStart(false);

        setChanged();
        notifyObservers();
    }

    /**
     * start the game (the ships are placed)
     */
    public void start(Player p) {
        p.setReadyToPlay(true);
        if (getJ1().isReadyToPlay() && getJ2().isReadyToPlay()) {
            setStart(true);
        }

        setChanged();
        notifyObservers();
    }

    public void setTactic(int IAtactic) {
        if (j1.getType().equals(GameFactory.AITYPE)) ((AI)j1).setTactic(IAtactic);
        if (j2.getType().equals(GameFactory.AITYPE)) ((AI)j2).setTactic(IAtactic);
    }

    /**
     * Set the age of the game
     * @param age the age
     */
    public void setAge(int age) {
        this.age = age;
        boardJ1.setAge(age);
        boardJ2.setAge(age);
        boardJ1.setAge(age);
        boardJ2.setAge(age);
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    /**
     * Set the position of a ship only if the position is on the board
     * @param p the player who will move a ship
     * @param s the ship which is moved
     * @param x the new X position
     * @param y the new Y position
     */
    public void setPosition(Player p, Ship s, int x, int y) {
        if (x >= 0 && x + s.getWidth() < GameFactory.BOARDSIZE - 1 && y >= 0 && y + s.getHeigth() < GameFactory.BOARDSIZE - 1)
            s.setPosition(x,y);

        setChanged();
        notifyObservers();
    }

    /**
     * The player shoot
     * @param x the position of the shoot in abscissa
     * @param y the position of the shoot in ordinate
     */
    public void shoot(Player p, int x, int y) {
        if (currentPlayer == p) {
            if (p == j1) {
                int res = boardJ2.shoot(x, y);
                if (boardJ2.isAllSunk()) {
                    currentPlayer.win();
                }
                if (res >= 0 && res != EnumState.HIT.ordinal())  {
                    setCurrentPlayer(j2);
                }
            } else {  // currentPlayer == j2
                int res = boardJ1.shoot(x, y);
                if (boardJ1.isAllSunk()) {
                    currentPlayer.win();
                }
                if (res >= 0 && res != EnumState.HIT.ordinal())  {
                    setCurrentPlayer(j1);
                }
            }
        }
        setChanged();
        notifyObservers();
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

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getJ1() {
        return j1;
    }

    public Player getJ2() {
        return j2;
    }
}
