package sample.model.factory;



public class GameFactory {

    // Orientation
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    public static final int BOTTOM = 3;

    // Age
    public static final int CENTURY15S = 15;
    public static final int CENTURY20S = 20;

    // Tactics
    public static final int TACTICRANDOM = 0;
    public static final int TACTICCROSS = 1;

    // Number of player playing
    public static final int NBPLAYER1 = 1;
    public static final int NBPLAYER2 = 2;

    // World size
    public static final float WORLDWIDTH = 600f;
    public static final float WORLDHEIGHT = 800f;
    public static final int MARGIN = 40;

    public static final int TILEWIDTH = 30;

    public static final int BOARDSIZE = 10;
    public static final int NBTILE = 100;

    public static final int NBSHIP = 7;

    // Sprite of the ship use
    public static final String SPRITESHIP = "images/drakkar.png";
    public static final String SPRITESUNK = "images/cruiser.png";


    public static final String HUMANTYPE = "human";
    public static final String AITYPE = "ai";

}
