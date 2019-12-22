package sample.view.boards;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import sample.model.BattleOfJava;
import sample.model.board.Board;
import sample.model.board.Tile;
import sample.model.board.EnumState;
import sample.model.factory.GameFactory;
import sample.model.player.*;
import sample.model.ship.Ship;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * The view of the battle (the two boards)
 */
public class ViewBoards implements Observer {

    private static final int SIZETUILE = 30;

    //The game
    private BattleOfJava battleOfJava;

    //The board of the player 1
    @FXML
    private GridPane grid1;
    @FXML
    private GridPane boardJ1;

    //The board of the player 2
    @FXML
    private GridPane grid2;
    @FXML
    private GridPane boardJ2;

    @FXML
    private Label text;

    // The pane to place ship
    @FXML
    private Pane paneShipJ1;
    @FXML
    private Pane paneShipJ2;

    private double startDragX;
    private double startDragY;

    @FXML
    private Button start; //The start button to validate the placement of the ships and begin the game

    /**
     * The constructor of the view
     * @param battleOfJava the game
     */
    public ViewBoards(BattleOfJava battleOfJava) {
        setBattleOfJava(battleOfJava);
        getBattleOfJava().addObserver(this);
    }

    /**
     * Initialisation of the boards
     */
    public void initialize() {
        initialiseBoard(grid1);
        initialiseBoard(grid2);
        initialiseShip();
        start.setAlignment(Pos.BOTTOM_CENTER);
        text.setStyle("-fx-font-size : 18px; -fx-font-weight: bold;");
    }

    /**
     * add panes to the grid
     */
    private void addPanes() {
        int size = GameFactory.BOARDSIZE;
        for (int i = 0 ; i < size ; i++) {
            for (int j = 0; j < size; j++) {
                addPaneJ1(i, j);
                addPaneJ2(i, j);
            }
        }
    }

    /**
     * initialization of the ships
     */
    public void initialiseShip(){
        initializeShipJ1();
        initializeShipJ2();
    }

    /**
     * initialization of the ships of the player 2
     */
    private void initializeShipJ1() {
        Board board = battleOfJava.getBoard(battleOfJava.getJ1());
        ArrayList<Ship> ships = (ArrayList<Ship>)board.getShips();
        for(Ship s: ships) {
            String nameImage;
            if (s.isSunk()) nameImage = "images/sunk_ship.png";
            else nameImage = GameFactory.SPRITESHIP;
            Image image = new Image(nameImage);
            ImageView imageView = new ImageView(image);
            imageView.setX(GameFactory.TILEWIDTH * s.getX());
            imageView.setY(GameFactory.TILEWIDTH * s.getY());

            imageView.setFitHeight(s.getHeigth()* GameFactory.TILEWIDTH);
            imageView.setFitWidth(s.getWidth()* GameFactory.TILEWIDTH);

            if(!getBattleOfJava().isStart()) setDragImage(s, imageView);

            this.paneShipJ1.getChildren().add(imageView);
        }
    }

    /**
     * Set the movement of the ships of the player 1
     * @param s the ship that is moved
     * @param imageView the imageView corresponding to the ship
     */
    private void setDragImage(Ship s, ImageView imageView) {
        imageView.setOnMousePressed(e-> {
            startDragX = e.getSceneX();
            startDragY = e.getSceneY();
        });

        imageView.setOnMouseDragged(e -> {
            double X = e.getSceneX();
            double dep = X - startDragX;
            if (dep > SIZETUILE && imageView.getX() + (s.getWidth()*SIZETUILE) < GameFactory.BOARDSIZE*SIZETUILE) {
                imageView.setX(imageView.getX()+SIZETUILE);
                startDragX = X;
            } else if (dep < -SIZETUILE && imageView.getX() >= SIZETUILE) {
                imageView.setX(imageView.getX()-SIZETUILE);
                startDragX = X;
            }

            double Y = e.getSceneY();
            dep = Y - startDragY;
            if (dep > SIZETUILE && imageView.getY() + (s.getHeigth()*SIZETUILE) < GameFactory.BOARDSIZE*SIZETUILE) {
                imageView.setY(imageView.getY() + SIZETUILE);
                startDragY = Y;
            } else if (dep < -SIZETUILE && imageView.getY() >= SIZETUILE) {
                imageView.setY(imageView.getY()-SIZETUILE);
                startDragY = Y;
            }
        });

        imageView.setOnMouseReleased(e -> battleOfJava.setPosition(battleOfJava.getJ1(), s, (int)imageView.getX()/SIZETUILE, (int)imageView.getY()/SIZETUILE));
    }

    /**
     * initialization of the ships of the player 2
     */
    private void initializeShipJ2() {
        Board board = battleOfJava.getBoard(battleOfJava.getJ2());
        ArrayList<Ship> ships = (ArrayList<Ship>)board.getShips();
        for(Ship s: ships) {
            if (s.isSunk()) {
                Image image = new Image("images/sunk_ship.png");
//                Image image = new Image("images/" + s.getType() + ".png");
                ImageView imageView = new ImageView(image);
                imageView.setX(GameFactory.TILEWIDTH * s.getX());
                imageView.setY(GameFactory.TILEWIDTH * s.getY());

                imageView.setFitHeight(s.getHeigth() * GameFactory.TILEWIDTH);
                imageView.setFitWidth(s.getWidth() * GameFactory.TILEWIDTH);

                this.paneShipJ2.getChildren().add(imageView);
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
        if (getBattleOfJava().isStart()) {
            Tile tile = getBattleOfJava().getTileBoardJ1(colIndex, rowIndex);
            printTile(pane, colIndex, rowIndex, getBoardJ1(), tile);
        }
        else getBoardJ1().add(pane, colIndex, rowIndex);
    }

    /**
     * add Panel to the board of the player 2, for this player,
     * we can click on the cell
     * @param colIndex the column of the cell into add the panel
     * @param rowIndex the row of the cell into add the panel
     */
    private void addPaneJ2(int colIndex, int rowIndex) {
        Pane pane = new Pane();
        pane.setOnMouseClicked(e -> boardJ2Click(colIndex, rowIndex));
        if (getBattleOfJava().isStart()) {
            Tile tile = getBattleOfJava().getTileBoardJ2(colIndex, rowIndex);
            printTile(pane, colIndex, rowIndex, getBoardJ2(), tile);
        }
        else getBoardJ2().add(pane, colIndex, rowIndex);
    }

    /**
     * print the state of a tile
     * @param pane the pane to print the state
     * @param colIndex the col of the tile
     * @param rowIndex the row of th tile
     * @param grid the grid of the current tile
     * @param tile the tile
     */
    private void printTile(Pane pane, int colIndex, int rowIndex, GridPane grid, Tile tile) {
        if (tile != null) {
            if (tile.getState().ordinal() == EnumState.HIT.ordinal()) {
                Image image = new Image("images/hit.png");
                pane.getChildren().add(new ImageView(image));
            } else if (tile.getState().ordinal() == EnumState.MISS.ordinal()) {
                Image image = new Image("images/miss.png");
                pane.getChildren().add(new ImageView(image));
            }
        }
        grid.add(pane, colIndex, rowIndex);
    }

    /**
     * click on the cell
     * @param col the column of the cell
     * @param row the row of the cell
     */
    private void boardJ2Click(int col, int row) {
        if (!getBattleOfJava().getCurrentPlayer().asWin()) {
            if (getBattleOfJava().getTileBoardJ2(col, row).getState() == EnumState.EMPTY) {
                getBattleOfJava().getCurrentPlayer().shoot(battleOfJava, col, row);
            }
        }
    }

    /**
     * the start button is clicked
     */
    public void startClick() {
        initialiseBoard(getBoardJ1());
        initialiseBoard(getBoardJ2());
        getBattleOfJava().start(getBattleOfJava().getJ1());
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

    /**
     * @return the board of the player 1
     */
    public GridPane getBoardJ1() {
        return boardJ1;
    }

    /**
     * @return  boardJ1 the board of the player 2
     */
    private GridPane getBoardJ2() {
        return boardJ2;
    }


    /**
     * update the boards
     */
    private void updateGrid() {
        getBoardJ1().getChildren().clear();
        getBoardJ2().getChildren().clear();

        addPanes();
    }

    /**
     * update the ships
     */
    private void updateShip() {
        paneShipJ1.getChildren().clear();
        paneShipJ2.getChildren().clear();
        initialiseShip();
    }

    /**
     * update the text
     */
    private void updateText() {
        Player current = getBattleOfJava().getCurrentPlayer();

        if (getBattleOfJava().getCurrentPlayer().getNum() == 1) {
            if (current.asWin())
                text.setText("you win !");
            else
                text.setText("It's your turn.");
        }
        if (getBattleOfJava().getCurrentPlayer().getNum() == 2) {
            if (current.asWin())
                text.setText("J2 win !");
            else
                text.setText("It's J2's turn.");
        }
    }

    /**
     * if is the turn of the turn of the IA, the IA shoot
     */
    private void checkAIShoot() {
        if (!getBattleOfJava().getCurrentPlayer().asWin()) {
            Player currentPlayer = getBattleOfJava().getCurrentPlayer();
            if (currentPlayer.getType().equals(GameFactory.AITYPE))
                ((AI) currentPlayer).shoot(getBattleOfJava());
        }
    }

    /**
     * update the placement of the ships
     */
    private void updatePlacementShip() {
        if (!getBattleOfJava().getJ1().isReadyToPlay()) {
            Board b = getBattleOfJava().getBoard(getBattleOfJava().getJ1()); //the board of the player 1
            if (b.shipsSuperimposed()) {
                text.setText("Ships shouldn't be superimposed.");
                start.setDisable(true);
            } else {
                text.setText("You can place your ships.");
                start.setDisable(false);
            }
        }
        if (!getBattleOfJava().getJ2().isReadyToPlay()){
            Player p = getBattleOfJava().getJ2();
            if (p.getType().equals(GameFactory.AITYPE)) {
                ((AI)p).placeShips(getBattleOfJava().getBoard(p));
                getBattleOfJava().start(p);
            }
        }
    }

    private void resetGrid(GridPane g) {
        g.getChildren().clear();
        g.getRowConstraints().remove(0, g.getRowConstraints().size());
        g.getColumnConstraints().remove(0, g.getColumnConstraints().size());
    }

    @Override
    public void update(Observable o, Object arg) {
        setBattleOfJava((BattleOfJava)o);
        if(battleOfJava.isStart()) {
            updateGrid();
            updateText();
            checkAIShoot();
            start.setVisible(false);
        }
        else {
            resetGrid(getBoardJ1());
            resetGrid(getBoardJ2());
            start.setVisible(true);
            updatePlacementShip();
        }
        updateShip();
    }
}
