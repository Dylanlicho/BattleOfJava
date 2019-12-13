package sample.model.board;

import sample.model.factory.AgeFactory;
import sample.model.factory.GameFactory;
import sample.model.ship.Ship;

import java.util.ArrayList;
import java.util.List;

public class Board {

    //The list of the Tile which composed the board
    private List<Tile> tiles;
    private List<Ship> shipsPlayer;

    /**
     * Constructor of the Board
     * @param initY the initial Y
     */
    public Board(int initY) {
        this.tiles = new ArrayList<>();
        Tile t = new ConcreteTile(0, 0);
        this.tiles.add(t);
        for (int i = 0 ; i < GameFactory.NBTILE - 1 ; i++) {
            this.tiles.add(t.clone());
        }
        int x = GameFactory.TILEWIDTH + ((int) GameFactory.WORLDWIDTH / 5);
        int y = initY;
        for (int i = 0 ; i < GameFactory.NBTILE ; i++) {
            this.tiles.get(i).setPosition(x, y);
            x += GameFactory.TILEWIDTH;
            if (x >= GameFactory.TILEWIDTH * 11 + ((int)GameFactory.WORLDWIDTH / 5)) {
                x = GameFactory.TILEWIDTH + ((int)GameFactory.WORLDWIDTH / 5);
                y += GameFactory.TILEWIDTH;
            }
        }

        this.shipsPlayer = new ArrayList<>(7);

    }

    public void setAge(int age){
        shipsPlayer = AgeFactory.createNewShip(age);
    }

    /**
     * A player shoots a tile of the board
     * @param x x-axes
     * @param y y-axes
     */
    public void shoot(int x, int y) {
        Tile t = getTile(x, y);
        if(t.isEmpty()){    //the player never shot this tile
            Ship s = getShip(x, y);
            if(s != null){  // the player hits a ship
                s.damage();
                t.setState(EnumState.HIT);
            }
            else{           // the player hits nothing...
                t.setState(EnumState.MISS);
            }
        }
        else{
            System.out.println("Vous avez déjà tiré ici, voici une nouvelle chance !");
        }

    }

    /**
     *Verify if all the fleet is sunk
     * @return true if all ships are sunk
     */
    public boolean isAllSunk() {
        boolean isAllSunk = true;
        for(Ship s : shipsPlayer){
            if(!s.isSunk()){
                isAllSunk = false;
            }
        }
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
        if (find) return tile;
        else return null;
    }

    public Ship getShip(int x, int y) {
        return null;
    }

}
