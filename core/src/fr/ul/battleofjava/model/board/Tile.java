package fr.ul.battleofjava.model.board;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;
import fr.ul.battleofjava.model.factory.GameFactory;
import fr.ul.battleofjava.model.factory.TextureFactory;

import static fr.ul.battleofjava.model.BattleOfJava.*;

public abstract class Tile implements Cloneable {

    //The position in X of the Tile
    protected int x;
    //The position in Y of the Tile
    protected int y;
    //True if the tile is alreadyClick
    protected boolean isClicked;
    //The world
    protected World w;
    //The body def
    protected BodyDef bodyDef;
    //the fixture def
    protected FixtureDef fixtureDef;
    //The polygon shape
    protected PolygonShape shape;
    //The body of the Tile
    protected Body body;


    /**
     * Constructor of a Tile
     * @param world the world
     * @param posX the position in X
     * @param posY the position in Y
     */
    public Tile(World world, int posX, int posY) {
        this.x = posX;
        this.y = posY;
        this.w = world;
        this.isClicked = false;
    }

    /**
     * The construction of the body of the tile
     */
    protected void constructBody() {
        this.bodyDef = new BodyDef();
        this.fixtureDef = new FixtureDef();
        this.shape = new PolygonShape();
        this.bodyDef.type = BodyDef.BodyType.StaticBody;
        this.fixtureDef.isSensor = true;
        float vertices[] = new float[8];
        vertices[0] = x * GameFactory.UMWIDTH;
        vertices[1] = y * GameFactory.UMHEIGHT;
        vertices[2] = (x+GameFactory.TILEWIDTH) * GameFactory.UMWIDTH;
        vertices[3] = y * GameFactory.UMHEIGHT;
        vertices[4] = (x+GameFactory.TILEWIDTH) * GameFactory.UMWIDTH;
        vertices[5] = (y+GameFactory.TILEWIDTH) * GameFactory.UMHEIGHT;
        vertices[6] = x * GameFactory.UMWIDTH;
        vertices[7] = (y+GameFactory.TILEWIDTH) * GameFactory.UMHEIGHT;
        this.shape.set(vertices);
        this.fixtureDef.shape = this.shape;
        this.body = w.createBody(this.bodyDef);
        this.body.createFixture(this.fixtureDef);
        this.shape.dispose();
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
     * Set the boolean isClicked to true
     */
    public void setIsClicked() {
        this.isClicked = true;
    }

    /**
     * @return the body of the tile
     */
    public Body getBody() {
        return this.body;
    }

    /**
     * Draw the tile
     * @param sb the sprite batch
     */
    public void draw(SpriteBatch sb) {

        sb.draw(TextureFactory.getInstance().getTile(), x * GameFactory.UMWIDTH, y * GameFactory.UMHEIGHT, GameFactory.TILEWIDTH * GameFactory.UMWIDTH, GameFactory.TILEWIDTH * GameFactory.UMHEIGHT);
        if (this.isClicked) {
            sb.draw(TextureFactory.getInstance().getTileClicked(), x * GameFactory.UMWIDTH, y * GameFactory.UMHEIGHT, GameFactory.TILEWIDTH * GameFactory.UMWIDTH,GameFactory.TILEWIDTH * GameFactory.UMHEIGHT);
        }
    }


    /**
     * Clone the tile
     * @return a clone of the tile
     */
    public abstract Tile clone();

}
