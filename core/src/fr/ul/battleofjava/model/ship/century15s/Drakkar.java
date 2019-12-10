package fr.ul.battleofjava.model.ship.century15s;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import fr.ul.battleofjava.model.factory.Century15SFactory;
import fr.ul.battleofjava.model.factory.TextureFactory;
import fr.ul.battleofjava.model.ship.Ship;

public class Drakkar extends Ship {
    /**
     * Constructor of the Ship
     *
     * @param hp          Health point of the ship
     * @param x           Absciss
     * @param y           Ordinate
     * @param orientation Orientation of the ship
     */
    public Drakkar(int hp, int x, int y, int orientation) {
        super(hp, x, y, 1, Century15SFactory.WIDTHDRAKKAR, orientation,"drakkar");
    }

}
