package fr.ul.battleofjava.model.ship;

public abstract class Ship {

    private int hp;
    private int x;
    private int y;
    private int width;
    private int heigth;
    private int orientation;

    /**
     * Constructor of the Ship
     * @param hp Health point of the ship
     * @param x  Absciss
     * @param y Ordinate
     * @param width Width of the ship
     * @param heigth Height of the ship
     * @param orientation Orientation of the ship
     */
    public Ship(int hp, int x, int y, int width, int heigth, int orientation){
        this.hp = hp;
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
        this.orientation = orientation;
    }

    /**
     * Return true if the HP of the ship is under zero, False else
     * @return true if the HP of the ship is under zero, False else
     */
    public boolean isSunk(){
        return hp<=0;
    }

    /**
     * The ship take damage
     */
    public void damage(){
        hp = hp - 1;
    }

    /**
     * Set the position of the ship
     * @param x absissa
     * @param y ordinate
     */
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

}
