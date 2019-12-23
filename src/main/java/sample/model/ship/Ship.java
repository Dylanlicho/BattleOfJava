package sample.model.ship;

import java.io.Serializable;

public abstract class Ship implements Serializable {

    protected int hp;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int orientation;
    protected String type;

    /**
     * Constructor of the Ship
     * @param hp Health point of the ship
     * @param x  Abscissa
     * @param y Ordinate
     * @param width Width of the ship
     * @param height Height of the ship
     * @param orientation Orientation of the ship
     */
    public Ship(int hp, int x, int y, int width, int height, int orientation, String type){
        this.hp = hp;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.orientation = orientation;
        this.type = type;
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
     * @param x abscissa
     * @param y ordinate
     */
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getOrientation() {
        return orientation;
    }
}
