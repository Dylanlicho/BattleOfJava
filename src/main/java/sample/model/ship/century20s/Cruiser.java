package sample.model.ship.century20s;

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
        super(hp, x, y,  Century20SFactory.WIDTHCRUISER, Century20SFactory.HEIGHTCRUISER, orientation, "cruiser");
    }
}
