package sample.model.board;

import sample.model.ship.AgeFactory;
import sample.model.factory.GameFactory;
import sample.model.ship.Ship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Board implements Serializable {

    //The list of the Tile which composed the board
    private List<Tile> tiles;
    //The list of the ships
    private List<Ship> shipsPlayer;
    private int nbShipSunk;

    /**
     * Constructor of the Board
     */
    public Board() {
        this.nbShipSunk = 0;
        this.tiles = new ArrayList<>();
        Tile t = new ConcreteTile(0, 0);
        this.tiles.add(t);
        for (int i = 0 ; i < GameFactory.NBTILE - 1 ; i++) {
            this.tiles.add(t.clone());
        }
        int x = 0;
        int y = 0;
        for (int i = 0 ; i < GameFactory.NBTILE ; i++) {
            this.tiles.get(i).setPosition(x, y);
            x ++;
            if (x >= GameFactory.NBTILE / GameFactory.BOARDSIZE) {
                x = 0;
                y ++;
            }
        }

        this.shipsPlayer = new ArrayList<>(GameFactory.NBSHIP);

    }

    /**
     * Set the age of the board
     * @param age age to set
     */
    public void setAge(int age){
        shipsPlayer = AgeFactory.createNewShip(age);
    }

    /**
     * A player shoots a tile of the board
     * @param x x-axes
     * @param y y-axes
     */
    public int shoot(int x, int y) {
        if (x >= 0 && y >= 0 && x < GameFactory.BOARDSIZE && y < GameFactory.BOARDSIZE) {
            Tile t = getTile(x, y);
            if (t.isEmpty()) {    //the player never shot this tile
                Ship s = getShip(x, y);
                if (s != null) {  // the player hits a ship
                    s.damage();
                    if (s.isSunk())
                        sunkShip(s);
                    else t.setState(EnumState.HIT);
                } else    // the player hits nothing...
                    t.setState(EnumState.MISS);
                return t.getState().ordinal();
            } else
                return -1;
        }
        return -1;
    }

    /**
     * Sunk a ship
     * @param s the ship to sunk
     */
    private void sunkShip(Ship s) {
        for (int i = 0; i < s.getWidth(); i++) {
            for (int j = 0; j < s.getHeight(); j++) {
                Tile t = getTile(s.getX() + i, s.getY() + j);
                t.setState(EnumState.SUNK);
            }
        }
        nbShipSunk++;
    }

    /**
     * @return the number of ship sunk of the player
     */
    public int getNbShipSunk() {
        return nbShipSunk;
    }

    /**
     *Verify if all the fleet is sunk
     * @return true if all ships are sunk
     */
    public boolean isAllSunk() {
        boolean isAllSunk = getNbShipSunk() == GameFactory.NBSHIP;
        /*for(Ship s : shipsPlayer){
            if(!s.isSunk()){
                isAllSunk = false;
            }
        }*/
        return isAllSunk;
    }

    /**
     * get a Tile
     * @param x the position in x
     * @param y the position in y
     * @return the Tile in x, y
     */
    public Tile getTile(int x, int y) {
        boolean find = false;
        Tile tile = null;
        int i = 0;
        while (!find && i < GameFactory.NBTILE) {
            tile = tiles.get(i);
            if (x == tile.getX() && y == tile.getY()) {
                find = true;
            }
            i++;
        }
        if (find)  return tile;
        else return null;
    }

    /**
     * @param x the x position
     * @param y the y position
     * @return the ship in (x,y)
     */
    public Ship getShip(int x, int y) {
        boolean find = false;
        Ship ship = null;
        int i = 0;
        while (!find && i < GameFactory.NBSHIP && !this.shipsPlayer.isEmpty()) {
            ship = shipsPlayer.get(i);
            int xS = ship.getX();
            int yS = ship.getY();
            int w = ship.getWidth();
            int h = ship.getHeight();

            if (xS <= x && x <= xS + w - 1 && yS <= y && y <= yS + h - 1) {
                find = true;
            }
            i++;
        }
        if (find) return ship;
        else return null;
    }

    /**
     * @return the list of the ships
     */
    public List<Ship> getShips() {
        return shipsPlayer;
    }

    /**
     * check if one or several ships are superimposed
     * @return true if one or several ships are superimposed
     *         false if all the ship aren't superimposed
     */
    public boolean shipsSuperimposed() {
        boolean find = false;
        int i = 0, j;
        Ship currentShip;
        Ship s;
        while (i < getShips().size() && !find) {
            currentShip = getShips().get(i);
            j = i + 1;
            while(j < getShips().size() && !find) {
                s = getShips().get(j);
                if (superimposed(currentShip, s))
                    find = true;
                j++;
            }
            i++;
        }
        return find;
    }

    /**
     * check if two ships are superimposed
     * @param ship1 the first ship
     * @param ship2 the second ship
     * @return true is the ships are superimposed, false otherwise
     */
    private boolean superimposed(Ship ship1, Ship ship2) {
        int x1, y1, w1, h1, x2, y2, w2, h2;
        boolean superimposedX, superimposedY;
        x1 = ship1.getX();
        y1 = ship1.getY();
        x2 = ship2.getX();
        y2 = ship2.getY();
        w1 = ship1.getWidth() - 1;
        h1 = ship1.getHeight() - 1;
        w2 = ship2.getWidth() - 1;
        h2 = ship2.getHeight() - 1;

        superimposedX = x1 <= x2 && x2 <= x1 + w1; //the ship 2 begin on the ship 1 in x
        superimposedX = superimposedX || (x1 <= x2 + w2 && x2 + w2 <= x1 + w1); //the ship 2 finish on the ship 1 in x
        superimposedX = superimposedX || (x2 <= x1 && x1 <= x2 + w2); //the ship 1 begin on the ship 2 in x
        superimposedX = superimposedX || (x2 <= x1 + w1 && x1 + w1 <= x2 + w2); //the ship 1 finish on the ship 2 in x

        superimposedY = y2 <= y1 && y1 <= y2 + h2; //the ship 2 begin on the ship 1 in y
        superimposedY = superimposedY || (y2 <= y1 + h1 && y1 + h1 <= y2 + h2); //the ship 2 finish on the ship 1 in y
        superimposedY = superimposedY || (y1 <= y2 && y2 <= y1 + h1); //the ship 1 begin on the ship 2 in y
        superimposedY = superimposedY || (y1 <= y2 + h2 && y2 + h2 <= y1 + h1); //the ship 1 finish on the ship 2 in y

        return superimposedX && superimposedY;
    }
}
