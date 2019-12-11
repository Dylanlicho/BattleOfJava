package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.model.BattleOfJava;
import sample.view.battle.ViewBattle;
import sample.view.menu.ViewMenu;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox root = FXMLLoader.load(getClass().getResource("view/sample.fxml"));

        BattleOfJava battle = new BattleOfJava();

        //load du menu
        FXMLLoader loaderVueMenu = new FXMLLoader();
        loaderVueMenu.setLocation(getClass().getResource("view/menu/viewMenu.fxml"));
        loaderVueMenu.setControllerFactory(iC->new ViewMenu(battle, primaryStage));
        Node viewMenu = loaderVueMenu.load();

        //load of the boards view
        FXMLLoader loaderBattle = new FXMLLoader();
        loaderBattle.setLocation(getClass().getResource("view/battle/viewBattle.fxml"));
        loaderBattle.setControllerFactory(iC->new ViewBattle(battle));
        Node viewBattle = loaderBattle.load();

        root.getChildren().addAll(viewMenu, viewBattle);

        primaryStage.setTitle("Battle Of Java");
        primaryStage.setScene(new Scene(root, 600, 800));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
