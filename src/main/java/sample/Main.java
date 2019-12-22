package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.model.BattleOfJava;
import sample.model.factory.GameFactory;
import sample.view.boards.ViewBoards;
import sample.view.menu.ViewMenu;
import sample.view.newGame.ViewNewGame;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main extends Application {

    private BattleOfJava battle;

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));

        battle = new BattleOfJava();
        setServer();

        //load du menu
        FXMLLoader loaderVueMenu = new FXMLLoader();
        loaderVueMenu.setLocation(getClass().getResource("/fxml/menu/viewMenu.fxml"));
        ViewMenu vm = new ViewMenu(battle, primaryStage, null);
        loaderVueMenu.setControllerFactory(iC->vm);
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
        ViewNewGame vng = new ViewNewGame(battle, primaryStage, null);
        loaderNewGame.setControllerFactory(iC->vng);
        AnchorPane viewNewGame = loaderNewGame.load();

        Scene sceneNewGame = new Scene(viewNewGame, 600, 800);
        Scene sceneBattle = new Scene(root, 600, 800);
        vm.setScene(sceneNewGame);
        vng.setScene(sceneBattle);

        primaryStage.setTitle("Battle Of Java");
        primaryStage.setScene(sceneNewGame);
        primaryStage.show();
    }

    public void setServer(){
        try {
            Registry registry = LocateRegistry.createRegistry(GameFactory.RMIPORT);
            registry.bind("instructions", battle);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
