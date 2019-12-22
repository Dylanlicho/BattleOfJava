//package sample.model.factory;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.Texture;
//
//import java.util.HashMap;
//
//public class TextureFactory {
//
//
//    private static final Texture tile = new Texture("tiletest.png");
//    private static final Texture tileClicked = new Texture("check.png");
//
//    private static final Texture caravelle = new Texture("ship/century15s/caravelle.png");
//    private static final Texture drakkar = new Texture("ship/century15s/drakkar.png");
//    private static final Texture flette = new Texture("ship/century15s/flette.png");
//    private static final Texture sailboat = new Texture("ship/century15s/sailboat.png");
//
//
//    private static TextureFactory instance = new TextureFactory();
//
//    private static HashMap<String, Texture> images;
//
//    private TextureFactory() {
//        images = new HashMap<String, Texture>();
//        images.put("tile", tile);
//        images.put("check", tileClicked);
//        images.put("caravelle",caravelle);
//        images.put("drakkar",drakkar);
//        images.put("flette",flette);
//        images.put("sailboat",sailboat);
//    }
//
//
//    public static TextureFactory getInstance() {
//        return instance;
//    }
//
//    public Texture getTile() {
//        return tile;
//    }
//
//    public Texture getTileClicked() {
//        return tileClicked;
//    }
//
//    public Texture getImage(String imageName) {
//        return images.get(imageName);
//    }
//
//
//}
