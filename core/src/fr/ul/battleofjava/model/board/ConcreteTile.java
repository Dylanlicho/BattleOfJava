package fr.ul.battleofjava.model.board;

import com.badlogic.gdx.physics.box2d.World;

public class ConcreteTile extends Tile {


    public ConcreteTile(World world, int posX, int posY) {
        super(world, posX, posY);
    }

    @Override
    public Tile clone() {
        Tile t = new ConcreteTile(w, x, y);
        return t;
    }
}
