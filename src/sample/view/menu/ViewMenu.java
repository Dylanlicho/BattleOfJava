package sample.view.menu;

import javafx.application.Platform;
import javafx.stage.Stage;
import sample.model.BattleOfJava;
import sample.model.factory.GameFactory;

import java.util.Observable;
import java.util.Observer;

public class ViewMenu implements Observer {

    //The battle of java
    private BattleOfJava battleOfJava;
    //The stage
    private Stage stage;
    //The stage of the view of the new game
    private Stage stageNewGame;


    /**
     * constructor of the menu
     * @param battleOfJava the battle of java
     * @param s the stage
     */
    public ViewMenu (BattleOfJava battleOfJava, Stage s, Stage stageNewGame) {
        setBattleOfJava(battleOfJava);
        setStageNewGame(stageNewGame);
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
    public Stage getStageNewGame() {
        return stageNewGame;
    }

    /**
     * set the stage of the new game
     * @param stageNewGame the stage
     */
    public void setStageNewGame(Stage stageNewGame) {
        this.stageNewGame = stageNewGame;
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
        System.out.println("save");
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

        System.out.println("load a game");
    }


    /**
     * create a new game
     */
    public void newGame() {
        getStage().close();
        getStageNewGame().show();
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
