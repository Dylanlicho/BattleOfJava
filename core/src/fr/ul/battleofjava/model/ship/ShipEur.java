package fr.ul.battleofjava.model.ship;

public class ShipEur extends Ship{


    /**
     * Constructor of the Ship
     *
     * @param hp          Health point of the ship
     * @param x           Absciss
     * @param y           Ordinate
     * @param width       Width of the ship
     * @param heigth      Height of the ship
     * @param orientation Orientation of the ship
     */
    public ShipEur(int hp, int x, int y, int width, int heigth, int orientation) {
        super(1, 2, 2, 1, 4, orientation);
    }
}
