import org.junit.jupiter.api.Test;
import sample.model.board.Board;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BoardTests {

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


}
