package sample.model.board;

import sample.model.factory.EnumState;

public abstract class Tile implements Cloneable {

    //The position in X of the Tile
    protected int x;
    //The position in Y of the Tile
    protected int y;
    // The state of the tile
    protected EnumState state;


    /**
     * Constructor of a Tile
     * @param posX the position in X
     * @param posY the position in Y
     */
    public Tile(int posX, int posY) {
        this.x = posX;
        this.y = posY;
    }


    /**
     * Set the position of the tile
     * @param x the position in X
     * @param y the position in Y
     */
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the position in x of the tile into the board
     */
    public int getX() {
        return x;
    }

    /**
     * @return the position in y of the tile into the board
     */
    public int getY() {
        return y;
    }

    /**
     * True if the case hasn't be clicked, false else
     * @return True if the case hasn't be clicked, false else
     */
    public boolean isEmpty(){
        return this.state == EnumState.EMPTY;
    }

    /**
     * Set the state of the tile
     * @param state State of the tile
     */
    public void setState(EnumState state){
        this.state = state;
    }

    /**
     * @return the state of the tile
     */
    public EnumState getState() {
        return state;
    }

    /**
     * Clone the tile
     * @return a clone of the tile
     */
    public abstract Tile clone();

}
