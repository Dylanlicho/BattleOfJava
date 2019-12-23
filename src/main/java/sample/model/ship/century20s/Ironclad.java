package sample.model.ship.century20s;


import sample.model.ship.Ship;
import sample.model.ship.ShipList;

public class Ironclad extends Ship {

    /**
     * Constructor of the Ship
     *
     * @param hp          Health point of the ship
     * @param x           Abscissa
     * @param y           Ordinate
     * @param orientation Orientation of the ship
     */
    public Ironclad(int hp, int x, int y, int orientation) {
        super(hp, x, y, Century20SFactory.WIDTHIRONCLAD, Century20SFactory.HEIGHTIRONCLAD,
                orientation, ShipList.ironclad+"");
    }
}
