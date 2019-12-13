package sample.model.ship.century15s;

import sample.model.ship.Ship;

public class Caravelle extends Ship {
    /**
     * Constructor of the Ship
     *
     * @param hp          Health point of the ship
     * @param x           Absciss
     * @param y           Ordinate
     * @param orientation Orientation of the ship
     */
    public Caravelle(int hp, int x, int y, int orientation) {
        super(hp, x, y, Century15SFactory.WIDTHCARAVELLE, Century15SFactory.HEIGHTCARAVELLE, orientation,"caravelle");
    }

}
