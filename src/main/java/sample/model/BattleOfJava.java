package sample.model;


import sample.model.board.Board;
import sample.model.board.EnumState;
import sample.model.board.Tile;
import sample.model.factory.GameFactory;
import sample.model.player.AI;
import sample.model.player.Human;
import sample.model.player.Player;
import sample.model.ship.Ship;
import sample.rmi.server.Instructions;

import java.io.File;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.*;
import java.util.Observable;

public class BattleOfJava extends Observable implements Serializable, Instructions, Intermediary{


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
    //The game is start
    private boolean start;


    /**
     * The constructor of the class BattleOfJava
     */
    public BattleOfJava() {
        j1 = new Human(1);
        j2 = new AI(2);
        startNewGame(1,GameFactory.TACTICRANDOM);
        currentPlayer = j1;
        setAge(GameFactory.CENTURY15S);
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
        getJ1().setReadyToPlay(false);
        getJ2().setReadyToPlay(false);

        this.j1.setWin(false);
        this.j2.setWin(false);
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

    /**
     * set the tactic of the IA
     * @param IAtactic the num of the tactic
     */
    public void setTactic(int IAtactic) {
        if (j1.getType().equals(GameFactory.AITYPE)) ((AI)j1).setTactic(IAtactic);
        if (j2.getType().equals(GameFactory.AITYPE)) ((AI)j2).setTactic(IAtactic);
    }

    /**
     * Set the age of the game
     * @param age the age
     */
    public void setAge(int age) {
        // Age of the ship
        boardJ1.setAge(age);
        boardJ2.setAge(age);
    }

    /**
     * Set the position of a ship only if the position is on the board
     * @param s the ship which is moved
     * @param x the new X position
     * @param y the new Y position
     */
    public void setPosition(Ship s, int x, int y) {
        if (x >= 0 && x + s.getWidth() - 1 < GameFactory.BOARDSIZE && y >= 0 && y + s.getHeight() - 1 < GameFactory.BOARDSIZE)
            s.setPosition(x,y);

        setChanged();
        notifyObservers();
    }

    /**
     * The player shoot
     * @param x the position of the shoot in abscissa
     * @param y the position of the shoot in ordinate
     */
    public int shoot(Player p, int x, int y) {
        int res = -1;
        if (currentPlayer == p) {
            if (p == j1) {
                res = boardJ2.shoot(x, y);
                if (boardJ2.isAllSunk()) {
                    currentPlayer.win();
                }
                if (res >= 0 && !(res == EnumState.HIT.ordinal() || res == EnumState.SUNK.ordinal()))  {
                    setCurrentPlayer(j2);
                }
            } else {  // currentPlayer == j2
                res = boardJ1.shoot(x, y);
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
        return res;
    }

    /**
     * load a file
     * @param file the name of the file
     */
    public void loadFile(File file) {
        ObjectInputStream flot;// Filter
        if(file != null){
            try {
                flot = new ObjectInputStream(new FileInputStream(file));
                BattleOfJava b = (BattleOfJava) (flot.readObject());// On lit le contenu du flot
                this.setBattleOfJava(b);// On construit la classe principale
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * save the game
     * @param file the file where save the game
     */
    public void save(File file) {
        ObjectOutputStream flot;// Opening of the flot

        if (file != null) {
            try {
                flot = new ObjectOutputStream(new FileOutputStream(file));
                flot.writeObject(this);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public Board getBoard(Player player) {
        if(player.getNum() == 1) {
            return boardJ1;
        }else{
            return boardJ2;
        }
    }

    /**
     * @return The number of ship sunk of the player 2 with the help of RMI
     */
    public int getNbShipSunkJ2RMI(){
        try {
            Registry registry = LocateRegistry.getRegistry(GameFactory.RMIPORT);
            BattleOfJava battle = (BattleOfJava)registry.lookup("instructions");
            // By the point of view of the other player, he is the player 1,
            // so we look the ship sunk on the board of the player 1
            return battle.getNbShipSunkJ1();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @return The number of ship sunk of the player 1 with the help of RMI
     */
    public int getNbShipSunkJ1RMI(){
        try {
            Registry registry = LocateRegistry.getRegistry(GameFactory.RMIPORT);
            BattleOfJava battle = (BattleOfJava)registry.lookup("instructions");
            // By the point of view of the other player, he is the player 2,
            // so we look the ship sunk on the board of the player 2
            return battle.getNbShipSunkJ2();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @return Return the number of the ship sunk of the player 1
     */
    public int getNbShipSunkJ1(){
        return getBoard(j1).getNbShipSunk();
    }

    /**
     * @return Return the number of the ship sunk of the player 2
     */
    public int getNbShipSunkJ2(){
        return getBoard(j2).getNbShipSunk();
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

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

    public void setBattleOfJava(BattleOfJava battleOfJava) {
        j1 = battleOfJava.getJ1();
        j2 = battleOfJava.getJ2();
        currentPlayer = battleOfJava.getCurrentPlayer();
        boardJ1 = battleOfJava.getBoard(j1);
        boardJ2 = battleOfJava.getBoard(j2);
        start = battleOfJava.getStart();
        setChanged();
        notifyObservers();
    }

    private boolean getStart() {
        return start;
    }

    @Override
    public BattleOfJava getBattleOfJava() throws RemoteException {
        return this;
    }
}
