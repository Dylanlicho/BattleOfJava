package sample.view.menu;

import javafx.application.Platform;
import javafx.stage.Stage;
import sample.model.BattleOfJava;

import java.util.Observable;
import java.util.Observer;

public class ViewMenu implements Observer {

    //The battle of java
    private BattleOfJava battleOfJava;
    //The stage
    private Stage stage;


    /**
     * constructor of the menu
     * @param battleOfJava the battle of java
     * @param s the stage
     */
    public ViewMenu (BattleOfJava battleOfJava, Stage s) {
        setBattleOfJava(battleOfJava);
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
        System.out.println("new game");
    }


    /**
     * change the tatcic of fire to random tactic
     */
    public void tacticRandom()  {
        System.out.println("change tactic random");
    }


    /**
     * change the tatcic of fire to cross tactic
     */
    public void tacticCross () {
        System.out.println("change tactic cross");
    }


    @Override
    public void update(Observable o, Object arg) {
        BattleOfJava b = (BattleOfJava) o;
        setBattleOfJava(b);
    }
}
