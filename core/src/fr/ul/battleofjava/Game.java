package fr.ul.battleofjava;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import fr.ul.battleofjava.model.BattleOfJava;

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
		//img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.4f, 0.85f, 0.85f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
