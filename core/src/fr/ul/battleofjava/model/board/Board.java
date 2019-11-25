package fr.ul.battleofjava.model.board;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;
import java.util.List;

import static fr.ul.battleofjava.model.BattleOfJava.WORLDWIDTH;

public class Board {

    public static final int TILEWIDTH = 30;

    List<Tile> tiles;

    public Board(World world, int initY) {

        this.tiles = new ArrayList<Tile>();
        Tile t = new ConcreteTile(world,0, 0);
        this.tiles.add(t);
        for (int i = 0 ; i < 99 ; i++) {
            this.tiles.add(t.clone());
        }
        int x = TILEWIDTH + ((int)WORLDWIDTH / 5);
        int y = initY;
        for (int i = 0 ; i < 100 ; i++) {
            this.tiles.get(i).setPosition(x, y);
            x += TILEWIDTH;
            if (x >= TILEWIDTH * 11 + ((int)WORLDWIDTH / 5)) {
                x = TILEWIDTH + ((int)WORLDWIDTH / 5);
                y += TILEWIDTH;
            }
        }
        for (Tile ti: this.tiles) {

            ti.constructBody();

        }

    }



    public void draw(SpriteBatch sb) {

        for (Tile t: this.tiles) {
            t.draw(sb);
        }

    }

}
