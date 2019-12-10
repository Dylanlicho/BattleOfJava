package fr.ul.battleofjava.model.board;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import fr.ul.battleofjava.model.factory.GameFactory;

import java.util.ArrayList;
import java.util.List;

public class Board {

    //The list of the Tile which composed the board
    private List<Tile> tiles;


    /**
     * The constroctor of the Board
     * @param world the world
     * @param initY the initial Y
     */
    public Board(World world, int initY) {

        this.tiles = new ArrayList<Tile>();
        Tile t = new ConcreteTile(world,0, 0);
        this.tiles.add(t);
        for (int i = 0 ; i < 99 ; i++) {
            this.tiles.add(t.clone());
        }
        int x = GameFactory.TILEWIDTH + ((int) GameFactory.WORLDWIDTH / 5);
        int y = initY;
        for (int i = 0 ; i < 100 ; i++) {
            this.tiles.get(i).setPosition(x, y);
            x += GameFactory.TILEWIDTH;
            if (x >= GameFactory.TILEWIDTH * 11 + ((int)GameFactory.WORLDWIDTH / 5)) {
                x = GameFactory.TILEWIDTH + ((int)GameFactory.WORLDWIDTH / 5);
                y += GameFactory.TILEWIDTH;
            }
        }
        if (initY == GameFactory.MARGIN) {
            for (Tile ti : this.tiles) {

                ti.constructBody();

            }
        }

    }


    /**
     * @param b a body
     * @return the Tile corresponding to the body
     */
    public Tile getTileByBody(Body b) {
        for (Tile t: this.tiles) {
            if (t.getBody() == b) {
                return t;
            }
        }
        return null;
    }


    /**
     * Draw the board
     * @param sb the sprite batch
     */
    public void draw(SpriteBatch sb) {

        for (Tile t: this.tiles) {
            t.draw(sb);
        }

    }

}
