package sample.view.menu;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.model.BattleOfJava;
import sample.model.factory.GameFactory;

import java.io.*;
import java.util.Observable;
import java.util.Observer;

public class ViewMenu implements Observer {

    //The battle of java
    private BattleOfJava battleOfJava;
    //The stage
    private Stage stage;
    //The stage of the view of the new game
    private Scene scene;


    /**
     * constructor of the menu
     * @param battleOfJava the battle of java
     * @param s the stage
     */
    public ViewMenu (BattleOfJava battleOfJava, Stage s, Scene scene) {
        setBattleOfJava(battleOfJava);
        setScene(scene);
        setStage(s);
        getBattleOfJava().addObserver(this);
    }


    /**
     * change la mélodie
     * @param battleOfJava une mélodie
     */
    private void setBattleOfJava(BattleOfJava battleOfJava) {
        this.battleOfJava = battleOfJava;
    }


    /**
     * @return la mélodie
     */
    private BattleOfJava getBattleOfJava() {
        return battleOfJava;
    }

    /**
     * @return la scène
     */
    private Stage getStage() {
        return stage;
    }


    /**
     * change la scène
     * @param s la nouvelle scène
     */
    private void setStage(Stage s) {
        stage = s;
    }


    /**
     * @return the stage of the view of the new game
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * set the stage of the new game
     * @param scene the stage
     */
    public void setScene(Scene scene) {
        this.scene = scene;
    }


    /**
     * exit the application
     */
    public void exit() {
        Platform.exit();
    }


    /**
     * save a game
     */
    public void save() {
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Enregistrer");
//        File f = fileChooser.showSaveDialog(getStage());
//        ObjectOutputStream flot;
//        try {
//            flot = new ObjectOutputStream(
//                    new FileOutputStream(f));
//            flot.writeObject(getBattleOfJava());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        ObjectOutputStream flot;// On ouvre un filtre
        FileChooser fileChooser = new FileChooser();// Nous permet de choisir un fichier
        fileChooser.setTitle("Save");
        File file = fileChooser.showSaveDialog(stage);// On prend le fichier choisit
        if (file != null) {
            try {
                flot = new ObjectOutputStream(new FileOutputStream(file));
                flot.writeObject(getBattleOfJava());// On écrit tous ce qui est dans la classe principale dans le fichier
                System.out.println("save");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }


    /**
     * load a game
     */
    public void load() {
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Open a file");
//        File f = fileChooser.showOpenDialog(getStage());
//
//        ObjectInputStream flot;
//        try {
//            flot = new ObjectInputStream(
//                    new FileInputStream(f));
//            getBattleOfJava().ouvrirMelodie((BattleOfJava)(flot.readObject()));
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        FileChooser fileChooser = new FileChooser();// Pour choisir le fichier à ouvrir
        fileChooser.setTitle("Ouvrir");
        File file = fileChooser.showOpenDialog(stage);// On prend le fichier à ouvrir
        ObjectInputStream flot;// Filtre
        if(file != null){
            try {
                flot = new ObjectInputStream(new FileInputStream(file));
                BattleOfJava b = (BattleOfJava) (flot.readObject());// On lit le contenu du flot
                battleOfJava.setBattleOfJava(b);// On construit la classe principale
                System.out.println("load a game");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * create a new game
     */
    public void newGame() {
//        getStage().close();
//        g().show();
        getStage().setScene(getScene());
    }


    /**
     * change the tatcic of fire to random tactic
     */
    public void tacticRandom()  {
        getBattleOfJava().setTactic(GameFactory.TACTICRANDOM);
    }


    /**
     * change the tatcic of fire to cross tactic
     */
    public void tacticCross () {
        getBattleOfJava().setTactic(GameFactory.TACTICCROSS);
    }


    @Override
    public void update(Observable o, Object arg) {
        BattleOfJava b = (BattleOfJava) o;
        setBattleOfJava(b);
    }
}
