package sample.model.board;




import sample.model.factory.GameFactory;

import java.util.ArrayList;
import java.util.List;

public class Board {

    //The list of the Tile which composed the board
    private List<Tile> tiles;

    /**
     * The constroctor of the Board
     * @param initY the initial Y
     */
    public Board(int initY) {

        this.tiles = new ArrayList<Tile>();
        Tile t = new ConcreteTile(0, 0);
//        Tile t = new ConcreteTile(world,0, 0);
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

}
