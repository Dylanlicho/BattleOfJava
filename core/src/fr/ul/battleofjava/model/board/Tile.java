package fr.ul.battleofjava.model.board;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;
import fr.ul.battleofjava.model.factory.TextureFactory;

import static fr.ul.battleofjava.model.BattleOfJava.*;

public abstract class Tile implements Cloneable {

    protected int x;
    protected int y;
    protected boolean isClicked;
    protected World w;
    protected BodyDef bodyDef;
    protected FixtureDef fixtureDef;
    protected PolygonShape shape;
    protected Body body;

    public Tile(World world, int posX, int posY) {
        this.x = posX;
        this.y = posY;
        this.w = world;
        this.isClicked = false;
    }

    protected void constructBody() {
        this.bodyDef = new BodyDef();
        this.fixtureDef = new FixtureDef();
        this.shape = new PolygonShape();
        this.bodyDef.type = BodyDef.BodyType.StaticBody;
        this.fixtureDef.isSensor = true;
        float vertices[] = new float[8];
        vertices[0] = x * UMWIDTH;
        vertices[1] = y * UMHEIGHT;
        vertices[2] = (x+Board.TILEWIDTH) * UMWIDTH;
        vertices[3] = y * UMHEIGHT;
        vertices[4] = (x+Board.TILEWIDTH) * UMWIDTH;
        vertices[5] = (y+Board.TILEWIDTH) * UMHEIGHT;
        vertices[6] = x * UMWIDTH;
        vertices[7] = (y+Board.TILEWIDTH) * UMHEIGHT;
        this.shape.set(vertices);
        this.fixtureDef.shape = this.shape;
        this.body = w.createBody(this.bodyDef);
        this.body.createFixture(this.fixtureDef);
        this.shape.dispose();
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setIsClicked() {
        this.isClicked = true;
    }

    public Body getBody() {
        return this.body;
    }

    public void draw(SpriteBatch sb) {

        sb.draw(TextureFactory.getInstance().getTile(), x * UMWIDTH, y * UMHEIGHT, Board.TILEWIDTH * UMWIDTH, Board.TILEWIDTH * UMHEIGHT);
        if (this.isClicked) {
            sb.draw(TextureFactory.getInstance().getTileClicked(), x * UMWIDTH, y * UMHEIGHT, Board.TILEWIDTH * UMWIDTH, Board.TILEWIDTH * UMHEIGHT);
        }
    }

    public abstract Tile clone();

}
