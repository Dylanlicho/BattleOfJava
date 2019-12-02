package fr.ul.battleofjava.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import fr.ul.battleofjava.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 800;
		config.height = 1000;
		config.resizable = false;
		config.vSyncEnabled = true;
		new LwjglApplication(new Game(), config);
	}
}
