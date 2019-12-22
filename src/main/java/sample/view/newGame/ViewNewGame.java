package sample.view.newGame;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.model.BattleOfJava;
import sample.model.factory.GameFactory;

import java.util.Observable;
import java.util.Observer;

public class ViewNewGame implements Observer {



    private BattleOfJava battleOfJava;
    private Stage stage;
    private Scene scene;
    private int century;
    private int tactic;

    private String styleBorder = "-fx-border-color: red; -fx-border-width: 2px;";

    @FXML
    private VBox box;
    @FXML
    private HBox centuries;
    @FXML
    private HBox tactics;
    @FXML
    private Button start;
    @FXML
    private Button century15;
    @FXML
    private Button century20;
    @FXML
    private Button random;
    @FXML
    private Button cross;
    @FXML
    private Label title;

    public ViewNewGame(BattleOfJava battleOfJava, Stage stage, Scene scene) {
        setBattleOfJava(battleOfJava);
        setStage(stage);
        setScene(scene);
        getBattleOfJava().addObserver(this);

        century = GameFactory.CENTURY15S;
        tactic = GameFactory.TACTICRANDOM;
    }

    public void initialize() {
        getBox().setAlignment(Pos.CENTER);
        getCenturies().setAlignment(Pos.CENTER);
        getTactics().setAlignment(Pos.CENTER);
        getStart().setAlignment(Pos.CENTER);
        getCentury15().setAlignment(Pos.CENTER);
        getCentury20().setAlignment(Pos.CENTER);
        getRandom().setAlignment(Pos.CENTER);
        getCross().setAlignment(Pos.CENTER);
        getTitle().setAlignment(Pos.TOP_CENTER);

        getCentury15().setStyle(styleBorder);
        getRandom().setStyle(styleBorder);
    }


    public void century15Click() {
        getCentury20().setStyle("");
        getCentury15().setStyle(styleBorder);
        century = GameFactory.CENTURY15S;
    }

    public void century20Click() {
        getCentury20().setStyle(styleBorder);
        getCentury15().setStyle("");
        century = GameFactory.CENTURY20S;
    }

    public void randomClick() {
        getCross().setStyle("");
        getRandom().setStyle(styleBorder);
        tactic = GameFactory.TACTICRANDOM;
    }

    public void crossClick() {
        getCross().setStyle(styleBorder);
        getRandom().setStyle("");
        tactic = GameFactory.TACTICCROSS;
    }

    public void startClick() {
        getStage().setScene(getScene());
        getBattleOfJava().startNewGame(century, tactic);
    }


    public BattleOfJava getBattleOfJava() {
        return battleOfJava;
    }

    public void setBattleOfJava(BattleOfJava battleOfJava) {
        this.battleOfJava = battleOfJava;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stageBoards) {
        this.stage = stageBoards;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public VBox getBox() {
        return box;
    }

    public HBox getCenturies() {
        return centuries;
    }

    public HBox getTactics() {
        return tactics;
    }

    public Button getStart() {
        return start;
    }

    public Button getCentury15() {
        return century15;
    }

    public Button getCentury20() {
        return century20;
    }

    public Button getRandom() {
        return random;
    }

    public Button getCross() {
        return cross;
    }

    public Label getTitle() {
        return title;
    }

    @Override
    public void update(Observable o, Object arg) {
        BattleOfJava battle = (BattleOfJava)o;
        setBattleOfJava(battle);
    }
}
