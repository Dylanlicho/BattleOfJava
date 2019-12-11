package sample.model.board;


public class ConcreteTile extends Tile {

    /**
     * The constructore of a concrete tile
     * @param posX the position in X
     * @param posY the position in Y
     */
    public ConcreteTile(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public Tile clone() {
        Tile t = new ConcreteTile(x, y);
        return t;
    }
}
