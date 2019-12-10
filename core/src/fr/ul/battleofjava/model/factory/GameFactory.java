package fr.ul.battleofjava.model.factory;

import com.badlogic.gdx.Gdx;

public class GameFactory {

    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    public static final int BOTTOM = 3;

    public static final int CENTURY15S = 15;
    public static final int CENTURY20S = 20;



    public static final float WORLDWIDTH = 600f;
    public static final float WORLDHEIGHT = 800f;
    public static final float WINDOWWIDTH = Gdx.graphics.getWidth();
    public static final float WINDOWHEIGHT = Gdx.graphics.getHeight();
    public static final float UMWIDTH = WINDOWWIDTH / WORLDWIDTH;
    public static final float UMHEIGHT = WINDOWHEIGHT / WORLDHEIGHT;
    public static final int MARGIN = 40;

    public static final int TILEWIDTH = 30;

}
