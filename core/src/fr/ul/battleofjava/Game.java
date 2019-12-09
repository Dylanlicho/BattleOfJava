package fr.ul.battleofjava;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import fr.ul.battleofjava.listeners.GameListener;
import fr.ul.battleofjava.model.BattleOfJava;
import fr.ul.battleofjava.model.board.Tile;

import static fr.ul.battleofjava.model.BattleOfJava.WINDOWHEIGHT;
import static fr.ul.battleofjava.model.BattleOfJava.WINDOWWIDTH;

public class Game extends ApplicationAdapter {

	private BattleOfJava boj;

	SpriteBatch batch;
	private OrthographicCamera camera;
	//Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		boj = new BattleOfJava();
		this.camera = new OrthographicCamera();
		camera.viewportWidth = WINDOWWIDTH;
		camera.viewportHeight = WINDOWHEIGHT;
		camera.position.set(WINDOWWIDTH / 2f, WINDOWHEIGHT / 2f, 0);
		Gdx.input.setInputProcessor(new GameListener(camera, this));
		//img = new Texture("badlogic.jpg");
	}

	public World getWorld() {
		return this.boj.getWorld();
	}

	public Tile getTileByBody(Body b) {
		return this.boj.getTileByBody(b);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.4f, 0.85f, 0.85f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.begin();

		boj.draw(batch);

		batch.end();
		batch.begin();
		Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();
		debugRenderer.render(boj.getWorld(), camera.combined);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
