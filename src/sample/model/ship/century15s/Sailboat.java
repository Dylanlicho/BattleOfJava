package sample.model.ship.century15s;

import sample.model.ship.Ship;

public class Sailboat extends Ship {


    /**
     * Constructor of the Ship
     *
     * @param hp          Health point of the ship
     * @param x           Absciss
     * @param y           Ordinate
     * @param orientation Orientation of the ship
     */
    public Sailboat(int hp, int x, int y, int orientation) {
        super(hp, x, y,  Century15SFactory.WIDTHSAILBOAT, Century15SFactory.HEIGHTSAILBOAT, orientation,"sailboat");
    }

}
