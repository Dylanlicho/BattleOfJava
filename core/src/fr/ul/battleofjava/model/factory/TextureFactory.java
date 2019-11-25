package fr.ul.battleofjava.model.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureFactory {

    private static TextureFactory instance = new TextureFactory();

    public static TextureFactory getInstance() {
        return instance;
    }

    private static final String relativePath = "";
    private static Texture tile = new Texture(Gdx.files.internal(relativePath + "tiletest.png"));

    public Texture getTile() {
        return tile;
    }

}
