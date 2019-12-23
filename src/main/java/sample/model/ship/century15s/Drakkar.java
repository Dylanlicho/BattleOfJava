package sample.model.ship.century15s;

import sample.model.ship.Ship;
import sample.model.ship.ShipList;

public class Drakkar extends Ship {
    /**
     * Constructor of the Ship
     *
     * @param hp          Health point of the ship
     * @param x           Abscissa
     * @param y           Ordinate
     * @param orientation Orientation of the ship
     */
    public Drakkar(int hp, int x, int y, int orientation) {
        super(hp, x, y,  Century15SFactory.WIDTHDRAKKAR, Century15SFactory.HEIGHTDRAKKAR,
                orientation, ShipList.drakkar+"");
    }

}
