package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.model.BattleOfJava;
import sample.view.boards.ViewBoards;
import sample.view.menu.ViewMenu;
import sample.view.newGame.ViewNewGame;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Stage stageNewGame = new Stage();

        VBox root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));

        BattleOfJava battle = new BattleOfJava();

        //load du menu
        FXMLLoader loaderVueMenu = new FXMLLoader();
        loaderVueMenu.setLocation(getClass().getResource("/fxml/menu/viewMenu.fxml"));
        loaderVueMenu.setControllerFactory(iC->new ViewMenu(battle, primaryStage, stageNewGame));
        Node viewMenu = loaderVueMenu.load();

        //load of the boards view
        FXMLLoader loaderBattle = new FXMLLoader();
        loaderBattle.setLocation(getClass().getResource("/fxml/boards/viewBoards.fxml"));
        loaderBattle.setControllerFactory(iC->new ViewBoards(battle));
        Node viewBattle = loaderBattle.load();

        root.getChildren().addAll(viewMenu, viewBattle);
//        primaryStage.setTitle("Battle Of Java");
//        primaryStage.setScene(new Scene(root, 600, 800));

        //load of the boards view
        FXMLLoader loaderNewGame = new FXMLLoader();
        loaderNewGame.setLocation(getClass().getResource("/fxml/newGame/viewNewGame.fxml"));
        loaderNewGame.setControllerFactory(iC->new ViewNewGame(battle, primaryStage, stageNewGame));
        AnchorPane viewNewGame = loaderNewGame.load();

        Scene sceneNewGame = new Scene(viewNewGame, 600, 800);
        Scene sceneBattle = new Scene(root, 600, 800);
        vm.setScene(sceneNewGame);
        vng.setScene(sceneBattle);

        primaryStage.setTitle("Battle Of Java");
        primaryStage.setScene(sceneNewGame);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
