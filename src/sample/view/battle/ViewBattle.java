package sample.view.battle;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import sample.model.BattleOfJava;
import sample.model.board.Tile;
import sample.model.board.EnumState;
import sample.model.factory.GameFactory;


import java.util.Observable;
import java.util.Observer;

/**
 * The view of the battle (the two boards)
 */
public class ViewBattle implements Observer {

    //The game
    private BattleOfJava battleOfJava;

    //The board of the player 1
    @FXML
    private GridPane boardJ1;

    //The board of the player 2
    @FXML
    private GridPane boardJ2;

    /**
     * The constructor of the view
     * @param battleOfJava the game
     */
    public ViewBattle(BattleOfJava battleOfJava) {
        setBattleOfJava(battleOfJava);
        getBattleOfJava().addObserver(this);
    }

    /**
     * Initialisation of the boards
     */
    public void initialize() {
        int size = GameFactory.BOARDSIZE;

        initialiseBoard(boardJ1);
        initialiseBoard(boardJ2);

        for (int i = 0 ; i < size ; i++) {
            for (int j = 0; j < size; j++) {
                addPaneJ1(i, j);
            }
        }

        for (int i = 0 ; i < size ; i++) {
            for (int j = 0; j < size; j++) {
                addPaneJ2(i, j);
            }
        }
    }

    /**
     * Initialisation of a board
     * @param grid the board to initialise
     */
    private void initialiseBoard(GridPane grid) {
        int size = GameFactory.BOARDSIZE;

        for (int i = 0; i < size; i++) {
            ColumnConstraints colConstraints = new ColumnConstraints();
            colConstraints.setHgrow(Priority.SOMETIMES);
            colConstraints.setPrefWidth(30.0);
            colConstraints.setMaxWidth(30.0);
            grid.getColumnConstraints().add(colConstraints);
        }

        for (int i = 0 ; i < size ; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setVgrow(Priority.SOMETIMES);
            rowConstraints.setPrefHeight(30.0);
            rowConstraints.setMaxHeight(30.0);
            grid.getRowConstraints().add(rowConstraints);
        }
    }

    /**
     * add Panel to the board of the player 1, for this player,
     * we can't click on the cells
     * @param colIndex the column of the cell into add the panel
     * @param rowIndex the row of the cell into add the panel
     */
    private void addPaneJ1(int colIndex, int rowIndex) {
        Pane pane = new Pane();
        Tile tile = battleOfJava.getTileBoardJ1(colIndex, rowIndex);
        if (tile != null) {
            if (tile.getState() == EnumState.HIT) {
                Image image = new Image("images/hit.png");
                pane.getChildren().add(new ImageView(image));
            } else if (tile.getState() == EnumState.MISS) {
                Image image = new Image("images/miss.png");
                pane.getChildren().add(new ImageView(image));
            }
        }
        boardJ1.add(pane, colIndex, rowIndex);
    }

    /**
     * add Panel to the board of the player 2, for this player,
     * we can click on the cell
     * @param colIndex the column of the cell into add the panel
     * @param rowIndex the row of the cell into add the panel
     */
    private void addPaneJ2(int colIndex, int rowIndex) {
        Pane pane = new Pane();
        pane.setOnMouseClicked(e -> {
            boardJ2Click(colIndex, rowIndex);
        });
        Tile tile = battleOfJava.getTileBoardJ2(colIndex, rowIndex);
        if (tile != null) {
            if (tile.getState() == EnumState.HIT) {
                Image image = new Image("images/hit.png");
                pane.getChildren().add(new ImageView(image));
            } else if (tile.getState() == EnumState.MISS) {
                Image image = new Image("images/miss.png");
                pane.getChildren().add(new ImageView(image));
            }
        }
        boardJ2.add(pane, colIndex, rowIndex);
    }

    /**
     * click on the cell
     * @param col the column of the cell
     * @param row the row of the cell
     */
    private void boardJ2Click(int col, int row) {

    }

    /**
     * set the game (battle of java)
     * @param battleOfJava the new battle of java
     */
    private void setBattleOfJava(BattleOfJava battleOfJava) {
        this.battleOfJava = battleOfJava;
    }

    /**
     * getteur of the battle of java
     * @return the battle of java
     */
    private BattleOfJava getBattleOfJava() {
        return battleOfJava;
    }

    @Override
    public void update(Observable o, Object arg) {
        setBattleOfJava((BattleOfJava)o);
    }
}
