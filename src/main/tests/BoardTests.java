import org.junit.jupiter.api.Test;
import sample.model.board.Board;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BoardTests {

    @Test
    void shootRegularShot() {
        Board b = new Board();
        int result = b.shoot(3, 2);
        assertNotEquals(-1, result);
    }

    @Test
    void shootNegativeCoordinates() {
        Board b = new Board();
        assertDoesNotThrow(() -> {
            b.shoot(-10, -10);
        });
    }

    @Test
    void shootTooBigCoordinates() {
        Board b = new Board();
        assertDoesNotThrow(() -> {
            b.shoot(10000000, 10000000);
        });
    }

    @Test
    void getTileNegativeCoordinates() {
        Board b = new Board();
        assertDoesNotThrow(() -> {
            b.getTile(-10, -10);
        });
    }

    @Test
    void getTileTooBigCoordinates() {
        Board b = new Board();
        assertDoesNotThrow(() -> {
            b.getTile(10000000, 10000000);
        });
    }

    @Test
    void getShipNegativeCoordinates() {
        Board b = new Board();
        assertDoesNotThrow(() -> {
            b.getShip(-10, -10);
        });
    }

    @Test
    void getShipTooBigCoordinates() {
        Board b = new Board();
        assertDoesNotThrow(() -> {
            b.getShip(10000000, 10000000);
        });
    }

}
