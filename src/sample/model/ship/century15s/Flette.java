package sample.model.ship.century15s;

import sample.model.factory.Century15SFactory;
import sample.model.ship.Ship;

public class Flette extends Ship {

    /**
     * Constructor of the Ship
     *
     * @param hp          Health point of the ship
     * @param x           Absciss
     * @param y           Ordinate
     * @param orientation Orientation of the ship
     */
    public Flette(int hp, int x, int y, int orientation) {
        super(hp, x, y, 1, Century15SFactory.WIDTHFLETTE, orientation,"flette");
    }


}
