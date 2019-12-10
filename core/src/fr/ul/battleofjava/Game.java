package fr.ul.battleofjava;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import fr.ul.battleofjava.model.BattleOfJava;
import fr.ul.battleofjava.model.board.Tile;
import fr.ul.battleofjava.view.ViewBattle;

/**
 * The class of the game
 */
public class Game extends com.badlogic.gdx.Game {

	//The battle of java
	private BattleOfJava boj;

	@Override
	public void create() {
		boj = new BattleOfJava();
		setScreen(new ViewBattle(this));
	}

	/**
	 * @return the battle of java
	 */
	public BattleOfJava getBattleOfJava() {
		return boj;
	}

	/**
	 * @return the world
	 */
	public World getWorld() {
		return this.boj.getWorld();
	}

	/**
	 * @param b a body
	 * @return the tile corresponding to the body
	 */
	public Tile getTileByBody(Body b) {
		return this.boj.getTileByBody(b);
	}


}
