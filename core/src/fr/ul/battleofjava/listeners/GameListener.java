package fr.ul.battleofjava.listeners;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.QueryCallback;
import fr.ul.battleofjava.Game;
import fr.ul.battleofjava.model.board.Tile;

import java.util.ArrayList;
import java.util.List;

public class GameListener implements InputProcessor {

    protected final List<Body> bodyList;
    private OrthographicCamera camera;
    private Game game;

    public GameListener(OrthographicCamera c, Game g) {
        this.bodyList = new ArrayList<Body>();
        this.camera = c;
        this.game = g;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button == Input.Buttons.LEFT) {
            performAction(screenX, screenY);
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
    
    private void performAction(int X, int Y) {

        this.bodyList.clear();
        Vector3 coords = new Vector3(X, Y, 0);
        this.camera.unproject(coords);
        game.getWorld().QueryAABB(queryCallback(), coords.x - 0.0001f, coords.y - 0.0001f, coords.x + 0.0001f, coords.y + 0.0001f);
        Tile tile = null;
        for (Body b: this.bodyList) {
            if (tile == null) {
                tile = this.game.getTileByBody(b);
                if (tile != null && !tile.isEmpty()) {
                    tile.setIsClicked();
                }
            }
        }
    }

    private QueryCallback queryCallback() {
        QueryCallback query = new QueryCallback() {

            @Override
            public boolean reportFixture(Fixture fixture) {
                bodyList.add(fixture.getBody());
                return true;

            }
        };
        return query;
    }

}
