package sample.model.ship.century20s;

import sample.model.factory.Century20SFactory;
import sample.model.ship.Ship;

public class Cruiser extends Ship {
    /**
     * Constructor of the Ship
     *
     * @param hp          Health point of the ship
     * @param x           Absciss
     * @param y           Ordinate
     * @param orientation Orientation of the shi
     */
    public Cruiser(int hp, int x, int y, int orientation) {
        super(hp, x, y, 1, Century20SFactory.WIDTHCRUISER, orientation, "cruiser");
    }
}
