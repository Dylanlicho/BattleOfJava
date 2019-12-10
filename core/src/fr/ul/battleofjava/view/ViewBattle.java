package fr.ul.battleofjava.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import fr.ul.battleofjava.Game;
import fr.ul.battleofjava.listeners.GameListener;
import fr.ul.battleofjava.model.BattleOfJava;
import fr.ul.battleofjava.model.factory.GameFactory;

public class ViewBattle extends ScreenAdapter {

    private Game game;
    private SpriteBatch batch;
    private OrthographicCamera camera;

    public ViewBattle (Game game) {
        this.game = game;
        batch = new SpriteBatch();
        this.camera = new OrthographicCamera();
        camera.viewportWidth = GameFactory.WINDOWWIDTH;
        camera.viewportHeight = GameFactory.WINDOWHEIGHT;
        camera.position.set(GameFactory.WINDOWWIDTH / 2f, GameFactory.WINDOWHEIGHT / 2f, 0);
        Gdx.input.setInputProcessor(new GameListener(camera, game));
        //img = new Texture("badlogic.jpg");

        game.getBattleOfJava().startNewGame(2);
    }

    public void render (float delta) {
        Gdx.gl.glClearColor(0.4f, 0.85f, 0.85f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        batch.begin();

        game.getBattleOfJava().draw(batch);

        batch.end();
        batch.begin();
        Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();
        debugRenderer.render(game.getBattleOfJava().getWorld(), camera.combined);
        batch.end();
    }

    public void dispose () {
        batch.dispose();
        //img.dispose();
    }

}
